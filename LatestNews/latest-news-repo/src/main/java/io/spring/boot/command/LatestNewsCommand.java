package io.spring.boot.command;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
public class LatestNewsCommand {
	
	@Value("${news.uri}")
	private String baseUrl;
	
	@RequestMapping("/news")
	public String getTopStories() throws RestClientException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),Object.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		return response.getBody().toString();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
