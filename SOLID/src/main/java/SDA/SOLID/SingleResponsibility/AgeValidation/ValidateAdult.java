package SDA.SOLID.SingleResponsibility.AgeValidation;

public class ValidateAdult implements ValidateAge{
    @Override
    public Boolean validate(Integer age) {
        if(age>18){return true;}
        return false;
    }
}
