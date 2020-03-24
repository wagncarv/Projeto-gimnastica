package br.com.dev.javaee.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Songs {

	private static final Map<Integer, Song> songs = Map.of(
			1, new Song(1, "Let it be", "Beatles"),
			2,new Song(2, "Hey Jude", "Beatles"),
			3, new Song(3, "Crazy", "Aerosmith"),
			4,new Song(4, "Angel", "Aerosmith"),
			5, new Song(5, "Bitter sweet symphony", "The Verve")
		);
	
	public static List<Song> list() {
		return new ArrayList<Song>(songs.values());
	}
	
	public static Song findById(int id) {
		return songs.get(id);
	}

}