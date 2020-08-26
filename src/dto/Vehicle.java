/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.NotFound;

/**
 *
 * @author Acer
 */
@Entity
public class Vehicle {
    @Id 
    private int vehicleId;
//    @ManyToOne
  //  @NotFound(action =NotFoundAction.IGNORE)
  @ManyToMany(mappedBy = "vehicles")
  private Collection<UserDetails> userlist=new ArrayList();
    //private UserDetails user;

    public Collection<UserDetails> getUserlist() {
        return userlist;
    }

    public void setUserlist(Collection<UserDetails> userlist) {
        this.userlist = userlist;
    }

   /* public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
*/
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    private String vehicleName;

   
    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
