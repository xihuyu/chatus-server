package com.chatus.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import com.chatus.bean.Information;

public class ServerChildHandler extends ChannelInitializer<SocketChannel> {
	
	
	@Override
	protected void initChannel(SocketChannel sc) throws Exception {
		System.out.println("服务端开启... ...");
		sc.pipeline().addLast("frameDecoder", new ProtobufVarint32FrameDecoder());
		sc.pipeline().addLast("protobufDecoder", new ProtobufDecoder(Information.Group.getDefaultInstance()));
		sc.pipeline().addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
		sc.pipeline().addLast("protobufEncoder", new ProtobufEncoder());
		sc.pipeline().addLast(new TimeServerHandler());


		System.out.println("向客户端发送连接消息包");
	}
	
}
