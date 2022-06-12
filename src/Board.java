package src;

import java.util.Stack;

public class Board {
    private char[][] board;

    public Board(int x, int y) {
        board = new char[x][y];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = ' ';
    }

    /**
     * adds a character to the board
     * this method does nothing if there is no space
     * @param c the character to add
     * @param col the column to add it to
     * @return the row it was added to
     */
    public int add(char c, int col) {
        int row = board.length - 1;
        while (row >= 0 && board[row][col] != ' ')
            row--;
        if (row < 0)
            return 0;
        board[row][col] = c;
        return row;
    }

    /**
     * @param row
     * @param col
     * @return the winning character, ' ' if no winner
     */
    public char checkWin(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            throw new IndexOutOfBoundsException();
        int repeat = 0;
        char last = ' ';
        Stack<Character> vals = new Stack<Character>();
        vals.addAll(getRow(row));
        vals.push(' ');
        vals.addAll(getColumn(col));
        vals.push(' ');
        vals.addAll(getForwardDiagonal(row, col));
        vals.push(' ');
        vals.addAll(getBackwardsDiagonal(row, col));
        while(!vals.isEmpty()) {
            if (vals.peek() == last)
                repeat++;
            else
                repeat = 1;
            last = vals.pop();
            if (repeat >= 4 && last != ' ')
                return last;
        }
        return ' ';
    }

    /**
     * @param ind the index of the row you want to search
     * @return a stack representing the values in the row
     */
    public Stack<Character> getRow(int ind) {
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
        Stack<Character> col = new Stack<Character>();
        for (int i = 0; i < board.length; i++)
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

    public char[][] getBoard() {
        return board;
    }
    
    // overrided from Object, called in System.out.println()
    @Override
    public String toString() {
        String res = "\n -";
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
