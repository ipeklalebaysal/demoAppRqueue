package com.example.demo;

import org.apache.commons.lang3.tuple.MutablePair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.sonus21.rqueue.core.RqueueMessageSender;

@RestController
public class Controller {
	@Autowired
	private RqueueMessageSender rqueueMessageEnqueuer;

	@GetMapping("/try")
	public void getCallIdAndTimeout(@RequestParam int callId, @RequestParam long timeout) {
		System.out.println(" Enqueuing message: " + callId);
		rqueueMessageEnqueuer.enqueueIn("timeout-queue", callId, timeout);
		System.out.println("I enqueud it: " + callId);
	}
}
