#include <iostream>
#include <random>

using namespace std;

    int main() {

    int array[10]={0};
    int totalItens = 20;

    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> dist(0,3);


    
    while (totalItens>1){
        int posicaoAleatoria = dist(gen);
        if (array[posicaoAleatoria] >2) {
            continue;   
        }
        else{
        array[posicaoAleatoria]++;
        totalItens--;
        }
    }

    for(int i=0;i<10;i++){
        cout<<"indice " <<i<<": "<<array[i]<<endl;
    }
    return 0;
    }