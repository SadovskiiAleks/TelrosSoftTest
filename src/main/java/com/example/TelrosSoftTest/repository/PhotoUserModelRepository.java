package com.example.TelrosSoftTest.repository;

import com.example.TelrosSoftTest.model.PhotoUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhotoUserModelRepository extends JpaRepository<PhotoUserModel, Long> {
   //Optional<PhotoUserModel> findByName(String name);
}
