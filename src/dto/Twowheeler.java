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
//@DiscriminatorValue("Bike")
public class Twowheeler extends Vehicle{
    private String steeringahndle;

    @Override
    public String toString() {
        return "Twowheeler{" + "steeringahndle=" + steeringahndle + '}';
    }

    public String getSteeringahndle() {
        return steeringahndle;
    }

    public void setSteeringahndle(String steeringahndle) {
        this.steeringahndle = steeringahndle;
    }
}
