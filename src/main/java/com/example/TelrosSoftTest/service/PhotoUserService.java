package com.example.TelrosSoftTest.service;

import com.example.TelrosSoftTest.model.PhotoUserModel;

import java.io.IOException;
import java.util.List;

public interface PhotoUserService {
    boolean create(PhotoUserModel photoUserModel, long id) throws IOException;

    List<PhotoUserModel> readAll();

    PhotoUserModel read(Long id);

    boolean update(byte[] image, Long id);

    boolean delete(Long id);


}
