# TelegramEntenBot
A Telegram bot that looks like a duck, walks like a duck, quacks like a duck, tastes like a duck. It should be running under [@VogelfreiEntenBot](https://t.me/VogelfreiEntenBot).

It is a fork of https://github.com/BergiuTelegram/TgEntenBot tailored to [Theatergruppe Vogelfrei](http://vogelfrei.in-hd.de)

## Dependencies
```
sudo apt install openjdk-8-jdk
```

## Installation
```shell
git clone https://github.com/Xjs/TgEntenBot && cd TgEntenBot
./config.sh
# <configure TOKEN and BOTNAME, see below>
make
```

## Configuration
- Create a new TelegramBot with the [Botfather](https://telegram.me/botfather)
- Disable privacy settings for the bot
- Write your Botname into the file `BOTNAME` and your Token into the file `TOKEN`

## Run
- `java -cp bin:lib/telegrambots-2.4.4.5-jar-with-dependencies.jar Main`
