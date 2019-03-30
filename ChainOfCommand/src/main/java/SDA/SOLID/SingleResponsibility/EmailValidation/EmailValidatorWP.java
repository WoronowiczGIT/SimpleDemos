package SDA.SOLID.SingleResponsibility.EmailValidation;

public class EmailValidatorWP implements EmailValidatorInterface {
    @Override
    public Boolean validEmail(String email) {
        EmailValidatorBasic evb = new EmailValidatorBasic();

        if (evb.validEmail(email)) {
            return email.toLowerCase().contains("@wp.pl");
        } else return false;
    }

}

