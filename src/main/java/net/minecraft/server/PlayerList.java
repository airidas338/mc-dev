package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;

import io.netty.buffer.Unpooled;

import java.io.File;
import java.io.IOException;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PlayerList {

	public static final File a = new File("banned-players.json");
	public static final File b = new File("banned-ips.json");
	public static final File c = new File("ops.json");
	public static final File d = new File("whitelist.json");
	private static final Logger h = LogManager.getLogger();
	private static final SimpleDateFormat i = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
	private final MinecraftServer j;
	public final List e = Lists.newArrayList();
	public final Map f = Maps.newHashMap();
	private final GameProfileBanList k;
	private final IpBanList l;
	private final OpList m;
	private final WhiteList n;
	private final Map o;
	private IPlayerFileData p;
	private boolean q;
	protected int g;
	private int r;
	private EnumGamemode s;
	private boolean t;
	private int u;

	public PlayerList(MinecraftServer var1) {
		this.k = new GameProfileBanList(a);
		this.l = new IpBanList(b);
		this.m = new OpList(c);
		this.n = new WhiteList(d);
		this.o = Maps.newHashMap();
		this.j = var1;
		this.k.a(false);
		this.l.a(false);
		this.g = 8;
	}

	public void a(NetworkManager var1, EntityPlayer var2) {
		GameProfile var3 = var2.cc();
		UserCache var4 = this.j.aD();
		GameProfile var5 = var4.a(var3.getId());
		String var6 = var5 == null ? var3.getName() : var5.getName();
		var4.a(var3);
		NBTTagCompound var7 = this.a(var2);
		var2.a((World) this.j.a(var2.am));
		var2.c.a((WorldServer) var2.o);
		String var8 = "local";
		if (var1.b() != null) {
			var8 = var1.b().toString();
		}

		h.info(var2.getName() + "[" + var8 + "] logged in with entity id " + var2.F() + " at (" + var2.s + ", " + var2.t + ", " + var2.u + ")");
		WorldServer var9 = this.j.a(var2.am);
		WorldData var10 = var9.P();
		Location var11 = var9.M();
		this.a(var2, (EntityPlayer) null, var9);
		PlayerConnection var12 = new PlayerConnection(this.j, var1, var2);
		var12.sendPacket((Packet) (new jw(var2.F(), var2.c.b(), var10.t(), var9.worldProvider.q(), var9.aa(), this.q(), var10.u(), var9.Q().b("reducedDebugInfo"))));
		var12.sendPacket((Packet) (new ji("MC|Brand", (new PacketDataSerializer(Unpooled.buffer())).a(this.c().getServerModName()))));
		var12.sendPacket((Packet) (new ix(var10.y(), var10.z())));
		var12.sendPacket((Packet) (new lh(var11)));
		var12.sendPacket((Packet) (new kd(var2.by)));
		var12.sendPacket((Packet) (new kv(var2.bg.c)));
		var2.A().d();
		var2.A().b(var2);
		this.a((ScoreboardServer) var9.Z(), var2);
		this.j.aF();
		ChatMessage var13;
		if (!var2.getName().equalsIgnoreCase(var6)) {
			var13 = new ChatMessage("multiplayer.player.joined.renamed", new Object[] { var2.getScoreboardDisplayName(), var6 });
		} else {
			var13 = new ChatMessage("multiplayer.player.joined", new Object[] { var2.getScoreboardDisplayName() });
		}

		var13.getChatModifier().setColor(EnumChatFormat.YELLOW);
		this.a((IChatBaseComponent) var13);
		this.c(var2);
		var12.a(var2.s, var2.t, var2.u, var2.y, var2.z);
		this.b(var2, var9);
		if (this.j.aa().length() > 0) {
			var2.a(this.j.aa(), this.j.ab());
		}

		Iterator var14 = var2.bk().iterator();

		while (var14.hasNext()) {
			MobEffect var15 = (MobEffect) var14.next();
			var12.sendPacket((Packet) (new lr(var2.F(), var15)));
		}

		var2.f_();
		if (var7 != null && var7.hasKeyOfType("Riding", 10)) {
			Entity var16 = EntityTypes.a(var7.getCompound("Riding"), (World) var9);
			if (var16 != null) {
				var16.n = true;
				var9.d(var16);
				var2.a(var16);
				var16.n = false;
			}
		}

	}

	protected void a(ScoreboardServer var1, EntityPlayer var2) {
		HashSet var3 = Sets.newHashSet();
		Iterator var4 = var1.getTeams().iterator();

		while (var4.hasNext()) {
			ScoreboardTeam var5 = (ScoreboardTeam) var4.next();
			var2.a.sendPacket((Packet) (new PacketPlayOutScoreboardTeam(var5, 0)));
		}

		for (int var9 = 0; var9 < 19; ++var9) {
			ScoreboardObjective var10 = var1.getObjectiveForSlot(var9);
			if (var10 != null && !var3.contains(var10)) {
				List var6 = var1.d(var10);
				Iterator var7 = var6.iterator();

				while (var7.hasNext()) {
					Packet var8 = (Packet) var7.next();
					var2.a.sendPacket(var8);
				}

				var3.add(var10);
			}
		}

	}

	public void a(WorldServer[] var1) {
		this.p = var1[0].O().e();
		var1[0].af().a((WorldBorderListener) (new so(this)));
	}

	public void a(EntityPlayer var1, WorldServer var2) {
		WorldServer var3 = var1.u();
		if (var2 != null) {
			var2.t().c(var1);
		}

		var3.t().a(var1);
		var3.b.c((int) var1.s >> 4, (int) var1.u >> 4);
	}

	public int d() {
		return PlayerChunkMap.b(this.t());
	}

	public NBTTagCompound a(EntityPlayer var1) {
		NBTTagCompound var2 = this.j.c[0].P().i();
		NBTTagCompound var3;
		if (var1.getName().equals(this.j.R()) && var2 != null) {
			var1.f(var2);
			var3 = var2;
			h.debug("loading single player");
		} else {
			var3 = this.p.load(var1);
		}

		return var3;
	}

	protected void b(EntityPlayer var1) {
		this.p.save(var1);
		ServerStatisticsManager var2 = (ServerStatisticsManager) this.o.get(var1.aJ());
		if (var2 != null) {
			var2.b();
		}

	}

	public void c(EntityPlayer var1) {
		this.e.add(var1);
		this.f.put(var1.aJ(), var1);
		this.a((Packet) (new kh(kj.a, new EntityPlayer[] { var1 })));
		WorldServer var2 = this.j.a(var1.am);
		var2.d(var1);
		this.a(var1, (WorldServer) null);

		for (int var3 = 0; var3 < this.e.size(); ++var3) {
			EntityPlayer var4 = (EntityPlayer) this.e.get(var3);
			var1.a.sendPacket((Packet) (new kh(kj.a, new EntityPlayer[] { var4 })));
		}

	}

	public void d(EntityPlayer var1) {
		var1.u().t().d(var1);
	}

	public void e(EntityPlayer var1) {
		var1.b(ty.f);
		this.b(var1);
		WorldServer var2 = var1.u();
		if (var1.m != null) {
			var2.f(var1.m);
			h.debug("removing player mount");
		}

		var2.e(var1);
		var2.t().c(var1);
		this.e.remove(var1);
		this.f.remove(var1.aJ());
		this.o.remove(var1.aJ());
		this.a((Packet) (new kh(kj.e, new EntityPlayer[] { var1 })));
	}

	public String a(SocketAddress var1, GameProfile var2) {
		String var4;
		if (this.k.a(var2)) {
			GameProfileBanEntry var5 = (GameProfileBanEntry) this.k.b((Object) var2);
			var4 = "You are banned from this server!\nReason: " + var5.d();
			if (var5.c() != null) {
				var4 = var4 + "\nYour ban will be removed on " + i.format(var5.c());
			}

			return var4;
		} else if (!this.e(var2)) {
			return "You are not white-listed on this server!";
		} else if (this.l.isBanned(var1)) {
			IpBanEntry var3 = this.l.b(var1);
			var4 = "Your IP address is banned from this server!\nReason: " + var3.d();
			if (var3.c() != null) {
				var4 = var4 + "\nYour ban will be removed on " + i.format(var3.c());
			}

			return var4;
		} else {
			return this.e.size() >= this.g ? "The server is full!" : null;
		}
	}

	public EntityPlayer f(GameProfile var1) {
		UUID var2 = EntityHuman.a(var1);
		ArrayList var3 = Lists.newArrayList();

		EntityPlayer var5;
		for (int var4 = 0; var4 < this.e.size(); ++var4) {
			var5 = (EntityPlayer) this.e.get(var4);
			if (var5.aJ().equals(var2)) {
				var3.add(var5);
			}
		}

		Iterator var6 = var3.iterator();

		while (var6.hasNext()) {
			var5 = (EntityPlayer) var6.next();
			var5.a.c("You logged in from another location");
		}

		Object var7;
		if (this.j.W()) {
			var7 = new qk(this.j.a(0));
		} else {
			var7 = new PlayerInteractManager(this.j.a(0));
		}

		return new EntityPlayer(this.j, this.j.a(0), var1, (PlayerInteractManager) var7);
	}

	public EntityPlayer a(EntityPlayer var1, int var2, boolean var3) {
		var1.u().s().b(var1);
		var1.u().s().b((Entity) var1);
		var1.u().t().c(var1);
		this.e.remove(var1);
		this.j.a(var1.am).f(var1);
		Location var4 = var1.cg();
		boolean var5 = var1.ch();
		var1.am = var2;
		Object var6;
		if (this.j.W()) {
			var6 = new qk(this.j.a(var1.am));
		} else {
			var6 = new PlayerInteractManager(this.j.a(var1.am));
		}

		EntityPlayer var7 = new EntityPlayer(this.j, this.j.a(var1.am), var1.cc(), (PlayerInteractManager) var6);
		var7.a = var1.a;
		var7.a((EntityHuman) var1, var3);
		var7.d(var1.F());
		var7.o(var1);
		WorldServer var8 = this.j.a(var1.am);
		this.a(var7, var1, var8);
		Location var9;
		if (var4 != null) {
			var9 = EntityHuman.a(this.j.a(var1.am), var4, var5);
			if (var9 != null) {
				var7.setPositionRotation((double) ((float) var9.n() + 0.5F), (double) ((float) var9.o() + 0.1F), (double) ((float) var9.p() + 0.5F), 0.0F, 0.0F);
				var7.a(var4, var5);
			} else {
				var7.a.sendPacket((Packet) (new jo(0, 0.0F)));
			}
		}

		var8.b.c((int) var7.s >> 4, (int) var7.u >> 4);

		while (!var8.a((Entity) var7, var7.aQ()).isEmpty() && var7.t < 256.0D) {
			var7.b(var7.s, var7.t + 1.0D, var7.u);
		}

		var7.a.sendPacket((Packet) (new kp(var7.am, var7.o.aa(), var7.o.P().u(), var7.c.b())));
		var9 = var8.M();
		var7.a.a(var7.s, var7.t, var7.u, var7.y, var7.z);
		var7.a.sendPacket((Packet) (new lh(var9)));
		var7.a.sendPacket((Packet) (new lb(var7.bB, var7.bA, var7.bz)));
		this.b(var7, var8);
		var8.t().a(var7);
		var8.d(var7);
		this.e.add(var7);
		this.f.put(var7.aJ(), var7);
		var7.f_();
		var7.h(var7.bm());
		return var7;
	}

	public void a(EntityPlayer var1, int var2) throws IOException {
		int var3 = var1.am;
		WorldServer var4 = this.j.a(var1.am);
		var1.am = var2;
		WorldServer var5 = this.j.a(var1.am);
		var1.a.sendPacket((Packet) (new kp(var1.am, var1.o.aa(), var1.o.P().u(), var1.c.b())));
		var4.f(var1);
		var1.I = false;
		this.a(var1, var3, var4, var5);
		this.a(var1, var4);
		var1.a.a(var1.s, var1.t, var1.u, var1.y, var1.z);
		var1.c.a(var5);
		this.b(var1, var5);
		this.f(var1);
		Iterator var6 = var1.bk().iterator();

		while (var6.hasNext()) {
			MobEffect var7 = (MobEffect) var6.next();
			var1.a.sendPacket((Packet) (new lr(var1.F(), var7)));
		}

	}

	public void a(Entity var1, int var2, WorldServer var3, WorldServer var4) throws IOException {
		double var5 = var1.s;
		double var7 = var1.u;
		double var9 = 8.0D;
		float var11 = var1.y;
		var3.methodProfiler.a("moving");
		if (var1.am == -1) {
			var5 = MathHelper.a(var5 / var9, var4.af().b() + 16.0D, var4.af().d() - 16.0D);
			var7 = MathHelper.a(var7 / var9, var4.af().c() + 16.0D, var4.af().e() - 16.0D);
			var1.setPositionRotation(var5, var1.t, var7, var1.y, var1.z);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		} else if (var1.am == 0) {
			var5 = MathHelper.a(var5 * var9, var4.af().b() + 16.0D, var4.af().d() - 16.0D);
			var7 = MathHelper.a(var7 * var9, var4.af().c() + 16.0D, var4.af().e() - 16.0D);
			var1.setPositionRotation(var5, var1.t, var7, var1.y, var1.z);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		} else {
			Location var12;
			if (var2 == 1) {
				var12 = var4.M();
			} else {
				var12 = var4.m();
			}

			var5 = (double) var12.n();
			var1.t = (double) var12.o();
			var7 = (double) var12.p();
			var1.setPositionRotation(var5, var1.t, var7, 90.0F, 0.0F);
			if (var1.isAlive()) {
				var3.a(var1, false);
			}
		}

		var3.methodProfiler.b();
		if (var2 != 1) {
			var3.methodProfiler.a("placing");
			var5 = (double) MathHelper.a((int) var5, -29999872, 29999872);
			var7 = (double) MathHelper.a((int) var7, -29999872, 29999872);
			if (var1.isAlive()) {
				var1.setPositionRotation(var5, var1.t, var7, var1.y, var1.z);
				var4.u().a(var1, var11);
				var4.d(var1);
				var4.a(var1, false);
			}

			var3.methodProfiler.b();
		}

		var1.a((World) var4);
	}

	public void e() {
		if (++this.u > 600) {
			this.a((Packet) (new kh(kj.c, this.e)));
			this.u = 0;
		}

	}

	public void a(Packet var1) {
		for (int var2 = 0; var2 < this.e.size(); ++var2) {
			((EntityPlayer) this.e.get(var2)).a.sendPacket(var1);
		}

	}

	public void a(Packet var1, int var2) {
		for (int var3 = 0; var3 < this.e.size(); ++var3) {
			EntityPlayer var4 = (EntityPlayer) this.e.get(var3);
			if (var4.am == var2) {
				var4.a.sendPacket(var1);
			}
		}

	}

	public void a(EntityHuman var1, IChatBaseComponent var2) {
		ScoreboardTeamBase var3 = var1.bN();
		if (var3 != null) {
			Collection var4 = var3.getPlayerNameSet();
			Iterator var5 = var4.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				EntityPlayer var7 = this.a(var6);
				if (var7 != null && var7 != var1) {
					var7.sendMessage(var2);
				}
			}

		}
	}

	public void b(EntityHuman var1, IChatBaseComponent var2) {
		ScoreboardTeamBase var3 = var1.bN();
		if (var3 == null) {
			this.a(var2);
		} else {
			for (int var4 = 0; var4 < this.e.size(); ++var4) {
				EntityPlayer var5 = (EntityPlayer) this.e.get(var4);
				if (var5.bN() != var3) {
					var5.sendMessage(var2);
				}
			}

		}
	}

	public String f() {
		String var1 = "";

		for (int var2 = 0; var2 < this.e.size(); ++var2) {
			if (var2 > 0) {
				var1 = var1 + ", ";
			}

			var1 = var1 + ((EntityPlayer) this.e.get(var2)).getName();
		}

		return var1;
	}

	public String[] g() {
		String[] var1 = new String[this.e.size()];

		for (int var2 = 0; var2 < this.e.size(); ++var2) {
			var1[var2] = ((EntityPlayer) this.e.get(var2)).getName();
		}

		return var1;
	}

	public GameProfile[] h() {
		GameProfile[] var1 = new GameProfile[this.e.size()];

		for (int var2 = 0; var2 < this.e.size(); ++var2) {
			var1[var2] = ((EntityPlayer) this.e.get(var2)).cc();
		}

		return var1;
	}

	public GameProfileBanList i() {
		return this.k;
	}

	public IpBanList j() {
		return this.l;
	}

	public void a(GameProfile var1) {
		this.m.a((JsonListEntry) (new OpListEntry(var1, this.j.p())));
	}

	public void b(GameProfile var1) {
		this.m.c(var1);
	}

	public boolean e(GameProfile var1) {
		return !this.q || this.m.d(var1) || this.n.d(var1);
	}

	public boolean g(GameProfile var1) {
		return this.m.d(var1) || this.j.S() && this.j.c[0].P().v() && this.j.R().equalsIgnoreCase(var1.getName()) || this.t;
	}

	public EntityPlayer a(String var1) {
		Iterator var2 = this.e.iterator();

		EntityPlayer var3;
		do {
			if (!var2.hasNext()) {
				return null;
			}

			var3 = (EntityPlayer) var2.next();
		} while (!var3.getName().equalsIgnoreCase(var1));

		return var3;
	}

	public void a(double var1, double var3, double var5, double var7, int var9, Packet var10) {
		this.a((EntityHuman) null, var1, var3, var5, var7, var9, var10);
	}

	public void a(EntityHuman var1, double var2, double var4, double var6, double var8, int var10, Packet var11) {
		for (int var12 = 0; var12 < this.e.size(); ++var12) {
			EntityPlayer var13 = (EntityPlayer) this.e.get(var12);
			if (var13 != var1 && var13.am == var10) {
				double var14 = var2 - var13.s;
				double var16 = var4 - var13.t;
				double var18 = var6 - var13.u;
				if (var14 * var14 + var16 * var16 + var18 * var18 < var8 * var8) {
					var13.a.sendPacket(var11);
				}
			}
		}

	}

	public void k() {
		for (int var1 = 0; var1 < this.e.size(); ++var1) {
			this.b((EntityPlayer) this.e.get(var1));
		}

	}

	public void d(GameProfile var1) {
		this.n.a((JsonListEntry) (new WhiteListEntry(var1)));
	}

	public void c(GameProfile var1) {
		this.n.c(var1);
	}

	public WhiteList l() {
		return this.n;
	}

	public String[] m() {
		return this.n.a();
	}

	public OpList n() {
		return this.m;
	}

	public String[] o() {
		return this.m.a();
	}

	public void a() {
	}

	public void b(EntityPlayer var1, WorldServer var2) {
		WorldBorder var3 = this.j.c[0].af();
		var1.a.sendPacket((Packet) (new kr(var3, kt.d)));
		var1.a.sendPacket((Packet) (new PacketPlayOutUpdateTime(var2.K(), var2.L(), var2.Q().b("doDaylightCycle"))));
		if (var2.S()) {
			var1.a.sendPacket((Packet) (new jo(1, 0.0F)));
			var1.a.sendPacket((Packet) (new jo(7, var2.j(1.0F))));
			var1.a.sendPacket((Packet) (new jo(8, var2.h(1.0F))));
		}

	}

	public void f(EntityPlayer var1) {
		var1.a(var1.bh);
		var1.r();
		var1.a.sendPacket((Packet) (new kv(var1.bg.c)));
	}

	public int p() {
		return this.e.size();
	}

	public int q() {
		return this.g;
	}

	public String[] r() {
		return this.j.c[0].O().e().getSeenPlayers();
	}

	public boolean s() {
		return this.q;
	}

	public void a(boolean var1) {
		this.q = var1;
	}

	public List b(String var1) {
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = this.e.iterator();

		while (var3.hasNext()) {
			EntityPlayer var4 = (EntityPlayer) var3.next();
			if (var4.w().equals(var1)) {
				var2.add(var4);
			}
		}

		return var2;
	}

	public int t() {
		return this.r;
	}

	public MinecraftServer c() {
		return this.j;
	}

	public NBTTagCompound u() {
		return null;
	}

	private void a(EntityPlayer var1, EntityPlayer var2, World var3) {
		if (var2 != null) {
			var1.c.a(var2.c.b());
		} else if (this.s != null) {
			var1.c.a(this.s);
		}

		var1.c.b(var3.P().r());
	}

	public void v() {
		for (int var1 = 0; var1 < this.e.size(); ++var1) {
			((EntityPlayer) this.e.get(var1)).a.c("Server closed");
		}

	}

	public void a(IChatBaseComponent var1, boolean var2) {
		this.j.sendMessage(var1);
		int var3 = var2 ? 1 : 0;
		this.a((Packet) (new PacketPlayOutChat(var1, (byte) var3)));
	}

	public void a(IChatBaseComponent var1) {
		this.a(var1, true);
	}

	public ServerStatisticsManager a(EntityHuman var1) {
		UUID var2 = var1.aJ();
		ServerStatisticsManager var3 = var2 == null ? null : (ServerStatisticsManager) this.o.get(var2);
		if (var3 == null) {
			File var4 = new File(this.j.a(0).O().b(), "stats");
			File var5 = new File(var4, var2.toString() + ".json");
			if (!var5.exists()) {
				File var6 = new File(var4, var1.getName() + ".json");
				if (var6.exists() && var6.isFile()) {
					var6.renameTo(var5);
				}
			}

			var3 = new ServerStatisticsManager(this.j, var5);
			var3.a();
			this.o.put(var2, var3);
		}

		return var3;
	}

	public void a(int var1) {
		this.r = var1;
		if (this.j.c != null) {
			WorldServer[] var2 = this.j.c;
			int var3 = var2.length;

			for (int var4 = 0; var4 < var3; ++var4) {
				WorldServer var5 = var2[var4];
				if (var5 != null) {
					var5.t().a(var1);
				}
			}

		}
	}

	public EntityPlayer a(UUID var1) {
		return (EntityPlayer) this.f.get(var1);
	}

}
