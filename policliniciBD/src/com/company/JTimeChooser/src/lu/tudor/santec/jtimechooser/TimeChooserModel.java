package com.company.JTimeChooser.src.lu.tudor.santec.jtimechooser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.MaskFormatter;


/**
 * @author jens.ferring(at)tudor.lu
 * 
 * This is the model in the MVC-patter of the JTimeChooser.
 * All data is hold and spread from here.
 */
public class TimeChooserModel
{
	/* ======================================== */
	// 		PRIVATE FINALS
	/* ======================================== */
	
	private static final long serialVersionUID = 1L;
	
	private static final Pattern TIME_PATTERN_WITHOUT_SECONDS 		= Pattern.compile ("(\\d{2}):(\\d{2})$",Pattern.CASE_INSENSITIVE);
//	private static final Pattern TIME_PATTERN_WITHOUT_SECONDS 		= Pattern.compile ("^([01]?[0-9]|2[0-3]):(\\d{2})$",Pattern.CASE_INSENSITIVE);
	private static final Pattern TIME_PATTERN_WITH_SECONDS 			= Pattern.compile ("(\\d{2}):(\\d{2}):(\\d{2})$",Pattern.CASE_INSENSITIVE);
//	private static final Pattern TIME_PATTERN_WITH_SECONDS 			= Pattern.compile ("^([01]?[0-9]|2[0-3]):(\\d{2}):(\\d{2})$",Pattern.CASE_INSENSITIVE);
	
	private static final String TIME_PATTERN_STRING_WITHOUT_SECONDS	= "HH:mm";
	private static final String TIME_PATTERN_STRING_WITH_SECONDS	= "HH:mm:ss";
	
	private static final String TIME_FORMAT_WITHOUT_SECONDS 		= "##:##";
	private static final String TIME_FORMAT_WITH_SECONDS 			= "##:##:##";
	
	

	/* ======================================== */
	// 		PRIVATE MEMBERS
	/* ======================================== */
	
	private final JTimeChooser view;
	
	private final TimeUnit timeUnit;

	private final Calendar time = new GregorianCalendar();

	
	private DateFormat formatter;
	
	private Pattern parsePattern;
	
	private HighlightPainter painter = new DefaultHighlightPainter(JTimeChooser.DEFAULT_HIGHLIGHTING_COLOR);
	
	
	private List<TimeChangedListener> listener = new LinkedList<TimeChangedListener>();
	private TimeChangedEvent lastChangeEvent;
	

	/* ======================================== */
	// 		CONSTRUCTOR
	/* ======================================== */
	
	public TimeChooserModel (JTimeChooser timeChooser)
	{
		this.view = timeChooser;
		this.timeUnit = new TimeUnit(this);
	}
	
	
	
	/* ======================================== */
	// 		GETTER & SETTER
	/* ======================================== */
	
	/**
	 * @return The TimeUnit that keeps the data needed for dragging
	 */
	public TimeUnit getTimeUnit ()
	{
		return timeUnit;
	}
	
	
	/**
	 * @return The Calendar that keeps the time data
	 */
	public Calendar getTime ()
	{
		return time;
	}
	
	
	/**
	 * Like the method get(int) of the class Calendar.
	 * 
	 * @param field A field of the class Calendar.<br>
	 * Normally it should be HOUR_OF_DAY, MINUTE or SECOND.
	 * @return The int value of the time unit, specified by the field.
	 */
	public int getTime (int field)
	{
		return time.get(field);
	}
	
	
	/**
	 * You can manually set a new date / time
	 * 
	 * @param time The new date
	 */
	public void setTime (Date time)
	{
		synchronized (this)
		{
			this.time.setTimeInMillis(time.getTime());
			view.getTimeField().setValue(formatter.format(time));
			
			timeUnit.reset();
			callListener(TimeChangedEvent.TIME_CHANGED_BY_SET_METHOD);
		}
	}


	/**
	 * @return Defines how many pixels must be dragged, 
	 * to change the hours by 1.
	 */
	public int getPixelPerHour()
	{
		return timeUnit.getPixelPerHour();
	}
	/**
	 * Sets how many pixels must be dragged to change the hours by 1.
	 * @param pixelPerHour
	 */
	public void setPixelPerHour(int pixelPerHour)
	{
		this.timeUnit.setPixelPerHour(pixelPerHour);
	}


	/**
	 * @return Defines how many pixels must be dragged, 
	 * to change the minutes by 1.
	 */
	public int getPixelPerMinute()
	{
		return timeUnit.getPixelPerMinute();
	}
	/**
	 * Sets how many pixels must be dragged to change the minutes by 1.
	 * @param pixelPerMinute
	 */
	public void setPixelPerMinute(int pixelPerMinute)
	{
		this.timeUnit.setPixelPerMinute(pixelPerMinute);
	}


