package example.librarymanagementsystem.route;

import example.librarymanagementsystem.entity.User;
import example.librarymanagementsystem.service.IUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private IUser userService;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @RequestMapping(method = RequestMethod.GET,path = "/{userId}")
    ResponseEntity<User> getUser(@PathVariable("userId") String userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
}
