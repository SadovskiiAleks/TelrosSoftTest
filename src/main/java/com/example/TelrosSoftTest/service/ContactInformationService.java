package com.example.TelrosSoftTest.service;

import com.example.TelrosSoftTest.model.ContactInformationModel;

import java.util.List;

public interface ContactInformationService {

    void create(ContactInformationModel contactInformationModel);

    List<ContactInformationModel> readAll();

    ContactInformationModel read(Long id);

    boolean update(ContactInformationModel contactInformationModel, Long id);

    boolean delete(Long id);
}
