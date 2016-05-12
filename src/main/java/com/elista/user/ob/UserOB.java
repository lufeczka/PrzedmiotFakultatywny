package com.elista.user.ob;

import com.elista.base.ob.BaseOB;
import com.elista.position.ob.positionOB;
import org.joda.time.DateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Thrundi on 2016-05-03.
 */

@Entity
@Table(name = "users")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_USERS_ID")
public class UserOB extends BaseOB {
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private DateTime activeUntil;

    @ManyToMany()
    @JoinColumn(name = "positions_id", referencedColumnName = "id")
    private List<positionOB> positions;
    public UserOB() {
    }

    public UserOB(Long id, String password, String email) {
        setPassword(password);
        this.email = email;
    }

    public UserOB(long id, List<positionOB> positions, String email, String password, String name, String surname, String phoneNumber, String address, DateTime activeUntil) {
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
        String hashedPassword = passwordEncoder.encode(password);

        return this.password == hashedPassword;
    }

    public String getPassword() {
        return password;
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

    public List<positionOB>  getPositions() {
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

    public void setPositions(List<positionOB> positions) {
        this.positions = positions;
    }

    public void addPosition(positionOB position) {
        this.positions.add(position);
    }

    public void setActiveUntil(DateTime activeUntil) {
        this.activeUntil = activeUntil;
    }
}
