/*
 * Reto #29
 * ORDENA LA LISTA
 * Fecha publicación enunciado: 18/07/22
 * Fecha publicación resolución: 26/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que ordene y retorne una matriz de números.
 * - La función recibirá un listado (por ejemplo [2, 4, 6, 8, 9]) y un parámetro adicional
 *   "Asc" o "Desc" para indicar si debe ordenarse de menor a mayor o de mayor a menor.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 */
 
package folder;
import java.util.Random;

public class Reto29 {
    
    public static void main(String[] args){
        int[] arr1 = sortArray(randomArray(10, 10_000), SortType.MERGESORT, SortOrder.ASC);
        int[] arr2 = sortArray(randomArray(10, 10_000), SortType.QUICKSORT, SortOrder.DESC);
        System.out.println("Sorted Array with merge sort: ");
        printArray(arr1);
        System.out.println("Sorted Array with quick sort (descendant): ");
        printArray(arr2);
    }
    
    private static int[] sortArray(int[] array, SortType type, SortOrder order){
        System.out.println("Unsorted Array: ");
        printArray(array);
        int[] sortedArray;
        if(type == SortType.MERGESORT) sortedArray = mergeSort(array);
        else sortedArray = quicksort(array);
        
        if(order == SortOrder.DESC) reverseArray(array);
        return sortedArray;
    }
    
    //Merge sort
    private static int[] mergeSort(int[] list){
        int length = list.length;
        if(length < 2) return list;
        
        int midIndex = length / 2;
        int[] leftHalf = copyArray(list, 0, midIndex, midIndex, 0);
        int[] rightHalf = copyArray(list, midIndex, length, length - midIndex, midIndex);
        
        int[] leftSorted = mergeSort(leftHalf);
        int[] rightSorted = mergeSort(rightHalf);
        
        return merge(leftSorted, rightSorted);
    }
    
    private static int[] merge(int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int[] newList = new int[leftSize + rightSize];
        
        int i = 0, j = 0, k = 0;
        while(i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                newList[k] = leftHalf[i];
                i++;
            } else {
                newList[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        
        while(i < leftSize){
            newList[k] = leftHalf[i];
            i++;
            k++;
        }
        
        while(j < rightSize){
            newList[k] = rightHalf[j];
            j++;
            k++;
        }
        return newList;
    }
    
    //Quick sort
    private static int[] quicksort(int[] list){
        quicksort(list, 0, list.length - 1);
        return list;
    }
    
    private static void quicksort(int[] list, int lowIndex, int highIndex){
        if(lowIndex >= highIndex) return;
        
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = list[pivotIndex];
        swap(list, pivotIndex, highIndex);
        
        int leftPointer = partition(list, lowIndex, highIndex, pivot);
        
        quicksort(list, lowIndex, leftPointer - 1);
        quicksort(list, leftPointer + 1, highIndex);
    }
    
    private static int partition(int[] list, int lowIndex, int highIndex, int pivot){
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;
        while(leftPointer < rightPointer){
            while(list[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }

            while(list[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(list, leftPointer, rightPointer);
        }
        
        if(list[leftPointer] > list[highIndex]){
            swap(list, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }
        return leftPointer;
    }
    
    private static void swap(int[] list, int index1, int index2){
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
    
    private static int[] copyArray(int[] originalArray, int start, int end, int size, int offset){
        int[] newArray = new int[size];
        for (int i = start; i < end; i++) {
            newArray[i - offset] = originalArray[i];
        }
        return newArray;
    }
    
    private static int[] copyArray(int[] originalArray){
        return copyArray(originalArray, 0, originalArray.length, originalArray.length, 0);
    }
    
    private static int[] randomArray(int size, int maxRange){
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxRange) + 1;
        }
        return arr;
    }
    
    private static void reverseArray(int[] array){
        for (int i = 0, j = array.length - 1; i < array.length / 2; i++){
            swap(array, i, j);
            j--;
        }
    }
    
    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i != array.length - 1) System.out.print(", ");
            else System.out.println();
        }
    }
    
    enum SortType {
        MERGESORT, QUICKSORT;
    }
    
    enum SortOrder{
        ASC, DESC;
    }
}
