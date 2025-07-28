package com.example.todo.controller;

import com.example.todo.model.TodoItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    private List<TodoItem> todoList = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("todos" , todoList);
        return "index";
    }
    @PostMapping("/add")
    public String addTodo(@RequestParam String task){
        System.out.println("Task received: " + task);
        todoList.add(new TodoItem(task));
        return "redirect:/";
    }

    @GetMapping("/delete/{index}")
    public String deleteTodo(@PathVariable int index) {
        if (index >= 0 && index < todoList.size()) {
            todoList.remove(index);
        }
        return "redirect:/";
    }

    @GetMapping("/toggle/{index}")
    public String toggleComplete(@PathVariable int index) {
        if (index >= 0 && index < todoList.size()) {
            TodoItem item = todoList.get(index);
            item.setCompleted(!item.isCompleted()); //  flip the status
        }
        return "redirect:/";
    }


}
