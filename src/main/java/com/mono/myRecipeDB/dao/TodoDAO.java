package com.mono.myRecipeDB.dao;


import com.mono.myRecipeDB.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
    DAO- enthält/erbt schon Standard-;ethoden e.g. findAll
 */
@Repository
public interface TodoDAO extends JpaRepository<Todo,Long> {

    // Methoden Original überschreiben /verändert , hinzufügen
    Todo findById(int id);


}
