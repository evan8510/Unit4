package Lesson10.insertRemove;

public class InsertRemoveFruit {

    static int logicalSize = 0;

    public static void main(String[] args) {
        String fruits[] = new String[10];
        fruits[0] = "Apple";
        fruits[1] = "Kiwi";
        fruits[2] = "Orange";
        fruits[3] = "Strawberry";
        logicalSize = 4;
        showFruit(fruits);
        System.out.println("Inserting Banana");
        int loc  = findInsertPoint(fruits, "Banana");
        insert(fruits, "Banana", loc);
        showFruit(fruits);
        System.out.println("Inserting Pear");
        insert(fruits, "Pear", findInsertPoint(fruits, "Pear"));
        showFruit(fruits);
        System.out.println("Inserting Lemon");
        insert(fruits, "Lemon", findInsertPoint(fruits, "Lemon"));
        showFruit(fruits);
        //////////////TESTING DELETE///////////////////////////////////
        System.out.println("Deleting Kiwi");
        loc = search(fruits, "Kiwi");
        if(delete(fruits,loc))
            System.out.println("Deleted successfully");
        else
            System.out.println("Could not delete");
        showFruit(fruits);
        
        System.out.println("Deleting Tomato");
        loc = search(fruits, "Tomato");
        if(delete(fruits,loc))
            System.out.println("Deleted successfully");
        else
            System.out.println("Could not delete");
        showFruit(fruits);
        
        System.out.println("Deleting Orange");
        if(delete(fruits, search(fruits, "Orange")))
            System.out.println("Deleted successfully");
        else
            System.out.println("Could not delete");
        showFruit(fruits);
    }
    
    public static void showFruit(String arr[]){
        for (int i = 0; i < logicalSize; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\n-------------------------------------------------------------------------\n");
    }

    
    
    ///////////////////////This is a BINARY search/////////
    //We call this FIRST to find the location to be deleted
    public static int search(Object[] a, Object searchValue) {
        int left = 0;
        int right = logicalSize - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a[midpoint]).compareTo(searchValue);
            if (result == 0) {
                return midpoint;
            } else if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return -1;

    }
    //Call search first, sent the location you get back into this delete method
    //this shifts item up by 1, starting at delete location + 1      //////////
    ///////////////////////////////////////////////////////////////////////////
    public static boolean delete(Object array[], int targetIndex) {
        if (targetIndex < 0 || targetIndex >= logicalSize) {
            return false;
        }

        // Shift items up by one position
        for (int i = targetIndex; i < logicalSize - 1; i++) {
            array[i] = array[i + 1];
        }

        // Decrement logical size and return true 
        logicalSize--;
        return true;
    }

    ///////////////////////////////////////////////////////////////////////////
    //Call this just before inserting - it returns location where new item goes
    //similar to binary search, except we are looking for location of NEW item
    public static int findInsertPoint(Object a[], Object searchValue) {
        int left = 0;
        int right = logicalSize - 1;
        int midpoint = 0;

        while (left <= right) {
            midpoint = (left + right) / 2;

            int result = ((Comparable) a[midpoint]).compareTo(searchValue);

            if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        if (((Comparable) a[midpoint]).compareTo(searchValue) < 0) {
            midpoint++;
        }
        return midpoint;
    }

//////////////////////////////////////////////////////////////////////////////////
    //Call this after findInsertPoint, sending in location we found
    //this starts at bottom and shifts each thing DOWN until we get to insertPoint
    
    public static boolean insert(Object array[], Object newItem, int targetIndex) {
        // Check for a full array and return false if full
        if (logicalSize == array.length) {
            return false;
        }
        // Check for valid target index or return false 
        if (targetIndex < 0 || targetIndex > logicalSize) {
            return false;
        }
        // Shift items down by one position
        for (int i = logicalSize; i > targetIndex; i--) {
            array[i] = array[i - 1];
        }
        // Add new item, increment logical size,return true                       
        array[targetIndex] = newItem;
        logicalSize++;
        return true;
    }

}
