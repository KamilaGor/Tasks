package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {
	@Autowired
	private TrelloClient trelloClient;

	@RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
	public void getTrelloBoards() {
		List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

		trelloBoards.stream()
				.filter(trelloBoardDto -> trelloBoardDto.getId() != null)
				.filter(trelloBoardDto -> trelloBoardDto.getName() != null)
				.filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla Application"))
				.forEach(trelloBoardDto -> System.out.println("Board id: " + trelloBoardDto.getId() + " Board name: " + trelloBoardDto.getName()));
	}
}
