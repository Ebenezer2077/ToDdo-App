package ToDo.app.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import ToDo.app.app.Services.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public String GetTodos() {
        return toDoService.GetAllTodos();
    }

    @GetMapping("/{id}")
    public String GetTodoById(@PathVariable Long id) {
        return toDoService.GetTodoById(id);
    }

    @PostMapping("/createTodo")
    public String CreateTodo() {
        return toDoService.CreateTodo();
    }

    @DeleteMapping("/{id}")
    public String DeleteTodo(@PathVariable Long id) {
        return toDoService.DeleteTodo(id);
    }

    @PutMapping("/{id}")
    public String UpdateTodo(@PathVariable Long id) {
        return toDoService.UpdateTodo(id);
    }
}