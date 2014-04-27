package com.github.pozo.telnet.movie.frame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FrameProviderFile implements FrameProvider {
    private BufferedReader bufferedReader;
    private final Iterator<Frame> iterator;
	private final FrameDescriptior frameDescriptior;
	
	public FrameProviderFile(File framesFile, FrameDescriptior frameDescription) throws FileNotFoundException {
		this.frameDescriptior = frameDescription;
		bufferedReader = new BufferedReader(new FileReader(framesFile));
		iterator = new BufferedFrameIterator(bufferedReader);
		
	}
	private class BufferedFrameIterator implements Iterator<Frame> {
		private BufferedReader bufferedReader;
		private String line = null;
        private String buffer = "";
        
		public BufferedFrameIterator(BufferedReader bufferedReader) {
			(this.bufferedReader = bufferedReader).getClass();
			advance();
		}

		public boolean hasNext() {
			return line != null;
		}

		public Frame next() {
			Frame retval = new Frame(buffer);
			buffer = "";
			advance();
			return retval;
		}
        private void advance() {
            try {
            	for (int i = 0; i < frameDescriptior.getFrameHeight() && (line = bufferedReader.readLine()) !=null ; i++) {
            		buffer += line;
				}
                //line = bufferedReader.readLine();
            } catch (IOException e) {
            	System.err.println(e.getMessage());
            } finally {
				if ( line == null && bufferedReader != null ) {
                    try {
                    	bufferedReader.close();
                    }
                    catch (IOException e) { 
                    	System.err.println(e.getMessage());
                    }
                }
            }

        }
		public void remove() {
			 throw new UnsupportedOperationException("Remove not supported on BufferedReader iteration.");
		}
		
	}
	public Iterator<Frame> iterator() {
		return iterator;
	}

}
