package com.epam.preprod.kushnarenko.server;

import java.io.IOException;
import java.net.Socket;

import com.epam.preprod.kushnarenko.processor.Processor;

abstract class AbstractServerFactory {

	abstract public Processor createServer(Socket s) throws IOException;

	public static Processor getProcess(Socket sock, ServType server) throws IOException {
		AbstractServerFactory asf;
		if (server.equals(ServType.TCP)) {
			asf = new TCPServerFactory();
		} else {
			asf = new HTTPServerFactory();
		}
		return asf.createServer(sock);
	}

}
