package kr.or.dgit.coffee_application.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.coffee_application.dto.PdIntro;
import kr.or.dgit.coffee_application.dto.Product;

public interface CoffeeDao {
	/*void insertItem(T item) throws SQLException;
	void updateItem(T item) throws SQLException;
	void deleteItem(T item) throws SQLException;
	List<T> selectItemByAll() throws SQLException;
	T selectItemByNo(T item) throws SQLException;
	*/
	
	List<PdIntro> selectPriceByAll() throws SQLException;
	PdIntro selectPriceByNo(PdIntro intro) throws SQLException;
	List<PdIntro> selectPriceByAllMargin() throws SQLException;
	List<PdIntro> selectPriceByAllSelling() throws SQLException;
	int updatePrice(PdIntro intro) throws SQLException;
	int deletePrice(PdIntro intro) throws SQLException;
	int insertPrice(PdIntro intro) throws SQLException;
	
	List<Product> selectProductByAll() throws SQLException;
	Product selectProductByNo(Product prd) throws SQLException;
	int updateProduct(Product prd) throws SQLException;
	int deleteProduct(Product prd) throws SQLException;
	int insertProduct(Product prd) throws SQLException;
	
}
