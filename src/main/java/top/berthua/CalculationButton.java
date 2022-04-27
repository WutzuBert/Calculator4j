package top.berthua;


import javax.imageio.ImageIO;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class CalculationButton extends JButton {
    private ImageIcon icon;
    private ImageIcon selectedIcon;
    private ImageIcon pressedIcon;
    public CalculationButton(String title,JTextField textField,JTextField textField2,JFrame parentFrame){
        super();
        this.icon = new ImageIcon(Main.class.getResource("/jsicon.png"));
        this.selectedIcon = new ImageIcon(Main.class.getResource("/jsselect.png"));
        this.pressedIcon = new ImageIcon(Main.class.getResource("/jspress.png"));
        setText(title);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setSize(icon.getIconWidth(),icon.getIconHeight());
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = textField.getText();
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
                try {
                    int re = (int) engine.eval(content);
                    textField2.setText("="+re);
                } catch (ScriptException ex) {
                    ex.printStackTrace();
                }
            }
        });
        try{
            bi = ImageIO.read(Main.class.getResource("/jsicon.png"));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"可能是图片文件不存在","ImageIO异常",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        setEnabled(true);
    }
    @Override
    public void paintComponent(Graphics g){
        if(this.getModel().isRollover()){
            g.drawImage(selectedIcon.getImage(),0,0,this);
            if(this.getModel().isPressed()){
                g.drawImage(pressedIcon.getImage(),0,0,this);
            }
        }else {
            g.drawImage(icon.getImage(),0,0,this);
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
