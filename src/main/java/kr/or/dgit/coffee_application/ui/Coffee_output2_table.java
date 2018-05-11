package kr.or.dgit.coffee_application.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.coffee_application.dto.PdIntro;
import kr.or.dgit.coffee_application.service.CoffeeService;

public class Coffee_output2_table extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coffee_output2_table frame = new Coffee_output2_table();
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
	public Coffee_output2_table() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblRank1 = new JLabel("마 진 액 순 위");
		contentPane.add(lblRank1, BorderLayout.NORTH);
		lblRank1.setVerticalAlignment(SwingConstants.TOP);
		lblRank1.setFont(new Font("돋움", Font.BOLD, 27));
		lblRank1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadDatas();
		tableCellAlign(SwingConstants.RIGHT,0,1,2,3,4,5,6,7,8,9);
		scrollPane.setViewportView(table);
	}

	private void tableCellAlign(int align,int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = table.getColumnModel();
		for(int i = 0; i<idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	private void loadDatas() {
		NonEditableModel model = new NonEditableModel(getRows(), getColumNames());
		table.setModel(new DefaultTableModel(getRows(),getColumNames()));
	}
	
	public String[] getColumNames() {
		return new String[] {
				"순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액"
			};
	}
	public Object[][] getRows(){
		Object[][] rows = null;
		List<PdIntro> list = CoffeeService.getInstance().selectPriceByAllMargin();
				//PdIntroDao.getInstance().selectItemByAllMargin();
		rows = new Object[list.size()+1][];
		int sumSv = 0;
		int sumVat = 0;
		int sumSell = 0;
		int sumMar =0;
		for(int i = 0; i<rows.length-1; i++) {
			rows[i] = list.get(i).toArray();
			sumSv += list.get(i).getSupplyvalue();
			sumVat += list.get(i).getVat();
			sumSell += list.get(i).getSelling();
			sumMar += list.get(i).getMargin();
		}
		rows[list.size()] = new String[] {"합계","","","","",String.format("%,d", sumSv),String.format("%,d", sumVat),
				String.format("%,d", sumSell),"",String.format("%,d", sumMar)
		};
		return rows;
	}
	
	class NonEditableModel extends DefaultTableModel{

		public NonEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}


	public int getselectedNo() {
		return (int) table.getValueAt(table.getSelectedRow(), 0);
	}

}
