package net.minecraft.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.GenericFutureListener;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;

public class ServerConnection {

	private static final Logger d = LogManager.getLogger();
	public static final up a = new rd();
	public static final up b = new re();
	private final MinecraftServer e;
	public volatile boolean c;
	private final List f = Collections.synchronizedList(Lists.newArrayList());
	private final List g = Collections.synchronizedList(Lists.newArrayList());

	public ServerConnection(MinecraftServer var1) {
		this.e = var1;
		this.c = true;
	}

	public void a(InetAddress var1, int var2) throws IOException {
		List var3 = this.f;
		synchronized (this.f) {
			this.f.add(((ServerBootstrap) ((ServerBootstrap) (new ServerBootstrap()).channel(NioServerSocketChannel.class)).childHandler(new ServerConnectionChannel(this)).group((EventLoopGroup) a.c())
					.localAddress(var1, var2)).bind().syncUninterruptibly());
		}
	}

	public void b() {
		this.c = false;
		Iterator var1 = this.f.iterator();

		while (var1.hasNext()) {
			ChannelFuture var2 = (ChannelFuture) var1.next();

			try {
				var2.channel().close().sync();
			} catch (InterruptedException var4) {
				d.error("Interrupted whilst closing channel");
			}
		}

	}

	public void c() {
		List var1 = this.g;
		
		synchronized (this.g) {
			Iterator var2 = this.g.iterator();

			while (var2.hasNext()) {
				NetworkManager var3 = (NetworkManager) var2.next();
				var3.a();
				System.out.println("Recieved NetworkManager " + var3);
				if (!var3.h()) {
					if (!var3.isConnected()) {
						System.out.println("NetworkManager is not connected " + var3);
						var2.remove();
						var3.l();
					} else {
						try {
							System.out.println("Connecting NetworkManager " + var3);
							var3.a();
						} catch (Exception var8) {
							if (var3.c()) {
								CrashReport var10 = CrashReport.a(var8, "Ticking memory connection");
								CrashReportSystemDetails var6 = var10.a("Ticking connection");
								var6.a("Connection", (Callable) (new rh(this, var3)));
								throw new ReportedException(var10);
							}

							d.warn("Failed to handle packet for " + var3.b(), var8);
							ChatComponentText var5 = new ChatComponentText("Internal server error");
							var3.a(new PacketPlayOutKickDisconnect(var5), new ServerConnectionFuture(this, var3, var5), new GenericFutureListener[0]);
							var3.k();
						}
					}
				}
			}
		}
	}

	public MinecraftServer d() {
		return this.e;
	}

	// $FF: synthetic method
	static List a(ServerConnection var0) {
		return var0.g;
	}

	// $FF: synthetic method
	static MinecraftServer b(ServerConnection var0) {
		return var0.e;
	}

}
