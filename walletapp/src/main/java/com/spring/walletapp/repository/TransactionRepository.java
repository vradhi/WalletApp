package com.spring.walletapp.repository;

import com.spring.walletapp.entity.Transaction;
import com.spring.walletapp.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>  {
    List<Transaction> findByWallet(Wallet wallet);
}
