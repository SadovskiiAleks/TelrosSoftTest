package com.example.TelrosSoftTest.service;

import com.example.TelrosSoftTest.model.ContactInformationModel;
import com.example.TelrosSoftTest.repository.ContactInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    @Autowired
    private ContactInformationRepository contactInformationRepository;

    @Override
    public void create(ContactInformationModel user) {

        contactInformationRepository.save(user);
    }

    @Override
    public List<ContactInformationModel> readAll() {

        return contactInformationRepository.findAll();
    }

    @Override
    public ContactInformationModel read(Long id) {
        if (contactInformationRepository.existsById(id)) {
            return contactInformationRepository.getReferenceById(id);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(ContactInformationModel user, Long id) {
        if (contactInformationRepository.existsById(id)) {
            user.setId(id);
            contactInformationRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (contactInformationRepository.existsById(id)) {
            contactInformationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
