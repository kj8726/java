#include <bits/stdc++.h>
using namespace std;

int board[8][8];
int n;

// Function to print the board
void printSolution(int board[8][8]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cout << board[i][j] << " ";
        cout << endl;
    }
}

// Check if a queen can be placed at board[row][col]
bool isPossible(int row, int col, int slashDiagonal[8][8], int backSlashDiagonal[8][8],
                bool rowLookup[], bool slashDiagonalLookup[], bool backSlashDiagonalLookup[]) {

    if (slashDiagonalLookup[slashDiagonal[row][col]] ||
        backSlashDiagonalLookup[backSlashDiagonal[row][col]] ||
        rowLookup[row])
        return false;

    return true;
}

// Recursive utility to solve N Queens problem
bool solveNQueensUtil(int col, int slashDiagonal[8][8], int backSlashDiagonal[8][8],
                      bool rowLookup[], bool slashDiagonalLookup[], bool backSlashDiagonalLookup[]) {
    if (col >= n)
        return true;

    for (int i = 0; i < n; i++) {
        if (isPossible(i, col, slashDiagonal, backSlashDiagonal,
                       rowLookup, slashDiagonalLookup, backSlashDiagonalLookup)) {

            board[i][col] = 1;
            rowLookup[i] = true;
            slashDiagonalLookup[slashDiagonal[i][col]] = true;
            backSlashDiagonalLookup[backSlashDiagonal[i][col]] = true;

            if (solveNQueensUtil(col + 1, slashDiagonal, backSlashDiagonal,
                                 rowLookup, slashDiagonalLookup, backSlashDiagonalLookup))
                return true;

            // Backtrack
            board[i][col] = 0;
            rowLookup[i] = false;
            slashDiagonalLookup[slashDiagonal[i][col]] = false;
            backSlashDiagonalLookup[backSlashDiagonal[i][col]] = false;
        }
    }
    return false;
}

// Main function to solve N Queens using Branch and Bound
bool solveNQueens(int n) {
    memset(board, 0, sizeof(board));

    int slashDiagonal[8][8];
    int backSlashDiagonal[8][8];

    bool rowLookup[8] = {false};
    bool slashDiagonalLookup[2 * 8 - 1] = {false};
    bool backSlashDiagonalLookup[2 * 8 - 1] = {false};

    // Initialize diagonals
    for (int r = 0; r < n; r++)
        for (int c = 0; c < n; c++) {
            slashDiagonal[r][c] = r + c;
            backSlashDiagonal[r][c] = r - c + (n - 1);  // to make index non-negative
        }

    if (!solveNQueensUtil(0, slashDiagonal, backSlashDiagonal,
                          rowLookup, slashDiagonalLookup, backSlashDiagonalLookup)) {
        cout << "No solution\n";
        return false;
    }

    printSolution(board);
    return true;
}

int main() {
    cout << "Enter N (0 to 8): ";
    cin >> n;

    if (n < 1 || n > 8) {
        cout << "Invalid input. N should be between 1 and 8.\n";
        return 0;
    }

    solveNQueens(n);
    return 0;
}
