package kr.or.dgit.coffee_application.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.dgit.coffee_application.dto.PdIntro;

public interface DaoInterface<T> {
	void insertItem(T item) throws SQLException;
	void updateItem(T item) throws SQLException;
	void deleteItem(T item) throws SQLException;
	List<T> selectItemByAll() throws SQLException;
	T selectItemByNo(T item) throws SQLException;
	
	
}
