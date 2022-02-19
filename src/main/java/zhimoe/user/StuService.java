package zhimoe.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * v1.0 fix me
 *
 * @author zhimoe
 * @version 1.0
 * @since 2022/2/19
 */
@Service
public class StuService {

	@Autowired
	private StuRepository repo;

	public List<Student> getAllStudents() {
		return repo.getAllStudents();
	}

}
