package lu.tudor.santec.jtimechooser;

import java.util.Date;

import javax.swing.JComponent;

/**
 * @author jens.ferring(at)tudor.lu
 *
 */
public class TimeChangedEvent
{
	private static final long serialVersionUID = 1L;
	
	
	/* ======================================== */
	// 		PUBLIC CONSTANTS
	/* ======================================== */
	
	public static final int TIME_CHANGED_BY_MOUSE_RELEASED 	= 0;
	public static final int TIME_CHANGED_BY_MOUSE_DRAGGED 	= 1;
	public static final int TIME_CHANGED_BY_FOCUS_LOST 		= 2;
	public static final int TIME_CHANGED_BY_EXIT_KEY_EVENT 	= 3;
	public static final int TIME_CHANGED_BY_CARET_EVENT 	= 4;
	public static final int TIME_CHANGED_BY_MOUSE_WHEEL 	= 5;
	public static final int TIME_CHANGED_BY_SET_METHOD 		= 6;
	
	
	
	/* ======================================== */
	// 		PRIVATE MEMBERS
	/* ======================================== */
	
	private JComponent source;
	
	private Date time;
	
	private Date happened = new Date();
	
	private int timeChangedBy;
	
	private boolean modified;

	
	
	/* ======================================== */
	// 		CONSTRUCTOR
	/* ======================================== */
	
	/**
	 * Used by the JTimeChooser, when time is changed.
	 * 
	 * @param source The component, that caused the event
	 * @param time The time, set in the JTimeChooser
	 * @param timeSet Specifies, why the time is changed. Use one of the TIME_CHANGED_BY-constants
	 */
	public TimeChangedEvent(JComponent source, Date time, int timeChangedBy, boolean modified)
	{
		this.source 		= source;
		this.time 			= time;
		this.timeChangedBy 	= timeChangedBy;
		this.modified 		= modified;
	}
	
	

	/* ======================================== */
	// 		GETTER & SETTER
	/* ======================================== */
	
	/**
	 * The JComponent, that caused this event. Normally it should be the JTimeChooser
	 * @return The component that caused this event
	 */
	public JComponent getSource()
	{
		return source;
	}
	
	/**
	 * The new time value normally from the JTimeChooser.
	 * @return The time set in the editor
	 */
	public Date getTime()
	{
		return time;
	}
	
	/**
	 * The time at which the event happened.
	 * @return The system time, at which the event happened 
	 */
	public Date getEventTime()
	{
		return happened;
	}
	
	/**
	 * Specifies why the time was changed.
	 * @return one of the TIME_CHANGED_BY-constants.
	 */
	public int getTimeWasChangedReason()
	{
		return timeChangedBy;
	}
	
	/**
	 * @return Specifies, whether the time was modified since the call of this component
	 */
	public boolean isTimeModified ()
	{
		return modified;
	}
}
