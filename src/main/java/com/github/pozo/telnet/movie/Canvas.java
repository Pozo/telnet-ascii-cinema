package com.github.pozo.telnet.movie;

import java.io.IOException;
import java.io.OutputStream;

import com.github.pozo.telnet.movie.frame.Frame;

public class Canvas {
	// Some escape codes used within VT100 Streams
	// @see: http://ascii-table.com/ansi-escape-sequences-vt-100.php
	private static final byte[] JMPHOME = "\u001B[H".getBytes();
	private static final byte[] CLEARSCRN = "\u001B[2J".getBytes();
	private static final byte[] NEXTLINE = "\u001BE".getBytes();

	private final OutputStream surface;
	
	public Canvas(OutputStream surface) {
		this.surface = surface;
	}
	
	public void printFrame(Frame frame) throws IOException {
		surface.write(CLEARSCRN);
		surface.write(JMPHOME);
		surface.write(frame.getData());
		surface.flush();
	}	
}
