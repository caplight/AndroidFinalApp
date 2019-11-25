package com.caplight.finalapp.pojo;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2019-11-20 10:39:11
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -96991568024744640L;
    
    private Integer id;
    
    private String proName;
    
    private Integer proPrice;
    
    private String proImg;

    public Product() {
    }

    public Product(Integer id, String proName, Integer proPrice, String proImg) {
        this.id = id;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proImg = proImg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getProPrice() {
        return proPrice;
    }

    public void setProPrice(Integer proPrice) {
        this.proPrice = proPrice;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

}