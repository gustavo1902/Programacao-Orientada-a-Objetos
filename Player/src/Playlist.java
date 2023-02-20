import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Playlist extends Content {
    private List<Content> contentList;
    
    public Playlist(String title){
        super(title, 0);
        contentList = new LinkedList<Content>();
    }

    public List<Content> getContentList() {
        return this.contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public String getDurationFormated(){
        int hours;
        int minutes;
        int seconds = this.getDuration();

        hours = seconds / 3600;
        seconds %= 3600;
        minutes = seconds / 60;
        seconds %= 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void addContent(Content content){
        contentList.add(content);
        this.setDuration(this.getDuration() + content.getDuration());
    }

    public void removeContent(Content content){
        if(contentList.contains(content))
            contentList.remove(content);
            this.setDuration(this.getDuration() - content.getDuration());
    }

    public List<Content> filterBy(boolean music, boolean podcast, boolean audiobook){

        List<Content> filteredList = new ArrayList<Content>();
        
        for (Content content : this.contentList){

            if(content.getClass() == Music.class && music)
                filteredList.add(content);

            if(content.getClass() == Podcast.class && podcast)
                filteredList.add(content);

            if(content.getClass() == Audiobook.class && audiobook)
                filteredList.add(content);
        }

        return filteredList;
    }

    public String getDescription(){
        String titulo = this.getTitle();
        if(titulo == "library") titulo = "Biblioteca";
        return String.format("Título da Playlist: %s\nDuração: %s\nConteúdos: %d ", titulo, getDurationFormated(), contentList.size());
    }
}
