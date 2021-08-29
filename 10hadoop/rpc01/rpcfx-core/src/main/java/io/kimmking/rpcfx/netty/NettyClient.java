package io.kimmking.rpcfx.netty;

import com.sun.jndi.toolkit.url.Uri;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

public class NettyClient {

    private final String url;

    //连接服务端的端口号地址和端口号
    public NettyClient(String url) {
        this.url = url;
    }

    public String start() {
        final EventLoopGroup group = new NioEventLoopGroup();

        ClientHandler handler = new ClientHandler();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)  // 使用NioSocketChannel来作为连接用的channel类
                    .handler(new ChannelInitializer<SocketChannel>() { // 绑定连接初始化器
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new HttpResponseEncoder());
                            ch.pipeline().addLast(new HttpRequestDecoder());
                            ch.pipeline().addLast(handler);
                        }
                    });
            //发起异步连接请求，绑定连接端口和host信息
            final ChannelFuture future = b.connect("127.0.0.1",8080).sync();

            URI uri = new URI(url);
            String msg = "";
            DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1,
                    HttpMethod.GET,uri.toASCIIString(), Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));

            // 构建http请求
            //request.headers().set(HttpHeaders.Names.HOST, "127.0.0.1");
            //request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            //request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());
            // 发送http请求
            future.channel().write(request);
            future.channel().flush();
            future.channel().closeFuture().sync();
        } catch (InterruptedException | UnsupportedEncodingException | URISyntaxException e) {
            e.printStackTrace();
        }

        return handler.getBody();
    }
}
