package com.example.teeto_integration_test.component.stubs;

import com.github.tomakehurst.wiremock.client.MappingBuilder;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

public class PostStubs {
    private static final String POST_PATH = "/posts";
        public static MappingBuilder posts() {
            return get(urlEqualTo(POST_PATH));
        }
}
