package com.PayKar.transaction.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Account_Info")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID accountId;

    @JoinColumn(name = "user_id",columnDefinition = "varchar(36)")
    @OneToOne(optional = false)
    @JsonBackReference
    @JsonIgnore
    private User user;

    private Long balance =0L;

    private String accountStatus="True";

    private Long createdOn=System.currentTimeMillis();

    private Long updatedOn=System.currentTimeMillis();

    private String bankName;

    private String branchName;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "transactionId")
    private List<Transaction> transaction;
}
