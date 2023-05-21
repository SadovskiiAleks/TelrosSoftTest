package com.example.TelrosSoftTest.controllers;

import com.example.TelrosSoftTest.model.ContactInformationModel;
import com.example.TelrosSoftTest.service.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactInformation {

    private final ContactInformationService contactInformationService;

    @Autowired
    public ContactInformation(ContactInformationService contactInformationService) {
        this.contactInformationService = contactInformationService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody ContactInformationModel contactInformationModel) {
        contactInformationService.create(contactInformationModel);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<ContactInformationModel>> read() {
        final List<ContactInformationModel> users = contactInformationService.readAll();

        if (users != null && !users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<ContactInformationModel> read(@PathVariable(name = "id") Long id) {

        final ContactInformationModel user = contactInformationService.read(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody ContactInformationModel user) {
        final boolean updated = contactInformationService.update(user, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = contactInformationService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
