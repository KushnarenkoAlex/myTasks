package com.epam.preprod.kushnarenko.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.epam.preprod.kushnarenko.processor.Processor;

public class MyServer extends Thread {

	ServerSocket sock;
	int port;
	ServType type;

	public MyServer(int port, ServType sv) {
		setDaemon(true);
		this.start();
		this.port = port;
		this.type = sv;
	}

	@Override
	public void run() {
		try {
			sock = new ServerSocket(port);
			while (true) {
				Socket s = sock.accept();
				Processor ip = AbstractServerFactory.getProcess(s, type);
				ip.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
