/**
 * A very simple vertical text scrolling
 * applet.  Like most Applets, this one
 * squeezes everything into a single class
 * to speed downloading, even though it makes
 * the design really cluttered from a OO
 * point of view.
 * <p>
 * To use this applet, you need to set the
 * following parameters using <param> tags.
 * <br>
 * titleImage - URL for image to go at the top (default: none)
 * <br>
 * font - font typeface (default: "Times")
 * <br>
 * size - font size (default: 11)
 * <br>
 * bold - want bold style font (default: "false")
 * <br>
 * italic - want italic style font (default: "false")
 * <br>
 * center - want lines centered (default: "false")
 * <br>
 * underlineLinks - want links underlined (default: "true")
 * <br>
 * movement - how many pixels to step each period (default: 1)
 *            [negative values to scroll downwards instead
 *             of upwards.]
 * <br>
 * period - animation time period in milliseconds (default: 50) 
 * <br>
 * scrollByLines - set to true to get line-by-line scrolling
 *                default is smooth scrolling (default: false)
 *                [Remember, if scrolling by lines, set period
 *                 to something longer, like 1000.]
 * <br>
 * color - text color as int (default: 000000)
 * <br>
 * linkcolor - text color for links, if any (default: 0000FF)
 * <br>
 * bgcolor - background color as int (default: FFFFFF)
 * <br>
 * margin - edge margin, all four sides (default: 2)
 * <br>
 * padding - padding between each text (default: 1)
 * <br>
 * linkTarget - target window for following links (default: _self)
 * <br>
 * textN - line of text number N (1-1000, dont skip any!)
 *         (default: text1="Hello World!")
 * <br>
 * linkN - link URL corresponding to each text line 
 *         (default: none)
 * <p>
 * In practice, you'll want to experiment with the period and
 * color properties, as well as the applet size and font size,
 * to find a pleasing mix for your application.
 * <p> 
 * Copyright (c) 1999 Neal Ziring - you may use, adapt, modify,
 * subclass, distribute, copy, and sell this applet, in both
 * compiled and binary form, as long as this copyright notice
 * is preserved.
 * <p>
 * @author Neal Ziring, 12/99	    
 */

import java.awt.*;
import java.applet.*;
import java.util.*;
import java.net.URL;

public class VertScrollText extends Applet implements Runnable
{
	protected final static String copyrightNotice = "Copyright (c) 1999 Neal Ziring - you may use this applet in any way you like, as long as this copyright notice is preserved.";

	protected final static int DefaultMovement = 1; // pixels to move
	protected final static int DefaultPeriod = 50;  // milliseconds
	protected final static String DefaultFont = "Times";
	protected final static int DefaultSize = 11;
	protected final static Color DefaultColor = Color.white;
	protected final static Color DefaultLinkColor = Color.blue;
	protected final static Color DefaultBG = Color.black;
	protected final static int DefaultMargin = 2;
	protected final static int DefaultPadding = 2;
	protected final static String DefaultLinkTarget = "_self";

	// member variables related to display appearance
	Font  textfont;
	Color textcolor;
	Color linkcolor;
	Color bgcolor;

	// member variables related to text contents and display
	Vector strings;
	Vector widths;
	Vector links;
	int   movementY;
	int   appletHeight, appletWidth;
	int   windowHeight, windowWidth;
	int   fontAscend, fontDescend;
	int   topOffset;
	int   margin;
	int   padding;
	boolean center;
	boolean underlineLinks;
	boolean scrollByLines;
	int   overallHeight;
	int   initY;
	int   currentY;
	int   lineSpacing;
	Image titleImage;
	String linkTarget;

	// member variables related to double-buffering
	Image buffer;
	Graphics bufferGraphics;

	// member variables related to activation and timing
	int period;
	Thread aThread;
	boolean enabled;
	boolean destroyed;

