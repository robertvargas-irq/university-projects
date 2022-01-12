all: Calendar

Calendar: Calendar.o Date.o Time.o
	g++ -std=c++11 Calendar.o Date.o Time.o -o Calendar

Calendar.o: Calendar.cpp Date.h Time.h
	g++ -std=c++11 -c Calendar.cpp

Date.o: Date.cpp Date.h
	g++ -std=c++11 -c Date.cpp

Time.o: Time.cpp Time.h
	g++ -std=c++11 -c Time.cpp

clean:
	rm -rf *.o
