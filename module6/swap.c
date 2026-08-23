#include <stdio.h>

void swap(int* a, int* b){
    int temp = *b;
    *b = *a;
    *a = temp;
}

void broken_Swap(int a, int b){
    int temp = b;
    b = a;
    a = temp;
}

void main(){

    int a = 15;
    int b = 30;

    printf("Before swap: x = %d, y = %d\n", a, b);
    swap(&a,&b);
    printf("After swap: x = %d, y = %d\n", a, b);

    printf("Before broken swap: x = %d, y = %d\n", a, b);
    broken_Swap(a,b);
    printf("After broken swap: x = %d, y = %d\n", a, b);

}