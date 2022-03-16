package pos.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POScashd extends JDialog {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	private int cash;

	public POScashd(POSGui posgui) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setVisible(false);
			panel_1.setVerifyInputWhenFocusTarget(false);
			panel_1.setRequestFocusEnabled(false);
			panel_1.setFocusable(false);
			panel_1.setBounds(0, 0, 436, 263);
			getContentPane().add(panel_1);
			panel_1.setLayout(null);
			{
				table = new JTable();
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
				table.setRowHeight(40);
				table.setFont(new Font("³ª´®°íµñ ExtraBold", Font.PLAIN, 23));
				table.setModel(new DefaultTableModel(new Object[][] { { "\uCD1D\uC561", "" },
						{ "\uC785\uB825\uD55C \uAE08\uC561", null }, { "\uCC28\uC561", null }, },
						new String[] { "New column", "New column" }) {
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(100);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
				table.setBounds(47, 58, 350, 120);
				panel_1.add(table);

				DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
				tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tcmSchedule = table.getColumnModel();
				for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
					tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
				}
			}
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 436, 263);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("\uD604\uC7AC \uC2DC\uC7AC");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
				lblNewLabel.setBounds(78, 98, 84, 42);
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setBounds(174, 102, 200, 30);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JButton btnNewButton = new JButton("\uD655\uC778");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							cash = Integer.parseInt(textField.getText());
						} catch (Exception exception) {
							posgui.err("Àß¸ø ÀÔ·ÂÇÏ¿´½À´Ï´Ù.");
						}
						table.setValueAt(Integer.toString(posgui.getCash()), 0, 1);
						table.setValueAt(cash, 1, 1);
						table.setValueAt(cash-posgui.getCash()>=0?"+"+Integer.toString(cash-posgui.getCash()):Integer.toString(cash-posgui.getCash()), 2, 1);
						
						panel_1.setVisible(true);
						panel.setVisible(false);
					}
				});
				btnNewButton.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
				btnNewButton.setBounds(156, 189, 135, 50);
				panel.add(btnNewButton);
			}
		}
	}

}
