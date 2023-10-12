package org.teamhub.groupware.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("refreshToken")
public class RefreshToken {

    @Id
    private String token;

    private String id;

    private Date expiryDate;
}

