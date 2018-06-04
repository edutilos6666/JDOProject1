package com.edutilos.objectdb;

import com.edutilos.pojo.Person;
import com.edutilos.pojo.SecondPerson;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 29/08/2016.
 */
public class TestPerson {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        List<Person> list = Arrays.asList(
                new Person("foo", 10 , 100.0 , true),
                new Person("bar", 20 , 200.0, false),
                new Person("bim", 30 , 300.0 , true)
        );


        tx.begin();
        Query _q = em.createQuery("delete from Person");
        _q.executeUpdate();
        tx.commit();


        tx.begin();
        for(Person p: list) {
            em.persist(p);
        }

        tx.commit();


        Query q = em.createQuery("select count(p) from Person p");
        long count = (long)q.getSingleResult();
        System.out.println("count = "+ count);
        q = em.createQuery("select avg(p.age) , max(p.age), min(p.age), sum(p.age) from Person p");
        Object[] obj = (Object[])q.getSingleResult();
        double avg = Double.parseDouble(obj[0].toString());
        int max = Integer.parseInt(obj[1].toString()),
                min = Integer.parseInt(obj[2].toString());
        long sum = Long.parseLong(obj[3].toString());
        String nl= "\r\n";
        String str = String.format("avg age = %f%s, max age = %d%s, min age = %d%s, sum age = %d", avg, nl ,
                max, nl , min, nl, sum);
        System.out.println(str);


        TypedQuery<Person> tq = em.createQuery("select p from Person p", Person.class);
        System.out.println("<<all people>>");
        List<Person> personList = tq.getResultList();
        for(Person p: personList)
            System.out.println(p);




        //named parameter
        tq  = em.createQuery("select p from Person p where p.name = :name and p.age = :age and p.wage = :wage", Person.class);
        tq.setParameter("name", "foo")
                .setParameter("age", 10)
                .setParameter("wage", 100.0);

        Person p = tq.getSingleResult();
        System.out.println("single person = " + p);


        //ordinal parameter
        tq = em.createQuery("select p from Person p where p.name = ?1 and p.age = ?2 and p.wage = ?3", Person.class);
        tq.setParameter(1, "bar")
                .setParameter(2, 20)
                .setParameter(3, 200.0);

        p = tq.getSingleResult();
        System.out.println("single person = "+ p);



        tq = em.createNamedQuery("person.selectAll", Person.class);
        list = tq.getResultList();
        System.out.println("<<person.selectAll>>");
        for(Person _p: list)
            System.out.println(_p);

        tq = em.createNamedQuery("person.selectNamedParam", Person.class);
        tq.setParameter("name", "foo")
                .setParameter("age", 10)
                .setParameter("wage", 100.0);
        p = tq.getSingleResult();
        System.out.println("<<person.selectNamedParam>>");
        System.out.println(p);

        tq = em.createNamedQuery("person.selectOrdinalParam", Person.class);
        tq.setParameter(1, "bar")
                .setParameter(2, 20)
                .setParameter(3, 200.0);
        p = tq.getSingleResult();
        System.out.println("<<person.selectOrdinalParam>>");
        System.out.println(p);

    /*
    select p from Person p where p.name = :name and p.age = :age and p.wage = :wage
    :name , :age , :wage -> ParameterExpression<T>
     c.select(Root<Person>).where(Predicate) ;
     CriteriaBuilder.and, eq, gt , ge , lt , le , ne ...

     */
    /*    CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> c = cb.createQuery(Person.class);
        Root<Person> rootPerson = c.from(Person.class);
        Path<Long> id = rootPerson.get("id");
        Path<String> name = rootPerson.get("name");
        Path<Integer> age = rootPerson.get("age");
        Path<Double> wage = rootPerson.get("wage");
        Path<Boolean> active = rootPerson.get("active");
        ParameterExpression<String> nameParam = cb.parameter(String.class);
        ParameterExpression<Integer> ageParamMin = cb.parameter(Integer.class);
        ParameterExpression<Integer> ageParamMax = cb.parameter(Integer.class);
        ParameterExpression<Double> wageParamMin = cb.parameter(Double.class);
        ParameterExpression<Double> wageParamMax = cb.parameter(Double.class);
        Predicate namePred = cb.equal(name, nameParam);
        Predicate agePred = cb.between(age, ageParamMin,ageParamMax);
        Predicate wagePred = cb.between(wage, wageParamMin, wageParamMax);
        Predicate pred = cb.and(namePred, agePred, wagePred);

        c.select(rootPerson).where(pred);
        tq = em.createQuery(c);
        tq.setParameter(nameParam, "foo")
                .setParameter(ageParamMin, 10)
                .setParameter(ageParamMax, 30)
                .setParameter(wageParamMin, 100.0)
                .setParameter(wageParamMax, 300.0);

        list = tq.getResultList();
        System.out.println("<<criteria query example>>");
        for(Person _p: list)
            System.out.println(_p);
*/



