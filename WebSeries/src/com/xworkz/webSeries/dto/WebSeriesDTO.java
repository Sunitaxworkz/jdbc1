package com.xworkz.webSeries.dto;

import com.xworkz.webSeries.dto.constant.Genre;
import com.xworkz.webSeries.dto.constant.StreamedIn;

public class WebSeriesDTO {
	private int id;
	private String name;
	private int noOfEpisodes;
	private int totalSeason;
	private StreamedIn streamedIn;
	private Genre genre;
	private int ageLimit;

	public WebSeriesDTO() {
		// TODO Auto-generated constructor stub
	}

	public WebSeriesDTO(String name, int noOfEpisodes, int totalSeason, StreamedIn streamedIn, Genre genre,
			int ageLimit) {
		super();
		
		this.name = name;
		this.noOfEpisodes = noOfEpisodes;
		this.totalSeason = totalSeason;
		this.streamedIn = streamedIn;
		this.genre = genre;
		this.ageLimit = ageLimit;
	}

	@Override
	public String toString() {
		return "WebSeriesDTO [id=" + id + ", name=" + name + ", noOfEpisodes=" + noOfEpisodes + ", totalSeason="
				+ totalSeason + ", streamedIn=" + streamedIn + ", genre=" + genre + ", ageLimit=" + ageLimit + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 89;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebSeriesDTO other = (WebSeriesDTO) obj;
		if (genre == null) {
			if (other.ageLimit != 0)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfEpisodes() {
		return noOfEpisodes;
	}

	public void setNoOfEpisodes(int noOfEpisodes) {
		this.noOfEpisodes = noOfEpisodes;
	}

	public int getTotalSeason() {
		return totalSeason;
	}

	public void setTotalSeason(int totalSeason) {
		this.totalSeason = totalSeason;
	}

	public StreamedIn getStreamedIn() {
		return streamedIn;
	}

	public void setStreamedIn(StreamedIn streamedIn) {
		this.streamedIn = streamedIn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

}
