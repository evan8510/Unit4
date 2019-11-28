package Lesson10.insertRemove;


public class InsertRemovePeople {

    static int logicalSize = 0;
   
    public static void main(String[] args) {
        Person peeps[] = new Person[10];
        peeps[0] = new Person("Andy", 45, "male");
        peeps[1] = new Person("Deb", 55, "female");
        peeps[2] = new Person("Mike", 17, "male");
        peeps[3] = new Person("Sue", 28, "female");
        logicalSize = 4;
        showPeeps(peeps);
        System.out.println("Inserting Joe, male Age 32");
        Person p = new Person("Joe", 32, "male");
        int loc = findInsertPoint(peeps, p);
        insert(peeps, p, loc);
        
        showPeeps(peeps);
        System.out.println("Inserting Leonard and Penny");
        p = new Person("Leonard", 38, "male");
        loc = findInsertPoint(peeps, p);
        insert(peeps, p, loc);
        p = new Person("Penny", 36, "female");
        loc = findInsertPoint(peeps, p);
        insert(peeps, p, loc);
        
        showPeeps(peeps);
        
        /////////////Testing Delete//////////////////
        System.out.println("Deleting Mike");
        loc = search(peeps, new Person("Mike"));
        if(delete(peeps, loc))
            System.out.println("Person was deleted");
        else
            System.out.println("Person was NOT deleted");
        showPeeps(peeps);
        
        System.out.println("Deleting Penny");
        loc = search(peeps, new Person("Penny"));
        if(delete(peeps, loc))
            System.out.println("Person was deleted");
        else
            System.out.println("Person was NOT deleted");
        showPeeps(peeps);
        
        System.out.println("Deleting Dylan");
        loc = search(peeps, new Person("Dylan"));
        if(delete(peeps, loc))
            System.out.println("Person was deleted");
        else
            System.out.println("Person was NOT deleted");
        showPeeps(peeps);
    }
    
    public static void showPeeps(Object arr[]){
        for (int i = 0; i < logicalSize; i++) {
            System.out.println(arr[i]);
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
