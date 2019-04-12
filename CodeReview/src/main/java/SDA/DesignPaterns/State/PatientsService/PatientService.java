package SDA.DesignPaterns.State.PatientsService;

import java.time.LocalDate;
import java.util.Map;

public class PatientService {
    private Patient patient;
    private PatientState state;

    PatientService(Patient patient){
        this.patient = patient;
        this.state = patient.getState();
    }
    public void createVisit(LocalDate date){
        state = patient.getState();
        state.createVisit(patient,date);
    }
    public void cancelVisit(){
        state = patient.getState();
        state.cancelVisit(patient);
    }
    public void printVisitDate(){
        System.out.println(patient.getVisitDate());
    }

    public void patientArrived(){
        this.patient.setState(new VisitingState());
    }
    public void updateMedicalRecords(String notes){
        state = patient.getState();
        state.updateRecords(patient,notes);
    }
    public Map printMedicalRecords(){
        state = patient.getState();
        return state.getRecords(patient);
    }
    public void printPatientState(){
        state = patient.getState();
        state.showState(patient);
    }



}
