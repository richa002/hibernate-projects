/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatecrud;

import dto.User;
import java.util.List;
import javax.imageio.spi.ServiceRegistry;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Acer
 */
public class Hibernatecrud {

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
        
        SessionFactory sessionFactory= createSessionFactory();
  Session session=sessionFactory.openSession();
  session.beginTransaction();
  
  
 //  create operation..................
for(int i=1;i<=10;i++)
        {
        User user=new User();
        user.setUsername("User"+(i));
        session.save(user);
 
        }
  /*      
  //read operation........................
  for(int j=1;j<=10;j++){
 User user= (User)session.get(User.class,j);
        System.out.println(user);
  }
*/
  //delete object...................
 /* User user= (User)session.get(User.class,10);
  session.delete(user);
*/
 //User user= (User)session.get(User.class,10);
 // user.setUsername("updated user");
//session.update(user); // by defaukt it is in persistent state..so update query automatically done.....
/*User user1= (User)session.get(User.class,1);
user1.setUsername("updated user 1");
session.getTransaction().commit();
    session.close();

   session=sessionFactory.openSession();
  session.beginTransaction();
  //user1.setUsername("updated username after session closed");
session.update(user1);
*/
//HQL LANGUAGE
/*Query query=session.createQuery("from User");
query.setFirstResult(5);
query.setMaxResults(4);
List <User>list=(List<User>)query.list();
        for(User u:list)
    System.out.println(u);
query=session.createQuery(" select username from User");
List <String>list1=(List<String>)query.list();
  for(String s:list1)
    System.out.println(s);
query=session.createQuery(" select max(userid) from User");
Integer i=(Integer)query.uniqueResult();
        System.out.println("max userid is:"+i);
*/

//  PAGINATION
/*
int totalrecords=50;
int start;
int recordsononepage=10;
int pages=totalrecords/recordsononepage;
for(int i=1;i<=pages;i++){
   if(i==1)
       start=1;
   else
       start=recordsononepage*(i-1)+1;
     System.out.println("RECORDS ON PAGE NO. "+i);  
    pagination(session,start);
}*/
/*
int id=5;
//Query query=session.createQuery("from User where userid>?");

//query.setInteger(0,id);
Query query=session.createQuery("from User where userid>:uid");

//query.setInteger("uid",id);
query.setParameter("uid",id);

List <User>list=(List<User>)query.list();
        System.out.println(list);
*/
//NAMED QUERY
/*
int uid=2;
Query query=session.getNamedQuery("User.byid");
 
query.setInteger(0,uid);

User user=(User)query.uniqueResult();
        System.out.println(user);
 query=session.getNamedQuery("User.byname");
query.setString(0,"User1");
 user=(User)query.uniqueResult();
        System.out.println(user);
  */
//Criteria criteria=session.createCriteria(User.class);
//criteria.add(Restrictions.eq("username","User10"))
 /* criteria.add(Restrictions.like("username","%User1%"))
          .add(Restrictions.ge("userid", 1))
          .add(Restrictions.between("userid",5 ,10));

 criteria.add(Restrictions.or(Restrictions.between("userid",1,4), Restrictions.between("userid",7,10)));
List <User> list=criteria.list();
        System.out.println(list);
*/
 /*
 Criteria criteria=session.createCriteria(User.class)
         .setProjection(Projections.property("userid"))//choosing column to pull up
         .addOrder(Order.desc("userid"));//adding order
List  list=criteria.list();
*/
//query by example
/*
User exampleuser=new User();
exampleuser.setUserid(5);//priamry key nor considered for example object
exampleuser.setUsername("User1%");

Example example=Example.create(exampleuser).excludeProperty("userid").enableLike();
  Criteria criteria=session.createCriteria(User.class)
         .add(example);
 List  list=criteria.list();

*/
User user1=(User)session.get(User.class,1);
//user1.setUsername("updated user 1");
       
session.getTransaction().commit();
    session.close();
    
Session session2=sessionFactory.openSession();
  session2.beginTransaction();
  User user2=(User)session2.get(User.class,1);
session2.getTransaction().commit();
    session2.close();

    Session session3=sessionFactory.openSession();
  session3.beginTransaction();
  User user3=(User)session3.get(User.class,1);
session3.getTransaction().commit();
    session3.close();


    System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

//for(Object obj:list)
  //          System.out.println(obj);
    }
  public static void pagination(Session session,int start) {
  
      Query query=session.createQuery("from User");
query.setFirstResult(start-1);
query.setMaxResults(10);
List <User>list=(List<User>)query.list();
        for(User u:list)
    System.out.println(u);

  } 
}
