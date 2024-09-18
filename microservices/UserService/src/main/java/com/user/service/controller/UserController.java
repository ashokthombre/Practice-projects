package com.user.service.controller;

import com.user.service.entities.User;
import com.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {

        User user1 = this.userService.createUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId)
    {
        User user = this.userService.getUser(userId);

        return ResponseEntity.ok().body(user);
    }

    //creating fallback method for circuitbreaker

    public ResponseEntity<User> ratingHotelFallback (String userId,Exception e)
    {

        System.out.println("Fallback is executed because service is down "+e.getMessage());

        User user = User.builder().email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down")
                .userId("12345")
                .build();

        return new ResponseEntity<>(user,HttpStatus.OK);

    }




     int retry=1;
    @CircuitBreaker(name = "allUsersBreaker" ,fallbackMethod ="allUsersBreakerFallback" )
    //@Retry(name = "retryListOfUser",fallbackMethod = "allUsersBreakerFallback")
    //@RateLimiter(name = "rateLimiterForGatAllUsers",fallbackMethod = "allUsersBreakerFallback")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        System.out.println("Retry :"+retry);
        retry++;

        List<User> allUsers = this.userService.getAllUsers();
        return ResponseEntity.ok().body(allUsers);
    }


    //fallback method for allUserBreaker

    public ResponseEntity<List<User>> allUsersBreakerFallback(Exception e)
    {
        System.out.println("Fallback is executed because service is down "+e.getMessage());

        List<User>users=new ArrayList<>();

        User user = User.builder().email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down")
                .userId("12345")
                .build();
        User user1 = User.builder().email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some service is down")
                .userId("12345")
                .build();
        users.add(user);
        users.add(user1);

        return new ResponseEntity<>(users,HttpStatus.OK);


    }





    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId)
    {
        this.userService.deleteUser(userId);

        return ResponseEntity.ok().body("User deleted successfully..");

    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        User user1 = this.userService.updateUser(user);
        return ResponseEntity.ok().body(user1);
    }


}
