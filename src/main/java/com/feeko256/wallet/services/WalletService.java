package com.feeko256.wallet.services;

import com.feeko256.wallet.dto.WalletDto;
import com.feeko256.wallet.entity.WalletEntity;
import com.feeko256.wallet.enums.OperationType;
import com.feeko256.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public WalletEntity updateWallet(WalletDto dto) {
        WalletEntity wallet = getWalletByUUID(dto.getUuid());

        if (dto.getOperationType().equals(OperationType.DEPOSIT)) {
            wallet.deposit(dto.getAmount());
        } else {
            wallet.withdraw(dto.getAmount());
        }

        return walletRepository.save(wallet);
    }

    public WalletEntity getWalletByUUID(UUID uuid) {
        return walletRepository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Wallet not found"));
    }

    public List<WalletEntity> getAllWallets() {
        return walletRepository.findAll();
    }
}