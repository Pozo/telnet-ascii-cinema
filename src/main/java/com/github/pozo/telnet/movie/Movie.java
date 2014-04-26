package com.github.pozo.telnet.movie;

import java.io.IOException;

import com.github.pozo.telnet.movie.frame.Frame;
import com.github.pozo.telnet.movie.frame.FrameProvider;

public class Movie {
	private final FrameProvider frameProvider;
	private final Canvas canvas;
	
	private int framePerSec = 1;
	
	public int getFramePerSec() {
		return framePerSec;
	}

	public void setFrameRate(int framePerSec) {
		this.framePerSec = framePerSec;
	}

	public Movie(FrameProvider frameProvider, Canvas canvas) {
		this.frameProvider = frameProvider;
		this.canvas = canvas;
	}

	public void play() throws IOException, InterruptedException {
		for (Frame frame : this.frameProvider) {
			canvas.printFrame(frame);
			hang();
		}
	}
	private void hang() throws InterruptedException {
		Thread.sleep(1000/framePerSec);
	}
}