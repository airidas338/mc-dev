package net.minecraft.server;

import com.google.common.collect.Queues;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalServerChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GenericFutureListener;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.Queue;

import javax.crypto.SecretKey;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class NetworkManager extends SimpleChannelInboundHandler {

	private static final Logger f = LogManager.getLogger();
	public static final Marker a = MarkerManager.getMarker("NETWORK");
	public static final Marker b = MarkerManager.getMarker("NETWORK_PACKETS", a);
	public static final AttributeKey c = AttributeKey.valueOf("protocol");
	public static final up d = new gs();
	public static final up e = new gt();
	private final ie g;
	private final Queue h = Queues.newConcurrentLinkedQueue();
	private Channel i;
	private SocketAddress j;
	private PacketListener k;
	private IChatBaseComponent l;
	private boolean m;
	private boolean n;

	public NetworkManager(ie var1) {
		this.g = var1;
	}

	public void channelActive(ChannelHandlerContext var1) throws Exception {
		super.channelActive(var1);
		System.out.println(var1.channel() + " " + var1.channel().isOpen());
		this.i = var1.channel();
		this.j = this.i.remoteAddress();

		try {
			this.a(gy.a);
		} catch (Throwable var3) {
			f.fatal(var3);
		}

	}

	public void a(gy var1) {
		this.i.attr(c).set(var1);
		this.i.config().setAutoRead(true);
		System.out.println(this.i.attr(c).get());
		f.debug("Enabled auto read");
	}

	public void channelInactive(ChannelHandlerContext var1) {
		this.a((IChatBaseComponent) (new hz("disconnect.endOfStream", new Object[0])));
	}

	public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) {
		f.debug("Disconnecting " + this.b(), var2);
		this.a((IChatBaseComponent) (new hz("disconnect.genericReason", new Object[] { "Internal Exception: " + var2 })));
	}

	protected void a(ChannelHandlerContext var1, id var2) {
		if (this.i.isOpen()) {
			try {
				var2.a(this.k);
			} catch (pi var4) {
				;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void a(PacketListener var1) {
		Validate.notNull(var1, "packetListener", new Object[0]);
		f.debug("Set listener of {} to {}", new Object[] { this, var1 });
		this.k = var1;
	}

	public void a(id var1) {
		if (this.i != null && this.i.isOpen()) {
			this.m();
			this.a(var1, (GenericFutureListener[]) null);
		} else {
			this.h.add(new gx(var1, (GenericFutureListener[]) null));
		}

	}

	public void a(id var1, GenericFutureListener var2, GenericFutureListener... var3) {
		if (this.i != null && this.i.isOpen()) {
			this.m();
			this.a(var1, (GenericFutureListener[]) ArrayUtils.add(var3, 0, var2));
		} else {
			this.h.add(new gx(var1, (GenericFutureListener[]) ArrayUtils.add(var3, 0, var2)));
		}

	}

	private void a(id var1, GenericFutureListener[] var2) {
		gy var3 = gy.a(var1);
		gy var4 = (gy) this.i.attr(c).get();
		if (var4 != var3) {
			f.debug("Disabled auto read");
			this.i.config().setAutoRead(false);
		}

		if (this.i.eventLoop().inEventLoop()) {
			if (var3 != var4) {
				this.a(var3);
			}

			ChannelFuture var5 = this.i.writeAndFlush(var1);
			if (var2 != null) {
				var5.addListeners(var2);
			}

			var5.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
		} else {
			this.i.eventLoop().execute(new gu(this, var3, var4, var1, var2));
		}

	}

	private void m() {
		if (this.i != null && this.i.isOpen()) {
			while (!this.h.isEmpty()) {
				gx var1 = (gx) this.h.poll();
				this.a(gx.a(var1), gx.b(var1));
			}

		}
	}

	public void a() {
		this.m();
		if (this.k instanceof IUpdatePlayerListBox) {
			((IUpdatePlayerListBox) this.k).c();
		}

		this.i.flush();
	}

	public SocketAddress b() {
		return this.j;
	}

	public void a(IChatBaseComponent var1) {
		if (this.i.isOpen()) {
			this.i.close().awaitUninterruptibly();
			this.l = var1;
		}

	}

	public boolean c() {
		return this.i instanceof LocalChannel || this.i instanceof LocalServerChannel;
	}

	public void a(SecretKey var1) {
		this.m = true;
		this.i.pipeline().addBefore("splitter", "decrypt", new gn(ug.a(2, var1)));
		this.i.pipeline().addBefore("prepender", "encrypt", new go(ug.a(1, var1)));
	}

	public boolean isConnected() {
		if (i != null) {
			System.out.println(i + " " + i.isOpen() + " " + i.isActive());
		}
		return this.i != null && this.i.isOpen();
	}

	public boolean h() {
		return this.i == null;
	}

	public PacketListener i() {
		return this.k;
	}

	public IChatBaseComponent j() {
		return this.l;
	}

	public void k() {
		this.i.config().setAutoRead(false);
	}

	public void a(int var1) {
		if (var1 >= 0) {
			if (this.i.pipeline().get("decompress") instanceof gp) {
				((gp) this.i.pipeline().get("decompress")).a(var1);
			} else {
				this.i.pipeline().addBefore("decoder", "decompress", new gp(var1));
			}

			if (this.i.pipeline().get("compress") instanceof gq) {
				((gq) this.i.pipeline().get("decompress")).a(var1);
			} else {
				this.i.pipeline().addBefore("encoder", "compress", new gq(var1));
			}
		} else {
			if (this.i.pipeline().get("decompress") instanceof gp) {
				this.i.pipeline().remove("decompress");
			}

			if (this.i.pipeline().get("compress") instanceof gq) {
				this.i.pipeline().remove("compress");
			}
		}

	}

	public void l() {
		if (!this.h() && !this.isConnected() && !this.n) {
			this.n = true;
			if (this.j() != null) {
				this.i().a(this.j());
			} else if (this.i() != null) {
				this.i().a(new ChatComponentText("Disconnected"));
			}
		}

	}

	// $FF: synthetic method
	protected void channelRead0(ChannelHandlerContext var1, Object var2) {
		this.a(var1, (id) var2);
	}

	// $FF: synthetic method
	static Channel a(NetworkManager var0) {
		return var0.i;
	}

}
