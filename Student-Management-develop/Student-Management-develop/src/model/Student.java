/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.Validation;
import java.util.HashMap;

/**
 *
 * @author Nguyen Quang Hau
 */
public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private String semeter;
    private HashMap<String, Integer> courses;

    public Student() {
        courses = new HashMap<>();
        courses.put("Java", 0);
        courses.put(".Net", 0);
        courses.put("C/C++", 0);
    }

    public Student(String id, String name, String semeter, HashMap<String, Integer> courses) {
        this.id = id;
        this.name = name;
        this.semeter = semeter;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemeter() {
        return semeter;
    }

    public void setSemeter(String semeter) {
        this.semeter = semeter;
    }

    public HashMap<String, Integer> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<String, Integer> courses) {
        this.courses = courses;
    }

    public String coursesDisplay() {
        String str = "";
        int count = 0;
        
        for (String key : courses.keySet()) {
            int value = courses.get(key);
            count++;
            
            if (value != 0) {
                str += (key + ": " + courses.get(key));
                if(count !=3){
                   str+=" | ";
                }
            }
        }
        
        if(str.charAt(str.length()-2) == '|') str = str.substring(0,str.length()-2);
        
        return str;
    }

    public Student create() {
        Validation val = new Validation();
        
        // allowing user input data for attrbutes excluding ID 
        
        name = val.getString("Enter name: ");
        semeter = val.getString("Enter semeter: ");

        // Begin Enter courses
        int courseCode = -1;
        do {
            courseCode = val.getIntData("--------Course----------\n1. Java\n2. .Net\n3. C/C++\n4. Exit\nSelection: ", 1, 4);
            switch (courseCode) {
                case 1:
                    courses.put("Java", courses.get("Java") + 1);
                    break;
                case 2:
                    courses.put(".Net", courses.get(".Net") + 1);
                    break;
                case 3:
                    courses.put("C/C++", courses.get("C/C++") + 1);
                    break;
            }
        } while (courseCode != 4);
        // End Enter courses

        return new Student(id, name, semeter, courses);
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + semeter + " | " + coursesDisplay();
    }

}
