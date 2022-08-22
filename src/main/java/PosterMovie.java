public class PosterMovie {
    private int id;
    private String image;
    private String header;
    private String genre;

    public PosterMovie(int id, String image, String header, String genre) {
        this.id = id;
        this.image = image;
        this.header = header;
        this.genre = genre;
    }

    public PosterMovie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}