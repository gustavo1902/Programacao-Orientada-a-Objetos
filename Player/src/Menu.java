import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, Playlist> playlists;

    public Map<String, Playlist> getPlaylists(){
		return playlists;
	}
    
    public Menu(){
        playlists = new HashMap<String, Playlist>();
        addPlaylist("library");
    }

    public void addPlaylist(String playlistTitle){
        if(!playlistExists(playlistTitle))
            playlists.put(playlistTitle, new Playlist(playlistTitle));
    }

    public Playlist getPlaylist(String playlistTitle){
        return playlists.get(playlistTitle);
    }

    public void removePlaylist(String playlistTitle){
        playlists.remove(playlistTitle);
    }

    public boolean playlistExists(String playlistTitle){
        return playlists.containsKey(playlistTitle);
    }

    public void addContent(String playlistTitle, Content content){
        getPlaylist(playlistTitle).addContent(content);
    }

    public void removeContent(String playlistTitle, Content content){
        getPlaylist(playlistTitle).removeContent(content);
    }

    public String getContentDescription(Content content){
        String contentClass = "";
        
        if(content.getClass() == Music.class) contentClass = "Música";
        if(content.getClass() == Podcast.class) contentClass = "Podcast";
        if(content.getClass() == Audiobook.class) contentClass = "Audiobook";

        return String.format("%s - %s", contentClass, content.toString());
        
    }
}
