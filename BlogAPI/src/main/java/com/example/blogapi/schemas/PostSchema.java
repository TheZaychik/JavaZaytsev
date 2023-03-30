package com.example.blogapi.schemas;

import com.example.blogapi.models.Comment;
import com.example.blogapi.models.Post;

import java.util.List;

public class PostSchema {
    public Post post;
    public List<Comment> comments;
}
