package net.minecraft.server;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;

import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MinecraftServer implements ae, Runnable, vn, wd {

	private static final Logger j = LogManager.getLogger();
	public static final File a = new File("usercache.json");
	private static MinecraftServer k;
	private final Convertable l;
	private final MojangStatisticsGenerator m = new MojangStatisticsGenerator("server", this, ax());
	private final File n;
	private final List o = Lists.newArrayList();
	private final ICommandHandler p;
	public final MethodProfiler b = new MethodProfiler();
	private final ServerConnection q;
	private final ServerPing r = new ServerPing();
	private final Random s = new Random();
	private String t;
	private int u = -1;
	public WorldServer[] c;
	private PlayerList v;
	private boolean w = true;
	private boolean isStopped;
	private int y;
	protected final Proxy d;
	public String e;
	public int f;
	private boolean z;
	private boolean A;
	private boolean B;
	private boolean C;
	private boolean D;
	private String E;
	private int F;
	private int G = 0;
	public final long[] g = new long[100];
	public long[][] h;
	private KeyPair H;
	private String I;
	private String J;
	private boolean L;
	private boolean M;
	private boolean N;
	private String O = "";
	private String P = "";
	private boolean Q;
	private long R;
	private String S;
	private boolean T;
	private boolean U;
	private final YggdrasilAuthenticationService V;
	private final MinecraftSessionService W;
	private long X = 0L;
	private final GameProfileRepository Y;
	private final UserCache Z;
	protected final Queue i = Queues.newArrayDeque();
	private Thread aa;
	private long ab = ax();

	public MinecraftServer(File var1, Proxy var2, File var3) {
		this.d = var2;
		k = this;
		this.n = var1;
		this.q = new ServerConnection(this);
		this.Z = new UserCache(this, var3);
		this.p = this.h();
		this.l = new WorldLoaderServer(var1);
		this.V = new YggdrasilAuthenticationService(var2, UUID.randomUUID().toString());
		this.W = this.V.createMinecraftSessionService();
		this.Y = this.V.createProfileRepository();
	}

	protected cl h() {
		return new cl();
	}

	protected abstract boolean init() throws UnknownHostException;

	protected void a(String var1) {
		if (this.X().b(var1)) {
			j.info("Converting map!");
			this.b("menu.convertingLevel");
			this.X().a(var1, new ConvertProgressUpdater(this));
		}

	}

	protected synchronized void b(String var1) {
		this.S = var1;
	}

	protected void a(String var1, String var2, long var3, WorldType var5, String var6) {
		this.a(var1);
		this.b("menu.loadingLevel");
		this.c = new WorldServer[3];
		this.h = new long[this.c.length][100];
		IDataManager var7 = this.l.a(var1, true);
		this.a(this.T(), var7);
		WorldData var9 = var7.d();
		WorldSettings var8;
		if (var9 == null) {
			if (this.W()) {
				var8 = DemoWorldServer.a;
			} else {
				var8 = new WorldSettings(var3, this.m(), this.l(), this.o(), var5);
				var8.a(var6);
				if (this.M) {
					var8.a();
				}
			}

			var9 = new WorldData(var8, var2);
		} else {
			var9.a(var2);
			var8 = new WorldSettings(var9);
		}

		for (int var10 = 0; var10 < this.c.length; ++var10) {
			byte var11 = 0;
			if (var10 == 1) {
				var11 = -1;
			}

			if (var10 == 2) {
				var11 = 1;
			}

			if (var10 == 0) {
				if (this.W()) {
					this.c[var10] = (WorldServer) (new DemoWorldServer(this, var7, var9, var11, this.b)).b();
				} else {
					this.c[var10] = (WorldServer) (new WorldServer(this, var7, var9, var11, this.b)).b();
				}

				this.c[var10].a(var8);
			} else {
				this.c[var10] = (WorldServer) (new SecondaryWorldServer(this, var7, var11, this.c[0], this.b)).b();
			}

			this.c[var10].a((ara) (new WorldManager(this, this.c[var10])));
			if (!this.S()) {
				this.c[var10].P().a(this.m());
			}
		}

		this.v.a(this.c);
		this.a(this.n());
		this.k();
	}

	protected void k() {
		boolean var1 = true;
		boolean var2 = true;
		boolean var3 = true;
		boolean var4 = true;
		int var5 = 0;
		this.b("menu.generatingTerrain");
		byte var6 = 0;
		j.info("Preparing start region for level " + var6);
		WorldServer var7 = this.c[var6];
		Location var8 = var7.M();
		long var9 = ax();

		for (int var11 = -192; var11 <= 192 && this.t(); var11 += 16) {
			for (int var12 = -192; var12 <= 192 && this.t(); var12 += 16) {
				long var13 = ax();
				if (var13 - var9 > 1000L) {
					this.a_("Preparing spawn area", var5 * 100 / 625);
					var9 = var13;
				}

				++var5;
				var7.b.c(var8.n() + var11 >> 4, var8.p() + var12 >> 4);
			}
		}

		this.q();
	}

	protected void a(String var1, IDataManager var2) {
		File var3 = new File(var2.b(), "resources.zip");
		if (var3.isFile()) {
			this.a_("level://" + var1 + "/" + var3.getName(), "");
		}

	}

	public abstract boolean l();

	public abstract EnumGamemode m();

	public abstract EnumDifficulty n();

	public abstract boolean o();

	public abstract int p();

	protected void a_(String var1, int var2) {
		this.e = var1;
		this.f = var2;
		j.info(var1 + ": " + var2 + "%");
	}

	protected void q() {
		this.e = null;
		this.f = 0;
	}

	protected void a(boolean var1) {
		if (!this.N) {
			WorldServer[] var2 = this.c;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				WorldServer var5 = var2[var4];
				if (var5 != null) {
					if (!var1) {
						j.info("Saving chunks for level \'" + var5.P().k() + "\'/" + var5.t.k());
					}

					try {
						var5.a(true, (IProgressUpdate) null);
					} catch (ExceptionWorldConflict var7) {
						j.warn(var7.getMessage());
					}
				}
			}

		}
	}

	public void r() {
		if (!this.N) {
			j.info("Stopping server");
			if (this.ao() != null) {
				this.ao().b();
			}

			if (this.v != null) {
				j.info("Saving players");
				this.v.k();
				this.v.v();
			}

			if (this.c != null) {
				j.info("Saving worlds");
				this.a(false);

				for (int var1 = 0; var1 < this.c.length; ++var1) {
					WorldServer var2 = this.c[var1];
					var2.o();
				}
			}

			if (this.m.d()) {
				this.m.e();
			}

		}
	}

	public String s() {
		return this.t;
	}

	public void c(String var1) {
		this.t = var1;
	}

	public boolean t() {
		return this.w;
	}

	public void u() {
		this.w = false;
	}

	public void run() {
		try {
			if (this.init()) {
				this.ab = ax();
				long var1 = 0L;
				this.r.a((IChatBaseComponent) (new ChatComponentText(this.E)));
				this.r.a(new ServerPingServerData("1.8", 47));
				this.a(this.r);

				while (this.w) {
					long var48 = ax();
					long var5 = var48 - this.ab;
					if (var5 > 2000L && this.ab - this.R >= 15000L) {
						j.warn("Can\'t keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)",
								new Object[] { Long.valueOf(var5), Long.valueOf(var5 / 50L) });
						var5 = 2000L;
						this.R = this.ab;
					}

					if (var5 < 0L) {
						j.warn("Time ran backwards! Did the system time change?");
						var5 = 0L;
					}

					var1 += var5;
					this.ab = var48;
					if (this.c[0].f()) {
						this.y();
						var1 = 0L;
					} else {
						while (var1 > 50L) {
							var1 -= 50L;
							this.y();
						}
					}

					Thread.sleep(Math.max(1L, 50L - var1));
					this.Q = true;
				}
			} else {
				this.a((CrashReport) null);
			}
		} catch (Throwable var46) {
			j.error("Encountered an unexpected exception", var46);
			CrashReport var2 = null;
			if (var46 instanceof ReportedException) {
				var2 = this.b(((ReportedException) var46).a());
			} else {
				var2 = this.b(new CrashReport("Exception in server tick loop", var46));
			}

			File var3 = new File(new File(this.w(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
			if (var2.a(var3)) {
				j.error("This crash report has been saved to: " + var3.getAbsolutePath());
			} else {
				j.error("We were unable to save this crash report to disk.");
			}

			this.a(var2);
		} finally {
			try {
				this.r();
				this.isStopped = true;
			} catch (Throwable var44) {
				j.error("Exception stopping the server", var44);
			} finally {
				this.x();
			}

		}

	}

	private void a(ServerPing var1) {
		File var2 = this.d("server-icon.png");
		if (var2.isFile()) {
			ByteBuf var3 = Unpooled.buffer();

			try {
				BufferedImage var4 = ImageIO.read(var2);
				Validate.validState(var4.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
				Validate.validState(var4.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
				ImageIO.write(var4, "PNG", new ByteBufOutputStream(var3));
				ByteBuf var5 = Base64.encode(var3);
				var1.a("data:image/png;base64," + var5.toString(Charsets.UTF_8));
			} catch (Exception var9) {
				j.error("Couldn\'t load server icon", var9);
			} finally {
				var3.release();
			}
		}

	}

	public File w() {
		return new File(".");
	}

	protected void a(CrashReport var1) {
	}

	protected void x() {
	}

	protected void y() {
		long var1 = System.nanoTime();
		++this.y;
		if (this.T) {
			this.T = false;
			this.b.a = true;
			this.b.a();
		}

		this.b.a("root");
		this.z();
		if (var1 - this.X >= 5000000000L) {
			this.X = var1;
			this.r.a(new ServerPingPlayerSample(this.H(), this.G()));
			GameProfile[] var3 = new GameProfile[Math.min(this.G(), 12)];
			int var4 = MathHelper.a(this.s, 0, this.G() - var3.length);

			for (int var5 = 0; var5 < var3.length; ++var5) {
				var3[var5] = ((EntityPlayer) this.v.e.get(var4 + var5)).cc();
			}

			Collections.shuffle(Arrays.asList(var3));
			this.r.b().a(var3);
		}

		if (this.y % 900 == 0) {
			this.b.a("save");
			this.v.k();
			this.a(true);
			this.b.b();
		}

		this.b.a("tallying");
		this.g[this.y % 100] = System.nanoTime() - var1;
		this.b.b();
		this.b.a("snooper");
		if (!this.m.d() && this.y > 100) {
			this.m.a();
		}

		if (this.y % 6000 == 0) {
			this.m.b();
		}

		this.b.b();
		this.b.b();
	}

	public void z() {
		this.b.a("jobs");
		Queue var1 = this.i;
		synchronized (this.i) {
			while (!this.i.isEmpty()) {
				try {
					((FutureTask) this.i.poll()).run();
				} catch (Throwable var9) {
					j.fatal(var9);
				}
			}
		}

		this.b.c("levels");

		int var11;
		for (var11 = 0; var11 < this.c.length; ++var11) {
			long var2 = System.nanoTime();
			if (var11 == 0 || this.A()) {
				WorldServer var4 = this.c[var11];
				this.b.a(var4.P().k());
				if (this.y % 20 == 0) {
					this.b.a("timeSync");
					this.v.a((id) (new PacketPlayOutUpdateTime(var4.K(), var4.L(), var4.Q().b("doDaylightCycle"))), var4.t.q());
					this.b.b();
				}

				this.b.a("tick");

				CrashReport var6;
				try {
					var4.c();
				} catch (Throwable var8) {
					var6 = CrashReport.a(var8, "Exception ticking world");
					var4.a(var6);
					throw new ReportedException(var6);
				}

				try {
					var4.i();
				} catch (Throwable var7) {
					var6 = CrashReport.a(var7, "Exception ticking world entities");
					var4.a(var6);
					throw new ReportedException(var6);
				}

				this.b.b();
				this.b.a("tracker");
				var4.s().a();
				this.b.b();
				this.b.b();
			}

			this.h[var11][this.y % 100] = System.nanoTime() - var2;
		}

		this.b.c("connection");
		this.ao().c();
		this.b.c("players");
		this.v.e();
		this.b.c("tickables");

		for (var11 = 0; var11 < this.o.size(); ++var11) {
			((IUpdatePlayerListBox) this.o.get(var11)).c();
		}

		this.b.b();
	}

	public boolean A() {
		return true;
	}

	public void a(IUpdatePlayerListBox var1) {
		this.o.add(var1);
	}

	public static void main(String[] var0) {
		DispenserRegistry.c();

		try {
			boolean var1 = true;
			String var2 = null;
			String var3 = ".";
			String var4 = null;
			boolean var5 = false;
			boolean var6 = false;
			int var7 = -1;

			for (int var8 = 0; var8 < var0.length; ++var8) {
				String var9 = var0[var8];
				String var10 = var8 == var0.length - 1 ? null : var0[var8 + 1];
				boolean var11 = false;
				if (!var9.equals("nogui") && !var9.equals("--nogui")) {
					if (var9.equals("--port") && var10 != null) {
						var11 = true;

						try {
							var7 = Integer.parseInt(var10);
						} catch (NumberFormatException var13) {
							;
						}
					} else if (var9.equals("--singleplayer") && var10 != null) {
						var11 = true;
						var2 = var10;
					} else if (var9.equals("--universe") && var10 != null) {
						var11 = true;
						var3 = var10;
					} else if (var9.equals("--world") && var10 != null) {
						var11 = true;
						var4 = var10;
					} else if (var9.equals("--demo")) {
						var5 = true;
					} else if (var9.equals("--bonusChest")) {
						var6 = true;
					}
				} else {
					var1 = false;
				}

				if (var11) {
					++var8;
				}
			}

			DedicatedServer var15 = new DedicatedServer(new File(var3));
			if (var2 != null) {
				var15.j(var2);
			}

			if (var4 != null) {
				var15.k(var4);
			}

			if (var7 >= 0) {
				var15.b(var7);
			}

			if (var5) {
				var15.b(true);
			}

			if (var6) {
				var15.c(true);
			}

			if (var1 && !GraphicsEnvironment.isHeadless()) {
				var15.aO();
			}

			var15.B();
			Runtime.getRuntime().addShutdownHook(new ThreadShutdown("Server Shutdown Thread", var15));
		} catch (Exception var14) {
			j.fatal("Failed to start the minecraft server", var14);
		}

	}

	public void B() {
		this.aa = new Thread(this, "Server thread");
		this.aa.start();
	}

	public File d(String var1) {
		return new File(this.w(), var1);
	}

	public void e(String var1) {
		j.info(var1);
	}

	public void f(String var1) {
		j.warn(var1);
	}

	public WorldServer a(int var1) {
		return var1 == -1 ? this.c[1] : (var1 == 1 ? this.c[2] : this.c[0]);
	}

	public String C() {
		return this.t;
	}

	public int D() {
		return this.u;
	}

	public String E() {
		return this.E;
	}

	public String F() {
		return "1.8";
	}

	public int G() {
		return this.v.p();
	}

	public int H() {
		return this.v.q();
	}

	public String[] I() {
		return this.v.g();
	}

	public GameProfile[] J() {
		return this.v.h();
	}

	public String K() {
		return "";
	}

	public String g(String var1) {
		RemoteControlCommandListener.h().i();
		this.p.a(RemoteControlCommandListener.h(), var1);
		return RemoteControlCommandListener.h().j();
	}

	public boolean L() {
		return false;
	}

	public void h(String var1) {
		j.error(var1);
	}

	public void i(String var1) {
		if (this.L()) {
			j.info(var1);
		}

	}

	public String getServerModName() {
		return "CraftBukkit";
	}

	public CrashReport b(CrashReport var1) {
		var1.g().a("Profiler Position", (Callable) (new CrashReportProfilerPosition(this)));
		if (this.v != null) {
			var1.g().a("Player Count", (Callable) (new CrashReportPlayerCount(this)));
		}

		return var1;
	}

	public List a(ae var1, String var2, Location var3) {
		ArrayList var4 = Lists.newArrayList();
		if (var2.startsWith("/")) {
			var2 = var2.substring(1);
			boolean var11 = !var2.contains(" ");
			List var12 = this.p.a(var1, var2, var3);
			if (var12 != null) {
				Iterator var13 = var12.iterator();

				while (var13.hasNext()) {
					String var14 = (String) var13.next();
					if (var11) {
						var4.add("/" + var14);
					} else {
						var4.add(var14);
					}
				}
			}

			return var4;
		} else {
			String[] var5 = var2.split(" ", -1);
			String var6 = var5[var5.length - 1];
			String[] var7 = this.v.g();
			int var8 = var7.length;

			for (int var9 = 0; var9 < var8; ++var9) {
				String var10 = var7[var9];
				if (CommandAbstract.a(var6, var10)) {
					var4.add(var10);
				}
			}

			return var4;
		}
	}

	public static MinecraftServer M() {
		return k;
	}

	public boolean N() {
		return this.n != null;
	}

	public String d_() {
		return "Server";
	}

	public void a(IChatBaseComponent var1) {
		j.info(var1.c());
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public ICommandHandler O() {
		return this.p;
	}

	public KeyPair P() {
		return this.H;
	}

	public int Q() {
		return this.u;
	}

	public void b(int var1) {
		this.u = var1;
	}

	public String R() {
		return this.I;
	}

	public void j(String var1) {
		this.I = var1;
	}

	public boolean S() {
		return this.I != null;
	}

	public String T() {
		return this.J;
	}

	public void k(String var1) {
		this.J = var1;
	}

	public void a(KeyPair var1) {
		this.H = var1;
	}

	public void a(EnumDifficulty var1) {
		for (int var2 = 0; var2 < this.c.length; ++var2) {
			WorldServer var3 = this.c[var2];
			if (var3 != null) {
				if (var3.P().t()) {
					var3.P().a(EnumDifficulty.HARD);
					var3.a(true, true);
				} else if (this.S()) {
					var3.P().a(var1);
					var3.a(var3.aa() != EnumDifficulty.PEACEFUL, true);
				} else {
					var3.P().a(var1);
					var3.a(this.V(), this.A);
				}
			}
		}

	}

	protected boolean V() {
		return true;
	}

	public boolean W() {
		return this.L;
	}

	public void b(boolean var1) {
		this.L = var1;
	}

	public void c(boolean var1) {
		this.M = var1;
	}

	public Convertable X() {
		return this.l;
	}

	public void Z() {
		this.N = true;
		this.X().d();

		for (int var1 = 0; var1 < this.c.length; ++var1) {
			WorldServer var2 = this.c[var1];
			if (var2 != null) {
				var2.o();
			}
		}

		this.X().e(this.c[0].O().g());
		this.u();
	}

	public String aa() {
		return this.O;
	}

	public String ab() {
		return this.P;
	}

	public void a_(String var1, String var2) {
		this.O = var1;
		this.P = var2;
	}

	public void a(MojangStatisticsGenerator var1) {
		var1.a("whitelist_enabled", Boolean.valueOf(false));
		var1.a("whitelist_count", Integer.valueOf(0));
		if (this.v != null) {
			var1.a("players_current", Integer.valueOf(this.G()));
			var1.a("players_max", Integer.valueOf(this.H()));
			var1.a("players_seen", Integer.valueOf(this.v.r().length));
		}

		var1.a("uses_auth", Boolean.valueOf(this.z));
		var1.a("gui_state", this.aq() ? "enabled" : "disabled");
		var1.a("run_time", Long.valueOf((ax() - var1.g()) / 60L * 1000L));
		var1.a("avg_tick_ms", Integer.valueOf((int) (MathHelper.a(this.g) * 1.0E-6D)));
		int var2 = 0;
		if (this.c != null) {
			for (int var3 = 0; var3 < this.c.length; ++var3) {
				if (this.c[var3] != null) {
					WorldServer var4 = this.c[var3];
					WorldData var5 = var4.P();
					var1.a("world[" + var2 + "][dimension]", Integer.valueOf(var4.t.q()));
					var1.a("world[" + var2 + "][mode]", var5.r());
					var1.a("world[" + var2 + "][difficulty]", var4.aa());
					var1.a("world[" + var2 + "][hardcore]", Boolean.valueOf(var5.t()));
					var1.a("world[" + var2 + "][generator_name]", var5.u().a());
					var1.a("world[" + var2 + "][generator_version]", Integer.valueOf(var5.u().d()));
					var1.a("world[" + var2 + "][height]", Integer.valueOf(this.F));
					var1.a("world[" + var2 + "][chunks_loaded]", Integer.valueOf(var4.N().g()));
					++var2;
				}
			}
		}

		var1.a("worlds", Integer.valueOf(var2));
	}

	public void b(MojangStatisticsGenerator var1) {
		var1.b("singleplayer", Boolean.valueOf(this.S()));
		var1.b("server_brand", this.getServerModName());
		var1.b("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
		var1.b("dedicated", Boolean.valueOf(this.ad()));
	}

	public boolean ac() {
		return true;
	}

	public abstract boolean ad();

	public boolean ae() {
		return this.z;
	}

	public void d(boolean var1) {
		this.z = var1;
	}

	public boolean af() {
		return this.A;
	}

	public void e(boolean var1) {
		this.A = var1;
	}

	public boolean ag() {
		return this.B;
	}

	public void f(boolean var1) {
		this.B = var1;
	}

	public boolean ah() {
		return this.C;
	}

	public void g(boolean var1) {
		this.C = var1;
	}

	public boolean ai() {
		return this.D;
	}

	public void h(boolean var1) {
		this.D = var1;
	}

	public abstract boolean aj();

	public String ak() {
		return this.E;
	}

	public void m(String var1) {
		this.E = var1;
	}

	public int al() {
		return this.F;
	}

	public void c(int var1) {
		this.F = var1;
	}

	public boolean am() {
		return this.isStopped;
	}

	public PlayerList an() {
		return this.v;
	}

	public void a(PlayerList var1) {
		this.v = var1;
	}

	public void a(EnumGamemode var1) {
		for (int var2 = 0; var2 < this.c.length; ++var2) {
			M().c[var2].P().a(var1);
		}

	}

	public ServerConnection ao() {
		return this.q;
	}

	public boolean aq() {
		return false;
	}

	public abstract String a(EnumGamemode var1, boolean var2);

	public int ar() {
		return this.y;
	}

	public void as() {
		this.T = true;
	}

	public Location c() {
		return Location.a;
	}

	public ChunkCoordinates d() {
		return new ChunkCoordinates(0.0D, 0.0D, 0.0D);
	}

	public World e() {
		return this.c[0];
	}

	public Entity f() {
		return null;
	}

	public int au() {
		return 16;
	}

	public boolean a(World var1, Location var2, EntityHuman var3) {
		return false;
	}

	public void i(boolean var1) {
		this.U = var1;
	}

	public boolean av() {
		return this.U;
	}

	public Proxy aw() {
		return this.d;
	}

	public static long ax() {
		return System.currentTimeMillis();
	}

	public int ay() {
		return this.G;
	}

	public void d(int var1) {
		this.G = var1;
	}

	public IChatBaseComponent e_() {
		return new ChatComponentText(this.d_());
	}

	public boolean az() {
		return true;
	}

	public MinecraftSessionService aB() {
		return this.W;
	}

	public GameProfileRepository aC() {
		return this.Y;
	}

	public UserCache aD() {
		return this.Z;
	}

	public ServerPing aE() {
		return this.r;
	}

	public void aF() {
		this.X = 0L;
	}

	public Entity a(UUID var1) {
		WorldServer[] var2 = this.c;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			WorldServer var5 = var2[var4];
			if (var5 != null) {
				Entity var6 = var5.a(var1);
				if (var6 != null) {
					return var6;
				}
			}
		}

		return null;
	}

	public boolean t_() {
		return M().c[0].Q().b("sendCommandFeedback");
	}

	public void a(ag var1, int var2) {
	}

	public int aG() {
		return 29999984;
	}

	public ListenableFuture a(Callable var1) {
		Validate.notNull(var1);
		if (!this.aH()) {
			ListenableFutureTask var2 = ListenableFutureTask.create(var1);
			Queue var3 = this.i;
			synchronized (this.i) {
				this.i.add(var2);
				return var2;
			}
		} else {
			try {
				return Futures.immediateFuture(var1.call());
			} catch (Exception var6) {
				return Futures.immediateFailedCheckedFuture(var6);
			}
		}
	}

	public ListenableFuture a(Runnable var1) {
		Validate.notNull(var1);
		return this.a(Executors.callable(var1));
	}

	public boolean aH() {
		return Thread.currentThread() == this.aa;
	}

	public int aI() {
		return 256;
	}

	public long aJ() {
		return this.ab;
	}

	public Thread aK() {
		return this.aa;
	}

	// $FF: synthetic method
	public static Logger aL() {
		return j;
	}

	// $FF: synthetic method
	public static PlayerList a(MinecraftServer var0) {
		return var0.v;
	}

}
