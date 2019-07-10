package com.company.innerClass;

public class PasswordFactory {
    private String password = "very hard password";

    class PrivatePresenter implements Presenter{
        @Override
        public void present() {
            System.out.println(password);
        }
    }

    public PrivatePresenter createPresenter(){
        return new PrivatePresenter();
    }
}
interface Presenter{ void present();}

class Tester{
    public static void main(String[] args) {
        // You can get an instance of inner private class by using interface
        Presenter p = new PasswordFactory().createPresenter();
        p.present();
    }
}

