package com.chatus.service;

import com.chatus.bean.Information;
import com.sun.tools.classfile.InnerClasses_attribute;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by gaopan on 16/6/6.
 */
public class MsgHandleService {

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static Map<String, ChannelHandlerContext> userMap = new HashMap<String ,ChannelHandlerContext>();

    public static Map<String,Information.Group.User> userList = new HashMap<String, Information.Group.User>();

}
