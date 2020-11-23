package com.mono.myRecipeDB.dao;

import com.mono.myRecipeDB.model.RecipeMySQLLite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySQLLiteDAO extends JpaRepository<RecipeMySQLLite, Long> {


}
