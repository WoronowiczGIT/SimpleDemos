package SDA.SOLID.SingleResponsibility;

import SDA.SOLID.SingleResponsibility.AgeValidation.ValidateAdult;
import SDA.SOLID.SingleResponsibility.EmailValidation.EmailValidatorWP;
import SDA.SOLID.SingleResponsibility.NamePresentation.ShortNamePresentation;
import SDA.SOLID.SingleResponsibility.Taxes.CalculateVAT;
import SDA.SOLID.SingleResponsibility.Taxes.Enterpreneur;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        user.setName("Jan");
        user.setLastName("Kowalski");

        user.setEmail("@WP.pl");
        user.setAge(21);

        EmailValidatorWP wpValidator = new EmailValidatorWP();
        ValidateAdult adultValidator = new ValidateAdult();
        ShortNamePresentation snp = new ShortNamePresentation();

        boolean wpV = wpValidator.validEmail(user.getEmail());
        boolean v18 = adultValidator.validate(user.getAge());
        String namePres = snp.presentName(user);

        System.out.println("email wp: "+wpV);
        System.out.println("age 18+: "+v18);
        System.out.println("name: "+ namePres);


        Enterpreneur ent = new Enterpreneur();
        CalculateVAT vat = new CalculateVAT();
        Double income = 5000D;
        ent.setBusiness("big");
        ent.setIncome(income);
        System.out.println(vat.calculate(ent));


    }
}
