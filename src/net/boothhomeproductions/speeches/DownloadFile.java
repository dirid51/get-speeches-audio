package net.boothhomeproductions.speeches;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class DownloadFile {
	
	private SimpleDateFormat format = new SimpleDateFormat("ddMMMyyyy");

	public String save(Item item, String directoryPath) throws Exception {
		InputStream in = new BufferedInputStream(item.getLink().openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while ((n = in.read(buf)) != -1) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();

		String filePath = directoryPath + item.getSpeaker() + "-" + item.getTitle() + "-" + format.format(item.getDate());
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(response);
		fos.close();
		return filePath;
	}
}
