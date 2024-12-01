#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main()
{
    pid_t pid, pid2;
    int inp;
    printf("Enter number of child process: ");
    scanf("%d", &inp);
    for (int i = 0; i < inp; i++)
    {
        pid = fork();

        if (pid == 0)
        {
            printf("Child process %d; pid = %d, with parent pid = %d\n", (i + 1), getpid(), getppid());
            return 0;
        }
        else if (pid < 0)
        {
            perror("Fork Failed\n");
            return 1;
        }
    }
    for (int i = 0; i < inp; i++)
    {
        wait(NULL);
    }
    if (pid > 0)
        printf("Parent process; pid = %d, All child processes finished\n", getpid());
    return 0;
}