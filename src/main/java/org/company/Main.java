package org.company;

import org.company.dao.StudentDao;
import org.company.entity.Student;

public class Main {

    public static void main(String[] args) {
//        Student student = new Student();
//        student.setId(1);
//        student.setName("Akif");
//        student.setSurname("Memmedli");
//        student.setAge(21);
//        studentDao.update(student);


        StudentDao studentDao = new StudentDao();
        Student byId = studentDao.getById(2);

        System.out.println(byId);
    }
}
