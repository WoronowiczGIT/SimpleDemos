package SDA.SOLID.SingleResponsibility.Taxes;

import SDA.SOLID.SingleResponsibility.Taxes.CalculateTax;

import javax.xml.bind.TypeConstraintException;

public class CalculateVAT implements CalculateTax {
    @Override
    public Double calculate(Enterpreneur business) {
        String type = business.getBusiness();
        switch(type){
            case "small":
                return business.getIncome()*0.77;
            case "big":
                return business.getIncome()*0.50;

        }

        throw new TypeConstraintException("wrong type");
    }
}
