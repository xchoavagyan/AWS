package com.example.ec2_aws.service.person;

import com.example.ec2_aws.facade.person.PersonDTO;
import com.example.ec2_aws.persistance.entities.Address;
import com.example.ec2_aws.persistance.entities.Person;
import com.example.ec2_aws.persistance.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public PersonDTO create(PersonDTO dto) {
        Person person = personFromDTO(dto);
        Person saved = personRepo.save(person);
        return dtoFromPerson(saved);
    }

    @Override
    public PersonDTO getById(Long id) {
        Person byId = personRepo.getById(id);
        return dtoFromPerson(byId);
    }

    @Override
    public ArrayList<PersonDTO> findAll() {
        List<Person> all = personRepo.findAll();
        List<PersonDTO> dataObjects = all.stream()
                .map(each -> dtoFromPerson(each))
                .collect(Collectors.toList());
        return (ArrayList<PersonDTO>) dataObjects;
    }

    @Override
    public PersonDTO findByName(String name) {
        Person byName = personRepo.findByName(name);
        return dtoFromPerson(byName);
    }

    @Override
    public ArrayList<PersonDTO> findAllByAge(Integer age) {
        ArrayList<Person> allByAge = personRepo.findAllByAge(age);
        List<PersonDTO> dataObjects = allByAge.stream()
                .map(each -> dtoFromPerson(each))
                .collect(Collectors.toList());
        return (ArrayList<PersonDTO>) dataObjects;
    }

    @Override
    public PersonDTO updateById(PersonDTO dto) {
        Person byId = personRepo.getById(dto.getId());
        Address address = byId.getAddress();
        byId.setName(dto.getName());
        byId.setAge(dto.getAge());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        byId.setAddress(address);
        Person saved = personRepo.save(byId);
        return dtoFromPerson(saved);
    }

    @Override
    public void deleteById(Long id) {
        personRepo.deleteById(id);
    }

    private Person personFromDTO(PersonDTO dto) {
        Person person = new Person();
        person.setId(dto.getId());
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        Address address = new Address();
        address.setId(dto.getId());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        person.setAddress(address);
        return person;
    }

    private PersonDTO dtoFromPerson(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setAge(person.getAge());
        personDTO.setAddressId(person.getAddress().getId());
        personDTO.setCity(person.getAddress().getCity());
        personDTO.setStreet(person.getAddress().getStreet());
        return personDTO;
    }
}
