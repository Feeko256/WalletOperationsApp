package com.feeko256.wallet.service.walletApi;



import com.feeko256.wallet.service.dto.WalletResponseDto;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class WalletSteps extends WalletApi {
    public static List<WalletResponseDto> GetAll() {
        Response response = getAllWallets();
        return Arrays.asList(response.getBody().as(WalletResponseDto[].class));
    }

    public static WalletResponseDto getByUuid(UUID uuid) {
        Response response = getWalletByUuid(uuid);
        return response.as(WalletResponseDto.class);
    }

}
