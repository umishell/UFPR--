
#include <iostream>
#include <cstdlib>

using namespace std;
int Removed = 0;

void removeSacks(int ar[], int quant, int removed) {
    for (int i = 0; i < 11; i++) {
        if (quant < 1) { cout << "{" << removed << "}"; Removed = removed; break; }
        cout << "." << removed+1<<".\n";
        if (i == 10) removeSacks(ar, quant, removed);
        else if (ar[i] < 1) continue;
        else { ar[i]--; quant--; removed++; }
    } 
}


int main() {

    int ar[10]{};
    int totalItens = 20, stak = 0, quant = 22, removed=0,rem=0;
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
        removeSacks(ar, quant, removed);
        cout <<"rem: "<< Removed << endl;
        stak += Removed;

        cout << "stak: " <<stak << endl;

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
