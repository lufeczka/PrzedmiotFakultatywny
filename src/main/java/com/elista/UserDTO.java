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
    private String email;
    private String password;
    private String name;
    private String lastName;
    private Date register_date;
    private String phone;
    private Boolean active;

    public UserDTO(){

    }

    public UserDTO(Long id, String email, String password, String name, String lastName, Date register_date, String phone, Boolean active) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.register_date = register_date;
        this.phone = phone;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getRegister_date() {
        return register_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
