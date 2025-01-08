package taras.kafka.tarasanichyn.user.service;

import taras.kafka.tarasanichyn.user.dto.UserCreateRequest;
import taras.kafka.tarasanichyn.user.dto.UserCreateResponse;
import taras.kafka.tarasanichyn.user.dto.UserListResponse;

public interface UserService {
  UserListResponse getAllUsers();

  UserCreateResponse createUser(UserCreateRequest request);
}
