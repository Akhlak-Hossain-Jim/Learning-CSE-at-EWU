#include <iostream>
#include <vector>
#include <list>
#include <queue>

// input
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

using namespace std;

class Graph
{
private:
    int vertices;
    vector<list<int>> adjLists;

public:
    Graph(int v) : vertices(v)
    {
        adjLists.resize(v);
    }

    void addEdge(int src, int dest)
    {
        adjLists[src].push_back(dest);
        adjLists[dest].push_back(src);
    }

    vector<list<int>> getAdjList()
    {
        return adjLists;
    }

    void printGraph() const
    {
        for (int i = 0; i < vertices; i++)
        {
            cout << "Vertex " << i << ":";
            for (int neighbor : adjLists[i])
            {
                cout << " -> " << neighbor;
            }
            cout << endl;
        }
    }
};

void print_queue(queue<int> q)
{
    queue<int> temp = q;
    while (!temp.empty())
    {
        cout << temp.front() << " ";
        temp.pop();
    }
    cout << '\n';
}

void BFS(Graph G, int v, int s)
{
    queue<int> q;
    bool Vis[v];
    for (int i = 0; i < v; i++)
    {
        Vis[i] = false;
    }
    vector<list<int>> aL = G.getAdjList();
    Vis[s] = true;
    // cout<<endl<<"before inqueue: ";
    // print_queue(q);
    q.push(s);
    cout << endl
         << "The traversed Graph(BFS): ";
    while (!q.empty())
    {
        // cout<<endl<<"before pop: ";
        // print_queue(q);
        int curr = q.front();
        q.pop();
        // cout<<endl<<"after pop: ";
        // print_queue(q);
        // cout <<endl<< " removing " << curr;
        cout << " " << curr;
        for (int ng : aL[curr])
        {
            // cout<<endl<<"***"<<ng<<"+++";
            if (!Vis[ng])
            {
                // cout<<endl<<"before push: ";
                // print_queue(q);
                q.push(ng);
                Vis[ng] = true;
                // cout<<endl<<"after push: ";
                // print_queue(q);
            }
        }
    }
}

int main()
{
    int vertices, edges, start;

    cout << "Enter the number of vertices: ";
    cin >> vertices;

    if (vertices <= 0)
    {
        cout << "Number of vertices must be positive!" << endl;
        return 1;
    }

    Graph graph(vertices);

    cout << "Enter the number of edges: ";
    cin >> edges;

    cout << "Enter the edges (format: source destination):" << endl;
    for (int i = 0; i < edges; i++)
    {
        int src, dest;
        cin >> src >> dest;

        if (src >= vertices || dest >= vertices || src < 0 || dest < 0)
        {
            cout << "Invalid edge! Please enter vertices between 0 and " << vertices - 1 << "." << endl;
            i--;
        }
        else
        {
            graph.addEdge(src, dest);
        }
    }

    graph.printGraph();

    cout << "Enter the start vertice: ";
    cin >> start;

    BFS(graph, vertices, start);

    return 0;
}