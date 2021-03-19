package homework_two;

public class MyArraySizeException extends Exception{

    public MyArraySizeException(String message) {
        super(message);
        System.err.println(message);
    }
}
