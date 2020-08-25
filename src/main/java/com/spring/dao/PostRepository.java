package com.spring.dao;
import com.spring.model.Post;
import com.spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
