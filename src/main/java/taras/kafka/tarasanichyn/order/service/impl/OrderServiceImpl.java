package taras.kafka.tarasanichyn.order.service.impl;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import taras.kafka.tarasanichyn.order.dto.OrderCreateRequest;
import taras.kafka.tarasanichyn.order.dto.OrderCreateResponse;
import taras.kafka.tarasanichyn.order.dto.OrderListResponse;
import taras.kafka.tarasanichyn.order.persistence.OrderEntity;
import taras.kafka.tarasanichyn.order.repository.OrderRepository;
import taras.kafka.tarasanichyn.order.service.OrderService;
import taras.kafka.tarasanichyn.user.exception.UserNotFoundException;
import taras.kafka.tarasanichyn.user.persistence.UserEntity;
import taras.kafka.tarasanichyn.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  private final UserRepository userRepository;
  private final DtoMapper mapper;

  @Override
  public OrderListResponse getAllOrders() {
    List<OrderListResponse.Order> orders = orderRepository.findAll().stream()
        .map(mapper::toListResponse)
        .toList();
    return new OrderListResponse(orders);
  }

  @Override
  public OrderCreateResponse createOrder(final OrderCreateRequest request) {
    UserEntity user = userRepository.findById(request.getUserId()).orElseThrow(UserNotFoundException::new);
    OrderEntity entity = mapper.fromCreateRequest(request);
    entity.setUser(user);
    entity = orderRepository.save(entity);
    return mapper.toCreateResponse(entity);
  }


  @Mapper(componentModel = "spring")
  public interface DtoMapper {
    OrderListResponse.Order toListResponse(OrderEntity entity);

    OrderEntity fromCreateRequest(OrderCreateRequest request);

    OrderCreateResponse toCreateResponse(OrderEntity entity);
  }
}
