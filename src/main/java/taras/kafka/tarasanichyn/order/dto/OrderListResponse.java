package taras.kafka.tarasanichyn.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListResponse {
  private List<Order> orders;

  @Data
  public static class Order {
    private Long id;
    private String product;
    private Integer quantity;
    private User user;
  }

  @Data
  public static class User {
    private Long id;
    private String name;
    private String email;
  }
}