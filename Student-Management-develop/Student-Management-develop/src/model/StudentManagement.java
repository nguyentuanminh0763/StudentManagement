/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Nguyen Quang Hau
 */
public class StudentManagement implements StudentITF {

    ArrayList<Student> list;
    Validation val;

    public StudentManagement() {
        list = new ArrayList<>();
        val = new Validation();
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    @Override
    public boolean create() {
        try {
            // Begin check if value exist
            String id;
            do {
                id = val.getString("Enter id: ");
            } while (val.idIsExisting(list, id));
            // End check if value exist

            Student c = new Student().create();
            c.setId(id);
            list.add(c);

            System.out.println("Created");
            return true;
        } catch (Exception e) {
            System.out.println("Creating Failure");
            return false;
        }
    }

    @Override
    public ArrayList<Student> searchByName() {
        String foundName = val.getString("Enter name that you want to find: ").toLowerCase();
        ArrayList<Student> foundedList = new ArrayList<>();
        
        for (Student student : list) {
            String name = student.getName().substring(student.getName().lastIndexOf(" ")).toLowerCase();
            if (name.contains(foundName)) {
                foundedList.add(student);
            }
        }

        return foundedList;
    }

    @Override
    public void sort(ArrayList<Student> list) {
         Collections.sort(list);
    }

    @Override
    public Student searchById() {
        String foundID = val.getString("Enter id that you want to find: ");
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(foundID)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student st) {
        try {
            // Inputing new datas
            System.out.println("------UPDATING-------");
            Student newStudent = new Student();
            newStudent.setName(val.getStringDataCanBlank("Enter name: "));
            newStudent.setSemeter(val.getStringDataCanBlank("Enter semeter: "));
            String choice = val.getString("Do you want to update new courses(Y/N): ", "Y|y|N|n|Yes|No|YES|NO");
            // checking if user want to update new courses
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                int courseCode = -1;
                do {
                    courseCode = val.getIntData("--------Course----------\n1. Java\n2. .Net\n3. C/C++\n4. Exit\nSelecttion: ", 1, 4);
                    switch (courseCode) {
                        case 1:
                            newStudent.getCourses().put("Java", newStudent.getCourses().get("Java") + 1);
                            break;
                        case 2:
                            newStudent.getCourses().put(".Net", newStudent.getCourses().get(".Net") + 1);
                            break;
                        case 3:
                            newStudent.getCourses().put("C/C++", newStudent.getCourses().get("C/C++") + 1);
                            break;
                    }
                } while (courseCode != 4);
            }

            // Begin: updating new data for st and data will be updated if user does not input blank
            if (newStudent.getName().trim().length() != 0) {
                st.setName(newStudent.getName());
            }
            if (newStudent.getSemeter().trim().length() != 0) {
                st.setSemeter(newStudent.getSemeter());
            }
            if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                st.setCourses(newStudent.getCourses());
            }
            // End: updating new data for st

            System.out.println("Updated");
        } catch (Exception e) {
            System.out.println("Updating failure");
        }
    }

    @Override
    public void delete(Student st) {
        try {
            list.remove(st);
            System.out.println("Deleted");
        } catch (Exception e) {
            System.out.println("Deleting failure");
        }
    }

    @Override
    public void report() {
        System.out.println("\n-------------REPORT------------");
        for (Student student : list) {
            System.out.println(student.getName() + " | " + student.coursesDisplay());
        }
    }

    @Override
    public void display(ArrayList<Student> list) {
        System.out.println("\n--------------DISPLAY-------------");
        for (Student st : list) {
            System.out.println(st);

        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();

        // fake data
        ArrayList<Student> list = new ArrayList<>();

        Student s1 = new Student();
        s1.setId("DE1");
        s1.setName("Nguyen Quang Hau");
        s1.setSemeter("Winter");
        HashMap<String, Integer> course1 = new HashMap<>();
        course1.put("Java", 2);
        course1.put(".Net", 1);
        course1.put("C/C++", 0);
        s1.setCourses(course1);

        Student s2 = new Student();
        s2.setId("DE2");
        s2.setName("Tran Cong Quoc");
        s2.setSemeter("Spring");
        HashMap<String, Integer> course2 = new HashMap<>();
        course2.put("Java", 1);
        course2.put(".Net", 0);
        course2.put("C/C++", 1);
        s2.setCourses(course2);

        Student s3 = new Student();
        s3.setId("DE2");
        s3.setName("Le Van Yen");
        s3.setSemeter("Spring");
        HashMap<String, Integer> course3 = new HashMap<>();
        course3.put("Java", 1);
        course3.put(".Net", 1);
        course3.put("C/C++", 1);
        s3.setCourses(course3);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        sm.setList(list);
        sm.display(list);
        sm.update(s3);
        sm.delete(s2);
        sm.display(list);

    }

}
