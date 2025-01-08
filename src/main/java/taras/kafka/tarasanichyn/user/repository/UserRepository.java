package taras.kafka.tarasanichyn.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taras.kafka.tarasanichyn.user.persistence.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {}