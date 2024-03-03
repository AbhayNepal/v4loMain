package com.v4lo.appuser.repository;

import com.v4lo.appuser.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByEmail(String email);
}
