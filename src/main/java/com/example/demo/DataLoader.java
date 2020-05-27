package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    ToDoListRepository toDoListRepository;
    @Override
    public void run(String... Strings) throws Exception {
        ToDoList newList = new ToDoList("Laundary","Washing cloths","High","May 27, 2020",true);
        toDoListRepository.save(newList);
        newList = new ToDoList("Cooking Dinner","Cooking food for holiday","High","Jan 01, 2021",false);
        toDoListRepository.save(newList);
        newList = new ToDoList("Tax","Submitting tax form","High","Jun 05, 2020",false);
        toDoListRepository.save(newList);

    }
}
