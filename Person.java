package quiz;


import java.io.Serializable;
import java.util.Scanner;

abstract public class Person implements Serializable {

    private String name;
    private int age;
    private String eMail;

    public Person(String name, int age, String eMail) {
        this.name = name;
        this.age = age;
        this.eMail = eMail;
    }

    public Person() {
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String geteMail() {
        return eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
