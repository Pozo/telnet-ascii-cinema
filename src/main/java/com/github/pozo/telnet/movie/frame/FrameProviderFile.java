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
	
	public FrameProviderFile(File framesFile) throws FileNotFoundException {
		bufferedReader = new BufferedReader(new FileReader(framesFile));
		iterator = new BufferedFrameIterator(bufferedReader);
	}
	private class BufferedFrameIterator implements Iterator<Frame> {
		private BufferedReader bufferedReader;
        private String line;
        
		public BufferedFrameIterator(BufferedReader bufferedReader) {
			(this.bufferedReader = bufferedReader).getClass();
			advance();
		}

		public boolean hasNext() {
			return line != null;
		}

		public Frame next() {
			Frame retval = new Frame(line);
			advance();
			return retval;
		}
        private void advance() {
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
            	System.err.println(e.getMessage());
            }
            if ( line == null && FrameProviderFile.this.bufferedReader != null ) {
                try {
                	FrameProviderFile.this.bufferedReader.close();
                }
                catch (IOException e) { 
                	System.err.println(e.getMessage());
                }
                FrameProviderFile.this.bufferedReader = null;
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
