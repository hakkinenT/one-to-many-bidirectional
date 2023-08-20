package com.example.oneToOneTest.services;

import com.example.oneToOneTest.dto.AnimalClientDTO;
import com.example.oneToOneTest.dto.AnimalDTO;
import com.example.oneToOneTest.entities.Address;
import com.example.oneToOneTest.entities.Animal;
import com.example.oneToOneTest.entities.Client;
import com.example.oneToOneTest.repositories.AnimalRepository;
import com.example.oneToOneTest.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public AnimalDTO simpleInsert(AnimalDTO dto){
        Animal animal = new Animal();
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());

        Client client = new Client();
        client.setId(dto.getClientId());

        animal.setClient(client);
        animal = animalRepository.save(animal);

        return new AnimalDTO(animal);
    }

    @Transactional
    public AnimalDTO complexInsert(AnimalDTO dto){
        Animal animal = new Animal();
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());

        Client client = clientRepository.getReferenceById(dto.getClientId());
        //client.setId(dto.getClientId());

        animal.setClient(client);
        animal = animalRepository.save(animal);

        return new AnimalDTO(animal);
    }

    @Transactional
    public AnimalClientDTO simpleInsert2(AnimalClientDTO dto){
        Animal animal = new Animal();
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());

        Client client = new Client();
        client.setId(dto.getClient().getId());

        animal.setClient(client);
        animal = animalRepository.save(animal);

        return new AnimalClientDTO(animal);
    }

    @Transactional
    public AnimalClientDTO complexInsert2(AnimalClientDTO dto){
        Animal animal = new Animal();
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());

        Client client = clientRepository.getReferenceById(dto.getClient().getId());
        //client.setId(dto.getClientId());

        animal.setClient(client);
        animal = animalRepository.save(animal);

        return new AnimalClientDTO(animal);
    }

    @Transactional
    public AnimalClientDTO update(Long id, AnimalClientDTO dto){

        Animal animal = animalRepository.getReferenceById(id);
        animal.setName(dto.getName());
        animal.setAge(dto.getAge());

        animal = animalRepository.save(animal);

        return new AnimalClientDTO(animal);
    }

    @Transactional(readOnly = true)
    public AnimalClientDTO findById(Long id){

        Animal animal = animalRepository.findById(id).get();

        return new AnimalClientDTO(animal);
    }

    @Transactional(readOnly = true)
    public List<AnimalClientDTO> findAll(){

        List<Animal> animals = animalRepository.findAll();

        return animals.stream().map(animal -> new AnimalClientDTO(animal)).collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        animalRepository.deleteById(id);
    }
}
