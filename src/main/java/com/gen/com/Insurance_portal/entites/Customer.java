package com.gen.com.Insurance_portal.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Customer extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerCode;

//    @Column(nullable = false)
//    private SubscriptionType subscriptionType;

    @EqualsExclude
    @ToStringExclude
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @EqualsExclude
    @ToStringExclude
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    @EqualsExclude
    @ToStringExclude
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<TransactionHistory> transactionHistories;

    @EqualsExclude
    @ToStringExclude
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<ClaimsInfo> claimsInfos;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
