package com.PayKar.transaction.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name="Transaction_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    @JsonBackReference
    private UUID transactionId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SenderAccountId")
    @JsonBackReference
    private AccountInfo sender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ReceiverAccountId")
    @JsonBackReference
    private AccountInfo receiver;

    private Long amount;

    private Long transactionTimeStamp=System.currentTimeMillis();
}
