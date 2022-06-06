package application;
 




import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.Button;
 
import javafx.scene.control.TextField;

import javafx.collections.ObservableList;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;





public class Accueilcontroller {
	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	 public void switchToPlats(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("Plats.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 
	 public void switchToAccueil(ActionEvent event) throws IOException {
	  root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	 public void switchToAjout(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("Ajout.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
	 

	 @FXML
	 
	 ImageView myImageView;
	
	 
	 Image myImage = new Image(getClass().getResourceAsStream("bbb.jpg"));
	 
	 public void displayImage() {
	  myImageView.setImage(myImage);
	 }
	 
	 
    @FXML
	 
	 
	 ImageView foood;
	 
	
	 Image foodd = new Image("file:food.jng");
	 
	 public void displayImagef() {
		  foood.setImage(foodd);
	 }
@FXML

	 
	 
	 ImageView caisse;
	 
	
	 Image caissee = new Image("file:caisse.jng");
	 
	 public void displayImagec() {
		  caisse.setImage(caissee);
	 }
@FXML
	 
	 
	 ImageView comm;
	 
	
	 Image commm = new Image("file:comm.jng");
	 
	 public void displayImagem() {
		  comm.setImage(commm);
	 }
@FXML
	 
	 
	 ImageView back;
	 
	
	 Image backg = new Image("file:PP.jng");
	 
	 public void displayImageb() {
		  back.setImage(backg);
	 }
@FXML
	 
	 
	 ImageView ajout;
	 
	
	 Image ajoutf = new Image("file:ajoutf.jng");
	 
	 public void displayImagea() {
		  ajout.setImage(ajoutf);
	 }
	 



	 
	 
	 
	 
	 	@FXML
	 	private TextField P1;
	 	@FXML
	 	private TextField P2;
	 	@FXML
	 	private TextField P3;
	 	@FXML
	 	private TextField P4;
	 	@FXML
	 	private TextField P5;
	 	@FXML
		private Button Btn;
	 	
	 	
	 	 String categorie;
	     String code_alpha;
		 String nom_plat;
		 int prix ;
		 int quantitycommandé;
	 	
	 	public void submit(ActionEvent event) {
	 		
	 		
	 		quantitycommandé = Integer.parseInt(P5.getText());
	 		prix = Integer.parseInt(P4.getText());
	 		categorie=P3.getText();
	 		code_alpha=P2.getText();
	 		nom_plat=P1.getText();
	 }
	 	
		/*
	 	  //Table
	    @FXML
	    private TableView<Plat> tableView;

	    //Columns
	    @FXML
	    private TableColumn<Plat, String> nameColumn;
	    @FXML
	    private TableColumn<Plat, String> codeColumn; 
	    @FXML
	    private TableColumn<Plat, String> categorieColumn;
	    @FXML
	    private TableColumn<Plat, Integer> platcommandColumn;

	    @FXML
	    private TableColumn<Plat, Double> prixColumn;
	    
	    public ObservableList<Plat> data=FXCollections.observableArrayList();
	    ObservableList<Plat> dataList;
	    int index = -1;
	    
	    Connection conn =null;
	    ResultSet rs = null;
	    PreparedStatement pst = null;
	    
	    @FXML
	    public void Add_plat (){    
	        conn = mysqlconnect.ConnectDb();
	        String sql = "insert into plats (nom,code,categorie,prix,commande)values(?,?,?,? )";
	        
	        try {
	            pst = conn.prepareStatement(sql);
	            pst.setString(1, P1.getText());
	            pst.setString(2, P2.getText());
	            pst.setString(3, P3.getText());
	            pst.setInt(4, Integer.parseInt(P4.getText()));
	            pst.setInt(4, Integer.parseInt(P5.getText()));
	            pst.execute();
	            
	            P5.setText("");
		 	    P4.setText("");
		 		P3.setText("");
		 		P2.setText("");
		 		P1.setText("");
	            
	            Alert alert =new Alert(AlertType.CONFIRMATION,"plat ajouté avec succes",pst.setText(""),javafx.scene.control.ButtonType.OK);
	            alert.showAndWait();
	            showplat();
	            
	   
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	        
	    }

		public void showplat() {
			String sql ="select * from plats"
					st=cnx.prepareStatement(sql);
			resul=st.executeQuery();
			while(resul.next()) {
				data.add(new Plat(resul.get(), sql, prix, quantitycommandé, sql));
			}
			
			 nameColumn.setCellValueFactory(new PropertyValueFactory<Plat, String>("nom_plat"));
		        codeColumn.setCellValueFactory(new PropertyValueFactory<Plat, String>("code_alpha"));
		        categorieColumn.setCellValueFactory(new PropertyValueFactory<Plat, String>("categorie"));
		        prixColumn.setCellValueFactory(new PropertyValueFactory<Plat, Double>("prix"));
		        platcommandColumn.setCellValueFactory(new PropertyValueFactory<Plat, Integer>("quantitycommandé"));
		        
		    }
	    


	    @Override
	    public void initialize(URL url, ResourceBundle resourceBundle) {
	        cnx=ConnexionMysql.connexionDB();
	        showplat();
	        */

	    
/*
	    //Submit button
	    @FXML
	    void submitt(ActionEvent event) {
	       Plat  plat = new Plat(P1.getText(),
	    		   P2.getText(),
	    		   Integer.parseInt(P4.getText()),
	                Integer.parseInt(P5.getText()), P3.getText());
	        ObservableList<Plat> plats = tableView.getItems();
	        plats.add(plat);
	        tableView.setItems(plats);
	    }

	    @FXML
	    void removeCustomer(ActionEvent event) {
	        int selectedID = tableView.getSelectionModel().getSelectedIndex();
	        tableView.getItems().remove(selectedID);
	    }
	    */
	}
	 	
	 	
	 	
	 	
	 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	 	
	 	
	 	
	




 
 
 

