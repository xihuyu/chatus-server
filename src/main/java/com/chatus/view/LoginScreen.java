package com.chatus.view;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.chatus.domain.User;
import com.chatus.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gaopan on 16/5/28.
 * 登陆界面
 */
@SuppressWarnings("resource")
public class LoginScreen extends JFrame {
	
    /**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	
	//定义需要的组件
    JLabel jlb_name,jlb_pwd;
    JTextField jtf_name;
    JPasswordField jpf_pwd;
    JButton jb_login; //登陆按钮
    JPanel jp_login,jp_center;
    static UserService userService = null;
    
    static {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        context.start();
        userService = (UserService)context.getBean("userService");
    }
    

    public LoginScreen() {
        jlb_name = new JLabel("用户名", JLabel.CENTER);
        jlb_pwd = new JLabel("密码", JLabel.CENTER);

        jp_login = new JPanel();
        jtf_name = new JTextField();
        jpf_pwd = new JPasswordField();

        jb_login = new JButton("登陆");

        jp_center = new JPanel(new GridLayout(2, 2));
        jp_center.add(jlb_name);
        jp_center.add(jtf_name);
        jp_center.add(jlb_pwd);
        jp_center.add(jpf_pwd);

        this.setTitle("我们聊天");

        this.add(jp_center, "North");

        jb_login.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                
                String name = jtf_name.getText().toString();
                String uPwd = jpf_pwd.getText().toString();
                User user = userService.findUserByName(name);
                if(user != null) {
                	if(user.getUserPwd().equals(uPwd)) {
                		dispose();
                        new QqFriendListScreen(user);
                	}
                } else {
                	JOptionPane.showMessageDialog(jp_center, "用户名密码错误");
                }
            }
        });

        jp_login = new JPanel();
        jp_login.add(jb_login, "South");
        this.add(jp_login);
        this.setBackground(Color.GREEN);
        this.setSize(285, 150);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @SuppressWarnings({"unused"})
	public static  void main(String [] args) {
        LoginScreen screen = new LoginScreen();
    }

}
