package org.example;

import jakarta.jws.WebService;
import org.example.entity.Book;
import org.example.entity.Genre;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "org.example.LibraryService")
public class LibraryImplService implements LibraryService {
    private final List<Book> books;
    private long id;

    {
        books = new ArrayList<>();
        books.add(new Book(++id, "Война и мир", "Лев Толстой", Genre.NOVEL));
        books.add(new Book(++id, "Дневник памяти", "Николас Спаркс", Genre.NOVEL));
        books.add(new Book(++id, "Безмолвный пациент", "Алекс Михаэлидес", Genre.THRILLER));
        books.add(new Book(++id, "Зеленая миля", "Стивен Кинг", Genre.NOVEL));
        books.add(new Book(++id, "Внутри убийцы", "Майк Омер", Genre.DETECTIVE));
        books.add(new Book(++id, "Двадцать лет спустя", "Александр Дюма", Genre.ADVENTURE));
        books.add(new Book(++id, "Рассказы о Шерлоке Холмсе", "Артур Конан Дойл", Genre.DETECTIVE));
        books.add(new Book(++id, "Остров сокровищ", "Роберт Льюис Стивенсон", Genre.ADVENTURE));
        books.add(new Book(++id, "Тихая гавань", "Николас Спаркс", Genre.NOVEL));
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return books
                .stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByName(String name) {
        return books
                .stream()
                .filter(book -> book.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public String getBooks(List<Book> books) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder
                    .append("Book №")
                    .append(book.getId())
                    .append(": ")
                    .append(book.getName())
                    .append(", ")
                    .append(book.getAuthor())
                    .append(", ")
                    .append(book.getGenre().getPrefix())
                    .append("<br>");
        }
        return stringBuilder.toString();
    }
}