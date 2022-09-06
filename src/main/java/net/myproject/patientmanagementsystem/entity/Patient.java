package net.myproject.patientmanagementsystem.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_last_name")
    @NotBlank(message = "Name and surname should not be empty")
    @Size(min = 3, max = 100, message = "Name and surname should be between 3 and 100")
    @Pattern(regexp = "[A-Za-z ]*", message = "Enter a letter value ")
    private String firstLastName;

    @Column(name = "ward")
    @Min(value = 1, message = "Ward should be greater than 0")
    @Max(value = 50, message = "Ward should be lower than 51")
    private int ward;

    @Column(name = "diagnosis")
    @NotBlank(message = "Diagnosis should not be empty")
    @Size(min = 2, max = 100, message = "Diagnosis should be between 2 and 100")
    @Pattern(regexp = "[A-Za-z ]*", message = "Enter a letter value ")
    private String diagnosis;

    @Column(name = "treatment")
    @NotBlank(message = "Treatment should not be empty")
    @Size(min = 2, max = 200, message = "Treatment should be between 2 and 200")
    @Pattern(regexp = "[A-Za-z ]*", message = "Enter a letter value ")
    private String treatment;

    public Patient(Long id, String firstLastName, int ward, String diagnosis, String treatment) {
        this.id = id;
        this.firstLastName = firstLastName;
        this.ward = ward;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstLastName='" + firstLastName + '\'' +
                ", ward=" + ward +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
