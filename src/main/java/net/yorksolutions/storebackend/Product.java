package net.yorksolutions.storebackend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table()
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;

    @JsonProperty
    @Column()
    String productName, displayName;
    @JsonProperty
    Double price, salePercent, currentPrice;

    @JsonProperty
    Boolean onSale;

    public Product() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(Double salePercent) {
        this.salePercent = salePercent;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }



    public Product(Long id, String productName, String displayName,
                   Double price, Double salePercent, boolean onSale)
    {
        this.id = 1L + (long) (Math.random() * (5L - 1L));
        this.productName = productName.toLowerCase();
        this.displayName = displayName;
        this.price = price;
        this.salePercent = salePercent;
        this.onSale = onSale;
        this.setCurrentPrice();
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
        this.setCurrentPrice();
    }

    public void setCurrentPrice(){
        if (this.onSale) {
            this.currentPrice = (this.getPrice() - (this.getCurrentPrice() * this.getSalePercent()));
        }
        else
        {
            this.currentPrice = this.getPrice();
        }
    }
}
