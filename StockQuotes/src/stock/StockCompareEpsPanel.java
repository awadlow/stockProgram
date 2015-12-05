// 		EGR327 Project
// 		StockCompareEpsPanel.java
//		Created 11/15/15	ARW
//		This class is the user interface for the compareEpsPanel
// 		REVISION HISTORY
//		DATE			BY				DETAILS
//		12/5/15			ARW				Added error checking when retrieving eps from quote

package stock;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StockCompareEpsPanel extends JPanel {
	private JTextField symbolOneTextField;
	private JTextField symbolTwoTextField;

	/**
	 * Create the panel.
	 */
	public StockCompareEpsPanel() {
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblCompareEps = new JLabel("Compare EPS");
		lblCompareEps.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompareEps.setFont(new Font("Rockwell", Font.PLAIN, 35));
		lblCompareEps.setBounds(207, 16, 263, 42);
		add(lblCompareEps);
		
		symbolOneTextField = new JTextField();
		symbolOneTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbolOneTextField.setColumns(10);
		symbolOneTextField.setBounds(144, 114, 172, 36);
		add(symbolOneTextField);
		
		symbolTwoTextField = new JTextField();
		symbolTwoTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbolTwoTextField.setColumns(10);
		symbolTwoTextField.setBounds(144, 166, 172, 36);
		add(symbolTwoTextField);
		
		JLabel lblSymbolOne = new JLabel("Symbol One:");
		lblSymbolOne.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSymbolOne.setBounds(15, 122, 124, 20);
		add(lblSymbolOne);
		
		JLabel lblSymbolTwo = new JLabel("Symbol Two:");
		lblSymbolTwo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSymbolTwo.setBounds(15, 174, 124, 20);
		add(lblSymbolTwo);
		
		JLabel lblSymbolOneEps = new JLabel("Symbol One Eps:");
		lblSymbolOneEps.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSymbolOneEps.setBounds(346, 123, 150, 20);
		add(lblSymbolOneEps);
		
		JLabel lblSymbolTwoEps = new JLabel("Symbol Two Eps:");
		lblSymbolTwoEps.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSymbolTwoEps.setBounds(346, 175, 154, 20);
		add(lblSymbolTwoEps);
		
		JLabel lblEpsValueOne = new JLabel("N/A");
		lblEpsValueOne.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEpsValueOne.setBounds(515, 120, 69, 20);
		add(lblEpsValueOne);
		
		JLabel lblEpsValueTwo = new JLabel("N/A");
		lblEpsValueTwo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEpsValueTwo.setBounds(515, 172, 69, 20);
		add(lblEpsValueTwo);
		
		JLabel lblDifference = new JLabel("Difference:");
		lblDifference.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDifference.setBounds(395, 222, 108, 20);
		add(lblDifference);
		
		JLabel lbldifferenceValue = new JLabel("N/A");
		lbldifferenceValue.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbldifferenceValue.setBounds(515, 220, 101, 20);
		add(lbldifferenceValue);
		
		JLabel lblWinner = new JLabel("WINNER:");
		lblWinner.setForeground(new Color(0, 255, 0));
		lblWinner.setFont(new Font("Rockwell", Font.PLAIN, 30));
		lblWinner.setBounds(216, 301, 129, 20);
		add(lblWinner);
		
		JLabel lblWinnerValue = new JLabel("N/A");
		lblWinnerValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWinnerValue.setBounds(380, 302, 69, 20);
		add(lblWinnerValue);
		
		JLabel lblLoser = new JLabel("LOSER:");
		lblLoser.setForeground(new Color(255, 0, 0));
		lblLoser.setFont(new Font("Rockwell", Font.PLAIN, 30));
		lblLoser.setBounds(241, 336, 124, 20);
		add(lblLoser);
		
		JLabel lblLoserValue = new JLabel("N/A");
		lblLoserValue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLoserValue.setBounds(380, 337, 69, 20);
		add(lblLoserValue);
		
		JLabel labelSymbolNotFound = new JLabel("");
		labelSymbolNotFound.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSymbolNotFound.setBounds(144, 263, 201, 20);
		add(labelSymbolNotFound);

		
		JButton btnCompare = new JButton("Compare");
		btnCompare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stock stockOne = new Stock();
				if(stockOne.parseQuote(symbolOneTextField.getText()) == true)
				{
					lblEpsValueOne.setText(stockOne.getEps().toString());
					labelSymbolNotFound.setText("");
					labelSymbolNotFound.setForeground(Color.BLACK);
					symbolOneTextField.setBackground(Color.WHITE);
				}
				
				else
				{
					symbolOneTextField.setBackground(Color.RED);
					lblEpsValueOne.setText("N/A");
					labelSymbolNotFound.setText("Symbol one not found");
					labelSymbolNotFound.setForeground(Color.RED);
				}
				
				Stock stockTwo = new Stock();
				if(stockTwo.parseQuote(symbolTwoTextField.getText()) == true ){
					lblEpsValueTwo.setText(stockTwo.getEps().toString());
					symbolTwoTextField.setBackground(Color.WHITE);
				}
				
				else
				{
					symbolTwoTextField.setBackground(Color.RED);
					lblEpsValueTwo.setText("N/A");
					labelSymbolNotFound.setText("Symbol two not found");
					labelSymbolNotFound.setForeground(Color.RED);
				}
				
				
				if( stockOne.getstockSymbolValid() == true 
						&& stockTwo.getstockSymbolValid() == true )
				{
				
					lbldifferenceValue.setText(String.valueOf((stockOne.getDifference
											  (stockTwo.getEps())) + "00000").substring(0, 4));
				//Previous line sets the difference value. The 00000 are added to ensure the substring is
				//not out of scope of the array
					
					lblWinnerValue.setText(stockOne.getWinner(stockTwo));
					lblLoserValue.setText(stockOne.getLoser(stockTwo));
				}
				
				else
				{
					lbldifferenceValue.setText("N/A");
					lblWinnerValue.setText("N/A");
					lblLoserValue.setText("N/A");
				}
				
				if(stockOne.getstockSymbolValid() == false && stockTwo.getstockSymbolValid() == false)
				{
					labelSymbolNotFound.setText("Symbols not found");
				}
			}
		});
		btnCompare.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCompare.setBounds(144, 218, 172, 29);
		add(btnCompare);
		

		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.exitProgram();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(15, 376, 163, 42);
		add(btnExit);
		
		JButton btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockGUI SGUI = (StockGUI) getParent().getParent().getParent().getParent();
				SGUI.changeCards("StockHome");
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHome.setBounds(485, 376, 163, 42);
		add(btnHome);
		
	

	}
}
