  /*		Board v 1.0 - Interface and AI for a chess programm

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

public class Boardf extends java.awt.Canvas
	implements
		java.awt.event.MouseListener, java.awt.event.MouseMotionListener,
		java.lang.Runnable 
{
	//The intern representation of the chessboard
	int [] board = new int [120];	
	
	//a second board for the graphic
	int [] graphboard = new int [120];
	
	//some colors
	Color dunkel = new Color (0x999999);
	Color hell = new Color (0xFFFFCC);
	Color red = new Color (0xCC0000);
	Color green = new Color (0x009900);
	Color blue = new Color (0x000099);	
	
	//the piece images
	Image [] pieces = new Image [18];	

	//a reference of the applet
	Applet parent;
	
	//variables for Drag&Drop
	int 	code 	= 0,	//forbid access to the movelist				
			start = 21,		//index of the start field
			alt 	= 21,	//did the mouse move to an other field?
			end	= 21,		//index of the end field
			x	= 0,		//x koordinate
			y 	= 0;		//y koordinate
			
	//variables of the AI
	int [] movelist = new int [250];  	//valid move control
	int movecounter = 0;
	int color = 1;				//color of the player that can move
	Thread th = null;			//AI thread
	int deep = 0;				//actual deep
	int target = 4;				//target deep
	float value = 0;			//minimax
	float minimax [] = new float [10]; 	
	float alphabeta [] = new float [10];	//Alpha Beta
	boolean ababort = false;		
	int move;				//move of the AI
	
	//variables for the evaluation
	float [] posvalues = 
		{	0.00f,	0.00f, 	0.00f, 	0.00f, 	0.00f, 	0.00f, 	0.00f, 	0.00f, 	0.00f, 	0.00f,
			0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,
			0.00f,	0.00f,	0.01f,	0.02f,	0.03f,	0.03f,	0.02f,	0.01f,	0.00f,	0.00f,//8
			0.00f,	0.01f,	0.04f,	0.04f,	0.04f,	0.04f,	0.04f,	0.04f,	0.01f,	0.00f,//7
			0.00f,	0.03f,	0.04f,	0.06f,	0.06f,	0.06f,	0.06f,	0.04f,	0.02f,	0.00f,//6
			0.00f,	0.03f,	0.04f,	0.06f,	0.08f,	0.08f,	0.06f,	0.04f,	0.03f,	0.00f,//5
			0.00f,	0.03f,	0.04f,	0.06f,	0.08f,	0.08f,	0.06f,	0.04f,	0.03f,	0.00f,//4
			0.00f,	0.02f,	0.04f,	0.06f,	0.06f,	0.06f,	0.06f,	0.04f,	0.02f,	0.00f,//3
			0.00f,	0.01f,	0.04f,	0.04f,	0.04f,	0.04f,	0.04f,	0.04f,	0.01f,	0.00f,//2
			0.00f,	0.00f,	0.01f,	0.02f,	0.03f,	0.03f,	0.02f,	0.01f,	0.00f,	0.00f,//1
			0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f, 
			0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f,	0.00f };

public Boardf (java.applet.Applet ref) {
	super();
	//initialize alpha beta
	alphabeta [0] = -3000.0f;
	newgame ();
	
	//load images
	MediaTracker controler = new MediaTracker (ref);
	
	pieces [1] = ref.getImage (ref.getCodeBase (), "pawn_wht.jpg");
	pieces [2] = ref.getImage (ref.getCodeBase (), "knight_wht.jpg");
	pieces [3] = ref.getImage (ref.getCodeBase (), "bishop_wht.jpg");
	pieces [4] = ref.getImage (ref.getCodeBase (), "rook_wht.jpg");
	pieces [5] = ref.getImage (ref.getCodeBase (), "queen_wht.jpg");
	pieces [6] = ref.getImage (ref.getCodeBase (), "king_wht.jpg");
	
	pieces [11] = ref.getImage (ref.getCodeBase (), "pawn_blk.jpg");
	pieces [12] = ref.getImage (ref.getCodeBase (), "knight_blk.jpg");
	pieces [13] = ref.getImage (ref.getCodeBase (), "bishop_blk.jpg");
	pieces [14] = ref.getImage (ref.getCodeBase (), "rook_blk.jpg");
	pieces [15] = ref.getImage (ref.getCodeBase (), "queen_blk.jpg");
	pieces [16] = ref.getImage (ref.getCodeBase (), "king_blk.jpg");
	
	for (int i = 1; i < 7; i++)
	{
		controler.addImage (pieces [i], 0);
		controler.addImage (pieces [i + 10], 0);
	}

	try {
		controler.waitForAll ();	//wait until the images are loaded	
	} catch (InterruptedException e) { 
		System.out.println ("Images not successfull loaded - Trying again ...");	
		controler.checkID (0, true);			
	}
	
	//set applet reference
	parent = ref;
	
	//events
	addMouseListener (this);
	addMouseMotionListener (this);
}
//evaluate a position
public float evaluation ( ) {
	float value = 0;
	float figur = 0;
	
	for (int i = 21; i < 99; i++)
	{
		if ( board [i] != 0 )
		{	
			//material
			switch (board [i] % 10)
			{
				case 1:
					figur = 1.0f;
					break;
				case 2:
				case 3:
					figur = 3.0f;
					break;
				case 4:
					figur = 4.5f;
					break;
				case 5:
					figur = 9.0f;
					break;
				case 6:
					figur = 0.0f;
			}
			
			//position
			figur += posvalues [i];
			
			if ( board [i] % 100  / 10 == color)
				value += figur;		
			else
				value -= figur;
		}	
		
		if ( i%10 == 8)
			i += 2;
	}
	return value;	
}
//execute a move
public void execute (int start, int end) 
{
	board [end] = board [start];
	board [start] = 0;
	
	//Rochade ?
	if (board [end] % 10 == 6)
	{
		if( end == start + 2)
		{	//little
			board [start + 1] = board [start + 3] % 100;
			board [start + 3] = 0;
		
			graphboard [start + 1] = board [start + 1];
			graphboard [start + 3] = 0;
				
			paintField (start + 3);
			paintField (start + 1);
		}
		if( end == start - 2)
		{	//big
			board [start - 1] = board [start - 4] % 100;
			board [start - 4] = 0;
		
			graphboard [start - 1] = board [start - 1];
			graphboard [start - 4] = 0;
				
			paintField (start - 4);
			paintField (start - 1);			
		}
	}
	
	//change pawn?
	if ( (board [end] % 10 == 1) && ((end < 29) || (end > 90)) )
		board [end] += 4;;
	
	graphboard [start] = board [start];
	graphboard [end] = board [end];
	
	paintField (end);
	paintField (start);
	
	//change player
	if (color == 1)
	{
		color = 2;
		
		//look for best move
		th = new Thread (this);
		th.setPriority (10);
		th.start ();

	} else {
		color = 1;
	
		//calculate valid moves
		movecounter = 0;
		deep = 0;
		target = 1;
		genmove ();

		if (movecounter == 0)	//no valid moves -> end of game
		{
			if (ischeck ())
				parent.getAppletContext ().showStatus ("Black wins!");
			else
				parent.getAppletContext ().showStatus ("Game is a draw!");			
		}
	}
}
//generates valid moves
public void genmove () {
	deep++;
	ababort = false;

	//find checkmath and initialize alphabeta
	if (deep % 2 != 0)		
	{	//Computer
		minimax [deep] = 2000.0f;
		alphabeta [deep] = 3000.0f;
	} else {
		//human
		minimax [deep] = -2000.0f;
		alphabeta [deep] = -3000.0f;
	}	
		
	for (int i = 21; i < 99; i++)	
	{
		if (board [i] % 100 / 10 == color)	//check color
		{
			switch (board [i] % 10) 
			{
				case 1:	//pawn	
					if (color == 1)	//white pawn ?
					{
						if (board [i-10] == 0)
							simulize ( i, i-10);										
						if (board [i- 9] % 100 / 10 == 2)
							simulize ( i, i-9 );								
						if (board [i-11] % 100 / 10 == 2)
							simulize ( i, i-11);								
						if ( (i>80) && ( ( board [i-10] == 0) && (board [i-20] == 0))) 
							simulize ( i, i-20);													
					} else {	//black pawn
						if (board [i+10] == 0)
							simulize ( i, i+10);								
						if (board [i+9] % 100 / 10 == 1)
							simulize (i, i+9);
						if (board [i+11] % 100 / 10 == 1)
							simulize (i, i+11);								
						if ( (i<39) && ( (board [i+10] == 0) && (board [i+20] == 0)))
							simulize (i, i+20);								
						//en passant
					}					
					break;
				case 2:	//knight	
					simulize (i, i+12);							
					simulize (i, i-12);							
					simulize (i, i+21);							
					simulize (i, i-21);							
					simulize (i, i+19);							
					simulize (i, i-19);						
					simulize (i, i+8 );					
					simulize (i, i-8 );					
					break;
				case 5:	//queen
				case 3:	//bishop
					multisimulize ( i,  -9);
					multisimulize ( i, -11);
					multisimulize ( i,  +9);
					multisimulize ( i, +11);
					
					if (board [i] % 10 == 3)
						break;
				case 4:	//rook
					multisimulize (i, -10);
				 	multisimulize (i, +10);
					multisimulize (i,  -1);
					multisimulize (i,  +1);
					break;
				case 6:	//king
					if ((board [i] / 100 == 1) && (! ischeck ()))
					{		
						if (((board [i+1] == 0) && (board [i+2] == 0)) && (board [i+3] / 100 == 1))
						{	//little casteling				
							board [i+1] = board [i] % 100;
							board [i] = 0;
														
							if (! ischeck ())
							{
								//king back
								board [i] = board [i+1];
																										
								//move rook
								board [i + 1] = board [i + 3] % 100;
								board [i + 3] = 0;
								
								simulize (i, i+2);
								
								//takeback
								board [i + 3] = board [i + 1] + 100;
								board [i+1] = board [i];
							}
							
							//rebuild original position
							board [i] = board [i + 1] + 100;
							board [i + 1] = 0;				
						}
						
						if (((board [i-1] == 0) && (board [i-2] == 0)) && ((board [i-3] == 0) && (board [i-4] / 100 == 1)))
						{	//big casteling
							board [i-1] = board [i] % 100;
							board [i] = 0;
													
							if (! ischeck ())
							{
								//king back
								board [i] = board [i-1];
																										
								//move rook
								board [i - 1] = board [i - 4] % 100;
								board [i - 4] = 0;
								
								simulize (i, i-2);
								
								//tackeback
								board [i - 4] = board [i - 1] + 100;
								board [i - 1] = board [i];
							}
							
							//rebuild original position
							board [i] = board [i - 1] + 100;
							board [i - 1] = 0;									
						}
					}				
																
					simulize (i, i+1); 
					simulize (i, i-1);
					simulize (i, i+10);
					simulize (i, i-10);
					simulize (i, i+9);
					simulize (i, i-9);
					simulize (i, i+11);
					simulize (i, i-11);	
			}
		}
		
		if ( i%10 == 8)
			i += 2;
	}
	
	deep--;
	ababort = false;
}
//is king in check?
public boolean ischeck () {
	int king = 0;
	
	//search king
	for ( int i = 21; i < 99; i++)
	{
		if ((board [i] % 100 / 10 == color) && (board [i] % 10 == 6))
		{
			king = i;
			break;
		}	
					
		if ( i % 10 == 8)
			i += 2;
	}
	
	//knight
	if ((board [king-21] % 10 == 2) && (board [king-21] % 100 / 10 != color))
		return true;
 	if ((board [king+21] % 10 == 2) && (board [king+21] % 100 / 10 != color))
		return true;
	if ((board [king-19] % 10 == 2) && (board [king-19] % 100 / 10 != color))
		return true; 
	if ((board [king+19] % 10 == 2) && (board [king+19] % 100 / 10 != color))
		return true;
	if ((board [king- 8] % 10 == 2) && (board [king- 8] % 100 / 10 != color))
		return true;
	if ((board [king+ 8] % 10 == 2) && (board [king+ 8] % 100 / 10 != color))
		return true;
	if ((board [king-12] % 10 == 2) && (board [king-12] % 100 / 10 != color))
		return true;
	if ((board [king+12] % 10 == 2) && (board [king+12] % 100 / 10 != color))
		return true;		 
 
   	//ishop
	int j = king;
	while (board [j - 9] != 99)
	{		
		j -= 9;
		if (board [j] % 100 / 10 == color)
			break;
		if (board [j] == 0)
			continue;
		if ((board [j] % 10  == 3) || (board [j] % 10  == 5))
			return true;
		else
			break;
	}
					
	j = king;
	while (board [j+9] != 99)		
	{
		j += 9;
		if (board [j] % 100 / 10 == color)
			break;
		if (board [j] == 0)
			continue;						
		if ((board [j] % 10 == 3) || (board [j] % 10 == 5))
			return true;
		else
			break;
	}
	
	j = king;
	while (board [j-11] != 99)
	{
		j -= 11;
		if (board [j] % 100 / 10 == color)
			break;
		if (board [j] == 0)
			continue;
		if ( (board [j] % 10 == 3) || (board [j] % 10 == 5))
			return true;
		else
			break;
	}
	
	j = king;
	while (board [j+11] != 99)
	{
		j +=11;
		if (board [j] % 100 / 10 == color)
			break;
		if (board [j] == 0)
			continue;
		if ( (board [j] % 10 == 3) || (board [j] % 10 == 5))
			return true;
		else
			break;
	}  
	
	//rook
	j = king;
	while (board [j-10] != 99)
	{
		j -= 10;
		if (board [j] % 100 / 10 == color)
			break;
		if (board [j] == 0)
			continue;
		if ((board [j] % 10 == 4) || (board [j] % 10 == 5))
			return true;
		else
			break;
	}
	j = king;
	while (board [j+10] != 99)
	{
		j += 10;
		if (board [j] % 100 / 10 == color)
			break;
		if (board [j] == 0)
			continue;
		if ((board [j] % 10 == 4) || (board [j] % 10 == 5))
			return true;
		else
			break;
	}
	j = king;
	while (board [j-1] != 99)	
	{
		j -=1;
		if (board [j] % 100 / 10 == color)
			break;
		if (board [j] == 0)
			continue;					
		if ((board [j] % 10 == 4) || (board [j] % 10 == 5))
			return true;
		else
			break;						
	}
	j = king;
	while (board [j+1] != 99)	
	{
		j +=1;
		if (board [j] % 100 / 10 == color)
			break;
		if (board [j] == 0)
			continue;
		if ((board [j] % 10 == 4) || (board [j] % 10 == 5))
			return true;
		else
			break;
	}
	
	//pawn
	if (color == 1)
	{
		if ((board [king-11] % 10 == 1) && (board [king-11] % 100 / 10 == 2))
			return true;
		if ((board [king- 9] % 10 == 1) && (board [king- 9] % 100 / 10 == 2))
			return true;	
	} else {
		if ((board [king+11] % 10 == 1) && (board [king+11] % 100 / 10 == 1))
			return true;
		if ((board [king+ 9] % 10 == 1) && (board [king+ 9] % 100 / 10 == 1)) 
			return true;
	}
	
	//king
	if ( board [king+ 1] % 10 == 6 )  
		return true;
	if ( board [king- 1] % 10 == 6 )   
		return true;
	if ( board [king+10] % 10 == 6 )   
		return true;
	if ( board [king-10] % 10 == 6 )   
		return true;
	if ( board [king+11] % 10 == 6 )   
		return true;
	if ( board [king-11] % 10 == 6 )   
		return true;
	if ( board [king+ 9] % 10 == 6 )   
		return true;
	if ( board [king- 9] % 10 == 6 )   
		return true;

	return false;
}
//checks if a human move is valid
public boolean isvalid (int move) 
{
	for (int i = 0; i < movecounter; i++) {
		if (movelist [i] == move)
			return true;		
	}	
	return false;
}
public void mouseClicked(java.awt.event.MouseEvent e) {
}
public void mouseDragged(java.awt.event.MouseEvent e) {
	x = e.getX() / 40;
	if (x < 0 )
		x = 0;
	if (x > 7 )
		x = 7;
	
	y = e.getY() / 40;
	if (y < 0)
		y = 0;
	if (y > 7 )
		y = 7;
	
	end = 21 + y * 10 + x;
	
	if ( end != alt)
	{
		//rebuild old field
		if	(alt != start)
			paintField (alt);	
			
		if ( end != start)
		{	//mark new field
			Graphics g = getGraphics ();
					
			if ( (code != 1) && (isvalid (start * 100 + end) ))
				g.setColor (green);
			else
				g.setColor (red);
	
			g.fillRect (x * 40, y * 40, 40, 40);
			try {
				g.drawImage (pieces [graphboard [end] % 100 - 10], x * 40, y * 40, 40, 40, parent);
			} catch (ArrayIndexOutOfBoundsException ex) {}	
		}
		alt = end;
	}
}
public void mouseEntered(java.awt.event.MouseEvent e) {
}
public void mouseExited(java.awt.event.MouseEvent e) {
}
public void mouseMoved(java.awt.event.MouseEvent e) {
}
public void mousePressed(java.awt.event.MouseEvent e) 
{
	x = e.getX() / 40;
	if (x < 0)
		x = 0;
	if (x > 7)
		x = 7;
	
	y = e.getY() / 40;
	if (y < 0)
		y = 0;
	if (y > 7)
		y = 7;	

	start = 21 + y*10 + x;
	alt = start;
	end = start;

	//mark start field
	Graphics g = getGraphics ();
	g.setColor (blue);
	g.fillRect (x * 40, y * 40, 40, 40);
	try {
		g.drawImage (pieces [graphboard [start] % 100 - 10], x * 40, y * 40, 40, 40, parent);
	} catch (ArrayIndexOutOfBoundsException ex) {}	
}
public void mouseReleased(java.awt.event.MouseEvent e) {
	//erase marks
	paintField (start);	
	paintField (end);
	
	//execute move if valid
	if ((code != 1) && (isvalid (start * 100 + end ) ))
		execute (start, end);
}
//simulation for queen, rook and bishop
public void multisimulize (int start, int inc) {
	int to = start;
	
	while ((board [to + inc ] != 99) && (board [to + inc] % 100 / 10  != color))
	{
		to += inc;
		
		if (board [to] != 0)
		{
			simulize (start, to);
			return;
		}
		simulize (start, to);
	}
	simulize (start, to);
}
//prepare AI for a new game
public void newgame () 
{
	if (parent != null)
		parent.getAppletContext ().showStatus ("");
	
	//kill AI thread
	if (th != null)
		th.stop ();
	th = null;	
	
	//gemerate original position
	int [] org = {
		99,	99,	99,	99,	99,	99,	99,	99,	99,	99,
		99,	99,	99,	99,	99,	99,	99,	99,	99,	99,
		99,	124,22,	23,	25,	126,23,	22,	124,99,
		99,	21,	21,	21,	21,	21,	21,	21,	21,	99,
		99,	00,	00,	00,	00,	00,	00,	00,	00,	99,
		99,	00,	00,	00,	00,	00,	00,	00,	00,	99,
		99,	00,	00,	00,	00,	00,	00,	00,	00,	99,
		99,	00,	00,	00,	00,	00,	00,	00,	00,	99,
		99,	11,	11,	11,	11,	11,	11,	11,	11,	99,
		99,	114,12,	13,	15,	116,13,	12,	114,99,
		99,	99,	99,	99,	99,	99,	99,	99,	99,	99,
		99,	99,	99,	99,	99,	99,	99,	99,	99,	99 };

	for (int i=0; i < 120; i++) {
		board [i] = org [i];
		graphboard [i] = org [i];
	}	
	repaint ();
	
	movecounter = 0;
	color = 1;	
	deep = 0;
	target = 1;
	genmove ();
	code = 0;
}
//paint chessboard
public void paint (Graphics g) {
	for ( int i = 21; i < 99; i++)
	{
		paintField (i);		
		if ( i%10 == 8)
			i += 2;
	}
}
//paint single field
public void paintField (int index) 
{
	//load graphic reference
	Graphics g = getGraphics ();
	
	//calculate x and y
	int x = (index - 21) % 10;
	int y = (index - 21) / 10;

	//paint ground field
	if ( (x*11 + y) % 2 == 0)
		g.setColor( hell );
	else
		g.setColor( dunkel );

	g.fillRect ( x * 40, y * 40, 40, 40);
	
	//paint piece
	try {
		g.drawImage (pieces [graphboard [index] % 100 - 10], x * 40, y * 40, 40, 40, parent);
	} catch (ArrayIndexOutOfBoundsException e) {}	
}
//AI thread
public void run() {
	//no access to the movelist
	code = 1;

	deep = 0;
	target = 4;
						
	//look for best move
	movecounter = 0;
	genmove ();			

	if (movecounter == 0)	//no moves -> end of game
	{
		if (ischeck () )
			parent.getAppletContext ().showStatus ("white wins!");
		else
			parent.getAppletContext ().showStatus ("game is a draw!");
		return;	
	}
	//execute move
	execute ( move / 100, move % 100 );
	
	//give accesss to the movelist
	code = 0;	
}
//here we simulize the move
public void simulize (int start, int end) {
	if ((board [end] == 99) || (board [end] % 100 / 10 == color))
		return;
		
	if (ababort)	//alpha beta
		return;			
		
	//simulize move
	int orgstart = board [start];
	int orgend = board [end];
		
	board [end] = board [start];
	board [start] = 0;
	
	//change pawn
	if ((board [end] % 10 == 1) && ((end < 29) || (end > 90)))
		board [end] += 4;
		
	if (! ischeck ())
	{
		if (deep == 1) {
			movelist [movecounter] = start * 100 + end;
			movecounter++;			
		}		
	
		//calculate value of this node
		if (target == deep)
			 value = evaluation ();
		else {
			if (color == 1)
				color = 2; 
			else
				color = 1;
		
			genmove ();
			value = minimax [deep + 1];
			
			//change alpha beta field?
			if (deep % 2 != 0)
			{	//computer
				if (value < alphabeta [deep])
					alphabeta [deep] = value;				
			} else {
				//human
				if (value > alphabeta [deep])
					alphabeta [deep] = value;
			}		
								 
			if (color == 1)
				color = 2; 
			else
				color = 1;
		}
		
		//minimax
		if (deep % 2 == 0) 
		{	//human
			if (value > minimax [deep] )
				minimax [deep] = value;
			//alphabeta
			if (value > alphabeta [deep - 1])
				ababort = true;

		} else {
			//computer
			if (value <= minimax [deep] )
			{
				minimax [deep] = value;
				if (deep == 1)
					move = start * 100 + end;
			}
			//alphabeta
			if (value < alphabeta [deep - 1])
				ababort = true;	
		}	
	}
		
	//undo move
	board [start] = orgstart;
	board [end] = orgend;
}
}