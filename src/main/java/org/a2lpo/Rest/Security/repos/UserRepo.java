package org.a2lpo.Rest.Security.repos;

import org.a2lpo.Rest.Security.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