	/**
	 * init method for this applet, creates the relevant
	 * thread and reads all the parameters.
	 */
	public void init() {
		String textfontName = getParam("font", DefaultFont);
		int textfontSize = getIntParam("size",DefaultSize);
		boolean dobold = new Boolean(getParam("bold","false")).booleanValue();
		boolean doitalic = new Boolean(getParam("italic","false")).booleanValue();
		textfont = new Font(textfontName, 
				((dobold)?(Font.BOLD):(Font.PLAIN))|
				((doitalic)?(Font.ITALIC):(Font.PLAIN)),
				textfontSize);
		movementY = getIntParam("movement", DefaultMovement);
		if (movementY == 0)  movementY = 1;
		period = getIntParam("period", DefaultPeriod);
		margin = getIntParam("margin", DefaultMargin);
		padding = getIntParam("padding", DefaultPadding);
		center = new Boolean(getParam("center","false")).booleanValue();
		underlineLinks = new Boolean(getParam("underlineLinks","true")).booleanValue();
		scrollByLines = new Boolean(getParam("scrollByLines","false")).booleanValue();
		textcolor = getColorParam("color", DefaultColor);
		linkcolor = getColorParam("linkcolor", DefaultLinkColor);
		bgcolor = getColorParam("bgcolor", DefaultBG);
		linkTarget = getParam("linkTarget", DefaultLinkTarget);
		URL titleImageURL = getURLParam("titleImage", null);
		FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(textfont);
		lineSpacing = fm.getHeight() + padding;
		fontAscend = fm.getAscent();
		fontDescend = fm.getDescent();
		if (scrollByLines) {
			movementY *= lineSpacing;
			if (period < 100) period = 750;
		}

		int i = 1;
		strings = new Vector();
		widths = new Vector();
		links = new Vector();
		String textN;
		URL linkN;
		int stringWid;
		do {
			textN = getParam("text" + i, null);
			if (i == 1 && textN == null) textN = "Hello World!";
			if (textN != null) { 
				strings.addElement(textN);
				stringWid = fm.charsWidth(textN.toCharArray(),0,textN.length());
				widths.addElement(new Integer(stringWid));
				linkN = getURLParam("link" + i, null);
				if (linkN != null) links.addElement(linkN);
				else links.addElement("");
			}
			i++;
		} while(textN != null);
		aThread = new Thread(this);
		topOffset = 0;
		appletHeight = size().height;
		windowHeight = appletHeight - (2 * margin);
		appletWidth = size().width;
		windowWidth = appletWidth - (2 * margin);
		overallHeight = strings.size() * lineSpacing;

		initY = ((movementY > 0)?(windowHeight + fontAscend):(-overallHeight));
		currentY = initY;

		setBackground(bgcolor);
		enabled = false;
		destroyed = false;
		titleImage = null;
		topOffset = 0;
		if (titleImageURL != null) {
			try {
				Image tmpImage = getImage(titleImageURL); 
				MediaTracker track = new MediaTracker(this);
				track.addImage(tmpImage,0);
				track.waitForAll(5000);
				if (tmpImage.getHeight(this) > 0) {
					titleImage = tmpImage;
					topOffset = titleImage.getHeight(this);
					windowHeight -= topOffset;
				}
			} catch (Exception ue) { }
		}
		buffer = createImage(windowWidth, windowHeight);
		bufferGraphics = buffer.getGraphics();
		bufferGraphics.setFont(textfont);
		aThread.start();
	}

	/**
	 * Get a parameter value, return default if none
	 * available.
	 */
	public String getParam(String name, String def) {
		String result = getParameter(name);
		return ((result == null)?(def):(result));
	}

	/**
	 * Get an integer parameter value.
	 */
	protected int getIntParam(String name, int def) {
		String result = getParameter(name);
		if (result == null) return def;
		else {
			try { return Integer.parseInt(result); }
			catch (Exception e) { return def; }
		}
	}

	/**
	 * Get a color value
	 */
	protected Color getColorParam(String name, Color def) {
		String result = getParameter(name);
		if (result == null) return def;
		else {
			try { 
				return new Color(Integer.parseInt(result,16)); 
			}
			catch (Exception e) { return def; }
		}
	}

