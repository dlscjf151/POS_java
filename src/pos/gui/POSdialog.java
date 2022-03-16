package pos.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pos.entity.Food;
import pos.entity.NonFood;
import pos.entity.Product;

public class POSdialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * 
	 * @wbp.parser.constructor
	 */

	public POSdialog(POSGui posgui) {
		setResizable(false);
		setLocationRelativeTo(posgui);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\uC0C1\uD488 \uC774\uB984");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 23, 67, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("¼ö·®");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 68, 67, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("°¡°Ý");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 113, 67, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("\uC720\uD1B5\uAE30\uD55C");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 153, 67, 30);
			contentPanel.add(lblNewLabel);
		}

		textField = new JTextField();
		textField.setBounds(92, 23, 300, 30);
		contentPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 68, 300, 30);
		contentPanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 113, 300, 30);
		contentPanel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(92, 158, 300, 30);
		contentPanel.add(textField_3);

		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText().equals("")) {
						throw new Exception();
					}
					Integer.parseInt(textField_1.getText());
					Integer.parseInt(textField_1.getText());
					if (!textField_3.getText().equals("O") && !textField_3.getText().equals("X")) {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");

						format.parse(textField_3.getText());
					}
				} catch (Exception exception) {
					exception.printStackTrace();
					posgui.err("Àß¸ø ÀÔ·ÂÇÏ¿´½À´Ï´Ù.");
					dispose();
					return;
				}
				Product p;
				if (textField_3.getText().equals("O") || textField_3.getText().equals("X"))
					if (textField_3.getText().equals("O"))
						p = new NonFood(textField.getText(), Integer.parseInt(textField_1.getText()),
								Integer.parseInt(textField_2.getText()), 1);
					else
						p = new NonFood(textField.getText(), Integer.parseInt(textField_1.getText()),
								Integer.parseInt(textField_2.getText()), 0);
				else
					p = new Food(textField.getText(), Integer.parseInt(textField_1.getText()),
							Integer.parseInt(textField_2.getText()), textField_3.getText());

				posgui.addp(p);
				posgui.reload();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
		btnNewButton.setBounds(75, 213, 130, 40);
		contentPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
		btnNewButton_1.setBounds(235, 213, 130, 40);
		contentPanel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("or \uC131\uC778");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 172, 67, 30);
		contentPanel.add(lblNewLabel);
	}

	public POSdialog(POSGui posgui, Product p) {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\uC0C1\uD488 \uC774\uB984");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 23, 67, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("¼ö·®");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 68, 67, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("°¡°Ý");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 113, 67, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("\uC720\uD1B5\uAE30\uD55C");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
			lblNewLabel.setBounds(12, 153, 67, 30);
			contentPanel.add(lblNewLabel);
		}

		textField = new JTextField();
		textField.setBounds(92, 23, 300, 30);
		contentPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 68, 300, 30);
		contentPanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 113, 300, 30);
		contentPanel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(92, 158, 300, 30);
		contentPanel.add(textField_3);

		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText().equals("")) {
						throw new Exception();
					}

					p.setName(textField.getText());
					p.setQuantity(Integer.parseInt(textField_1.getText()));
					p.setPrice(Integer.parseInt(textField_2.getText()));

					if (textField_3.getText().equals("O") || textField_3.getText().equals("X")) {
						((NonFood) p).setAdult(textField_3.getText().equals("O") ? 1 : 0);
					} else {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
						format.parse(textField_3.getText());
						((Food)p).setLife(textField_3.getText());
					}
					
					posgui.reload();
					posgui.save();
					dispose();
				} catch (Exception exception) {
					posgui.err("Àß¸ø ÀÔ·ÂÇÏ¿´½À´Ï´Ù.");
					dispose();
					return;
				}
			}
		});
		btnNewButton.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
		btnNewButton.setBounds(75, 213, 130, 40);
		contentPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
		btnNewButton_1.setBounds(235, 213, 130, 40);
		contentPanel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("or \uC131\uC778");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 172, 67, 30);
		contentPanel.add(lblNewLabel);
		textField.setText(p.getName());
		textField_1.setText(Integer.toString(p.getQuantity()));
		textField_2.setText(Integer.toString(p.getPrice()));
		if (p instanceof Food)
			textField_3.setText(((Food) p).getLife());
		else if (p instanceof NonFood)
			textField_3.setText(((NonFood) p).getAdult() == 1 ? "O" : "X");
	}
}
