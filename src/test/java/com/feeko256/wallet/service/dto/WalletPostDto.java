package com.feeko256.wallet.service.dto;

import com.feeko256.wallet.enums.OperationType;
import lombok.Data;

import java.util.UUID;

@Data
public class WalletPostDto {
    private UUID uuid;
    private OperationType operationType;
    private long amount;
}
