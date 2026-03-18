package com.feeko256.wallet.service.walletApi;


import com.feeko256.wallet.service.dto.WalletPostDto;
import com.feeko256.wallet.service.dto.WalletResponseDto;
import com.feeko256.wallet.service.enums.OperationType;
import io.restassured.response.Response;

import java.util.UUID;

public class WalletSteps extends WalletApi {
    public static Response getByUuid(UUID uuid) {
        return getWalletByUuid(uuid);
    }

    public static Response updateWalletByUuid(UUID uuid, long amount, OperationType operationType) {
        WalletPostDto walletDto = new WalletPostDto();
        walletDto.setUuid(uuid);
        walletDto.setAmount(amount);
        walletDto.setOperationType(operationType);

        return updateWallet(walletDto);
    }

    public static WalletResponseDto responseToDto(Response response) {
        return response.as(WalletResponseDto.class);
    }

    public static Response setBalanceToWallet(UUID uuid, long amount) {
        WalletPostDto walletPostDto = new WalletPostDto();
        walletPostDto.setUuid(uuid);

        WalletResponseDto walletResponseDto = getWalletByUuid(uuid).as(WalletResponseDto.class);
        long currentAmount = walletResponseDto.getAmount();
        if (currentAmount < 0) {
            walletPostDto.setAmount(amount - currentAmount);
            walletPostDto.setOperationType(OperationType.DEPOSIT);
        } else {
            walletPostDto.setAmount(currentAmount - amount);
            walletPostDto.setOperationType(OperationType.WITHDRAW);

        }
        return updateWallet(walletPostDto);
    }
}
