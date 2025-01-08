package taras.kafka.tarasanichyn.user.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListResponse {
  private List<User> users;

  @Data
  public static class User {
    private Long id;
    private String name;
    private String email;
  }
}