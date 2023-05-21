package com.example.TelrosSoftTest.service;


import com.example.TelrosSoftTest.model.DetailedContactInformationModel;
import com.example.TelrosSoftTest.repository.ContactInformationRepository;
import com.example.TelrosSoftTest.repository.DetailedContactInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailedContactInformationServiceImpl implements DetailedContactInformationService {

    @Autowired
    private DetailedContactInformationRepository detailedContactInformationRepository;
    @Autowired
    private ContactInformationRepository contactInformationRepository;

    @Override
    public boolean create(DetailedContactInformationModel detailedContactInformationModel, long id) {
        if (!detailedContactInformationRepository.existsById(id)) {
            detailedContactInformationRepository.save(detailedContactInformationModel);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<DetailedContactInformationModel> readAll() {

        return detailedContactInformationRepository.findAll();
    }

    @Override
    public DetailedContactInformationModel read(Long id) {
        if (detailedContactInformationRepository.existsById(id)) {
            return detailedContactInformationRepository.getReferenceById(id);
        } else {
            return null;
        }

    }

    @Override
    public boolean update(DetailedContactInformationModel detailedContactInformationModel,
                          Long id) {
        if (detailedContactInformationRepository.existsById(id)) {
            detailedContactInformationModel.setId(id);
            detailedContactInformationRepository.save(detailedContactInformationModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (detailedContactInformationRepository.existsById(id)) {
            detailedContactInformationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
