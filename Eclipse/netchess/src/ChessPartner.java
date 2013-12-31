
/*		ChessPartner v 1.0 - Chess playing Applet

		Copyright (C) 2000 Leander Eyer
		email:	noblochi@rhone.ch
		
		This programm is free software; you can redistribute it and/or
		modify it under the terms of the GNU General Public License as
		published by the Free Software Foundation; either version 2 of
		the License, or (at your option) any later version.
		
		This program is distributed in the hope that it will be useful,
		but WITHOUT ANY WARRANTY; without even the implied warranty of
		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
		General Public License for more details.
		
		You should have received a copy of the GNU General Public License
		along with this program; if not, write to the Free Software
		Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.	
*/

import java.applet.*;
import java.awt.*;

public class ChessPartner extends Applet
{
	//reference for the board classDie Referenz auf die KI
	Boardf brain;
		
	//the elements of the GUI
	Button newgame = new Button ("start new game");

//events
public boolean action (Event evt, Object arg) {
	if ( ((String) arg).equals ("start new game"))
		brain.newgame ();	
	return true;
}
//initialize the applet
public void init() {
	super.init();

	//initialize AI
	brain = new Boardf (this);
	
	//build GUI
	setBackground (Color.lightGray);
	setLayout (new BorderLayout (10,10));
	
	add ("Center", brain);
	add ("South", newgame);	
}
//make a border with 10 bixels width
public Insets insets () {
	return new Insets (10,10,10,10);
}
}