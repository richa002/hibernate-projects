/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 * @author Acer
 */
@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="User.byid",query="from User where userid=?")
@NamedNativeQuery(name="User.byname",query="select * from user where username=?",resultClass=User.class)
//@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class User {
    @Id@GeneratedValue
    private int userid;
    private String username;

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", username=" + username + '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
