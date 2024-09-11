package com.igrowker.miniproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.igrowker.miniproject.api.dto.Item;
import com.igrowker.miniproject.api.dto.Items;

import reactor.core.publisher.Mono;

@Service
public class FiltroDestinoService {

	private final WebClient webClient;

	public FiltroDestinoService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://discover.search.hereapi.com/v1/").build();
	}

	public Mono<List<String>> getFiltroDestino(Double lat, Double lng, Integer rad, String actividad, String apiKey) {
		String uri = String.format("/discover?in=circle:%s,%s;r=%d&q=%s&apiKey=%s", lat, lng, rad, actividad, apiKey);

		return webClient.get().uri(uri).retrieve().bodyToMono(Items.class)
				.map(items -> items.getItems().stream().map(Item::getTitle).collect(Collectors.toList()));
	}
}