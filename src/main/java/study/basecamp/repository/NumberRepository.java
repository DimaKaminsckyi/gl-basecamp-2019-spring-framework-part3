package study.basecamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.basecamp.domain.Number;

@Repository
public interface NumberRepository extends JpaRepository<Number , Integer> {
}
