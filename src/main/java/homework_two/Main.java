package homework_two;

public class Main {

    public static void main(String[] args) {

        int sum = 0;
        String array[][] = new String[4][8];
        try{
            sum = sumArrayElements(array);
        }catch (MyArraySizeException e){
            //e.printStackTrace();
        }

        array = new String[8][4];
        try{
            sum = sumArrayElements(array);
        }catch (MyArraySizeException e){
            //e.printStackTrace();
        }

        array = new String[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = String.valueOf(i + j);
            }
        }

        array[2][1] = "abracadabra";
        try{
            sum = sumArrayElements(array);
        }catch (MyArraySizeException e){
            //e.printStackTrace();
        }catch(MyArrayDataException e){
            e.printError();
            //e.printStackTrace();
        }
        System.out.println(sum);
    }

    public static int sumArrayElements(String array[][]) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;

        if(array.length != 4){
            throw new MyArraySizeException("Размер массива не равен 4");
        }
        
        for(String subarray[]:array){
            if (subarray.length != 4){
                throw new MyArraySizeException("Размер массива не равен 4");
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }catch (Exception e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

}
