package com.mono.myrecipedb.dao;

import com.mono.myrecipedb.model.RecipeSqlLite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeSqlLiteDAO extends JpaRepository<RecipeSqlLite, Long> {


    RecipeSqlLite findById(int id );
}
