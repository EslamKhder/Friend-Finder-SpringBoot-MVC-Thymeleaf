package com.spring.dao;
import com.spring.model.Post;
import com.spring.model.Role;
import com.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUser(User user);
}
