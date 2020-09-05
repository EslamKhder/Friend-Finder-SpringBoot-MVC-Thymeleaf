package com.spring.dao;
import com.spring.model.Like;
import com.spring.model.Post;
import com.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {

    Like findByUserAndPost(User user, Post post);
}
