package net.boothhomeproductions.speeches;

import java.util.ArrayList;


public class SpeechGetter {
	
	private static final String SAVE_FILE_HERE_PATH = "C:\\Users\\randallbooth\\Music\\BYU_Speeches\\";

	public static void main(String[] args) throws Exception {
		ArrayList<Item> items = new ArrayList<Item>();
		items.addAll(new GetPage(1949, 1949).getPage());
		
		System.out.println("Items Found: " + items.size());
		
		for (Item i : items) {
			System.out.println(new DownloadFile().save(i, SAVE_FILE_HERE_PATH));
		}
	}
}
