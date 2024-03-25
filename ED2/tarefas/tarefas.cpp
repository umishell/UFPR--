#include <iostream>
#include <cstdlib>

using namespace std;

int ar[10]{};


struct IndexMax {
    
    int index;
    int max;
 
};


    int goRight(int index) {
        int max = 0;
        int length = sizeof(ar) / sizeof(ar[0]);
            for (int i = index; i < length; i++) {
                if (ar[i] == 0) return max;
                else {
                    max++;
                }
            }
        return max;
    }

    int goLeft(int index) {
        int max = 0;
            for (int i = index; i > -1; i--) {
                if (ar[i] == 0) return max;
                else {
                    max++;
                }
            }
        return max;
    }
    IndexMax  leftright() {
        IndexMax indexmax;
        for (int i = 0; i < 10; i++) {

            int left = goLeft(i);
            int right = goRight(i);
            if (right > left) indexmax.max = right;
            else indexmax.max = left;

        }
        return indexmax;
    }
    IndexMax  leftright() {
        IndexMax indexmax;
        for (int i = 0; i < 10; i++) {

            int left = goLeft(i);
            int right = goRight(i);
            if (right > left ) indexmax.max = right;
            else indexmax.max = left;

        }
        return indexmax;
    }


int main() {

   
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
    }
    return 0;
}
