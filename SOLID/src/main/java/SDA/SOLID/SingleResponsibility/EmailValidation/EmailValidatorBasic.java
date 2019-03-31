package SDA.SOLID.SingleResponsibility.EmailValidation;

public class EmailValidatorBasic implements EmailValidatorInterface {

    @Override
    public Boolean validEmail(String email) {
        return email.length() > 3 && email.contains("@");
    }
}
