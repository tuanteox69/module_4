package model;

public class Product {
    private int idP ;
    private String nameP;
    private int priceP;
    private String imgP ;
    private Category category;
    private boolean status=true;


    public Product(int idP, String nameP, int priceP, String imgP, Category category) {
        this.idP = idP;
        this.nameP = nameP;
        this.priceP = priceP;
        this.imgP = imgP;
        this.category = category;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public int getPriceP() {
        return priceP;
    }

    public void setPriceP(int priceP) {
        this.priceP = priceP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
