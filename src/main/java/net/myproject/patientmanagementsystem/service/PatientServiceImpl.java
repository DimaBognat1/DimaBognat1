package net.myproject.patientmanagementsystem.service;

import net.myproject.patientmanagementsystem.entity.Patient;
import net.myproject.patientmanagementsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

//    @Override
//    public Patient updatePatient(Long id, Patient patient) {
//        patientRepository.deleteById(id);
//        return patientRepository.save(patient);
//    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
