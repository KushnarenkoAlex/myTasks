package com.epam.preprod.kushnarenko.server;

import java.io.IOException;
import java.net.Socket;

import com.epam.preprod.kushnarenko.processor.Processor;
import com.epam.preprod.kushnarenko.processor.MyTCPProcessor;

public class TCPServerFactory extends AbstractServerFactory{

	/**
	 * This method returns new Instance of TCP server.
	 */
	@Override
	public Processor createServer(Socket s) throws IOException {
		return new MyTCPProcessor(s);
		
	}

}
