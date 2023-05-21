package com.example.TelrosSoftTest.controllers;

import com.example.TelrosSoftTest.model.ContactInformationModel;
import com.example.TelrosSoftTest.model.DetailedContactInformationModel;
import com.example.TelrosSoftTest.service.ContactInformationService;
import com.example.TelrosSoftTest.service.DetailedContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetailedContactInformation {

    private final DetailedContactInformationService detailedContactInformationService;
    private final ContactInformationService contactInformationService;

    @Autowired
    public DetailedContactInformation(DetailedContactInformationService detailedContactInformationService,
                                      ContactInformationService contactInformationService) {
        this.detailedContactInformationService = detailedContactInformationService;
        this.contactInformationService = contactInformationService;
    }

    @PostMapping(value = "/users/{id}/detailed")
    public ResponseEntity<?> create(@RequestBody DetailedContactInformationModel detailedContactInformationModel,
                                    @PathVariable(name = "id") Long id) {

        if (contactInformationService.read(id) != null) {
            final ContactInformationModel user = contactInformationService.read(id);
            detailedContactInformationModel.setContactInformationModel(user);

            if (detailedContactInformationService.create(detailedContactInformationModel, id)) {
                return  new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/users/detailed")
    public ResponseEntity<List<DetailedContactInformationModel>> read() {
        final List<DetailedContactInformationModel> users = detailedContactInformationService.readAll();

        if (users != null &&  !users.isEmpty()) {
            return  new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/users/{id}/detailed")
    public ResponseEntity<DetailedContactInformationModel> read(@PathVariable(name = "id") Long id) {
        final DetailedContactInformationModel detailedContactInformationModel = detailedContactInformationService.read(id);
        if (detailedContactInformationModel != null) {
            return new ResponseEntity<>(detailedContactInformationModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/users/{id}/detailed")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody DetailedContactInformationModel user) {
        final boolean updated = detailedContactInformationService.update(user, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/users/{id}/detailed")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = detailedContactInformationService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
