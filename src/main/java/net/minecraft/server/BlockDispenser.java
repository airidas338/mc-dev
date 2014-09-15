package net.minecraft.server;

import java.util.Random;

public class BlockDispenser extends atg {

	public static final beu a = beu.a("facing");
	public static final bet b = bet.a("triggered");
	public static final RegistryDefault M = new RegistryDefault(new DispenserBehaviorItem());
	protected Random N = new Random();

	protected BlockDispenser() {
		super(Material.STONE);
		this.j(this.L.b().a(a, EnumFacing.NORTH).a(b, Boolean.valueOf(false)));
		this.a(CreativeModeTab.d);
	}

	public int a(World var1) {
		return 4;
	}

	public void c(World var1, Location var2, IBlockData var3) {
		super.c(var1, var2, var3);
		this.e(var1, var2, var3);
	}

	private void e(World var1, Location var2, IBlockData var3) {
		if (!var1.isStatic) {
			EnumFacing var4 = (EnumFacing) var3.b(a);
			boolean var5 = var1.getData(var2.c()).c().m();
			boolean var6 = var1.getData(var2.d()).c().m();
			if (var4 == EnumFacing.NORTH && var5 && !var6) {
				var4 = EnumFacing.SOUTH;
			} else if (var4 == EnumFacing.SOUTH && var6 && !var5) {
				var4 = EnumFacing.NORTH;
			} else {
				boolean var7 = var1.getData(var2.e()).c().m();
				boolean var8 = var1.getData(var2.f()).c().m();
				if (var4 == EnumFacing.WEST && var7 && !var8) {
					var4 = EnumFacing.EAST;
				} else if (var4 == EnumFacing.EAST && var8 && !var7) {
					var4 = EnumFacing.WEST;
				}
			}

			var1.a(var2, var3.a(a, var4).a(b, Boolean.valueOf(false)), 2);
		}
	}

	public boolean a(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
		if (var1.isStatic) {
			return true;
		} else {
			TileEntity var9 = var1.s(var2);
			if (var9 instanceof bcx) {
				var4.a((IInventory) ((bcx) var9));
			}

			return true;
		}
	}

	protected void d(World var1, Location var2) {
		SourceBlock var3 = new SourceBlock(var1, var2);
		bcx var4 = (bcx) var3.h();
		if (var4 != null) {
			int var5 = var4.m();
			if (var5 < 0) {
				var1.b(1001, var2, 0);
			} else {
				ItemStack var6 = var4.a(var5);
				IDispenseBehavior var7 = this.a(var6);
				if (var7 != IDispenseBehavior.a) {
					ItemStack var8 = var7.a(var3, var6);
					var4.a(var5, var8.b == 0 ? null : var8);
				}

			}
		}
	}

	protected IDispenseBehavior a(ItemStack var1) {
		return (IDispenseBehavior) M.a(var1 == null ? null : var1.b());
	}

	public void a(World var1, Location var2, IBlockData var3, Block var4) {
		boolean var5 = var1.z(var2) || var1.z(var2.a());
		boolean var6 = ((Boolean) var3.b(b)).booleanValue();
		if (var5 && !var6) {
			var1.a(var2, (Block) this, this.a(var1));
			var1.a(var2, var3.a(b, Boolean.valueOf(true)), 4);
		} else if (!var5 && var6) {
			var1.a(var2, var3.a(b, Boolean.valueOf(false)), 4);
		}

	}

	public void b(World var1, Location var2, IBlockData var3, Random var4) {
		if (!var1.isStatic) {
			this.d(var1, var2);
		}

	}

	public TileEntity a(World var1, int var2) {
		return new bcx();
	}

	public IBlockData a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(a, BlockPiston.a(var1, var2, var8)).a(b, Boolean.valueOf(false));
	}

	public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
		var1.a(var2, var3.a(a, BlockPiston.a(var1, var2, var4)), 2);
		if (var5.s()) {
			TileEntity var6 = var1.s(var2);
			if (var6 instanceof bcx) {
				((bcx) var6).a(var5.q());
			}
		}

	}

	public void b(World var1, Location var2, IBlockData var3) {
		TileEntity var4 = var1.s(var2);
		if (var4 instanceof bcx) {
			vs.a(var1, var2, (bcx) var4);
			var1.e(var2, this);
		}

		super.b(var1, var2, var3);
	}

	public static IPosition a(ISourceBlock var0) {
		EnumFacing var1 = b(var0.f());
		double var2 = var0.getX() + 0.7D * (double) var1.g();
		double var4 = var0.getY() + 0.7D * (double) var1.h();
		double var6 = var0.getZ() + 0.7D * (double) var1.i();
		return new ey(var2, var4, var6);
	}

	public static EnumFacing b(int var0) {
		return EnumFacing.a(var0 & 7);
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, Location var2) {
		return aib.a(var1.s(var2));
	}

	public int b() {
		return 3;
	}

	public IBlockData a(int var1) {
		return this.P().a(a, b(var1)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	public int c(IBlockData var1) {
		byte var2 = 0;
		int var3 = var2 | ((EnumFacing) var1.b(a)).a();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}
