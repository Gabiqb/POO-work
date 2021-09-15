package lu.tudor.santec.jtimechooser;

import java.util.Calendar;

/**
 * @author jens.ferring(at)tudor.lu
 * 
 * This TimeUnit is supposed to keep and select the correct data for a JTimeChooser.<br>
 * It is used for the MouseEvents of the JTimeChooser.
 */
public class TimeUnit
{
	/* ======================================== */
	// 		PUBLIC CONSTANTS
	/* ======================================== */
	
	public static final int NO_TIME_UNIT_SELECTED = -1;
	
	
	
	/* ======================================== */
	// 		PRIVATE CONSTANTS
	/* ======================================== */
	
	private static final int DEFAULT_PIXEL_PER_HOURS 	= 10;
	private static final int DEFAULT_PIXEL_PER_MINUTES 	= 5;
	private static final int DEFAULT_PIXEL_PER_SECONDS 	= 5;

	private static final int DEFAULT_SCROLLS_PER_HOURS 	= 1;
	private static final int DEFAULT_SCROLLS_PER_MINUTES= 1;
	private static final int DEFAULT_SCROLLS_PER_SECONDS= 1;
	
	
	
	/* ======================================== */
	// 		PRIVATE MEMBERS
	/* ======================================== */
	
	private final TimeChooserModel model;

	
	private int timeUnit;
	
	private int value;
	private int rounds;
	
	private int maxValue;
	private int pixelPerUnit;
	private int scrollAmountPerUnit;
	
	
	private int pixelPerHour 		= DEFAULT_PIXEL_PER_HOURS;
	private int pixelPerMinute 		= DEFAULT_PIXEL_PER_MINUTES;
	private int pixelPerSecond 		= DEFAULT_PIXEL_PER_SECONDS;
	
	private int scrollsPerHour 		= DEFAULT_SCROLLS_PER_HOURS;
	private int scrollsPerMinute 	= DEFAULT_SCROLLS_PER_MINUTES;
	private int scrollsPerSecond 	= DEFAULT_SCROLLS_PER_SECONDS;
	
	
	
	/* ======================================== */
	// 		CONSTRUCTOR
	/* ======================================== */
	
	/**
	 * @param chooser The JTimeChooser this TimeUnit keeps the data for.
	 */
	public TimeUnit (TimeChooserModel model)
	{
		this.model = model;
		reset();
		timeUnitChanged();
	}
	
	
	
	/* ======================================== */
	// 		HELP METHODS
	/* ======================================== */
	
