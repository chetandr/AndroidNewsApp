package com.example.formulaone.recycleagain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chetan_rane on 5/30/2017.
 */

public class People {
    private List<Person> people = new ArrayList<>();

    public void People() {
        this.initialzeData();
    }

    public List<Person> getData() {
        return this.people;
    }

    private void initialzeData() {
        this.people.add(new Person("Anna Hathaway Wilson", "23 years old", R.drawable.anna));
        this.people.add(new Person("Mila Kunis", "25 years old", R.drawable.mila));
        this.people.add(new Person("Angelina Jolie", "35 years old", R.drawable.angelina));
    }

}