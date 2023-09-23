/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import controller.ManagingStudent;
import java.util.ArrayList;
import java.util.HashMap;
import model.Student;
import model.StudentManagement;

/**
 *
 * @author Nguyen Quang Hau
 */
public class Test {
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
        s3.setId("DE3");
        s3.setName("Le Van Yen");
        s3.setSemeter("Spring");
        HashMap<String, Integer> course3 = new HashMap<>();
        course3.put("Java", 1);
        course3.put(".Net", 1);
        course3.put("C/C++", 1);
        s3.setCourses(course3);
        
        
        Student s4 = new Student();
        s4.setId("DE4");
        s4.setName("Nguyen Van Huy");
        s4.setSemeter("Spring");
        HashMap<String, Integer> course4 = new HashMap<>();
        course4.put("Java", 2);
        course4.put(".Net", 4);
        course4.put("C/C++", 1);
        s4.setCourses(course4);
        
         Student s5 = new Student();
        s5.setId("DE5");
        s5.setName("Nguyen Van Ha");
        s5.setSemeter("Spring");
        HashMap<String, Integer> course5 = new HashMap<>();
        course5.put("Java", 2);
        course5.put(".Net", 4);
        course5.put("C/C++", 1);
        s5.setCourses(course5);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        sm.setList(list);
        
        // end fake data
        
        new ManagingStudent(sm).run();
    }
}
