
package Lesson10.sorting;


public class ISSStudent implements Comparable{
    private String name, address;
    private int id;
    
    public ISSStudent(String n, String a, int i){
        name = n;
        address = a;
        id = i;
    }
    
    public String toString(){
        String str = "Name: " + name;
        str+= "\nAddress: " + address;
        str+= "\nID: " + id;
        str +="\n----------------\n";
        return str;
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }

    
    //this version compares students by name for searching and sorting
    @Override
    public int compareTo(Object t) {
        String othername = ((ISSStudent)t).getName();
        return name.compareTo(othername); //0=match
    }
    
    
}
