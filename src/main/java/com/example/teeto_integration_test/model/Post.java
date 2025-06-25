package com.example.teeto_integration_test.model;

import com.example.teeto_integration_test.dto.PostDto;

public record Post(int userId, String title, String body) {

    public static Post mapFrom(PostDto postDto) {
       return new Post(postDto.userId(), postDto.title(), postDto.body());
    }
}
