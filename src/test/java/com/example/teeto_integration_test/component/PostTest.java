package com.example.teeto_integration_test.component;

import com.example.teeto_integration_test.component.stubs.PostStubs;
import com.example.teeto_integration_test.model.Post;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest extends AbstractApplicationTests {

    @Test
    void whenPostMethodIsCalled_thenAListOfPostsIsReturned() {
        //perform stubbing
        wireMockServer.givenThat(PostStubs.posts()
                .willReturn(okJson(postResponse("testdata/postData.json"))
                        ));

        //make rest call
        List<Post> post = postIsCalled();

        //assertion
        assertEquals("delectus aut autem", post.get(0).title());
    }

}
