package com.PayKar.transaction.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name="User_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    private String username;
    private Long creationDate=System.currentTimeMillis();

    @JsonIgnore
    @JoinColumn(name="accountId",columnDefinition = "varchar(36)",updatable = false)
    @JsonManagedReference
    private  AccountInfo account;
}
