package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.model.User;
import za.ac.cput.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/graduate-portal/user/")
@Slf4j
public class UserController {
//
    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        User newUser = UserFactory.build(
                user.getUserId()
                ,user.getEmail(),
                user.getPassword(),
                user.getUserRole());
        return userService.save(newUser);
    }

    @RequestMapping("/read/{userId}")
    public Optional<User> read(@PathVariable String userId){
        return userService.read(userId);
    }

    @DeleteMapping("/delete}")
    public void delete(@PathVariable User user) {
        this.userService.delete(user);}

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();


    }

}

