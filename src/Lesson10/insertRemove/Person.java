
package Lesson10.insertRemove;


public class Person implements Comparable{
    private String name, gender;
    private int age;
    public Person(){
        age = 0;
        name = "";
        gender = "";
    }
    public Person(String nm){
        age = 0;
        name = nm;
        gender = "";
    }
    public Person(String nm, int a, String gen){
        name = nm;
        gender = gen;
        age = a;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public boolean isFemale(){
        if(gender.equals("Female"))
                return true;
        else return false;
    }
    
    public String toString(){
        //Bob: Age 12 | male
        return name + ": Age " + age + " | " + gender;
    }

    @Override
    public int compareTo(Object t) {
        String n = ((Person)t).getName();
        return name.compareTo(n);
    }
    
}
