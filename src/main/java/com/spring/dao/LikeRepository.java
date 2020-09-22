package com.spring.dao;
import com.spring.model.Like;
import com.spring.model.Post;
import com.spring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like,Long> {

    Like findByUserAndPost(User user, Post post);
}
