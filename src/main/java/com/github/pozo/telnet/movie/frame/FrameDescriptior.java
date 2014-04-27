package com.github.pozo.telnet.movie.frame;

public class FrameDescriptior {
	private final int frameWidth;
	private final int frameHeight;
	
	public FrameDescriptior(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}


	public int getFrameWidth() {
		return frameWidth;
	}


	public int getFrameHeight() {
		return frameHeight;
	}
	
}
