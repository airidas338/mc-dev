package net.minecraft.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;

public abstract class Entity implements ICommandListener {

	private static final AxisAlignedBB a = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	private static int b;
	private int c;
	public double j;
	public boolean k;
	public Entity l;
	public Entity m;
	public boolean n;
	public World o;
	public double p;
	public double q;
	public double r;
	public double s;
	public double t;
	public double u;
	public double v;
	public double w;
	public double x;
	public float y;
	public float z;
	public float A;
	public float B;
	private AxisAlignedBB f;
	public boolean C;
	public boolean D;
	public boolean E;
	public boolean F;
	public boolean G;
	protected boolean H;
	private boolean g;
	public boolean I;
	public float J;
	public float K;
	public float L;
	public float M;
	public float N;
	public float O;
	private int h;
	public double P;
	public double Q;
	public double R;
	public float S;
	public boolean T;
	public float U;
	protected Random V;
	public int W;
	public int X;
	private int i;
	protected boolean Y;
	public int Z;
	protected boolean aa;
	protected boolean ab;
	protected DataWatcher ac;
	private double ap;
	private double aq;
	public boolean ad;
	public int ae;
	public int af;
	public int ag;
	public boolean ah;
	public boolean ai;
	public int aj;
	protected boolean ak;
	protected int al;
	public int am;
	protected int an;
	private boolean ar;
	protected UUID ao;
	private final af as;

	public int F() {
		return this.c;
	}

	public void d(int var1) {
		this.c = var1;
	}

	public void G() {
		this.J();
	}

	public Entity(World var1) {
		this.c = b++;
		this.j = 1.0D;
		this.f = a;
		this.J = 0.6F;
		this.K = 1.8F;
		this.h = 1;
		this.V = new Random();
		this.X = 1;
		this.aa = true;
		this.ao = MathHelper.a(this.V);
		this.as = new af();
		this.o = var1;
		this.b(0.0D, 0.0D, 0.0D);
		if (var1 != null) {
			this.am = var1.worldProvider.q();
		}

		this.ac = new DataWatcher(this);
		this.ac.a(0, Byte.valueOf((byte) 0));
		this.ac.a(1, Short.valueOf((short) 300));
		this.ac.a(3, Byte.valueOf((byte) 0));
		this.ac.a(2, "");
		this.ac.a(4, Byte.valueOf((byte) 0));
		this.h();
	}

	protected abstract void h();

	public DataWatcher H() {
		return this.ac;
	}

	public boolean equals(Object var1) {
		return var1 instanceof Entity ? ((Entity) var1).c == this.c : false;
	}

	public int hashCode() {
		return this.c;
	}

	public void J() {
		this.I = true;
	}

	protected void a(float var1, float var2) {
		if (var1 != this.J || var2 != this.K) {
			float var3 = this.J;
			this.J = var1;
			this.K = var2;
			this.a(new AxisAlignedBB(this.aQ().a, this.aQ().b, this.aQ().c, this.aQ().a + (double) this.J, this.aQ().b + (double) this.K, this.aQ().c + (double) this.J));
			if (this.J > var3 && !this.aa && !this.o.isStatic) {
				this.d((double) (var3 - this.J), 0.0D, (double) (var3 - this.J));
			}
		}

	}

	protected void b(float var1, float var2) {
		this.y = var1 % 360.0F;
		this.z = var2 % 360.0F;
	}

	public void b(double var1, double var3, double var5) {
		this.s = var1;
		this.t = var3;
		this.u = var5;
		float var7 = this.J / 2.0F;
		float var8 = this.K;
		this.a(new AxisAlignedBB(var1 - (double) var7, var3, var5 - (double) var7, var1 + (double) var7, var3 + (double) var8, var5 + (double) var7));
	}

	public void s_() throws IOException {
		this.K();
	}

	public void K() throws IOException {
		this.o.methodProfiler.a("entityBaseTick");
		if (this.m != null && this.m.I) {
			this.m = null;
		}

		this.L = this.M;
		this.p = this.s;
		this.q = this.t;
		this.r = this.u;
		this.B = this.z;
		this.A = this.y;
		if (!this.o.isStatic && this.o instanceof WorldServer) {
			this.o.methodProfiler.a("portal");
			MinecraftServer var1 = ((WorldServer) this.o).r();
			int var2 = this.L();
			if (this.ak) {
				if (var1.A()) {
					if (this.m == null && this.al++ >= var2) {
						this.al = var2;
						this.aj = this.ar();
						byte var3;
						if (this.o.worldProvider.q() == -1) {
							var3 = 0;
						} else {
							var3 = -1;
						}

						this.c(var3);
					}

					this.ak = false;
				}
			} else {
				if (this.al > 0) {
					this.al -= 4;
				}

				if (this.al < 0) {
					this.al = 0;
				}
			}

			if (this.aj > 0) {
				--this.aj;
			}

			this.o.methodProfiler.b();
		}

		this.Y();
		this.W();
		if (this.o.isStatic) {
			this.i = 0;
		} else if (this.i > 0) {
			if (this.ab) {
				this.i -= 4;
				if (this.i < 0) {
					this.i = 0;
				}
			} else {
				if (this.i % 20 == 0) {
					this.a(DamageSource.c, 1.0F);
				}

				--this.i;
			}
		}

		if (this.ab()) {
			this.M();
			this.O *= 0.5F;
		}

		if (this.t < -64.0D) {
			this.O();
		}

		if (!this.o.isStatic) {
			this.b(0, this.i > 0);
		}

		this.aa = false;
		this.o.methodProfiler.b();
	}

	public int L() {
		return 0;
	}

