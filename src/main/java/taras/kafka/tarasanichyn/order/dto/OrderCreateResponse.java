package taras.kafka.tarasanichyn.order.dto;

import lombok.Data;

@Data
public class OrderCreateResponse {
  private Long id;
  private String product;
  private Integer quantity;
  private User user;

  @Data
  public static class User {
    private Long id;
    private String name;
    private String email;
  }
}
