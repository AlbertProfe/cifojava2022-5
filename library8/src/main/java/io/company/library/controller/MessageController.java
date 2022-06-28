package io.company.library.controller;


import io.company.library.model.TextMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

	@MessageMapping("/sendmessage")
	@SendTo("/message/response")
	public TextMessage textMessage(TextMessage inputMessage) {

		System.out.println("inputMessage" + inputMessage);
		TextMessage outputMessage = new TextMessage ("This is the response from server. This is your original message: "
				+ HtmlUtils.htmlEscape(inputMessage.getContent()) + ". Please, enjoy Websockets!");

		return outputMessage;
	}



}