#include <stdio.h>

void print_math(int a, int b){
    int sum = a + b;

    printf("Sum:     %d\n",sum);

    int product = a * b;

    printf("Product: %d\n",product);

}

void swap(int* a, int* b){
    int temp = *b;
    *b = *a;
    *a = temp;
}


void main(){

    int a = 0;
    int b = 0;

    printf("Enter value a: ");
    scanf("%d", &a);
    printf("Enter value b: ");
    scanf("%d", &b);

    print_math(a,b);

    printf("Before swap: x = %d, y = %d\n", a, b);
    swap(&a,&b);
    printf("After swap: x = %d, y = %d\n", a, b);

}
