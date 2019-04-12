package SDA.DesignPaterns.State.PatientsService;

import java.time.LocalDate;
import java.util.Map;

public class VisitingState implements PatientState{

    @Override
    public void createVisit(Patient patient, LocalDate date) {
        patient.setState(new RegisteringState());
        patient.setVisitDate(date);
        System.out.println("next visit on: "+ date+", thank you and goodbye");
    }

    @Override
    public void cancelVisit(Patient patient) {
        System.out.println("cant cancel ongoing visit");
    }

    @Override
    public void updateRecords(Patient patient, String notes) {
        System.out.println("meddical records updated");
        patient.getMedicalRecords().put(LocalDate.now(),notes);
    }

    @Override
    public Map getRecords(Patient patient) {
        System.out.println(" Your medical history: ");
        return patient.getMedicalRecords();
    }
}
