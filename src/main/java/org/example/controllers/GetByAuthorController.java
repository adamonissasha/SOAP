package org.example.controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.ws.WebServiceRef;
import org.example.LibraryService;
import org.example.entity.Book;

import java.io.IOException;
import java.util.List;

@WebServlet("/booksByAuthor")
public class GetByAuthorController extends HttpServlet {
    @WebServiceRef
    LibraryService libraryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String str = req.getParameter("str");
        List<Book> bookList = libraryService.findByAuthor(str);
        if (bookList == null) {
            resp.getWriter().write("Книги с таким автором не найдено!");
        } else {
            resp.getWriter().write(libraryService.getBooks(bookList));
        }
    }
}