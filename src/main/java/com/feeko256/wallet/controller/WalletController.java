package com.feeko256.wallet.controller;

import com.feeko256.wallet.dto.WalletDto;
import com.feeko256.wallet.entity.WalletEntity;
import com.feeko256.wallet.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping("/wallets")
    public List<WalletEntity> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping("/wallet/{uuid}")
    public WalletEntity getWalletByUuid(@PathVariable UUID uuid) {
        return walletService.getWalletByUUID(uuid);
    }

    @PostMapping("/wallet")
    private WalletEntity createWallet(@RequestBody WalletDto wallet) {
        return walletService.updateWallet(wallet);
    }
}
