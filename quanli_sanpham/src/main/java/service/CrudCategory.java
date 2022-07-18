package service;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CrudCategory {
    public List<Category> categories = new ArrayList<>();

    public CrudCategory(){
        categories.add(new Category(1,"Nor"));
        categories.add(new Category(2,"Pro"));
        categories.add(new Category(3,"ProMax"));
    }
    public Category findCategoryById(int id){
        for(int i=0;i<categories.size();i++){
            if(categories.get(i).getId()==id){
                return categories.get(i);
            }
        }
        return null;
    }
}
