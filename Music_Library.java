import java.util.List;

public class Music_Library {


    public static void main(String[] args) throws Exception {


        String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/udvnvmom";
        String user = "udvnvmom";
        String password = "kDaEWcH5VlVuBj389D0FtlG255sZPc9N";
        DatabaseConnection dbConnect = new DatabaseConnection(url, user, password);


        Artist artist1 = new Artist("Polnareff", "Français", "soupe");
        Artist.artistList(dbConnect, artist1);

        List<Artist> resultat = Artist.artistdisplay(dbConnect);


        for (int i = 0; i < resultat.size(); i++) {
            System.out.println(resultat.get(i).toString());
        }
        dbConnect.closeConnection();

    }
}

