package taras.kafka.tarasanichyn.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taras.kafka.tarasanichyn.order.persistence.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {}
