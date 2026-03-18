package com.feeko256.wallet.tests;

import com.feeko256.wallet.service.dto.WalletResponseDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;

import java.util.UUID;

public class BaseTest {
    protected static final UUID TEST_UUID = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
    protected static final UUID ERROR_UUID = UUID.fromString("550e8400-e29b-41d4-a716-446655440022");
    protected static final UUID TEST_UUID_LOW_BALANCE = UUID.fromString("a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11");
    protected static final long TEST_AMOUNT = 200L;
    protected static final long FIX_AMOUNT = 1000L;
    protected static final long FIX_AMOUNT_LOW = 50L;

}
