package SDA.DesignPaterns.State.PatientsService;

import java.time.LocalDate;
import java.util.Map;

public class RegisteringState implements PatientState{


    @Override
    public void createVisit(Patient patient, LocalDate date) {
        patient.setVisitDate(date);
        patient.setState(new WaitingState());
        System.out.println("new visit on: "+ date);

    }

    @Override
    public void cancelVisit(Patient patient) {
        System.out.println(" You have no visits");
    }

    @Override
    public void updateRecords(Patient patient, String notes) {
        System.out.println(" Available only on  visit");
    }

    @Override
    public Map getRecords(Patient patient) {
        System.out.println(" Your medical history: ");
        return patient.getMedicalRecords();
    }
}
