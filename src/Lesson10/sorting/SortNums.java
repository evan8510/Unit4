package Lesson10.sorting;

public class SortNums {

    public static void main(String[] args) {
        int nums[] = new int[100];

        for (int i = 0; i < 100; i++) {
            nums[i] = (int) (Math.random() * 1000) + 1;
            System.out.print(nums[i] + ", ");
            if (i == 25 || i == 50 || i == 75) {
                System.out.println("");
            }
        }
        /* selectionSort(nums);
        System.out.println("\nSELECTION SORT\n=========");
        for (int i = 0; i < 100; i++) {
            System.out.print(nums[i] + ", ");
            if (i == 25 || i == 50 || i == 75) {
                System.out.println("");
            }
        } */
        //insertionSort(nums);
        mergeSort(nums);
        System.out.println("\nINSERTION SORT\n=========");
        for (int i = 0; i < 100; i++) {
            System.out.print(nums[i] + ", ");
            if (i == 25 || i == 50 || i == 75) {
                System.out.println("");
            }
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = findMinimum(a, i);
            if (minIndex != i) //if lowest is not already in place
            {
                swap(a, i, minIndex);
            }
        } //end for
    }

    public static int findMinimum(int[] a, int first) {
        //first=where to start looking from
        //assume first is also the smallest for now
        int minIndex = first;
        for (int i = first + 1; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    ////////////////////////////////////////////
    public static void bubbleSort(int[] a) {
        int k = 0;
        boolean exchangeMade = true;
        // Make up to n - 1 passes through array, exit 
        //early if no exchanges are made on previous pass

        while ((k < a.length - 1) && exchangeMade) {
            exchangeMade = false;
            k++;
            for (int j = 0; j < a.length - k; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    exchangeMade = true;
                }//end if
            }//end for
        }//end while
    }
    /////////////////////////////////////////////////////////////

    public static void insertionSort(int a[]) {
        int itemToInsert, j;
        boolean stillLooking;

        //on the kth pass, pass item k upwards in list
        //and insert it in its proper place amoung the
        //first k entries in an array
        for (int k = 1; k < a.length; k++) {
            //move backwards through list, looking for
            //the right place to insert a[k];
            itemToInsert = a[k];
            j = k - 1;
            stillLooking = true;
            while (j >= 0 && stillLooking) {
                if (itemToInsert < a[j]) {
                    //move item higher
                    a[j + 1] = a[j];
                    j--;
                } else {
                    //we have found new home for a[k];
                    stillLooking = false;
                }//end else// j+1 is where the item goes
                a[j + 1] = itemToInsert;
            }//end while
        }//end for
    }//end method
    
    public static void mergeSort(int arr[]){
        int size = arr.length;
        if(size<2) return;
        int mid = size/2;
        int left[] = new int[mid];
        int right[] = new int[size - mid];
        
        for(int i = 0; i<mid; i++){
            left[i] = arr[i];
        }
        
        for(int i = mid; i < size; i ++){
            right[i-mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        
        merge(arr, left, right, mid, size-mid);
        
        
    }
    
    public static void merge(int[] a, int[] l, int r[], int left, int right){
        int i = 0, j = 0, k = 0;
        
        while(i<left && j<right){
            if(l[i] <= r[j])
                a[k++] = l[i++];
            else a[k++] = r[j++];
        }
        while(i<left){
            a[k++] = l[i++];
        }
        while(j<right){
            a[k++] = r[j++];
        }
    }
    
}
