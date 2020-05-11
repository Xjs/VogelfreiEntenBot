package ente

import (
	"math/rand"
	"strings"
	"time"

	"gopkg.in/tucnak/telebot.v2"
)

func init() {
	rand.Seed(time.Now().UnixNano())
}

func tasseOderKaennchen() string {
	if rand.Float64() < 0.7 {
		return "*Kännchen!!*"
	}

	return "Tasse."
}

const flaviaSaysTooLate = "Das geht ja mal gar nicht! Du bist schon wieder spät dran? Überdenke lieber einmal deine Lebensentscheidungen. Und dann auch noch über Telegram schreiben. Schäm dich!"

// Respond lets the duck respond to the message. It returns true as second argument
// if the duck has a response to this message.
func Respond(message *telebot.Message) (interface{}, bool) {
	if message.Text == "" {
		return nil, false
	}

	lower := strings.ToLower(message.Text)

	have := func(needle string) bool {
		return strings.Contains(lower, needle)
	}

	if have("love") || have("git") {
		return "*<3*", true
	}

	if have("svn") || have("subversion") {
		return "*QUAAAAACKKKK😡!!*", true
	}

	if have("vivat") {
		return "*HOCH*", true
	}

	if have("tasse") || have("kännchen") {
		return tasseOderKaennchen(), true
	}

	if have("dachsenfranz") {
		return "*Prosit! 🍻*", true
	}

	if have("spaet") || have("spät") {
		if rand.Float64() < 0.2 {
			return flaviaSaysTooLate, true
		}

		return "War ja zu erwarten, daß gerade DU mal wieder spät dran bist...", true
	}

	if message.Text == "Magic!" {
		return "*fizz* buzz", true
	}

	return nil, false
}
