package com.spring.walletapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(1)
    @NotNull(message = "Amount cannot be null")
    private Double amount;
    private String description;
    @Min(1)
    @Max(3)
    private int type;//1=Income , 2= Expense, 3=Transfer
    @JsonFormat(pattern = "yyyy-mm-dd")
        private Date transactionDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id",nullable = false)
    @JsonIgnore
    private Wallet wallet;


    @PrePersist
    public void setTransactionDate(){
        this.transactionDate = new Date();
    }

}
