package src;

import java.util.Stack;

public class Board {
    char[][] board;

    public Board(int x, int y) {
        board = new char[x][y];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = ' ';
    }

    /**
     * @param ind the index of the row you want to search
     * @return a stack representing the values in the row
     */
    public Stack<Character> getRow(int ind) {
        if (ind < 0 || ind >= board.length)
            throw new IndexOutOfBoundsException();
        Stack<Character> row = new Stack<Character>();
        for (int i = 0; i < board[ind].length; i++)
            row.push(board[ind][i]);
        return row;
    }

    /**
     * @param ind the index of the column you want to search
     * @return a stack representing the values in the column
     */
    public Stack<Character> getColumn(int ind) {
        if (ind < 0 || ind >= board[0].length)
            throw new IndexOutOfBoundsException();
        Stack<Character> col = new Stack<Character>();
        for (int i = 0; i < board[0].length; i++)
            col.push(board[i][ind]);
        return col;
    }

    /**
     * @param x an x coord in the diagonal you want to search
     * @param y a y coord in the diagonal you want to search
     * @return a stack representing the values in the diagonal going forwards in the
     *         board (/, bottom left to top right)
     */
    public Stack<Character> getForwardDiagonal(int x, int y) {
        Stack<Character> diag = new Stack<Character>();

        // get top left coordinate
        int min = Math.min(x, y);
        x -= min;
        y -= min;

        // loop through forward diagonal
        while (x < board.length && y < board[0].length) {
            diag.push(board[x][y]);
            x++;
            y++;
        }

        return diag;
    }

    /**
     * @param x an x coord in the diagonal you want to search
     * @param y a y coord in the diagonal you want to search
     * @return a stack representing the values in the diagonal going backwards in the
     *         board (\, top left to bottom right)
     */
    public Stack<Character> getBackwardsDiagonal(int x, int y) {
        Stack<Character> diag = new Stack<Character>();

        // get top left coordinate
        int min = Math.min(x, y);
        x -= min;
        y -= min;

        // loop through forward diagonal
        while (x < board.length && y < board[0].length) {
            diag.push(board[x][y]);
            x++;
            y++;
        }

        return diag;
    }
    
    // overrided from Object, called in System.out.println()
    @Override
    public String toString() {
        String res = " -";
        // top
        for (int i = 0; i < board[0].length; i++)
            res += "----";
        res += "\n";
        // middle
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                res += " | " + board[i][j];
            }
            res += " |";
            res += "\n -";
            for (int j = 0; j < board[i].length; j++) {
                res += "----";
            }
            res += "\n";
        }
        return res;
    }
}
