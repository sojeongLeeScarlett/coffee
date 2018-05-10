package kr.or.dgit.coffee_application.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.coffee_application.dao.PdIntroDao;
import kr.or.dgit.coffee_application.dao.ProductDao;
import kr.or.dgit.coffee_application.dto.PdIntro;
import kr.or.dgit.coffee_application.dto.Product;
import kr.or.dgit.coffee_application.service.PdIntroService;
import kr.or.dgit.coffee_application.service.ProductService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CoffeeUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfpdCode;
	private JTextField tfpdName;
	private JTextField tfpdup;
	private JTextField tfus;
	private JTextField tfpm;
	private JButton btnInput;
	ProductService ps = new ProductService();
	PdIntroService pi = new PdIntroService();
	private JButton btnOutput1;
	private JButton btnOutput2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeUI frame = new CoffeeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeUI() {
		initComponents();
	}
	private void initComponents() {
		setTitle("판매실적 계산 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pTop = new JPanel();
		contentPane.add(pTop, BorderLayout.NORTH);
		
		JLabel lblpdCode = new JLabel("제품 코드");
		pTop.add(lblpdCode);
		
		tfpdCode = new JTextField();
		tfpdCode.addActionListener(this);
		pTop.add(tfpdCode);
		tfpdCode.setColumns(10);
		
		JLabel lblpdName = new JLabel("제품명");
		pTop.add(lblpdName);
		
		tfpdName = new JTextField();
		tfpdName.setColumns(10);
		pTop.add(tfpdName);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblpdup = new JLabel("제품단가");
		lblpdup.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblpdup);
		
		tfpdup = new JTextField();
		tfpdup.setColumns(10);
		pCenter.add(tfpdup);	//제품단가
		
		JLabel lblus = new JLabel("판매수량");
		lblus.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblus);
		
		tfus = new JTextField();
		tfus.setColumns(10);
		pCenter.add(tfus);	//판매수량
		
		JLabel lblpm = new JLabel("마 진 율");
		lblpm.setHorizontalAlignment(SwingConstants.RIGHT);
		pCenter.add(lblpm);
		
		tfpm = new JTextField();
		tfpm.setColumns(10);
		pCenter.add(tfpm);	//마진율
		
		JPanel pBottom = new JPanel();
		contentPane.add(pBottom, BorderLayout.SOUTH);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		pBottom.add(btnInput);
		
		btnOutput1 = new JButton("출력1");
		btnOutput1.addActionListener(this);
		pBottom.add(btnOutput1);
		
		btnOutput2 = new JButton("출력2");
		btnOutput2.addActionListener(this);
		pBottom.add(btnOutput2);
	}
	
	public void clearItem() {
		tfpdCode.setText("");
		tfpdName.setText("");
		tfpdup.setText("");
		tfus.setText("");
		tfpm.setText("");
		
	}
	
	public boolean isEmpty() {
		return tfpdCode.getText().equals("") || 
				tfpdName.getText().equals("") || 
				tfpdup.getText().equals("") || 
				tfus.getText().equals("") ||
				tfpm.getText().equals("");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfpdCode) {
			actionPerformedTfpdCode(e);
		}
		if (e.getSource() == btnOutput2) {
			actionPerformedBtnOutput2(e);
		}
		if (e.getSource() == btnOutput1) {
			actionPerformedBtnOutput1(e);
		}
		if (e.getSource() == btnInput) {
			actionPerformedBtnInput(e);
		}
	}
	protected void actionPerformedBtnInput(ActionEvent e) {
		String pdCode = tfpdCode.getText();
		String pdName = tfpdName.getText();
		Product pd = new Product(pdCode, pdName);
		try {
			int pdUnitprice = Integer.parseInt(tfpdup.getText());
			int pdUnitsales = Integer.parseInt(tfus.getText());
			int pdPermargin = Integer.parseInt(tfpm.getText());
			
			PdIntro pdIntro = new PdIntro(pd, pdUnitprice, pdUnitsales, pdPermargin);
			pi.insertItem(pdIntro);
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "숫자만 입력가능");
			clearItem();
		}
		
		
		
		
		
	}
	protected void actionPerformedBtnOutput1(ActionEvent e) {
		Coffee_output1_table cot1 = new Coffee_output1_table();
			cot1.setBounds(100, 100, 700, 500);
			cot1.setVisible(true);
	}
	protected void actionPerformedBtnOutput2(ActionEvent e) {
		Coffee_output2_table cot2 = new Coffee_output2_table();
		cot2.setBounds(100, 100, 700, 500);
		cot2.setVisible(true);
	}
	protected void actionPerformedTfpdCode(ActionEvent e) {
		if(tfpdCode.getText().trim().equals("")) {
			return;
		}
		
		String pdCode =tfpdCode.getText();
		Product product = new Product();
		product.setPdCode(pdCode);
		try {
			product = ProductDao.getInstance().selectItemByNo(product);
			tfpdName.setText(product.getPdName());
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
