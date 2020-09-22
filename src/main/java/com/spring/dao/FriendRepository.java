package com.spring.dao;
import com.spring.model.Friend;
import com.spring.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend,Long> {

    List<Friend> findByUser(User user);
}
