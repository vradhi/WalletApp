package com.spring.walletapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.factory.annotation.Autowired;

@SpringBootTest
public class WalletappApplicationTests {

	@Autowired
	private WalletappApplicationTests walletappApplicationTests;
	@Test
	void isWalletExitsById(){
		Wallet wallet = new Wallet(1,"Ram",1234);
		wallet.save(wallet);
		Boolean actualResult = wallet.isWalletExitsById(1);
		assertThat(actualResult).isTrue();
	}
//	void contextLoads() {
//	}

}
