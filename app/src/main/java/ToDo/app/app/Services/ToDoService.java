package ToDo.app.app.Services;

public class ToDoService {
    public String GetAllTodos() {
        return "all Todos";
    }

    public String GetTodoById(Long id) {
        return "todo with ID: " + id;
    }

    public String CreateTodo() {
        return "Todo Created";
    }

    public String DeleteTodo(Long id) {
        return "Todo " + id + " deleted";
    }

    public String UpdateTodo(Long id) {
        return "Todo " + id + "updated";
    }
}
