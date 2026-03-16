package com.feeko256.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.feeko256.wallet.repository")
public class WalletOperationsAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletOperationsAppApplication.class, args);
    }
}
