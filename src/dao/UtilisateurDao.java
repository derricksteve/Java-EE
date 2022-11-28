package dao;

import java.util.ArrayList;

import beans.Utilisateur;
import jdk.nashorn.internal.ir.ForNode;

import java.sql.*;
public class UtilisateurDao {
	
	Connection con;
	Statement etat;
	PreparedStatement pre;
	
	
	public  UtilisateurDao() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee", "root", "");
			this.etat = con.createStatement();
		
			
		}catch(Exception e) {
			System.out.print("pas de connection "+e.getMessage());
			
			
		}
	}
	
	
	
	private static int lastId=1;
private static   ArrayList<Utilisateur> utilisateurs=new ArrayList<Utilisateur>();
/*
static {
	utilisateurs.add(new Utilisateur(1, "BAH", "Med", "MK", "passer" ) );
	utilisateurs.add(new Utilisateur(1, "SIDI", "Ahmed", "zz", "aller" ) );
	
}*/

public  boolean  ajouter(Utilisateur utilisateur)  {
	try {
		utilisateur.setId(lastId++);
		utilisateurs.add(utilisateur);
		
		
		this.pre = this.con.prepareStatement("INSERT INTO utilisateur (prenom, nom, login, password) VALUES (?, ?, ?, ?)");
		this.pre.setString(1, utilisateur.getPrenom());
		this.pre.setString(2, utilisateur.getNom());
		this.pre.setString(3, utilisateur.getLogin());
		this.pre.setString(4, utilisateur.getPassword() );
		 
		boolean ok = this.pre.executeUpdate() > 0 ? true : false;
		
		return ok;
	}catch(Exception e ) {
		System.out.print(e.getMessage());
		
	}
	return false;
	
}
public  ArrayList<Utilisateur> lister()  {
	
	
	ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
	
	
	Utilisateur	utilisateur = new Utilisateur();
try {
	ResultSet resultats = this.etat.executeQuery("SELECT * FROM utilisateur");
	
	while(resultats.next()) {
		
			utilisateur = new Utilisateur();
		
		if(resultats.getString("login") != null) {
			utilisateur.setLogin(resultats.getString("login"));
		}
		if(resultats.getString("password") != null) {
			utilisateur.setPassword(resultats.getString("password"));
		}
		if(resultats.getString("prenom") != null) {
			utilisateur.setPrenom(resultats.getString("prenom"));
		}
		if(resultats.getString("nom") != null) {
			utilisateur.setNom(resultats.getString("nom"));
		}
		
		if(resultats.getString("id") != null) {
			utilisateur.setId(resultats.getInt("id"));
		}
		utilisateurs.add(utilisateur);
	}
} catch (Exception e) {
	// TODO: handle exception
}
	
	
	return utilisateurs;
}

public  boolean supprimer (int id) {
	
try {
	PreparedStatement pres = this.con.prepareStatement("DELETE FROM utilisateur WHERE id = ?");
	pres.setInt(1, id);
	 
	boolean ok = pres.executeUpdate() > 0 ? true : false;
	return  ok;
	
} catch (Exception e) {
	// TODO: handle exception
}
	
	

	return false;
}

public boolean modifier(Utilisateur user) {
	try {
		this.pre = this.con.prepareStatement("UPDATE Utilisateur SET prenom=?, nom=?, login=?, password=? WHERE id=?");
		
			this.pre.setString(1, user.getPrenom());
		this.pre.setString(2, user.getNom());
		this.pre.setString(3, user.getLogin());
		this.pre.setString(4, user.getPassword());
		this.pre.setInt(5,user.getId());
		
	
boolean ok = this.pre.executeUpdate() > 0 ? true : false;
return ok;	
		
	
	} catch (Exception e) {
		// TODO: handle exception
	}
return false;
}
public  Utilisateur login(String login, String password) {
	Utilisateur utilisateur=new Utilisateur();
	
	try {
		
	 this.pre = this.con.prepareStatement("SELECT * FROM utilisateur WHERE login = ? AND password=?");
         this.pre.setString(1,login);
         this.pre.setString(2, password);
        
        ResultSet resultats = this.pre.executeQuery();
        while (resultats.next()) {
        	utilisateur.setId(resultats.getInt("id"));
    		utilisateur.setNom(resultats.getString("nom"));
    		utilisateur.setPrenom(resultats.getString("prenom"));
    		utilisateur.setLogin(resultats.getString("login"));
    		utilisateur.setPassword(resultats.getString("password"));
    		return utilisateur;
    }
         
		
		
		
		
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	 
	
	return utilisateur;

}
public  Utilisateur get(int id) {
	Utilisateur utilisateur=new Utilisateur();
	
	try {
		
	 this.pre = this.con.prepareStatement("SELECT * FROM utilisateur WHERE id = ?");
         this.pre.setInt(1,id);
        
        ResultSet resultats = this.pre.executeQuery();
        while (resultats.next()) {
        	utilisateur.setId(resultats.getInt("id"));
    		utilisateur.setNom(resultats.getString("nom"));
    		utilisateur.setPrenom(resultats.getString("prenom"));
    		utilisateur.setLogin(resultats.getString("login"));
    		utilisateur.setPassword(resultats.getString("password"));
    		return utilisateur;
    }
         
		
		
		
		
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	 
	
	return utilisateur;
}
}
