package com.spring.walletapp.service;

import com.spring.walletapp.entity.Transaction;
import com.spring.walletapp.entity.Wallet;
import com.spring.walletapp.repository.TransactionRepository;
import com.spring.walletapp.repository.WalletRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WalletRepository walletRepository;
    public List<Transaction> getAll(Long walletId){
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        if(wallet.isPresent()){
            return transactionRepository.findByWallet(wallet.get());
        }
        return null;
    }
    public Transaction createOrUpdate(Long walletId,Transaction transaction){
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        if(wallet.isPresent()){
            transaction.setWallet(wallet.get());
            transactionRepository.save(transaction);
            return transaction;
        }
        return null;
    }
    public boolean delete(Long wallet_id,Long id){

        Optional<Wallet> wallet = walletRepository.findById(wallet_id);
        if(wallet.isPresent()){
            Optional<Transaction> transaction = transactionRepository.findById(id);
            if (transaction.isPresent()){
                transactionRepository.delete(transaction.get());
                return true;
            }
        }
        return false;
    }

    public Transaction getById(Long wallet_id,Long id){
        Optional<Wallet> wallet = walletRepository.findById(wallet_id);
        if (wallet.isPresent()){
            Optional<Transaction> transaction = transactionRepository.findById(id);
            if (transaction.isPresent()){
                return transaction.get();
            }
        }
        return  null;
    }
}
