# Graph Algorithms

## 1. Breadth-First Search (BFS)

You are given an unweighted and undirected graph as input. Your task is to perform a Breadth-First Search (BFS) traversal of the graph, starting from the given vertex, and output the order in which the vertices are visited.

## 2. Depth-First Search (DFS)

You are given an unweighted and undirected graph as input. Your task is to perform a Depth-First Search (DFS) traversal of the graph, starting from the given vertex, and output the order in which the vertices are visited.

### Sample Input

```shell
4
4
1 0
0 2
1 2
3 2
Starting node: 0
```

### Sample Output

```shell
0, 2, 1, 3
```

## 3. Edge Classification

You are given an unweighted and undirected graph as input. Your task is to classify every edge of the graph as tree, back, forward, and cross edge depending on their type using DFS algorithms.

### Sample Input

```shell
4
4
1 0
0 2
1 2
3 2
```

### Sample Output

```shell
0->1: tree edge
1->2: tree edge
2->3: tree edge
2->0: back edge
```

## 4. Topological Sort

You are given a directed acyclic graph (DAG) as input. Your task is to perform a topological sort of the vertices in the graph and output the order in which the vertices should be processed.

### Sample Input

```shell
4
4
1 0
0 2
1 2
3 2
```

### Sample Output

```shell
1, 2, 0, 3
```
