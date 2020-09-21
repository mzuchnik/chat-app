package pl.mzuchnik.communicatorserver;

import java.util.*;

public class TestClass {

    public static void main(String[] args) {

        int[] ageNumbers = {1,2,3,4,5,6,7,8,9};

        List<Age> ageList = new ArrayList<>();


        for (int ageNumber : ageNumbers) {
            ageList.add(new Age(ageNumber));
        }

        ageList.forEach(age -> {
            System.out.println(age.getAge());
        });
    }
}