	/**
	 * Get a URL value
	 */
	protected URL getURLParam(String name, URL def) {
		String result = getParameter(name);
		if (result == null) return def;
		else {
			try { 
				return new URL(getCodeBase(), result);
			}
			catch (Exception e) { return def; }
		}
	}

	/**
	 * Paint this applet, just copy the offscreen image
	 * to the body of the applet.
	 */
	public void paint(Graphics g) {
		g.setColor(bgcolor);
		g.fillRect(0,0,appletWidth,appletHeight);
		g.drawImage(buffer, margin, margin + topOffset, this);
		if (titleImage != null) {
			g.drawImage(titleImage, 0, 0, this);
		}
		return;
	}

	/**
	 * Start - enable the applet
	 */
	public void start() {
		currentY = initY;
		synchronized (this) { 
			enabled = true;
			notify();
		}
		return;
	}

	/**
	 * Stop - stop this applet
	 */
	public void stop() {
		synchronized(this) {
			enabled = false;
		}
	}

	/**
	 * Destroy this applet, release resources
	 */
	public void destroy() {
		synchronized(this) {
			enabled = false;
			destroyed = true;
			notify();
		}
	}


	/**
	 * Run this animated applet 
	 */
	public void run() {
		Enumeration te, le;
		int ty = 0;
		int newy = 0;
		String line = null;
		URL link;
		Object linkobj;

		while (!destroyed) {
			// first step, clear the image
			bufferGraphics.setColor(bgcolor);
			bufferGraphics.fillRect(0,0,windowWidth,windowHeight);

			// second step, draw the text
			bufferGraphics.setColor(textcolor);
			int ix;
			Integer linewidth;
			int linex;
			for(ty = currentY, te = strings.elements(), 
					le = links.elements(), ix = 0; 
			te.hasMoreElements();
			ty += lineSpacing, ix++)
			{
				line = te.nextElement().toString();
				linkobj = le.nextElement();
				if ((ty > -lineSpacing) && (ty <= (windowHeight + fontAscend))) {
					if (linkobj instanceof URL) {
						link = (URL)linkobj;
						bufferGraphics.setColor(linkcolor);
					}
					else {
						link = null;
						bufferGraphics.setColor(textcolor);
					}
					linex = margin;
					linewidth = (Integer)(widths.elementAt(ix));
					if (center) {
						linex += (windowWidth - linewidth.intValue())/2;
					}
					bufferGraphics.drawString(line, linex, ty - fontDescend);
					if (link != null && underlineLinks) {
						ty -= fontDescend / 2;
						bufferGraphics.drawLine(linex, ty,
								linex + linewidth.intValue(),
								ty);
					}			
				}
			}

			// third step, draw into the applet itself
			getGraphics().drawImage(buffer, 
					margin, margin + topOffset, 
					this);

			// fourth step, increment currentY by movementY, or wrap
			if ((movementY > 0 && ty > lineSpacing) || 
					(movementY < 0 && ty < (windowHeight + overallHeight)))
			{
				newy = currentY - movementY;
			}
			else 
			{
				newy = initY;
			}

			// last step, maybe sleep, then make sure we are still enabled
			if (enabled && !destroyed) {
				try { Thread.sleep(period); } catch (Exception e) { }
			}
			while(!enabled && !destroyed) {
				synchronized(this) {
					try { wait(); }
					catch (Exception e) { }
				}
			}

			currentY = newy;
		}
	}

	public boolean mouseDown(Event evt, int x, int y) {
		synchronized(this) { enabled = false; }
		return true;
	}

	public boolean mouseUp(Event evt, int x, int y) {
		int wx, wy;
		synchronized(this) { enabled = true; notify(); }

		wx = x - margin;
		wy = y - (topOffset + margin);
		int vy = (wy - currentY) + fontAscend + fontDescend;
		if (vy > 0) {
			int ix = (vy / lineSpacing);
			if (ix < links.size()) {
				Object linkvalue = links.elementAt(ix);
				if (linkvalue instanceof URL) {
					getAppletContext().showStatus("Following link to " + linkvalue.toString());
					getAppletContext().showDocument((URL)linkvalue, linkTarget);
				}
			}
		}
		return true;
	}
}
