package com.example.zoo.repos;

import com.example.zoo.domain.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalsRepo extends JpaRepository<Animals,Long> {
    List<Animals> findAllByName(String name);

    @Query(value = "select * from Animals where view = ?1", nativeQuery = true)
    List<Animals> findAllView(String view);

    @Query(value = "select * from Animals where predator = ?1", nativeQuery = true)
    List<Animals> findAllPred(boolean pred);

    @Query(value = "select * from Animals where name Like %?1%", nativeQuery = true)
    List<Animals> findAllName(String name);
}
