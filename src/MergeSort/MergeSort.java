package MergeSort;

public class MergeSort {
	private int[] array;
    private int[] tempMergArr;
    private static int[] array2;
    private static int[] tempMergArr2;
    private int length;
 
//    public static void main(String a[]){
//         
//        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
//        MergeSort mms = new MergeSort();
//        mms.sort(inputArr);
//        for(int i:inputArr){
//            System.out.print(i);
//            System.out.print(" ");
//        }
//    }
     
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

private  void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
    public static void main(String a[]){
        
        array2 = new int[]{25, 24};
        tempMergArr2 = new int[array2.length];
        mergeParts1(0,1,array2.length-1);

        for(int i:tempMergArr2){
            System.out.print(i);
            System.out.print(" ");
        }
    }
    
    private static void mergeParts1(int lowerIndex, int middle, int higherIndex) {
    	 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr2[i] = array2[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr2[i] <= tempMergArr2[j]) {
                array2[k] = tempMergArr2[i];
                i++;
            } else {
                array2[k] = tempMergArr2[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array2[k] = tempMergArr2[i];
            k++;
            i++;
        }
 
    }

}