        /*
        select p from Person p where p.name like :name and p.age between :ageMin , :ageMax  and p.wage between
        :wageMin , :wageMax and
        p.active = :active
         */

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class);
        Path<String> namePath = root.get("name");
        Path<Integer> agePath = root.get("age");
        Path<Double> wagePath = root.get("wage");
        Path<Boolean> activePath = root.get("active");
        ParameterExpression<String> nameParam = cb.parameter(String.class);
        ParameterExpression<Integer> ageParamMin = cb.parameter(Integer.class),
                ageParamMax = cb.parameter(Integer.class);
        ParameterExpression<Double> wageParamMin = cb.parameter(Double.class),
                wageParamMax = cb.parameter(Double.class);
        ParameterExpression<Boolean> activeParam = cb.parameter(Boolean.class);
        Predicate namePred = cb.like(namePath , nameParam);
        Predicate agePred = cb.between(agePath , ageParamMin, ageParamMax);
        Predicate wagePred = cb.between(wagePath , wageParamMin, wageParamMax);
        Predicate activePred = cb.equal(activePath, activeParam);

        Predicate predAnd = cb.and(namePred, agePred, wagePred, activePred);
        cq.select(root).where(predAnd);



        tq = em.createQuery(cq)
                .setParameter(nameParam, "foo")
                .setParameter(ageParamMin, 10)
                .setParameter(ageParamMax, 30)
                .setParameter(wageParamMin, 100.0)
                .setParameter(wageParamMax, 300.0)
                .setParameter(activeParam, true);

        p = tq.getSingleResult();
        System.out.println(p);



        CriteriaQuery<Object[]> multiSelect = cb.createQuery(Object[].class);
        Root<Person> rPerson = multiSelect.from(Person.class);
        multiSelect.select(cb.array(rPerson.get("name"), rPerson.get("age"), rPerson.get("wage")));
        List<Object []> resList = em.createQuery(multiSelect).getResultList();
        for(Object[] _obj: resList)
            System.out.println(_obj[0]+ " and "+ _obj[1]+ " and " + _obj[2]);





        resList = em.createQuery("select p.name , p.age , p.wage from Person p", Object[].class).getResultList();
        for(Object[] _obj: resList)
            System.out.println(_obj[0]+ " and "+ _obj[1]+ " and " + _obj[2]);


        System.out.println("<<Tuple Query>>");
        CriteriaQuery<Tuple>  tupleSelect = cb.createTupleQuery();
        rPerson = tupleSelect.from(Person.class);
        tupleSelect.select(cb.tuple(rPerson.get("name"), rPerson.get("name"), rPerson.get("name")));
        List<Tuple> listTuple =  em.createQuery(tupleSelect).getResultList();
        for(Tuple t: listTuple)
            System.out.println(t.get(0)+ " and "+ t.get(1)+ " and "+ t.get(2));




        List<SecondPerson> secondPersonList = em.createQuery("select NEW com.edutilos.pojo.SecondPerson(p.name, p.age, p.wage) from Person p", SecondPerson.class)
        .getResultList();
        for(SecondPerson sp: secondPersonList)
            System.out.println( sp);


        CriteriaQuery<SecondPerson> querySecondPerson = cb.createQuery(SecondPerson.class);
        Root<Person> pRoot = querySecondPerson.from(Person.class);
        querySecondPerson.select(cb.construct(SecondPerson.class, pRoot.get("name"),
                pRoot.get("age"), pRoot.get("wage")));
        secondPersonList = em.createQuery(querySecondPerson).getResultList();
        System.out.println("<<with CriteriaQuery and construct>>");
        for(SecondPerson sp: secondPersonList)
            System.out.println( sp);



        querySecondPerson.multiselect(Arrays.asList(pRoot.get("name"), pRoot.get("age"), pRoot.get("wage")));
        secondPersonList = em.createQuery(querySecondPerson).getResultList();
        for(SecondPerson sp: secondPersonList)
            System.out.println( sp);


        em.close();
        emf.close();
    }
}
