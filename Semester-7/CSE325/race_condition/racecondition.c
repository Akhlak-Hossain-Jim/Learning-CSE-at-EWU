#include <stdio.h>
#include <pthread.h>

int count = 0;
int inc = 20000;

void *increment(void *arg)
{
    for (int i = 0; i < inc; i++)
    {
        int temp = count;
        temp = temp + 1;
        count = temp;
    }
    return NULL;
}

int main()
{
    pthread_t thread1, thread2;

    printf("Initial value of count is:%d\n", count);

    pthread_create(&thread1, NULL, increment, NULL);
    pthread_create(&thread2, NULL, increment, NULL);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    printf("The final value of count is: %d\n", count);
    printf("The expected value of count is: %d\n", inc * 2);

    return 0;
}