package com.feeko256.wallet.services;

import com.feeko256.wallet.dto.WalletDto;
import com.feeko256.wallet.entity.WalletEntity;
import com.feeko256.wallet.enums.OperationType;
import com.feeko256.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;


    @Retryable(
            retryFor = {ObjectOptimisticLockingFailureException.class},
            maxAttempts = 15,
            backoff = @Backoff(delay = 50, multiplier = 1.5)
    )
    @Transactional
    public WalletEntity updateWallet(WalletDto dto) {
        WalletEntity wallet = getWalletByUUID(dto.getUuid());

        if (dto.getOperationType().equals(OperationType.DEPOSIT)) {
            wallet.deposit(dto.getAmount());
        } else {
            if (!wallet.checkAmount(dto.getAmount())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Недостаточный баланс: в кошельке: %d, запрос: %d",
                        wallet.getAmount(), dto.getAmount()));
            }
            wallet.withdraw(dto.getAmount());
        }
        return walletRepository.save(wallet);
    }

    public WalletEntity getWalletByUUID(UUID uuid) {
        return walletRepository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Кошелек не найден"));
    }
}