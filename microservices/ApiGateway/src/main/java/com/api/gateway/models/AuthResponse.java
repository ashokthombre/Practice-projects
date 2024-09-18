package com.api.gateway.models;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthResponse {

    private String userId;

    private String accessToken;

    private String refreshToken;

    private long expireAt;

    private Collection<String> authorities;
}
