package manager;

import domain.Book;
import domain.NotFoundException;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class TestProduct {

    @Test
    public void shouldNotFoundException() {
        ProductRepository repository = new ProductRepository();
        Product firstBook = new Book(1, "Анна Каренина", 1000, "Толстой");
        Product secondBook = new Book(2, "Война и мир", 1100, "Толстой");
        Product thirdBook = new Book(3, "Человек футляр", 800, "Чехов");
        Product fourthSmartphone = new Smartphone(4, "Apple", 4100, "IND");
        Product fifthSmartphone = new Smartphone(5, "Sony", 3300, "RTF");

        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(fourthSmartphone);
        repository.save(fifthSmartphone);
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(68);
        });
    }

    @org.junit.jupiter.api.Test
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        Product firstBook = new Book(1, "Кому на Руси жить хорошо", 450, "Некрасов");
        Product secondBook = new Book(2, "Записки сумасшедшего", 600, "Гоголь");
        Product thirdBook = new Book(3, "Мастер и Маргарита", 590, "Булгаков");
        Product fourthSmartphone = new Smartphone(4, "Apple", 39100, "IND");
        Product fifthSmartphone = new Smartphone(5, "Xiaomi", 23500, "RTF");

        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(fourthSmartphone);
        repository.save(fifthSmartphone);
        repository.removeById(1);
        Product[] expected = {secondBook, thirdBook, fourthSmartphone, fifthSmartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
