package taras.kafka.tarasanichyn.user.rest;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import taras.kafka.tarasanichyn.user.dto.UserCreateRequest;
import taras.kafka.tarasanichyn.user.dto.UserCreateResponse;
import taras.kafka.tarasanichyn.user.dto.UserListResponse;
import taras.kafka.tarasanichyn.user.service.UserService;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public UserListResponse getAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping
  public UserCreateResponse createUser(@RequestBody UserCreateRequest request) {
    return userService.createUser(request);
  }
}