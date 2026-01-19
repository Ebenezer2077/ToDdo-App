package ToDo.app.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import ToDo.app.app.Entities.TodoItem;
import ToDo.app.app.Services.ToDoService;
import ToDo.app.app.DTOs.ApiResponse;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TodoItem>> GetTodos() {
        return ResponseEntity.ok(toDoService.GetAllTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> GetTodoById(@PathVariable Long id) {
        try {
            TodoItem item = toDoService.GetTodoById(id).get();
            return ResponseEntity.ok(item);
        } catch (NoSuchElementException e) {
            System.err.println("Error: ToDo-Item with id: " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/createTodo")
    public ResponseEntity<TodoItem> CreateTodo(@RequestBody TodoItem item) {
        return ResponseEntity.ok(toDoService.CreateTodo(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteTodo(@PathVariable Long id) {
        try {
            toDoService.GetTodoById(id).get();
        } catch (NoSuchElementException e) {
            System.err.println("Error: Could not find the ToDo-Item with id: " + id + " for deletion");
            return ResponseEntity.badRequest().build();
        }
        toDoService.DeleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> UpdateTodo(@PathVariable Long id, @RequestBody TodoItem newToDdo) {
        try {
            TodoItem todo = toDoService.GetTodoById(id).get();
            todo.setTitle(newToDdo.getTitle());
            todo.setDescription(newToDdo.getDescription());
            todo.setCompleted(newToDdo.isCompleted());
            toDoService.CreateTodo(todo);
            return ResponseEntity.ok(todo);
        } catch (NoSuchElementException e) {
            System.err.println("Error: ToDo-Item with id: " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
    }

    // ===== Neue Endpoints mit Latency-Tracking & Metadaten =====

    @GetMapping("/{id}/detailed")
    public ResponseEntity<ApiResponse<TodoItem>> GetTodoByIdDetailed(@PathVariable Long id) {
        long startTime = System.currentTimeMillis();
        try {
            TodoItem item = toDoService.GetTodoById(id).get();
            long endTime = System.currentTimeMillis();
            long latency = endTime - startTime;
            return ResponseEntity.ok(new ApiResponse<>(item, latency));
        } catch (NoSuchElementException e) {
            System.err.println("Error: ToDo-Item with id: " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/gettodos/detailed")
    public ResponseEntity<ApiResponse<List<TodoItem>>> GetTodosDetailed() {
        long startTime = System.currentTimeMillis();
        List<TodoItem> todos = toDoService.GetAllTodos();
        long endTime = System.currentTimeMillis();
        long latency = endTime - startTime;
        return ResponseEntity.ok(new ApiResponse<>(todos, latency));
    }
}