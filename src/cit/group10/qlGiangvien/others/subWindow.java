package cit.group10.qlGiangvien.others;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class subWindow {
	
	
	
	
	
	public static Window confirmDelete(String title, String content, String button ){
		
		final Window subwindow ;
		// Create the window...
        subwindow = new Window(title);
        // ...and make it modal
        subwindow.setModal(true);

        // Configure the windws layout; by default a VerticalLayout
        VerticalLayout layout = (VerticalLayout) subwindow.getContent();
        layout.setMargin(true);
        layout.setSpacing(true);

        // Add some content; a label and a close-button
        Label message = new Label(content);
        subwindow.addComponent(message);

        Button close = new Button(button, new Button.ClickListener() {
            
			@Override
			public void buttonClick(ClickEvent event) {
				
				(subwindow.getParent()).removeWindow(subwindow);
			}
        });
        // The components added to the window are actually added to the window's
        // layout; you can use either. Alignments are set using the layout
        layout.addComponent(close);
        layout.setComponentAlignment(close, Alignment.TOP_RIGHT);
		
		return subwindow ;
	}//end of confirmDelete
	
	
	
	
	
	
	

}
