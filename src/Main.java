import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class Main {
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			WindoofBot entenBot = new WindoofBot();
			telegramBotsApi.registerBot(entenBot);
		} catch (TelegramApiException e){
			BotLogger.error("LOGTAG", e);
		}
	}
}
