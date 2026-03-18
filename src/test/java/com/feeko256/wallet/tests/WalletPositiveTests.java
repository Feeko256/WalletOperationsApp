package com.feeko256.wallet.tests;

import com.feeko256.wallet.service.enums.OperationType;
import com.feeko256.wallet.service.walletApi.WalletSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class WalletPositiveTests extends BaseTest {
    private static Response response;

    @BeforeEach
    void getWallet() {
        response = WalletSteps.getByUuid(TEST_UUID);
        Assertions.assertEquals(200, response.getStatusCode());

        response = WalletSteps.setBalanceToWallet(TEST_UUID, FIX_AMOUNT);
    }

    @Test
    void checkValidWalletTest() {
        Assertions.assertEquals(TEST_UUID, WalletSteps.responseToDto(response).getUuid());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    void updateWalletDepositTest() {
        long currentAmount = WalletSteps.responseToDto(response).getAmount();
        long expectedAmount = currentAmount + TEST_AMOUNT;

        response = WalletSteps.updateWalletByUuid(TEST_UUID, TEST_AMOUNT, OperationType.DEPOSIT);
        Assertions.assertEquals(expectedAmount, WalletSteps.responseToDto(response).getAmount());
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    void updateWalletWithdrawTest() {
        long currentAmount = WalletSteps.responseToDto(response).getAmount();
        long expectedAmount = currentAmount - TEST_AMOUNT;

        response = WalletSteps.updateWalletByUuid(TEST_UUID, TEST_AMOUNT, OperationType.WITHDRAW);
        Assertions.assertEquals(expectedAmount, WalletSteps.responseToDto(response).getAmount());
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
