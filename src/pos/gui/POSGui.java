package pos.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import pos.POS;
import pos.Transaction;
import pos.entity.Food;
import pos.entity.NonFood;
import pos.entity.Product;
import javax.swing.ListSelectionModel;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class POSGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private List<Transaction> history;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	private List<Product> product = null;
	private List<Product> stock;
	private List<Product> selectedProduct = new ArrayList<Product>();

	private String status = "";
	private final JDesktopPane desktopPane = new JDesktopPane();
	private final JLabel label = new JLabel("\uC218\uB7C9\uC744 \uCD08\uACFC\uD558\uC600\uC2B5\uB2C8\uB2E4");
	private POS pos;

	public POSGui() {
		setResizable(false);
		pos = new POS("dlscjf151", 50000);
		stock = pos.GetProduct();
		POSGui posgui = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setEnabled(false);
//		scrollPane_1.setVisible(false);
//		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
//		contentPane.add(scrollPane_1);
		table_3 = new JTable();
		table_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_3.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table_3.setRowHeight(30);
		table_3.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
		table_3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "No.", "\uC0C1\uD488", "\uCD1D\uAE08\uC561", "\uD658\uBD88 \uC5EC\uBD80",
						"\uAC70\uB798\uC77C\uC790" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_3.getColumnModel().getColumn(0).setResizable(false);
		table_3.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_3.getColumnModel().getColumn(1).setResizable(false);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(300);
		table_3.getColumnModel().getColumn(2).setResizable(false);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_3.getColumnModel().getColumn(3).setResizable(false);
		table_3.getColumnModel().getColumn(4).setResizable(false);
		table_3.getColumnModel().getColumn(4).setPreferredWidth(125);
		table_3.getTableHeader().setReorderingAllowed(false);
		table_3.getTableHeader().setResizingAllowed(false);
		table_3.getTableHeader().setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table_3.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JScrollPane scrollPane_3 = new JScrollPane(table_3);
		scrollPane_3.setSize(1006, 304);
		scrollPane_3.setLocation(0, 92);
		scrollPane_3.setEnabled(false);
		scrollPane_3.setVisible(false);

		desktopPane.setBackground(SystemColor.inactiveCaption);
		desktopPane.setBounds(359, 254, 437, 136);
		contentPane.add(desktopPane);
		desktopPane.setLayout(new BorderLayout(0, 0));
		label.setBackground(SystemColor.inactiveCaption);
		label.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		desktopPane.add(label);
		desktopPane.setVisible(false);
		contentPane.add(scrollPane_3);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table_1.setRowHeight(30);
		table_1.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
		table_1.setModel(new DefaultTableModel(null,
				new String[] { "No.", "»óÇ° ÀÌ¸§", "°¡°Ý", "¼ö·®", "\uC720\uD1B5\uAE30\uD55C/\uC131\uC778" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(300);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
		table_1.getTableHeader().setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));

		tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tcmSchedule = table_1.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setEnabled(false);
		scrollPane_1.setVisible(false);

		table_2 = new JTable();
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table_2.setRowHeight(30);
		table_2.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
		table_2.setModel(new DefaultTableModel(null,
				new String[] { "No.", "»óÇ° ÀÌ¸§", "°¡°Ý", "¼ö·®", "\uC720\uD1B5\uAE30\uD55C/\uC131\uC778" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(300);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_2.getColumnModel().getColumn(3).setResizable(false);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(4).setResizable(false);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_2.getTableHeader().setReorderingAllowed(false);
		table_2.getTableHeader().setResizingAllowed(false);
		table_2.getTableHeader().setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));

		Panel panel_2 = new Panel();
		panel_2.setVisible(false);
		panel_2.setBounds(1012, 99, 271, 336);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_10 = new JButton("\uCD94\uAC00");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POSdialog dialog = new POSdialog(posgui);
				dialog.setVisible(true);
			}
		});
		btnNewButton_10.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_10.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_10.setBounds(71, 72, 130, 50);
		panel_2.add(btnNewButton_10);

		JButton btnNewButton_10_1 = new JButton("\uC218\uC815");
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p;
				if (table_2.getSelectedRowCount() != 1) {
					return;
				}
				p = stock.get(table_2.getSelectedRow());
				POSdialog dialog = new POSdialog(posgui, p);
				dialog.setVisible(true);
			}
		});
		btnNewButton_10_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_10_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_10_1.setBounds(71, 174, 130, 50);
		panel_2.add(btnNewButton_10_1);

		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setVisible(false);
		scrollPane_2.setBounds(0, 92, 1006, 304);

		scrollPane_2.setEnabled(false);

		contentPane.add(scrollPane_2);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(0, 92, 1006, 304);
		contentPane.add(scrollPane_1);

		tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tcmSchedule = table_2.getColumnModel();

		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1290, 73);
		panel.setBackground(new Color(100, 149, 237));
		panel.setForeground(SystemColor.desktop);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uB9E4\uC7A5\uAD00\uB9AC \uC2DC\uC2A4\uD15C");
		lblNewLabel_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(1077, 40, 178, 29);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("POS");
		lblNewLabel.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(1100, 10, 128, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("RadioButtonMenuItem.disabledForeground"));
		panel_1.setBounds(0, 73, 1290, 20);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel();
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					long systemTime = System.currentTimeMillis();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
					String dTime = formatter.format(systemTime);
					lblNewLabel_2.setText(dTime);
				}
			}

		};
		thread.start();

		lblNewLabel_2.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(0, 0, 216, 20);
		panel_1.add(lblNewLabel_2);

		table = new JTable();
		table.setRequestFocusEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(30);
		table.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));
		table.setModel(new DefaultTableModel(null, new String[] { "No.", "\uC0C1\uD488 \uC774\uB984", "\uC218\uB7C9",
				"\uD310\uB9E4 \uB2E8\uAC00", "\uD310\uB9E4 \uAE08\uC561" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setFont(new Font("³ª´®°íµñ", Font.PLAIN, 20));

		tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 92, 1006, 304);
		contentPane.add(scrollPane);

		JButton btnNewButton = new JButton("\uCDE8  \uC18C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (scrollPane_1.isVisible()) {
					scrollPane_1.disable();
					scrollPane_1.setVisible(false);
				}
				if (scrollPane_2.isVisible()) {
					scrollPane_2.disable();
					scrollPane_2.setVisible(false);
					panel_2.setVisible(false);
					panel_2.disable();
				}
				if (scrollPane_3.isVisible()) {
					scrollPane_3.disable();
					scrollPane_3.setVisible(false);
				}
				if (status.equals("stock_manage")) {
					product = null;
				}
				status = "";
				textField.setText("");
			}
		});
		btnNewButton.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setBounds(36, 418, 130, 50);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCD08\uAE30\uD654");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedProduct = new ArrayList<Product>();
				((DefaultTableModel) table.getModel()).setRowCount(0);
				product = null;
				textField_1.setText("0");
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_1.setBounds(217, 418, 130, 50);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uC601\uC218\uC99D\uCD9C\uB825");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!status.equals("history"))return;
				if (table_3.getSelectedRowCount() == 1) {
					POSreceiptd receiptd = new POSreceiptd(history.get(table_3.getSelectedRow()));
					receiptd.setVisible(true);
				}
				
			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_2.setBounds(402, 418, 130, 50);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\uAD6C\uB9E4\uB0B4\uC5ED");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (status != ""||selectedProduct.size()!=0) {
					return;
				}
				status="history";
				scrollPane_3.setVisible(true);
				history = pos.getHistory();
				int row = 1;
				((DefaultTableModel) table_3.getModel()).setRowCount(0);
				for (Transaction t : history) {
					Object[] a = t.toArray();
					a[0] = Integer.toString(row);
					((DefaultTableModel) table_3.getModel()).addRow(a);
					row += 1;
				}
			}
		});
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_3.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_3.setBounds(575, 418, 130, 50);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\uC2DC\uC7AC \uC810\uAC80");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POScashd cashd = new POScashd(posgui);
				cashd.setVisible(true);
			}
		});
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_4.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_4.setBounds(575, 502, 130, 50);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("»óÇ° ¼±ÅÃ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!status.equals(""))
					return;
				status = "sel_product";
				if (product == null) {
					product = new ArrayList<Product>();
					for (Product ppp : pos.GetProduct()) {
						product.add(ppp.clone());
					}
				}
				((DefaultTableModel) table_1.getModel()).setRowCount(0);

				int row = 1;
				for (Product p : product) {
					Object[] a = p.ToArray();
					a[0] = Integer.toString(row);
					((DefaultTableModel) table_1.getModel()).addRow(a);
					row += 1;
				}
				scrollPane_1.enable(true);
				scrollPane_1.setVisible(true);
			}
		});
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_5.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_5.setBounds(36, 502, 130, 50);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Àç°í °ü¸®");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!status.equals(""))
					return;
				if (!selectedProduct.isEmpty()) {
					label.setText("±¸¸ÅÁß¿¡ Àç°í¸¦ ¼öÁ¤ÇÒ ¼ö ¾ø½À´Ï´Ù!");
					Thread thread = new Thread() {
						Timer timer = new Timer();
						TimerTask task = new TimerTask() {
							public void run() {
								desktopPane.setVisible(false);
							}
						};

						public void run() {
							timer.schedule(task, 1000);
						}
					};
					if (desktopPane.isVisible() == true) {
						return;
					}
					desktopPane.setVisible(true);
					thread.start();
					return;
				}
				status = "stock_manage";
				if (stock == null) {
					stock = pos.GetProduct();
				}
				((DefaultTableModel) table_2.getModel()).setRowCount(0);
				scrollPane_2.enable(true);
				scrollPane_2.setVisible(true);
				panel_2.enable(true);
				panel_2.setVisible(true);
				int row = 1;
				for (Product p : stock) {
					Object[] a = p.ToArray();
					a[0] = Integer.toString(row);
					((DefaultTableModel) table_2.getModel()).addRow(a);
					row += 1;
				}

			}
		});
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_6.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_6.setBounds(217, 502, 130, 50);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_9 = new JButton("\uD3D0\uAE30\uB4F1\uB85D");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!status.equals("stock_manage")) {
					return;
				}
				if(table_2.getSelectedRowCount()!=1) return;
				Food p;
				try {
					p = (Food)stock.get(table_2.getSelectedRow());
				}catch(Exception ee) {
					err("½ÄÇ°ÀÌ ¾Æ´Õ´Ï´Ù!");
					return;
				}
				err("Æó±âµÇ¾ú½À´Ï´Ù!");
				stock.remove(p);
				reload();
			}
		});
		btnNewButton_9.setForeground(Color.BLACK);
		btnNewButton_9.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_9.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_9.setBounds(402, 502, 130, 50);
		contentPane.add(btnNewButton_9);

		JButton btnNewButton_4_1 = new JButton("\uD658\uBD88");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!status.equals("history")) return;
				if (table_3.getSelectedRowCount() != 1) {
					return;
				}
				Transaction tt = history.get(table_3.getSelectedRow());
				if (tt.getIsRefunded()) {
					err("ÀÌ¹Ì È¯ºÒµÈ °Å·¡ÀÔ´Ï´Ù!");
					return;
				}
				tt.setIsRefunded(true);
				if (tt.isCash()) {
					pos.DecreaseCash(tt.getTotalPrice());
				}
				history = pos.getHistory();
				int row = 1;
				int c = 0;
				for(Product p : tt.getProduct()) {
					c=0;
					for(Product pp : stock) {
						if(pp instanceof Food) {
							if((p).equals((Food)pp)) {
								pp.setQuantity(pp.getQuantity()+p.getQuantity());
								c=1;
								break;
							}
						}
						if(pp instanceof NonFood) {
							if((p).equals((NonFood)pp)) {
								pp.setQuantity(pp.getQuantity()+p.getQuantity());
								c=1;
								break;
							}
						}
					}
					if(c==0) {
						stock.add(p);
					}
				}
				product=null;
				err("È¯ºÒµÇ¾ú½À´Ï´Ù!");
				((DefaultTableModel) table_3.getModel()).setRowCount(0);
				pos.write();
				for (Transaction t : history) {
					Object[] a = t.toArray();
					a[0] = Integer.toString(row);
					((DefaultTableModel) table_3.getModel()).addRow(a);
					row += 1;
				}
			}
		});

		btnNewButton_4_1.setForeground(Color.BLACK);
		btnNewButton_4_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_4_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_4_1.setBounds(751, 418, 130, 50);
		contentPane.add(btnNewButton_4_1);

		JButton btnNewButton_7 = new JButton("\uD604\uAE08\uACB0\uC81C");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals("0"))
					return;

				List<Product> selp = pos.SellProduct(selectedProduct, stock);

				pos.write();
				selectedProduct = new ArrayList<Product>();
				((DefaultTableModel) table.getModel()).setRowCount(0);
				product = null;
				if (scrollPane_1.isVisible()) {
					scrollPane_1.disable();
					scrollPane_1.setVisible(false);
				}
				if (scrollPane_2.isVisible()) {
					scrollPane_2.disable();
					scrollPane_2.setVisible(false);
					panel_2.setVisible(false);
					panel_2.disable();
				}
				status = "";
				pos.IncreaseCash(Integer.parseInt(textField_1.getText()));
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
				Transaction transaction = new Transaction(formatter.format(System.currentTimeMillis()), selp,
						Integer.parseInt(textField_1.getText()), true, false);
				pos.addTransaction(transaction);

				textField_1.setText("0");
				textField.setText("");
				err("°áÁ¦µÇ¾ú½À´Ï´Ù.");
			}
		});
		btnNewButton_7.setForeground(Color.BLACK);
		btnNewButton_7.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_7.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_7.setBounds(1011, 454, 130, 50);
		contentPane.add(btnNewButton_7);

		JButton btnNewButton_7_1 = new JButton("\uCE74\uB4DC\uACB0\uC81C");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals("0"))
					return;

				List<Product> selp = pos.SellProduct(selectedProduct, stock);

				pos.write();
				selectedProduct = new ArrayList<Product>();
				((DefaultTableModel) table.getModel()).setRowCount(0);
				product = null;
				if (scrollPane_1.isVisible()) {
					scrollPane_1.disable();
					scrollPane_1.setVisible(false);
				}
				if (scrollPane_2.isVisible()) {
					scrollPane_2.disable();
					scrollPane_2.setVisible(false);
					panel_2.setVisible(false);
					panel_2.disable();
				}
				status = "";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
				Transaction transaction = new Transaction(formatter.format(System.currentTimeMillis()), selp,
						Integer.parseInt(textField_1.getText()), false, false);
				pos.addTransaction(transaction);
				textField_1.setText("0");
				textField.setText("");
				err("°áÁ¦µÇ¾ú½À´Ï´Ù.");
			}

		});
		btnNewButton_7_1.setForeground(Color.BLACK);
		btnNewButton_7_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		btnNewButton_7_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_7_1.setBounds(1153, 454, 130, 50);
		contentPane.add(btnNewButton_7_1);

		textField = new JTextField();
		textField.setBorder(new LineBorder(SystemColor.desktop));
		textField.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
		textField.setForeground(SystemColor.desktop);
		textField.setSelectionColor(SystemColor.text);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(1018, 113, 256, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_8 = new JButton("1");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "1");
			}
		});
		btnNewButton_8.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8.setBounds(1018, 152, 80, 60);
		contentPane.add(btnNewButton_8);

		JButton btnNewButton_8_1 = new JButton("3");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		btnNewButton_8_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_1.setBounds(1194, 152, 80, 60);
		contentPane.add(btnNewButton_8_1);

		JButton btnNewButton_8_2 = new JButton("2");
		btnNewButton_8_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "2");
			}
		});
		btnNewButton_8_2.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_2.setBounds(1106, 152, 80, 60);
		contentPane.add(btnNewButton_8_2);

		JButton btnNewButton_8_3 = new JButton("4");
		btnNewButton_8_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		btnNewButton_8_3.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_3.setBounds(1018, 222, 80, 60);
		contentPane.add(btnNewButton_8_3);

		JButton btnNewButton_8_4 = new JButton("6");
		btnNewButton_8_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		btnNewButton_8_4.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_4.setBounds(1194, 222, 80, 60);
		contentPane.add(btnNewButton_8_4);

		JButton btnNewButton_8_5 = new JButton("5");
		btnNewButton_8_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		btnNewButton_8_5.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_5.setBounds(1106, 222, 80, 60);
		contentPane.add(btnNewButton_8_5);

		JButton btnNewButton_8_4_1 = new JButton("7");
		btnNewButton_8_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		btnNewButton_8_4_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_4_1.setBounds(1018, 292, 80, 60);
		contentPane.add(btnNewButton_8_4_1);

		JButton btnNewButton_8_4_2 = new JButton("8");
		btnNewButton_8_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		btnNewButton_8_4_2.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_4_2.setBounds(1106, 292, 80, 60);
		contentPane.add(btnNewButton_8_4_2);

		JButton btnNewButton_8_4_3 = new JButton("9");
		btnNewButton_8_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		btnNewButton_8_4_3.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_4_3.setBounds(1194, 292, 80, 60);
		contentPane.add(btnNewButton_8_4_3);

		JButton btnNewButton_8_4_4 = new JButton("0");
		btnNewButton_8_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
		btnNewButton_8_4_4.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_4_4.setBounds(1018, 362, 80, 60);
		contentPane.add(btnNewButton_8_4_4);

		JButton btnNewButton_8_4_5 = new JButton("È®ÀÎ");
		btnNewButton_8_4_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (status.equals("sel_product")) {
					if (textField.getText() == null || textField.getText().equals("")
							|| table_1.getSelectedRowCount() != 1) {
						return;
					}
					int q = Integer.parseInt(textField.getText());
					textField.setText("");

					Product p = product.get(table_1.getSelectedRow());
					if (p.getQuantity() < q) {
						label.setText("¼ö·®À» ÃÊ°úÇÏ¿´½À´Ï´Ù!");
						Thread thread = new Thread() {
							Timer timer = new Timer();
							TimerTask task = new TimerTask() {
								public void run() {
									desktopPane.setVisible(false);
								}
							};

							public void run() {
								timer.schedule(task, 1000);
							}
						};
						if (desktopPane.isVisible() == true) {
							return;
						}
						desktopPane.setVisible(true);
						thread.start();
						return;
					}
					if (p instanceof Food) {
						if (!((Food) p).CheckLife()) {
							label.setText("À¯Åë±âÇÑÀÌ Áö³­ »óÇ°ÀÔ´Ï´Ù!");
							Thread thread = new Thread() {
								Timer timer = new Timer();
								TimerTask task = new TimerTask() {
									public void run() {
										desktopPane.setVisible(false);
									}
								};

								public void run() {
									timer.schedule(task, 1000);
								}
							};
							if (desktopPane.isVisible() == true) {
								return;
							}
							desktopPane.setVisible(true);
							thread.start();
							return;
						}
					} else if (((NonFood) p).getAdult() == 1) {
						err("¸¸ 19¼¼ ÀÌ»ó¸¸ ±¸¸Å °¡´ÉÇÑ Á¦Ç°ÀÔ´Ï´Ù!");
					}
					
					pos.SeletProduct(p, selectedProduct, q);

					((DefaultTableModel) table.getModel()).setRowCount(0);
					int row = 1;
					int sum = 0;
					for (Product pp : selectedProduct) {
						Object[] a = pp.ToArray();
						Object temp = a[2];
						a[2] = a[3];
						a[3] = temp;
						a[0] = Integer.toString(row);
						a[4] = Integer.toString(Integer.parseInt((String) a[3]) * Integer.parseInt((String) a[2]));
						((DefaultTableModel) table.getModel()).addRow(a);
						row += 1;
						sum += Integer.parseInt((String) a[4]);
					}

					textField_1.setText(Integer.toString(sum));
					p.setQuantity(p.getQuantity() - q);
					scrollPane_1.setVisible(false);
					scrollPane_1.disable();
					status = "";
				}
			}
		});
		btnNewButton_8_4_5.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_4_5.setBounds(1106, 362, 80, 60);
		contentPane.add(btnNewButton_8_4_5);

		JButton btnNewButton_8_4_6 = new JButton("\u2190");
		btnNewButton_8_4_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("") && textField.getText() != null)
					textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
			}
		});
		btnNewButton_8_4_6.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		btnNewButton_8_4_6.setBounds(1194, 362, 80, 60);
		contentPane.add(btnNewButton_8_4_6);

		JLabel lblNewLabel_3 = new JLabel("\uD569  \uACC4");
		lblNewLabel_3.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(922, 547, 50, 30);
		contentPane.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("0");
		textField_1.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 20));
		textField_1.setEditable(false);
		textField_1.setBounds(1011, 551, 272, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

	public void err(String st) {
		label.setText(st);
		Thread thread = new Thread() {
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				public void run() {
					desktopPane.setVisible(false);
				}
			};

			public void run() {
				timer.schedule(task, 1000);
			}
		};
		if (desktopPane.isVisible() == true) {
			return;
		}
		desktopPane.setVisible(true);
		thread.start();
	}

	public void addp(Product p) {
		for (Product pp : stock) {
			if (pp instanceof Food) {
				if (p.equals((Food) pp)) {
					pp.setQuantity(p.getQuantity() + pp.getQuantity());
					pos.write();
					return;
				}
			} else if (pp instanceof NonFood) {
				if (p.equals((NonFood) pp)) {
					pp.setQuantity(p.getQuantity() + pp.getQuantity());
					pos.write();
					return;
				}
			}
		}
		stock.add(p);
		pos.write();
	}

	public void reload() {
		if (stock == null) {
			stock = pos.GetProduct();
		}
		List<Product> r = new ArrayList<Product>();
		for (Product pp : stock) {
			if (pp.getQuantity() == 0) {
				r.add(pp);
			}
		}
		for (Product pp : r) {
			stock.remove(pp);
		}
		((DefaultTableModel) table_2.getModel()).setRowCount(0);

		int row = 1;
		for (Product p : stock) {
			Object[] a = p.ToArray();
			a[0] = Integer.toString(row);
			((DefaultTableModel) table_2.getModel()).addRow(a);
			row += 1;
		}
	}

	public void save() {
		pos.write();
	}

	public int getCash() {
		return pos.getCash();
	}
}
