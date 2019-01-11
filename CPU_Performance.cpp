//============================================================================
// Name        : Cpu_Performance.cpp
// Author      : varnitajain
// Version     :
// Copyright   : Your copyright notice
// Description : Ansi-style
//============================================================================
#include <thread>			//include thread library
#include <iostream>
#include <atomic>			//include atomic library
#include <mutex>			//include mutex library
#include <chrono>			//chrono library is used to add clocks

//using namespace std;

//size_t is used to define unsigned integer type
//const size_t size = 100000000;		//initialize constant size as timer 1
//const size_t size = 200000000;		//initalize constant size as timer2
const size_t size = 50000000;			//initalize constant size as timer3

std::mutex mutex;			//initialize mutex obj
bool var = false;		//init boolean flag with a FALSE value

typedef std::chrono::high_resolution_clock Clock;		//std::chrono::high_resolution_clock represents the clock with shortest tick period

//testAtomic function is used to implement std::atomic
void testAtomic(){

	//std::atomic<> is used to represent a type. Here std::atomic<bool> represents a boolean variable 'var' that multiple threads can use simultaneously
	std::atomic<bool> sync(true);		//sync the flag
	const auto start_time = Clock::now();		//Starting clock now
	//the clock will count the no of ticks to execute for loop for Atomic

	for(size_t counter = 0; counter < size; ++counter){			//loop starts here
		var = sync.load();			//sync the content of std::atomic and store in flag. load() is used to get the contained value atomically
	}
	//loop ends here

	const auto end_time = Clock::now();		//ending clock now

	//using duration_cast function to convert ticks into microseconds
	std::cout << "time taken to execute testAtomic(): ";

	//std::chrono::duration is used to represent a time interval. Here duration_cast is used to convert the duration to microseconds.
	//count() is used to return the no of ticks.

	//1e-6 represents 1*10 raised to the power 6. we are using this for ms to sec conversion
	std::cout << 1e-6*std::chrono::duration_cast<std::chrono::microseconds>(end_time - start_time).count() << "s\n";
}


void testMutex(){
	const auto start_time = Clock::now();		//start clock

	//for loop starts here
	for(size_t counter = 0; counter < size; ++counter){

		//lock() function is used to lock the mutex. If another thread has already locked the mutex, a call to lock will block execution until the lock is acquired.
		//unique_lock() function is used to control ownership of mutex.
		std::unique_lock<std::mutex> lock(mutex);
		//mutex locked

		var != var;
		}
	//for loop ends here

	const auto end_time = Clock::now();		//stop the clock
    	std::cout << "time taken to execute testMutex(): ";

    	//(end_time - start_time) will count the no of ticks from end time to start time
	std::cout << 1e-6*std::chrono::duration_cast<std::chrono::microseconds>(end_time - start_time).count() << "s\n";
}


int main() {

	//starting thread 1
	std::cout <<"Starting Thread 1... \n" << "Calling testAtomic() \n";
	std::thread thread1(testAtomic);		//thread 1 started and calls function testAtomic

	//calling join function to end thread 1
	thread1.join();
//thread 1 ends here
	std::cout <<"Ending Thread 1. \n";


	//starting thread 2
std::cout <<"Starting Thread 2... \n" << "Calling testMutex() \n";
	std::thread thread2(testMutex);			//thread 2 started and calls function testMutex

	//std::thread thread3(testMutex);

	//calling join function to end thread 2
	thread2.join();
//thread 2 ends here
	std::cout <<"Ending thread 2.\n";

}
