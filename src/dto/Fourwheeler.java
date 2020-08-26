/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Acer
 */
@Entity
//@DiscriminatorValue("JEEP")
public class Fourwheeler  extends  Vehicle{
   private String steeringwheel; 

    @Override
    public String toString() {
        return "Fourwheeler{" + "steeringwheel=" + steeringwheel + '}';
    }

    public String getSteeringwheel() {
        return steeringwheel;
    }

    public void setSteeringwheel(String steeringwheel) {
        this.steeringwheel = steeringwheel;
    }
}
