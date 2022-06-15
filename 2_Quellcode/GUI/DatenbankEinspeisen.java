    // Datei hinzufügen, welches Eintragungsformat-->nach der Aktion einspeisen die den anmeldebutton bestimmt  
    public void actionPerformed(ActionEvent evt) {
    	
    	if (new addUser().eintragen(jTextField.getText()) > 0)
    		System.out.println("Daten erfolgreich eingetragen.");
    	else 
    		System.out.println("Eintragen der Daten nicht erfolgreich.");
    	
    	if (new addNachname().eintragen(jTextField.getText()) > 0)
    		System.out.println("Daten erfolgreich eingetragen.");
    	else 
    		System.out.println("Eintragen der Daten nicht erfolgreich.");
    	
    	if (new addEmail().eintragen(jTextField.getText()) > 0)
    		System.out.println("Daten erfolgreich eingetragen.");
    	else 
    		System.out.println("Eintragen der Daten nicht erfolgreich.");
    	
    	if (new addNummer().eintragen(jTextField.getText()) > 0)
    		System.out.println("Daten erfolgreich eingetragen.");
    	else 
    		System.out.println("Eintragen der Daten nicht erfolgreich.");
    
    
    }
