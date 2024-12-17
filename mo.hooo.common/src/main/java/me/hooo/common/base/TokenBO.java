package me.hooo.common.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenBO {

    private String accessToken;

    private String refreshToken;

    private String ticket;
}

