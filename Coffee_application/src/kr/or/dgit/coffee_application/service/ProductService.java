package kr.or.dgit.coffee_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.coffee_application.dao.ProductDao;
import kr.or.dgit.coffee_application.dto.Product;

public class ProductService {
	String message = null;
	public void insertItem(Product item) {
		try {
			ProductDao.getInstance().insertItem(item);
		} catch (SQLException e) {
			message = String.format("%s - %s",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}
	public void updateItem(Product item) {
		try {
			ProductDao.getInstance().updateItem(item);
		} catch (SQLException e) {
			message = String.format("%s - %s",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}
	public void deleteItem(Product item) {
		try {
			ProductDao.getInstance().deleteItem(item);
		} catch (SQLException e) {
			message = String.format("%s - %s",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}
	public List<Product> selectItemByAll(){
		List<Product> lists = null;
		try {
			lists = ProductDao.getInstance().selectItemByAll();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getErrorCode() +" : "+ e.getMessage());
			e.printStackTrace();
		}
		return lists;
	}
	public Product selectItemByNo(Product item) {
		Product searchProduct = null;
		try {
			searchProduct = ProductDao.getInstance().selectItemByNo(item);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getErrorCode() +" : "+ e.getMessage());
			e.printStackTrace();
		}
		return searchProduct;
	}
}
