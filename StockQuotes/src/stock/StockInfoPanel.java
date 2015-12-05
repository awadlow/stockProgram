// 		EGR327 Project
// 		StockInfoPanel.java
//		Created 11/3/15	ARW
//		This class is used to manipulate the quotes for Stock Quotes
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		11/5/15			ARW				Created new JLabel for volume. Changed Jlabel vert. aligns
//		11/15/15		ARW				Finished assigning labels to values for volume and percent change
//		12/4/15			ARW				Added some error checking and changed label colors
//		12/5/15			ARW				Fixed bug causing the labels to be the wrong color
package stock;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

import java.awt.SystemColor;

public class StockInfoPanel extends JPanel {
	private JTextField symbolTextField;

	/**
	 * Create the panel.
	 */
	public StockInfoPanel() {
		setForeground(Color.BLACK);
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblStockTerms = new JLabel("Stock Info");
		lblStockTerms.setBounds(259, 0, 175, 42);
		lblStockTerms.setFont(new Font("Rockwell", Font.BOLD, 35));
		lblStockTerms.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblStockTerms);
		
		JLabel lblPleaseEnterA = new JLabel("Please enter a stock symbol:");
		lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseEnterA.setBounds(29, 89, 231, 20);
		add(lblPleaseEnterA);
		
		symbolTextField = new JTextField();
		symbolTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbolTextField.setBounds(262, 82, 172, 36);
		add(symbolTextField);
		symbolTextField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 139, 601, 2);
		add(separator);
		
		JLabel lblEps = new JLabel("EPS:");
		lblEps.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEps.setBounds(84, 157, 69, 20);
		add(lblEps);
		
		JLabel lblBid = new JLabel("Bid:");
		lblBid.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBid.setBounds(88, 211, 40, 20);
		add(lblBid);
		
		JLabel lblNewLabel = new JLabel("Ask:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(84, 265, 69, 20);
		add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 193, 601, 2);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 247, 601, 2);
		add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 301, 601, 2);
		add(separator_3);
		
		JLabel lblEPSValue = new JLabel("N/A");
		lblEPSValue.setVerticalAlignment(SwingConstants.TOP);
		lblEPSValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEPSValue.setBounds(168, 153, 110, 38);
		add(lblEPSValue);
		
		JLabel lblBidValue = new JLabel("N/A");
		lblBidValue.setVerticalAlignment(SwingConstants.TOP);
		lblBidValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBidValue.setBounds(168, 207, 110, 38);
		add(lblBidValue);
		
		JLabel lblAskValue = new JLabel("N/A");
		lblAskValue.setVerticalAlignment(SwingConstants.TOP);
		lblAskValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAskValue.setBounds(168, 261, 110, 38);
		add(lblAskValue);
		
		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVolume.setBounds(404, 157, 100, 20);
		add(lblVolume);
		
		JLabel lblVolumeValue = new JLabel("N/A");
		lblVolumeValue.setVerticalAlignment(SwingConstants.TOP);
		lblVolumeValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVolumeValue.setBounds(519, 153, 112, 42);
		add(lblVolumeValue);
		
		JLabel lblChange = new JLabel("Change:");
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChange.setBounds(404, 202, 100, 38);
		add(lblChange);
		
		JLabel lblChangeValue = new JLabel("N/A");
		lblChangeValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChangeValue.setBounds(519, 202, 111, 38);
		add(lblChangeValue);

		JLabel lblDivshare = new JLabel("Div/Share:");
		lblDivshare.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDivshare.setBounds(382, 256, 128, 38);
		add(lblDivshare);
		
		JLabel lblDivshareValue = new JLabel("N/A");
		lblDivshareValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDivshareValue.setBounds(520, 256, 111, 38);
		add(lblDivshareValue);
		
		JLabel lblSymbolNotFound = new JLabel("");
		lblSymbolNotFound.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSymbolNotFound.setForeground(Color.RED);
		lblSymbolNotFound.setBounds(269, 56, 165, 20);
		add(lblSymbolNotFound);


		
		JButton btnGetInfo = new JButton("Get Info!");
		btnGetInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGetInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Stock stock = new Stock();
				if (stock.parseQuote(symbolTextField.getText()) == true)
					{
					symbolTextField.setBackground(Color.WHITE);
					lblSymbolNotFound.setText("");
					lblEPSValue.setText(stock.getEps().toString());
					lblAskValue.setText(stock.getAsk().toString());
					lblBidValue.setText(stock.getBid().toString());
					lblVolumeValue.setText(stock.getVolumeCharacters());
					lblDivshareValue.setText(stock.getDivShare());
					lblChangeValue.setText(stock.getPercentChange());
					
					if(stock.checkPercentChange())
					{
						lblChangeValue.setForeground(Color.GREEN);
					}
					
					else
					{
						lblChangeValue.setForeground(Color.RED);
					}
				}
				
				else
				{
					
					symbolTextField.setBackground(Color.RED);
					lblSymbolNotFound.setText("Symbol not found");
					lblSymbolNotFound.setForeground(Color.RED);
					lblChangeValue.setForeground(Color.BLACK);
					lblEPSValue.setText("N/A");
					lblAskValue.setText("N/A");
					lblBidValue.setText("N/A");
					lblVolumeValue.setText("N/A");
					lblDivshareValue.setText("N/A");
					lblChangeValue.setText("N/A");
				}
				
			}
			
		});
		btnGetInfo.setBounds(464, 82, 139, 37);
		add(btnGetInfo);
		
		JButton btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.changeCards("StockHome");
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBounds(478, 378, 163, 42);
		add(btnHome);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.exitProgram();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(29, 378, 163, 42);
		add(btnExit);


	}
}
