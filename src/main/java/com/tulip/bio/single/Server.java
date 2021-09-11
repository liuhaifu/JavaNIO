package com.tulip.bio.single;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 当前服务端能实现服务端和客户端一对一Socket通信
 * 且是同步阻塞式通信
 * 一个服务端只能处理一个客户端的Socket通信请求
 * 如果有多个客户端的请求，客户端没法儿处理多个请求
 */
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
