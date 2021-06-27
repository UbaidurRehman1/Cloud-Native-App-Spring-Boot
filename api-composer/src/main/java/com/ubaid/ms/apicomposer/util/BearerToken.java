package com.ubaid.ms.apicomposer.util;

import lombok.Data;

import static com.ubaid.ms.common.Constants.*;


@Data
public class BearerToken {

    private final String bearerToken;

    public BearerToken(String accessToken) {
        this.bearerToken = BEARER_TOKEN + SINGLE_SPACE + accessToken;
    }

}
