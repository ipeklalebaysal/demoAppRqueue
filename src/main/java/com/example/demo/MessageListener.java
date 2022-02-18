package com.example.demo;

import org.springframework.stereotype.Component;

import com.github.sonus21.rqueue.annotation.RqueueListener;

@Component
public class MessageListener {

	@RqueueListener(value = "timeout-queue")
	public void sendTimeoutData(int callId) {
		System.out.println("timed out call id: " + callId);
	}
}