	/**
	 * @return Defines how many pixels must be dragged, 
	 * to change the seconds by 1.
	 */
	public int getPixelPerSecond()
	{
		return timeUnit.getPixelPerSecond();
	}
	/**
	 * Sets how many pixels must be dragged to change the seconds by 1.
	 * @param pixelPerSecond
	 */
	public void setPixelPerSecond(int pixelPerSecond)
	{
		this.timeUnit.setPixelPerSecond(pixelPerSecond);
	}


	/**
	 * @return Defines by what value the hours are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public int getScrollsPerHour()
	{
		return timeUnit.getScrollsPerHour();
	}
	/**
	 * @param scrollsPerHour The value the hours are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public void setScrollsPerHour(int scrollsPerHour)
	{
		this.timeUnit.setScrollsPerHour(scrollsPerHour);
	}


	/**
	 * @return Defines by what value the minutes are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public int getScrollsPerMinute()
	{
		return timeUnit.getScrollsPerMinute();
	}
	/**
	 * @param scrollsPerMinute The value the minutes are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public void setScrollsPerMinute(int scrollsPerMinute)
	{
		this.timeUnit.setScrollsPerMinute(scrollsPerMinute);
	}


	/**
	 * @return Defines by what value the seconds are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public int getScrollsPerSecond()
	{
		return timeUnit.getScrollsPerSecond();
	}
	/**
	 * @param scrollsPerSecond The value the seconds are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public void setScrollsPerSecond(int scrollsPerSecond)
	{
		this.timeUnit.setScrollsPerSecond(scrollsPerSecond);
	}
	
	
	/**
	 * @return The Pattern that defines, which characters are allowed in the text field.
	 */
	public Pattern getPattern ()
	{
		return parsePattern;
	}
	
	
	/**
	 * @return The Format that defines which characters are fix and which may be edited.
	 */
	public DateFormat getFormat ()
	{
		return formatter;
	}
	
	
	/**
	 * If the format was changed or needs to be initialized, call this method.
	 */
	public void setFormat () 
	{
		String format;
		if (view.isShowSeconds())
		{
			format = TIME_FORMAT_WITH_SECONDS;
			formatter = new SimpleDateFormat(TIME_PATTERN_STRING_WITH_SECONDS);
			parsePattern = TIME_PATTERN_WITH_SECONDS;
		}
		else
		{
			format = TIME_FORMAT_WITHOUT_SECONDS;
			formatter = new SimpleDateFormat(TIME_PATTERN_STRING_WITHOUT_SECONDS);
			parsePattern = TIME_PATTERN_WITHOUT_SECONDS;
		}
		
		MaskFormatter formatter = null;
		
		try {
			formatter = new MaskFormatter (format);
			formatter.setAllowsInvalid(false);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		view.getTimeField().setFormatterFactory(new DefaultFormatterFactory(formatter));
	}
	
	
	/**
	 * @return The Painter that defines the highlighting color.
	 */
	public HighlightPainter getPainter ()
	{
		return painter;
	}
	
	
	/**
	 * @param painter The Painter that defines the highlighting color.
	 */
	public void setPainter (HighlightPainter painter)
	{
		this.painter = painter;
	}
	
	
	
	/* ======================================== */
	// 		TIME CHANGED LISTENER METHODS
	/* ======================================== */
	/**
	 * Adds the listener to the list of listener.<br>
	 * The listener are called whenever the time might be changed.
	 * 
	 * @param listener The TimeChangedListener
	 */
	public void addTimeChangedListener (TimeChangedListener listener)
	{
		this.listener.add(listener);
	}
	
	
	/**
	 * Removes the listener of the list of listener
	 * @param listener
	 */
	public void removeTimeChangedListener (TimeChangedListener listener)
	{
		this.listener.remove(listener);
	}
	
	
	/**
	 * Calls the timeChanged-method of all listener.
	 * @param reason The reason, why the listener are called.
	 */
	public void callListener (int reason)
	{
		boolean modified = true;
		Date time = this.time.getTime();
		
		if (lastChangeEvent != null)
			modified = lastChangeEvent.getTime().getTime() != time.getTime();
		
		TimeChangedEvent event = new TimeChangedEvent(view, time, reason, modified);
		lastChangeEvent = event;
		for (TimeChangedListener l : listener)
		{
			l.timeChanged(event);
		}
	}
}
