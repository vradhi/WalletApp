package com.spring.walletapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Name can't be blank")
    @Size(min=2,max = 30)
    private String name;
    @Size(min=2,max=30)
    private String accountNumber;
    @Size(max=100)
    private String description;
    @Min(1)
    @Max(3)
    private Integer priority;//1-High,2-Medium,3-Low
    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER,mappedBy = "wallet",orphanRemoval = true)
    @JsonIgnore
    private List<Transaction> transactions;
    private Double currentBalance;
    @PrePersist
    public void setBalance(){this.currentBalance=new Double(0);}

}
