# compiler optionen
JFLAGS = -g -d bin -cp bin -cp lib/telegrambots-2.4.4.5-jar-with-dependencies.jar
# compiler
JC = javac

# jede .class datei hat die abhängigkeit einer .java datei mit dem gleichen namen
# 2.zeile: wie wird die jeweils compilier
# $< ist die erste abhängigkeit
# %.class: %.java
# 	$(JC) $(JFLAGS) $<

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  src/*.java \

default: build

#classes: $(CLASSES:.java=.class)
build: $(CLASSES)
	$(JC) $(JFLAGS) $(CLASSES)

# damit der nicht versucht die datei "clean" du bauen
.PHONY: build clean
clean:
	$(RM) bin/**/*.class
	$(RM) bin/*.class

