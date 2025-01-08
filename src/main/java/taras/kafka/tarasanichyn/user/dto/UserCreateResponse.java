package taras.kafka.tarasanichyn.user.dto;

import lombok.Data;

@Data
public class UserCreateResponse {
  private Long id;
  private String name;
  private String email;
}
