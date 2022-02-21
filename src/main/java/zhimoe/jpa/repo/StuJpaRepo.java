package zhimoe.jpa.repo;

import org.springframework.data.repository.CrudRepository;
import zhimoe.jpa.entity.Student;

import java.util.List;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/20
 */
public interface StuJpaRepo extends CrudRepository<Student, Long> {
    List<Student> findById(String id);
    Student findById(long id);
}