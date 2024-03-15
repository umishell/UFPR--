// ED2ex.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <chrono>
#include <functional>
using namespace std::chrono;


// Function to measure execution time of another function
double measure_execution_time(std::function<void()> func) {
    auto start = high_resolution_clock::now();
    func();
    auto finish = high_resolution_clock::now();
    duration<double> elapsed = finish - start;
    return elapsed.count();
}

// Define the Fibonacci functions
long int fib_recursive(long int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib_recursive(n - 1) + fib_recursive(n - 2);
}

long int fib_iterative(long int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    long int first = 1, second = 1, next;
    for (long int c = 0; c < n; c++) {
        if (c <= 1) next = c;
        else {
            next = first + second;
            first = second;
            second = next;
        }
    }
    return next;
}


int main() {

    int n;
    do {
        bool validInput = false; // Flag to track if valid input is received
        while (!validInput) {
            // Prompt the user for input
            std::cout << "Enter a positive integer: \n <1 to end program\n";

            // Read the input from the user
            std::cin >> n;
            if (n < 1) {
                std::cout << "..PROGRAM TERMINATED..";
                exit(n);
            }
            // Check if the input was successful and positive
            if (std::cin.fail() || n <= 0) {
                std::cerr << "Error: Invalid input. Please enter a positive integer." << std::endl;
                std::cin.clear(); // Clear the error state for future input
                std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Ignore invalid input from the stream
            }
            else {
                validInput = true; // Input is valid, set the flag
            }
        }

        // Measure execution time for each function with a specific input (e.g., n = 30)



        double recursive_time = measure_execution_time(std::bind(fib_recursive, n));
        double iterative_time = measure_execution_time(std::bind(fib_iterative, n));
        // Print the results
        std::cout << "Recursive Fibonacci (n=" << n << ") execution time: " << recursive_time << " seconds\n";
        std::cout << "Iterative Fibonacci (n=" << n << ") execution time: " << iterative_time << " seconds\n";



    } while (n > 0);

    
    
    
    /*int b = 43;
    double recursive_time = measure_execution_time(std::bind(fib_recursive, b));
    double iterative_time = measure_execution_time(std::bind(fib_iterative, b));
    // Print the results
    std::cout << "Recursive Fibonacci (n=" << b << ") execution time: " << recursive_time << " seconds\n";
    std::cout << "Iterative Fibonacci (n=" << b << ") execution time: " << iterative_time << " seconds\n";
    int c = 1000;
    double recursive_time = measure_execution_time(std::bind(fib_recursive, c));
    double iterative_time = measure_execution_time(std::bind(fib_iterative, c));
    // Print the results
    std::cout << "Recursive Fibonacci (n=" << c << ") execution time: " << recursive_time << " seconds\n";
    std::cout << "Iterative Fibonacci (n=" << c << ") execution time: " << iterative_time << " seconds\n";
    int d = 100000;
    double recursive_time = measure_execution_time(std::bind(fib_recursive, d));
    double iterative_time = measure_execution_time(std::bind(fib_iterative, d));
    // Print the results
    std::cout << "Recursive Fibonacci (n=" << d << ") execution time: " << recursive_time << " seconds\n";
    std::cout << "Iterative Fibonacci (n=" << d << ") execution time: " << iterative_time << " seconds\n";
    */

   
    return 0;
}
