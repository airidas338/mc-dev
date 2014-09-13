package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;

import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityPlayer extends EntityHuman implements ail {

	private static final Logger bF = LogManager.getLogger();
	private String bG = "en_US";
	public PlayerConnection a;
	public final MinecraftServer b;
	public final PlayerInteractManager c;
	public double d;
	public double e;
	public final List f = Lists.newLinkedList();
	private final List bH = Lists.newLinkedList();
	private final ServerStatisticsManager bI;
	private float bJ = Float.MIN_VALUE;
	private float bK = -1.0E8F;
	private int bL = -99999999;
	private boolean bM = true;
	private int bN = -99999999;
	private int bO = 60;
	private EnumChatVisibility bP;
	private boolean bQ = true;
	private long bR = System.currentTimeMillis();
	private Entity bS = null;
	private int bT;
	public boolean g;
	public int h;
	public boolean i;

	public EntityPlayer(MinecraftServer var1, WorldServer var2, GameProfile var3, PlayerInteractManager var4) {
		super(var2, var3);
		var4.b = this;
		this.c = var4;
		Location var5 = var2.M();
		if (!var2.t.o() && var2.P().r() != EnumGamemode.ADVENTURE) {
			int var6 = Math.max(5, var1.au() - 6);
			int var7 = MathHelper.c(var2.af().b((double) var5.n(), (double) var5.p()));
			if (var7 < var6) {
				var6 = var7;
			}

			if (var7 <= 1) {
				var6 = 1;
			}

			var5 = var2.r(var5.a(this.V.nextInt(var6 * 2) - var6, 0, this.V.nextInt(var6 * 2) - var6));
		}

		this.b = var1;
		this.bI = var1.an().a((EntityHuman) this);
		this.S = 0.0F;
		this.a(var5, 0.0F, 0.0F);

		while (!var2.a((Entity) this, this.aQ()).isEmpty() && this.t < 255.0D) {
			this.b(this.s, this.t + 1.0D, this.u);
		}

	}

	public void a(NBTTagCompound var1) {
		super.a(var1);
		if (var1.hasKeyOfType("playerGameType", 99)) {
			if (MinecraftServer.M().av()) {
				this.c.a(MinecraftServer.M().m());
			} else {
				this.c.a(EnumGamemode.a(var1.getInt("playerGameType")));
			}
		}

	}

	public void b(NBTTagCompound var1) {
		super.b(var1);
		var1.setInt("playerGameType", this.c.b().a());
	}

	public void a(int var1) {
		super.a(var1);
		this.bN = -1;
	}

	public void b(int var1) {
		super.b(var1);
		this.bN = -1;
	}

	public void f_() {
		this.bi.a((ail) this);
	}

	public void g_() {
		super.g_();
		this.a.sendPacket((Packet) (new ke(this.br(), kg.a)));
	}

	public void j() {
		super.j();
		this.a.sendPacket((Packet) (new ke(this.br(), kg.b)));
	}

	public void s_() throws IOException {
		this.c.a();
		--this.bO;
		if (this.Z > 0) {
			--this.Z;
		}

		this.bi.b();
		if (!this.o.D && !this.bi.a((EntityHuman) this)) {
			this.n();
			this.bi = this.bh;
		}

		while (!this.bH.isEmpty()) {
			int var1 = Math.min(this.bH.size(), Integer.MAX_VALUE);
			int[] var2 = new int[var1];
			Iterator var3 = this.bH.iterator();
			int var4 = 0;

			while (var3.hasNext() && var4 < var1) {
				var2[var4++] = ((Integer) var3.next()).intValue();
				var3.remove();
			}

			this.a.sendPacket((Packet) (new km(var2)));
		}

		if (!this.f.isEmpty()) {
			ArrayList var6 = Lists.newArrayList();
			Iterator var8 = this.f.iterator();
			ArrayList var9 = Lists.newArrayList();

			Chunk var5;
			while (var8.hasNext() && var6.size() < 10) {
				aqm var10 = (aqm) var8.next();
				if (var10 != null) {
					if (this.o.e(new Location(var10.a << 4, 0, var10.b << 4))) {
						var5 = this.o.getChunkAt(var10.a, var10.b);
						if (var5.i()) {
							var6.add(var5);
							var9.addAll(((WorldServer) this.o).a(var10.a * 16, 0, var10.b * 16, var10.a * 16 + 16, 256, var10.b * 16 + 16));
							var8.remove();
						}
					}
				} else {
					var8.remove();
				}
			}

			if (!var6.isEmpty()) {
				if (var6.size() == 1) {
					this.a.sendPacket((Packet) (new jq((Chunk) var6.get(0), true, '\uffff')));
				} else {
					this.a.sendPacket((Packet) (new js(var6)));
				}

				Iterator var12 = var9.iterator();

				while (var12.hasNext()) {
					TileEntity var11 = (TileEntity) var12.next();
					this.a(var11);
				}

				var12 = var6.iterator();

				while (var12.hasNext()) {
					var5 = (Chunk) var12.next();
					this.u().s().a(this, var5);
				}
			}
		}

		Entity var7 = this.C();
		if (var7 != this) {
			if (!var7.isAlive()) {
				this.e(this);
			} else {
				this.a(var7.s, var7.t, var7.u, var7.y, var7.z);
				this.b.an().d(this);
				if (this.aw()) {
					this.e(this);
				}
			}
		}

	}

	public void l() {
		try {
			super.s_();

			for (int var1 = 0; var1 < this.bg.n_(); ++var1) {
				ItemStack var6 = this.bg.a(var1);
				if (var6 != null && var6.b().f()) {
					Packet var8 = ((ake) var6.b()).c(var6, this.o, this);
					if (var8 != null) {
						this.a.sendPacket(var8);
					}
				}
			}

			if (this.bm() != this.bK || this.bL != this.bj.a() || this.bj.e() == 0.0F != this.bM) {
				this.a.sendPacket((Packet) (new lc(this.bm(), this.bj.a(), this.bj.e())));
				this.bK = this.bm();
				this.bL = this.bj.a();
				this.bM = this.bj.e() == 0.0F;
			}

			if (this.bm() + this.bM() != this.bJ) {
				this.bJ = this.bm() + this.bM();
				Collection var5 = this.co().getObjectivesForCriteria(IScoreboardCriteria.g);
				Iterator var7 = var5.iterator();

				while (var7.hasNext()) {
					ScoreboardObjective var9 = (ScoreboardObjective) var7.next();
					this.co().getPlayerScoreForObjective(this.d_(), var9).updateForList(Arrays.asList(new EntityHuman[] { this }));
				}
			}

			if (this.bA != this.bN) {
				this.bN = this.bA;
				this.a.sendPacket((Packet) (new lb(this.bB, this.bA, this.bz)));
			}

			if (this.W % 20 * 5 == 0 && !this.A().a(AchievementList.L)) {
				this.h_();
			}

		} catch (Throwable var4) {
			CrashReport var2 = CrashReport.a(var4, "Ticking player");
			CrashReportSystemDetails var3 = var2.a("Player being ticked");
			this.getAttributeInstance(var3);
			throw new ReportedException(var2);
		}
	}

	protected void h_() {
		BiomeBase var1 = this.o.b(new Location(MathHelper.c(this.s), 0, MathHelper.c(this.u)));
		String var2 = var1.ah;
		ua var3 = (ua) this.A().b((tq) AchievementList.L);
		if (var3 == null) {
			var3 = (ua) this.A().a((tq) AchievementList.L, (tx) new ua());
		}

		var3.add(var2);
		if (this.A().b(AchievementList.L) && var3.size() >= BiomeBase.n.size()) {
			HashSet var4 = Sets.newHashSet(BiomeBase.n);
			Iterator var5 = var3.iterator();

			while (var5.hasNext()) {
				String var6 = (String) var5.next();
				Iterator var7 = var4.iterator();

				while (var7.hasNext()) {
					BiomeBase var8 = (BiomeBase) var7.next();
					if (var8.ah.equals(var6)) {
						var7.remove();
					}
				}

				if (var4.isEmpty()) {
					break;
				}
			}

			if (var4.isEmpty()) {
				this.b((tq) AchievementList.L);
			}
		}

	}

	public void a(DamageSource var1) {
		if (this.o.Q().b("showDeathMessages")) {
			ScoreboardTeamBase var2 = this.bN();
			if (var2 != null && var2.j() != bsg.a) {
				if (var2.j() == bsg.c) {
					this.b.an().a((EntityHuman) this, this.br().b());
				} else if (var2.j() == bsg.d) {
					this.b.an().b((EntityHuman) this, this.br().b());
				}
			} else {
				this.b.an().a(this.br().b());
			}
		}

		if (!this.o.Q().b("keepInventory")) {
			this.bg.n();
		}

		Collection var6 = this.o.Z().getObjectivesForCriteria(IScoreboardCriteria.d);
		Iterator var3 = var6.iterator();

		while (var3.hasNext()) {
			ScoreboardObjective var4 = (ScoreboardObjective) var3.next();
			ScoreboardScore var5 = this.co().getPlayerScoreForObjective(this.d_(), var4);
			var5.a();
		}

		EntityLiving var7 = this.bs();
		if (var7 != null) {
			MonsterEggInfo var8 = (MonsterEggInfo) EntityTypes.a.get(Integer.valueOf(EntityTypes.a(var7)));
			if (var8 != null) {
				this.b(var8.e);
			}

			var7.b(this, this.aU);
		}

		this.b(ty.y);
		this.a(ty.h);
		this.br().g();
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			boolean var3 = this.b.ad() && this.cq() && "fall".equals(var1.p);
			if (!var3 && this.bO > 0 && var1 != DamageSource.j) {
				return false;
			} else {
				if (var1 instanceof wi) {
					Entity var4 = var1.getEntity();
					if (var4 instanceof EntityHuman && !this.a((EntityHuman) var4)) {
						return false;
					}

					if (var4 instanceof EntityArrow) {
						EntityArrow var5 = (EntityArrow) var4;
						if (var5.c instanceof EntityHuman && !this.a((EntityHuman) var5.c)) {
							return false;
						}
					}
				}

				return super.a(var1, var2);
			}
		}
	}

	public boolean a(EntityHuman var1) {
		return !this.cq() ? false : super.a(var1);
	}

	private boolean cq() {
		return this.b.ah();
	}

	public void c(int var1) throws IOException {
		if (this.am == 1 && var1 == 1) {
			this.b((tq) AchievementList.D);
			this.o.e((Entity) this);
			this.i = true;
			this.a.sendPacket((Packet) (new jo(4, 0.0F)));
		} else {
			if (this.am == 0 && var1 == 1) {
				this.b((tq) AchievementList.C);
				Location var2 = this.b.a(var1).m();
				if (var2 != null) {
					this.a.a((double) var2.n(), (double) var2.o(), (double) var2.p(), 0.0F, 0.0F);
				}

				var1 = 1;
			} else {
				this.b((tq) AchievementList.y);
			}

			this.b.an().a(this, var1);
			this.bN = -1;
			this.bK = -1.0F;
			this.bL = -1;
		}

	}

	public boolean a(EntityPlayer var1) {
		return var1.v() ? this.C() == this : (this.v() ? false : super.a(var1));
	}

	private void a(TileEntity var1) {
		if (var1 != null) {
			Packet var2 = var1.x_();
			if (var2 != null) {
				this.a.sendPacket(var2);
			}
		}

	}

	public void a(Entity var1, int var2) {
		super.a(var1, var2);
		this.bi.b();
	}

	public ahf a(Location var1) {
		ahf var2 = super.a(var1);
		if (var2 == ahf.a) {
			kl var3 = new kl(this, var1);
			this.u().s().a((Entity) this, (Packet) var3);
			this.a.a(this.s, this.t, this.u, this.y, this.z);
			this.a.sendPacket((Packet) var3);
		}

		return var2;
	}

	public void a(boolean var1, boolean var2, boolean var3) {
		if (this.bI()) {
			this.u().s().b(this, new ir(this, 2));
		}

		super.a(var1, var2, var3);
		if (this.a != null) {
			this.a.a(this.s, this.t, this.u, this.y, this.z);
		}

	}

	public void a(Entity var1) {
		Entity var2 = this.m;
		super.a(var1);
		if (var1 != var2) {
			this.a.sendPacket((Packet) (new ky(0, this, this.m)));
			this.a.a(this.s, this.t, this.u, this.y, this.z);
		}

	}

	protected void a(double var1, boolean var3, Block var4, Location var5) {
	}

	public void a(double var1, boolean var3) {
		int var4 = MathHelper.c(this.s);
		int var5 = MathHelper.c(this.t - 0.20000000298023224D);
		int var6 = MathHelper.c(this.u);
		Location var7 = new Location(var4, var5, var6);
		Block var8 = this.o.getData(var7).c();
		if (var8.r() == Material.AIR) {
			Block var9 = this.o.getData(var7.b()).c();
			if (var9 instanceof BlockFence || var9 instanceof BlockCobbleWall || var9 instanceof BlockFenceGate) {
				var7 = var7.b();
				var8 = this.o.getData(var7).c();
			}
		}

		super.a(var1, var3, var8, var7);
	}

	public void a(bdj var1) {
		var1.a((EntityHuman) this);
		this.a.sendPacket((Packet) (new kc(var1.v())));
	}

	private void cr() {
		this.bT = this.bT % 100 + 1;
	}

	public void a(vv var1) {
		this.cr();
		this.a.sendPacket((Packet) (new je(this.bT, var1.k(), var1.e_())));
		this.bi = var1.a(this.bg, this);
		this.bi.d = this.bT;
		this.bi.a((ail) this);
	}

	public void a(IInventory var1) {
		if (this.bi != this.bh) {
			this.n();
		}

		if (var1 instanceof vy) {
			vy var2 = (vy) var1;
			if (var2.q_() && !this.a(var2.i()) && !this.v()) {
				this.a.sendPacket((Packet) (new PacketPlayOutChat(new ChatMessage("container.isLocked", new Object[] { var1.e_() }), (byte) 2)));
				this.a.sendPacket((Packet) (new jv("random.door_close", this.s, this.t, this.u, 1.0F, 1.0F)));
				return;
			}
		}

		this.cr();
		if (var1 instanceof vv) {
			this.a.sendPacket((Packet) (new je(this.bT, ((vv) var1).k(), var1.e_(), var1.n_())));
			this.bi = ((vv) var1).a(this.bg, this);
		} else {
			this.a.sendPacket((Packet) (new je(this.bT, "minecraft:container", var1.e_(), var1.n_())));
			this.bi = new aim(this.bg, var1, this);
		}

		this.bi.d = this.bT;
		this.bi.a((ail) this);
	}

	public void a(aqb var1) throws IOException {
		this.cr();
		this.bi = new ajf(this.bg, var1, this.o);
		this.bi.d = this.bT;
		this.bi.a((ail) this);
		aje var2 = ((ajf) this.bi).e();
		IChatBaseComponent var3 = var1.e_();
		this.a.sendPacket((Packet) (new je(this.bT, "minecraft:villager", var3, var2.n_())));
		aqd var4 = var1.b_(this);
		if (var4 != null) {
			hd var5 = new hd(Unpooled.buffer());
			var5.writeInt(this.bT);
			var4.a(var5);
			this.a.sendPacket((Packet) (new ji("MC|TrList", var5)));
		}

	}

	public void a(EntityHorse var1, IInventory var2) {
		if (this.bi != this.bh) {
			this.n();
		}

		this.cr();
		this.a.sendPacket((Packet) (new je(this.bT, "EntityHorse", var2.e_(), var2.n_(), var1.F())));
		this.bi = new aiy(this.bg, var2, var1, this);
		this.bi.d = this.bT;
		this.bi.a((ail) this);
	}

	public void a(ItemStack var1) {
		Item var2 = var1.b();
		if (var2 == Items.bN) {
			this.a.sendPacket((Packet) (new ji("MC|BOpen", new hd(Unpooled.buffer()))));
		}

	}

	public void a(aib var1, int var2, ItemStack var3) {
		if (!(var1.a(var2) instanceof ajj)) {
			if (!this.g) {
				this.a.sendPacket((Packet) (new jh(var1.d, var2, var3)));
			}
		}
	}

	public void a(aib var1) {
		this.a(var1, var1.a());
	}

	public void a(aib var1, List var2) {
		this.a.sendPacket((Packet) (new jf(var1.d, var2)));
		this.a.sendPacket((Packet) (new jh(-1, -1, this.bg.p())));
	}

	public void a(aib var1, int var2, int var3) {
		this.a.sendPacket((Packet) (new jg(var1.d, var2, var3)));
	}

	public void a(aib var1, IInventory var2) {
		for (int var3 = 0; var3 < var2.g(); ++var3) {
			this.a.sendPacket((Packet) (new jg(var1.d, var3, var2.a_(var3))));
		}

	}

	public void n() {
		this.a.sendPacket((Packet) (new jd(this.bi.d)));
		this.p();
	}

	public void o() {
		if (!this.g) {
			this.a.sendPacket((Packet) (new jh(-1, -1, this.bg.p())));
		}
	}

	public void p() {
		this.bi.b((EntityHuman) this);
		this.bi = this.bh;
	}

	public void a(float var1, float var2, boolean var3, boolean var4) {
		if (this.m != null) {
			if (var1 >= -1.0F && var1 <= 1.0F) {
				this.aX = var1;
			}

			if (var2 >= -1.0F && var2 <= 1.0F) {
				this.aY = var2;
			}

			this.aW = var3;
			this.c(var4);
		}

	}

	public void a(tq var1, int var2) {
		if (var1 != null) {
			this.bI.b(this, var1, var2);
			Iterator var3 = this.co().getObjectivesForCriteria(var1.k()).iterator();

			while (var3.hasNext()) {
				ScoreboardObjective var4 = (ScoreboardObjective) var3.next();
				this.co().getPlayerScoreForObjective(this.d_(), var4).a(var2);
			}

			if (this.bI.e()) {
				this.bI.a(this);
			}

		}
	}

	public void a(tq var1) {
		if (var1 != null) {
			this.bI.a(this, var1, 0);
			Iterator var2 = this.co().getObjectivesForCriteria(var1.k()).iterator();

			while (var2.hasNext()) {
				ScoreboardObjective var3 = (ScoreboardObjective) var2.next();
				this.co().getPlayerScoreForObjective(this.d_(), var3).setScore(0);
			}

			if (this.bI.e()) {
				this.bI.a(this);
			}

		}
	}

	public void q() {
		if (this.l != null) {
			this.l.a((Entity) this);
		}

		if (this.bu) {
			this.a(true, false, false);
		}

	}

	public void r() {
		this.bK = -1.0E8F;
	}

	public void b(IChatBaseComponent var1) {
		this.a.sendPacket((Packet) (new PacketPlayOutChat(var1)));
	}

	protected void s() {
		this.a.sendPacket((Packet) (new jk(this, (byte) 9)));
		super.s();
	}

	public void a(ItemStack var1, int var2) {
		super.a(var1, var2);
		if (var1 != null && var1.b() != null && var1.b().e(var1) == ano.b) {
			this.u().s().b(this, new ir(this, 3));
		}

	}

	public void a(EntityHuman var1, boolean var2) {
		super.a(var1, var2);
		this.bN = -1;
		this.bK = -1.0F;
		this.bL = -1;
		this.bH.addAll(((EntityPlayer) var1).bH);
	}

	protected void a(MobEffect var1) {
		super.a(var1);
		this.a.sendPacket((Packet) (new lr(this.F(), var1)));
	}

	protected void a(MobEffect var1, boolean var2) {
		super.a(var1, var2);
		this.a.sendPacket((Packet) (new lr(this.F(), var1)));
	}

	protected void b(MobEffect var1) {
		super.b(var1);
		this.a.sendPacket((Packet) (new kn(this.F(), var1)));
	}

	public void a(double var1, double var3, double var5) {
		this.a.a(var1, var3, var5, this.y, this.z);
	}

	public void b(Entity var1) {
		this.u().s().b(this, new ir(var1, 4));
	}

	public void c(Entity var1) {
		this.u().s().b(this, new ir(var1, 5));
	}

	public void t() {
		if (this.a != null) {
			this.a.sendPacket((Packet) (new kd(this.by)));
			this.B();
		}
	}

	public WorldServer u() {
		return (WorldServer) this.o;
	}

	public void a(EnumGamemode var1) throws IOException {
		this.c.a(var1);
		this.a.sendPacket((Packet) (new jo(3, (float) var1.a())));
		if (var1 == EnumGamemode.SPECTATOR) {
			this.a((Entity) null);
		} else {
			this.e(this);
		}

		this.t();
		this.bO();
	}

	public boolean v() {
		return this.c.b() == EnumGamemode.SPECTATOR;
	}

	public void a(IChatBaseComponent var1) {
		this.a.sendPacket((Packet) (new PacketPlayOutChat(var1)));
	}

	public boolean a(int var1, String var2) {
		if ("seed".equals(var2) && !this.b.ad()) {
			return true;
		} else if (!"tell".equals(var2) && !"help".equals(var2) && !"me".equals(var2) && !"trigger".equals(var2)) {
			if (this.b.an().g(this.cc())) {
				OpListEntry sq;
				if ((sq = (OpListEntry) this.b.an().n().b((Object) this.cc())) != null) {
					return sq.a() >= var1;
				}
				return this.b.p() >= var1;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public String w() {
		String var1 = this.a.a.b().toString();
		var1 = var1.substring(var1.indexOf("/") + 1);
		var1 = var1.substring(0, var1.indexOf(":"));
		return var1;
	}

	public void a(PacketPlayInSettings var1) {
		this.bG = var1.a();
		this.bP = var1.c();
		this.bQ = var1.d();
		this.H().b(10, Byte.valueOf((byte) var1.e()));
	}

	public EnumChatVisibility y() {
		return this.bP;
	}

	public void a(String var1, String var2) {
		this.a.sendPacket((Packet) (new ko(var1, var2)));
	}

	public Location c() {
		return new Location(this.s, this.t + 0.5D, this.u);
	}

	public void z() {
		this.bR = MinecraftServer.ax();
	}

	public ServerStatisticsManager A() {
		return this.bI;
	}

	public void d(Entity var1) {
		if (var1 instanceof EntityHuman) {
			this.a.sendPacket((Packet) (new km(new int[] { var1.F() })));
		} else {
			this.bH.add(Integer.valueOf(var1.F()));
		}

	}

	protected void B() {
		if (this.v()) {
			this.bi();
			this.e(true);
		} else {
			super.B();
		}

		this.u().s().a(this);
	}

	public Entity C() {
		return (Entity) (this.bS == null ? this : this.bS);
	}

	public void e(Entity var1) {
		Entity var2 = this.C();
		this.bS = (Entity) (var1 == null ? this : var1);
		if (var2 != this.bS) {
			this.a.sendPacket((Packet) (new ku(this.bS)));
			this.a(this.bS.s, this.bS.t, this.bS.u);
		}

	}

	public void f(Entity var1) {
		if (this.c.b() == EnumGamemode.SPECTATOR) {
			this.e(var1);
		} else {
			super.f(var1);
		}

	}

	public long D() {
		return this.bR;
	}

	public IChatBaseComponent E() {
		return null;
	}

}
