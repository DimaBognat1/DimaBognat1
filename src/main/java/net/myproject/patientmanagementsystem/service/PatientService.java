package net.myproject.patientmanagementsystem.service;

import net.myproject.patientmanagementsystem.entity.Patient;

import java.util.List;

public interface PatientService {


    List<Patient> findAll();

    Patient savePatient(Patient patient);

    Patient findById(Long id);


    void deleteById(Long id);

}
