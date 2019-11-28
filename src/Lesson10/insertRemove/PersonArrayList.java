
package Lesson10.insertRemove;

import java.util.ArrayList;

public class PersonArrayList {

    
    public static void main(String[] args) {
        ArrayList<Person> peeps = new ArrayList();
        /*
        .add(item)          - adds item to bottom of arraylist
        .add(loc, item)     - adds item at given location
        .get(loc)           - gets a COPY of item at given location
        .remove(loc)        - remove at a location
        .remove(item)       - remove by item
        .set(loc, new item) - replaces item at location with a new item
        .size()             - how many items we have
        */
        peeps.add(new Person("Andy", 45, "male"));
        peeps.add(new Person("Deb", 55, "female"));
        peeps.add(new Person("Mike", 17, "male"));
        peeps.add(new Person("Sue", 28, "female"));
        
        showPeeps(peeps);
        
        System.out.println("Inserting Joe, male Age 32");
        Person p = new Person("Joe", 32, "male");
        int loc = findInsertPoint(peeps, p);
        peeps.add(loc, p);
        
        showPeeps(peeps);
        
        System.out.println("Deleting Mike");
        loc = search(peeps, new Person("Mike"));
        peeps.remove(loc);
        showPeeps(peeps);
        
    }
    
    public static void showPeeps(ArrayList a){
        //for (int i = 0; i < a.size(); i++) {
        //    System.out.println(a.get(i));
        //}
        for (Object p : a) {
            System.out.println(p);
        }
        System.out.println("----------------------------------");
    }
    
    public static int findInsertPoint(ArrayList a, Object searchValue) {
        int left = 0;
        int right = a.size() - 1;
        int midpoint = 0;

        while (left <= right) {
            midpoint = (left + right) / 2;

            int result = ((Comparable) a.get(midpoint)).compareTo(searchValue);

            if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        if (((Comparable) a.get(midpoint)).compareTo(searchValue) < 0) {
            midpoint++;
        }
        return midpoint;
    }
    
    public static int search(ArrayList a, Object searchValue) {
        int left = 0;
        int right = a.size() - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a.get(midpoint)).compareTo(searchValue);
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
    
}
