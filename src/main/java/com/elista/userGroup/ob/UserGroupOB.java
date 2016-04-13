package com.elista.userGroup.ob;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

/**
 * Created by maciej.chyczewski on 29-03-2016.
 */

@Entity
@Table(name = "user_group")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_USER_GROUP_ID")
public class UserGroupOB implements Serializable {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;
}
