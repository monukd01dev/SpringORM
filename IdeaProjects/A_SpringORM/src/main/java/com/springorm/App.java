package com.springorm;

import com.springorm.dao.ProductDaoImpl;
import com.springorm.entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        ProductDaoImpl dao1 = new ProductDaoImpl(context.getBean("hibernateTemplate", HibernateTemplate.class));
        ProductDaoImpl productDao = context.getBean("productDao", ProductDaoImpl.class);

//       Create
        Product p1 = new Product(101, "Phone", 12000);
        Product p2 = new Product(102, "Phone", 12000);
        Product p3 = new Product(103, "Clothe", 1000);
//        System.out.println(productDao.insert(p1));
        System.out.println(productDao.insert(p2));
        System.out.println(productDao.insert(p3));

        System.out.println("Inserted successfully");
//        Read
        System.out.println(productDao.getProduct(101));

//        Updating the p1
        p1.setName("Mini-Clips");
        p1.setPrice(152.60);

        productDao.updateProduct(p1);
        System.out.println(productDao.getProduct(101));
        System.out.println(" ");

//        Delete
        productDao.deleteProduct(101);
        for (Product product:productDao.getAllProducts()) {
            System.out.println(product);
        }

    }

}
