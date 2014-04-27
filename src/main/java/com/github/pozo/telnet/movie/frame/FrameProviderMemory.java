package com.github.pozo.telnet.movie.frame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FrameProviderMemory implements FrameProvider {
	private ArrayList<Frame> frames = new ArrayList<Frame>();
	
	public FrameProviderMemory() {
		Frame frame = new Frame("test 1         \r\n    1 tset\n");
		
		frames.add(frame);
	}
	public List<Frame> getFrames() {
		return frames;
	}
	public Iterator<Frame> iterator() {
		return frames.iterator();
	}

}
