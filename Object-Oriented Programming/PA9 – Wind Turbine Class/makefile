all: PA9Test

PA9Test: PA9Test.o WindTurbine.o
	g++ -std=c++11 PA9Test.o WindTurbine.o -o PA9Test

PA9Test.o: PA9Test.cpp WindTurbine.h
	g++ -std=c++11 -c PA9Test.cpp

WindTurbine.o: WindTurbine.cpp WindTurbine.h
	g++ -std=c++11 -c WindTurbine.cpp

clean:
	rm -rf *.o
