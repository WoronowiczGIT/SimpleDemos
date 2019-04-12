package SDA.DesignPaterns.State.PatientsService;

import java.time.LocalDate;
import java.util.Map;

public class WaitingState implements PatientState {

    @Override
    public void createVisit(Patient patient, LocalDate date) {
        System.out.println("you already have a visit registred at: "+ patient.getVisitDate()
                             +", please cancel the old one.");
    }

    @Override
    public void cancelVisit(Patient patient) {
        System.out.println("visit on "+ patient.getVisitDate() +" is canceled.");
        patient.setVisitDate(null);
        patient.setState(new RegisteringState());
    }

    @Override
    public void updateRecords(Patient patient, String notes) {
        System.out.println("Available only during visit");
    }

    @Override
    public Map getRecords(Patient patient) {
        System.out.println(" Your medical history: ");
        return patient.getMedicalRecords();
    }
}
