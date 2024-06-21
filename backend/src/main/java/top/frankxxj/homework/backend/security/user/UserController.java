package top.frankxxj.homework.backend.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        userService.create(userDto);
        return ResponseEntity.ok("User created successfully");
    }

    @PutMapping
    public void updatePassword(@RequestBody UserDto userDto) {
        userService.updatePassword(userDto);
    }

    @GetMapping("/check?email={email}")
    public ResponseEntity<String> checkEmail(@PathVariable String email) {
        return userService.checkEmail(email) ?
                ResponseEntity.ok("Email is available") :
                ResponseEntity.badRequest().body("Email is not available");
    }

}
