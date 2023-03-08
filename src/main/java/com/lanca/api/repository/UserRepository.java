package com.lanca.api.repository;

import com.lanca.api.domain.LoginDTO;
import com.lanca.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPassword(String username, String password);
}
