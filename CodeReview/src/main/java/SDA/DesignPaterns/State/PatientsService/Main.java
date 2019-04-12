package SDA.DesignPaterns.State.PatientsService;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Patient joe = new Patient("Joe");
        PatientService clinic = new PatientService(joe);

        clinic.printPatientState();
        clinic.patientArrived();
        clinic.printPatientState();
        clinic.updateMedicalRecords("katar");
        System.out.println(clinic.printMedicalRecords());
        clinic.printPatientState();
        clinic.createVisit(LocalDate.now());
        clinic.printVisitDate();
        clinic.printPatientState();
        clinic.cancelVisit();
        clinic.updateMedicalRecords("trololo");

    }
}
