package com.chatus.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 聊天服务器
 * <p></p>
 * @author fenggaopan 2016年6月6日 下午5:47:11
 * @version V1.0   
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2016年6月6日
 * @modify by reason:{方法名}:{原因}
 */
public class ChatServer {
	
	/**
	 * 绑定端口号
	 * @author fenggaopan 2016年6月6日 下午5:49:47
	 * @param port
	 * @throws Exception
	 */
	public void bind(int port) throws Exception {
		
		EventLoopGroup workGroup = new NioEventLoopGroup();
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workGroup);
			b.channel(NioServerSocketChannel.class);
			b.option(ChannelOption.SO_BACKLOG, 1024);
			//绑定handler,处理接收到的消息
			b.childHandler(new ServerChildHandler());
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
			
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
		
	}

}
