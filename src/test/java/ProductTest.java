import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "Бладшот", 1000, "Уэс Андерсон");
    Product item2 = new Book(2, "Отель", 1500, "Андерсон");
    Product item3 = new Book(3, "Теория зла", 1500, "Уэс Андерсон");
    Product item4 = new Smartphone(4, "iphone 12", 70_000, "Apple");
    Product item5 = new Smartphone(5, "Джанго", 30_000, "Спилберг");
    Product item6 = new Book(6, "Бладшот", 1000, "Уэс Андерсон");
    Product item7 = new Book(7, "Бладшот", 1000, "Уэс Андерсон");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
    }


    @Test
    public void ShouldAdd() {

        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemove() {

        repo.removeById(4);

        Product[] expected = {item1, item2, item3, item5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveIfNotExists() {

        repo.removeById(8);

        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindByIdIfExists() {

        Product expected = item5;
        Product actual = repo.findById(5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldFindByIdIfNotExists() {

        Product expected = null;
        Product actual = repo.findById(6);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByText() {

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("Бладшот");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByTextIfMoreThanOne() {
        manager.add(item6);
        manager.add(item7);

        Product[] expected = {item1, item6, item7};
        Product[] actual = manager.searchBy("Бладшот");

        Assertions.assertArrayEquals(expected, actual);
    }
}