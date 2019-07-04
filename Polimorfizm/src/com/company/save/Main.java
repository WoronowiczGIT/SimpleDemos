package com.company.save;

public class Main {
    public static void main(String[] args) {
        Chmura obloczek = new Chmura();
        DataMenager menagier2 = new DataMenager(obloczek);
        menagier2.dodajDane();


        Repository repo;
        boolean internetConnection = false;
        if(internetConnection){
            repo = new Chmura();
        }else{
            repo = new Dysk();
        }
        DataMenager menagier = new DataMenager(repo);
        repo = new Brain();
        DataMenager brainMenager = new DataMenager(repo);

        menagier.wyswietlDane();
        brainMenager.dodajDane();
    }
}
