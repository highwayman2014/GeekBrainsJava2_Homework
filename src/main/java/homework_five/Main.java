package homework_five;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        simpleFill();
        fillByThreads(3);
    }

    static void simpleFill(){

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - startTime);

    }

    static void fillByThreads(int countThreads){

        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        List<float[]> arrays = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        int out = SIZE % countThreads;
        int sourcePos = 0;
        for (int i = 0; i < countThreads; i++) {

            int h = SIZE / countThreads;
            if (i == countThreads - 1){
                h+=out;
            }
            float[] arr1 = new float[h];
            System.arraycopy(arr, sourcePos, arr1, 0, h);
            sourcePos+=h;

            Thread t1 = new Thread(()->{
                fillSubArray(arr1, arrays);
            });
            t1.start();
            threads.add(t1);
        }

        for(Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int destPos = 0;
        for (int i = 0; i < arrays.size(); i++) {

            int h = SIZE / countThreads;
            if (i == countThreads - 1){
                h+=out;
            }
            System.arraycopy(arrays.get(i), 0, arr, destPos, h);
            destPos+=h;
        }

        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(arr.length + " " + arr[0]);
    }

    static void fillSubArray(float[]arr, List<float[]> arrays){
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (float)(arr[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        arrays.add(arr);
    }


}
