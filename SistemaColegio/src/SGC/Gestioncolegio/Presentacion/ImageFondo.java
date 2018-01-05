package SGC.Gestioncolegio.Presentacion;

//import java.awt.Graphics;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;

//public class ImageFondo extends JPanel{
//    private Image fondo=null;
//    @Override
//    protected void paintComponent(Graphics g){
//        super.paintComponent(g);
//        g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
//        setOpaque(false);
//    }
//    
//    public void setImage(String image){
//        if (image!=null) {
//            fondo=new ImageIcon(getClass().getResource(image)).getImage();
//        }
//    }
//}
  public class ImageFondo implements Border{
      public BufferedImage back;
      
      public ImageFondo(){
          try {
              URL imagePath = new URL(getClass().getResource("/Iconos/colegio.png").toString());
              back = ImageIO.read(imagePath);
          } catch (Exception e) {
          }
      }
      
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
          g.drawImage(back,(x + (width - back.getWidth())/2),(y + (height - back.getHeight())/2),null);          
      }
      
      public Insets getBorderInsets(Component c){
          return new Insets(0, 0, 0, 0);
      }
      
      public boolean isBorderOpaque(){
          return false;
      }
  }
  
      
  