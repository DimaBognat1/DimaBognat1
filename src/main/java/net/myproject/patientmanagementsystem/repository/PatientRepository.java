package net.myproject.patientmanagementsystem.repository;

import net.myproject.patientmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
