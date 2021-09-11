package com.tulip.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class Server {
	public static void main(String[] args) {
		try {
			log.info("服务端启动");
			ServerSocket serverSocket = new ServerSocket(9999);
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String message;
			while ((message = bufferedReader.readLine()) != null) {
				log.info("服务端收到消息:" + message);
			}
		} catch (IOException e) {
			log.error("Server IOException:{}", e.getMessage(),e);
		}
	}
}
