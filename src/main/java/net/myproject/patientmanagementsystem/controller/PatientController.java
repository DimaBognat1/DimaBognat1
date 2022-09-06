package net.myproject.patientmanagementsystem.controller;

import net.myproject.patientmanagementsystem.entity.Patient;
import net.myproject.patientmanagementsystem.service.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/patients")
    public String findAll(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "/patient-list";
    }

    @GetMapping("/patient-create")
    @PreAuthorize("hasAuthority('patients:read')")
    public String createPatientForm(Patient patient) {
        return "patient-create";
    }

    @PostMapping("/patient-create")
    @PreAuthorize("hasAuthority('patients:write')")
    public String createPatient(@Valid Patient patient,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patient-create";
        }
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("patient-delete/{id}")
    @PreAuthorize("hasAuthority('patients:write')")
    public String deletePatient(@PathVariable("id") Long id) {
        patientService.deleteById(id);
        return "redirect:/patients";
    }

    @GetMapping("/patients-edit/{id}")
    @PreAuthorize("hasAuthority('patients:read')")
    public String editPatientForm(@PathVariable("id") Long id, Model model) {
        Patient patient = patientService.findById(id);
        model.addAttribute("patient", patient);
        return "/patient-edit";
    }

    @PostMapping("/patient-edit")
    @PreAuthorize("hasAuthority('patients:write')")
    public String editPatient(@Valid Patient patient,
                              BindingResult bindingResult) {
//        Logger.getLogger("yuliya").warning("inside method editPatient");
//        Logger.getLogger("yuliya").warning("id" + patient.getId());
//        patientService.deleteById(patient.getId());

        if (bindingResult.hasErrors()){
            return "/patient-edit";
        }
        patientService.savePatient(patient);
        return "redirect:/patients";
    }
}
  