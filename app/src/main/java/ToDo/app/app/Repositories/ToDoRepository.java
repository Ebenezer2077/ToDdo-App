package ToDo.app.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ToDo.app.app.Entities.TodoItem;

public interface ToDoRepository extends JpaRepository<TodoItem, Long> {}
