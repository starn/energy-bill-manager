package fr.starn.energybillmanager.controller;

import fr.starn.energybillmanager.dto.UserDto;
import fr.starn.energybillmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getAll();
    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody UserDto newUser){
        try {
            UserDto result = userService.save(newUser);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateUser(@PathVariable("id") String id, @RequestBody UserDto updatedUser){
        UserDto result = userService.update(updatedUser);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable("id") long id){
        userService.delete(id);
    }
}
