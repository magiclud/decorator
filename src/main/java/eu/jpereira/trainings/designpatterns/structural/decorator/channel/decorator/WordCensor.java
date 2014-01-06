package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator {
	private String censoredWord;

	public WordCensor(String censoredWord) {
		this.censoredWord = censoredWord;
	}

	public WordCensor(String censoredWord, SocialChannel channel) {
		this.censoredWord = censoredWord;
		this.delegate = channel;
	}
	// TODO
	@Override
	public void deliverMessage(String message) {
		if (censoredWord.equals("Microsoft")) {
			StringBuilder builder = new StringBuilder();
			builder.append("###");
			builder.append(message.substring(censoredWord.length()));
			message = builder.toString();
		}

		delegate.deliverMessage(message);
	}

}
