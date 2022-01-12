all: PA11

PA11: PA11.o LongDate.o Date.o
	g++ -std=c++11 PA11.o Date.o LongDate.o -o PA11 -lm

PA11.o: PA11.cpp Date.h LongDate.h
	g++ -std=c++11 -c PA11.cpp

LongDate.o: LongDate.cpp LongDate.h Date.h
	g++ -std=c++11 -c LongDate.cpp

Date.o: Date.cpp Date.h
	g++ -std=c++11 -c Date.cpp

clean:
	rm -rf *.o
