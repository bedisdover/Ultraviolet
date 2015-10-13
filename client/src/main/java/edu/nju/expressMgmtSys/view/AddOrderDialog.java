package edu.nju.expressMgmtSys.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.expressMgmtSys.client.RMIHelper;
import edu.nju.expressMgmtSys.model.Commodity;
import edu.nju.expressMgmtSys.model.Customer;
import edu.nju.expressMgmtSys.model.ExpressOrder;
import edu.nju.expressMgmtSys.model.ExpressType;
import edu.nju.expressMgmtSys.service.OrderService;

/**
 * Created by hazel on 2015-10-07.
 */
public class AddOrderDialog extends JDialog{
	private ShowOrderPanel parent;

    public AddOrderDialog(ShowOrderPanel parent) {
    	this.parent = parent;
    	
        this.setContentPane(new AddOrderPanel());
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
 
    CustomerPanel senderPanel = new CustomerPanel();
    CustomerPanel receiverPanel = new CustomerPanel();
    CommodityPanel commodityPanel = new CommodityPanel();
    ExpressInfoPanel expressInfoPanel = new ExpressInfoPanel();

    class AddOrderPanel extends JPanel {
        AddOrderPanel() {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            senderPanel.setBorder(BorderFactory.createTitledBorder("Sender"));
            this.add(senderPanel);
            
            receiverPanel.setBorder(BorderFactory.createTitledBorder("Receiver"));
            this.add(receiverPanel);
            
            commodityPanel.setBorder(BorderFactory.createTitledBorder("Commodity"));
            this.add(commodityPanel);
            
            expressInfoPanel.setBorder(BorderFactory.createTitledBorder("Express Info"));
            this.add(expressInfoPanel);
            
            JButton addButton = new JButton("Add");
            this.add(addButton);
            
            addButton.addActionListener(new AddExpressOrderAction());
        }
    }

    class AddExpressOrderAction implements ActionListener{

    	@Override
		public void actionPerformed(ActionEvent e) {
			String senderName = senderPanel.nameTextField.getText();
			String senderAddress = senderPanel.addressTextField.getText();
			String senderCompany = senderPanel.companyTextField.getText();
			String senderTelephone = senderPanel.teleTextField.getText();
			String senderMobile = senderPanel.mobileTextField.getText();
			Customer sender = new Customer(senderName, senderAddress, senderCompany, senderTelephone, senderMobile);

			String receiverName = receiverPanel.nameTextField.getText();
			String receiverAddress = receiverPanel.addressTextField.getText();
			String receiverCompany = receiverPanel.companyTextField.getText();
			String receiverTelephone = receiverPanel.teleTextField.getText();
			String receiverMobile = receiverPanel.mobileTextField.getText();
			Customer receiver = new Customer(receiverName, receiverAddress, receiverCompany, receiverTelephone, receiverMobile);
			
			String commodityNumberString = commodityPanel.numsTextField.getText();
			int commodityNumber = Integer.parseInt(commodityNumberString);
			String commodityWeightString = commodityPanel.weightTextFiled.getText();
			int commodityWeight = Integer.parseInt(commodityWeightString);
			String commodityVolumeString = commodityPanel.volumeTextFiled.getText();
			int commodityVolume = Integer.parseInt(commodityVolumeString);
			String commodityName = commodityPanel.nameTextFiled.getText();
			Commodity commodity = new Commodity(commodityNumber, commodityWeight, commodityVolume, commodityName);
			
			String barcode = expressInfoPanel.barcodeTextField.getText();
			ExpressType type = (ExpressType) expressInfoPanel.typeComboBox.getSelectedItem();
			String feeString = expressInfoPanel.packagingFeeTextField.getText();
			int fee = Integer.parseInt(feeString);
			
			int totalPrice = fee;//???
			
			ExpressOrder order = new ExpressOrder(barcode, sender, receiver, commodity, type, fee, totalPrice);
			
			OrderService service = RMIHelper.getOrderService();
			service.addExpressOrder(order);
			parent.refresh();
			AddOrderDialog.this.dispose();
		}
    	
    }
    
    final int LEFT_PADDING = 20;
    final int TOP_PADDING = 15;
    final int LABEL_COMPONENT_PADDING = 10;
    final int PADDING_VERTICAL = 5;
    final int PADDING_HORIZATION = 20;
    
    final int LABEL_WIDTH = 80;
    final int LABEL_HEIGHT = 20;
    
    
    final int TEXTFILED_WIDTH = 100;
    final int TEXTFILED_HEIGHT = 20;
    
    class CustomerPanel extends JPanel {
        private JLabel nameLabel = new JLabel("Name:", JLabel.RIGHT);
        private JTextField nameTextField = new JTextField();
        private JLabel addressLabel = new JLabel("Address:", JLabel.RIGHT);
        private JTextField addressTextField = new JTextField();
        private JLabel companyLabel = new JLabel("Company:", JLabel.RIGHT);
        private JTextField companyTextField = new JTextField();
        private JLabel teleLabel = new JLabel("Telephone:", JLabel.RIGHT);
        private JTextField teleTextField = new JTextField();
        private JLabel mobileLabel = new JLabel("Mobile:", JLabel.RIGHT);
        private JTextField mobileTextField = new JTextField();

        CustomerPanel() {
            this.setLayout(null);
            
            nameLabel.setBounds(LEFT_PADDING, TOP_PADDING, LABEL_WIDTH, LABEL_HEIGHT);
            nameTextField.setBounds(
            		nameLabel.getX() + nameLabel.getWidth() + LABEL_COMPONENT_PADDING, 
            		nameLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);
            addressLabel.setBounds(
            		nameTextField.getX() + nameTextField.getWidth() + PADDING_HORIZATION, 
            		nameLabel.getY(), 
            		LABEL_WIDTH, 
            		LABEL_HEIGHT
            	);
            addressTextField.setBounds(
            		addressLabel.getX() + addressLabel.getWidth() + LABEL_COMPONENT_PADDING, 
            		addressLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);
            companyLabel.setBounds(
            		nameLabel.getX(), 
            		nameLabel.getY()+nameLabel.getHeight()+PADDING_VERTICAL, 
            		LABEL_WIDTH, 
            		LABEL_HEIGHT
            	);
            companyTextField.setBounds(
            		nameTextField.getX(), 
            		companyLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);
            teleLabel.setBounds(
            		addressLabel.getX(), 
            		companyLabel.getY(), 
            		LABEL_WIDTH, 
            		LABEL_HEIGHT
            	);
            teleTextField.setBounds(
            		addressTextField.getX(), 
            		teleLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);
            mobileLabel.setBounds(
            		nameLabel.getX(), 
            		companyLabel.getY()+companyLabel.getHeight()+PADDING_VERTICAL,
            		LABEL_WIDTH, 
            		LABEL_HEIGHT
            	);
            mobileTextField.setBounds(
            		nameTextField.getX(),
            		mobileLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);

            this.add(nameLabel);
            this.add(nameTextField);
            this.add(addressLabel);
            this.add(addressTextField);
            this.add(companyLabel);
            this.add(companyTextField);
            this.add(teleLabel);
            this.add(teleTextField);
            this.add(mobileLabel);
            this.add(mobileTextField);
        }

    }
    
    class CommodityPanel extends JPanel{
    	
	  private JLabel numsLabel = new JLabel("Quantity:", JLabel.RIGHT);
      private JTextField numsTextField = new JTextField();
      private JLabel weightLabel = new JLabel("Weight:", JLabel.RIGHT);
      private JTextField weightTextFiled = new JTextField();
      private JLabel volumeLabel = new JLabel("Volume:", JLabel.RIGHT);
      private JTextField volumeTextFiled = new JTextField();
      private JLabel nameLabel = new JLabel("Object:", JLabel.RIGHT);
      private JTextField nameTextFiled = new JTextField();
    	
      	CommodityPanel() {
    		this.setLayout(null);
    				
    		numsLabel.setBounds(LEFT_PADDING, TOP_PADDING, LABEL_WIDTH, LABEL_HEIGHT);
    		numsTextField.setBounds(
    				numsLabel.getX() + numsLabel.getWidth() + LABEL_COMPONENT_PADDING, 
    				numsLabel.getY(), 
             		TEXTFILED_WIDTH, 
             		TEXTFILED_HEIGHT
             	);
    		weightLabel.setBounds(
    				numsTextField.getX() + numsTextField.getWidth() + PADDING_HORIZATION, 
    				numsLabel.getY(), 
            		LABEL_WIDTH, 
            		LABEL_HEIGHT
            	);
    		weightTextFiled.setBounds(
    				weightLabel.getX() + weightLabel.getWidth() + LABEL_COMPONENT_PADDING, 
    				weightLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);
    		volumeLabel.setBounds(
    				numsLabel.getX(), 
    				numsLabel.getY()+numsLabel.getHeight()+PADDING_VERTICAL, 
            		LABEL_WIDTH, 
            		LABEL_HEIGHT
            	);
    		volumeTextFiled.setBounds(
    				numsTextField.getX(), 
    				volumeLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);
    		nameLabel.setBounds(
    				weightLabel.getX(), 
    				volumeLabel.getY(), 
            		LABEL_WIDTH, 
            		LABEL_HEIGHT
            	);
    		nameTextFiled.setBounds(
    				weightTextFiled.getX(), 
    				nameLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);
            
    		this.add(numsLabel);
    		this.add(numsTextField);
    		this.add(weightLabel);
    		this.add(weightTextFiled);
    		this.add(volumeLabel);
    		this.add(volumeTextFiled);
    		this.add(nameLabel);
    		this.add(nameTextFiled);
		}
    }
    
    class ExpressInfoPanel extends JPanel{
    	
    	private JLabel barcodeLabel = new JLabel("Barcode:", JLabel.RIGHT);
    	private JTextField barcodeTextField = new JTextField();
    	
    	private JLabel typeLabel = new JLabel("Type:", JLabel.RIGHT);
    	private JComboBox<ExpressType> typeComboBox = new JComboBox<ExpressType>();
    	
    	private JLabel packagingFeeLabel = new JLabel("Pack Fee:", JLabel.RIGHT);
    	private JTextField packagingFeeTextField = new JTextField();
    	
    	ExpressInfoPanel(){
    		this.setLayout(null);
    		
    		barcodeLabel.setBounds(LEFT_PADDING, TOP_PADDING, LABEL_WIDTH, LABEL_HEIGHT);
    		barcodeTextField.setBounds(
    				barcodeLabel.getX() + barcodeLabel.getWidth() + LABEL_COMPONENT_PADDING, 
    				barcodeLabel.getY(), 
             		TEXTFILED_WIDTH, 
             		TEXTFILED_HEIGHT
             	);
    		
    		typeLabel.setBounds(
    				barcodeLabel.getX(), 
    				barcodeLabel.getY() + barcodeLabel.getHeight() + LABEL_COMPONENT_PADDING, 
    				LABEL_WIDTH, 
    				LABEL_HEIGHT
    			);
    		typeComboBox.addItem(ExpressType.ECONOMY);
    		typeComboBox.addItem(ExpressType.STANDARD);
    		typeComboBox.addItem(ExpressType.EXPRESS);
    		typeComboBox.setBounds(
    				typeLabel.getX() + typeLabel.getWidth() + LABEL_COMPONENT_PADDING, 
    				typeLabel.getY(), 
             		TEXTFILED_WIDTH, 
             		TEXTFILED_HEIGHT
             	);
    		
    		packagingFeeLabel.setBounds(
    				typeLabel.getX(), 
    				typeLabel.getY()+typeLabel.getHeight()+PADDING_VERTICAL, 
            		LABEL_WIDTH, 
            		LABEL_HEIGHT
            	);
    		packagingFeeTextField.setBounds(
    				typeComboBox.getX(), 
    				packagingFeeLabel.getY(), 
            		TEXTFILED_WIDTH, 
            		TEXTFILED_HEIGHT
            	);

    		this.add(barcodeLabel);
    		this.add(barcodeTextField);
    		this.add(typeLabel);
    		this.add(typeComboBox);
    		this.add(packagingFeeLabel);
    		this.add(packagingFeeTextField);
    	}
    	
    }

}
