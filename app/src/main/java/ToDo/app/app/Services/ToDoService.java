package ToDo.app.app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ToDo.app.app.Entities.TodoItem;
import ToDo.app.app.Repositories.ToDoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ToDoService {

    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public List<TodoItem> GetAllTodos() {
        return repository.findAll();
    }

    public Optional<TodoItem> GetTodoById(Long id) {
        return repository.findById(id);
    }

    public TodoItem CreateTodo(TodoItem item) {
        return repository.save(item);
    }

    public void DeleteTodo(Long id) {                   //return type for confirmation of deletion?
        repository.deleteById(id);
    }
}
