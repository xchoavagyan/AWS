package com.example.ec2_aws.persistance.repos;

import com.example.ec2_aws.persistance.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PersonRepo extends JpaRepository<Person,Long> {
    Person findByName(String name);
    ArrayList<Person> findAllByAge(Integer age);
}
