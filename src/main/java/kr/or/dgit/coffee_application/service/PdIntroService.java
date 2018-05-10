package kr.or.dgit.coffee_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.coffee_application.dao.PdIntroDao;
import kr.or.dgit.coffee_application.dto.PdIntro;

public class PdIntroService {
	String message = null;
	public void insertItem(PdIntro item) {
		try {
			PdIntroDao.getInstance().insertItem(item);
		} catch (SQLException e) {
			message = String.format("%s - %s",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}
	public void updateItem(PdIntro item) {
		try {
			PdIntroDao.getInstance().updateItem(item);
		} catch (SQLException e) {
			message = String.format("%s - %s",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}
	public void deleteItem(PdIntro item) {
		try {
			PdIntroDao.getInstance().deleteItem(item);
		} catch (SQLException e) {
			message = String.format("%s - %s",e.getErrorCode(),e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<PdIntro> selectItemByAll(){
		List<PdIntro> lists = null;
		try {
			lists = PdIntroDao.getInstance().selectItemByAll();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getErrorCode() +" : "+ e.getMessage());
			e.printStackTrace();
		}
		return lists;
	}
	public PdIntro selectItemByNo(PdIntro item) {
		PdIntro searchPdIntro = null;
		try {
			searchPdIntro = PdIntroDao.getInstance().selectItemByNo(item);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getErrorCode() +" : "+ e.getMessage());
			e.printStackTrace();
		}
		return searchPdIntro;
	}
	
}
