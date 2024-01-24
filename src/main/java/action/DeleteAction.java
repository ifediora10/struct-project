package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.ProductDAO;

public class DeleteAction extends ActionSupport {
    Integer productId;

    public String execute(){
        String statusCode;

        int productDeleted = ProductDAO.deleteProduct(productId);
        if (productDeleted == 1){
            statusCode = "success";
        }else {
            statusCode = "error";
        }
        return statusCode;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
