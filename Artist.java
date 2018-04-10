import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Artist {

    int id;
    String name;
    String nationality;
    String style;
    SQLException e;

    public Artist(String name, String nationality, String style) {
        this.name = name;
        this.nationality = nationality;
        this.style = style;
    }

    public static void artistList(DatabaseConnection dbConnect, Artist artist) {


        String sql = "INSERT INTO artist (artist,style,nationality) VALUES (?,?,?)";
        try (PreparedStatement sqlStatement = dbConnect.getConnection().prepareStatement(sql)) {
            sqlStatement.setString(1, artist.getName());
            sqlStatement.setString(2, artist.getStyle());
            sqlStatement.setString(3, artist.getNationality());
            sqlStatement.execute();


        } catch (Exception e) {
            System.out.println("Désolé ça s'est mal passé");

            e.printStackTrace();
        }
    }

    public static List<Artist> artistdisplay(DatabaseConnection dbConnect) {


        List<Artist> artistList = new ArrayList<Artist>();

        String sql = "SELECT artist,style,nationality FROM artist";
        try (PreparedStatement sqlStatement = dbConnect.getConnection().prepareStatement(sql)) {
            ResultSet rs = sqlStatement.executeQuery();


            while (rs.next()) {
                Artist artist = new Artist(rs.getString("artist"), rs.getString("style"), rs.getString("nationality"));
                artistList.add(artist);

            }

        } catch (Exception e) {
            System.out.println("Somthing went wrong !");
            e.printStackTrace();
        }

        return artistList;
    }

    public String toString() {
        return "Name of the artist : " + this.name + ", Style : " + this.nationality + ", Nationality : " + this.style;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
