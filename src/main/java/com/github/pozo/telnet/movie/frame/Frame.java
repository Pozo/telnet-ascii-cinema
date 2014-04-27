package com.github.pozo.telnet.movie.frame;

public class Frame {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private String data;

	public Frame(String data) {
		this.data = data;
	}

	public byte[] getData() {
		String sanitizedData = sanitizeDataLineEnds();
		String cleanedData = appendDataCorrectLineEnd(sanitizedData);
		return cleanedData.getBytes();
	}

	private String sanitizeDataLineEnds() {
		String sanitizedData = data.replaceAll("\\r", "");
		sanitizedData = sanitizedData.replaceAll("\\n", "");
		return data;
	}

	private String appendDataCorrectLineEnd(String sanitizedData) {
		return String.format("%s%s", sanitizedData, LINE_SEPARATOR);
	}
	
	public void setRawData(String data) {
		this.data = data;
	}
	
}