package com.example.demo3;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//tworzymy interface rozszerzajacy JpaRepository
@Repository
interface PersonRepository extends JpaRepository<Person,Long> {

}
