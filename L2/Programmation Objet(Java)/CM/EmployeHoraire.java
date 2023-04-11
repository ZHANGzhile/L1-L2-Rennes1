package tp3;

public class EmployeHoraire extends Employe{

	private int heures;
	private boolean typeEm;
	
	public EmployeHoraire(String name) {
		super(name);
	}
	public EmployeHoraire(String name,int heures,boolean typeEm) {
		super(name);
		this.heures = heures;
		this.typeEm = typeEm;
	}
		
	public void setHeures(int heures) {
		this.heures = heures;
	}
	
	public int getHeures() {
		return heures;
	}
	
	public void setTypeEm(boolean typeEm) {
		this.typeEm= typeEm;
	}
	
	public boolean getTypeEm() {
		return typeEm;
	}
	
	public void setInfosSalaire(int heures, boolean typeEm ) {
		this.heures = heures;
		this.typeEm = typeEm;
	}
	
	
	public double getSalaire() {
		if(typeEm) {
			return (35*30 + (heures-35)*39);
		}
		else 
			return (35*30 + (heures-35)*45);
		}
	


}
