package kr.or.dgit.coffee_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import kr.or.dgit.coffee_application.dto.PdIntro;
import kr.or.dgit.coffee_application.dto.Product;
import kr.or.dgit.erp_application.jdbc.DBcon;

public class PdIntroDao implements DaoInterface<PdIntro> {
	private static final PdIntroDao instance = new PdIntroDao();
	

	public static PdIntroDao getInstance() {
		return instance;
	}

	@Override
	public void insertItem(PdIntro item) throws SQLException {
		String sql ="insert into pdintro values(?,?,?,?,?)";
		Connection con = DBcon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getPd().getPdCode());
			pstmt.setString(2, item.getPd().getPdName());
			pstmt.setInt(3, item.getPdUnitprice());	//제품단가
			pstmt.setInt(4, item.getPdUnitsales());		//판매수량
			pstmt.setInt(5, item.getPdPermargin());		//마진율
			System.out.println(pstmt);
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void updateItem(PdIntro item) throws SQLException {
		String sql ="update pdintro set pdUnitprice=? pdUnitsales=? pdPermargin=? where pdCode=?;";
		Connection con = DBcon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getPdUnitprice());
			pstmt.setInt(2, item.getPdUnitsales());
			pstmt.setInt(3, item.getPdPermargin());
			pstmt.setString(4, item.getPd().getPdCode());
			
			System.out.println(pstmt);
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void deleteItem(PdIntro item) throws SQLException {
		String sql = "delete from pdintro where pdCode=?;";
		Connection con = DBcon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getPd().getPdCode());
			
			System.out.println(pstmt);
			pstmt.executeUpdate();
		}
		
	}

	
	public List<PdIntro> selectItemByAllSelling() throws SQLException {
		String sql ="select s.pdCode,s.pdName,s.pdUnitprice,s.pdUnitsales,s.pdPermargin, (s.pdUnitprice*s.pdUnitsales) as selling," + 
				"round((s.pdUnitprice*s.pdUnitsales)/11) as vat, round((s.pdUnitprice*s.pdUnitsales)-(s.pdUnitprice*s.pdUnitsales)/11) as supplyvalue," + 
				"round(((s.pdUnitprice*s.pdUnitsales)-round((s.pdUnitprice*s.pdUnitsales)/11))*(s.pdPermargin/100)) as margin," + 
				"(select count(*)+1 from pdintro where (pdUnitprice*pdUnitsales)>(s.pdUnitprice*s.pdUnitsales)) as 'rank' " + 
				"from product pr join pdintro s on s.pdCode = pr.pdCode order by rank;";
		
		Connection con = DBcon.getInstance().getConnection();
		List<PdIntro> list = new ArrayList<>();
		try(Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(getPdIntro(rs));
			}
		} 
		return list;
	}
	
	
	public List<PdIntro> selectItemByAllMargin() throws SQLException {
		String sql ="select s.pdCode,s.pdName,s.pdUnitprice,s.pdUnitsales,s.pdPermargin, (s.pdUnitprice*s.pdUnitsales) as selling," + 
				"round((s.pdUnitprice*s.pdUnitsales)/11) as vat, round((s.pdUnitprice*s.pdUnitsales)-(s.pdUnitprice*s.pdUnitsales)/11) as supplyvalue, " + 
				"round(((s.pdUnitprice*s.pdUnitsales)-round((s.pdUnitprice*s.pdUnitsales)/11))*(s.pdPermargin/100)) as margin," + 
				"(select count(*)+1 from pdintro where round(((pdUnitprice*pdUnitsales)-round((pdUnitprice*pdUnitsales)/11))*(pdPermargin/100))>" + 
				"round(((s.pdUnitprice*s.pdUnitsales)-round((s.pdUnitprice*s.pdUnitsales)/11))*(s.pdPermargin/100))) as 'rank' " + 
				"from product pr join pdintro s on s.pdCode = pr.pdCode order by rank;";
		Connection con = DBcon.getInstance().getConnection();
		List<PdIntro> list = new ArrayList<>();
		try(Statement stmt = con.createStatement();) {
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(getPdIntro(rs));
			}
		} 
		return list;
	}

	private PdIntro getPdIntro(ResultSet rs) throws SQLException {
		String pdCode = rs.getString("pdCode");
		String pdName = rs.getString("pdName");
		Product pd = new Product(pdCode, pdName);
		int pdUnitprice = rs.getInt("pdUnitprice");
		int pdUnitsales = rs.getInt("pdUnitsales");
		int pdPermargin = rs.getInt("pdPermargin");
		int rank = rs.getInt("rank");
		int supplyvalue = rs.getInt("supplyvalue");
		int selling = rs.getInt("selling");
		int vat = rs.getInt("vat");
		int margin = rs.getInt("margin");
		
		return new PdIntro(pd, pdUnitprice, pdUnitsales, pdPermargin, rank, supplyvalue, selling, vat, margin);
	}
	
	private PdIntro getPdIntroByNo(ResultSet rs) throws SQLException {
		String pdCode = rs.getString("pdCode");
		String pdName = rs.getString("pdName");
		Product pd = new Product(pdCode, pdName);
		int pdUnitprice = rs.getInt("pdUnitprice");
		int pdUnitsales = rs.getInt("pdUnitsales");
		int pdPermargin = rs.getInt("pdPermargin");
		
		
		return new PdIntro(pd, pdUnitprice, pdUnitsales, pdPermargin);
	}

	@Override
	public PdIntro selectItemByNo(PdIntro item) throws SQLException {
		String sql = "select pdCode,pdName,pdUnitprice,pdUnitsales,pdPermargin from pdintro where pdCode=?;";
		Connection con = DBcon.getInstance().getConnection();
		PdIntro findPdIntro = null;
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getPd().getPdCode());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					findPdIntro = getPdIntroByNo(rs);
				}
			}
		}
		return findPdIntro;
	}

	@Override
	public List<PdIntro> selectItemByAll() throws SQLException {
		String sql ="select pdCode,pdName,pdUnitprice,pdUnitsales,pdPermargin from pdintro";
		Connection con = DBcon.getInstance().getConnection();
		List<PdIntro> list = new ArrayList<>();
		try(Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(getPdIntroAll(rs));
			}
		} 
		return list;
	}

	private PdIntro getPdIntroAll(ResultSet rs) throws SQLException {
		String pdCode = rs.getString("pdCode");
		String pdName = rs.getString("pdName");
		Product pd = new Product(pdCode, pdName);
		int pdUnitprice = rs.getInt("pdUnitprice");
		int pdUnitsales = rs.getInt("pdUnitsales");
		int pdPermargin = rs.getInt("pdPermargin");
		return new PdIntro(pd, pdUnitprice, pdUnitsales, pdPermargin);
	}

	
}
