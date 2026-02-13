package Sem_2_Data_and_functions;

import java.util.Arrays;

/**
 * Написат функцию добавления элемента в конец массива
 * т.о., чтобы она расширяла массив при необходимости
 */
public class Task_1 {
    static void main() {
        int [] arr = {1,2,3,4,5,6};
        int num = 7;
        int index = 6;
        int [] resultArr1 = AddLast(arr, num);
        int [] resultArr2 = AddIndex(arr, num, index);
        //System.out.println("Исходный массив " + Arrays.toString(arr));
        //System.out.println("Итоговый массив c " + num + " в конце " + Arrays.toString(resultArr1));
        System.out.println("Итоговый массив с " + num + " вторым по счету "  + Arrays.toString(resultArr2));

    }
    public static int [] AddLast(int [] arr, int num) {
        int[] tmpArr = new int [arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tmpArr[i] = arr[i];
        }
        tmpArr[arr.length] =num;
        return tmpArr;
    }

    public static int [] AddIndex(int [] arr, int num, int index) {
        if (! (index >=0 && index <= arr.length)) {
            System.out.println("Индекс за пределами массива");
            return null;
        } else if (index == arr.length) {
             return AddLast(arr,num);
        } else {
            int[] tmpArr = new int [arr.length + 1];
            int tmp = 0;
            for (int i = 0; i <arr.length + 1; i++) {
                if (i == index) {
                    tmpArr[i] = num;
                    tmp++;
                } else {
                    tmpArr[i] = arr[i - tmp];
                }
            }
            return tmpArr;
        }
    }
}
