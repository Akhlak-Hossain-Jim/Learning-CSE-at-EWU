#include <iostream>
#include <vector>
#include <list>
#include <stack>

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

void print_stack(stack<int> q)
{
    stack<int> temp = q;
    while (!temp.empty())
    {
        cout << temp.top() << " ";
        temp.pop();
    }
    cout << '\n';
}

void DFS(Graph G, int v, int s)
{
    stack<int> st;
    bool Vis[v];
    for (int i = 0; i < v; i++)
    {
        Vis[i] = false;
    }
    vector<list<int>> aL = G.getAdjList();
    Vis[s] = true;
    // cout<<endl<<"before inqueue: ";
    // print_stack(q);
    st.push(s);
    cout << endl
         << "The traversed Graph(DFS): ";
    while (!st.empty())
    {
        // cout<<endl<<"before pop: ";
        // print_stack(q);
        int curr = st.top();
        st.pop();
        // cout<<endl<<"after pop: ";
        // print_stack(q);
        // cout <<endl<< " removing " << curr;
        cout << " " << curr;
        for (int ng : aL[curr])
        {
            // cout<<endl<<"***"<<ng<<"+++";
            if (!Vis[ng])
            {
                // cout<<endl<<"before push: ";
                // print_stack(q);
                st.push(ng);
                Vis[ng] = true;
                // cout<<endl<<"after push: ";
                // print_stack(q);
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

    DFS(graph, vertices, start);

    return 0;
}