import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class EntenBot extends TelegramLongPollingBot {

	private String botUsername;

	private String botToken;

	public EntenBot(){
		String[] params = readTokenAndUsernameFromFile();
		this.botToken = params[0];
		this.botUsername = params[1];
	}

	public static String[] readTokenAndUsernameFromFile() {
		File file_token = new File("TOKEN");
		File file_username = new File("BOTNAME");
		try {
			Scanner sc = new Scanner(file_token);
			String token = sc.nextLine();
			sc.close();
			sc = new Scanner(file_username);
			String username = sc.nextLine();
			sc.close();
			if (token != "" && username != "") {
				return new String[] { token, username };
			}
		} catch (FileNotFoundException fnfe) {

		}
		System.out.println("You have to create two files, TOKEN and BOTNAME.");
		System.out.println("Then you have to insert your BotToken and your BotUsername into them.");
		System.exit(1);
		return null;
	}

	@Override
	public String getBotUsername() {
		return this.botUsername;
	}

	@Override
	public String getBotToken() {
		return this.botToken;
	}

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		System.out.println("Received msg");
		if (update.hasMessage() && update.getMessage().hasText()) {
			String text = update.getMessage().getText().toLowerCase();
			SendMessage message = new SendMessage();
			message.setChatId(update.getMessage().getChatId());
			//write everything in lowercase in the contains
			if(text.contains("ente")){
				message.setText("*QUACK!*");
			} else if (text.contains("bla")){
				message.setText("*BLUB!*");
			} else if (text.contains("kuh")){
				message.setText("*MUUHH!*");
			} else if (text.contains("187")){
				message.setText("*STRAßENBANDE!*");
			} else if (text.contains("git")){
				message.setText("*<3!*");
			} else {
				return;
			}
			message.setParseMode("markdown");
			try {
				sendMessage(message); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

}
