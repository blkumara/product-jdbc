package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Helper.Helper;
import dto.Product;

public class ProductCrud {
	Helper helper = new Helper();

	Connection connection = helper.getConnectionObj();

	public void save(Product product) {
		String query = "insert into product values(?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getBrand());
			preparedStatement.setString(4, product.getType());
			preparedStatement.setDouble(5, product.getCost());
			preparedStatement.execute();

			System.out.println("Data Saved");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>();
		String query = "Select * from product";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ArrayList<Product> arrayList = new ArrayList<Product>();
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String brand = resultSet.getString(3);
				String type = resultSet.getString(4);
				double cost = resultSet.getDouble(5);

				Product product = new Product();
				product.setId(1);
				product.setName(name);
				product.setBrand(brand);
				product.setType(type);
				product.setCost(cost);
				list.add(product);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public Product getById(int id) {
		String query = "Select * from product where id=?";
		Product product = new Product();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setBrand(resultSet.getString("brand"));
				product.setType(resultSet.getString("type"));
				product.setCost(resultSet.getDouble("cost"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return product;
	}

	public void deleteById(int id) {
		String sql = "delete from product where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			preparedStatement.close();

			System.out.println("You Entered product isd " + id + "is deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateTheProduct(Product product, int id) {
		String sql = "Update product SET name=?,brand=?,type=?,cost=? where id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getBrand());
			preparedStatement.setString(3, product.getType());
			preparedStatement.setDouble(4, product.getCost());
			preparedStatement.setInt(5, product.getId());

			preparedStatement.execute();

			preparedStatement.close();
			System.out.println("Product updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}