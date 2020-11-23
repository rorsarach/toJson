package bean;

import java.util.ArrayList;

public class Advice {
	String disease;
	String information;
	ArrayList clinic = new ArrayList();
	ArrayList advice = new ArrayList();
	ArrayList alias = new ArrayList();
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public ArrayList getClinic() {
		return clinic;
	}
	public void setClinic(ArrayList clinic) {
		this.clinic = clinic;
	}
	public ArrayList getAdvice() {
		return advice;
	}
	public void setAdvice(ArrayList advice) {
		this.advice = advice;
	}
	public ArrayList getAlias() {
		return alias;
	}
	public void setAlias(ArrayList alias) {
		this.alias = alias;
	}
	@Override
	public String toString() {
		return "Advice [disease=" + disease + ", information=" + information + ", clinic=" + clinic + ", advice="
				+ advice + ", alias=" + alias + "]";
	}
	
}
