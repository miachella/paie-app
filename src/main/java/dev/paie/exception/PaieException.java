package dev.paie.exception;

import java.util.List;

public class PaieException extends RuntimeException {

	private List<String> messagesErreurs;

	public PaieException(List<String> messagesErreurs) {
		this.messagesErreurs = messagesErreurs;
	}

	public List<String> getMessagesErreurs() {
		return messagesErreurs;
	}

}
