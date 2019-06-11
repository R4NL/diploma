package thealeshka.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thealeshka.diploma.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
