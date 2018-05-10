package kr.or.dgit.coffee_application.dto;

public class Product {
	private String pdCode;
	private String pdName;
	
	
	public Product(String pdCode, String pdName) {
		
		this.pdCode = pdCode;
		this.pdName = pdName;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pdCode == null) ? 0 : pdCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (pdCode == null) {
			if (other.pdCode != null)
				return false;
		} else if (!pdCode.equals(other.pdCode))
			return false;
		return true;
	}
	public String getPdCode() {
		return pdCode;
	}
	public void setPdCode(String pdCode) {
		this.pdCode = pdCode;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	@Override
	public String toString() {
		return String.format("Product [pdCode=%s, pdName=%s]", pdCode, pdName);
	}
	
	
	
	
}
