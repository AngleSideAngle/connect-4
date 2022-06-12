package src;

public abstract class Player {
    private char name;
    private int lastRow;
    private int lastCol;

    public Player(char name) {
        this.name = name;
        this.lastRow = 0;
        this.lastCol = 0;
    }

    public char getName() {
        return name;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }
    
    public abstract void move(Board board);

}
