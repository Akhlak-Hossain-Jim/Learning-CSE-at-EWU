#include <iostream>
using namespace std;

// Function to check if the current cell is valid
bool isValidMove(int x, int y, int **maze, int **visited, int n)
{
    return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && visited[x][y] == 0);
}

// Function to print the current state of the matrix
void printMatrix(int **matrix, int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
    cout << "--------------------" << endl;
}

// Recursive function for backtracking
bool findPath(int x, int y, int **maze, int **visited, int **path, int n)
{
    // Base Case: If destination is reached
    if (x == n - 1 && y == n - 1)
    {
        path[x][y] = 1; // Mark the destination in the path
        return true;
    }

    // Check if the current move is valid
    if (isValidMove(x, y, maze, visited, n))
    {
        // Mark the current cell as part of the solution path
        visited[x][y] = 1;
        path[x][y] = 1;

        // Debugging: Print current state
        // cout << "Visiting (" << x << ", " << y << ")" << endl;
        // cout << "Visited State:" << endl;
        // printMatrix(visited, n);

        // cout << "Path State:" << endl;
        printMatrix(path, n);

        // Move right
        if (findPath(x, y + 1, maze, visited, path, n))
            return true;

        // Move down
        if (findPath(x + 1, y, maze, visited, path, n))
            return true;

        // Backtrack: Unmark the current cell
        path[x][y] = 0;
        visited[x][y] = 0;

        // Debugging: Print backtracking state
        // cout << "Backtracking from (" << x << ", " << y << ")" << endl;
        // cout << "Visited State after Backtracking:" << endl;
        // printMatrix(visited, n);

        // cout << "Path State after Backtracking:" << endl;
        // printMatrix(path, n);
    }

    return false;
}

int main()
{
    int n;
    cout << "Enter the size of the maze (N x N): ";
    cin >> n;

    // Dynamically allocate 2D arrays
    int **maze = new int *[n];
    int **visited = new int *[n];
    int **path = new int *[n];
    for (int i = 0; i < n; i++)
    {
        maze[i] = new int[n];
        visited[i] = new int[n]();
        path[i] = new int[n]();
    }

    cout << "Enter the maze matrix (0 for wall, 1 for path):" << endl;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> maze[i][j];
        }
    }

    if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
    {
        cout << "No Path Exists!" << endl;
    }
    else if (findPath(0, 0, maze, visited, path, n))
    {
        cout << "Solution Path:" << endl;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cout << path[i][j] << " ";
            }
            cout << endl;
        }
    }
    else
    {
        cout << "No Path Exists!" << endl;
    }

    // Deallocate memory
    for (int i = 0; i < n; i++)
    {
        delete[] maze[i];
        delete[] visited[i];
        delete[] path[i];
    }
    delete[] maze;
    delete[] visited;
    delete[] path;

    return 0;
}
