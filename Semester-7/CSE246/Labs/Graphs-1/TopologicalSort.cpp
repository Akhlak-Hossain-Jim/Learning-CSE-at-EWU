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

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void topologicalSort(int n, vector<pair<int, int>> &edges)
{
    // Adjacency list and in-degree array
    vector<vector<int>> adj(n);
    vector<int> inDegree(n, 0);

    // Build the graph
    for (auto &edge : edges)
    {
        int u = edge.first;
        int v = edge.second;
        adj[u].push_back(v);
        inDegree[v]++;
    }

    // Queue for vertices with in-degree 0
    queue<int> q;
    for (int i = 0; i < n; i++)
    {
        if (inDegree[i] == 0)
        {
            q.push(i);
        }
    }

    vector<int> topoOrder;

    // Process the vertices
    while (!q.empty())
    {
        int u = q.front();
        q.pop();
        topoOrder.push_back(u);

        // Reduce in-degree of neighbors
        for (int v : adj[u])
        {
            inDegree[v]--;
            if (inDegree[v] == 0)
            {
                q.push(v);
            }
        }
    }

    // Check for cycle
    if (topoOrder.size() != n)
    {
        cout << "The graph is not a DAG. Topological sort is not possible." << endl;
        return;
    }

    // Print the topological order
    for (int i = 0; i < topoOrder.size(); i++)
    {
        cout << topoOrder[i];
        if (i < topoOrder.size() - 1)
        {
            cout << ", ";
        }
    }
    cout << endl;
}

int main()
{
    int n, e;
    cout << "Enter the number of vertices: ";
    cin >> n;
    cout << "Enter the number of edges: ";
    cin >> e;

    vector<pair<int, int>> edges;
    cout << "Enter the edges (u v):" << endl;
    for (int i = 0; i < e; i++)
    {
        int u, v;
        cin >> u >> v;
        edges.emplace_back(u, v);
    }

    cout << "Topological Sort Order: ";
    topologicalSort(n, edges);

    return 0;
}
