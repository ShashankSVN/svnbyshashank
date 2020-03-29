package collection;

/**
 * 
 * @author Nagendra
 * 
 */
//Comparable gives you default sorting...............
//
public class Biscuit extends Object implements Comparable<Biscuit>{

	private int bid;
	private String vendor;
	private String taste;
	private String howtoeat;
	
	public Biscuit() { 
		
	}

	public Biscuit(int bid, String vendor, String taste, String howtoeat) {
		this.bid = bid;
		this.vendor = vendor;
		this.taste = taste;
		this.howtoeat = howtoeat;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getHowtoeat() {
		return howtoeat;
	}

	public void setHowtoeat(String howtoeat) {
		this.howtoeat = howtoeat;
	}
	
	
	/* public boolean equals(Object obj) {
			return (this == obj);
	 }*/
	
	
	@Override
	public boolean equals(Object obj) {
		Biscuit biscuit=(Biscuit)obj; //this is second object which we want to compare
		//this.bid >>>> bid ==>>>this is attribute of current object
		if(this.bid==biscuit.bid && this.vendor.equals(biscuit.vendor) && this.taste.equals(biscuit.taste) && this.howtoeat.equals(biscuit.howtoeat) ) {
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return bid+vendor.hashCode()+taste.hashCode()+howtoeat.hashCode();
	};


	@Override
	public String toString() {
		return "Biscuit [bid=" + bid + ", vendor=" + vendor + ", taste="
				+ taste + ", howtoeat=" + howtoeat + "]";
	}

	@Override
	public int compareTo(Biscuit o) {
		//we are adding sorting behavior in biscuit ascending
		int p=bid-o.bid; //ascending order by bid 
		if(p==0) {
			p=o.taste.compareTo(taste);  //here it is descending order by taste
		}
		return p;
	}



}
