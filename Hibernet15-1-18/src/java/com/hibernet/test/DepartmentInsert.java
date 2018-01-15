/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernet.test;

import com.hibernet.entity.Department;
import com.hibernet.service.DepartmentService;

/**
 *
 * @author J2EE-33
 */
public class DepartmentInsert {
    public static DepartmentService deptservice = new DepartmentService();
    
    public static void main(String[] args) {
        try {
            Department dept = new Department();
            dept.setDepartmentName("J2eed");
        } catch (Exception e) {
        }
    }
}
