package com.spring.walletapp.repository;

import com.spring.walletapp.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    List<Wallet> findAllByOrderByPriority();
    @Query("Select case when count(s)>0 then true else false enf from Wallet w where w.id=?1")
    Boolean isWalletExitsById(Long id);
}
