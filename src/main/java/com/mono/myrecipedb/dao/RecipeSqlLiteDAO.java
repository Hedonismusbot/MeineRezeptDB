package com.mono.myrecipedb.dao;

import com.mono.myrecipedb.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeSqlLiteDAO extends JpaRepository<Recipe, Long> {


    Recipe findById(int id );
    List<Recipe> findAllByNameContaining(String name );

}
