package com.mycompany.a3;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound {
	private Media m;
	private int timeStamp = 0;
	
//	public Sound(String fileName) {
//		try{
//			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
//			System.out.println(is.toString());
//			m = MediaManager.createMedia(is, "audio/wav");
//			m.setVolume(1000);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	public Sound(String fileName) {
		try{
			m = MediaManager.createBackgroundMedia("src/" + fileName);
			m.setVolume(10);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void pause() {
		this.timeStamp = m.getTime();
		m.pause();
	}

	public void play() {
		m.setTime(timeStamp);
		m.play();
	}
	public void run() {
		m.setTime(timeStamp);
		m.play();
		
		
	}
	
	
	
//	private Media m;
//	public Sound(String fileName) {
//		try{
//			InputStream is = Display.getInstance().getResourceAsStream(getClass(),
//					"/"+fileName);
//			m = MediaManager.createMedia(is, "audio/wav");
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	public void play() {
//	//start playing the sound from time zero (beginning of the sound file)
//	m.setTime(0);
//	m.play();
//	}

}
