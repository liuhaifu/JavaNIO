package com.tulip.bio.more;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 当前服务端可以处理多个客户端的Socket通信请求
 * 处理方式是当前客户端为每一个客户端请求创建一个线程
 * 每一个socket请求，服务端交给一个独立的线程处理
 *
 */
@Slf4j
public class ServerMore {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread(()->{
					try {
						InputStream inputStream = socket.getInputStream();
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
						String msg;
						while ((msg = bufferedReader.readLine()) != null) {
							log.info("ServerMore收到:" + msg);
						}
					} catch (IOException e) {
						log.error("ServerMore IOException:{}", e.getMessage(),e);
					}
				}).start();
			}
		} catch (IOException e) {
			log.error("ServerMore IOException:{}", e.getMessage(), e);
		}
	}
}
