package org.loboevolution.pdf;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import org.loboevolution.pdfview.PDFFile;

public class NavigationToolbar extends JToolBar {
	
	private static final long serialVersionUID = 1L;

	private static final int FIRSTPAGE = 0;
	
	private static final int FBACKPAGE = 1;
	
	private static final int BACKPAGE = 2;
	
	private static final int FORWARDPAGE = 3;
	
	private static final int FFORWARDPAGE = 4;
	
	private static final int LASTPAGE = 5;
	
	private static final int SETPAGE = 6;

	/** the current page number text field. */
	protected JTextField currentPageBox = new JTextField(4);
	
	private JLabel totalNoOfPages = new JLabel();

	private PDFViewer PDFViewer;

	public NavigationToolbar(PDFViewer PDFViewer) {
		this.PDFViewer = PDFViewer;

		add(Box.createHorizontalGlue());

		addButton("Rewind To Start", "/org/loboevolution/images/start.gif", FIRSTPAGE);
		addButton("Back 5 Pages", "/org/loboevolution/images/fback.gif", FBACKPAGE);
		addButton("Back", "/org/loboevolution/images/back.gif", BACKPAGE);

		add(new JLabel("Page"));
		currentPageBox.setText("1");
		currentPageBox.setMaximumSize(new Dimension(5, 50));
		currentPageBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				executeCommand(SETPAGE);
			}
		});
		add(currentPageBox);
		add(totalNoOfPages);

		addButton("Forward", "/org/loboevolution/images/forward.gif", FORWARDPAGE);
		addButton("Forward 5 Pages", "/org/loboevolution/images/fforward.gif", FFORWARDPAGE);
		addButton("Fast Forward To End", "/org/loboevolution/images/end.gif", LASTPAGE);

		add(Box.createHorizontalGlue());

	}

	public void setTotalNoOfPages(int noOfPages) {
		totalNoOfPages.setText("of " + noOfPages);
	}

	public void setCurrentPage(int currentPage) {
		currentPageBox.setText(String.valueOf(currentPage));
	}

    private void addButton(String tooltip, String url, final int type) {
		JButton button = new JButton();
		button.setIcon(new ImageIcon(getClass().getResource(url)));
		button.setToolTipText(tooltip);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				executeCommand(type);
			}
		});

		add(button);
	}

	public void executeCommand(int type) {
		switch (type) {
		case FIRSTPAGE:
			PDFViewer.doFirst();
			break;
		case FBACKPAGE:
			PDFViewer.gotoPage(PDFViewer.curpage - 5);
			break;
		case BACKPAGE:
			PDFViewer.doPrev();
			break;
		case FORWARDPAGE:
			PDFViewer.doNext();
			break;
		case FFORWARDPAGE:
			PDFViewer.gotoPage(PDFViewer.curpage + 5);
			break;
		case LASTPAGE:
			PDFViewer.doLast();
			break;
		case SETPAGE:
			int pagenum = -1;
			final PDFFile curFile = PDFViewer.curFile;
			final int curpage = PDFViewer.curpage;
			try {
				pagenum = Integer.parseInt(currentPageBox.getText()) - 1;
			} catch (NumberFormatException nfe) {
			}
			if (pagenum >= curFile.getNumPages()) {
				pagenum = curFile.getNumPages() - 1;
			}
			if (pagenum >= 0) {
				if (pagenum != curpage) {
					PDFViewer.gotoPage(pagenum);
				}
			} else {
				currentPageBox.setText(String.valueOf(curpage));
			}
			break;
		default:
			break;
		}
		currentPageBox.setText(String.valueOf(PDFViewer.curpage + 1));
	}
}
