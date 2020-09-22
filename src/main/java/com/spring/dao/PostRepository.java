package com.spring.dao;
import com.spring.model.Post;
import com.spring.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {

    List<Post> findByUser(User user);
}
