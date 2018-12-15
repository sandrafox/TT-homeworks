SOURCES = $(shell find src -type f -name "*.java")
CLASSES = $(patsubst src/%.java,out/%.class,$(SOURCES))
MAINCLASS = Task1

all: $(CLASSES)

run:
	java -cp out ${MAINCLASS}

pack:
	zip hw1.zip -r Makefile src

out/%.class: src/%.java out
	javac -cp src $< -d out

out:
	mkdir -p out
