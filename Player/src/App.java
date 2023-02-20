import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printSpootifyLogo(){
        System.out.println();
    }

    
    public static void pressEnter(Scanner dataScanner){
        System.out.println("==================================================================================+++---");
        System.out.println("Pressione 'ENTER' para ir ao menu");
        System.out.println("==================================================================================+++---");
        dataScanner.nextLine();
    }

    public static void closeScanner(Scanner scanner){
        scanner.close();
    }

    public static Music createMusic(Scanner dataScanner){
        Scanner stringCutter;
        String title;
        int duration;
        List<String> songwriters = new ArrayList<String>();
        String bigSW;
        List<String> interpreters = new ArrayList<String>();
        String bigIT;
        String genre;
        
        System.out.println("Titulo:");
        title = dataScanner.nextLine();

        System.out.println("Duração:");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();
        
        System.out.println("Genero:");
        genre = dataScanner.nextLine();

        System.out.println("Compositores: Separe com ;");
        bigSW = dataScanner.nextLine();

        System.out.println("Interpretes: Separe com ;");
        bigIT = dataScanner.nextLine();

        stringCutter = new Scanner(bigSW);
        stringCutter.useDelimiter(";");

        while(stringCutter.hasNext()){
            songwriters.add(stringCutter.next());
        }
        stringCutter.close();

        stringCutter = new Scanner(bigIT);
        stringCutter.useDelimiter(";");

        while(stringCutter.hasNext()){
            interpreters.add(stringCutter.next());
        }
        stringCutter.close();

        return new Music(title, duration, songwriters, interpreters, genre);
    }

    public static Podcast createPodcast(Scanner dataScanner){
        String title;
        int duration;
        String presenter;
        String review;
        
        System.out.println("Titulo:");
        title = dataScanner.nextLine();

        System.out.println("Duração:");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();
        
        System.out.println("Apresentador:");
        presenter = dataScanner.nextLine();

        System.out.println("Descrição:");
        review = dataScanner.nextLine();

        return new Podcast(title, duration, presenter, review);
    }

    public static Audiobook createAudioook(Scanner dataScanner){
        Scanner stringCutter;
        String title;
        int duration;
        List<String> authors = new ArrayList<String>();
        String bigAT;
        String storyteller;
        String publisher;
        String synopsis;
        
        System.out.println("Titulo:");
        title = dataScanner.nextLine();;

        System.out.println("Duração:");
        duration = dataScanner.nextInt();
        dataScanner.nextLine();
        
        System.out.println("Editora:");
        publisher = dataScanner.nextLine();

        System.out.println("Autores: Separe com ;");
        bigAT = dataScanner.nextLine();

        System.out.println("Narrador:");
        storyteller = dataScanner.nextLine();

        System.out.println("Sinopse:");
        synopsis = dataScanner.nextLine();

        stringCutter = new Scanner(bigAT);
        stringCutter.useDelimiter(";");

        while(stringCutter.hasNext()){
            authors.add(stringCutter.next());
        }
        stringCutter.close();

        return new Audiobook(title, duration, storyteller, synopsis, authors, publisher);
    }

    public static void addToPlaylist(Scanner dataScanner, String playlistTitle, Menu menu){
        boolean wannaAdd = true;
        int actualCommand;
        while(wannaAdd){
            clearTerminal();
            printSpootifyLogo();
            System.out.println("Que tipo de conteúdo deseja adicionar?");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Música | 2. Podcast | 3. Audiobook");
            actualCommand = dataScanner.nextInt();
            dataScanner.nextLine();
            
            switch (actualCommand) {
                case 1:
                    try{
                        menu.getPlaylist(playlistTitle).addContent(createMusic(dataScanner));
                        System.out.println("Música adicionada com sucesso!");
                    }catch(InputMismatchException e){
                        clearTerminal();
                        System.out.println("Entrada inválida!\nNão foi possível adicionar o conteúdo!\nPressione ENTER para continuar");
                        dataScanner.nextLine();
                        clearTerminal();
                    }
                    break;
                    
                
                case 2:
                    try{
                        menu.getPlaylist(playlistTitle).addContent(createPodcast(dataScanner));
                        System.out.println("Podcast adicionado com sucesso!");
                    }catch(InputMismatchException e){
                        clearTerminal();
                        System.out.println("Entrada inválida!\nNão foi possível adicionar o conteúdo!\nPressione ENTER para continuar");
                        dataScanner.nextLine();
                        clearTerminal();   
                    }
                    break;
                
                case 3:
                    try{
                        menu.getPlaylist(playlistTitle).addContent(createAudioook(dataScanner));
                        System.out.println("Audiobook adicionado com sucesso!");
                    }catch(InputMismatchException e){
                        clearTerminal();
                        System.out.println("Entrada inválida!\nNão foi possível adicionar o conteúdo!\nPressione ENTER para continuar");
                        dataScanner.nextLine();
                        clearTerminal();
                    }
                    break;
                }
                
            System.out.println("==================================================================================+++---");
            System.out.println("Deseja adicionar mais um conteúdo?");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Sim | 2. Voltar ao menu");
            actualCommand = dataScanner.nextInt();
            dataScanner.nextLine();
            if(actualCommand != 1) wannaAdd = false;
        }
    }

    public static void showPlaylistContent(Scanner dataScanner, String playlistTitle, Menu menu){
        List<Content> filteredList = new ArrayList<Content>();
        int actualCommand;
        int counter;

        clearTerminal();
        System.out.println("O que deseja listar?");
        System.out.println("==================================================================================+++---");
        System.out.println("1. Músicas | 2. Podcasts | 3. Audiobooks | 4. Todos");
        System.out.println("==================================================================================+++---");
        actualCommand = dataScanner.nextInt();
        dataScanner.nextLine();

        switch(actualCommand){
            case 1:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(true, false, false);
                break;
            case 2:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(false, true, true);
                break;
            case 3:
                filteredList = menu.getPlaylist(playlistTitle).filterBy(false, false, true);
                break;
            case 4:
                filteredList = menu.getPlaylist(playlistTitle).getContentList();
                break;
        }

        counter = 1;

        clearTerminal();
        if(!filteredList.isEmpty()){
            System.out.println("==================================================================================+++---");
            System.out.println("Esses são seus conteúdos");
            System.out.println("==================================================================================+++---");
            for (Content spootifyContent : filteredList){
                System.out.printf("%d | %s\n", counter, spootifyContent.toString());
                counter += 1;
            }
        }else{
            System.out.println("Não existem conteúdos que atendam esse requisito :(");
        }
        pressEnter(dataScanner);

    }

    public static void createPlaylist(Scanner dataScanner, Menu menu){
        String playlistTitle;

        printSpootifyLogo();
        System.out.println("==================================================================================+++---");
        System.out.println("Digite o nome da playlist");
        System.out.println("==================================================================================+++---");
        playlistTitle = dataScanner.nextLine();
        
        if(!menu.playlistExists(playlistTitle)){
            menu.addPlaylist(playlistTitle);
            System.out.println("A playlist " + playlistTitle + " foi criada com sucesso!\n ");
        } else{
            System.out.println("Já existe uma playlist chamada " + playlistTitle + "!");
        }

        pressEnter(dataScanner);
    }
    
    public static void deletePlaylist(Scanner dataScanner, Menu menu){
        String playlistTitle;

        printSpootifyLogo();
        System.out.println("==================================================================================+++---");
        System.out.println("Digite o nome da playlist");
        System.out.println("==================================================================================+++---");
        playlistTitle = dataScanner.nextLine();
        
        if(menu.playlistExists(playlistTitle) && playlistTitle != "library"){
            menu.removePlaylist(playlistTitle);
            System.out.println("A playlist " + playlistTitle + " foi removida com sucesso!\n ");
        } else if(playlistTitle == "library")
            System.out.println("Não é possivel apagar a biblioteca!");
        else
            System.out.println("Não existe uma playlist chamada " + playlistTitle + "!");

        pressEnter(dataScanner);
    }

    public static void showPlaylists(Scanner dataScanner, Menu menu){
        int counter =1;
        
        if(menu.getPlaylists().size() > 1){
            System.out.println("==================================================================================+++---");
            System.out.println("Essas são suas playlists");
            System.out.println("==================================================================================+++---");


            for(String playlistTitle : menu.getPlaylists().keySet()){
                if(playlistTitle != "library"){
                    System.out.printf("%d | %s\n", counter, playlistTitle);
                    counter += 1;
                }
            }
        }else{
            System.out.println("Você não possui playlists :(");
        }

        pressEnter(dataScanner);
    }

    public static void main(String[] args){
        Menu myMenu = new Menu();
        Scanner dataScanner = new Scanner(System.in);
        int actualCommand = 0;
        String playlistTitle;

        // Criando playlist com dados do usuário
        clearTerminal();
        printSpootifyLogo();
        System.out.println("20/02/2023\n");
        pressEnter(dataScanner);

        while(actualCommand != 8){
            clearTerminal();
            printSpootifyLogo();
            System.out.println("Selecione uma opção");
            System.out.println("==================================================================================+++---");
            System.out.println("1. Preencher a sua Biblioteca           | 2. Listar os conteúdos da Bilioteca\n3. Exibir informações da Biblioteca     | 4. Criar uma nova Playlist");
            System.out.println("5. Excluir uma Playlist                 | 6. Adicionar conteúdo a Playlist\n7. Listar Playlists                     | 8. Sair");
            System.out.println("==================================================================================+++---");
            actualCommand = dataScanner.nextInt();
            dataScanner.nextLine();

            clearTerminal();
            printSpootifyLogo();

            switch(actualCommand){
                // Adicionar conteúdo a biblioteca
                case 1:
                    addToPlaylist(dataScanner, "library", myMenu);
                    break;

                // Listar conteúdos da biblioteca
                case 2:
                    showPlaylistContent(dataScanner, "library", myMenu);
                    break;

                // Exibir informações da biblioteca
                case 3:
                    System.out.println(myMenu.getPlaylist("library").getDescription());
                    pressEnter(dataScanner);
                    break;
                
                // Criar nova playlist
                case 4:
                    try{
                        createPlaylist(dataScanner, myMenu);
                    }catch(InputMismatchException e){
                        System.out.println("Entrada inválida!\nNão foi possível adicionar o conteúdo!\nPressione ENTER para continuar");
                        dataScanner.nextLine();
                        clearTerminal();
                    }
                    break;
                
                // Criar nova playlist
                case 5:
                    deletePlaylist(dataScanner, myMenu);
                    break;
                
                // Adicionar a uma playlist
                case 6:
                    System.out.println("==================================================================================+++---");
                    System.out.println("Digite o nome da playlist");
                    System.out.println("==================================================================================+++---");
                    playlistTitle = dataScanner.nextLine();
                    if(myMenu.playlistExists(playlistTitle)) addToPlaylist(dataScanner, playlistTitle, myMenu);
                    else{
                        System.out.println("Essa playlist não existe!");
                        pressEnter(dataScanner);
                        clearTerminal();
                    }
                    break;

                // Listando playlists
                case 7:
                    showPlaylists(dataScanner, myMenu);
                    break;

                // Sair
                case 8:
                    System.out.println("Saindo...");
                    break;
            }
        }
        closeScanner(dataScanner);
    }
}
