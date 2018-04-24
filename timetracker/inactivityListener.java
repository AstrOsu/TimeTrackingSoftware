/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetracker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author GG46195x
 */
class InactivityListener implements ActionListener, AWTEventListener
{
	public final static long KEY_EVENTS = AWTEvent.KEY_EVENT_MASK;

	public final static long MOUSE_EVENTS =
		AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK;

	public final static long USER_EVENTS = KEY_EVENTS + MOUSE_EVENTS;
        
        //public Calendar start; 
        
	private Window window;
	private Action action;
	private int interval;
	private long eventMask;
	private Timer timer = new Timer(0, this);

	/*
	 *  Use a default inactivity interval of 1 minute and listen for
	 *  USER_EVENTS
	 */
	public InactivityListener(Window window, Action action)
	{
		this(window, action, 1);
	}

	/*
	 *	Specify the inactivity interval and listen for USER_EVENTS
	 */
	public InactivityListener(Window window, Action action, int interval)
	{
		this(window, action, interval, USER_EVENTS);
	}

	/*
	 *  Specify the inactivity interval and the events to listen for
	 */
	public InactivityListener(Window window, Action action, int minutes, long eventMask)
	{
		this.window = window;
		setAction( action );
		setInterval( minutes );
		setEventMask( eventMask );
	}

	/*
	 *  The Action to be invoked after the specified inactivity period
	 */
	public void setAction(Action action)
	{
		this.action = action;
	}

	/*
	 *  The interval before the Action is invoked specified in minutes
	 */
	public void setInterval(int minutes)
	{
		setIntervalInMillis(minutes * 60000);
	}

	/*
	 *  The interval before the Action is invoked specified in milliseconds
	 */
	public void setIntervalInMillis(int interval)
	{
		this.interval = interval;
		timer.setInitialDelay(interval);
	}

	/*
	 *	A mask specifying the events to be passed to the AWTEventListener
	 */
	public void setEventMask(long eventMask)
	{
		this.eventMask = eventMask;
	}

	/*
	 *  Start listening for events.
	 */
	public void start()
	{
		timer.setInitialDelay(interval);
                //start = Calendar.getInstance(); 
		timer.setRepeats(false);
		timer.start();
		Toolkit.getDefaultToolkit().addAWTEventListener(this, eventMask);
	}
        
        /*public Calendar getStart()
        {
            return start; 
        }

	/*
	 *  Stop listening for events
	 */
	public void stop()
	{
		Toolkit.getDefaultToolkit().removeAWTEventListener(this);
		timer.stop();
	}

	//  Implement ActionListener for the Timer

        @Override
	public void actionPerformed(ActionEvent e)
	{
		ActionEvent ae = new ActionEvent(window, ActionEvent.ACTION_PERFORMED, "");
		action.actionPerformed(ae);
	}

	//  Implement AWTEventListener

        @Override
	public void eventDispatched(AWTEvent e)
	{
		if (timer.isRunning())
			timer.restart();
	}
}
