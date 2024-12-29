#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

sem_t semaphore;

int count = 0;
int slp = 5;
int inc = 20000000;

void *increment(void *arg)
{
    sem_wait(&semaphore);
    printf("The initial count: %d; before Entering thread %ld\n", count, (long)arg);
    for (int i = 0; i < inc; i++)
    {
        int temp = count;
        temp = temp + 1;
        count = temp;
    }
    sleep(slp);
    printf("The final count: %d; before leaving thread %ld\n", count, (long)arg);
    sem_post(&semaphore);
    return NULL;
}

int main()
{
    pthread_t thread1, thread2, thread3;

    sem_init(&semaphore, 0, 1);

    printf("Initial value of count is:%d\n\n", count);

    pthread_create(&thread1, NULL, increment, (void *)1);
    pthread_create(&thread2, NULL, increment, (void *)2);
    pthread_create(&thread3, NULL, increment, (void *)3);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);
    pthread_join(thread3, NULL);

    printf("\n\nThe final value of count is: %d\n", count);
    printf("The expected value of count is: %d\n", inc * 3);

    sem_destroy(&semaphore);

    return 0;
}