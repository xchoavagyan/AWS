package com.example.ec2_aws.facade.person;

import com.example.ec2_aws.annotations.Facade;
import com.example.ec2_aws.controller.person.models.PersonRequestModel;
import com.example.ec2_aws.controller.person.models.PersonResponseModel;
import com.example.ec2_aws.converter.PersonConverter;
import com.example.ec2_aws.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class PersonFacade {

    private final PersonService personService;
    private final PersonConverter personConverter;

    @Autowired
    public PersonFacade(PersonService personService, PersonConverter personConverter) {
        this.personService = personService;
        this.personConverter = personConverter;
    }

    public PersonResponseModel create(PersonRequestModel requestModel) {
        PersonDTO personDTO = personConverter.buildDataObjFromRequest(requestModel);
        PersonDTO savedDataObject = personService.create(personDTO);
        PersonResponseModel responseModel = personConverter.buildResponseFromDataObj(savedDataObject);
        return responseModel;
    }

    public PersonResponseModel getById(Long id) {
        PersonDTO byId = personService.getById(id);
        PersonResponseModel personResponseModel = personConverter.buildResponseFromDataObj(byId);
        return personResponseModel;
    }

    public ArrayList<PersonResponseModel> findAll() {
        ArrayList<PersonDTO> all = personService.findAll();
        List<PersonResponseModel> responseModels = all.stream()
                .map(each -> personConverter.buildResponseFromDataObj(each))
                .collect(Collectors.toList());
        return (ArrayList<PersonResponseModel>) responseModels;
    }

    public PersonResponseModel findByName(String name) {
        PersonDTO byName = personService.findByName(name);
        PersonResponseModel personResponseModel = personConverter.buildResponseFromDataObj(byName);
        return personResponseModel;
    }

    public ArrayList<PersonResponseModel> findAllByAge(Integer age) {
        ArrayList<PersonDTO> all = personService.findAllByAge(age);
        List<PersonResponseModel> responseModels = all.stream()
                .map(each -> personConverter.buildResponseFromDataObj(each))
                .collect(Collectors.toList());
        return (ArrayList<PersonResponseModel>) responseModels;
    }

    public PersonResponseModel updateById(PersonRequestModel requestModel, Long id) {
        PersonDTO personDTO = personConverter.buildDataObjFromRequest(requestModel);
        personDTO.setId(id);
        PersonDTO updateById = personService.updateById(personDTO);
        PersonResponseModel responseModel = personConverter.buildResponseFromDataObj(updateById);
        return responseModel;
    }

    public void deleteById(Long id) {
        personService.deleteById(id);
    }
}
