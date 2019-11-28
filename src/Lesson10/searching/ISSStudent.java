
package Lesson10.searching;


public class ISSStudent implements Comparable{
    private String name, address;
    private int id;
    
    public ISSStudent(String n, String a, int i){
        name = n;
        address = a;
        id = i;
    }
    
    //used for searching
    public ISSStudent(int i){
        name = "";
        address = "";
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

    @Override
    public int compareTo(Object t) {
        int otherid = ((ISSStudent)t).getID();
        return id - otherid; //0=match
    }
    
    
}
