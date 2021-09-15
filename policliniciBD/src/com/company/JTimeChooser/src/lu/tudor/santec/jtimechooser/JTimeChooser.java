package com.company.JTimeChooser.src.lu.tudor.santec.jtimechooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

/**
 * @author jens.ferring(at)tudor.lu
 * 
 * The JTimeChooser is a possibility to let the user set the time by typing, 
 * dragging the mouse and / or rotate the mouse wheel.
 */
public class JTimeChooser extends JComponent 
{
	/* ======================================== */
	// 		PUBLIC FINALS
	/* ======================================== */
	
	public static final Date MIDNIGHT = new GregorianCalendar(0, 0, 0, 0, 0, 0).getTime();
	
	public static final Color DEFAULT_HIGHLIGHTING_COLOR = new Color (190, 215, 254);
	
	
	
	/* ======================================== */
	// 		PRIVATE FINALS
	/* ======================================== */
	
	private static final long serialVersionUID = 1L;
	
	private static final String CLOCK_ICON_RESOURCE = "icons/clock.png";
	
	
	
	/* ======================================== */
	// 		PRIVATE MEMBERS
	/* ======================================== */
	
	private final JFormattedTextField timeField;
	
	private TimeChooserModel model;
	
	private JLabel icon;
	
	private boolean showSeconds = true;
	
	
	
	/* ======================================== */
	// 		CONSTRUCTORS
	/* ======================================== */
	
	/**
	 * Builds a JTimeChooser initializing the time with 00:00. 
	 */
	public JTimeChooser ()
	{
		this (MIDNIGHT);
	}
	
	
	/**
	 * Builds a JTimeChooser initializing the time of the given date. 
	 * 
	 * @param time	this date provides the start value and is modified
	 */
	public JTimeChooser (Date time)
	{
		this.setLayout(new BorderLayout());
		
		// initialize model & controller
		model = new TimeChooserModel(this);
		TimeChooserHandler handler = new TimeChooserHandler(model, this);
		
		// initialize the text field
		timeField = new JFormattedTextField();
		initTimeField(handler);
		
		model.setFormat();
		
		icon = new JLabel(new ImageIcon(JTimeChooser.class.getResource(CLOCK_ICON_RESOURCE)));
		setShowIcon(false);
		
		this.add(timeField, BorderLayout.CENTER);
		this.add(icon, BorderLayout.WEST);
		
		model.setTime(time);
	}
	
	
	/* ======================================== */
	// 		INITIALIZATION METHODS
	/* ======================================== */
	
	private void initTimeField (TimeChooserHandler handler)
	{
		timeField.setEnabled(false);
		timeField.setDisabledTextColor(Color.BLACK);
		timeField.setToolTipText("Click on the hours, minutes or seconds and drag the mouse down, " +
				"to increase the time, or drag it up, to decrease the time.");
		
		// add all needed listeners for the text field
		timeField.addMouseListener(handler);
		timeField.addMouseMotionListener(handler);
		timeField.addMouseWheelListener(handler);
		timeField.addFocusListener(handler);
		timeField.addKeyListener(handler);
		timeField.addCaretListener(handler);
		
		// initialize the highlighter
		DefaultHighlighter highlighter = new DefaultHighlighter();
		timeField.setHighlighter(highlighter);
	}
	
	
	
	/* ======================================== */
	// 		GETTER & SETTER
	/* ======================================== */

	/**
	 * @return The text field that contains the time.
	 */
	public JFormattedTextField getTimeField ()
	{
		return timeField;
	}
	
	
	/**
	 * @param c Define the Color which is used to highlight the currently selected TimeUnit.
	 */
	public void setHighlightingColor (Color c)
	{
		model.setPainter(new DefaultHighlightPainter(c));
	}
	
	
	/**
	 * Defines whether the format of JTimeChooser should show seconds or not.
	 * @param showSeconds Shall the seconds be shown?
	 */
	public void setShowSeconds (boolean showSeconds)
	{
		if (this.showSeconds != showSeconds)
		{
			this.showSeconds = showSeconds;
			model.setFormat();
		}
	}
	
	
	/**
	 * @return If the seconds are shown or not.
	 */
	public boolean isShowSeconds ()
	{
		return showSeconds;
	}
	
	
	/**
	 * Defines whether a small clock shall be shown or not. By default it is not shown.
	 * @param show
	 */
	public void setShowIcon (boolean show)
	{
		icon.setVisible(show);
	}
	
	
	/**
	 * Tells whether a small clock is shown or not. By default it is not shown.
	 * @return
	 */
	public boolean isShowIcon ()
	{
		return icon.isVisible();
	}
	
	
	/**
	 * @return The number of hours
	 */
	public int getHours ()
	{
		return model.getTime(Calendar.HOUR_OF_DAY);
	}
	

