
public enum ThemeList {
	
	
	AUTUMN("org.pushingpixels.substance.api.skin.SubstanceAutumnLookAndFeel"),
	BUSINESS("org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel"),
	BUSINESS_BLACK_STEEL("org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel"),
	MIST_SILVER("org.pushingpixels.substance.api.skin.SubstanceMistSilverLookAndFeel"),
	MIST_AQUA("org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel"),
	NIMBUS("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"),
	OFFICE_BLUE("org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel"); 
	

	private String str;//Instance field
	
	ThemeList(String str){
		this.str = str;
	}
	
	@Override
	public String toString(){
		return punctuateString();
	}

	/**
	 * @return Returns a theme list string to it's proper capitalization
	 */
	private String punctuateString() {
		char[] name = this.name().toCharArray();
		String newString = "";
		//Go through each letter and correct capitalization
		for(int i = 0 ; i < name.length; i++){
			//If the index is at the first letter in the array
			if(i == 0){
				newString = String.valueOf( name[i]).toUpperCase();
				
			} else if(name[i] == '_' && i+1 < name.length){	//If we encounter an underscore and the next index to the right is not at the end of the name/chars' length
				//Then we replace the underscore with a space and begin a new word with capitalizing the next first letter of the new word
				newString +=  " ";//Assign an empty space in between words
				newString +=  String.valueOf( name[i + 1] ).toUpperCase();//Capitalize the first letter of the new word
				i++;//Increment the counter to the next position so we don't get doubles of the same letter
				
			} else{	//Here we put every letter after the first letter of a word to lower case
				newString +=  String.valueOf( name[i] ).toLowerCase();
			}
		}
		return newString;
	}
		
	/**
	 * 
	 * @return Returns the themes url
	 */
	public String getThemeUrl(){
		return str;
	}
	
}
