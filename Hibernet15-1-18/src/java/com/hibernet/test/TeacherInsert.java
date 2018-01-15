/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernet.test;

import com.hibernet.entity.Department;
import com.hibernet.entity.Teacher;
import com.hibernet.service.TeacherService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author J2EE-33
 */
public class TeacherInsert {

    public static TeacherService teacherService = new TeacherService();

    public static void main(String[] args) {
        try {
            Teacher teacher = new Teacher();
            teacher.setTeacherName("Mr. Ac");
            teacher.setEmail("demox@dg1emo.com");
            teacher.setAge(52);

            Department department = new Department();
            department.setDept_id(1);

            teacher.setDepartment(department);

            teacherService.persist(teacher);

        } catch (HibernateException exception) {
            System.out.println("Problem creating session factory");
            exception.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(TeacherInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
