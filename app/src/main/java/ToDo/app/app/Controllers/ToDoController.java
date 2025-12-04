package ToDo.app.app.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @RequestMapping("/hello")
    public String HelloWorld() {
        return "Hello World";
    }
}