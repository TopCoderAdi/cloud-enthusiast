package io.spring.boot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestClientException;

import io.spring.boot.command.LatestNewsCommand;

@SpringBootApplication
@EnableDiscoveryClient
public class NewsRepoApplicationCloud {

	public static void main(String[] args) throws RestClientException, IOException {
		SpringApplication.run(NewsRepoApplicationCloud.class, args);
		
		LatestNewsCommand command = new LatestNewsCommand();
		
		command.getTopStories();
	}
}