	/**
	 * This is called, whenever the setTimeUnit method is called.
	 */
	private void timeUnitChanged ()
	{
		try {
			switch (timeUnit)
			{
			case NO_TIME_UNIT_SELECTED:
//				reset();
				return;
				
			case Calendar.HOUR_OF_DAY:
				pixelPerUnit 		= model.getPixelPerHour();
				scrollAmountPerUnit	= model.getScrollsPerHour();
				maxValue 			= 24;
				break;
				
			case Calendar.MINUTE:
				pixelPerUnit 		= model.getPixelPerMinute();
				scrollAmountPerUnit	= model.getScrollsPerMinute();
				maxValue 			= 60;
				break;
				
			case Calendar.SECOND:
				pixelPerUnit 		= model.getPixelPerSecond();
				scrollAmountPerUnit	= model.getScrollsPerSecond();
				maxValue 			= 60;
				break;
				
			default:
				// a not supported time unit was somehow selected
				throw new Exception("Wrong or not supported time unit " + 
						timeUnit + 
						". The time unit must be one of " +
						Calendar.HOUR_OF_DAY + ", " +
						Calendar.MINUTE + " or " +
						Calendar.SECOND + ".");
			}
			value 				= model.getTime(timeUnit);
		} catch (Exception e)
		{
			reset();
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Resets the data. Should be called after the mouse was released.
	 */
	public void reset ()
	{
		timeUnit			= NO_TIME_UNIT_SELECTED;
		pixelPerUnit 		= 0;
		maxValue 			= 0;
		scrollAmountPerUnit	= 0;
		value				= -1;
		rounds				= 0;
	}
	
	
	
	/* ======================================== */
	// 		GETTER & SETTER
	/* ======================================== */

	/**
	 * @return The current time unit.
	 */
	public int getTimeUnit ()
	{
		return timeUnit;
	}
	
	/**
	 * The caret position is crucial for which time unit is set.
	 * 
	 * @param caretPosition the caret position of the JTimeChooser text field.
	 */
	public void setTimeUnit (int caretPosition)
	{
		/* choose the according value of the Calendar class 
		 * or NO_TIME_UNIT_SELECTED, if the caretPosition is illegal. 
		 */
		int oldTimeUnit = timeUnit;
		if (caretPosition < 0)
			timeUnit = NO_TIME_UNIT_SELECTED;
		else if (caretPosition <= 2)
			timeUnit = Calendar.HOUR_OF_DAY;
		else if (caretPosition <= 5)
			timeUnit = Calendar.MINUTE;
		else //if (caretPosition <= 8)
			timeUnit = Calendar.SECOND;
		
		if (oldTimeUnit != timeUnit)
			// the TimeUnit has changed ...
			timeUnitChanged();
	}
	
	/**
	 * @return is the TimeUnit valid
	 */
	public boolean isTimeUnitValid ()
	{
		return timeUnit != NO_TIME_UNIT_SELECTED;
	}
	
	/**
	 * @return the value of the selected time unit when the time unit was set.
	 */
	public int getValue ()
	{
		return value;
	}
	
	/**
	 * When the users drags the mouse and increases or decreases the value 
	 * of the time unit, the value of the next upper time unit will be changed, 
	 * if the min or max value is crossed. One round counts, how often this 
	 * value is crossed.<br>
	 * 0 means the max or min value wasn't crossed. A negative value counts 
	 * how often the value was lower than 0.
	 * 
	 * @return The number of rounds.
	 */
	public int getRounds ()
	{
		return rounds;
	}
	
	/**
	 * Increases the number of rounds by 1.
	 */
	public void increaseRounds ()
	{
		rounds++;
	}
	
	/**
	 * Decreases the number of rounds by 1.
	 */
	public void decreaseRounds ()
	{
		rounds--;
	}
	
	/**
	 * If this value is crossed, the rounds shall be increased.
	 * 
	 * @return The max value for the set time unit.
	 */
	public int getMaxValue()
	{
		return maxValue;
	}

	/**
	 * @return Defines how many pixels must be dragged, 
	 * to change the value of the time unit by 1.
	 */
	public int getPixelPerUnit()
	{
		return pixelPerUnit;
	}

	/**
	 * @return Defines by what the value is in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public int getScrollAmountPerUnit()
	{
		return scrollAmountPerUnit;
	}

	/**
	 * @return Defines how many pixels must be dragged, 
	 * to change the hours by 1.
	 */
	public int getPixelPerHour()
	{
		return pixelPerHour;
	}

	/**
	 * Sets how many pixels must be dragged to change the hours by 1.
	 * @param pixelPerHour
	 */
	public void setPixelPerHour(int pixelPerHour)
	{
		this.pixelPerHour = pixelPerHour;
	}

	/**
	 * @return Defines how many pixels must be dragged, 
	 * to change the minutes by 1.
	 */
	public int getPixelPerMinute()
	{
		return pixelPerMinute;
	}

	/**
	 * Sets how many pixels must be dragged to change the minutes by 1.
	 * @param pixelPerMinute
	 */
	public void setPixelPerMinute(int pixelPerMinute)
	{
		this.pixelPerMinute = pixelPerMinute;
	}

	/**
	 * @return Defines how many pixels must be dragged, 
	 * to change the seconds by 1.
	 */
	public int getPixelPerSecond()
	{
		return pixelPerSecond;
	}

	/**
	 * Sets how many pixels must be dragged to change the seconds by 1.
	 * @param pixelPerSecond
	 */
	public void setPixelPerSecond(int pixelPerSecond)
	{
		this.pixelPerSecond = pixelPerSecond;
	}

	/**
	 * @return Defines by what value the hours are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public int getScrollsPerHour()
	{
		return scrollsPerHour;
	}

	/**
	 * @param scrollsPerHour The value the hours are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public void setScrollsPerHour(int scrollsPerHour)
	{
		this.scrollsPerHour = scrollsPerHour;
	}

	/**
	 * @return Defines by what value the minutes are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public int getScrollsPerMinute()
	{
		return scrollsPerMinute;
	}

	/**
	 * @param scrollsPerMinute The value the minutes are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public void setScrollsPerMinute(int scrollsPerMinute)
	{
		this.scrollsPerMinute = scrollsPerMinute;
	}

	/**
	 * @return Defines by what value the seconds are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public int getScrollsPerSecond()
	{
		return scrollsPerSecond;
	}

	/**
	 * @param scrollsPerSecond The value the seconds are in- / decreased, 
	 * if the mouse wheel is rotated.
	 */
	public void setScrollsPerSecond(int scrollsPerSecond)
	{
		this.scrollsPerSecond = scrollsPerSecond;
	}
}
