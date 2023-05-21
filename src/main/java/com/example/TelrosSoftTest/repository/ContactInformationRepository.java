package com.example.TelrosSoftTest.repository;

import com.example.TelrosSoftTest.model.ContactInformationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInformationRepository extends JpaRepository<ContactInformationModel, Long> {
}
