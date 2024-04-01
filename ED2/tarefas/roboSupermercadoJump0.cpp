
#include <iostream>
#include <cstdlib>
#include < ctype.h >
#include <algorithm>


using namespace std;
int Removed = 0;

void removeSequencial(int ar[], int quant, int removed) {
    

    for (int i = 0; i < 11; i++) {
        if (quant>20-Removed) quant=20-Removed;
        if (quant < 1) { cout << "{" << removed << "}"; Removed = removed; return; }
        if (i == 10) removeSequencial(ar, quant, removed);

        else if (ar[i] < 1) continue;
        else { ar[i]--; quant--; removed++;cout << "." << removed<<".\n"; }
        
    } 
}






void removeBinary(int ar[], int quant, int size, int& removedCount) {

    // Error handling: Ensure quant is not greater than total items
    if (quant > size) {
        cout << "Error: quantity to remove cannot exceed total items." << endl;
        return;
    }

    // Sort the array in descending order
    sort(ar, ar + size, greater<int>());

    removedCount = 0;
    while (quant > 0) {
        int low = 0;
        int high = size - 1;
        int mid;

        // Binary search for the first value greater than or equal to quant
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (ar[mid] >= quant) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        // Decrement the found value or the closest larger value
        if (low < size) {
            while (quant > 0 && ar[low] > 0) {
                ar[low]--;
                quant--;
                removedCount++;
            }
        }
    }

    cout << "Items removed: " << removedCount << endl;
}



int main() {

    int ar[10]{};
    int totalItens = 20, stak = 0, quant = 22, removed ;
    //randomize through out array
    srand(time(0));
    while (totalItens > 0) {
        int randomNumber = rand() % 10;
        if (ar[randomNumber] > 2) {
            continue;
        }
        else {
            ar[randomNumber]++;
            totalItens--;
        }
    }
    //check array
    for (int i = 0; i < 10; i++) {
        cout << ar[i];
    }cout << endl;



    //input test sample max 20
    cout << "se quantidade < 1 = end program." << endl;
    cout << "quantos pacotes de açucar gostaria de retirar? " << endl;
   
    while (quant > 20) {
        cout << "quantidade: ";
        cin >> quant;
        if (quant > 20) cout << "wrong value\n";
        else if (quant < 1) exit(0);
    }
    while (stak < 20) { 
        removeSequencial(ar, quant, removed=0);
        //removeBinary(ar, quant, 10);
        cout <<"rem: "<< Removed << endl;

        stak += Removed;cout << "stak: " <<stak << endl;

        //check array
        for (int i = 0; i < 10; i++) {
            cout << ar[i];
        }cout << endl;

        if (stak >= 20) { cout << "nao ha mais itens\n" << endl; break; }

        quant = 22;
        while (quant > 20) {
            cout << "quantidade: ";
            cin >> quant;
            if (quant > 20) cout << "wrong value\n";
            else if (quant < 1) exit(0);

        }
    }

   
    cout << "END OF PROGRAM" << endl;

    return 0;
}
