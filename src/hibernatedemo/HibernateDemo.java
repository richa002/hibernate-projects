/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import dto.Address;
import dto.UserDetails;
import dto.Vehicle;
import java.util.Date;
import javax.imageio.spi.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Acer
 */
public class HibernateDemo {

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
    UserDetails user=new UserDetails();  //UserDetails user2=new UserDetails();  
   
   // user.setUserId(4);
   user.setUserName("First User");
  // user2.setUserName("Second User");
  /* Address addr=new Address();
  addr.setStreet(" home street name");
   addr.setCity(" home city name");
   addr.setState(" home State name");
   addr.setPincode(" home pincode name");
  // user.setHomeaddress(addr);
  user.getListofaddress().add(addr);
    Address addr2=new Address();
  addr2.setStreet(" office street name");
   addr2.setCity(" office city name");
   addr2.setState(" office State name");
   addr2.setPincode(" office pincode name");
   //user.setOfficeaddress(addr2);
  user.getListofaddress().add(addr2);
  
  // user.setAddress("First user's address");
   //user.setJoineddate(new Date());
   //user.setDesription("Description of first user");
   */
  Vehicle vehicle=new Vehicle();
  vehicle.setVehicleId(101);
  vehicle.setVehicleName("car");
   vehicle.getUserlist().add(user);

 
 Vehicle vehicle2=new Vehicle();
  vehicle2.setVehicleId(102);
  vehicle2.setVehicleName("jeep");
 vehicle2.getUserlist().add(user);
 
  user.getVehicles().add(vehicle);
   user.getVehicles().add(vehicle2);

// user.setVehicle(vehicle);
  
  SessionFactory sessionFactory= createSessionFactory();
  Session session=sessionFactory.openSession();
  session.beginTransaction();
  session.save(user);
  session.save(vehicle);
  session.save(vehicle2);
 
 // session.save(user2);
  session.getTransaction().commit();
    session.close();
    
 /*   user=null;
    session=sessionFactory.openSession();
  session.beginTransaction();
  user=(UserDetails)session.get(UserDetails.class,1);// 1 is the primary key here.
       
  session.close();//as fetch type is eagerso we cN STILL FETCH DETAILS EVEN AFTER SESSION CLOSED..NOT POSSIBLE WITH LAZY FETCHING.
  System.out.println(user.getListofaddress().size());//lazy initialization
   */
    
  //  user=null;
   //session=sessionFactory.openSession();
  //session.beginTransaction();
 // user=(UserDetails)session.get(UserDetails.class,4);
   //     System.out.println("User name retrieved is "+user.getUserName());
    }
    
}
