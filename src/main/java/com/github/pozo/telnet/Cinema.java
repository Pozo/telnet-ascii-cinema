package com.github.pozo.telnet;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.github.pozo.telnet.movie.Canvas;
import com.github.pozo.telnet.movie.Movie;
import com.github.pozo.telnet.movie.frame.FrameProvider;
import com.github.pozo.telnet.movie.frame.FrameProviderFile;
import com.github.pozo.telnet.movie.frame.FrameProviderMemory;

public class Cinema {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ServerSocket server = new ServerSocket(23);
		
		while(true) {
			Socket client = server.accept();
			
			FrameProvider frameProvider = new FrameProviderFile(new File("movie"));
			//FrameProvider frameProvider = new FrameProviderMemory();
			Canvas canvas = new Canvas(client.getOutputStream());
			
			Movie movie = new Movie(frameProvider, canvas);
			movie.setFrameRate(10);
			movie.play();

			client.close();
		}
	}
}

