package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Smartphone phone1 = new Smartphone(1,"12 pro",100,"Iphone");
    private Smartphone phone2 = new Smartphone(2,"A51",150,"Samsung");
    private Smartphone phone3 = new Smartphone(3,"Aleshka",200,"LG");
   

    @Test
    public void shouldSearchByName1() {
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] products = productManager.searchBy("12 pro");
        assertArrayEquals(new Product[]{phone1},products);

    }

    @Test
    public void shouldSearchByProducer1() {
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);

        Product[] products = productManager.searchBy("Iphone");
        assertArrayEquals(new Product[]{phone1},products);

    }


}