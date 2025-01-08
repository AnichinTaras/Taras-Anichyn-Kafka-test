package taras.kafka.tarasanichyn.order.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import taras.kafka.tarasanichyn.user.persistence.UserEntity;

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