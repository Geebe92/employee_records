package com.project.employee_records.controller;

import com.project.employee_records.model.User;
import com.project.employee_records.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{idUser}")
    public ResponseEntity<User> getUser(@PathVariable Integer idUser){
        return ResponseEntity.of(userService.getUser(idUser));
    }

    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable){
        return userService.getUsers(pageable);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        User createUser = userService.setUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idUser}").buildAndExpand(createUser.getIdUser()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        headers.add("Access-Control-Expose-Headers", "*");
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/users/{idUser}")
    public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable Integer idUser){
        return userService.getUser(idUser)
                .map(u -> {
                    userService.setUser(user);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/records/{idUser}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer idUser){
        return userService.getUser(idUser)
                .map(u -> {
                    userService.deleteUser(idUser);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
