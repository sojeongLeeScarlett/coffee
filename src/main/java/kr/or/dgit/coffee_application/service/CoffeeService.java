package kr.or.dgit.coffee_application.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.coffee_application.dto.PdIntro;
import kr.or.dgit.coffee_application.dto.Product;
import kr.or.dgit.coffee_application.utils.MyBatisSqlSessionFactory;



public class CoffeeService {
	private static final CoffeeService instance = new CoffeeService();
	private static final Log log = LogFactory.getLog(CoffeeService.class);
	private final String namespace = "kr.or.dgit.coffee_application.dao.CoffeeDao.";
	
	public CoffeeService() {
	}
	public static CoffeeService getInstance() {
		return instance;
	}
	
	public List<PdIntro> selectPriceByAll() {
		log.debug("selectPriceByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectPriceByAll");
		}
	}
	
	public PdIntro selectPriceByNo(PdIntro pdintro) {
		log.debug("selectPriceByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectPriceByNo", pdintro);
		}
	}
	
	public List<PdIntro> selectPriceByAllMargin(){
		log.debug("selectPriceByAllMargin()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectPriceByAllMargin");
		}
	}
	
	public List<PdIntro> selectPriceByAllSelling(){
		log.debug("selectPriceByAllSelling()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectPriceByAllSelling");
		}
	}
	
	public int updatePrice(PdIntro pdintro) {
		log.debug("updatePrice()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "updatePrice", pdintro);
			sqlSession.commit();
		}
		return res;
	}
	
	public int deletePrice(PdIntro pdintro) {
		log.debug("deletePrice()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.delete(namespace + "deletePrice", pdintro);
			sqlSession.commit();
		}
		return res;
	}
	
	public int insertPrice(PdIntro pdintro) {
		log.debug("insertPrice()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertPrice", pdintro);
			sqlSession.commit();
		}
		return res;
	}
	
	public List<Product> selectProductByAll() {
		log.debug("selectProductByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectProductByAll");
		}
	}
	
	public Product selectProductByNo(Product product) {
		log.debug("selectPriceByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectProductByNo", product);
		}
	}
	
	public int updateProduct(Product product) {
		log.debug("updateProduct()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "updateProduct", product);
			sqlSession.commit();
		}
		return res;
	}
	
	public int deleteProduct(Product product) {
		log.debug("deleteProduct()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.delete(namespace + "deleteProduct", product);
			sqlSession.commit();
		}
		return res;
	}
	
	public int insertProduct(Product product) {
		log.debug("insertProduct()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertProduct", product);
			sqlSession.commit();
		}
		return res;
	}
	
}
