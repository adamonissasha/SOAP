package org.example.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.ws.WebServiceRef;
import org.example.service.LibraryService;
import org.example.entity.Book;

import java.io.IOException;
import java.util.List;

@WebServlet("/allBooks")
public class GetAllBooksController extends HttpServlet {
    @WebServiceRef
    LibraryService libraryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Book> bookList = libraryService.getAllBooks();
        if (bookList == null) {
            resp.getWriter().write("В библиотеке нет книг!");
        } else {
            req.setAttribute("books", bookList);
            req.getRequestDispatcher("getAllBooks.jsp").forward(req, resp);
        }
    }
}