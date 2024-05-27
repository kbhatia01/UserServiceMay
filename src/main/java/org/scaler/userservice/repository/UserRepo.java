package org.scaler.userservice.repository;

import org.scaler.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User save(User user); // UPSERT

    Optional<User> findByEmail(String email);

}
