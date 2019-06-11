package thealeshka.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thealeshka.diploma.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
