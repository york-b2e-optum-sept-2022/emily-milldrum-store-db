package net.yorksolutions.storebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    private ArrayList<Product> list = new ArrayList<>();

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    public Iterable<Product> getAll(){
        return this.productRepo.findAll();
    }
    public void save(Product p) {
       //do work
        p.productName = p.productName.toLowerCase().replace(" ", "");
        if(p.price < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
       this.productRepo.save(p);
        System.out.println(p + " saved");
        System.out.println(this.getAll());
    }

    public boolean delete(Long id) {

        //Optional<Product>
        //find id, if exists send to product repo delete, if not throw error
        if (productRepo.existsById(id) ){
            productRepo.deleteById(id);
            return true;
        }
        else {
            return false;

        // for (productRepo : list){}
//        for(int i = 0; i < this.list.size(); i++){
//            if(Objects.equals(this.list.get(i).getId(), id)){
//                this.list.remove(i);
//                return true;
//                break;
//            }
//            return false;
        }

//        }
        //
    }

    public void replace(Long id, Product p) {
        //find id and replace...something using existsbyid
//        if (productRepo.existsById(id)){
//            this.productRepo.save(p);
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
        for(int i = 0; i < this.list.size(); i++){
            if(this.list.get(i).getId() == id){
                //this.list.set(i,p);
                this.list.set(this.list.indexOf(id),p);
                break;
            }
        }
    }

    public void sale(double price, boolean onSale){
        for(int i = 0; i < this.list.size(); i++){
            if(this.list.get(i).getCurrentPrice() > price){
                this.list.get(i).setOnSale(onSale);
            }
        }
    }
}
