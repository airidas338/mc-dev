package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;

import io.netty.buffer.Unpooled;
import io.netty.util.concurrent.GenericFutureListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerConnection implements PacketPlayInListener, IUpdatePlayerListBox {

	private static final Logger c = LogManager.getLogger();
	public final NetworkManager a;
	private final MinecraftServer d;
	public EntityPlayer b;
	private int e;
	private int f;
	private int g;
	private boolean h;
	private int i;
	private long j;
	private long k;
	private int l;
	private int m;
	private IntHashMap n = new IntHashMap();
	private double o;
	private double p;
	private double q;
	private boolean r = true;

	public PlayerConnection(MinecraftServer var1, NetworkManager var2, EntityPlayer var3) {
		this.d = var1;
		this.a = var2;
		var2.a((PacketListener) this);
		this.b = var3;
		var3.a = this;
	}

	public void c() {
		this.h = false;
		++this.e;
		this.d.b.a("keepAlive");
		if ((long) this.e - this.k > 40L) {
			this.k = (long) this.e;
			this.j = this.d();
			this.i = (int) this.j;
			this.sendPacket((Packet) (new PacketPlayOutKeepAlive(this.i)));
		}

		this.d.b.b();
		if (this.l > 0) {
			--this.l;
		}

		if (this.m > 0) {
			--this.m;
		}

		if (this.b.D() > 0L && this.d.ay() > 0 && MinecraftServer.ax() - this.b.D() > (long) (this.d.ay() * 1000 * 60)) {
			this.c("You have been idle for too long!");
		}

	}

	public NetworkManager a() {
		return this.a;
	}

	public void c(String var1) {
		ChatComponentText var2 = new ChatComponentText(var1);
		this.a.a(new PacketPlayOutKickDisconnect(var2), new rk(this, var2), new GenericFutureListener[0]);
		this.a.k();
		Futures.getUnchecked(this.d.a((Runnable) (new rl(this))));
	}

	public void a(PacketPlayInSteerVehicle var1) {
		ig.a(var1, this, this.b.u());
		this.b.a(var1.a(), var1.b(), var1.c(), var1.d());
	}

	public void a(PacketPlayInFlying var1) throws IOException {
		ig.a(var1, this, this.b.u());
		WorldServer var2 = this.d.a(this.b.am);
		this.h = true;
		if (!this.b.i) {
			double var3 = this.b.s;
			double var5 = this.b.t;
			double var7 = this.b.u;
			double var9 = 0.0D;
			double var11 = var1.a() - this.o;
			double var13 = var1.b() - this.p;
			double var15 = var1.c() - this.q;
			if (var1.g()) {
				var9 = var11 * var11 + var13 * var13 + var15 * var15;
				if (!this.r && var9 < 0.25D) {
					this.r = true;
				}
			}

			if (this.r) {
				this.f = this.e;
				double var19;
				double var21;
				double var23;
				if (this.b.m != null) {
					float var48 = this.b.y;
					float var18 = this.b.z;
					this.b.m.al();
					var19 = this.b.s;
					var21 = this.b.t;
					var23 = this.b.u;
					if (var1.h()) {
						var48 = var1.d();
						var18 = var1.e();
					}

					this.b.C = var1.f();
					this.b.l();
					this.b.a(var19, var21, var23, var48, var18);
					if (this.b.m != null) {
						this.b.m.al();
					}

					this.d.an().d(this.b);
					if (this.b.m != null) {
						if (var9 > 4.0D) {
							Entity var49 = this.b.m;
							this.b.a.sendPacket((Packet) (new PacketPlayOutEntityTeleport(var49)));
							this.a(this.b.s, this.b.t, this.b.u, this.b.y, this.b.z);
						}

						this.b.m.ai = true;
					}

					if (this.r) {
						this.o = this.b.s;
						this.p = this.b.t;
						this.q = this.b.u;
					}

					var2.playerJoinedWorld(this.b);
					return;
				}

				if (this.b.bI()) {
					this.b.l();
					this.b.a(this.o, this.p, this.q, this.b.y, this.b.z);
					var2.playerJoinedWorld(this.b);
					return;
				}

				double var17 = this.b.t;
				this.o = this.b.s;
				this.p = this.b.t;
				this.q = this.b.u;
				var19 = this.b.s;
				var21 = this.b.t;
				var23 = this.b.u;
				float var25 = this.b.y;
				float var26 = this.b.z;
				if (var1.g() && var1.b() == -999.0D) {
					var1.a(false);
				}

				if (var1.g()) {
					var19 = var1.a();
					var21 = var1.b();
					var23 = var1.c();
					if (Math.abs(var1.a()) > 3.0E7D || Math.abs(var1.c()) > 3.0E7D) {
						this.c("Illegal position");
						return;
					}
				}

				if (var1.h()) {
					var25 = var1.d();
					var26 = var1.e();
				}

				this.b.l();
				this.b.a(this.o, this.p, this.q, var25, var26);
				if (!this.r) {
					return;
				}

				double var27 = var19 - this.b.s;
				double var29 = var21 - this.b.t;
				double var31 = var23 - this.b.u;
				double var33 = Math.min(Math.abs(var27), Math.abs(this.b.v));
				double var35 = Math.min(Math.abs(var29), Math.abs(this.b.w));
				double var37 = Math.min(Math.abs(var31), Math.abs(this.b.x));
				double var39 = var33 * var33 + var35 * var35 + var37 * var37;
				if (var39 > 100.0D && (!this.d.S() || !this.d.R().equals(this.b.getName()))) {
					c.warn(this.b.getName() + " moved too quickly! " + var27 + "," + var29 + "," + var31 + " (" + var33 + ", " + var35 + ", " + var37 + ")");
					this.a(this.o, this.p, this.q, this.b.y, this.b.z);
					return;
				}

				float var41 = 0.0625F;
				boolean var42 = var2.getCubes((Entity) this.b, this.b.aQ().d((double) var41, (double) var41, (double) var41)).isEmpty();
				if (this.b.C && !var1.f() && var29 > 0.0D) {
					this.b.bE();
				}

				this.b.d(var27, var29, var31);
				this.b.C = var1.f();
				double var43 = var29;
				var27 = var19 - this.b.s;
				var29 = var21 - this.b.t;
				if (var29 > -0.5D || var29 < 0.5D) {
					var29 = 0.0D;
				}

				var31 = var23 - this.b.u;
				var39 = var27 * var27 + var29 * var29 + var31 * var31;
				boolean var45 = false;
				if (var39 > 0.0625D && !this.b.bI() && !this.b.c.d()) {
					var45 = true;
					c.warn(this.b.getName() + " moved wrongly!");
				}

				this.b.a(var19, var21, var23, var25, var26);
				this.b.k(this.b.s - var3, this.b.t - var5, this.b.u - var7);
				if (!this.b.T) {
					boolean var46 = var2.getCubes((Entity) this.b, this.b.aQ().d((double) var41, (double) var41, (double) var41)).isEmpty();
					if (var42 && (var45 || !var46) && !this.b.bI()) {
						this.a(this.o, this.p, this.q, var25, var26);
						return;
					}
				}

				AxisAlignedBB var47 = this.b.aQ().b((double) var41, (double) var41, (double) var41).a(0.0D, -0.55D, 0.0D);
				if (!this.d.ai() && !this.b.abilities.canFly && !var2.c(var47)) {
					if (var43 >= -0.03125D) {
						++this.g;
						if (this.g > 80) {
							c.warn(this.b.getName() + " was kicked for floating too long!");
							this.c("Flying is not enabled on this server");
							return;
						}
					}
				} else {
					this.g = 0;
				}

				this.b.C = var1.f();
				this.d.an().d(this.b);
				this.b.a(this.b.t - var17, var1.f());
			} else if (this.e - this.f > 20) {
				this.a(this.o, this.p, this.q, this.b.y, this.b.z);
			}

		}
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.a(var1, var3, var5, var7, var8, Collections.emptySet());
	}

	public void a(double var1, double var3, double var5, float var7, float var8, Set var9) {
		this.r = false;
		this.o = var1;
		this.p = var3;
		this.q = var5;
		if (var9.contains(ij.a)) {
			this.o += this.b.s;
		}

		if (var9.contains(ij.b)) {
			this.p += this.b.t;
		}

		if (var9.contains(ij.c)) {
			this.q += this.b.u;
		}

		float var10 = var7;
		float var11 = var8;
		if (var9.contains(ij.d)) {
			var10 = var7 + this.b.y;
		}

		if (var9.contains(ij.e)) {
			var11 = var8 + this.b.z;
		}

		this.b.a(this.o, this.p, this.q, var10, var11);
		this.b.a.sendPacket((Packet) (new PacketPlayOutPosition(var1, var3, var5, var7, var8, var9)));
	}

	public void a(PacketPlayInBlockDig var1) {
		ig.a(var1, this, this.b.u());
		WorldServer var2 = this.d.a(this.b.am);
		Location var3 = var1.a();
		this.b.z();
		switch (rn.a[var1.c().ordinal()]) {
		case 1:
			if (!this.b.v()) {
				this.b.a(false);
			}

			return;
		case 2:
			if (!this.b.v()) {
				this.b.a(true);
			}

			return;
		case 3:
			this.b.bT();
			return;
		case 4:
		case 5:
		case 6:
			double var4 = this.b.s - ((double) var3.n() + 0.5D);
			double var6 = this.b.t - ((double) var3.o() + 0.5D) + 1.5D;
			double var8 = this.b.u - ((double) var3.p() + 0.5D);
			double var10 = var4 * var4 + var6 * var6 + var8 * var8;
			if (var10 > 36.0D) {
				return;
			} else if (var3.o() >= this.d.al()) {
				return;
			} else {
				if (var1.c() == mm.a) {
					if (!this.d.a((World) var2, var3, (EntityHuman) this.b) && var2.af().a(var3)) {
						this.b.c.a(var3, var1.b());
					} else {
						this.b.a.sendPacket((Packet) (new PacketPlayOutBlockChange(var2, var3)));
					}
				} else {
					if (var1.c() == mm.c) {
						this.b.c.a(var3);
					} else if (var1.c() == mm.b) {
						this.b.c.e();
					}

					if (var2.getData(var3).c().getMaterial() != Material.AIR) {
						this.b.a.sendPacket((Packet) (new PacketPlayOutBlockChange(var2, var3)));
					}
				}

				return;
			}
		default:
			throw new IllegalArgumentException("Invalid player action");
		}
	}

	public void a(PacketPlayInBlockPlace var1) {
		ig.a(var1, this, this.b.u());
		WorldServer var2 = this.d.a(this.b.am);
		ItemStack var3 = this.b.bg.h();
		boolean var4 = false;
		Location var5 = var1.a();
		EnumFacing var6 = EnumFacing.a(var1.b());
		this.b.z();
		if (var1.b() == 255) {
			if (var3 == null) {
				return;
			}

			this.b.c.a(this.b, var2, var3);
		} else if (var5.o() >= this.d.al() - 1 && (var6 == EnumFacing.UP || var5.o() >= this.d.al())) {
			ChatMessage var7 = new ChatMessage("build.tooHigh", new Object[] { Integer.valueOf(this.d.al()) });
			var7.getChatModifier().setColor(EnumChatFormat.RED);
			this.b.a.sendPacket((Packet) (new PacketPlayOutChat(var7)));
			var4 = true;
		} else {
			if (this.r && this.b.e((double) var5.n() + 0.5D, (double) var5.o() + 0.5D, (double) var5.p() + 0.5D) < 64.0D && !this.d.a((World) var2, var5, (EntityHuman) this.b) && var2.af().a(var5)) {
				this.b.c.a(this.b, var2, var3, var5, var6, var1.d(), var1.e(), var1.f());
			}

			var4 = true;
		}

		if (var4) {
			this.b.a.sendPacket((Packet) (new PacketPlayOutBlockChange(var2, var5)));
			this.b.a.sendPacket((Packet) (new PacketPlayOutBlockChange(var2, var5.a(var6))));
		}

		var3 = this.b.bg.h();
		if (var3 != null && var3.count == 0) {
			this.b.bg.a[this.b.bg.c] = null;
			var3 = null;
		}

		if (var3 == null || var3.l() == 0) {
			this.b.g = true;
			this.b.bg.a[this.b.bg.c] = ItemStack.b(this.b.bg.a[this.b.bg.c]);
			ajk var8 = this.b.bi.a((IInventory) this.b.bg, this.b.bg.c);
			this.b.bi.b();
			this.b.g = false;
			if (!ItemStack.matches(this.b.bg.h(), var1.c())) {
				this.sendPacket((Packet) (new PacketPlayOutSetSlot(this.b.bi.d, var8.e, this.b.bg.h())));
			}
		}

	}

	public void a(PacketPlayInStopSpectating var1) throws IOException {
		ig.a(var1, this, this.b.u());
		if (this.b.v()) {
			Entity var2 = null;
			WorldServer[] var3 = this.d.c;
			int var4 = var3.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				WorldServer var6 = var3[var5];
				if (var6 != null) {
					var2 = var1.a(var6);
					if (var2 != null) {
						break;
					}
				}
			}

			if (var2 != null) {
				this.b.e(this.b);
				this.b.a((Entity) null);
				if (var2.o != this.b.o) {
					WorldServer var7 = this.b.u();
					WorldServer var8 = (WorldServer) var2.o;
					this.b.am = var2.am;
					this.sendPacket((Packet) (new PacketPlayOutRespawn(this.b.am, var7.aa(), var7.getWorldData().getType(), this.b.c.b())));
					var7.removeEntity(this.b);
					this.b.I = false;
					this.b.setPositionRotation(var2.s, var2.t, var2.u, var2.y, var2.z);
					if (this.b.isAlive()) {
						var7.entityJoinedWorld((Entity) this.b, false);
						var8.addEntity(this.b);
						var8.entityJoinedWorld((Entity) this.b, false);
					}

					this.b.a((World) var8);
					this.d.an().a(this.b, var7);
					this.b.a(var2.s, var2.t, var2.u);
					this.b.c.a(var8);
					this.d.an().b(this.b, var8);
					this.d.an().f(this.b);
				} else {
					this.b.a(var2.s, var2.t, var2.u);
				}
			}
		}

	}

	public void a(PacketPlayInDownloadResult var1) {
	}

	public void a(IChatBaseComponent var1) {
		c.info(this.b.getName() + " lost connection: " + var1);
		this.d.aF();
		ChatMessage var2 = new ChatMessage("multiplayer.player.left", new Object[] { this.b.getScoreboardDisplayName() });
		var2.getChatModifier().setColor(EnumChatFormat.YELLOW);
		this.d.an().a((IChatBaseComponent) var2);
		this.b.q();
		this.d.an().e(this.b);
		if (this.d.S() && this.b.getName().equals(this.d.R())) {
			c.info("Stopping singleplayer server as player logged out");
			this.d.u();
		}

	}

	public void sendPacket(Packet var1) {
		if (var1 instanceof PacketPlayOutChat) {
			PacketPlayOutChat var2 = (PacketPlayOutChat) var1;
			EnumChatVisibility var3 = this.b.y();
			if (var3 == EnumChatVisibility.HIDDEN) {
				return;
			}

			if (var3 == EnumChatVisibility.SYSTEM && !var2.b()) {
				return;
			}
		}

		try {
			this.a.a(var1);
		} catch (Throwable var5) {
			CrashReport var6 = CrashReport.a(var5, "Sending packet");
			CrashReportSystemDetails var4 = var6.a("Packet being sent");
			var4.a("Packet class", (Callable) (new CrashReportConnectionPacketClass(this, var1)));
			throw new ReportedException(var6);
		}
	}

	public void a(PacketPlayInHeldItemSlot var1) {
		ig.a(var1, this, this.b.u());
		if (var1.a() >= 0 && var1.a() < ahb.i()) {
			this.b.bg.c = var1.a();
			this.b.z();
		} else {
			c.warn(this.b.getName() + " tried to set an invalid carried item");
		}
	}

	public void a(PacketPlayInChat var1) {
		ig.a(var1, this, this.b.u());
		if (this.b.y() == EnumChatVisibility.HIDDEN) {
			ChatMessage var4 = new ChatMessage("chat.cannotSend", new Object[0]);
			var4.getChatModifier().setColor(EnumChatFormat.RED);
			this.sendPacket((Packet) (new PacketPlayOutChat(var4)));
		} else {
			this.b.z();
			String var2 = var1.a();
			var2 = StringUtils.normalizeSpace(var2);

			for (int var3 = 0; var3 < var2.length(); ++var3) {
				if (!v.a(var2.charAt(var3))) {
					this.c("Illegal characters in chat");
					return;
				}
			}

			if (var2.startsWith("/")) {
				this.d(var2);
			} else {
				ChatMessage var5 = new ChatMessage("chat.type.text", new Object[] { this.b.getScoreboardDisplayName(), var2 });
				this.d.an().a(var5, false);
			}

			this.l += 20;
			if (this.l > 200 && !this.d.an().g(this.b.cc())) {
				this.c("disconnect.spam");
			}

		}
	}

	private void d(String var1) {
		this.d.O().a(this.b, var1);
	}

	public void a(PacketPlayInArmAnimation var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		this.b.bv();
	}

	public void a(PacketPlayInEntityAction var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		switch (rn.b[var1.b().ordinal()]) {
		case 1:
			this.b.c(true);
			break;
		case 2:
			this.b.c(false);
			break;
		case 3:
			this.b.d(true);
			break;
		case 4:
			this.b.d(false);
			break;
		case 5:
			this.b.a(false, true, true);
			this.r = false;
			break;
		case 6:
			if (this.b.m instanceof EntityHorse) {
				((EntityHorse) this.b.m).v(var1.c());
			}
			break;
		case 7:
			if (this.b.m instanceof EntityHorse) {
				((EntityHorse) this.b.m).g(this.b);
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid client command!");
		}

	}

	public void a(PacketPlayInUseEntity var1) throws IOException {
		ig.a(var1, this, this.b.u());
		WorldServer var2 = this.d.a(this.b.am);
		Entity var3 = var1.a((World) var2);
		this.b.z();
		if (var3 != null) {
			boolean var4 = this.b.t(var3);
			double var5 = 36.0D;
			if (!var4) {
				var5 = 9.0D;
			}

			if (this.b.h(var3) < var5) {
				if (var1.a() == me.a) {
					this.b.u(var3);
				} else if (var1.a() == me.c) {
					var3.a((EntityHuman) this.b, var1.b());
				} else if (var1.a() == me.b) {
					if (var3 instanceof EntityItem || var3 instanceof EntityExperienceOrb || var3 instanceof EntityArrow || var3 == this.b) {
						this.c("Attempting to attack an invalid entity");
						this.d.f("Player " + this.b.getName() + " tried to attack an invalid entity");
						return;
					}

					this.b.f(var3);
				}
			}
		}

	}

	public void a(PacketPlayInClientCommand var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		lw var2 = var1.a();
		switch (rn.c[var2.ordinal()]) {
		case 1:
			if (this.b.i) {
				this.b = this.d.an().a(this.b, 0, true);
			} else if (this.b.u().getWorldData().isHardcore()) {
				if (this.d.S() && this.b.getName().equals(this.d.R())) {
					this.b.a.c("You have died. Game over, man, it\'s game over!");
					this.d.Z();
				} else {
					GameProfileBanEntry var3 = new GameProfileBanEntry(this.b.cc(), (Date) null, "(You just lost the game)", (Date) null, "Death in Hardcore");
					this.d.an().i().a((JsonListEntry) var3);
					this.b.a.c("You have died. Game over, man, it\'s game over!");
				}
			} else {
				if (this.b.bm() > 0.0F) {
					return;
				}

				this.b = this.d.an().a(this.b, 0, false);
			}
			break;
		case 2:
			this.b.A().a(this.b);
			break;
		case 3:
			this.b.b((Statistic) AchievementList.f);
		}

	}

	public void a(PacketPlayInCloseWindow var1) {
		ig.a(var1, this, this.b.u());
		this.b.p();
	}

	public void a(PacketPlayInWindowClick var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		if (this.b.bi.d == var1.a() && this.b.bi.c(this.b)) {
			if (this.b.v()) {
				ArrayList var2 = Lists.newArrayList();

				for (int var3 = 0; var3 < this.b.bi.c.size(); ++var3) {
					var2.add(((ajk) this.b.bi.c.get(var3)).d());
				}

				this.b.a(this.b.bi, (List) var2);
			} else {
				ItemStack var5 = this.b.bi.a(var1.b(), var1.c(), var1.f(), this.b);
				if (ItemStack.matches(var1.e(), var5)) {
					this.b.a.sendPacket((Packet) (new PacketPlayOutTransaction(var1.a(), var1.d(), true)));
					this.b.g = true;
					this.b.bi.b();
					this.b.o();
					this.b.g = false;
				} else {
					this.n.a(this.b.bi.d, Short.valueOf(var1.d()));
					this.b.a.sendPacket((Packet) (new PacketPlayOutTransaction(var1.a(), var1.d(), false)));
					this.b.bi.a(this.b, false);
					ArrayList var6 = Lists.newArrayList();

					for (int var4 = 0; var4 < this.b.bi.c.size(); ++var4) {
						var6.add(((ajk) this.b.bi.c.get(var4)).d());
					}

					this.b.a(this.b.bi, (List) var6);
				}
			}
		}

	}

	public void a(PacketPlayInEnchantItem var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		if (this.b.bi.d == var1.a() && this.b.bi.c(this.b) && !this.b.v()) {
			this.b.bi.a((EntityHuman) this.b, var1.b());
			this.b.bi.b();
		}

	}

	public void a(PacketPlayInSetCreativeSlot var1) {
		ig.a(var1, this, this.b.u());
		if (this.b.c.d()) {
			boolean var2 = var1.a() < 0;
			ItemStack var3 = var1.b();
			if (var3 != null && var3.hasTag() && var3.getTag().hasKeyOfType("BlockEntityTag", 10)) {
				NBTTagCompound var4 = var3.getTag().getCompound("BlockEntityTag");
				if (var4.hasKey("x") && var4.hasKey("y") && var4.hasKey("z")) {
					Location var5 = new Location(var4.getInt("x"), var4.getInt("y"), var4.getInt("z"));
					TileEntity var6 = this.b.o.getTileEntity(var5);
					if (var6 != null) {
						NBTTagCompound var7 = new NBTTagCompound();
						var6.b(var7);
						var7.remove("x");
						var7.remove("y");
						var7.remove("z");
						var3.a("BlockEntityTag", (NBTBase) var7);
					}
				}
			}

			boolean var8 = var1.a() >= 1 && var1.a() < 36 + ahb.i();
			boolean var9 = var3 == null || var3.getItem() != null;
			boolean var10 = var3 == null || var3.getData() >= 0 && var3.count <= 64 && var3.count > 0;
			if (var8 && var9 && var10) {
				if (var3 == null) {
					this.b.bh.a(var1.a(), (ItemStack) null);
				} else {
					this.b.bh.a(var1.a(), var3);
				}

				this.b.bh.a(this.b, true);
			} else if (var2 && var9 && var10 && this.m < 200) {
				this.m += 20;
				EntityItem var11 = this.b.a(var3, true);
				if (var11 != null) {
					var11.j();
				}
			}
		}

	}

	public void a(PacketPlayInTransaction var1) {
		ig.a(var1, this, this.b.u());
		Short var2 = (Short) this.n.a(this.b.bi.d);
		if (var2 != null && var1.b() == var2.shortValue() && this.b.bi.d == var1.a() && !this.b.bi.c(this.b) && !this.b.v()) {
			this.b.bi.a(this.b, true);
		}

	}

	public void a(PacketPlayInUpdateSign var1) {
		ig.a(var1, this, this.b.u());
		this.b.z();
		WorldServer var2 = this.d.a(this.b.am);
		Location var3 = var1.a();
		if (var2.isLoaded(var3)) {
			TileEntity var4 = var2.getTileEntity(var3);
			if (!(var4 instanceof TileEntitySign)) {
				return;
			}

			TileEntitySign var5 = (TileEntitySign) var4;
			if (!var5.b() || var5.c() != this.b) {
				this.d.f("Player " + this.b.getName() + " just tried to change non-editable sign");
				return;
			}

			System.arraycopy(var1.b(), 0, var5.a, 0, 4);
			var5.o_();
			var2.notify(var3);
		}

	}

	public void a(PacketPlayInKeepAlive var1) {
		if (var1.a() == this.i) {
			int var2 = (int) (this.d() - this.j);
			this.b.h = (this.b.h * 3 + var2) / 4;
		}

	}

	private long d() {
		return System.nanoTime() / 1000000L;
	}

	public void a(PacketPlayInAbilities var1) {
		ig.a(var1, this, this.b.u());
		this.b.abilities.isFlying = var1.b() && this.b.abilities.canFly;
	}

	public void a(PacketPlayInTabComplete var1) {
		ig.a(var1, this, this.b.u());
		ArrayList var2 = Lists.newArrayList();
		Iterator var3 = this.d.a((ICommandListener) this.b, var1.a(), var1.b()).iterator();

		while (var3.hasNext()) {
			String var4 = (String) var3.next();
			var2.add(var4);
		}

		this.b.a.sendPacket((Packet) (new PacketPlayOutTabComplete((String[]) var2.toArray(new String[var2.size()]))));
	}

	public void a(PacketPlayInSettings var1) {
		ig.a(var1, this, this.b.u());
		this.b.a(var1);
	}

	public void a(PacketPlayInCustomPayload var1) {
		ig.a(var1, this, this.b.u());
		PacketDataSerializer var2;
		ItemStack var3;
		ItemStack var4;
		if ("MC|BEdit".equals(var1.a())) {
			var2 = new PacketDataSerializer(Unpooled.wrappedBuffer(var1.b()));

			try {
				var3 = var2.i();
				if (var3 == null) {
					return;
				}

				if (!ItemBookAndQuill.b(var3.getTag())) {
					throw new IOException("Invalid book tag!");
				}

				var4 = this.b.bg.h();
				if (var4 != null) {
					if (var3.getItem() == Items.BOOK_AND_QUILL && var3.getItem() == var4.getItem()) {
						var4.a("pages", (NBTBase) var3.getTag().getList("pages", 8));
					}

					return;
				}
			} catch (Exception var38) {
				c.error("Couldn\'t handle book info", var38);
				return;
			} finally {
				var2.release();
			}

			return;
		} else if ("MC|BSign".equals(var1.a())) {
			var2 = new PacketDataSerializer(Unpooled.wrappedBuffer(var1.b()));

			try {
				var3 = var2.i();
				if (var3 == null) {
					return;
				}

				if (!ItemWrittenBook.b(var3.getTag())) {
					throw new IOException("Invalid book tag!");
				}

				var4 = this.b.bg.h();
				if (var4 != null) {
					if (var3.getItem() == Items.WRITTEN_BOOK && var4.getItem() == Items.BOOK_AND_QUILL) {
						var4.a("author", (NBTBase) (new NBTTagString(this.b.getName())));
						var4.a("title", (NBTBase) (new NBTTagString(var3.getTag().getString("title"))));
						var4.a("pages", (NBTBase) var3.getTag().getList("pages", 8));
						var4.setItem(Items.WRITTEN_BOOK);
					}

					return;
				}
			} catch (Exception var36) {
				c.error("Couldn\'t sign book", var36);
				return;
			} finally {
				var2.release();
			}

			return;
		} else if ("MC|TrSel".equals(var1.a())) {
			try {
				int var40 = var1.b().readInt();
				aib var42 = this.b.bi;
				if (var42 instanceof ajf) {
					((ajf) var42).d(var40);
				}
			} catch (Exception var35) {
				c.error("Couldn\'t select trade", var35);
			}
		} else if ("MC|AdvCdm".equals(var1.a())) {
			if (!this.d.aj()) {
				this.b.sendMessage((IChatBaseComponent) (new ChatMessage("advMode.notEnabled", new Object[0])));
			} else if (this.b.a(2, "") && this.b.abilities.canInstantlyBuild) {
				var2 = var1.b();

				try {
					byte var43 = var2.readByte();
					CommandBlockListenerAbstract var46 = null;
					if (var43 == 0) {
						TileEntity var5 = this.b.o.getTileEntity(new Location(var2.readInt(), var2.readInt(), var2.readInt()));
						if (var5 instanceof TileEntityCommand) {
							var46 = ((TileEntityCommand) var5).getCommandBlock();
						}
					} else if (var43 == 1) {
						Entity var47 = this.b.o.getEntity(var2.readInt());
						if (var47 instanceof EntityMinecartCommandBlock) {
							var46 = ((EntityMinecartCommandBlock) var47).getCommandBlock();
						}
					}

					String var50 = var2.c(var2.readableBytes());
					boolean var6 = var2.readBoolean();
					if (var46 != null) {
						var46.a(var50);
						var46.a(var6);
						if (!var6) {
							var46.b((IChatBaseComponent) null);
						}

						var46.h();
						this.b.sendMessage((IChatBaseComponent) (new ChatMessage("advMode.setCommand.success", new Object[] { var50 })));
					}
				} catch (Exception var33) {
					c.error("Couldn\'t set command block", var33);
				} finally {
					var2.release();
				}
			} else {
				this.b.sendMessage((IChatBaseComponent) (new ChatMessage("advMode.notAllowed", new Object[0])));
			}
		} else if ("MC|Beacon".equals(var1.a())) {
			if (this.b.bi instanceof aig) {
				try {
					var2 = var1.b();
					int var44 = var2.readInt();
					int var49 = var2.readInt();
					aig var48 = (aig) this.b.bi;
					ajk var51 = var48.a(0);
					if (var51.e()) {
						var51.a(1);
						IInventory var7 = var48.e();
						var7.b(1, var44);
						var7.b(2, var49);
						var7.o_();
					}
				} catch (Exception var32) {
					c.error("Couldn\'t set beacon", var32);
				}
			}
		} else if ("MC|ItemName".equals(var1.a()) && this.b.bi instanceof aid) {
			aid var41 = (aid) this.b.bi;
			if (var1.b() != null && var1.b().readableBytes() >= 1) {
				String var45 = v.a(var1.b().c(32767));
				if (var45.length() <= 30) {
					var41.a(var45);
				}
			} else {
				var41.a("");
			}
		}

	}

}
