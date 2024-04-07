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
	
	int i = lo, j = hi;
	while (1) {
		while (a[++i] < a[lo]) if (i == hi) break; 
		cout <<"i." << i << " = " << a[i] << endl;
	
		while (a[j--] > a[lo]) if (j == lo) break; 
		cout <<"j." << j << " = " << a[j] << endl;

		if (i >= j) break;
		swap(a, i, j); 
		cout << "- swapping . i= " << a[i] <<"   j= " << a[j] << endl;
	}
	cout << "before swap j." << j << " = " << a[j] << endl;
	cout << "           lo." << lo << " = " << a[lo] << endl;
	cout << a << endl;//array
	//swap(a, j-1, lo);
	char temp = a[lo];
	a[lo] = a[j];
	a[j] = temp;
	cout << "after swap j." << j << " = " << a[j] << endl;
	cout << "           lo." << lo << " = " << a[lo] << endl;
	cout << a << endl;//array
	 cout << "end of partition\n"<<endl; return(j);
}

void quicksort_(char* a, int lo, int hi)
{

	cout << "lo = " << lo << "  hi = " << hi << endl;
	if (hi <= lo) {
		cout << "hi <= lo \n"; return;
	}
	int pivot = partition(a, lo, hi);
	//tracking changes
	cout << a << endl;//array

	quicksort_(a, lo, pivot - 1);
	quicksort_(a, pivot + 1, hi);
}

void quicksort(char* a, int n)
{	
	//shuffle(a, n-1);
	//cout << "shuffled name: \n";
	//cout << a << "\n" << endl;
	cout << "quick sort starting: \n";
	quicksort_(a, 0, n-1);

}




int main()
{
	string strname = "fedcba"; // string input name
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

	quicksort(name, n );
	cout << "\nSorted name: \n";
	cout << name << endl;


	return 0;
}
