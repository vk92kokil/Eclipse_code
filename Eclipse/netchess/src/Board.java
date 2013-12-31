 /*		Board v 0.1 - Interface and AI for a chess programm

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

import java.applet.Applet;
import java.awt.*;

public class Board extends java.awt.Canvas
	implements
		java.awt.event.MouseListener, java.awt.event.MouseMotionListener,
		java.lang.Runnable 
{
	//the intern representation of the chessboard
	int [] board = new int [120];		

public Board (java.applet.Applet ref) {
	super();
}
public void mouseClicked(java.awt.event.MouseEvent e) {
}
public void mouseDragged(java.awt.event.MouseEvent e) {
}
public void mouseEntered(java.awt.event.MouseEvent e) {
}
public void mouseExited(java.awt.event.MouseEvent e) {
}
public void mouseMoved(java.awt.event.MouseEvent e) {
}
public void mousePressed(java.awt.event.MouseEvent e) {
}
public void mouseReleased(java.awt.event.MouseEvent e) {
}
//prepare AI for new game
public void newgame () {
	return;
}
//paint chessboard (not implemented yet)
public void paint (Graphics g) {
	g.setColor (Color.black);
	g.fillRect (0,0, 320,320);
	return;
}
//AI thread
public void run() {
}
}