package com.example.TelrosSoftTest.service;

import com.example.TelrosSoftTest.model.DetailedContactInformationModel;

import java.util.List;

public interface DetailedContactInformationService {
    boolean create(DetailedContactInformationModel detailedContactInformationModel, long id);

    List<DetailedContactInformationModel> readAll();

    DetailedContactInformationModel read(Long id);

    boolean update(DetailedContactInformationModel detailedContactInformationModel, Long id);

    boolean delete(Long id);
}
