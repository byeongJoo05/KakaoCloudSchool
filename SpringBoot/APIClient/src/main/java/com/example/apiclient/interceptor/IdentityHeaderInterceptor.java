package com.example.apiclient.interceptor;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class IdentityHeaderInterceptor implements ClientHttpRequestInterceptor {
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws
		IOException {
		// 헤더가 존재하면 그대로 두고 없으면 추가
		request.getHeaders().addIfAbsent("X-COMPONENT-ID", "ADAM-API");
		return execution.execute(request, body);
	}
}
