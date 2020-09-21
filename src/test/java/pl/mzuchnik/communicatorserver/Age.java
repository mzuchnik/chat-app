package pl.mzuchnik.communicatorserver;

public class Age implements Comparable<Age>{

    private int age;

    public Age(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Age o) {
        if (age > o.age)
            return 1;
        else if(age == o.age)
            return 0;
        else
            return -1;
    }
}
