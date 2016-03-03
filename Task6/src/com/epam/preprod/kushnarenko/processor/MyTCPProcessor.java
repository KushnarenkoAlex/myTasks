package com.epam.preprod.kushnarenko.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import com.epam.preprod.kushnarenko.serverCommands.Commands;
import com.epam.preprod.kushnarenko.serverCommands.ServerCommand;
import com.epam.preprod.kushnarenko.util.Const;

/**
 * This class represents thread for processing HTTP queries.
 * 
 * @author Oleksandr Kushnarenko
 *
 */
public class MyTCPProcessor extends Thread implements Processor {

	private PrintStream os;
	private BufferedReader is;

	public MyTCPProcessor(Socket s) throws IOException {
		os = new PrintStream(s.getOutputStream());
		is = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	public void run() {
		String str;
		try {
			while ((str = is.readLine()) != null) {
				System.out.println(str);
				String[] ss = str.split("=");
				ServerCommand c = Commands.get(ss[0]);
				if (ss.length == 1) {
					os.println(c.execute(null, Const.TCP));
				} else {
					os.println(c.execute(ss[1], Const.TCP));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Disconnect");
		} finally {
			disconnect();
		}
	}

	private void disconnect() {
		try {
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// this.interrupt();
		}
	}
}
