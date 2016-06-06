package com.chatus.server;

import com.chatus.bean.Information;
import com.chatus.service.MsgHandleService;
import io.netty.channel.ChannelHandlerAdapter;
import com.chatus.protocol.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.validator.Msg;


/**
 * 真正的业务处理handler
 * Created by gaopan on 16/6/6.
 */
public class TimeServerHandler  extends ChannelHandlerAdapter {

    MessageProtocol protocol = new MessageProtocol(true);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MsgHandleService.channelGroup.add(ctx.channel());
        MsgHandleService.userMap.put(ctx.channel().id().toString(), ctx);
        System.out.println("登陆" + MsgHandleService.channelGroup.size());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        MsgHandleService.channelGroup.remove(ctx.channel());
        MsgHandleService.userMap.remove(ctx.channel().id().toString());
        MsgHandleService.userList.remove(ctx.channel().id().toString());
        System.out.println("退出");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Information.Group group = (Information.Group)msg;
        switch (group.getMsgEnum().getNumber()) {
            case Information.MsgEnum.CheckToLogin_VALUE:
                //登陆

        }
    }
}
