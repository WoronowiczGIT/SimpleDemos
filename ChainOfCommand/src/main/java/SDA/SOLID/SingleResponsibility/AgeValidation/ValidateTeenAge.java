package SDA.SOLID.SingleResponsibility.AgeValidation;

public class ValidateTeenAge implements ValidateAge {
    @Override
    public Boolean validate(Integer age) {
        if(age > 13 && age < 19){return true;}
        return false;
    }
}
