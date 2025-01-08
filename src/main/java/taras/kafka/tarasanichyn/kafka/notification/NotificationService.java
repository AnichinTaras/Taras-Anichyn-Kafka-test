package taras.kafka.tarasanichyn.kafka.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

  @KafkaListener(topics = "user-orders-topic", groupId = "user-orders-group")
  public void handleNewOrderNotification(String message) {
    System.out.println("Sending email notification: " + message);
  }
}