package com.igrowker.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igrowker.miniproject.api.dto.JamDataDTO;
import com.igrowker.miniproject.service.MapaCalorService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class MapaCalorController {
	
 /* Devuelve datos en tiempo real sobre la
congestión turística en diferentes zonas de la ciudad*/
	
	@Autowired
	private MapaCalorService mapaCalorService;

	@Value("${api.key}")
	private String apiKey;

	@GetMapping("/mapa-calor")
	public Mono<List<JamDataDTO>> mapaCalor(@RequestParam Double lat, @RequestParam Double lng,
			@RequestParam Integer rad) {

		return mapaCalorService.getFiltroDestino(apiKey ,lat, lng, rad);
	}
}
