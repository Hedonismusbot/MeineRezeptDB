package com.mono.myRecipeDB.service ;


import com.mono.myRecipeDB.dao.TodoDAO;
import com.mono.myRecipeDB.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Implmentierungen , konkrete aufbereitetet Methoden
    - kann geneuso wie DAO ein Interface sein
 */
@Service
public class TodoService {

    @Autowired // Erzeugt/holt Instanz , dependencyinjection (@Inject geht auch )
    private TodoDAO dao ;

    public List <Todo> list (){
        return dao.findAll();
    }
    public Todo save(Todo t){
     return dao.save(t);
    }
    public Todo find (int id ){
        return dao.findById(id);
    }

    public Todo updateDone(int id , boolean done){
        Todo t = dao.findById(id);
        t.setDone(true);
        return dao.save(t);
    }
    //TODO Ändern Rückgabewerte hinzufügen
    public void delete (Todo t ){
        dao.delete(t);
    }


}
