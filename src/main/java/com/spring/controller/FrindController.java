package com.spring.controller;

import com.spring.dao.FriendRepository;
import com.spring.model.Friend;
import com.spring.model.User;
import com.spring.util.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class FrindController {

    private FriendRepository friendRepository;

    @Autowired
    public FrindController(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @PostMapping("/friend")
    @ResponseBody
    public String addFriend(@RequestBody Friend friend){
        friend.setUser(new User(UserData.userId()));
        friendRepository.save(friend);
        return "added";
    }
}
