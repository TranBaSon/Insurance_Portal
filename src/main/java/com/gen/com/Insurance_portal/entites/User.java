package com.gen.com.Insurance_portal.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gen.com.Insurance_portal.common.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class User extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String givenName;

    private String username;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;

    private String phoneCode;

    private String email;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dod;

    @Enumerated(value = EnumType.STRING)
    private Gender gender = Gender.NONE;

    @Column(length = 50)
    private String idNumber;

    private String address;

    private String company;

    @Column(nullable = false)
    private boolean fromLegacySystem;

    private boolean isCancelled = false;

    private String cancellationReason;

    private Date cancelDate = null;

    private Boolean isDeleted = false;

    private Date deletedAt;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @JsonIgnore
    @OneToOne( mappedBy = "user")
    private RefreshToken refreshToken;
}
