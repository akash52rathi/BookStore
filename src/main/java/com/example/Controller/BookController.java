package com.example.Controller;


import com.example.Entity.Book;
import com.example.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    // Create APi
    @PostMapping("/addbooks")
    public Book addProduct(@RequestBody Book book) {
        return service.saveProduct(book);
    }

    // Read Api
    @GetMapping("/books")
    public List<Book> findAllProducts() {
        return service.getProducts();
    }
    // Read Api By Name
    @GetMapping("/books/{name}")
    public Book findProductByName(@PathVariable  String name) {
        return service.getproductByname(name);
    }
    // Read Api By ID
    @GetMapping("/book/{id}")
    public  Book findProductById(@PathVariable int id)
    {
        return  service.getProductById(id);
    }
    // Fetch By List of Ids:
    @PostMapping("/getbooks")
    public List<Book> getProductByIds(@RequestBody List<Integer> listOfIds) {
        return service.getProductByIds(listOfIds);
    }
    // Delete Api
    @DeleteMapping("/books/{id}")
    public  String deleteProduct(@PathVariable int id)
    {
        return service.deleteProduct(id);
    }
    // Update APi
    @PutMapping("/books/{id}")
    public String updateProduct(@RequestBody Book book)
    {
        return service.updateProduct(book);
    }


}
