INF = 9999999
# Number of vertices in the graph
N = 5

# Creating graph using adjacency matrix method
G = [
    [0, 19, 5, 0, 0],
    [19, 0, 5, 9, 2],
    [5, 5, 0, 1, 6],
    [0, 9, 1, 0, 1],
    [0, 2, 6, 1, 0]
]

# Array to track selected vertices
selected_node = [False] * N
# Number of edges in MST
no_edge = 0

# Select the first node (index 0)
selected_node[0] = True

# Printing the MST edges and their weights
print("Edge : Weight")

while no_edge < N - 1:
    minimum = INF
    a = 0
    b = 0

    for m in range(N):
        if selected_node[m]:
            for n in range(N):
                if (not selected_node[n]) and G[m][n]:
                    if minimum > G[m][n]:
                        minimum = G[m][n]
                        a = m
                        b = n
                        
    print(f"{a}-{b} : {G[a][b]}")
    selected_node[b] = True
    no_edge += 1
