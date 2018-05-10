package kr.or.dgit.coffee_application.dto;

public class PdIntro {
	private Product pd;	//pdCode ,pdName
	
	private int pdUnitprice;	//제품 단가 pdUnitprice pdUnitsales supplyvalue vat selling pdPermargin margin
	private int pdUnitsales;	//판매수량
	private int pdPermargin;	//마진율
	
	private int rank;
	private int supplyvalue;	//공급가액
	private int selling; //판매 금액
	private int vat;	//부가새액
	private int margin;	//마진액
	
	
	
	public PdIntro() {

	}
	
	

	public PdIntro(Product pd, int pdUnitprice, int pdUnitsales, int pdPermargin, int rank, int supplyvalue,
			int selling, int vat, int margin) {
		super();
		this.pd = pd;
		this.pdUnitprice = pdUnitprice;
		this.pdUnitsales = pdUnitsales;
		this.pdPermargin = pdPermargin;
		this.rank = rank;
		this.supplyvalue = supplyvalue;
		this.selling = selling;
		this.vat = vat;
		this.margin = margin;
	}
	
	
	

	public int getSelling() {
		return selling;
	}



	public void setSelling(int selling) {
		this.selling = selling;
	}



	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSupplyvalue() {
		return supplyvalue;
	}

	public void setSupplyvalue(int supplyvalue) {
		this.supplyvalue = supplyvalue;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public PdIntro(Product pd, int pdUnitprice, int pdUnitsales, int pdPermargin) {
		super();
		this.pd = pd;
		this.pdUnitprice = pdUnitprice;
		this.pdUnitsales = pdUnitsales;
		this.pdPermargin = pdPermargin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pd == null) ? 0 : pd.hashCode());
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
		PdIntro other = (PdIntro) obj;
		if (pd == null) {
			if (other.pd != null)
				return false;
		} else if (!pd.equals(other.pd))
			return false;
		return true;
	}

	public Product getPd() {
		return pd;
	}

	public void setPd(Product pd) {
		this.pd = pd;
	}

	

	public int getPdUnitprice() {
		return pdUnitprice;
	}



	public void setPdUnitprice(int pdUnitprice) {
		this.pdUnitprice = pdUnitprice;
	}



	public int getPdUnitsales() {
		return pdUnitsales;
	}

	public void setPdUnitsales(int pdUnitsales) {
		this.pdUnitsales = pdUnitsales;
	}

	public int getPdPermargin() {
		return pdPermargin;
	}

	public void setPdPermargin(int pdPermargin) {
		this.pdPermargin = pdPermargin;
	}

	
	@Override
	public String toString() {
		return String.format(
				"PdIntro [pd=%s, pdUnitprice=%s, pdUnitsales=%s, pdPermargin=%s, rank=%s, supplyvalue=%s, selling=%s, vat=%s, margin=%s]",
				pd, pdUnitprice, pdUnitsales, pdPermargin, rank, supplyvalue, selling, vat, margin);
	}



	public Object[] toArray() {
		return new Object[] {rank,pd.getPdCode(),pd.getPdName(),String.format("%,d",pdUnitprice), pdUnitsales, String.format("%,d",supplyvalue),
				String.format("%,d",vat) , String.format("%,d",selling), pdPermargin, String.format("%,d", margin)};
	}
	
	
}
