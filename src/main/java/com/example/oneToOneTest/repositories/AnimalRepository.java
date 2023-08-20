package com.example.oneToOneTest.repositories;

import com.example.oneToOneTest.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
