#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

// input 1
// 7
// 9
// 0 1
// 0 4
// 1 4
// 4 5
// 1 3
// 5 6
// 3 6
// 3 2
// 6 2
// 4

// input 2
// 4
// 4
// 1 0
// 0 2
// 1 2
// 3 2
// 0

// inout 3
// 4
// 4
// 1 0
// 0 2
// 1 2
// 3 2

using namespace std;

void dfs(int u, unordered_map<int, vector<int>> &adj, vector<bool> &visited, vector<int> &discovery, vector<int> &finish, int &time, unordered_set<string> &edges)
{
    visited[u] = true;
    discovery[u] = ++time;

    for (int v : adj[u])
    {
        string edge = to_string(u) + "->" + to_string(v);
        if (!edges.count(edge))
        {
            edges.insert(edge);

            if (!visited[v])
            {
                cout << u << "->" << v << ": tree edge" << endl;
                dfs(v, adj, visited, discovery, finish, time, edges);
            }
            else if (discovery[v] < discovery[u] && finish[v] == -1)
            {
                cout << u << "->" << v << ": back edge" << endl;
            }
            else if (discovery[v] > discovery[u])
            {
                cout << u << "->" << v << ": forward edge" << endl;
            }
            else
            {
                cout << u << "->" << v << ": cross edge" << endl;
            }
        }
    }

    finish[u] = ++time;
}

int main()
{
    int n, e;
    cout << "Enter the number of vertices: ";
    cin >> n;
    cout << "Enter the number of edges: ";
    cin >> e;

    unordered_map<int, vector<int>> adj;
    cout << "Enter the edges (u v):" << endl;
    for (int i = 0; i < e; i++)
    {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u); // Undirected graph
    }

    vector<bool> visited(n, false);
    vector<int> discovery(n, -1);
    vector<int> finish(n, -1);
    unordered_set<string> edges;
    int time = -1;

    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
        {
            dfs(i, adj, visited, discovery, finish, time, edges);
        }
    }

    return 0;
}
