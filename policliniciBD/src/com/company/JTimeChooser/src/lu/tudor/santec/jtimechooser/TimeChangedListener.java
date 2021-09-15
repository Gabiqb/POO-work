package com.company.JTimeChooser.src.lu.tudor.santec.jtimechooser;

/**
 * @author jens.ferring(at)tudor.lu
 * 
 * This listener is called, whenever the date is changed by the JTimeChooser.
 */
public interface TimeChangedListener
{
	/**
	 * The time could have been changed.
	 * 
	 * @param event The TimeChangedEvent that keeps all important data for this event.
	 */
	public void timeChanged (TimeChangedEvent event);
}
