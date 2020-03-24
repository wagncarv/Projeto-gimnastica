package br.com.dev.javaee.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Songs {

	private static int CURRENT_ID = 0;
	
	private static final Map<Integer, Song> songs = new LinkedHashMap<>();
	
	static {
		songs.put(++CURRENT_ID, new Song(CURRENT_ID, "Let it be", "Beatles"));
		songs.put(++CURRENT_ID, new Song(CURRENT_ID, "Hey Jude", "Beatles"));
		songs.put(++CURRENT_ID, new Song(CURRENT_ID,  "Crazy", "Aerosmith"));
		songs.put(++CURRENT_ID, new Song(CURRENT_ID, "Bitter sweet symphony", "The Verve"));
	}
	

	public static List<Song> list() {
		return new ArrayList<Song>(songs.values());
	}

	public static Song findById(int id) {
		return songs.get(id);
	}

	public static int create(String name, String singer) {
		Song song = new Song(++CURRENT_ID, name, singer);
		songs.put(CURRENT_ID, song);
		return CURRENT_ID;
	}

}