# Clone Graph

https://leetcode.com/problems/clone-graph/

https://youtu.be/mQeF6bN8hMk

### Algorithm
Graph DFS (adjacency list)

1) We create a copy of the first node and store it in the map
2) We recursively create copies of all the neighbors of the node and add them to a new node (we check if the map to see if the node was already cloned).