package homework_two;

public class MyArrayDataException extends NumberFormatException{
    private int col;
    private int row;

    public MyArrayDataException(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void printError(){
        System.err.println("Неверное значение в ячейке (" +
                row + ";" +
                col + ")");
    }

}
