package com.codewithsowmiya.JpaTodo.Service;

import com.codewithsowmiya.JpaTodo.Model.Todo;
import com.codewithsowmiya.JpaTodo.Model.User;
import com.codewithsowmiya.JpaTodo.Repository.TodoRepository;
import com.codewithsowmiya.JpaTodo.Repository.UserRepository;
import com.codewithsowmiya.JpaTodo.Request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Todo> getAllTodo(int userId) {
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getUser().getUserid() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> createTodo(TodoRequest todo) {
        Todo originalTodo=new Todo();
        originalTodo.setItems(todo.getTodo());
        User user=userRepository.findById(todo.getUserId()).get();
        originalTodo.setUser(user);
        todoRepository.save(originalTodo);
        return getAllTodo(todo.getUserId());

    }

    public List<Todo> updateTodo(TodoRequest todoRequest) {
        Todo originalTodo=new Todo();
        originalTodo.setId(todoRequest.getId());
        originalTodo.setItems(todoRequest.getTodo());
        User user=userRepository.findById(todoRequest.getUserId()).get();
        originalTodo.setUser(user);
        todoRepository.save(originalTodo);
        return getAllTodo(todoRequest.getUserId());

    }

    public List<Todo> deleteTodoById(Integer id) {
       int userId=todoRepository.findById(id).get().getUser().getUserid();
       todoRepository.deleteById(id);
       return getAllTodo(userId);
    }
}
