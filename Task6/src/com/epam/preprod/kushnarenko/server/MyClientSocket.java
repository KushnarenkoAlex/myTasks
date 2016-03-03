package com.epam.preprod.kushnarenko.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.epam.preprod.kushnarenko.util.Const;

public class MyClientSocket {
	public static void main(String[] args) {

		try {
			while (true) {
				Socket s = new Socket(InetAddress.getLocalHost(), Const.PORT3000);
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
				BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
				String sentence = inFromUser.readLine();
				if (sentence == null || sentence.isEmpty() || sentence.equals(Const.EXIT)) {
					break;
				}
				outToServer.writeBytes(sentence + "\n");
				System.out.println(br.readLine());
				s.close();
			}
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	}
}