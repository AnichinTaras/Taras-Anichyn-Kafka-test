package taras.kafka.tarasanichyn.user.service.impl;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import taras.kafka.tarasanichyn.user.dto.UserCreateRequest;
import taras.kafka.tarasanichyn.user.dto.UserCreateResponse;
import taras.kafka.tarasanichyn.user.dto.UserListResponse;
import taras.kafka.tarasanichyn.user.persistence.UserEntity;
import taras.kafka.tarasanichyn.user.repository.UserRepository;
import taras.kafka.tarasanichyn.user.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final DtoMapper mapper;

  @Override
  public UserListResponse getAllUsers() {
    List<UserListResponse.User> users = userRepository.findAll().stream()
        .map(mapper::toListResponse)
        .toList();
    return new UserListResponse(users);
  }

  @Override
  public UserCreateResponse createUser(final UserCreateRequest request) {
    // Ensure no ID is set during mapping
    UserEntity entity = mapper.fromCreateRequest(request);
    entity = userRepository.save(entity);
    return mapper.toCreateResponse(entity);
  }

  @Mapper(componentModel = "spring")
  public interface DtoMapper {
    UserListResponse.User toListResponse(UserEntity entity);

    UserEntity fromCreateRequest(UserCreateRequest request);

    UserCreateResponse toCreateResponse(UserEntity entity);
  }
}
