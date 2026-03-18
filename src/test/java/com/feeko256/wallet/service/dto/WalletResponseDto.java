package com.feeko256.wallet.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class WalletResponseDto {
    private UUID uuid;
    private long amount;
    private long version;
}
