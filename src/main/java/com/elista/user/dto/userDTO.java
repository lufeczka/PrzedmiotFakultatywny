package com.elista.user.dto;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.elista.base.dto.BaseDTO;
import com.elista.position.dto.PositionDTO;
import io.swagger.annotations.ApiModel;

/**
 * Created by Thrundi on 2016-05-03.
 */
@ApiModel
public class UserDTO extends BaseDTO implements Serializable {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private DateTime activeUntil;
    private PositionDTO position;

    public UserDTO() {
    }

    public UserDTO(Long id, String password, String email) {
        setPassword(password); //TODO: HASH
        this.email = email;
    }

    public UserDTO(long id, PositionDTO position, String email, String password, String name, String surname, String phoneNumber, String address, DateTime activeUntil) {
        super(id);
        this.position = position;
        this.email = email;
        setPassword(password);
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.activeUntil = activeUntil;
    }

    public String getEmail() {
        return email;
    }

    public Boolean isPasswordValid(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        return this.password == hashedPassword;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public PositionDTO getPosition() {
        return position;
    }

    public DateTime getActiveUntil() {
        return activeUntil;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPosition(PositionDTO position) {
        this.position = position;
    }

    public void setActiveUntil(DateTime activeUntil) {
        this.activeUntil = activeUntil;
    }
}
