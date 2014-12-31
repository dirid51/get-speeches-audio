package net.boothhomeproductions.speeches;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GetPage {
	
	private int beginYear;
	private int endYear;
	
	public GetPage(int beginYear, int endYear) throws Exception {
		this.beginYear = beginYear;
		this.endYear = endYear;
		if (beginYear < 1900) {
			throw new Exception("Year must be greater than or equal to 1900.");
		} else if (beginYear > endYear) {
			throw new Exception("Begin year cannot be later than end year.");
		} else if (endYear > Calendar.getInstance().get(Calendar.YEAR)) {
			throw new Exception("End year cannot be in the future.");
		}
	}

	public List<Item> getPage() throws IOException, ParseException {
		ArrayList<Item> items = new ArrayList<Item>();

		for (int i = beginYear; i <= endYear; i += 1) {
			items.addAll((new GetData(i)).getData());
//			Runnable r1 = new GetData(i);
//			new Thread(r1).start();
//			Runnable r2 = new GetData(i + 1);
//			new Thread(r2).start();
//			Runnable r3 = new GetData(i + 2);
//			new Thread(r3).start();
//			Runnable r4 = new GetData(i + 3);
//			new Thread(r4).start();
		}

		return items;
	}
}
