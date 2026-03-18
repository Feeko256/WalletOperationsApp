package com.feeko256.wallet.tests;

import com.feeko256.wallet.service.dto.WalletResponseDto;
import com.feeko256.wallet.service.walletApi.WalletSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;


class WalletOperationsAppApplicationTests {

    @Test
    void contextLoads() {
        List<WalletResponseDto> wallets = WalletSteps.GetAll();
        WalletResponseDto walletDto = WalletSteps.getByUuid(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"));

        Assertions.assertEquals(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), walletDto.getUuid());
    }

}
