package bean;

import java.util.ArrayList;

public class Examination {
	String target;
	ArrayList uplist = new ArrayList();
	ArrayList downlist = new ArrayList();
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public ArrayList getUplist() {
		return uplist;
	}
	public void setUplist(ArrayList uplist) {
		this.uplist = uplist;
	}
	public ArrayList getDownlist() {
		return downlist;
	}
	public void setDownlist(ArrayList downlist) {
		this.downlist = downlist;
	}
	@Override
	public String toString() {
		return "Examination [target=" + target + ", uplist=" + uplist + ", downlist=" + downlist + "]";
	}

	
	
}
