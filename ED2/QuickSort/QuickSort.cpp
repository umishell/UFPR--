#include <iostream>

using namespace std;

void swap(int arr[], int i, int j) {
	/* Directly swap elements within the array */
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

int partition(int* a, int lo, int hi) {

	int i = lo, j = hi + 1;
	while (1) {
		while (a[++i] < a[lo]) // Encontra item na esquerda para a troca
			if (i == hi) break;

		while (a[lo] < a[--j]) // Encontra item na direita para a troca
			if (j == lo) break;
		if (i >= j) break;
		swap(a, i, j);
	}
	swap(a, lo, j);
	return(j);
}


void quicksort_(int* a, int lo, int hi)
{
	if (hi <= lo) return; 
	int j = partition(a, lo, hi);
	quicksort_(a, lo, j - 1);
	quicksort_(a, j + 1, hi);
}

void quicksort(int* a, int n)
{
	shuffle(a, n);
	quicksort_(a, 0, n - 1);
}
#include <random>

void shuffle(int arr[], int n) {
	// Use random number generator for shuffling
	std::random_device rd;
	std::mt19937 g(rd()); // Seed the generator

	// Use a uniform distribution to generate random indexes
	std::uniform_int_distribution<int> dist(0, n - 1);

	for (int i = 0; i < n - 1; ++i) {
		// Swap current element with a random element
		int j = dist(g);
		swap(arr[i], arr[j]);
	}
}


int main()
{
	int arr[] = { 10, 7, 8, 9, 1, 5 };
	int n = sizeof(arr) / sizeof(arr[0]);

	quickSort(arr, 0, n - 1);
	cout << "Sorted array: \n";
	printArray(arr, n);

	return 0;


}

