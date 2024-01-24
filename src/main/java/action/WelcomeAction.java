package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.ProductDAO;
import pojo.Product;

import java.util.List;

public class WelcomeAction extends ActionSupport {

    List<Product> products;

    public void initializeProducts(){
        products = ProductDAO.getALlProducts();
    }

    public String execute(){
        initializeProducts();
        return "success";
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
