package DZ_6_DesignAPIForServerApp.api;

import DZ_6_DesignAPIForServerApp.model.User;
import DZ_6_DesignAPIForServerApp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Получить всех пользователей
    @GetMapping
    @Operation(summary = "get all users", description = "загружает всех пользователей, которые есть в системе")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    //Получить пользователя по ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> optionalUser = userService.findUserById(id);

        // Если пользователя нет, возвращаем статус 404 Not Found
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Создать пользователя
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    // Изменить пользователя
    @PutMapping("/put")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user.getId(), user.getName(), user.getAge()));
    }

    //Удалить пользователя
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}