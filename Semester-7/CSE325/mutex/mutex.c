#include <stdio.h>
#include <pthread.h>

int count = 0;
int inc = 2000000;
pthread_mutex_t lock;

void *increment(void *arg)
{
    for (int i = 0; i < inc; i++)
    {
        pthread_mutex_lock(&lock);
        count++;
        pthread_mutex_unlock(&lock);
    }
    return NULL;
}

int main()
{
    pthread_t thread1, thread2;

    pthread_mutex_init(&lock, NULL);

    printf("Initial value of count is:%d\n", count);

    pthread_create(&thread1, NULL, increment, NULL);
    pthread_create(&thread2, NULL, increment, NULL);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    pthread_mutex_destroy(&lock);

    printf("The final value of count is: %d\n", count);
    printf("The expected value of count is: %d\n", inc * 2);

    return 0;
}