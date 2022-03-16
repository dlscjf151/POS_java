package pos.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import pos.Transaction;
import pos.entity.Product;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class POSreceiptd extends JDialog {

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public POSreceiptd(Transaction transaction) {
		setMinimumSize(new Dimension(500, 500));
		setResizable(false);
		getContentPane().setSize(new Dimension(300, 200));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(32767, 50));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("\uC601\uC218\uC99D");
		lblNewLabel_1.setPreferredSize(new Dimension(400, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(400, 30));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);

		if(transaction.getIsRefunded()) {
			lblNewLabel_1.setText("È¯ºÒ ¿µ¼öÁõ");
		}
		JPanel panel = new JPanel();
		panel.setFocusable(false);
		panel.setFocusTraversalKeysEnabled(false);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		panel.setMaximumSize(new Dimension(32767, 33*(transaction.getProduct().size()+2)));
		panel.setMinimumSize(new Dimension(0, 33*(transaction.getProduct().size()+2)));

		JLabel lblNewLabel_2_1 = new JLabel("\uC774\uB984");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_4 = new JLabel("\uC218\uB7C9");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_3 = new JLabel("\uAC00\uACA9");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel.add(lblNewLabel_2_3);
		JLabel j;
		int sum=0;
		for (Product p : transaction.getProduct()) {
			j = new JLabel(p.getName());
			j.setHorizontalAlignment(SwingConstants.CENTER);
			j.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
			panel.add(j);
			j = new JLabel(Integer.toString(p.getQuantity()));
			j.setHorizontalAlignment(SwingConstants.CENTER);
			j.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
			panel.add(j);
			j = new JLabel(Integer.toString(p.getPrice()));
			j.setHorizontalAlignment(SwingConstants.CENTER);
			j.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
			panel.add(j);
			sum+=p.getQuantity()*p.getPrice();
		}

		JLabel lblNewLabel_2_2 = new JLabel("ÇÕ°è");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_5 = new JLabel(Integer.toString(sum));
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel.add(lblNewLabel_2_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setMaximumSize(new Dimension(32767, 33));
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setMaximumSize(new Dimension(32767, 33));
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setText(transaction.isCash()?"Çö±Ý °áÁ¦":"Ä«µå °áÁ¦");
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("");
		lblNewLabel_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_3.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2_1_3);
		lblNewLabel_2_1_3.setText(transaction.getTime());
	}

}
