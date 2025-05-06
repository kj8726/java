#include <stdio.h>
#include <stdbool.h>

#define N 4

// Function to print the solution
void printSolution(int board[N][N]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++)
            printf(" %d ", board[i][j]);
        printf("\n");
    }
}

// A utility function to check if a queen can be placed on board[row][col]
bool isSafe(int board[N][N], int row, int col) {
    int i, j;

    // Check this row on left side
    for (i = 0; i < col; i++)
        if (board[row][i])
            return false;

    // Check upper diagonal on left side
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
        if (board[i][j])
            return false;

    // Check lower diagonal on left side
    for (i = row, j = col; j >= 0 && i < N; i++, j--)
        if (board[i][j])
            return false;

    return true;
}

// A recursive utility function to solve N Queen problem
bool solveNQUtil(int board[N][N], int col) {
    // Base case: If all queens are placed
    if (col >= N)
        return true;

    // Consider this column and try placing the queen in all rows
    for (int i = 0; i < N; i++) {
        if (isSafe(board, i, col)) {
            board[i][col] = 1;

            // Recur to place rest of the queens
            if (solveNQUtil(board, col + 1))
                return true;

            // BACKTRACK
            board[i][col] = 0;
        }
    }

    // If the queen cannot be placed in any row in this column
    return false;
}

// This function solves the N Queen problem using Backtracking
bool solveNQ() {
    int board[N][N] = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };

    if (solveNQUtil(board, 0) == false) {
        printf("Solution does not exist\n");
        return false;
    }

    printSolution(board);
    return true;
}

// Driver code
int main() {
    solveNQ();
    return 0;
}
