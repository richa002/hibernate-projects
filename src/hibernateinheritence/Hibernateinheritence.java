/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateinheritence;

import dto.*;
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
public class Hibernateinheritence {

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
        Vehicle vehicle=new Vehicle();
        vehicle.setName("car");
        vehicle.setId(1);
        Twowheeler twowheeler=new Twowheeler();
        twowheeler.setId(2);
        
        twowheeler.setName("Bike");
        twowheeler.setSteeringahndle( "Bike steering handle");
         Fourwheeler fourwheeler=new Fourwheeler();
        fourwheeler.setName("jeep");
        fourwheeler.setSteeringwheel("Jeep steering wheel");
         fourwheeler.setId(3);
       
        SessionFactory sessionFactory= createSessionFactory();
  Session session=sessionFactory.openSession();
  session.beginTransaction();
  session.save(vehicle);
  session.save(twowheeler);
  session.save(fourwheeler);
 
  session.getTransaction().commit();
    session.close();

    }
    
}
