package com.company.save;

public class DataMenager{

private final Repository repository;

    DataMenager(Repository repozytorium){

    this.repository = repozytorium;

    }

    void wyswietlDane(){
        repository.load();
    }
    void dodajDane(){
        repository.save();
    }

}
