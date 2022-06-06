package application;



import java.util.Scanner;

public class Plat implements Comparable<Plat> {
	private String categorie;
	private String code_alpha;
	private String nom_plat;
	private double prix ;
	private int quantitycommandé;
	
	public Plat( String nom_plat,String code_alpha, double prix ,int q,String categorie) {
		this.code_alpha = code_alpha;
		this.nom_plat = nom_plat;
		this.prix = prix;
		this.categorie=categorie;
		this.quantitycommandé=q;
		
	}
	public Plat(String code){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("donner le nom du plat ");
		this.nom_plat=sc.next();
		System.out.println("donner le prix");
		this.prix=sc.nextDouble();
		System.out.println("donner la categorie du plat");
		this.categorie=sc.next();
		this.quantitycommandé=0;
		this.code_alpha=code;
		
	}
	public String getCode_alpha() {
		return code_alpha;
	}
	public void setCode_alphanumerique(String code_alphanumerique) {
		this.code_alpha = code_alphanumerique;
	}
	public String getNom_de_plat() {
		return nom_plat;
	}
	public void setNom_de_plat(String nom_de_plat) {
		this.nom_plat = nom_de_plat;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getQuantitycommandé() {
		return quantitycommandé;
	}
	public void setQuantitycommandé(int quantitycommandé) {
		this.quantitycommandé = quantitycommandé;
	}
   
	@Override
	public String toString(){
		String s  = " code alpha_numerique est :"+this.code_alpha
				+"\n le nom de plat est : "+this.nom_plat+"categorie de plat ="+this.categorie+
				"\n le prix de plat = "+this.prix +" dinares" +"ce plat est commandé "+quantitycommandé+"fois";
		return s ;
		
		}
	
	
        
	    
	public int compareTo(Plat o) {
		 if(this.getCode_alpha().equalsIgnoreCase(o.code_alpha))
		 {
			 return this.getCode_alpha().compareTo(o.getCode_alpha());
		 }
		 
		 return this.getCode_alpha().compareTo(o.getCode_alpha());
	}

	
	
	
	
        }