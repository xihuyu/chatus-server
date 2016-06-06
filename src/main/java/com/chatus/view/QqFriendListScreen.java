package com.chatus.view;

import javax.swing.*;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chatus.domain.Friends;
import com.chatus.domain.User;
import com.chatus.service.FriendsService;
import com.chatus.service.UserService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaopan on 16/5/28.
 * 好友列表界面
 */
@SuppressWarnings("resource")
public class QqFriendListScreen extends JFrame implements ActionListener,MouseListener {

    /**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;
	
	//卡片布局
    JPanel jphy1,jphy2,jphy3;
    JButton jphy1_jb1;
    JScrollPane jsp1;
    static FriendsService friendsService;
    static UserService userService;
    static {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        context.start();
        friendsService = (FriendsService)context.getBean("friendsService");
        userService = (UserService)context.getBean("userService");
    }
    
    @SuppressWarnings("unused")
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setUserName("gaopan");
		user.setUserPwd("123");
		QqFriendListScreen screen = new QqFriendListScreen(user);
	}

    public QqFriendListScreen(User user) {
        //处理第一张卡片
        jphy1 = new JPanel(new BorderLayout());
        jphy2 = new JPanel(new GridLayout(50, 1, 4,4));
        jphy1_jb1 = new JButton("我的好友");
        
        
        List<Friends> friendsList = friendsService.findFriends(user.getId());
        
        System.out.println(friendsList.size());
        JLabel [] jlbs = null;
        List<String> names = new ArrayList<String>();
        names.add(user.getUserName());
        
        if(CollectionUtils.isNotEmpty(friendsList)) {
            
            for(Friends friend : friendsList) {
                User tempUser = userService.findUserById(friend.getToId());
                System.out.println("名字为:" + tempUser.getUserName());
                names.add(tempUser.getUserName());
            }
            jlbs = new JLabel[names.size()];
        }
       
        for(int  i=0;i<names.size();i++) {
        	jlbs[i] = new JLabel(names.get(i), new ImageIcon("images/mm.jpg"),JLabel.LEFT);
        	jlbs[i].addMouseListener(this);
        	jphy2.add(jlbs[i]);
        }
        jsp1 = new JScrollPane(jphy2);
        //加入面板
        jphy1.add(jphy1_jb1, "North");
        jphy1.add(jsp1, "Center");

        this.add(jphy1, "Center");
        this.setSize(140, 400);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

        //响应鼠标点击事件
        if(e.getClickCount() ==2) {
            //如果是双击
            String friendNo = ((JLabel)e.getSource()).getText();
            System.out.println("你希望和"  + friendNo + "聊天");
            new ChatScreen(friendNo);
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        JLabel jl =(JLabel)e.getSource();
        jl.setForeground(Color.BLUE);
    }

    public void mouseExited(MouseEvent e) {

    }
}
