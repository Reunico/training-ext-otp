package com.trainings.otp.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Slf4j
public class RestTemplateAuthInterceptor implements ClientHttpRequestInterceptor {

    private final ApplicationProperties applicationProperties;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        String authHeader = applicationProperties.getLogin() + ":" + applicationProperties.getPassword();
        byte[] encodeAuth = Base64.encodeBase64(authHeader.getBytes(StandardCharsets.UTF_8));
        String auth = "Basic " + new String(encodeAuth);

        request.getHeaders().add(HttpHeaders.AUTHORIZATION, auth);
        return execution.execute(request, body);

    }
}
