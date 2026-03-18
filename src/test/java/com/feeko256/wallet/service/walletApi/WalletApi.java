package com.feeko256.wallet.service.walletApi;

import com.feeko256.wallet.service.baseApi.BaseApi;
import com.feeko256.wallet.service.specification.Specification;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.UUID;

public class WalletApi extends BaseApi {
    private static final String HOST = "http://localhost";
    private static final String PATH = "/api/v1";
    private static final String ENDPOINT_ = "/wallets";
    private static final String ENDPOINT = "/wallet/{uuid}";
    private static final String REQUEST_PATH = "uuid";
    private static final RequestSpecification SPEC = Specification.getSpecification(HOST, PATH);

    protected static Response getAllWallets(){
        return GET(SPEC, ENDPOINT_);
    }

    protected static Response getWalletByUuid(UUID uuid){
        return GET(SPEC, ENDPOINT, REQUEST_PATH, uuid);
    }
}
