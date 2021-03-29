package quiz;

import java.io.Serializable;

abstract public class Person implements Serializable{

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

}
