package Driver;

import java.util.List;

import dao.ProductCrud;
import dto.Product;

public class ProductCrudDriver {
	public static void main(String[] args) {
		Product product=new Product();
		ProductCrud crud=new ProductCrud();
		product.setId(1);
		product.setName("Laptop");
		product.setBrand("Lenovo");
		product.setType("HardDisk");
		product.setCost(25000);
//		System.out.println(product);
		
//		//crud.save(product);
//		List<Product> list=crud.getAll();
//		System.out.println(list);
		
//		Product product1=crud.getById(6);
//		System.out.println(product1);
		//crud.deleteById(11);
		crud.updateTheProduct(product, 17);
		
	}

}
