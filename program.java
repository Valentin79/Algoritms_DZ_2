package program;

import java.util.Random;

public class program {
    private static final Random random = new Random();
    public program() {
    }

    public static void main(String[] args) {
        //int[] array = new int[]{2,5,7,1,8,4,0,3,5,2};
        int[] array = program.ArrayUtils.prepareArray();
        program.ArrayUtils.printArray(array);
        program.heapSort(array);
        program.ArrayUtils.printArray(array);
    }
    static class ArrayUtils {
        static int[] prepareArray() {
            int[] arr = new int[program.random.nextInt(15) + 5];

            for (int i = 0; i < arr.length; ++i) {
                arr[i] = program.random.nextInt(100);
            }

            return arr;
        }
        static void printArray(int[] arr) {
            int[] var1 = arr;
            int var2 = arr.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                int element = var1[var3];
                System.out.printf("%d\t", element);
            }

            System.out.println();
        }
    }

    private static void heapSort(int[] arr){
        // Построение кучи (перегрупировка массива)
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            heapyfy(arr, arr.length, i);
        }
        // Один за другим извлекаем элементы из кучи
        for(int i = arr.length - 1; i >= 0; i--){
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // вызываем процедуру на уменьшеной куче
            heapyfy(arr, i, 0);
        }
    }
    private static void heapyfy(int[] arr, int heapSize, int rootIndex){
        int largest = rootIndex; // инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый
        int rightChild = 2 * rootIndex + 2; // правый
        // если левый дочерний элемент больше корня
        if(leftChild < heapSize && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        // если правый дочерний элемент больше чем самый большой элемент
        if(rightChild < heapSize && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        // если самый большой элемент не корень
        if(largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;
            // преобразуем затронутое поддерево
            heapyfy(arr, heapSize, largest);
        }
    }
}
