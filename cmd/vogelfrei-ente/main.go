package main

import (
	"flag"
	"log"
	"time"

	"gopkg.in/tucnak/telebot.v2"

	ente "github.com/Xjs/VogelfreiEntenBot"
)

func main() {
	var token string
	var apiURL string = "https://api.telegram.org"
	var timeout time.Duration

	flag.StringVar(&token, "token", token, "Telegram API token")
	flag.StringVar(&apiURL, "api", apiURL, "Telegram API URL")
	flag.DurationVar(&timeout, "timeout", timeout, "Poller timeout")

	flag.Parse()

	bot, err := telebot.NewBot(telebot.Settings{
		Token:  token,
		URL:    apiURL,
		Poller: &telebot.LongPoller{Timeout: timeout},
	})
	if err != nil {
		log.Fatalf("Error initialising bot: %v\n", err)
	}

	bot.Handle(telebot.OnText, func(m *telebot.Message) {
		if response, ok := ente.Respond(m); ok {
			bot.Send(m.Chat, response, &telebot.SendOptions{ParseMode: telebot.ModeMarkdownV2})
		}
	})

	bot.Start()
}
