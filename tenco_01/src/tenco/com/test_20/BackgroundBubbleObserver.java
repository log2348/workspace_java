package tenco.com.test_20;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 쓰레드로 만들지 않음(느려지기 때문)
public class BackgroundBubbleObserver {
	
	private static final int LEFT_XPOINT = 0;
	private static final int RIGHT_XPOINT = 60;
	private static final int CENTER_TOP = 25;
	
	private BufferedImage image;
	private Bubble bubble;
	
	// Color를 멤버변수로 만드는 게 좋은가? --> 지역변수로 쓰는 게 더 좋다(범용해서 쓸 일이 없기 때문에)
	// 리팩토링 과정 연습	
	public BackgroundBubbleObserver(Bubble bubble) {
		this.bubble = bubble;
		
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
	}
	
	public boolean checkLeftWall() {
		// 1단계
		return isCrashColor(LEFT_XPOINT);
	}
	
	public boolean checkRightWall() {
		// 2단계
		return isCrashColor(RIGHT_XPOINT);
	}
	
	public boolean checkTopWall() {
		// 3단계
		return isCrashColor(CENTER_TOP);
	}
	
	private boolean isCrashColor(int correctionPoint) {
		Color topColor = new Color(image.getRGB(bubble.getX() + correctionPoint, bubble.getY()));
		// color 빨강 --> 외벽 충돌
		if(topColor.getRed() == 255 && topColor.getGreen() == 0 && topColor.getBlue() == 0) {
			return true;
		}
		return false;
	}
	
}
