package ToDo.app.app.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @GetMapping("/gettodos")
    public String GetTodos() {
        return "all Todos";
    }

    @GetMapping("/{id}")
    public String GetTodoById(@PathVariable Long id) {
        return "todo with ID: " + id;
    }

    @PostMapping("/createTodo")
    public String CreateTodo() {
        return "Todo Created";
    }

    @DeleteMapping("/{id}")
    public String DeleteTodo(@PathVariable Long id) {
        return "Todo " + id + " deleted";
    }

    @PutMapping("/{id}")
    public String UpdateTodo(@PathVariable Long id) {
        return "Todo " + id + "updated";
    }
}