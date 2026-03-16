package com.feeko256.wallet.dto;

import com.feeko256.wallet.enums.OperationType;
import lombok.Data;

import java.util.UUID;

@Data
public class WalletDto {
    private UUID uuid;
    private OperationType operationType;
    private long amount;
}
