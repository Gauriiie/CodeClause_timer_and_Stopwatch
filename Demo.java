package TimerAndStopwatch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
 

//import java.util.*;

 

public class Demo implements ActionListener 
{
	 JFrame fr=new JFrame("My StopWatch");
	 JButton start=new JButton("Start");
	 JButton reset=new JButton("reset");
	 JLabel timeLabel=new JLabel();
	int time=0;
	int sec=0;
	int min=0;
	int hr=0;
	boolean staeted=false;
	String sec_string=String.format("%02d", sec);
	String min_string=String.format("%02d", min);
	String hr_string=String.format("%02d", hr);
	
	Timer timer=new Timer(1000,new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			time=time+1000;
			hr=(time/3600000);
			min=(time/60000)%60;
			sec=(time/1000)%60;
			sec_string=String.format("%02d", sec);
			min_string=String.format("%02d", min);
			hr_string=String.format("%02d", hr);
			
			timeLabel.setText(hr_string+":"+min_string+":"+sec_string);
			
		}
		
	});
	
	Demo()
	{
		 
		timeLabel.setText(hr_string+":"+min_string+":"+sec_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		start.setBounds(100,200,100,50);
		start.setFont(new Font("Ink Free",Font.PLAIN,20));
		start.setFocusable(false);
		start.addActionListener(this);
		
		reset.setBounds(200,200,100,50);
		reset.setFont(new Font("Ink Free",Font.PLAIN,20));
		reset.setFocusable(false);
		reset.addActionListener(this);
		
		fr.add(start);
		fr.add(reset);
		fr.add(timeLabel);
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fr.setSize(400,400);
		fr.setLayout(null);
		fr.setVisible(true);
	}
	 
	
	void stop()
	{
		timer.stop();
		
	}
	void start()
	{
		timer.start();
		
	}
	void reset()
	{
		timer.stop();
		time=0;
		sec=0;
		min=0;
		hr=0;
		sec_string=String.format("%02d", sec);
		min_string=String.format("%02d", min);
		hr_string=String.format("%02d", hr);
		
		timeLabel.setText(hr_string+":"+min_string+":"+sec_string);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==start)
		{
			 
			if(staeted==false)
			{
				staeted=true;
				start.setText("stop");
				start();
			}
			else
			{

				staeted=false;
				start.setText("start");
				stop();
			}
		}
		
		if(e.getSource()==reset)
		{
			staeted=false;
			start.setText("Start");
			reset();
		}
	}

	 
	 


	 
	}

 
