package net.boothhomeproductions.speeches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetData {

	private static String SPEECHES_HOME_URL = "http://speeches.byu.edu/?act=sortByYear&ByYear=";
	
	private int year;
	
	public GetData(int year) {
		this.year = year;
	}

	public List<Item> getData() throws IOException, ParseException {
		DateFormat df = new SimpleDateFormat("MMMMM d, yyyy");
		URL url = new URL(SPEECHES_HOME_URL + Integer.toString(year));
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));

		String inputLine;
		StringBuilder result = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			result.append(inputLine);
		}
		in.close();

		ArrayList<Item> items = new ArrayList<Item>();
		Document doc = Jsoup.parse(result.toString());
		Elements links = doc.select("a[href^=index.php]");
		for (Element e : links) {
			Item i = new Item();
			Element parent = e.parent().parent().parent();
			Elements dataBits = new Elements(parent.select(".DINWeb-Light"));
			for (Element bit : dataBits) {
				if (bit.hasAttr("href")) {
					i.setTitle(bit.text());
				} else {
					i.setDate(df.parse(bit.text()));
				}
			}
			i.setLink(getMp3Link(new URL("http://speeches.byu.edu/" + e.attr("href"))));
			i.setSpeaker(parent.select(".DINWeb>div:eq(0)").text());
			items.add(i);
		}
		
		return items;
	}
	
	private URL getMp3Link(URL url) throws IOException {
		URL result = null;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.matches("http://speeches\\.byu\\.edu/download\\.php/.*\\.mp3\\?item=\\d+&amp;download=true")) {
				
			}
		}
		in.close();
		
		return result;
	}
}