	/**
	 * @return The number of minutes
	 */
	public int getMinutes ()
	{
		return model.getTime(Calendar.MINUTE);
	}
	

	/**
	 * @return The number of seconds
	 */
	public int getSeconds ()
	{
		return model.getTime(Calendar.SECOND);
	}
	

	/**
	 * You can manually set a new date / time
	 * 
	 * @param time The new date
	 */
	public void setTime (Date time)
	{
		model.setTime(time);
	}
	
	
	/**
	 * @return The time as it is in the text field.
	 */
	public String getFormatedTime ()
	{
		return timeField.getText();
	}
	
	
	/**
	 * @return The date as string, using the short style and the default locale.
	 */
	public String getFormatedDate ()
	{
		return getFormatedDate(getDefaultLocale(), DateFormat.SHORT);
	}
	
	
	/**
	 * @param l The locale to format the date.
	 * @param style The style to format the date.
	 * @return The date as string, using the specified style and the specified locale.
	 */
	public String getFormatedDate (Locale l, int style)
	{
		return DateFormat.getDateInstance(style, l).format(model.getTime());
	}
	
	
	/**
	 * @param pattern The pattern to format the date.
	 * @return The date / time as string, using the specified pattern.
	 */
	public String getFormatedDate (String pattern)
	{
		return new SimpleDateFormat(pattern).format(model.getTime());
	}
	
	
	/**
	 * Replaces the time in the given Date.<br>
	 * This method does NOT change the JTimeChooser!
	 * @param date The Date to be changed
	 */
	public void setTimeOnDate (Date date)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		setTimeOnCalendar(cal);
		date.setTime(cal.getTimeInMillis());
	}
	
	
	/**
	 * Replaces the time in the given Calendar.<br>
	 * This method does NOT change the JTimeChooser!
	 * @param cal The Calendar to be changed
	 */
	public void setTimeOnCalendar (Calendar cal)
	{
		cal.set(Calendar.HOUR_OF_DAY, 	model.getTime(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, 		model.getTime(Calendar.MINUTE));
		if (showSeconds)
			cal.set(Calendar.SECOND, 	model.getTime(Calendar.SECOND));
	}
	
	
	/**
	 * Creates a new Calendar with the data of the given Calendar, 
	 * but replaces the time.<br>
	 * This method does NOT change the JTimeChooser!
	 * @param calendar The Calendar, which data is used.
	 * @return A new Calendar with the defined time.
	 */
	public Calendar getCalendarWithTime (Calendar calendar)
	{
		return getCalendarWithTime(calendar.getTime());
	}
	

	/**
	 * Creates a new Calendar with the data of the given Date, 
	 * but replaces the time.<br>
	 * This method does NOT change the JTimeChooser!
	 * @param date The Date, which data is used.
	 * @return A new Calendar with the defined time.
	 */
	public Calendar getCalendarWithTime (Date date)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		setTimeOnCalendar(cal);
		return cal;
	}
	

	/**
	 * Creates a new Date with the data of the given Date, 
	 * but replaces the time.<br>
	 * This method does NOT change the JTimeChooser!
	 * @param date The Date, which data is used.
	 * @return A new Date with the defined time.
	 */
	public Date getDateWithTime (Date date)
	{
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		setTimeOnCalendar(cal);
		return cal.getTime();
	}
	
	
	
	/**
	 * Adds the listener to the list of listener.<br>
	 * The listener are called whenever the time might be changed.
	 * 
	 * @param listener The TimeChangedListener
	 */
	public void addTimeChangedListener (TimeChangedListener listener)
	{
		model.addTimeChangedListener(listener);
	}
	
	
	/**
	 * Removes the listener of the list of listener
	 * @param listener
	 */
	public void removeTimeChangedListener (TimeChangedListener listener)
	{
		model.removeTimeChangedListener(listener);
	}
}
