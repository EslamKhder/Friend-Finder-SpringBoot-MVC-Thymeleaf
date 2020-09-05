package com.spring.controller;

import com.spring.dao.LikeRepository;
import com.spring.dao.PostRepository;
import com.spring.model.Like;
import com.spring.model.Post;
import com.spring.model.User;
import com.spring.util.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class LikeController {

    private LikeRepository likeRepository;
    private PostRepository postRepository;

    @Autowired
    public LikeController(LikeRepository likeRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
    }


    @PostMapping("/like")
    @ResponseBody
    public String addLike(@RequestBody Like like){
        like.setUser(new User(UserData.userId()));
        Like li = likeRepository.findByUserAndPost(new User(like.getUser().getId()),new Post(like.getPost().getId()));
        Optional<Post> post = postRepository.findById(like.getPost().getId());
        if(li != null){
            likeRepository.delete(li);
            post.get().setLove(post.get().getLove() - 1);
            postRepository.save(post.get());
            return "dec";
        } else {
            likeRepository.save(like);
            post.get().setLove(post.get().getLove() + 1);
            postRepository.save(post.get());
            return "inc";
        }
    }
}