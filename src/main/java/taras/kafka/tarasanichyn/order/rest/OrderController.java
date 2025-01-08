package taras.kafka.tarasanichyn.order.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import taras.kafka.tarasanichyn.order.dto.OrderCreateRequest;
import taras.kafka.tarasanichyn.order.dto.OrderCreateResponse;
import taras.kafka.tarasanichyn.order.dto.OrderListResponse;
import taras.kafka.tarasanichyn.order.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @GetMapping
  public OrderListResponse getAllUsers() {
    return orderService.getAllOrders();
  }

  @PostMapping
  public OrderCreateResponse createOrder(@RequestBody OrderCreateRequest request) {
    return orderService.createOrder(request);
  }
}