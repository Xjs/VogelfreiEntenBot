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

public class WindoofBot extends TelegramLongPollingBot {

	private String botUsername;

	private String botToken;

	public WindoofBot(){
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
			if(text.equals("/license") || text.equals("/license"+this.getBotUsername())){
				message.setText("Welcome!\nThis bot is a program which is available under the MIT license at https://github.com/Bergiu/TelegramWindoofBot");
			}
			else if(text.contains("windows")){
				String replaced = text.replace("windows", "windoof");
				message.setText("Meinst du:``` \n" + replaced + " ```\n");
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
