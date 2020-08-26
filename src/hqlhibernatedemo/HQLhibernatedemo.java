/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hqlhibernatedemo;

import dto.Student;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.imageio.spi.ServiceRegistry;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Acer
 */
public class HQLhibernatedemo {

    /**
     * @param args the command line arguments
     */
   
        
         private static SessionFactory sessionFactory;
private static ServiceRegistry serviceRegistry;

public static SessionFactory createSessionFactory() {
    Configuration configuration = new Configuration();
    configuration.configure();
    StandardServiceRegistry serviceRegistry;
    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    return sessionFactory;
}
   
    public static void main(String[] args) {
        // TODO code application logic here
         SessionFactory sessionFactory= createSessionFactory();
  Session session=sessionFactory.openSession();
  session.beginTransaction();
  /*Random r=new Random();
  for(int i=1;i<=50;i++)
  {
  Student s=new Student();
  s.setRoll(i);
  s.setName("Name"+i);
  s.setMarks(r.nextInt(100));
  session.save(s);
 
  }
  
  */
  /*
  Query q=session.createQuery("from Student where marks>50");
 List<Student> students=q.list();
 for(Student s:students){
     System.out.println(s);
 }
   q=session.createQuery("from Student where roll=7");
   Student std=(Student)q.uniqueResult();
        System.out.println(std);
        
    q=session.createQuery("select name,marks from Student where roll=7");
   Object[] arr=(Object[])q.uniqueResult();
       for(Object o:arr){
           System.out.println(o);
       }
       
    q=session.createQuery("select name,marks from Student ");
   List<Object[]>list=(List<Object[]>)q.list();
       for(Object[] ar:list){
           for(Object o:ar){
               System.out.print(o+"  ");
           }
           System.out.println("");  
       }
        int b=60;
        Query  q=session.createQuery("select sum(marks) from Student where marks>:b");
       q.setParameter("b",b);
        Long tot=(Long)q.uniqueResult();//sum returns long
        System.out.println(tot);
*/
  
  SQLQuery query=session.createSQLQuery("select * from student where marks>60");
  query.addEntity(Student.class);
  List<Student> list=query.list();
  for(Student s:list)
            System.out.println(s);
  
  query=session.createSQLQuery("select name,marks from student where marks>60");
  query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
  List<Map> l=query.list();
  for(Map m:l)
            System.out.println(m.get("name")+" "+m.get("marks"));
  
  session.getTransaction().commit();
    session.close();
 

    }
    
}
