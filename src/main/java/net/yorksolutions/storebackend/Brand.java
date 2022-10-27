package net.yorksolutions.storebackend;


import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    //public String name;

    @OneToMany
    public ArrayList<Product> brand;
}
