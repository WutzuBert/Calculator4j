package top.berthua;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class CustomButton extends JButton {
    private ImageIcon imageIcon;
    private ImageIcon pressedIcon;
    private ImageIcon selectedIcon;
    public CustomButton(String title,JTextField textField){
        super();
        this.imageIcon = new ImageIcon(Main.class.getResource("/icon.png"));
        this.pressedIcon = new ImageIcon(Main.class.getResource("/press.png"));
        this.selectedIcon = new ImageIcon(Main.class.getResource("/select.png"));
        setBorderPainted(false);
        setContentAreaFilled(false);
        if(title.equals("C")){
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText("0");
                }
            });
        }if(title.equals("←")){
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String content = textField.getText();
                    content = content.substring(0,content.length()-1);
                    textField.setText(content);
                }
            });
        }else{
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = textField.getText()+title;
                textField.setText(content);
            }
        });
        }
        setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
        setText(title);
        try{
            bi = ImageIO.read(Main.class.getResource("/icon.png"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"可能是图片文件不存在","ImageIO异常",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        if(this.getModel().isRollover()){
            g.drawImage(selectedIcon.getImage(),0,0,this);
            if(this.getModel().isPressed()){
                g.drawImage(pressedIcon.getImage(),0,0,this);
            }
        }else {
            g.drawImage(imageIcon.getImage(),0,0,this);
        }
        super.paintComponent(g);
    }
    BufferedImage bi;
    int rgb,alpha;
    @Override
    public boolean contains(int x,int y){
        try{
            rgb = bi.getRGB(x,y);
            alpha = (rgb>>24)&0xFF;
            return alpha != 0;
        }catch(ArrayIndexOutOfBoundsException e){
            //当搜索到透明区域时，就getRGB抛出下表越界异常
            return false;
        }
    }
}
