#include <stdio.h>

void sjfScheduling(int n, int arrivalTime[], int burstTime[], int processID[]);
void fcfsScheduling(int n, int arrivalTime[], int burstTime[], int processID[]);

int main()
{
    int n;

    printf("Enter the number of processes: ");
    scanf("%d", &n);

    int arrivalTime[n], burstTime[n], processID[n];

    printf("Enter the Arrival Time and Burst Time for each process:\n");
    for (int i = 0; i < n; i++)
    {
        printf("Process %d Arrival Time: ", i + 1);
        scanf("%d", &arrivalTime[i]);
        printf("Process %d Burst Time: ", i + 1);
        scanf("%d", &burstTime[i]);
        processID[i] = i + 1;
    }

    sjfScheduling(n, arrivalTime, burstTime, processID);
    fcfsScheduling(n, arrivalTime, burstTime, processID);

    return 0;
}

void sjfScheduling(int n, int arrivalTime[], int burstTime[], int processID[])
{
    int completionTime[n], waitingTime[n], turnaroundTime[n];
    int i, j;

    for (i = 0; i < n - 1; i++)
    {
        for (j = 0; j < n - i - 1; j++)
        {
            if (burstTime[j] > burstTime[j + 1])
            {

                int temp = burstTime[j];
                burstTime[j] = burstTime[j + 1];
                burstTime[j + 1] = temp;

                temp = processID[j];
                processID[j] = processID[j + 1];
                processID[j + 1] = temp;
            }
        }
    }

    int currentTime = 0;

    for (i = 0; i < n; i++)
    {
        if (currentTime < 0)
        {
            currentTime = 0;
        }
        currentTime += burstTime[i];
        completionTime[i] = currentTime;
        turnaroundTime[i] = completionTime[i];
        waitingTime[i] = turnaroundTime[i] - burstTime[i];
    }

    printf("\nSJF Scheduling Results:\n");
    printf("PID\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time\n");

    for (i = 0; i < n; i++)
    {
        printf("%d\t%d\t%d\t\t%d\t\t%d\t\t%d\n",
               processID[i],
               arrivalTime[i],
               burstTime[i],
               completionTime[i],
               turnaroundTime[i],
               waitingTime[i]);
    }

    printf("\nGantt Chart:\n");

    printf("|");
    for (i = 0; i < n; i++)
    {
        printf(" P%d |", processID[i]);
    }
    printf("\n");

    int time = 0;
    printf("%d", time);
    for (i = 0; i < n; i++)
    {
        time += burstTime[i];
        printf("    %d", time);
    }
    printf("\n");
}

// Function to perform FCFS Scheduling
void fcfsScheduling(int n, int arrivalTime[], int burstTime[], int processID[])
{
    int completionTime[n], waitingTime[n], turnaroundTime[n];
    int currentTime = 0;

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (arrivalTime[j] > arrivalTime[j + 1])
            {

                int temp = arrivalTime[j];
                arrivalTime[j] = arrivalTime[j + 1];
                arrivalTime[j + 1] = temp;

                temp = burstTime[j];
                burstTime[j] = burstTime[j + 1];
                burstTime[j + 1] = temp;

                temp = processID[j];
                processID[j] = processID[j + 1];
                processID[j + 1] = temp;
            }
        }
    }

    for (int i = 0; i < n; i++)
    {
        if (currentTime < arrivalTime[i])
        {
            currentTime = arrivalTime[i];
        }
        currentTime += burstTime[i];
        completionTime[i] = currentTime;
        turnaroundTime[i] = completionTime[i] - arrivalTime[i];
        waitingTime[i] = turnaroundTime[i] - burstTime[i];
    }

    printf("\nFCFS Scheduling Results:\n");
    printf("PID\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time\n");

    for (int i = 0; i < n; i++)
    {
        printf("%d\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",
               processID[i],
               arrivalTime[i],
               burstTime[i],
               completionTime[i],
               turnaroundTime[i],
               waitingTime[i]);
    }

    printf("\nGantt Chart:\n");

    printf("|");
    for (int i = 0; i < n; i++)
    {
        printf(" P%d |", processID[i]);
    }
    printf("\n");

    int time = 0;
    printf("%d", time);
    for (int i = 0; i < n; i++)
    {
        if (time < arrivalTime[i])
        {
            time = arrivalTime[i];
        }
        time += burstTime[i];
        printf("    %d", time);
    }
    printf("\n");
}
