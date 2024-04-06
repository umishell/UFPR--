#include <iostream>
#include <algorithm>  
#include <string>
#include <random>

using namespace std;

void swap(char* name, int i, int j) {
	// Directly swap elements within the array
	char temp = name[i];
	name[i] = name[j];
	name[j] = temp;
}

void shuffle(char* arr, int n) {
	// Use random number generator for shuffling
	std::random_device rd;
	std::mt19937 g(rd()); // Seed the generator

	// Use a uniform distribution to generate random indexes
	std::uniform_int_distribution<int> dist(0, n - 1);

	for (int i = 0; i < n+1 ; ++i) {
		// Swap current element with a random element
		int j = dist(g);
		swap(arr[i], arr[j]);
	}
}

int partition(char* a, int lo, int hi) {

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

void quicksort_(char* a, int lo, int hi)
{
	

	if (hi <= lo) return;
	int j = partition(a, lo, hi);
	//printing for tracking changes
	cout << a << endl;//array
	cout << "lo = " << lo;//low
	cout << "  hi = " << lo;//high
	cout << "  j = " << lo << endl;;//pivot

	quicksort_(a, lo, j - 1);
	quicksort_(a, j + 1, hi);
	
}

void quicksort(char* a, int n)
{	
	cout <<"before shuffle n= " << n << endl;

	shuffle(a, n);
	cout << "after shuffle n= " << n << endl;

	cout << "shuffled name: \n";
	cout << a << "\n" << endl;
	cout << "quick sort starting: \n";
	quicksort_(a, 0, n - 1);

}




int main()
{
	string strname = "Michel Abril Marinho"; // string input name
	cout << "string passed as input: \n";
	cout << strname << "\n" << endl;

	strname.erase(remove_if(strname.begin(), strname.end(), [](unsigned char x) { return isspace(x); }), strname.end());
	cout << "name without spaces: \n";
	cout << strname << "\n" << endl;

	int n = strname.size();//size of name
	// Convert string to character array
	char* name = new char[n + 1]; // char array with \0 
	name[n] = '\0';
	for (int i = 0; i < n; i++) {
		name[i] = strname[i];
	}

	cout << "char array: \n";
	for (int i = 0; i < n; i++) cout << name[i];
	cout << "\n" << endl;

	cout <<"n= " << n << endl;

	quicksort(name, n - 1);
	cout << "\nSorted name: \n";
	cout << name << endl;


	return 0;
}
