package com.example.agupta1409.webndocview;


import java.util.ArrayList;

/**
 * Created by Ishan Maheshwari on 27-06-2016.
 */
public class Student {

    public static class Students{
        String name;
        String course;

        public Students(String course, String name) {
            this.course = course;
            this.name = name;
        }
    }

    public static ArrayList<Students> getdata(){
        ArrayList<Students> data = new ArrayList<>();

        data.add(new Students("Pandora","Ishan"));
        data.add(new Students("Pandora","Rajat"));
        data.add(new Students("Pandora","Aarushi"));
        data.add(new Students("Crux","Mansi"));
        data.add(new Students("Interview","Astitwa"));
        data.add(new Students("Pandora","Shuhul"));
        data.add(new Students("Elixir","Rachit"));
        data.add(new Students("Crux","Ravi"));

        return data;
    }
}
