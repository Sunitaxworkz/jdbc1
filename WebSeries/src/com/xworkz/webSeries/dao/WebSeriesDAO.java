package com.xworkz.webSeries.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.webSeries.dto.WebSeriesDTO;

public interface WebSeriesDAO {
	
	int save(WebSeriesDTO dto);

	int total();

	int findMax();

	int findMinSeason();

	Collection<WebSeriesDTO> findAll();

	Collection<WebSeriesDTO> findAllSortByNameDesc();

	Optional<WebSeriesDTO> findOne(Predicate<WebSeriesDTO> predicate);
}
