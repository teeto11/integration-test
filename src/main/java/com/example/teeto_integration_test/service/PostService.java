package com.example.teeto_integration_test.service;

import com.example.teeto_integration_test.dto.PostDto;
import com.example.teeto_integration_test.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class PostService {
    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final ParameterizedTypeReference<List<PostDto>> postDto = new ParameterizedTypeReference<>(){};
    public List<Post> getPosts() {
        PostDto[] posts = restTemplate.getForEntity(baseUrl +"/posts", PostDto[].class).getBody();
        return Arrays.stream(posts)
                .map(post -> Post.mapFrom(post))
                .toList();
//        List<PostDto> postDtoList = restTemplate.exchange(baseUrl + "/posts",
//                HttpMethod.GET,
//                null,
//                postDto).getBody();
//       return postDtoList.stream()
//                .map(postDto -> Post.mapFrom(postDto))
//                .toList();
    }

    public Post getPost(String postId) {
        return
    }
}
