package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CrudProduct {
    public List<Product> products = new ArrayList<>();
    CrudCategory crudCategory = new CrudCategory();

    public CrudProduct(){
        products.add(new Product(1,"Iphone11",900,"https://i.pinimg.com/236x/ca/18/45/ca18455b23e6205862a1d6ea1e3be4aa.jpg",crudCategory.categories.get(1)));
        products.add(new Product(2,"Iphone12",1000,"https://i.pinimg.com/236x/b2/fc/98/b2fc9885b32b4c07e6767d0d3df9925b.jpg",crudCategory.categories.get(2)));
    }
    public void create(Product product){
        products.add(product);
    }
    public void edit(int id,Product product){
        products.set(vtProduct(id),product);
    }
    public void delete(int id){
        products.remove(vtProduct(id));
    }
    public int vtProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdP() == id) {
                return i;
            }
        }
        return -1;
    }

    public Product findProductByName(String name){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getNameP().contains(name)){
                return products.get(i);
            }
        }
        return null;
    }
}
