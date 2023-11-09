package com.codewithsowmiya.JpaTodo.Controller;

import com.codewithsowmiya.JpaTodo.Model.Todo;
import com.codewithsowmiya.JpaTodo.Model.User;
import com.codewithsowmiya.JpaTodo.Request.TodoRequest;
import com.codewithsowmiya.JpaTodo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{userId}")
    public List<Todo> findAll(@PathVariable int userId) {
        return todoService.getAllTodo(userId);
    }

    @PostMapping
    public List<Todo> createTodo(@RequestBody TodoRequest todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody TodoRequest todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> deleteTodoById(@PathVariable int id) {
        return todoService.deleteTodoById(id);
    }
}
