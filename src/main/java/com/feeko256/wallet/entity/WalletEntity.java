package com.feeko256.wallet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "wallets")
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private long amount;
    @Version
    private Long version;

    public void deposit(long amount) {
        this.amount += amount;
    }

    public boolean checkAmount(long amount) {
        return this.amount >= amount;
    }

    public void withdraw(long amount) {
        this.amount -= amount;
    }
}
