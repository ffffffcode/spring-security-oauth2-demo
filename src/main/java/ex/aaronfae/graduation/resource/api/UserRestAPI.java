package ex.aaronfae.graduation.resource.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.aaronfae.graduation.resource.entity.User;

@RestController
public class UserRestAPI {

	// 需要通过OAuth2认证才可以调用该API
	@RequestMapping("/api/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("kevin", 33));
		users.add(new User("joe", 30));
		return ResponseEntity.ok(users);
	}

}