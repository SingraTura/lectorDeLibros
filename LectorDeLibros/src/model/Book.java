package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Book {


	private FileReader book = null;
	private String bookReader="";
	
	public Book(String path) {
		super();
		if (checkBook(path)) {
			this.setBook(openBook(new File(path)));
		}
	}
	public void writeBook(long characterNumber)
	{
		int i=0;
		String salir;
		while(i<characterNumber)
		{
			try {
				System.out.println(i*100/characterNumber + "%");
				salir=giveMeCharacter();
				bookReader=bookReader.concat(salir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
	public String giveMeCharacterDos(long num) {
		// TODO Auto-generated method stub
		return String.valueOf(bookReader.charAt((int) num));
	}
	private String giveMeCharacter() throws IOException {
		int test= book.read();
		switch(test) {
		case 8364:
			return " ";
		case 226:
			return " ";
		case 194:
			return " ";
		case 195:
			return " ";
		case 239:
			return " ";
		case 187:
			return " ";
		case 191:
			return " ";
		case 166:
			return ".";
		case 161:
			return "á";
		case 169:
			return "é";
		case 8240:
			return "É";
		case 179:
			return "ó";
		case 8220:
			return " ";
		case 173:
			return "í";
		case 186:
			return "ú";
		case 177:
			return "ñ";
		case -1:
			return "Ñ";
		}
		return String.valueOf((char) test);
	}
	private boolean checkBook(String path) {
		File file = new File(path);
		return file.exists() && file.canRead();
	}
	private FileReader openBook(File path) {
		assert path.exists() && path.canRead();
		try {
			return new FileReader(path);
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	

	private void setBook(FileReader book) {
		this.book = book;
	}

}
