package dev.paie.service;

import org.springframework.stereotype.Service;

import dev.paie.repository.AvantagesRepository;

@Service
public class AvantageService {
	private AvantagesRepository repoAvantage;

	public AvantageService(AvantagesRepository repoAvantage) {
		this.repoAvantage = repoAvantage;
	}

}
