
#include <iostream>
#include <cstdlib>

using namespace std;


int removeSacks(int ar[], int arlen, int quant, int removed) {
    for (int i = 0; i <= arlen; i++) {
        if (quant < 1) break;
        if (i == arlen) removeSacks(ar, arlen, quant, removed);
        else if (ar[i] < 1) continue;
        else { ar[i]--; quant--; removed++; }
    }
    //cout << removed << endl;
    return removed;
}



int main() {

    int ar[10]{};
    int totalItens = 20, arlen = 10, stak = 0, quant = 22, removed;
    //randomize through out array
    srand(time(0));
    while (totalItens > 0) {
        int randomNumber = rand() % arlen;
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
    }
    while (quant > 0 || stak < 20) {  
        removed = removeSacks(ar, arlen, quant, removed = 0);
        cout << removed << endl;
        stak += removed;
        cout << stak << endl;
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
            }
    }

   
    cout << "END OF PROGRAM" << endl;

    return 0;
}
