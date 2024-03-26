// Michel Abril Marinho
//Jessica
// Luiz

#include <iostream>
#include <cstdlib>

using namespace std;



struct Action {
    
    int bestIndex=0,max=0;
    bool right=false;
};


    int goRight(int ar[], int index, int quant) {
        int max = 0;
      //  int length = sizeof(ar) / sizeof(ar[0]);
            for (int i = index; i < 10; i++) {
                if (ar[i] == 0 || max==quant) return max;
                else {
                    max++;
                }
            }
        return max;
    }

    int goLeft(int ar[], int index, int quant) {
        int max = 0;
            for (int i = index; i > -1; i--) {
                if (ar[i] == 0 || max == quant) return max;
                else {
                    max++;
                }
            }
        return max;
    }

    Action  searchBest(int ar[],int quant) {
        Action act;
        for (int i = 0; i < 10; i++) {

            int left = goLeft(ar, i, quant);
            int right = goRight(ar, i, quant);
            if (right > left && right > act.max) {
                act.max = right;
                act.right = true;
                act.bestIndex = i;
            }
            else if (left >= right && left > act.max) {
                act.max = left;
                act.right = false;
                act.bestIndex = i;

            }
            
        }
     return act;
    }
    /*
    void getSugar(Action act) {
        if (act.right) {
            for (int i = 0; i < act.max; i++) {
                if (ar[i] == 0 || max == quant) return max;
                else {
                    max++;
                }
            }
        }
        else {

        }
    }
    */


int main() {

    int ar[10]{};
    int totalItens = 20;

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

    for (int i = 0; i < 10; i++) {
        cout << ar[i];
        
    }cout << endl;

    //input test
    int quant = 6;

    Action act = searchBest(ar, quant);
    cout << " greater amount: " << act.max << ",  went right: " << act.right << ", on index: " << act.bestIndex << endl;





    return 0;
}