	protected void M() {
		if (!this.ab) {
			this.a(DamageSource.d, 4.0F);
			this.e(15);
		}
	}

	public void e(int var1) {
		int var2 = var1 * 20;
		var2 = EnchantmentProtection.a(this, var2);
		if (this.i < var2) {
			this.i = var2;
		}

	}

	public void N() {
		this.i = 0;
	}

	protected void O() {
		this.J();
	}

	public boolean c(double var1, double var3, double var5) {
		AxisAlignedBB var7 = this.aQ().c(var1, var3, var5);
		return this.b(var7);
	}

	private boolean b(AxisAlignedBB var1) {
		return this.o.a(this, var1).isEmpty() && !this.o.d(var1);
	}

	public void d(double var1, double var3, double var5) {
		if (this.T) {
			this.a(this.aQ().c(var1, var3, var5));
			this.m();
		} else {
			this.o.methodProfiler.a("move");
			double var7 = this.s;
			double var9 = this.t;
			double var11 = this.u;
			if (this.H) {
				this.H = false;
				var1 *= 0.25D;
				var3 *= 0.05000000074505806D;
				var5 *= 0.25D;
				this.v = 0.0D;
				this.w = 0.0D;
				this.x = 0.0D;
			}

			double var13 = var1;
			double var15 = var3;
			double var17 = var5;
			boolean var19 = this.C && this.aw() && this instanceof EntityHuman;
			if (var19) {
				double var20;
				for (var20 = 0.05D; var1 != 0.0D && this.o.a(this, this.aQ().c(var1, -1.0D, 0.0D)).isEmpty(); var13 = var1) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}
				}

				for (; var5 != 0.0D && this.o.a(this, this.aQ().c(0.0D, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}

				for (; var1 != 0.0D && var5 != 0.0D && this.o.a(this, this.aQ().c(var1, -1.0D, var5)).isEmpty(); var17 = var5) {
					if (var1 < var20 && var1 >= -var20) {
						var1 = 0.0D;
					} else if (var1 > 0.0D) {
						var1 -= var20;
					} else {
						var1 += var20;
					}

					var13 = var1;
					if (var5 < var20 && var5 >= -var20) {
						var5 = 0.0D;
					} else if (var5 > 0.0D) {
						var5 -= var20;
					} else {
						var5 += var20;
					}
				}
			}

			List var53 = this.o.a(this, this.aQ().a(var1, var3, var5));
			AxisAlignedBB var21 = this.aQ();

			AxisAlignedBB var23;
			for (Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(this.aQ(), var3)) {
				var23 = (AxisAlignedBB) var22.next();
			}

			this.a(this.aQ().c(0.0D, var3, 0.0D));
			boolean var54 = this.C || var15 != var3 && var15 < 0.0D;

			AxisAlignedBB var24;
			Iterator var55;
			for (var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(this.aQ(), var1)) {
				var24 = (AxisAlignedBB) var55.next();
			}

			this.a(this.aQ().c(var1, 0.0D, 0.0D));

			for (var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(this.aQ(), var5)) {
				var24 = (AxisAlignedBB) var55.next();
			}

			this.a(this.aQ().c(0.0D, 0.0D, var5));
			if (this.S > 0.0F && var54 && (var13 != var1 || var17 != var5)) {
				double var57 = var1;
				double var25 = var3;
				double var27 = var5;
				AxisAlignedBB var29 = this.aQ();
				this.a(var21);
				var3 = (double) this.S;
				List var30 = this.o.a(this, this.aQ().a(var13, var3, var17));
				AxisAlignedBB var31 = this.aQ();
				AxisAlignedBB var32 = var31.a(var13, 0.0D, var17);
				double var33 = var3;

				AxisAlignedBB var36;
				for (Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.b(var32, var33)) {
					var36 = (AxisAlignedBB) var35.next();
				}

				var31 = var31.c(0.0D, var33, 0.0D);
				double var67 = var13;

				AxisAlignedBB var38;
				for (Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.a(var31, var67)) {
					var38 = (AxisAlignedBB) var37.next();
				}

				var31 = var31.c(var67, 0.0D, 0.0D);
				double var69 = var17;

				AxisAlignedBB var40;
				for (Iterator var39 = var30.iterator(); var39.hasNext(); var69 = var40.c(var31, var69)) {
					var40 = (AxisAlignedBB) var39.next();
				}

				var31 = var31.c(0.0D, 0.0D, var69);
				AxisAlignedBB var68 = this.aQ();
				double var70 = var3;

				AxisAlignedBB var43;
				for (Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.b(var68, var70)) {
					var43 = (AxisAlignedBB) var42.next();
				}

				var68 = var68.c(0.0D, var70, 0.0D);
				double var72 = var13;

				AxisAlignedBB var45;
				for (Iterator var44 = var30.iterator(); var44.hasNext(); var72 = var45.a(var68, var72)) {
					var45 = (AxisAlignedBB) var44.next();
				}

				var68 = var68.c(var72, 0.0D, 0.0D);
				double var73 = var17;

				AxisAlignedBB var47;
				for (Iterator var46 = var30.iterator(); var46.hasNext(); var73 = var47.c(var68, var73)) {
					var47 = (AxisAlignedBB) var46.next();
				}

				var68 = var68.c(0.0D, 0.0D, var73);
				double var71 = var67 * var67 + var69 * var69;
				double var48 = var72 * var72 + var73 * var73;
				if (var71 > var48) {
					var1 = var67;
					var5 = var69;
					this.a(var31);
				} else {
					var1 = var72;
					var5 = var73;
					this.a(var68);
				}

				var3 = (double) (-this.S);

				AxisAlignedBB var51;
				for (Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(this.aQ(), var3)) {
					var51 = (AxisAlignedBB) var50.next();
				}

				this.a(this.aQ().c(0.0D, var3, 0.0D));
				if (var57 * var57 + var27 * var27 >= var1 * var1 + var5 * var5) {
					var1 = var57;
					var3 = var25;
					var5 = var27;
					this.a(var29);
				}
			}

			this.o.methodProfiler.b();
			this.o.methodProfiler.a("rest");
			this.m();
			this.D = var13 != var1 || var17 != var5;
			this.E = var15 != var3;
			this.C = this.E && var15 < 0.0D;
			this.F = this.D || this.E;
			int var58 = MathHelper.floor(this.s);
			int var59 = MathHelper.floor(this.t - 0.20000000298023224D);
			int var56 = MathHelper.floor(this.u);
			Location var26 = new Location(var58, var59, var56);
			Block var62 = this.o.getData(var26).c();
			if (var62.r() == Material.AIR) {
				Block var28 = this.o.getData(var26.b()).c();
				if (var28 instanceof BlockFence || var28 instanceof BlockCobbleWall || var28 instanceof BlockFenceGate) {
					var62 = var28;
					var26 = var26.b();
				}
			}

			this.a(var3, this.C, var62, var26);
			if (var13 != var1) {
				this.v = 0.0D;
			}

			if (var17 != var5) {
				this.x = 0.0D;
			}

			if (var15 != var3) {
				var62.a(this.o, this);
			}

			if (this.r_() && !var19 && this.m == null) {
				double var61 = this.s - var7;
				double var63 = this.t - var9;
				double var66 = this.u - var11;
				if (var62 != Blocks.LADDER) {
					var63 = 0.0D;
				}

				if (var62 != null && this.C) {
					var62.a(this.o, var26, this);
				}

				this.M = (float) ((double) this.M + (double) MathHelper.sqrt(var61 * var61 + var66 * var66) * 0.6D);
				this.N = (float) ((double) this.N + (double) MathHelper.sqrt(var61 * var61 + var63 * var63 + var66 * var66) * 0.6D);
				if (this.N > (float) this.h && var62.r() != Material.AIR) {
					this.h = (int) this.N + 1;
					if (this.V()) {
						float var34 = MathHelper.sqrt(this.v * this.v * 0.20000000298023224D + this.w * this.w + this.x * this.x * 0.20000000298023224D) * 0.35F;
						if (var34 > 1.0F) {
							var34 = 1.0F;
						}

						this.a(this.P(), var34, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
					}

					this.a(var26, var62);
				}
			}

			try {
				this.Q();
			} catch (Throwable var52) {
				CrashReport var65 = CrashReport.a(var52, "Checking entity block collision");
				CrashReportSystemDetails var64 = var65.a("Entity being checked for collision");
				this.getAttributeInstance(var64);
				throw new ReportedException(var65);
			}

			boolean var60 = this.U();
			if (this.o.e(this.aQ().d(0.001D, 0.001D, 0.001D))) {
				this.f(1);
				if (!var60) {
					++this.i;
					if (this.i == 0) {
						this.e(8);
					}
				}
			} else if (this.i <= 0) {
				this.i = -this.X;
			}

			if (var60 && this.i > 0) {
				this.a("random.fizz", 0.7F, 1.6F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
				this.i = -this.X;
			}

			this.o.methodProfiler.b();
		}
	}

	private void m() {
		this.s = (this.aQ().a + this.aQ().d) / 2.0D;
		this.t = this.aQ().b;
		this.u = (this.aQ().c + this.aQ().f) / 2.0D;
	}

	protected String P() {
		return "game.neutral.swim";
	}

	protected void Q() {
		Location var1 = new Location(this.aQ().a + 0.001D, this.aQ().b + 0.001D, this.aQ().c + 0.001D);
		Location var2 = new Location(this.aQ().d - 0.001D, this.aQ().e - 0.001D, this.aQ().f - 0.001D);
		if (this.o.a(var1, var2)) {
			for (int var3 = var1.n(); var3 <= var2.n(); ++var3) {
				for (int var4 = var1.o(); var4 <= var2.o(); ++var4) {
					for (int var5 = var1.p(); var5 <= var2.p(); ++var5) {
						Location var6 = new Location(var3, var4, var5);
						IBlockData var7 = this.o.getData(var6);

						try {
							var7.c().a(this.o, var6, var7, this);
						} catch (Throwable var11) {
							CrashReport var9 = CrashReport.a(var11, "Colliding entity with block");
							CrashReportSystemDetails var10 = var9.a("Block being collided with");
							CrashReportSystemDetails.a(var10, var6, var7);
							throw new ReportedException(var9);
						}
					}
				}
			}
		}

	}

	protected void a(Location var1, Block var2) {
		StepSound var3 = var2.H;
		if (this.o.getData(var1.a()).c() == Blocks.SNOW) {
			var3 = Blocks.SNOW.H;
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		} else if (!var2.r().d()) {
			this.a(var3.c(), var3.d() * 0.15F, var3.e());
		}

	}

	public void a(String var1, float var2, float var3) {
		if (!this.R()) {
			this.o.a(this, var1, var2, var3);
		}

	}

	public boolean R() {
		return this.ac.a(4) == 1;
	}

	public void b(boolean var1) {
		this.ac.b(4, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	protected boolean r_() {
		return true;
	}

	protected void a(double var1, boolean var3, Block var4, Location var5) {
		if (var3) {
			if (this.O > 0.0F) {
				if (var4 != null) {
					var4.a(this.o, var5, this, this.O);
				} else {
					this.e(this.O, 1.0F);
				}

				this.O = 0.0F;
			}
		} else if (var1 < 0.0D) {
			this.O = (float) ((double) this.O - var1);
		}

	}

	public AxisAlignedBB S() {
		return null;
	}

	protected void f(int var1) {
		if (!this.ab) {
			this.a(DamageSource.a, (float) var1);
		}

	}

	public final boolean T() {
		return this.ab;
	}

	public void e(float var1, float var2) {
		if (this.l != null) {
			this.l.e(var1, var2);
		}

	}

	public boolean U() {
		return this.Y || this.o.C(new Location(this.s, this.t, this.u)) || this.o.C(new Location(this.s, this.t + (double) this.K, this.u));
	}

	public boolean V() {
		return this.Y;
	}

	public boolean W() {
		if (this.o.a(this.aQ().b(0.0D, -0.4000000059604645D, 0.0D).d(0.001D, 0.001D, 0.001D), Material.WATER, this)) {
			if (!this.Y && !this.aa) {
				this.X();
			}

			this.O = 0.0F;
			this.Y = true;
			this.i = 0;
		} else {
			this.Y = false;
		}

		return this.Y;
	}

	protected void X() {
		float var1 = MathHelper.sqrt(this.v * this.v * 0.20000000298023224D + this.w * this.w + this.x * this.x * 0.20000000298023224D) * 0.2F;
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		this.a(this.aa(), var1, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
		float var2 = (float) MathHelper.floor(this.aQ().b);

		int var3;
		float var4;
		float var5;
		for (var3 = 0; (float) var3 < 1.0F + this.J * 20.0F; ++var3) {
			var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			this.o.a(ew.e, this.s + (double) var4, (double) (var2 + 1.0F), this.u + (double) var5, this.v, this.w - (double) (this.V.nextFloat() * 0.2F), this.x, new int[0]);
		}

		for (var3 = 0; (float) var3 < 1.0F + this.J * 20.0F; ++var3) {
			var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
			this.o.a(ew.f, this.s + (double) var4, (double) (var2 + 1.0F), this.u + (double) var5, this.v, this.w, this.x, new int[0]);
		}

	}

	public void Y() {
		if (this.ax() && !this.V()) {
			this.Z();
		}

	}

	protected void Z() {
		int var1 = MathHelper.floor(this.s);
		int var2 = MathHelper.floor(this.t - 0.20000000298023224D);
		int var3 = MathHelper.floor(this.u);
		Location var4 = new Location(var1, var2, var3);
		IBlockData var5 = this.o.getData(var4);
		Block var6 = var5.c();
		if (var6.b() != -1) {
			this.o.a(ew.L, this.s + ((double) this.V.nextFloat() - 0.5D) * (double) this.J, this.aQ().b + 0.1D, this.u + ((double) this.V.nextFloat() - 0.5D) * (double) this.J, -this.v * 4.0D, 1.5D,
					-this.x * 4.0D, new int[] { Block.f(var5) });
		}

	}

	protected String aa() {
		return "game.neutral.swim.splash";
	}

	public boolean a(Material var1) {
		double var2 = this.t + (double) this.aR();
		Location var4 = new Location(this.s, var2, this.u);
		IBlockData var5 = this.o.getData(var4);
		Block var6 = var5.c();
		if (var6.r() == var1) {
			float var7 = axl.b(var5.c().c(var5)) - 0.11111111F;
			float var8 = (float) (var4.o() + 1) - var7;
			boolean var9 = var2 < (double) var8;
			return !var9 && this instanceof EntityHuman ? false : var9;
		} else {
			return false;
		}
	}

	public boolean ab() {
		return this.o.a(this.aQ().b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.LAVA);
	}

	public void a(float var1, float var2, float var3) {
		float var4 = var1 * var1 + var2 * var2;
		if (var4 >= 1.0E-4F) {
			var4 = MathHelper.c(var4);
			if (var4 < 1.0F) {
				var4 = 1.0F;
			}

			var4 = var3 / var4;
			var1 *= var4;
			var2 *= var4;
			float var5 = MathHelper.sin(this.y * 3.1415927F / 180.0F);
			float var6 = MathHelper.cos(this.y * 3.1415927F / 180.0F);
			this.v += (double) (var1 * var6 - var2 * var5);
			this.x += (double) (var2 * var6 + var1 * var5);
		}
	}

	public float c(float var1) {
		Location var2 = new Location(this.s, 0.0D, this.u);
		if (this.o.isLoaded(var2)) {
			double var3 = (this.aQ().e - this.aQ().b) * 0.66D;
			int var5 = MathHelper.floor(this.t + var3);
			return this.o.o(var2.b(var5));
		} else {
			return 0.0F;
		}
	}

	public void a(World var1) {
		this.o = var1;
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		this.p = this.s = var1;
		this.q = this.t = var3;
		this.r = this.u = var5;
		this.A = this.y = var7;
		this.B = this.z = var8;
		double var9 = (double) (this.A - var7);
		if (var9 < -180.0D) {
			this.A += 360.0F;
		}

		if (var9 >= 180.0D) {
			this.A -= 360.0F;
		}

		this.b(this.s, this.t, this.u);
		this.b(var7, var8);
	}

	public void a(Location var1, float var2, float var3) {
		this.setPositionRotation((double) var1.n() + 0.5D, (double) var1.o(), (double) var1.p() + 0.5D, var2, var3);
	}

	public void setPositionRotation(double var1, double var3, double var5, float var7, float var8) {
		this.P = this.p = this.s = var1;
		this.Q = this.q = this.t = var3;
		this.R = this.r = this.u = var5;
		this.y = var7;
		this.z = var8;
		this.b(this.s, this.t, this.u);
	}

	public float g(Entity var1) {
		float var2 = (float) (this.s - var1.s);
		float var3 = (float) (this.t - var1.t);
		float var4 = (float) (this.u - var1.u);
		return MathHelper.c(var2 * var2 + var3 * var3 + var4 * var4);
	}

	public double e(double var1, double var3, double var5) {
		double var7 = this.s - var1;
		double var9 = this.t - var3;
		double var11 = this.u - var5;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public double b(Location var1) {
		return var1.c(this.s, this.t, this.u);
	}

	public double c(Location var1) {
		return var1.d(this.s, this.t, this.u);
	}

	public double f(double var1, double var3, double var5) {
		double var7 = this.s - var1;
		double var9 = this.t - var3;
		double var11 = this.u - var5;
		return (double) MathHelper.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
	}

	public double h(Entity var1) {
		double var2 = this.s - var1.s;
		double var4 = this.t - var1.t;
		double var6 = this.u - var1.u;
		return var2 * var2 + var4 * var4 + var6 * var6;
	}

	public void d(EntityHuman var1) throws IOException {
	}

	public void i(Entity var1) {
		if (var1.l != this && var1.m != this) {
			if (!var1.T && !this.T) {
				double var2 = var1.s - this.s;
				double var4 = var1.u - this.u;
				double var6 = MathHelper.a(var2, var4);
				if (var6 >= 0.009999999776482582D) {
					var6 = (double) MathHelper.sqrt(var6);
					var2 /= var6;
					var4 /= var6;
					double var8 = 1.0D / var6;
					if (var8 > 1.0D) {
						var8 = 1.0D;
					}

					var2 *= var8;
					var4 *= var8;
					var2 *= 0.05000000074505806D;
					var4 *= 0.05000000074505806D;
					var2 *= (double) (1.0F - this.U);
					var4 *= (double) (1.0F - this.U);
					if (this.l == null) {
						this.g(-var2, 0.0D, -var4);
					}

					if (var1.l == null) {
						var1.g(var2, 0.0D, var4);
					}
				}

			}
		}
	}

	public void g(double var1, double var3, double var5) {
		this.v += var1;
		this.w += var3;
		this.x += var5;
		this.ai = true;
	}

	protected void ac() {
		this.G = true;
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			this.ac();
			return false;
		}
	}

	public Vec3D d(float var1) {
		if (var1 == 1.0F) {
			return this.f(this.z, this.y);
		} else {
			float var2 = this.B + (this.z - this.B) * var1;
			float var3 = this.A + (this.y - this.A) * var1;
			return this.f(var2, var3);
		}
	}

	protected final Vec3D f(float var1, float var2) {
		float var3 = MathHelper.cos(-var2 * 0.017453292F - 3.1415927F);
		float var4 = MathHelper.sin(-var2 * 0.017453292F - 3.1415927F);
		float var5 = -MathHelper.cos(-var1 * 0.017453292F);
		float var6 = MathHelper.sin(-var1 * 0.017453292F);
		return new Vec3D((double) (var4 * var5), (double) var6, (double) (var3 * var5));
	}

	public boolean ad() {
		return false;
	}

	public boolean ae() {
		return false;
	}

	public void b(Entity var1, int var2) {
	}

	public boolean c(NBTTagCompound var1) {
		String var2 = this.ag();
		if (!this.I && var2 != null) {
			var1.setString("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public boolean d(NBTTagCompound var1) {
		String var2 = this.ag();
		if (!this.I && var2 != null && this.l == null) {
			var1.setString("id", var2);
			this.e(var1);
			return true;
		} else {
			return false;
		}
	}

	public void e(NBTTagCompound var1) {
		try {
			var1.set("Pos", (NBTBase) this.a(new double[] { this.s, this.t, this.u }));
			var1.set("Motion", (NBTBase) this.a(new double[] { this.v, this.w, this.x }));
			var1.set("Rotation", (NBTBase) this.a(new float[] { this.y, this.z }));
			var1.setFloat("FallDistance", this.O);
			var1.setShort("Fire", (short) this.i);
			var1.setShort("Air", (short) this.aA());
			var1.setBoolean("OnGround", this.C);
			var1.setInt("Dimension", this.am);
			var1.setBoolean("Invulnerable", this.ar);
			var1.setInt("PortalCooldown", this.aj);
			var1.setLong("UUIDMost", this.aJ().getMostSignificantBits());
			var1.setLong("UUIDLeast", this.aJ().getLeastSignificantBits());
			if (this.aL() != null && this.aL().length() > 0) {
				var1.setString("CustomName", this.aL());
				var1.setBoolean("CustomNameVisible", this.aM());
			}

			this.as.b(var1);
			if (this.R()) {
				var1.setBoolean("Silent", this.R());
			}

			this.b(var1);
			if (this.m != null) {
				NBTTagCompound var2 = new NBTTagCompound();
				if (this.m.c(var2)) {
					var1.set("Riding", (NBTBase) var2);
				}
			}

		} catch (Throwable var5) {
			CrashReport var3 = CrashReport.a(var5, "Saving entity NBT");
			CrashReportSystemDetails var4 = var3.a("Entity being saved");
			this.getAttributeInstance(var4);
			throw new ReportedException(var3);
		}
	}

	public void f(NBTTagCompound var1) {
		try {
			NBTTagList var2 = var1.getList("Pos", 6);
			NBTTagList var6 = var1.getList("Motion", 6);
			NBTTagList var7 = var1.getList("Rotation", 5);
			this.v = var6.d(0);
			this.w = var6.d(1);
			this.x = var6.d(2);
			if (Math.abs(this.v) > 10.0D) {
				this.v = 0.0D;
			}

			if (Math.abs(this.w) > 10.0D) {
				this.w = 0.0D;
			}

			if (Math.abs(this.x) > 10.0D) {
				this.x = 0.0D;
			}

			this.p = this.P = this.s = var2.d(0);
			this.q = this.Q = this.t = var2.d(1);
			this.r = this.R = this.u = var2.d(2);
			this.A = this.y = var7.e(0);
			this.B = this.z = var7.e(1);
			this.O = var1.getFloat("FallDistance");
			this.i = var1.getShort("Fire");
			this.h(var1.getShort("Air"));
			this.C = var1.getBoolean("OnGround");
			this.am = var1.getInt("Dimension");
			this.ar = var1.getBoolean("Invulnerable");
			this.aj = var1.getInt("PortalCooldown");
			if (var1.hasKeyOfType("UUIDMost", 4) && var1.hasKeyOfType("UUIDLeast", 4)) {
				this.ao = new UUID(var1.getLong("UUIDMost"), var1.getLong("UUIDLeast"));
			} else if (var1.hasKeyOfType("UUID", 8)) {
				this.ao = UUID.fromString(var1.getString("UUID"));
			}

			this.b(this.s, this.t, this.u);
			this.b(this.y, this.z);
			if (var1.hasKeyOfType("CustomName", 8) && var1.getString("CustomName").length() > 0) {
				this.a(var1.getString("CustomName"));
			}

			this.g(var1.getBoolean("CustomNameVisible"));
			this.as.a(var1);
			this.b(var1.getBoolean("Silent"));
			this.a(var1);
			if (this.af()) {
				this.b(this.s, this.t, this.u);
			}

		} catch (Throwable var5) {
			CrashReport var3 = CrashReport.a(var5, "Loading entity NBT");
			CrashReportSystemDetails var4 = var3.a("Entity being loaded");
			this.getAttributeInstance(var4);
			throw new ReportedException(var3);
		}
	}

	protected boolean af() {
		return true;
	}

	protected final String ag() {
		return EntityTypes.b(this);
	}

	protected abstract void a(NBTTagCompound var1);

	protected abstract void b(NBTTagCompound var1);

	public void ah() {
	}

	protected NBTTagList a(double... var1) {
		NBTTagList var2 = new NBTTagList();
		double[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.a((NBTBase) (new NBTTagDouble(var6)));
		}

		return var2;
	}

	protected NBTTagList a(float... var1) {
		NBTTagList var2 = new NBTTagList();
		float[] var3 = var1;
		int var4 = var1.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			float var6 = var3[var5];
			var2.a((NBTBase) (new NBTTagFloat(var6)));
		}

		return var2;
	}

	public EntityItem a(Item var1, int var2) {
		return this.a(var1, var2, 0.0F);
	}

	public EntityItem a(Item var1, int var2, float var3) {
		return this.a(new ItemStack(var1, var2, 0), var3);
	}

	public EntityItem a(ItemStack var1, float var2) {
		if (var1.b != 0 && var1.b() != null) {
			EntityItem var3 = new EntityItem(this.o, this.s, this.t + (double) var2, this.u, var1);
			var3.p();
			this.o.d((Entity) var3);
			return var3;
		} else {
			return null;
		}
	}

	public boolean isAlive() {
		return !this.I;
	}

	public boolean aj() {
		if (this.T) {
			return false;
		} else {
			for (int var1 = 0; var1 < 8; ++var1) {
				double var2 = this.s + (double) (((float) ((var1 >> 0) % 2) - 0.5F) * this.J * 0.8F);
				double var4 = this.t + (double) (((float) ((var1 >> 1) % 2) - 0.5F) * 0.1F);
				double var6 = this.u + (double) (((float) ((var1 >> 2) % 2) - 0.5F) * this.J * 0.8F);
				if (this.o.getData(new Location(var2, var4 + (double) this.aR(), var6)).c().u()) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean e(EntityHuman var1) {
		return false;
	}

	public AxisAlignedBB j(Entity var1) {
		return null;
	}

	public void ak() throws IOException {
		if (this.m.I) {
			this.m = null;
		} else {
			this.v = 0.0D;
			this.w = 0.0D;
			this.x = 0.0D;
			this.s_();
			if (this.m != null) {
				this.m.al();
				this.aq += (double) (this.m.y - this.m.A);

				for (this.ap += (double) (this.m.z - this.m.B); this.aq >= 180.0D; this.aq -= 360.0D) {
					;
				}

				while (this.aq < -180.0D) {
					this.aq += 360.0D;
				}

				while (this.ap >= 180.0D) {
					this.ap -= 360.0D;
				}

				while (this.ap < -180.0D) {
					this.ap += 360.0D;
				}

				double var1 = this.aq * 0.5D;
				double var3 = this.ap * 0.5D;
				float var5 = 10.0F;
				if (var1 > (double) var5) {
					var1 = (double) var5;
				}

				if (var1 < (double) (-var5)) {
					var1 = (double) (-var5);
				}

				if (var3 > (double) var5) {
					var3 = (double) var5;
				}

				if (var3 < (double) (-var5)) {
					var3 = (double) (-var5);
				}

				this.aq -= var1;
				this.ap -= var3;
			}
		}
	}

	public void al() {
		if (this.l != null) {
			this.l.b(this.s, this.t + this.an() + this.l.am(), this.u);
		}
	}

	public double am() {
		return 0.0D;
	}

	public double an() {
		return (double) this.K * 0.75D;
	}

	public void a(Entity var1) {
		this.ap = 0.0D;
		this.aq = 0.0D;
		if (var1 == null) {
			if (this.m != null) {
				this.setPositionRotation(this.m.s, this.m.aQ().b + (double) this.m.K, this.m.u, this.y, this.z);
				this.m.l = null;
			}

			this.m = null;
		} else {
			if (this.m != null) {
				this.m.l = null;
			}

			if (var1 != null) {
				for (Entity var2 = var1.m; var2 != null; var2 = var2.m) {
					if (var2 == this) {
						return;
					}
				}
			}

			this.m = var1;
			var1.l = this;
		}
	}

	public float ao() {
		return 0.1F;
	}

	public Vec3D ap() {
		return null;
	}

	public void aq() {
		if (this.aj > 0) {
			this.aj = this.ar();
		} else {
			double var1 = this.p - this.s;
			double var3 = this.r - this.u;
			if (!this.o.isStatic && !this.ak) {
				int var5;
				if (MathHelper.e((float) var1) > MathHelper.e((float) var3)) {
					var5 = var1 > 0.0D ? EnumFacing.WEST.b() : EnumFacing.EAST.b();
				} else {
					var5 = var3 > 0.0D ? EnumFacing.NORTH.b() : EnumFacing.SOUTH.b();
				}

				this.an = var5;
			}

			this.ak = true;
		}
	}

	public int ar() {
		return 300;
	}

	public ItemStack[] at() {
		return null;
	}

	public void c(int var1, ItemStack var2) {
	}

	public boolean au() {
		boolean var1 = this.o != null && this.o.isStatic;
		return !this.ab && (this.i > 0 || var1 && this.g(0));
	}

	public boolean av() {
		return this.m != null;
	}

	public boolean aw() {
		return this.g(1);
	}

	public void c(boolean var1) {
		this.b(1, var1);
	}

	public boolean ax() {
		return this.g(3);
	}

	public void d(boolean var1) {
		this.b(3, var1);
	}

	public boolean ay() {
		return this.g(5);
	}

	public void e(boolean var1) {
		this.b(5, var1);
	}

	public void f(boolean var1) {
		this.b(4, var1);
	}

	protected boolean g(int var1) {
		return (this.ac.a(0) & 1 << var1) != 0;
	}

	protected void b(int var1, boolean var2) {
		byte var3 = this.ac.a(0);
		if (var2) {
			this.ac.b(0, Byte.valueOf((byte) (var3 | 1 << var1)));
		} else {
			this.ac.b(0, Byte.valueOf((byte) (var3 & ~(1 << var1))));
		}

	}

	public int aA() {
		return this.ac.b(1);
	}

	public void h(int var1) {
		this.ac.b(1, Short.valueOf((short) var1));
	}

	public void a(EntityLightning var1) {
		this.a(DamageSource.b, 5.0F);
		++this.i;
		if (this.i == 0) {
			this.e(8);
		}

	}

	public void a(EntityLiving var1) {
	}

	protected boolean j(double var1, double var3, double var5) {
		Location var7 = new Location(var1, var3, var5);
		double var8 = var1 - (double) var7.n();
		double var10 = var3 - (double) var7.o();
		double var12 = var5 - (double) var7.p();
		List var14 = this.o.a(this.aQ());
		if (var14.isEmpty() && !this.o.u(var7)) {
			return false;
		} else {
			byte var15 = 3;
			double var16 = 9999.0D;
			if (!this.o.u(var7.e()) && var8 < var16) {
				var16 = var8;
				var15 = 0;
			}

			if (!this.o.u(var7.f()) && 1.0D - var8 < var16) {
				var16 = 1.0D - var8;
				var15 = 1;
			}

			if (!this.o.u(var7.a()) && 1.0D - var10 < var16) {
				var16 = 1.0D - var10;
				var15 = 3;
			}

			if (!this.o.u(var7.c()) && var12 < var16) {
				var16 = var12;
				var15 = 4;
			}

			if (!this.o.u(var7.d()) && 1.0D - var12 < var16) {
				var16 = 1.0D - var12;
				var15 = 5;
			}

			float var18 = this.V.nextFloat() * 0.2F + 0.1F;
			if (var15 == 0) {
				this.v = (double) (-var18);
			}

			if (var15 == 1) {
				this.v = (double) var18;
			}

			if (var15 == 3) {
				this.w = (double) var18;
			}

			if (var15 == 4) {
				this.x = (double) (-var18);
			}

			if (var15 == 5) {
				this.x = (double) var18;
			}

			return true;
		}
	}

	public void aB() {
		this.H = true;
		this.O = 0.0F;
	}

	public String getName() {
		if (this.k_()) {
			return this.aL();
		} else {
			String var1 = EntityTypes.b(this);
			if (var1 == null) {
				var1 = "generic";
			}

			return fi.a("entity." + var1 + ".name");
		}
	}

	public Entity[] aC() {
		return null;
	}

	public boolean k(Entity var1) {
		return this == var1;
	}

	public float aD() {
		return 0.0F;
	}

	public void f(float var1) {
	}

	public boolean aE() {
		return true;
	}

	public boolean l(Entity var1) {
		return false;
	}

	public String toString() {
		return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[] { this.getClass().getSimpleName(), this.getName(), Integer.valueOf(this.c),
				this.o == null ? "~NULL~" : this.o.P().k(), Double.valueOf(this.s), Double.valueOf(this.t), Double.valueOf(this.u) });
	}

	public boolean b(DamageSource var1) {
		return this.ar && var1 != DamageSource.j && !var1.u();
	}

	public void m(Entity var1) {
		this.setPositionRotation(var1.s, var1.t, var1.u, var1.y, var1.z);
	}

	public void n(Entity var1) {
		NBTTagCompound var2 = new NBTTagCompound();
		var1.e(var2);
		this.f(var2);
		this.aj = var1.aj;
		this.an = var1.an;
	}

	public void c(int var1) throws IOException {
		if (!this.o.isStatic && !this.I) {
			this.o.methodProfiler.a("changeDimension");
			MinecraftServer var2 = MinecraftServer.M();
			int var3 = this.am;
			WorldServer var4 = var2.a(var3);
			WorldServer var5 = var2.a(var1);
			this.am = var1;
			if (var3 == 1 && var1 == 1) {
				var5 = var2.a(0);
				this.am = 0;
			}

			this.o.e(this);
			this.I = false;
			this.o.methodProfiler.a("reposition");
			var2.an().a(this, var3, var4, var5);
			this.o.methodProfiler.c("reloading");
			Entity var6 = EntityTypes.a(EntityTypes.b(this), (World) var5);
			if (var6 != null) {
				var6.n(this);
				if (var3 == 1 && var1 == 1) {
					Location var7 = this.o.r(var5.M());
					var6.a(var7, var6.y, var6.z);
				}

				var5.d(var6);
			}

			this.I = true;
			this.o.methodProfiler.b();
			var4.j();
			var5.j();
			this.o.methodProfiler.b();
		}
	}

	public float a(aqo var1, World var2, Location var3, IBlockData var4) {
		return var4.c().a(this);
	}

	public boolean a(aqo var1, World var2, Location var3, IBlockData var4, float var5) {
		return true;
	}

	public int aF() {
		return 3;
	}

	public int aG() {
		return this.an;
	}

	public boolean aH() {
		return false;
	}

	public void getAttributeInstance(CrashReportSystemDetails var1) {
		var1.a("Entity Type", (Callable) (new ww(this)));
		var1.a("Entity ID", (Object) Integer.valueOf(this.c));
		var1.a("Entity Name", (Callable) (new wx(this)));
		var1.a("Entity\'s Exact location", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.s), Double.valueOf(this.t), Double.valueOf(this.u) }));
		var1.a("Entity\'s Block location", (Object) CrashReportSystemDetails.a((double) MathHelper.floor(this.s), (double) MathHelper.floor(this.t), (double) MathHelper.floor(this.u)));
		var1.a("Entity\'s Momentum", (Object) String.format("%.2f, %.2f, %.2f", new Object[] { Double.valueOf(this.v), Double.valueOf(this.w), Double.valueOf(this.x) }));
		var1.a("Entity\'s Rider", (Callable) (new wy(this)));
		var1.a("Entity\'s Vehicle", (Callable) (new wz(this)));
	}

	public UUID aJ() {
		return this.ao;
	}

	public boolean aK() {
		return true;
	}

	public IChatBaseComponent getScoreboardDisplayName() {
		ChatComponentText var1 = new ChatComponentText(this.getName());
		var1.getChatModifier().a(this.aP());
		var1.getChatModifier().a(this.aJ().toString());
		return var1;
	}

	public void a(String var1) {
		this.ac.b(2, var1);
	}

	public String aL() {
		return this.ac.e(2);
	}

	public boolean k_() {
		return this.ac.e(2).length() > 0;
	}

	public void g(boolean var1) {
		this.ac.b(3, Byte.valueOf((byte) (var1 ? 1 : 0)));
	}

	public boolean aM() {
		return this.ac.a(3) == 1;
	}

	public void a(double var1, double var3, double var5) {
		this.setPositionRotation(var1, var3, var5, this.y, this.z);
	}

	public void i(int var1) {
	}

	public EnumFacing aO() {
		return EnumFacing.b(MathHelper.floor((double) (this.y * 4.0F / 360.0F) + 0.5D) & 3);
	}

	protected ChatHoverable aP() {
		NBTTagCompound var1 = new NBTTagCompound();
		String var2 = EntityTypes.b(this);
		var1.setString("id", this.aJ().toString());
		if (var2 != null) {
			var1.setString("type", var2);
		}

		var1.setString("name", this.getName());
		return new ChatHoverable(EnumHoverAction.SHOW_ENTITY, new ChatComponentText(var1.toString()));
	}

	public boolean a(EntityPlayer var1) {
		return true;
	}

	public AxisAlignedBB aQ() {
		return this.f;
	}

	public void a(AxisAlignedBB var1) {
		this.f = var1;
	}

	public float aR() {
		return this.K * 0.85F;
	}

	public boolean aS() {
		return this.g;
	}

	public void h(boolean var1) {
		this.g = var1;
	}

	public boolean d(int var1, ItemStack var2) {
		return false;
	}

	public void sendMessage(IChatBaseComponent var1) {
	}

	public boolean a(int var1, String var2) {
		return true;
	}

	public Location getLocation() {
		return new Location(this.s, this.t + 0.5D, this.u);
	}

	public Vec3D d() {
		return new Vec3D(this.s, this.t, this.u);
	}

	public World getWorld() {
		return this.o;
	}

	public Entity f() {
		return this;
	}

	public boolean t_() {
		return false;
	}

	public void a(ag var1, int var2) {
		this.as.a(this, var1, var2);
	}

	public af aT() {
		return this.as;
	}

	public void o(Entity var1) {
		this.as.a(var1.aT());
	}

	public NBTTagCompound aU() {
		return null;
	}

	public boolean a(EntityHuman var1, Vec3D var2) {
		return false;
	}

	public boolean aV() {
		return false;
	}

	protected void a(EntityLiving var1, Entity var2) {
		if (var2 instanceof EntityLiving) {
			EnchantmentManager.a((EntityLiving) var2, (Entity) var1);
		}

		EnchantmentManager.b(var1, var2);
	}

}
