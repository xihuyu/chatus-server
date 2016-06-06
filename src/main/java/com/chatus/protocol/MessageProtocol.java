package com.chatus.protocol;

import com.chatus.bean.Information;
import com.sun.tools.classfile.InnerClasses_attribute;

import java.util.Collection;

/**
 * Created by gaopan on 16/6/6.
 */
public class MessageProtocol {

    private Information.Group group;
    private Information.Login login;
    private Information.MsgInfo msgInfo;
    private Information.Group.User user;

    @SuppressWarnings("unused")
    public MessageProtocol(){}

    public MessageProtocol(boolean bool) {
        login = Information.Login.newBuilder().setUserName("")
                .setUserPwd("")
                .setLoginState(Information.Login.LoinEnum.Request)
                .setFeedBackInfo("")
                .build();

        msgInfo = Information.MsgInfo.newBuilder()
                .setSendUser("")
                .setSendToUser("")
                .setSendInfo("")
                .build();

        user = Information.Group.User.newBuilder()
                .setId("")
                .setUserName("")
                .setUserPwd("")
                .build();

        group = Information.Group.newBuilder()
                .setLogin(login)
                .setMsgInfo(msgInfo)
                .setMsgEnum(Information.MsgEnum.ReuqestToConnect)
                .setServerConnectEnum(Information.Group.ServerConnectEnum.Request)
                .addUserList(user)
                .build();
    }

    public Information.Group getConnectServerInfo(Information.Group.ServerConnectEnum serverConnectEnum) {
        group = Information.Group.newBuilder()
                .setLogin(login)
                .setMsgInfo(msgInfo)
                .setMsgEnum(Information.MsgEnum.ReuqestToConnect)
                .setServerConnectEnum(serverConnectEnum)
                .addUserList(user)
                .build();
        return group;
    }


    public Information.Group getLoginInfo(String userName, String userPwd) {
        Information.Login login = Information.Login.newBuilder()
                .setUserName(userName)
                .setUserPwd(userPwd)
                .setLoginState(Information.Login.LoinEnum.Request)
                .setFeedBackInfo("")
                .build();

        group = Information.Group.newBuilder()
                .setMsgInfo(msgInfo)
                .setMsgEnum(Information.MsgEnum.CheckToLogin)
                .setServerConnectEnum(Information.Group.ServerConnectEnum.Success)
                .addUserList(user)
                .build();
        return group;
    }

    public Information.Group getLoginInfo(String userName, String userPwd,Information.Login.LoinEnum loinEnum, String feedBackInfo) {
        Information.Login login = Information.Login.newBuilder()
                .setUserName(userName)
                .setUserPwd(userPwd)
                .setLoginState(loinEnum)
                .setFeedBackInfo(feedBackInfo)
                .build();

        group = Information.Group.newBuilder()
                .setLogin(login)
                .setMsgInfo(msgInfo)
                .setMsgEnum(Information.MsgEnum.CheckToLogin)
                .setServerConnectEnum(Information.Group.ServerConnectEnum.Success)
                .addUserList(user)
                .build();
        return group;
    }

    public Information.Group doGetFriendsListInfo(Collection<Information.Group.User> userList) {
        Information.Group.Builder groupBuilder = new Information.Group.newBuilder();
        groupBuilder.setLogin(login);
        groupBuilder.setMsgInfo(msgInfo);
        groupBuilder.setMsgEnum(Information.MsgEnum.ChatToFriend);
        groupBuilder.setServerConnectEnum(Information.Group.ServerConnectEnum.Success);
        for(Information.Group.User user : userList) {
            groupBuilder.addUserList(user);
        }

        group = groupBuilder.build();
        return group;
    }

    public Information.Group getSendInfos(String userName, String msgStr) {

        msgInfo = Information.MsgInfo.newBuilder()
                .setSendUser(userName)
                .setSendToUser("")
                .setSendInfo(msgStr)
                .build();

        group = Information.Group.newBuilder()
                .setLogin(login)
                .setMsgInfo(msgInfo)
                .setMsgEnum(Information.MsgEnum.ChatToFriend)
                .setServerConnectEnum(Information.Group.ServerConnectEnum.Success)
                .addUserList(user)
                .build();
        return group;
    }

}
