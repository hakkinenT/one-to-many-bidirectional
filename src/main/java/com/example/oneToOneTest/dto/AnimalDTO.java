package com.example.oneToOneTest.dto;

import com.example.oneToOneTest.entities.Animal;

public class AnimalDTO {
    private Long id;
    private String name;
    private Integer age;
    private Long clientId;

    public AnimalDTO(Long id, String name, Integer age, Long clientId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clientId = clientId;
    }

    public AnimalDTO(Animal entity) {
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
        clientId = entity.getClient().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getClientId() {
        return clientId;
    }
}
