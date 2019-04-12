package SDA.DesignPaterns.State.PatientsService;

import java.time.LocalDate;
import java.util.Map;

interface PatientState {
     void createVisit(Patient patient, LocalDate date);
     void cancelVisit(Patient patient);
     void updateRecords(Patient patient, String notes);
     Map getRecords(Patient patient);

     default void showState(Patient patient){
         System.out.println(patient.getState().getClass().getSimpleName());
     }
}
