package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTextArea;
import model.Page;
import view.bookUI;

public class GUIController extends bookUI {
	private static final long serialVersionUID = 1L;
	
	private Controller controller;

	
	int pageGlobal;
	
	public GUIController() {
		super();
		this.controller=new Controller("");
		this.pageGlobal=this.getController().getBookMark();
		this.getController().createArray();
		listener();
	}
	private void listener() {

		this.getBtnNext().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// writtingHelped(getPageLeftTo()); //funcion para escribir el archivo "Auxiliar.txt"
				getController().setCountCharacter(getController().getNumberCharactersAct(pageGlobal));
				loadFooterLeft();
				skipPage(getPageLeftTo());
				loadFooterRight();
				skipPage(getPageRightTo());
			}
		});
		this.getBtnPrevious().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean salir = true;
				pageGlobal -= 4;
				int i = 1;
				for (Page page : getController().getPages()) {
					if (getPageLeft().getText().equals(String.valueOf(page.getPage()))) {
						if (salir) {
							getController().setCountCharacter(getController().getNumberCharactersPrev(i));
							loadFooterLeft();
							skipPage(getPageLeftTo());
							loadFooterRight();
							skipPage(getPageRightTo());
							salir = false;
						}
					}
					i++;
				}
				
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(pageGlobal>0 && (pageGlobal%2!=0))
				 getController().setBookMark(pageGlobal);
				System.exit(0);
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				pageGlobal -= 2;
				getController().setCountCharacter(getController().getNumberCharactersAct(pageGlobal));
				System.out.println("AQIO"+pageGlobal);
				loadFooterLeft();
				skipPage(getPageLeftTo());
				loadFooterRight();
				skipPage(getPageRightTo());
			}
		});
	}
	private void loadFooterLeft() {

		getPageLeft().setText(String.valueOf(pageGlobal));
	}

	private void loadFooterRight() {
		getPageRight().setText(String.valueOf(pageGlobal));
	}

	private void skipPage(JTextArea textArea) {
		StringBuilder cadena = new StringBuilder();
		double height2 = 18;
		do {
			cadena.append(this.getController().readingBook());
			this.getController().increaseCharacterCounter();
			textArea.setText(cadena.toString());
		} while (textArea.getPreferredSize().getHeight() + height2 <= textArea.getHeight());
		pageGlobal++;
	}
	private Controller getController() {
		return controller;
	}
	//Método para crear el archivo auxiliar que indica el numero de caracteres de cada página.
	private void writtingHelped(JTextArea textArea) {
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("auxiliar.txt");
			pw = new PrintWriter(file);
			pw.println(0 + ":" + this.getController().getCharacterCounter());
			while (3030 > pageGlobal) {
				pw.println(pageGlobal + ":" + this.getController().getCharacterCounter());
				skipPage(getPageLeftTo());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != file)
					file.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
