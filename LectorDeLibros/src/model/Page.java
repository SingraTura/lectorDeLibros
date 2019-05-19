package model;

public class Page {
	private long numberCharactersPrev;
	private int page;
	
	public Page(long numberCharactersPrev, int page)
	{
		super();
		this.setNumberCharactersPrev(numberCharactersPrev);
		this.setPage(page);
	}
	public long getNumberCharactersPrev() {
		return numberCharactersPrev;
	}
	public void setNumberCharactersPrev(long numberCharactersPrev) {
		this.numberCharactersPrev = numberCharactersPrev;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
