package taras.kafka.tarasanichyn.order.service;

import taras.kafka.tarasanichyn.order.dto.OrderCreateRequest;
import taras.kafka.tarasanichyn.order.dto.OrderCreateResponse;
import taras.kafka.tarasanichyn.order.dto.OrderListResponse;

public interface OrderService {
  OrderListResponse getAllOrders();

  OrderCreateResponse createOrder(OrderCreateRequest request);
}
