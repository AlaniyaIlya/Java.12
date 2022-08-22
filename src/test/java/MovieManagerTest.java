import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    PosterMovie item1 = new PosterMovie(1, "https://", "Бладшот", "боевик");
    PosterMovie item2 = new PosterMovie(2, "https://", "Вперед", "мультфильм");
    PosterMovie item3 = new PosterMovie(3, "https://", "Отель", "комедия");
    PosterMovie item4 = new PosterMovie(3, "https://", "Человек-невидимка", "ужасы");

    @Test
    public void shouldSave() {
        MovieManager poster = new MovieManager();
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);
        poster.save(item4);

        PosterMovie[] expected = {item1, item2, item3, item4};
        PosterMovie[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void ShouldGetAll() {
        MovieManager poster = new MovieManager();
        poster.save(item1);
        poster.save(item2);

        PosterMovie[] expected = {item1, item2};
        PosterMovie[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldGetLastDef() {
        MovieManager poster = new MovieManager();
        poster.save(item1);
        poster.save(item2);
        poster.save(item3);

        PosterMovie[] expected = {item3, item2, item1};
        PosterMovie[] actual = poster.findLastDef();

        Assertions.assertArrayEquals(expected, actual);
    }
}
