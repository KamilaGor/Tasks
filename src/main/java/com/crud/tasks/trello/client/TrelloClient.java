package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component //adn.,kt. w trakcie budowania kontekstu aplikacji stworzy z niej beana
public class TrelloClient { //wstrzykinie(za pomocą Autowired) beana kl.RestTemplate,aby umożliwić wysyłanie żądań klasie TrelloClient

	@Value("${trello.api.endpoint.prod}")
	private String trelloApiEndpoint;

	@Value("${trello.app.key}")
	private String trelloAppKey;

	@Value("${trello.app.token}")
	private String trelloToken;

	@Value("${trello.app.username}")
	private String trelloUsername;

	@Autowired
	private RestTemplate restTemplate;

	private URI getUrl() {

		URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUsername + "/boards")
				.queryParam("key", trelloAppKey)
				.queryParam("token", trelloToken)
				.queryParam("fields", "name,id").build().encode().toUri();
		return url;
	}

	public List<TrelloBoardDto> getTrelloBoards() {

//		System.out.println(getUrl());

		TrelloBoardDto[] boardsResponse = restTemplate.getForObject(getUrl(), TrelloBoardDto[].class);

		if (boardsResponse !=null) {
			return Arrays.asList(boardsResponse);
		}
		return new ArrayList<>();
//      Optional<TrelloBoardDto> optional = Optional.empty();
//		optional.ifPresent(trelloBoardsDto -> System.out.println("My boards: " + trelloBoardsDto.getId() + trelloBoardsDto.getName()));
	}
}
