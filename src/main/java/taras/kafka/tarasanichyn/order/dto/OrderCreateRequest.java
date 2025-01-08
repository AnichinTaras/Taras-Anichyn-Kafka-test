package taras.kafka.tarasanichyn.order.dto;

import lombok.Data;

@Data
public class OrderCreateRequest {
  private Long userId;
  private String product;
  private String quantity;
}
