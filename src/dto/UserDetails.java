/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


/**
 *
 * @author Acer
 */
@Entity
public class UserDetails {
/*
    public Address getOfficeaddress() {
        return officeaddress;
    }

    public void setOfficeaddress(Address officeaddress) {
        this.officeaddress = officeaddress;
    }
*/
@Id@GeneratedValue(strategy=GenerationType.AUTO)//autoincrement
private int userId;
//@Transient
  private String userName;
 // @OneToMany
 // @JoinTable(name="user_vehicle",joinColumns =@JoinColumn(name="userid"),inverseJoinColumns=@JoinColumn(name="vehicleid"))
  @ManyToMany
  private Collection<Vehicle> vehicles=new ArrayList();
 // @OneToOne@JoinColumn(name="vehicle_id")
  // private Vehicle vehicle;
  // @ElementCollection(fetch=FetchType.EAGER)
  //@JoinTable(name="user_address",
    //      joinColumns=@JoinColumn(name="userid"))
 // @GenericGenerator(name="hilo_gen",strategy="hilo")  // to generate primary key
  //@CollectionId(columns={@Column(name="address_id")},generator="hilo_gen",type=@Type(type="long"))
   //private Collection<Address> listofaddress=new ArrayList();

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

  //  public Vehicle getVehicle() {
    //    return vehicle;
    //}

   // public void setVehicle(Vehicle vehicle) {
    //    this.vehicle = vehicle;
   // }

   /* public Collection<Address> getListofaddress() {
        return listofaddress;
    }

    public void setListofaddress(Collection<Address> listofaddress) {
        this.listofaddress = listofaddress;
    }
  /* @Embedded
   @AttributeOverrides({
       
   @AttributeOverride(name="street",column=@Column(name="home_street_name")),
   @AttributeOverride(name="city",column=@Column(name="home_city_name")),
   @AttributeOverride(name="state",column=@Column(name="home_state_name")),
   @AttributeOverride(name="pincode",column=@Column(name="home_pincode_name"))
   
   })        
   private Address homeaddress;
   @Embedded
   private Address officeaddress;
//@Temporal(TemporalType.DATE)
//private Date joineddate;

    public Address getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(Address homeaddress) {
        this.homeaddress = homeaddress;
    }

  
  //  public Date getJoineddate() {
    //    return joineddate;
    //}

    //public void setJoineddate(Date joineddate) {
      //  this.joineddate = joineddate;
    //}

    //public String getAddress() {
      //  return address;
    //}

   // public void setAddress(String address) {
     //   this.address = address;
    //}

    //public String getDesription() {
      //  return desription;
    //}

    //public void setDesription(String desription) {
     //   this.desription = desription;
    //}
//private String address;
//@Lob
//private String desription;
*/
  //@Column(name="user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
//@Column(name = "user_name")
   public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
