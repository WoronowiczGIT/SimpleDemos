package SDA.SOLID.SingleResponsibility.NamePresentation;

import SDA.SOLID.SingleResponsibility.User;

public class ShortNamePresentation implements NamePresentationInterface{

    @Override
    public String presentName(User user) {
        String result="";
        for (int i = 0; i < 2 ; i++) {
            result+=(user.getName().charAt(i));
        }
        for (int i = 0; i < 2 ; i++) {
            result+=(user.getLastName().charAt(i));
        }
        return result.toUpperCase();
    }
}
