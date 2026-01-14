package ToDo.app.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import ToDo.app.app.Entities.TodoItem;
import ToDo.app.app.Services.ToDoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService service) {
        toDoService = service;
    }

    @GetMapping("/gettodos")
    public List<TodoItem> GetTodos() {
        return toDoService.GetAllTodos();
    }

    @GetMapping("/{id}")
    public TodoItem GetTodoById(@PathVariable Long id) {        //error handling neccessary
        return toDoService.GetTodoById(id).get();   
    }

    @PostMapping("/createTodo")
    public TodoItem CreateTodo(@RequestBody TodoItem item) {
        return toDoService.CreateTodo(item);
    }

    @DeleteMapping("/{id}")
    public void DeleteTodo(@PathVariable Long id) {
        toDoService.DeleteTodo(id);
    }

    @PutMapping("/{id}")
    public String UpdateTodo(@PathVariable Long id) {
        //return toDoService.UpdateTodo(id);
        return "to be completed";
    }
}