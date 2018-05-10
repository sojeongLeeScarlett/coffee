package kr.or.dgit.coffee_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.ProgressBarUI;

import kr.or.dgit.coffee_application.dto.PdIntro;
import kr.or.dgit.coffee_application.dto.Product;
import kr.or.dgit.erp_application.jdbc.DBcon;

public class ProductDao implements DaoInterface<Product> {
	private static final ProductDao instance = new ProductDao();
	
	

	public static ProductDao getInstance() {
		return instance;
	}

	@Override
	public void insertItem(Product item) throws SQLException {
		String sql = "insert into product values (?,?);";
		Connection con = DBcon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, item.getPdCode());
			pstmt.setString(2, item.getPdName());
			System.out.println(pstmt);
				//나중에 없애기
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void updateItem(Product item) throws SQLException {
		String sql = "update product set pdName=? where pdCode=?;";
		Connection con = DBcon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, item.getPdName());
			pstmt.setString(2, item.getPdCode());
			
				//나중에 없애기
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void deleteItem(Product item) throws SQLException {
		String sql = "delete from product where pdCode=?;";
		Connection con = DBcon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, item.getPdCode());
			
			//나중에 없애기
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public List<Product> selectItemByAll() throws SQLException {
		String sql = "select pdCode,pdName from product;";
		Connection con = DBcon.getInstance().getConnection();
		List<Product> list = new ArrayList<>();
		try(Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(getProduct(rs));
			}
		} 
		return list;
	}

	private Product getProduct(ResultSet rs) throws SQLException{
		String pdCode = rs.getString("pdCode");
		String pdName = rs.getString("pdName");
		return new Product(pdCode, pdName);
	}

	@Override
	public Product selectItemByNo(Product item) throws SQLException {
		String sql = "select pdCode,pdName from product where pdCode=?;";
		Connection con = DBcon.getInstance().getConnection();
		Product findProduct = null;
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getPdCode());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					findProduct = getProduct(rs);
				}
			}
		}
		return findProduct;
	}



}
