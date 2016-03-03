package com.epam.preprod.kushnarenko.server;

import java.io.IOException;
import java.net.Socket;

import com.epam.preprod.kushnarenko.processor.Processor;
import com.epam.preprod.kushnarenko.processor.MyHttpProcessor;

public class HTTPServerFactory extends AbstractServerFactory {

	
	/**
	 * This method returns new Instance of HTTP server.
	 */
	@Override
	public Processor createServer(Socket s) throws IOException {
		return new MyHttpProcessor(s);

	}

}
