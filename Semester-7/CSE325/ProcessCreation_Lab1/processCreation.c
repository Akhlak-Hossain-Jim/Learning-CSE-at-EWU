#include <stdio.h>
#include <unistd.h>
int main()
{
    pid_t pid;
    pid = fork(); // Create a new process
    if (pid < 0)
    {
        // Fork failed
        perror("fork failed");
        return 1;
    }
    else if (pid == 0)
    {
        // Child process
        printf("This is the child process. PID: %d, Parent PID: %d\n", getpid(), getppid());
    }
    else
    {
        // Parent process
        printf("This is the parent process. PID: %d, Child PID: %d\n", getpid(), pid);
    }
    return 0;
}