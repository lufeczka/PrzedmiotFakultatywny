package com.elista.user.dto;

import java.io.Serializable;
import java.util.List;

import com.elista.base.dto.baseDTO;
import com.elista.position.dto.positionDTO;
import org.joda.time.DateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import io.swagger.annotations.ApiModel;

/**
 * Created by Thrundi on 2016-05-03.
 */
@ApiModel
public class userDTO extends baseDTO implements Serializable {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private DateTime activeUntil;
    private List<positionDTO> positions;

    public userDTO() {
    }

    public userDTO(Long id, String password, String email) {
        setPassword(password);
        this.email = email;
    }

    public userDTO(long id, List<positionDTO> positions, String email, String password, String name, String surname, String phoneNumber, String address, DateTime activeUntil) {
        super(id);
        this.positions = positions;
        this.email = email;
        this.password = password;
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
        return this.password == passwordEncoder.encode(password);
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

    public List<positionDTO> getPositions() {
        return positions;
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

    public void addPosition(positionDTO position) {
        this.positions.add(position);
    }

    public void setActiveUntil(DateTime activeUntil) {
        this.activeUntil = activeUntil;
    }
}
