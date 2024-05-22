package config;
import java.awt.Color;    
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundPanel extends JPanel {
    
    private Color backgroundColor = new Color(27, 57,77); //DIRI IBUTANG ANG COLOR CODE

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint(); 
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        int cornerRadius = 30; 
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);
        
        g2d.dispose();
    }

}