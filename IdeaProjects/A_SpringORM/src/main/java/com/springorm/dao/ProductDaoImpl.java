package com.springorm.dao;

import com.springorm.entities.Product;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

/*
    Name    : Monu KD (monukd01dev)
    Project : A_SpringORM
    Date    : 11-Sep-2023
    
    Connect
    Twitter  : https://twitter.com/monukd01dev
    LinkedIN : https://www.linkedin.com/in/monukd01dev/
    GitHub   : https://github.com/monukd01dev
     
*/
public class ProductDaoImpl{
    private HibernateTemplate template;
    //constructor
    public ProductDaoImpl() {
        super();
    }
    public ProductDaoImpl(HibernateTemplate template) {
        this.template = template;
    }

    //setter and getter

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }


//    insert -> return the primary key
    @Transactional
    public int insert(Product product) {
        return (Integer) this.template.save(product);
    }

    //    fetch
    public Product getProduct(int product_id) {
        return this.template.get(Product.class, product_id);
    }

    //    fetch_All
    public List<Product> getAllProducts() {
        return this.template.loadAll(Product.class);
    }

    //    Delete first getProduct then delete
    @Transactional
    public void deleteProduct(int product_id) {
        this.template.delete(getProduct(product_id));
    }

    //    update
    @Transactional
    public void updateProduct(Product product) {
        this.template.update(product);
    }

}
