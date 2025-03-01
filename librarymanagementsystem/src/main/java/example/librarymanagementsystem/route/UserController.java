package example.librarymanagementsystem.route;

import example.librarymanagementsystem.entity.User;
import example.librarymanagementsystem.service.IUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
@AllArgsConstructor
public class UserController {

    private IUser userService;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @RequestMapping(method = RequestMethod.POST,path = "/{userId}")
    ResponseEntity<User> getUser(@RequestParam("userId") String userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
