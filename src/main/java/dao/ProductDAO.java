package dao;

import dbutil.DBUtil;
import pojo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<Product> getALlProducts(String productName, String productCategory, String createdDate) {
        List<Product> productList = new ArrayList<>();
        String findProduct = "";

        if (productName != null && !productName.isEmpty()) {
            findProduct += "product_name = '" + productName + "'";
        }

        if (productCategory != null && !productCategory.isEmpty()) {
            if (!findProduct.isEmpty()) {
                findProduct += " AND ";
            }
            findProduct += "product_category = '" + productCategory + "'";
        }

        if (createdDate != null && !createdDate.isEmpty()) {
            if (!findProduct.isEmpty()) {
                findProduct += " AND ";
            }
            findProduct += "created_date = '" + createdDate + "'";
        }

        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM product";
            if (!findProduct.isEmpty()) {
                query += " WHERE " + findProduct;
            }

            System.out.println(query);

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Product product = new Product(resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("product_category"),
                        resultSet.getInt("product_price"),
                        resultSet.getString("created_date"));
                productList.add(product);
            }

            DBUtil.closeConnection(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productList;
    }


    public static int addProduct(Product product){
        int status = 0;

        try {
            Connection connection = DBUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product VALUES (?,?,?,?,?)");

            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(4, product.getProductPrice());
            preparedStatement.setString(3, product.getProductCategory());
            preparedStatement.setString(5, product.getCreatedDate());
            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static Product getProductById(Integer productId){
        Product product = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE product_id = ?");
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product = new Product(resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("product_category"),
                        resultSet.getInt("product_price"),
                        resultSet.getString("created_date")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public static int updateProduct(Product product){
        int status = 0;

        try {
            Connection connection = DBUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET product_name=?, product_price=?, product_category=? WHERE product_id=?");

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getProductPrice());
            preparedStatement.setString(3, product.getProductCategory());
            preparedStatement.setInt(4, product.getProductId());
            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
           // throw new RuntimeException(e);
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteProduct(int productId){
        int status = 0;

        try {
            Connection connection = DBUtil.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product  WHERE product_id=?");

            preparedStatement.setInt(1, productId);
            status = preparedStatement.executeUpdate();

        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return status;
    }

}
