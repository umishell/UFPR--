#include <iostream>
#include <cstdlib>

using namespace std;



int main() {

    int array[10]{};
    int totalItens = 20;

    srand(time(0));

    while (totalItens > 0) {
        int randomNumber = rand() % 10;
        if (array[randomNumber] > 2) {
            continue;
        }
        else {
            array[randomNumber]++;
            totalItens--;
        }
    }

    for (int i = 0; i < 10; i++) {
        cout << array[i] << endl;
    }
    return 0;
}
