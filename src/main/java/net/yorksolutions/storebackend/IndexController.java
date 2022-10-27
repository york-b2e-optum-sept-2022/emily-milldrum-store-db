package net.yorksolutions.storebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


// Problem in web applications: Client, and Server; each has its own state; need to keep the state in sync
// state - data that can change
// REST - well defined way for clients to retrieve and update a servers state
//      - NOT JSON SERVER
/*
Server:
State1: []
State2: [{id: 5, name: madison}]
Client:
State1: []
 */

// Controller - maps client requests to methods
// The thing that accepts http requests is not my application, it is TomCat
// Spring will configure TomCat to call the methods that I specify using annotations when certain http requests are received

// Request Life Cycle
// 1. Client generates request
// 2. TomCat receives the request
// 3. TomCat routes the request to our application's method
// 4. Our application's method returns a value
// 5. Spring transforms the value into an HTTP response
// 6. TomCat sends the response back to the Client

// TomCat is HTTP server
// HTTP Server is a program that listens for HTTP Requests and optionally responds

@RestController // tells the program that this is a controller class, allows this class to use the REST functions
@RequestMapping("/api") // localhost:8081/api
public class IndexController {
    ProductService productService;

    @Autowired
    public IndexController(ProductService productService){
        this.productService = productService;
    }

    // HTTP Request:
    //   method: GET
    //   url: http://localhost:8081/api/hello
    //   headers?
    //   body?
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/")
    public Iterable<Product> getProducts(){
        return this.productService.getAll();
    }

    // HTTP Request:
    //   method: POST
    //   url: http://localhost:8081/api/hello
    @PostMapping("/save")
    public void saveProduct(@RequestBody Product p){
        productService.save(p);
    }

    @DeleteMapping("/delete/{id}")
    String deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return productService.delete(id) ? "Success" : "Fail";
    }

    @PutMapping("/replace/{id}")
    public void replaceProduct(@PathVariable Long id, @RequestBody Product p){

        productService.replace(id, p);
        //return productService.(id, p);
        //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)

    }
}
