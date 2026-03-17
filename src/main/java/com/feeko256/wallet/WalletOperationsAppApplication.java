package com.feeko256.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableJpaRepositories("com.feeko256.wallet.repository")
@EnableRetry
public class WalletOperationsAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletOperationsAppApplication.class, args);
    }
}
