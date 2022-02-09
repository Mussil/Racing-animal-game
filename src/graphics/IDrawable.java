package graphics;

import java.awt.Graphics;

public interface IDrawable {
	public final static String PICTURE_PATH = "…";
	public void loadImages(String nm1);
	public void drawObject (Graphics g);
}
