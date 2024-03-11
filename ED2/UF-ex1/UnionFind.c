#include <stdio.h>
#include <stdlib.h>

typedef struct
{
  int *id;
  int count;
  int n;
} UF;

UF *init_UF(int n);
int count_UF(UF *uf);
int connected_UF(UF *uf, int p, int q);
int find_UF(UF *uf, int p);
void union_UF(UF *uf, int p, int q);

UF *init_UF(int n)
{
  int i;
  UF *uf;

  uf = malloc(sizeof(UF));

  uf->id = malloc(sizeof(int) * n);
  uf->n = n;
  uf->count = n;
  for (i = 0; i < uf->count; ++i)
  {
    uf->id[i] = i;
  }

  return (uf);
}

int count_UF(UF *uf)
{
  return (uf->count);
}

int connected_UF(UF *uf, int p, int q)
{
  return (find_UF(uf, p) == find_UF(uf, q));
}

int find_UF(UF *uf, int p)
{
  return (uf->id[p]);
}

void union_UF(UF *uf, int p, int q)
{
  uf->count--;
  int h, base1 = uf->id[p], base2 = uf->id[q];

  if (base1 < base2)
  {
    if (base1 >= 0)
      uf->id[p] = -base1;
    uf->id[q] = uf->id[p];
  }
  else
  {
    if (base2 >= 0)
      uf->id[q] = -base2;
    uf->id[p] = uf->id[q];
  }

  if (base1 < 0 && base2 < 0)
  {
    for (h = 0; h < uf->n; ++h)
    {
      if (uf->id[h] == base2)
        uf->id[h] = base1;
    }
  }

  return;
}

int main()
{
  int n, p, q, i, k;
  UF *uf;
  
  scanf("%d", &n);
  int result[n][2];
  
  uf = init_UF(n);

  scanf("%d %d", &p, &q);
  while (p > -1 && q > -1)
  {

    if (!connected_UF(uf, p, q))
    {
    result[i][0]=p;
    result[i][1]=q;
    i++;
      union_UF(uf, p, q);
    }
    scanf("%d %d", &p, &q);
  }

  for (int j=0;j<n;j++){
    for (int k=0;k<2;k++){ 
        if (!(result[j][0]==0 && result[j][1]==0)){
            printf("%d ",result[j][k]);}
  }printf("\n");}
  
  printf("%d components\n", uf->count);
}