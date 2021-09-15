package lu.tudor.santec.jtimechooser;

import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Calendar;
import java.util.regex.Matcher;

import javax.swing.JFormattedTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.Position;

/**
 * @author jens.ferring(at)tudor.lu
 * 
 * The Controller in the MVC-patter of the JTimeChooser. 
 * All events, that happen to the text field of the time chooser are 
 * recognized and handled here.
 */
public class TimeChooserHandler implements MouseListener, 
											MouseMotionListener, 
											MouseWheelListener, 
											FocusListener, 
											KeyListener,
											CaretListener
{
	/* ======================================== */
	// 		PRIVATE CONSTANTS
	/* ======================================== */
	
//	private static final Cursor HOVER_CURSOR 	= Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
//	private static final Cursor DRAG_CURSOR 	= Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
	
	
	
	/* ======================================== */
	// 		PRIVATE MEMBERS
	/* ======================================== */
	
	private final TimeChooserModel model;
	
	private final JTimeChooser view;

	
	private int caretPositionWhenMousePressed;
	
//	private Cursor defaultCursor;
	
	
	
	/* ======================================== */
	// 		CONSTRUCTOR
	/* ======================================== */
	
	public TimeChooserHandler (TimeChooserModel model, JTimeChooser view)
	{
		this.model = model;
		this.view = view;
	}

	
	
	/* ======================================== */
	// 		LISTENER EVENTS
	/* ======================================== */
	
	public void mouseClicked(MouseEvent e) 
	{
		if (!e.isPopupTrigger())
			if (e.getClickCount() > 1)
				view.getTimeField().setEnabled(true);
	}
	
	public void mouseReleased(MouseEvent e) 
	{
		if (!e.isPopupTrigger())
			if (e.getClickCount() < 2)
			{
				model.callListener(TimeChangedEvent.TIME_CHANGED_BY_MOUSE_RELEASED);
			}
		
		JTextComponent timeField = view.getTimeField();
		if (	   e.getX() > timeField.getWidth()
				|| e.getY() > timeField.getHeight()
				|| e.getX() < 0
				|| e.getY() < 0)
			timeField.getHighlighter().removeAllHighlights();
	}
	
	
	public void mousePressed(MouseEvent e) 
	{
		TimeUnit timeUnit = model.getTimeUnit();
		
		timeUnit.reset();
		if (!e.isPopupTrigger())
			if (e.getClickCount() < 2)
			{
				caretPositionWhenMousePressed = getMousePositionInText(e);
				timeUnit.setTimeUnit(caretPositionWhenMousePressed);
			}
	}
	
	
	public void mouseMoved(MouseEvent e) 
	{
		// highlight the current phase
		highlightTimeUnit(e);
	}
	
	
	public void mouseExited(MouseEvent e) 
	{
		view.getTimeField().getHighlighter().removeAllHighlights();
	}
	
	
	public void mouseDragged(MouseEvent e)
	{
		if (setTime(e))
			model.callListener(TimeChangedEvent.TIME_CHANGED_BY_MOUSE_DRAGGED);
		
		highlightTimeUnit(caretPositionWhenMousePressed);
	}

	
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		if (setTime(e))		
			model.callListener(TimeChangedEvent.TIME_CHANGED_BY_MOUSE_WHEEL);
		highlightTimeUnit(e);
	}
	
	
	public void focusLost(FocusEvent e)
	{
		view.getTimeField().setEnabled(false);
		setTime();
		model.callListener(TimeChangedEvent.TIME_CHANGED_BY_FOCUS_LOST);
		model.getTimeUnit().reset();
	}
	
	
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyChar() == KeyEvent.VK_ESCAPE
				|| e.getKeyChar() == KeyEvent.VK_TAB)
		{
			view.getTimeField().setEnabled(false);
			setTime();
			model.callListener(TimeChangedEvent.TIME_CHANGED_BY_EXIT_KEY_EVENT);
			model.getTimeUnit().reset();
		}
	}


	public void caretUpdate(CaretEvent e)
	{
		model.getTimeUnit().setTimeUnit(e.getMark());
		model.callListener(TimeChangedEvent.TIME_CHANGED_BY_CARET_EVENT);
	}
	
	
	
	/* ---------------------------------------- */
	// UNNEEDED LISTENER EVENTS
	// These methods are not used, but need to be implemented
	/* ---------------------------------------- */
	public void mouseEntered(MouseEvent e) {}
	public void focusGained(FocusEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	
	

	/* ======================================== */
	// 		HELP METHODS
	/* ======================================== */
	
	private int getMousePositionInText (MouseEvent event)
	{
		if (!(event.getSource() instanceof JTextComponent))
			return -1;
		
		JTextComponent component = (JTextComponent)event.getSource();
		Point pt = new Point(event.getX(), event.getY());
		Position.Bias[] biasRet = new Position.Bias[1];
		int pos = component.getUI().viewToModel(component, pt, biasRet);
		
		return pos;
	}
	
	
	private void highlightTimeUnit (MouseEvent event)
	{
		int pos = getMousePositionInText(event);
		highlightTimeUnit(pos);
	}
	
	
	private void highlightTimeUnit (int caretPosition)
	{
		int startIndex;
		int endIndex;
		
		if (caretPosition < 0)
			// not valid
			return;
		
		if (caretPosition <= 2)
		{
			// hours are selected
			startIndex 	= 0;
			endIndex 	= 2;
		} 
		else if (caretPosition <= 5)
		{
			// minutes are selected
			startIndex 	= 3;
			endIndex 	= 5;
		} 
		else if (caretPosition <= 8)
		{
			// seconds are selected
			startIndex 	= 6;
			endIndex 	= 8;
		} 
		else
			// not valid
			return;
		
		JFormattedTextField timeField = view.getTimeField();
		Highlighter highlighter = timeField.getHighlighter();
		try
		{
			highlighter.removeAllHighlights();
			highlighter.addHighlight(startIndex, endIndex, model.getPainter());
		} catch (BadLocationException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Used when moving the mouse wheel.
	 * 
	 * @param event The MouseWheelEvent taken to calculate the time.
	 * @return <code>true</code> if the time was changed successfully, else <code>false</code>
	 */
	private boolean setTime (MouseWheelEvent event)
	{
		TimeUnit timeUnit 	= model.getTimeUnit();
		Calendar time 		= model.getTime();
		int pos 			= getMousePositionInText(event);
		
		timeUnit.setTimeUnit(pos);
		
		int wheelRotations 	= event.getWheelRotation();
		int amountPerUnit 	= timeUnit.getScrollAmountPerUnit();
		int field 			= timeUnit.getTimeUnit();
		int value 			= time.get(field) + wheelRotations * amountPerUnit;
		
		time.set(field, value);
		view.getTimeField().setValue(model.getFormat().format(time.getTime()));
		
		return true;
	}
	
	
	/**
	 * Used when dragging the mouse.
	 * 
	 * @param event The MouseEvent taken to calculate the time.
	 * @return <code>true</code> if the time was changed successfully, else <code>false</code>
	 */
	private boolean setTime (MouseEvent event)
	{
		TimeUnit timeUnit = model.getTimeUnit();
		JFormattedTextField timeField = view.getTimeField();
		Calendar time = model.getTime();
		
		int y = event.getY();
		
		if (!timeUnit.isTimeUnitValid())
			return false;
		
		if (y >= 0)
		{
			y -= timeField.getHeight();
			if (y < 0)
				y = 0;
		}
		
		// set the parameter for calculation
		int pixelPerUnit = timeUnit.getPixelPerUnit();
		int maxValue = timeUnit.getMaxValue();
		
		// calculate the new time value for the clicked time unit
		int value = timeUnit.getValue() + y / pixelPerUnit - maxValue * timeUnit.getRounds();
		
//		System.out.println(value+" = "+timeUnit.getValue()+" + "+y+" / "+pixelPerUnit+" - "+maxValue+" * "+timeUnit.getRounds());
		
		
		time.set(timeUnit.getTimeUnit(), value);
		
		if (value < 0)
			timeUnit.decreaseRounds();
		else if (value >= maxValue)
			timeUnit.increaseRounds();
		
		timeField.setValue(model.getFormat().format(time.getTime()));
		return true;
	}
	
	
	/**
	 * Used when typing the date.<br>
	 * The entered text is checked and transfered to the date.
	 */
	private void setTime ()
	{
		// Thanks @nmack
		int hour;
		int minute;
		int second = model.getTime().get(Calendar.SECOND);
		
		Matcher matcher = model.getPattern().matcher(view.getTimeField().getText());
		if (matcher.matches())
		{
			hour = Integer.parseInt(matcher.group(1));
			minute = Integer.parseInt(matcher.group(2));
			if (view.isShowSeconds())
				second = Integer.parseInt(matcher.group(3));
		}
		else
		{
			hour = model.getTime().get(Calendar.HOUR_OF_DAY);
			minute = model.getTime().get(Calendar.MINUTE);
			if (view.isShowSeconds())
				second = model.getTime().get(Calendar.SECOND);
		}
		
		model.getTime().set(model.getTime().get(Calendar.YEAR),
				model.getTime().get(Calendar.MONTH),
				model.getTime().get(Calendar.DAY_OF_MONTH),
				hour, minute, second);
		
		view.getTimeField().setValue(model.getFormat().format(model.getTime().getTime()));
	}
}
