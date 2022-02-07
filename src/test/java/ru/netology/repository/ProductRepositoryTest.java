package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import static org.junit.jupiter.api.Assertions.*;


class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book book1 = new Book(1,"Sun",500,"Dynon",230,2000);
  private Book book2 = new Book(2,"Set",200,"Myson",100,1995);

  @Test
  public void shouldDeleteOneItem() {
    repository.save(book1);
    repository.removeById(1);
      Product[] expected = new Product[]{};
      Product[] actual = repository.findAll();

      assertArrayEquals(expected,actual);
  }

  @Test
    public void notFoundIfWrongParm(){
      repository.save(book1);
      assertThrows(NotFoundException.class, () -> repository.removeById(100));
  }
}
