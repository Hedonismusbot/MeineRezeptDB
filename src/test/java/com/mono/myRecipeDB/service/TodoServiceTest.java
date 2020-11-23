package com.mono.myRecipeDB.service;


import com.mono.myRecipeDB.model.Prio;
import com.mono.myRecipeDB.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoService service ;

    @Test
    void list() {
       List<Todo> list =  service.list();
        assertEquals(2,list.size());
    }

    @Test   // Public
    void save() {
       Todo t =  service.save(new Todo ("abwaschen" , false, LocalDate.now(), Prio.HIGH ));
       System.out.println(t);
       assertNotNull(t);
    }


    @Test
    void find() {
      Todo t = service.find(1);
        assertNotNull(t);
    }

    @Test
    void updateDone() {
        Todo t = service.updateDone(1,true);
        assertNotNull(t);
        assertTrue(t.isDone());
     //   System.out.println("Update: " +t );
    }

    @Test
    void delete() {
     //   fail(); // Wichtig fail reinschreiben wenn noch nicht implementiert
      Todo t =  service.save(new Todo ("löschtodo" , false, LocalDate.now(), Prio.LOW ));
      Todo dt = service.find(t.getId());
      System.out.println("Vor löschen -> " + dt);
      service.delete(dt);
      Todo t2 = service.find(dt.getId());
      System.out.println("Nach löschen -> " + t2);
      assertNull(t2);
    }
}