package com.tulip.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

@Slf4j
public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",9999);
			OutputStream outputStream = socket.getOutputStream();
			PrintStream printStream = new PrintStream(outputStream);
			Scanner scanner = new Scanner(System.in);
			while (true) {
				log.info("客户端请说:");
				String msg = scanner.nextLine();
				printStream.println(msg);
				printStream.flush();
			}

		} catch (IOException e) {
			log.error("Client IOException:{}", e.getMessage(), e);
		}

	}
}
