package Simple.Plane.Fighter;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;

import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * An utility class for playing back audio files using Java Sound API. 
 * @author www.codejava.net
 *
 */
public class AudioPlayer implements LineListener, Runnable {
	private static final int SECONDS_IN_HOUR = 60 * 60;
	private static final int SECONDS_IN_MINUTE = 60;
	
	/**
	 * this flag indicates whether the playback completes or not.
	 */
	private boolean playCompleted;

	/**
	 * this flag indicates whether the playback is stopped or not.
	 */
	private boolean isStopped;

	private boolean isPaused;

	private Clip audioClip;

	
	public long getClipSecondLength() {
		return audioClip.getMicrosecondLength() / 1_000_000;
	}
	
	public String getClipLengthString() {
		String length = "";
		long hour = 0;
		long minute = 0;
		long seconds = audioClip.getMicrosecondLength() / 1_000_000;
		
		System.out.println(seconds);
		
		if (seconds >= SECONDS_IN_HOUR) {
			hour = seconds / SECONDS_IN_HOUR;
			length = String.format("%02d:", hour);
		} else {
			length += "00:";
		}
		
		minute = seconds - hour * SECONDS_IN_HOUR;
		if (minute >= SECONDS_IN_MINUTE) {
			minute = minute / SECONDS_IN_MINUTE;
			length += String.format("%02d:", minute);
			
		} else {
			minute = 0;
			length += "00:";
		}
		
		long second = seconds - hour * SECONDS_IN_HOUR - minute * SECONDS_IN_MINUTE;
		
		length += String.format("%02d", second);
		
		return length;
	}

	/**
	 * Play a given audio file.
	 * 
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 */
	void play() throws IOException, InterruptedException {

                URL url = AudioPlayer.class.getResource("/srcmusic/backgroundmusic.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();
		clip.loop();
	}

	/**
	 * Stop playing back.
	 */
	public void stop() {
		isStopped = true;
	}

	public void pause() {
		isPaused = true;
	}

	public void resume() {
		isPaused = false;
	}

	/**
	 * Listens to the audio line events to know when the playback completes.
	 */
	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();
		if (type == LineEvent.Type.STOP) {
			System.out.println("STOP EVENT");
			if (isStopped || !isPaused) {
				playCompleted = true;
			}
		}
	}
	
	public Clip getAudioClip() {
		return audioClip;
	}	

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}