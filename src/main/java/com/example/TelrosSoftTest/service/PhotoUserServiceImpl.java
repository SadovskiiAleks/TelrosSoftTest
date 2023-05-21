package com.example.TelrosSoftTest.service;


import com.example.TelrosSoftTest.model.PhotoUserModel;
import com.example.TelrosSoftTest.repository.PhotoUserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoUserServiceImpl implements PhotoUserService {

    @Autowired
    PhotoUserModelRepository photoUserModelRepository;

    @Override
    public boolean create(PhotoUserModel photoUserModel, long id) {

        if (!photoUserModelRepository.existsById(id)){
            photoUserModelRepository.save(photoUserModel);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<PhotoUserModel> readAll() {
        return null;
    }

    @Override
    public PhotoUserModel read(Long id) {
        if (photoUserModelRepository.existsById(id)){
            return photoUserModelRepository.getReferenceById(id);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(byte[] image, Long id) {

        if (photoUserModelRepository.existsById(id)) {
            PhotoUserModel photoUserModel = photoUserModelRepository.getReferenceById(id);
            photoUserModel.setImageData(image);
            photoUserModelRepository.save(photoUserModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (photoUserModelRepository.existsById(id)) {
            photoUserModelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
