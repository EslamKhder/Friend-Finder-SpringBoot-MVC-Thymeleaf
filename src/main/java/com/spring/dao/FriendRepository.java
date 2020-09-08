package com.spring.dao;
import com.spring.model.Friend;
import com.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend,Long> {

    public List<Friend> findByUser(User user);
}
