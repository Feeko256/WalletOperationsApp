package com.feeko256.wallet.tests;

import com.feeko256.wallet.service.enums.OperationType;
import com.feeko256.wallet.service.walletApi.WalletSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletNegativeTests extends BaseTest {

    private static Response response;

    @BeforeEach
    void getWallet() {
        response = WalletSteps.getByUuid(TEST_UUID_LOW_BALANCE);
        Assertions.assertEquals(200, response.getStatusCode());

        response = WalletSteps.setBalanceToWallet(TEST_UUID_LOW_BALANCE, FIX_AMOUNT_LOW);
    }

    @Test
    void checkInvalidWalletTest() {
        response = WalletSteps.getByUuid(ERROR_UUID);
        Assertions.assertEquals(404, response.getStatusCode());
    }

    @Test
    void updateWalletWithdrawNegativeTest() {
        response = WalletSteps.updateWalletByUuid(TEST_UUID_LOW_BALANCE, TEST_AMOUNT, OperationType.WITHDRAW);
        Assertions.assertEquals(400, response.getStatusCode());
    }
}
