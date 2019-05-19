package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JTextArea;

import model.Book;
import model.Page;

public class Controller {
	private ArrayList <Page> pages= new ArrayList<Page>() ;
	private long characterCounter;
	private Book book;
	private long numberCharacter=200000;

	public Controller (String path)
	{
		book = new Book("juegotronos.txt");
		book.writeBook(this.numberCharacter);
		this.setCountCharacter(0);
	}
	
	public void createArray() {
		String[] help = new String[2];
		String line = "";
		int i=0;
		boolean salir=true;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("auxiliar.txt");
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		while(salir) {
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				help = line.split(":");
				addPage(help, i);
				i++;
			} catch(NullPointerException e) {
				salir=false;
			}
			
		}
	}
	public int getBookMark() {
		FileReader fr = null;
		BufferedReader br = null;
		String line="";
		try {
			fr = new FileReader("bookMark.txt");
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Integer.parseInt(line));
		return Integer.parseInt(line);
	}
	public void setBookMark(int page)
	{
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("bookMark.txt");
			pw = new PrintWriter(file);
			pw.println(page);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (null != file)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void addPage(String[] help, int i) {
		pages.add(new Page(Long.valueOf(help[1]),i+1));
	}
	public void increaseCharacterCounter() {
		setCountCharacter(getCharacterCounter()+1);
	}
	public String readingBook() {
		return getBook().giveMeCharacterDos(this.getCharacterCounter());
	}	
	public Book getBook() {
		return book;
	}
	public long getCharacterCounter() {
		return characterCounter;
	}

	public void setCountCharacter(long countCharacter) {
		this.characterCounter = countCharacter;
	}
	public long getNumberCharactersAct(int i)
	{
		return getPages().get(i).getNumberCharactersPrev();
	}
	public long getNumberCharactersPrev(int i)
	{
		return getPages().get(i-2).getNumberCharactersPrev();
	}
	
	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}
	
}
