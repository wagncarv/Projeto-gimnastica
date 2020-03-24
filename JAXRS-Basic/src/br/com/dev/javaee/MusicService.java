package br.com.dev.javaee;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dev.javaee.model.Songs;
import br.com.dev.javaee.model.Song;

@Path("/music")
public class MusicService {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String loadNames() {
		StringBuilder stringBuilder = new StringBuilder("<html><body><h2>Nomes das Músicas</h2><ul>");

		Songs.list().stream().forEach(s -> stringBuilder.append("<li>").append(s.getName()).append("</li>"));

		stringBuilder.append("</ul></body></html>");

		return stringBuilder.toString();
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Song> loadSongsAsJson(){
		return Songs.list();
	}

}
