package SDA.DesignPaterns.State.PatientsService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Patient {
    private PatientState state;
    private String name;
    private LocalDate visitDate;
    private Map<LocalDate,String> medicalRecords;

    public Patient(String name) {
        this.state = new RegisteringState();
        this.name = name;
        medicalRecords = new HashMap<>();
    }

    public PatientState getState() {
        return state;
    }

    public void setState(PatientState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Map<LocalDate, String> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(Map<LocalDate, String> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
