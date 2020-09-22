package com.spring.controller;

import com.spring.dao.CommentRepository;
import com.spring.dao.FriendRepository;
import com.spring.dao.PostRepository;
import com.spring.dao.UserRepository;
import com.spring.model.Friend;
import com.spring.model.Post;
import com.spring.model.User;
import com.spring.util.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private FriendRepository friendRepository;
    private UserRepository userRepository;

    private List<User> users;
    private List<Friend> friends;
    private List<Post> posts;
    private int counter;
    private long userid;

    @Autowired
    public HomeController(PostRepository postRepository, CommentRepository commentRepository, FriendRepository friendRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.friendRepository = friendRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        return "/view/index";
    }

    @GetMapping("/home")
    public String showMyPage(Model model) {
        posts = (List<Post>) postRepository.findAll();
        users = (List<User>) userRepository.findAll();

        if(UserData.isConnected()){

            model.addAttribute("post", new Post());

            model.addAttribute("imageprofile", UserData.userImage());

            userid =  UserData.userId();
            friends = friendRepository.findByUser(new User(UserData.userId()));

            users = users.parallelStream().filter(x -> x.getId() != userid).collect(Collectors.toList());
            if(!friends.isEmpty()){
                List<Post> myposts = new ArrayList<>();
                for (counter = 0; counter< friends.size(); counter++) {

                    users = users.parallelStream().filter(x -> x.getId() != friends.get(counter).getFriendid())
                                                  .collect(Collectors.toList());


                    myposts.addAll(posts.parallelStream().filter((x -> x.getUser().getId() == friends.get(counter).getFriendid() &&
                            friends.get(counter).getUser().getId() == userid))
                            .collect(Collectors.toList()));
                    myposts.addAll(posts.parallelStream().filter(x -> x.getUser().getId() == userid).collect(Collectors.toList()));
                }
                Collections.reverse(myposts);
                model.addAttribute("myposts",myposts);
            } else {
                posts = postRepository.findByUser(new User(UserData.userId()));
                Collections.reverse(posts);
                model.addAttribute("myposts",posts);
            }
            model.addAttribute("myfriends",users);

        } else {
            model.addAttribute("posts",posts);
            model.addAttribute("users",users);
        }
        model.addAttribute("comments",commentRepository.findAll());
        return "/view/mainpage";
    }
}