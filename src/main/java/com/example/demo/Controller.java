package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    ToDoListRepository toDoListRepository;


    @RequestMapping("/home")
    public String displayToDoList(Model model){
        model.addAttribute("allToDoList",toDoListRepository.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String addToDoListForm(Model model){
        model.addAttribute("newToDoList", new ToDoList());
        return "addForm";
    }

    @PostMapping("/check")
    public String processForm(@Valid @ModelAttribute("newToDoList") ToDoList list, BindingResult result){
        if(result.hasErrors()){
            return "addForm";
        }
        toDoListRepository.save(list);
        return "redirect:/home";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        model.addAttribute("newToDoList", toDoListRepository.findById(id).get());
        return "addForm";
    }

    @RequestMapping("/detail/{id}")
    public String viewMore(@PathVariable("id") long id, Model model){
        model.addAttribute("list", toDoListRepository.findById(id).get());
        return "display";
    }

    @RequestMapping("/delete/{id}")
    public String deleteList(@PathVariable("id") long id, Model model){
        toDoListRepository.deleteById(id);
        return "redirect:/home";
    }
}
