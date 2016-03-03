package com.epam.preprod.kushnarenko.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.preprod.kushnarenko.serverCommands.Commands;
import com.epam.preprod.kushnarenko.serverCommands.ServerCommand;
import com.epam.preprod.kushnarenko.util.Const;

/**
 * This class represents thread for processing HTTP queries.
 * 
 * @author Oleksandr Kushnarenko
 *
 */
public class MyHttpProcessor extends Thread implements Processor {

	private PrintStream os;
	BufferedReader is;
	//private String query;

	public MyHttpProcessor(Socket s) throws IOException {
		os = new PrintStream(s.getOutputStream());
		//query = q;
		is = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	/**
	 * This method parses query and send response.
	 */
	@Override
	public void run() {
		String str;
		ServerCommand sc;
		try {
			str = is.readLine();
			Pattern urlPat = Pattern.compile(Const.URL_PATTERN);
			Matcher m = urlPat.matcher(str);
			if (m.matches()) {
				str = m.group(1);
			}
			Pattern pattern2 = Pattern.compile(Const.HTTP_PATTERN);
			Matcher m2 = pattern2.matcher(str);
			if (m2.matches()) {
				sc = Commands.get(m2.group(2));
				str = m2.group(3);
			} else {
				sc = Commands.get(str);
			}
			if (sc.equals(null)) {
				sc = Commands.get("no_command");
			}
			String res = sc.execute(str, Const.HTTP);
			writeResponse("<html><body><h1>" + res + "</h1></body></html>");
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

	private void writeResponse(String s) throws IOException {
		String response = "HTTP/1.1 200 OK\r\n" + "Server: Kush\r\n" + "Content-Type: text/html\r\n"
				+ "Content-Length: " + s.length() + "\r\n" + "Connection: close\r\n\r\n";
		String result = response + s;
		os.write(result.getBytes());
		os.flush();
	}

}
