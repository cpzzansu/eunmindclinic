package org.teamhub.groupware.common.repository;

import org.springframework.data.repository.CrudRepository;
import org.teamhub.groupware.common.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
