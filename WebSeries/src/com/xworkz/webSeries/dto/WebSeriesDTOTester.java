package com.xworkz.webSeries.dto;

import java.util.Collection;

import com.xworkz.webSeries.dao.WebSeriesDAO;
import com.xworkz.webSeries.dao.WebSeriesDAOImpl;
import com.xworkz.webSeries.dto.constant.Genre;
import com.xworkz.webSeries.dto.constant.StreamedIn;

public class WebSeriesDTOTester {

	public static void main(String[] args) {
		WebSeriesDTO dto = new WebSeriesDTO("Made in Heaven", 700, 6, StreamedIn.NETFLIX, Genre.COMEDY, 18);
		WebSeriesDTO dto1 = new WebSeriesDTO("Kota Factory", 1000, 4, StreamedIn.HOTSTAR, Genre.MYSTERY, 18);
		WebSeriesDTO dto2 = new WebSeriesDTO("Better Life Foundation", 400, 10, StreamedIn.AMAZON_MOVIES,Genre.THRILLER, 18);
		WebSeriesDTO dto3 = new WebSeriesDTO("What the folks", 650, 15, StreamedIn.WATCH_SERIES, Genre.COMEDY, 18);
		WebSeriesDTO dto4 = new WebSeriesDTO("FamilyMan", 800, 8, StreamedIn.HOTSTAR, Genre.MYSTERY, 18);
		WebSeriesDTO dto5 = new WebSeriesDTO("FamilyMan", 800, 8, StreamedIn.HOTSTAR, Genre.MYSTERY, 18);

		WebSeriesDAO dao = new WebSeriesDAOImpl();

		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto4);
		dao.save(dto5);
		int total = dao.total();
		System.out.println(total);

		int max = dao.findMax();
		System.out.println("Maximum Seasons are:" + max);

		int min = dao.findMinSeason();
		System.out.println("Min season:" + min);

		Collection<WebSeriesDTO> collection = dao.findAll();
		collection.forEach(p -> System.out.println(p));

		Collection<WebSeriesDTO> collection2 = dao.findAllSortByNameDesc();
		collection2.forEach(w -> System.out.println(w));

	}

}
