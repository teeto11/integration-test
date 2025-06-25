package com.example.teeto_integration_test.component;

import com.example.teeto_integration_test.model.Post;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import wiremock.org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
@ActiveProfiles("COMPONENT_TEST")
public abstract class AbstractApplicationTests {
    @Autowired
    protected WireMockServer wireMockServer;

    @Autowired
    protected TestRestTemplate restTemplate;

    @LocalServerPort
    private Integer port;

    protected String serverAddress() {
        return "http://localhost:" + port;
    }

    @SneakyThrows
    public String postResponse(String filePath) {
      return IOUtils.toString(AbstractApplicationTests.class.getClassLoader().getResourceAsStream(filePath),
                StandardCharsets.UTF_8.name());
    }

    public List<Post> postIsCalled() {
        return restTemplate.exchange(serverAddress() + "/posts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {}).getBody();
    }

}
