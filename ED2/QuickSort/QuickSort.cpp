#include <iostream>
#include <algorithm>  // Add this line
#include <string>
#include <random>

using namespace std;

void shuffle(string* name, int n) {
	// Use random number generator for shuffling
	random_device rd;
	mt19937 g(rd()); // Seed the generator

	// Use a uniform distribution to generate random indexes
	uniform_int_distribution<int> dist(0, n - 1);

	for (int i = 0; i < n - 1; ++i) {
		// Swap current element with a random element
		int j = dist(g);
		swap(name[i], name[j]);
	}
}

void swap(string* name, int i, int j) {
	/* Directly swap elements within the array */
	string temp = name[i];
	name[i] = name[j];
	name[j] = temp;
}

int partition(string* name, int lo, int hi) {

	int i = lo, j = hi + 1;
	while (1) {
		while (name[++i] < name[lo]) // Encontra item na esquerda para a troca
			if (i == hi) break;

		while (name[lo] < name[--j]) // Encontra item na direita para a troca
			if (j == lo) break;
		if (i >= j) break;
		swap(name, i, j);
	}
	swap(name, lo, j);
	return(j);
}


void quicksort_(string* name, int lo, int hi)
{
	if (hi <= lo) return; 
	int j = partition(name, lo, hi);
	quicksort_(name, lo, j - 1);
	quicksort_(name, j + 1, hi);
}

void quicksort(string* name, int n)
{
	//shuffle(name, n);
	quicksort_(name, 0, n - 1);
}




int main()
{
	string name = "Michel Abril Marinho";
	name.erase(remove_if(name.begin(), name.end(), [](unsigned char x) { return isspace(x); }), name.end());
	cout << name << endl;

	int n = name.size();
	cout << n << endl;

	//quicksort(&name, n - 1);
	quicksort_(&name, 0, n - 1);
	cout << "Sorted name: \n";
	cout << name << endl;


	return 0;


}

