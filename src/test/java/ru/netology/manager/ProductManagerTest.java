package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Smartphone phone1 = new Smartphone(1, "12 pro", 100, "Iphone");
    private Smartphone phone2 = new Smartphone(2, "A51", 150, "Samsung");
    private Smartphone phone3 = new Smartphone(3, "Aleshka", 200, "LG");

    private Book book1 = new Book(1, "Sun", 50, "Melody", 400, 1950);
    private Book book2 = new Book(2, "Sea", 100, "Denson", 500, 2000);
    private Book book3 = new Book(2, "Sun", 300, "Fet", 600, 2050);


    @Test
    public void shouldSearchSmartphoneByName() {
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] products = productManager.searchBy("12 pro");
        assertArrayEquals(new Product[]{phone1}, products);

    }

    @Test
    public void shouldSearchSmartphoneByProducer() {
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] products = productManager.searchBy("Iphone");
        assertArrayEquals(new Product[]{phone1}, products);

    }

    @Test
    public void shouldSearchBookByName() {
        repository.save(book1);

        Product[] products = productManager.searchBy("Sun");
        assertArrayEquals(new Product[]{book1}, products);
    }

    @Test
    public void shouldSearchBookByAuthor() {
        repository.save(book2);

        Product[] products = productManager.searchBy("Denson");
        assertArrayEquals(new Product[]{book2}, products);
    }

    @Test
    public void searchShouldReturnNothing() {

        Product[] products = productManager.searchBy("Denson");
        assertArrayEquals(new Product[]{}, products);

    }

    @Test
    public void shouldSearchTwoSameNames() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);

        Product[] products = productManager.searchBy("Sun");
        assertArrayEquals(new Product[]{book1,book3}, products);
    }
}