#include <iostream>


 void merge(int * a, int l, int m, int r){

  int i,j,k, *aux;
  aux= (int *) malloc(sizeof(int) * r+1);

  for(i=m+1; i >l; i--) aux[i-1] =a[i-1]; 
for(j=m; j < r; j++) aux[r+m-j] =a[j+1];

 for(k=l; k<=r; k++)
 if(aux[j] <aux[i]) a[k] =aux[j--]; 
else a[k] =aux[i++];
 }



void mergeSort_ordena (int *v, int esq, int dir){
    if (esq ==dir) return;

    int meio=(esq+dir)/2;
    mergeSort_ordena(v,esq,meio);
    mergeSort_ordena(v,meio+1,dir);
    merge(v,esq,meio,dir);
}

void printArray(int arr[], int n) {
  for (int i = 0; i < n; i++) {
    std::cout << arr[i] << " ";
  }
  std::cout << std::endl;
}

void mergeSort(int *v, int n){
        mergeSort_ordena (v,0,n-1);
}

int main() {
  int arr[] = {38,27,43,3,9,82,10};
  int n = sizeof(arr) / sizeof(arr[0]);

  std::cout << "Unsorted array: \n";
  printArray(arr, n);

  mergeSort(arr, n);

  std::cout << "Sorted array: \n";
  printArray(arr, n);

  return 0;
}