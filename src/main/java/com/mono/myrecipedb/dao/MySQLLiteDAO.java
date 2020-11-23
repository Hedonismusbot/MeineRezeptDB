package com.mono.myrecipedb.dao;

import com.mono.myrecipedb.model.RecipeMySQLLite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySQLLiteDAO extends JpaRepository<RecipeMySQLLite, Long> {


    RecipeMySQLLite findById(int id );
}
