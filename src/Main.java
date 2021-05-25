import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        randomizeElements(arr);
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
//        findElement(arr, 20);
//        arr = addElement(arr, 20);
//        arr = deleteElement(arr, 30);
//        bubbleSort(arr);
//        selectSort(arr2);
        insertSort(arr3);
//        showArr(arr);
//        showArr(arr2);
//        showArr(arr3);
    }

    static void findElement(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println("Элемент массива: " + i);
            }
        }
    }

    static int[] addElement(int[] arr, int x) {
        int[] narr = new int[arr.length + 1];
        for (int i = 0; i < narr.length - 1; i++) {
            narr[i] = arr[i];
        }
        narr[narr.length - 1] = x;
        return narr;
    }

    static int[] deleteElement(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        int[] narr = new int[arr.length - count];
        int margin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                margin++;
                continue;
            } else {
                narr[i - margin] = arr[i];
            }
        }
        return narr;
    }

    static void randomizeElements(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = (int) (Math.random() * 100);
        }
    }

    static void bubbleSort(int[] arr) {
        long start = System.nanoTime();
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length - i; k++) {
                if (k >= arr.length - (i + 1)) {
                    break;
                }
                if (arr[k] >= arr[k + 1]) {
                    temp = arr[k + 1];
                    arr[k + 1] = arr[k];
                    arr[k] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Длительность сортировки пузырьком: " + (double) (end - start) / 1000000000 + " сек.");
    }

    static void selectSort(int[] arr) {
        long start = System.nanoTime();
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            temp = arr[i];
            for (int k = i; k < arr.length; k++) {
                if (k >= arr.length - 1) {
                    break;
                }
                if (temp > arr[k + 1]) {
                    temp = arr[k + 1];
                    arr[k + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Длительность сортировки выбором: " + (double) (end - start) / 1000000000 + " сек.");
    }

    static void insertSort(int[] arr) {
        long start = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            if (i >= arr.length - 1) {
                break;
            }
            if (arr[i] >= arr[i + 1]) {
                swapElements(arr, i, i + 1);
                if (i == 0)
                    continue;
                else {
                    for (int k = i; k > 0; k--) {
                        if (arr[k] <= arr[k - 1]) {
                            swapElements(arr, k, k - 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Длительность сортировки вставками: " + (double) (end - start) / 1000000000 + " сек.");
    }

    static void swapElements(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void showArr (int[] arr) {
        for (int i: arr) {
            System.out.print(i+", ");
        }
        System.out.println();
    }
}
