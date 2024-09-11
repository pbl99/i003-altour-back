package com.igrowker.miniproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.igrowker.miniproject.api.dto.JamDataDTO;
import com.igrowker.miniproject.api.dto.Results;

import reactor.core.publisher.Mono;

@Service
public class MapaCalorService {

	private final WebClient webClient;

	public MapaCalorService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://data.traffic.hereapi.com/v7/").build();
	}

	public Mono<List<JamDataDTO>> getFiltroDestino(String apiKey, Double lat, Double lng, Integer rad) {
		String uri = String.format("flow?apiKey=%s&in=circle:%s,%s;r=%d&q=all&locationReferencing=shape", apiKey, lat,
				lng, rad);

		return webClient
				.get().uri(
						uri)
				.retrieve().bodyToMono(Results.class)
				.map(results -> results.getResults().stream()
						.map(result -> new JamDataDTO(result.getLocation().getDescription(),
								result.getCurrentFlow().getJamFactor()))
						.collect(Collectors.toList()));
	}
}
