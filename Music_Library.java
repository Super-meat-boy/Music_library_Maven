import java.util.Scanner;

public class Music_Library {


    public static void main(String[] args) throws Exception {


        String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/udvnvmom";
        String user = "udvnvmom";
        String password = "kDaEWcH5VlVuBj389D0FtlG255sZPc9N";
        DatabaseConnection dbConnect = new DatabaseConnection(url, user, password);

        int menuchoice = 0;

        System.out.println("***************************** \n WELCOME TO OUR MUSIC LIBRARY \n*****************************");
        System.out.println("\n================ PLEASE MAKE YOUR SELECTION ==================\n");
        System.out.println("================ TO ADD AN ARTIST PRESS 1 ====================");
        System.out.println("================ TO DELETE AN ARTIST PRESS 2 =================");
        System.out.println("================ TO DISPLAY ARTIST IN DATABASE PRESS 3 =======");
        System.out.println("================ TO ADD A VINYL PRESS 4 ======================");


       /* // Choice 1 : Add a new artist
        String name = sc.nextLine();
        String nationality = sc.nextLine();
        String style = sc.nextLine();

        Artist artist1 = new Artist(name, nationality, style);
        Artist.addArtist(dbConnect, artist1);


        // Choice 2 : Delete an artist
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Artist.deleteArtist(dbConnect, input.toLowerCase());


        // Choice 3 : Display all artists in DB
        List<Artist> resultat = Artist.artistdisplay(dbConnect);


        for (int i = 0; i < resultat.size(); i++) {
            System.out.println("****** WHAT ARE WE GONNA LISTEN TODAY ? ******" + "\n" + resultat.get(i).toString());
        }*/

        // Choice 4 : Add a vinyl
        System.out.println("Thanks for giving us the name of the artist");
        Scanner sc = new Scanner(System.in);
        String nameartist = sc.nextLine();

        System.out.println("Name of the album");
        String album = sc.nextLine();
        System.out.println("Year of the albumoppo");
        int year = sc.nextInt();
        Vinyl vinyl = new Vinyl(album, year);
        Artist.addVinyl(dbConnect, vinyl, nameartist.toLowerCase());

        dbConnect.closeConnection();

    }
}

