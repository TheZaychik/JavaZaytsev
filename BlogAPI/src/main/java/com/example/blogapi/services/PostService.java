package com.example.blogapi.services;

import com.example.blogapi.models.Post;
import com.example.blogapi.repositories.CommentRepo;
import com.example.blogapi.repositories.PostRepo;
import com.example.blogapi.schemas.PostSchema;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    CommentRepo commentRepo;

    public List<PostSchema> getAllPosts() {
        List<PostSchema> allPostsWithComments = new ArrayList<>();
        List<Post> posts = postRepo.findAll();
        for (Post p : posts) {
            PostSchema postSchema = new PostSchema();
            postSchema.post = p;
            postSchema.comments = commentRepo.findAllByPost(p);
            allPostsWithComments.add(postSchema);
        }
        return allPostsWithComments;
    }

    public Post getPostById(Integer id) {
        return postRepo.findById(id).get();
    }

    public void save(Post post) {
        postRepo.save(post);
    }
}
