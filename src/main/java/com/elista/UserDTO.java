package com.elista;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by maciej.chyczewski on 23-03-2016.
 */
@ApiModel
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private String lastName;
    private Date registered;

    public UserDTO(){

    }

    public UserDTO(Long id, String name, String lastName, Date registered){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.registered = registered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
