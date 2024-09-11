package com.igrowker.miniproject.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.igrowker.miniproject.service.FiltroDestinoService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class FiltroDestinoController {

	@Autowired
	private FiltroDestinoService filtroDestinoService;

	@Value("${api.key}")
	private String apiKey;

	@GetMapping("/destinos/filtrar")
	public Mono<List<String>> filtrarDestinos(@RequestParam Double lat, @RequestParam Double lng,
			@RequestParam Integer rad, @RequestParam String actividad) {

		return filtroDestinoService.getFiltroDestino(lat, lng, rad, actividad, apiKey);
	}

}
