# Fork()

The fork() system call is a key feature of Unix-based operating systems, used to create a new process by duplicating the calling process. This new process is called the **child process**, while the calling process becomes the **parent process**. Both processes execute independently but share the same code and resources initially.

## Key Details about fork():

1. **Return Values:**
   - In the Parent Process: fork() returns the PID (Process ID) of the child process.
   - In the Child Process: fork() returns 0.
   - On Failure: fork() returns -1, and no new process is created.
2. **Execution Flow:** After a successful fork(), both the parent and child processes execute the next instructions in the code independently. It's up to the developer to handle which process does what using the return value of fork().
3. Memory Sharing:

   - Initially, the parent and child processes share the same memory, but due to **copy-on-write (COW)**, changes made by one process do not affect the other. Each gets its own copy of the modified memory pages.

4. **File Descriptors:**
   - The child inherits the file descriptors of the parent. For example, if a file is open in the parent, the child can also access it.
5. **Process Identification:**
   - The getpid() function can be used to identify the process ID of the current process.
   - The getppid() function retrieves the parent process's ID.

## Example Program

```c
#include <stdio.h>
#include <unistd.h>
int main() {
pid_t pid;
pid = fork(); // Create a new process
if (pid < 0) {
// Fork failed
perror("fork failed");
return 1;
} else if (pid == 0) {
// Child process
printf("This is the child process. PID: %d, Parent PID: %d\n", getpid(), getppid());

} else {
// Parent process
printf("This is the parent process. PID: %d, Child PID: %d\n", getpid(), pid);
}
return 0;
}
```

## Sample Output

The output order depends on how the operating system schedules the processes:

```shell
This is the parent process. PID: 1234, Child PID: 1235
This is the child process. PID: 1235, Parent PID: 1234
```

## Practical Use Cases of fork():

1. **Process Creation:** Used to create multiple processes for parallel execution.
2. **Daemon Processes:** Helps in creating background processes or services.
3. **Implementation of exec():** After fork(), the child process can call an exec() family function to replace its code with a new program.
