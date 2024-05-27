package org.scaler.userservice.repository;

import org.scaler.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;


public interface TokenRepository extends JpaRepository<Token, Long> {
    @Override
    Token save(Token token);


    Optional<Token> findByValueAndActive(String tokenValue, boolean active);
    /*

    select * from tokens where value = tokenValue and deleted = false and expiry_date > time.
     */
    Optional<Token> findByValueAndActiveAndExpiryGreaterThan(String tokenValue, boolean valid, Date currentTime);
}
