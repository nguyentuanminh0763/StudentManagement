/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface StudentITF {
    boolean create();
    ArrayList<Student> searchByName();
    Student searchById();
    void sort(ArrayList<Student> list);
    void update(Student st);
    void delete(Student st);
    void report();
    void display(ArrayList<Student> list);
}
