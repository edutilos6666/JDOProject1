package com.edutilos.objectdb;

import com.edutilos.pojo.School;
import com.edutilos.pojo.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 29/08/2016.
 */
public class TestSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/teacher.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();


        etx.begin();
        em.createQuery("delete from Teacher t", Teacher.class).executeUpdate();
        em.createQuery("delete from School s", School.class).executeUpdate();
        etx.commit();

        //insert some values
        Teacher t1 , t2 , t3 , t4 ;
        t1 = new Teacher("foo");
        t2 = new Teacher("bar");
        t3 = new Teacher("bim");
        t4= new  Teacher("pako");
        School s1 , s2 ;
        s1 = new School("s1");
        s2 = new School("s2");
        s1.setTeachers(Arrays.asList(t1, t2));
        t1.setSchool(s1);
        t2.setSchool(s1);

        s2.setTeachers(Arrays.asList(t3, t4));
        t3.setSchool(s2);
        t4.setSchool(s2);

        etx.begin();
        em.persist(s1);
        em.persist(s2);
        etx.commit();


        //select
        System.out.println("<<schools>>");
        List<School> list = em.createQuery("select s from School s", School.class).getResultList();
        for(School school: list) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(school.getName()).append(" ;  ");
            for(Teacher t: school.getTeachers())
                buffer.append(t.getName()).append(" , ");

            System.out.println(buffer.toString());
        }


        //select teachers
        System.out.println("<<teachers>>");
        List<Teacher> teacherList = em.createQuery("select t from Teacher t", Teacher.class).getResultList();
        for(Teacher teacher: teacherList) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(teacher.getName()).append(" ; ");
            buffer.append(teacher.getSchool().getName());
            System.out.println(buffer.toString());
        }

    }
}
