# VogelfreiEntenBot
A Telegram bot that looks like a duck, walks like a duck, quacks like a duck, tastes like a duck.
It should be running under [@VogelfreiEntenBot](https://t.me/VogelfreiEntenBot).

It was inspired by https://github.com/BergiuTelegram/TgEntenBot but later rewritten using the telebot Go package.
tailored to [Theatergruppe Vogelfrei](http://vogelfrei.in-hd.de)

## Dependencies
A [Go](https://golang.org) installation.

## Configuration
* Create a new Telegram bot with the [BotFather](https://telegram.me/botfather)
* Disable privacy settings for the bot
* Pass the token on the command line when running, see below

## Installation
```shell
git clone https://github.com/Xjs/VogelfreiEntenBot && cd VogelfreiEntenBot
go run cmd/vogelfrei-ente/main.go -token <TOKEN>
```
