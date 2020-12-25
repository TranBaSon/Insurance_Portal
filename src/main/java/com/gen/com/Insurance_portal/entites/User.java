package com.gen.com.Insurance_portal.entites;

import com.gen.com.Insurance_portal.common.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String givenName;

    @Column(nullable = false)
    private String userName;

    private Date dod;

    @Column(nullable = false)
    private Gender gender;

    @Column(length = 50)
    private String idNumber;

    private String address;

    private String company;

    @Column(nullable = false)
    private boolean fromLegacySystem;

    private boolean isCancelled;

    private String cancellationReason;

    private Date cancelDate;

    private Boolean isDeleted;

    private Date deletedAt;

    public User() {
        this.address = "";
        this.idNumber = "";
        this.gender = Gender.NONE;
        this.isCancelled = false;
        this.cancelDate = null;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
