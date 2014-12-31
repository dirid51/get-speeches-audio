package net.boothhomeproductions.speeches;

import java.net.URL;
import java.util.Date;

public class Item {

	private URL link;
	private String title;
	private String speaker;
	private Date date;

	public URL getLink() {
		return link;
	}

	public void setLink(URL link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Item [link=" + link + ", title=" + title + ", speaker="
				+ speaker + ", date=" + date + "]";
	}

}
