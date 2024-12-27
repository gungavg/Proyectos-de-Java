package com.example.auth_service_artifact.repositories;

import com.example.auth_service_artifact.comons.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
