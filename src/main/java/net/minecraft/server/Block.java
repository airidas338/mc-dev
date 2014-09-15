package net.minecraft.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Block {

    private static final RegistryPrepender a = new RegistryPrepender("air");
    public static final RegistryBlocks REGISTRY = new RegistryBlocks(a);
    public static final RegistryID d = new RegistryID();
    private CreativeModeTab b;
    public static final StepSound e = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound f = new StepSound("wood", 1.0F, 1.0F);
    public static final StepSound g = new StepSound("gravel", 1.0F, 1.0F);
    public static final StepSound h = new StepSound("grass", 1.0F, 1.0F);
    public static final StepSound i = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound j = new StepSound("stone", 1.0F, 1.5F);
    public static final StepSound k = new StepSoundStone("stone", 1.0F, 1.0F);
    public static final StepSound l = new StepSound("cloth", 1.0F, 1.0F);
    public static final StepSound m = new StepSound("sand", 1.0F, 1.0F);
    public static final StepSound n = new StepSound("snow", 1.0F, 1.0F);
    public static final StepSound o = new StepSoundLadder("ladder", 1.0F, 1.0F);
    public static final StepSound p = new StepSoundAnvil("anvil", 0.3F, 1.0F);
    public static final StepSound q = new StepSoundSlime("slime", 1.0F, 1.0F);
    protected boolean r;
    protected int s;
    protected boolean t;
    protected int u;
    protected boolean v;
    protected float w;
    protected float x;
    protected boolean y = true;
    protected boolean z;
    protected boolean A;
    protected double B;
    protected double C;
    protected double D;
    protected double E;
    protected double F;
    protected double G;
    public StepSound H;
    public float I;
    protected final Material J;
    public float K;
    protected final bed L;
    private IBlockData M;
    private String N;

    public static int a(Block var0) {
        return REGISTRY.b(var0);
    }

    public static int f(IBlockData var0) {
        return a(var0.c()) + (var0.c().c(var0) << 12);
    }

    public static Block c(int var0) {
        return (Block) REGISTRY.a(var0);
    }

    public static IBlockData d(int var0) {
        int var1 = var0 & 4095;
        int var2 = var0 >> 12 & 15;
        return c(var1).a(var2);
    }

    public static Block a(Item var0) {
        return var0 instanceof aju ? ((aju) var0).d() : null;
    }

    public static Block b(String var0) {
        RegistryPrepender var1 = new RegistryPrepender(var0);
        if (REGISTRY.d(var1)) {
            return (Block) REGISTRY.a(var1);
        } else {
            try {
                return (Block) REGISTRY.a(Integer.parseInt(var0));
            } catch (NumberFormatException var3) {
                return null;
            }
        }
    }

    public boolean m() {
        return this.r;
    }

    public int n() {
        return this.s;
    }

    public int p() {
        return this.u;
    }

    public boolean q() {
        return this.v;
    }

    public Material r() {
        return this.J;
    }

    public MaterialMapColor g(IBlockData var1) {
        return this.r().r();
    }

    public IBlockData a(int var1) {
        return this.P();
    }

    public int c(IBlockData var1) {
        if (var1 != null && !var1.a().isEmpty()) {
            throw new IllegalArgumentException("Don\'t know how to convert " + var1 + " back into data...");
        } else {
            return 0;
        }
    }

    public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
        return var1;
    }

    protected Block(Material var1) {
        this.H = e;
        this.I = 1.0F;
        this.K = 0.6F;
        this.J = var1;
        this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.r = this.c();
        this.s = this.c() ? 255 : 0;
        this.t = !var1.b();
        this.L = this.e();
        this.j(this.L.b());
    }

    protected Block a(StepSound var1) {
        this.H = var1;
        return this;
    }

    protected Block e(int var1) {
        this.s = var1;
        return this;
    }

    protected Block a(float var1) {
        this.u = (int) (15.0F * var1);
        return this;
    }

    protected Block b(float var1) {
        this.x = var1 * 3.0F;
        return this;
    }

    public boolean s() {
        return this.J.c() && this.d();
    }

    public boolean t() {
        return this.J.k() && this.d() && !this.g();
    }

    public boolean u() {
        return this.J.c() && this.d();
    }

    public boolean d() {
        return true;
    }

    public boolean b(IBlockAccess var1, Location var2) {
        return !this.J.c();
    }

    public int b() {
        return 3;
    }

    public boolean f(World var1, Location var2) {
        return false;
    }

    protected Block c(float var1) {
        this.w = var1;
        if (this.x < var1 * 5.0F) {
            this.x = var1 * 5.0F;
        }

        return this;
    }

    protected Block v() {
        this.c(-1.0F);
        return this;
    }

    public float g(World var1, Location var2) {
        return this.w;
    }

    protected Block a(boolean var1) {
        this.z = var1;
        return this;
    }

    public boolean w() {
        return this.z;
    }

    public boolean x() {
        return this.A;
    }

    protected final void a(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.B = (double) var1;
        this.C = (double) var2;
        this.D = (double) var3;
        this.E = (double) var4;
        this.F = (double) var5;
        this.G = (double) var6;
    }

    public boolean b(IBlockAccess var1, Location var2, EnumFacing var3) {
        return var1.getData(var2).c().r().a();
    }

    public void a(World var1, Location var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
        AxisAlignedBB var7 = this.a(var1, var2, var3);
        if (var7 != null && var4.b(var7)) {
            var5.add(var7);
        }

    }

    public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
        return new AxisAlignedBB((double) var2.n() + this.B, (double) var2.o() + this.C, (double) var2.p() + this.D, (double) var2.n() + this.E, (double) var2.o() + this.F, (double) var2.p() + this.G);
    }

    public boolean c() {
        return true;
    }

    public boolean a(IBlockData var1, boolean var2) {
        return this.y();
    }

    public boolean y() {
        return true;
    }

    public void a(World var1, Location var2, IBlockData var3, Random var4) {
        this.b(var1, var2, var3, var4);
    }

    public void b(World var1, Location var2, IBlockData var3, Random var4) {
    }

    public void d(World var1, Location var2, IBlockData var3) {
    }

    public void a(World var1, Location var2, IBlockData var3, Block var4) {
    }

    public int a(World var1) {
        return 10;
    }

    public void c(World var1, Location var2, IBlockData var3) {
    }

    public void b(World var1, Location var2, IBlockData var3) {
    }

    public int a(Random var1) {
        return 1;
    }

    public Item a(IBlockData var1, Random var2, int var3) {
        return Item.a(this);
    }

    public float a(EntityHuman var1, World var2, Location var3) {
        float var4 = this.g(var2, var3);
        return var4 < 0.0F ? 0.0F : (!var1.b(this) ? var1.a(this) / var4 / 100.0F : var1.a(this) / var4 / 30.0F);
    }

    public final void b(World var1, Location var2, IBlockData var3, int var4) {
        this.a(var1, var2, var3, 1.0F, var4);
    }

    public void a(World var1, Location var2, IBlockData var3, float var4, int var5) {
        if (!var1.isStatic) {
            int var6 = this.a(var5, var1.random);

            for (int var7 = 0; var7 < var6; ++var7) {
                if (var1.random.nextFloat() <= var4) {
                    Item var8 = this.a(var3, var1.random, var5);
                    if (var8 != null) {
                        a(var1, var2, new ItemStack(var8, 1, this.a(var3)));
                    }
                }
            }

        }
    }

    public static void a(World var0, Location var1, ItemStack var2) {
        if (!var0.isStatic && var0.Q().b("doTileDrops")) {
            float var3 = 0.5F;
            double var4 = (double) (var0.random.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
            double var6 = (double) (var0.random.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
            double var8 = (double) (var0.random.nextFloat() * var3) + (double) (1.0F - var3) * 0.5D;
            EntityItem var10 = new EntityItem(var0, (double) var1.n() + var4, (double) var1.o() + var6, (double) var1.p() + var8, var2);
            var10.p();
            var0.d((Entity) var10);
        }
    }

    protected void b(World var1, Location var2, int var3) {
        if (!var1.isStatic) {
            while (var3 > 0) {
                int var4 = EntityExperienceOrb.a(var3);
                var3 -= var4;
                var1.d((Entity) (new EntityExperienceOrb(var1, (double) var2.n() + 0.5D, (double) var2.o() + 0.5D, (double) var2.p() + 0.5D, var4)));
            }
        }

    }

    public int a(IBlockData var1) {
        return 0;
    }

    public float a(Entity var1) {
        return this.x / 5.0F;
    }

    public MovingObjectPosition a(World var1, Location var2, Vec3D var3, Vec3D var4) {
        this.a((IBlockAccess) var1, var2);
        var3 = var3.b((double) (-var2.n()), (double) (-var2.o()), (double) (-var2.p()));
        var4 = var4.b((double) (-var2.n()), (double) (-var2.o()), (double) (-var2.p()));
        Vec3D var5 = var3.a(var4, this.B);
        Vec3D var6 = var3.a(var4, this.E);
        Vec3D var7 = var3.b(var4, this.C);
        Vec3D var8 = var3.b(var4, this.F);
        Vec3D var9 = var3.c(var4, this.D);
        Vec3D var10 = var3.c(var4, this.G);
        if (!this.a(var5)) {
            var5 = null;
        }

        if (!this.a(var6)) {
            var6 = null;
        }

        if (!this.b(var7)) {
            var7 = null;
        }

        if (!this.b(var8)) {
            var8 = null;
        }

        if (!this.c(var9)) {
            var9 = null;
        }

        if (!this.c(var10)) {
            var10 = null;
        }

        Vec3D var11 = null;
        if (var5 != null && (var11 == null || var3.g(var5) < var3.g(var11))) {
            var11 = var5;
        }

        if (var6 != null && (var11 == null || var3.g(var6) < var3.g(var11))) {
            var11 = var6;
        }

        if (var7 != null && (var11 == null || var3.g(var7) < var3.g(var11))) {
            var11 = var7;
        }

        if (var8 != null && (var11 == null || var3.g(var8) < var3.g(var11))) {
            var11 = var8;
        }

        if (var9 != null && (var11 == null || var3.g(var9) < var3.g(var11))) {
            var11 = var9;
        }

        if (var10 != null && (var11 == null || var3.g(var10) < var3.g(var11))) {
            var11 = var10;
        }

        if (var11 == null) {
            return null;
        } else {
            EnumFacing var12 = null;
            if (var11 == var5) {
                var12 = EnumFacing.WEST;
            }

            if (var11 == var6) {
                var12 = EnumFacing.EAST;
            }

            if (var11 == var7) {
                var12 = EnumFacing.DOWN;
            }

            if (var11 == var8) {
                var12 = EnumFacing.UP;
            }

            if (var11 == var9) {
                var12 = EnumFacing.NORTH;
            }

            if (var11 == var10) {
                var12 = EnumFacing.SOUTH;
            }

            return new MovingObjectPosition(var11.b((double) var2.n(), (double) var2.o(), (double) var2.p()), var12, var2);
        }
    }

    private boolean a(Vec3D var1) {
        return var1 == null ? false : var1.b >= this.C && var1.b <= this.F && var1.c >= this.D && var1.c <= this.G;
    }

    private boolean b(Vec3D var1) {
        return var1 == null ? false : var1.a >= this.B && var1.a <= this.E && var1.c >= this.D && var1.c <= this.G;
    }

    private boolean c(Vec3D var1) {
        return var1 == null ? false : var1.a >= this.B && var1.a <= this.E && var1.b >= this.C && var1.b <= this.F;
    }

    public void a(World var1, Location var2, aqo var3) {
    }

    public boolean a(World var1, Location var2, EnumFacing var3, ItemStack var4) {
        return this.a(var1, var2, var3);
    }

    public boolean a(World var1, Location var2, EnumFacing var3) {
        return this.c(var1, var2);
    }

    public boolean c(World var1, Location var2) {
        return var1.getData(var2).c().J.j();
    }

    public boolean a(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
        return false;
    }

    public void a(World var1, Location var2, Entity var3) {
    }

    public IBlockData a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
        return this.a(var7);
    }

    public void a(World var1, Location var2, EntityHuman var3) {
    }

    public Vec3D a(World var1, Location var2, Entity var3, Vec3D var4) {
        return var4;
    }

    public void a(IBlockAccess var1, Location var2) {
    }

    public final double z() {
        return this.B;
    }

    public final double A() {
        return this.E;
    }

    public final double B() {
        return this.C;
    }

    public final double C() {
        return this.F;
    }

    public final double D() {
        return this.D;
    }

    public final double E() {
        return this.G;
    }

    public int a(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
        return 0;
    }

    public boolean g() {
        return false;
    }

    public void a(World var1, Location var2, IBlockData var3, Entity var4) throws IOException {
    }

    public int b(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
        return 0;
    }

    public void h() {
    }

    public void a(World var1, EntityHuman var2, Location var3, IBlockData var4, TileEntity var5) {
        var2.b(ty.H[a(this)]);
        var2.a(0.025F);
        if (this.G() && EnchantmentManager.e(var2)) {
            ItemStack var7 = this.i(var4);
            if (var7 != null) {
                a(var1, var3, var7);
            }
        } else {
            int var6 = EnchantmentManager.f(var2);
            this.b(var1, var3, var4, var6);
        }

    }

    protected boolean G() {
        return this.d() && !this.A;
    }

    protected ItemStack i(IBlockData var1) {
        int var2 = 0;
        Item var3 = Item.a(this);
        if (var3 != null && var3.k()) {
            var2 = this.c(var1);
        }

        return new ItemStack(var3, 1, var2);
    }

    public int a(int var1, Random var2) {
        return this.a(var2);
    }

    public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
    }

    public Block c(String var1) {
        this.N = var1;
        return this;
    }

    public String H() {
        return fi.a(this.a() + ".name");
    }

    public String a() {
        return "tile." + this.N;
    }

    public boolean a(World var1, Location var2, IBlockData var3, int var4, int var5) {
        return false;
    }

    public boolean I() {
        return this.y;
    }

    protected Block J() {
        this.y = false;
        return this;
    }

    public int i() {
        return this.J.m();
    }

    public void a(World var1, Location var2, Entity var3, float var4) {
        var3.e(var4, 1.0F);
    }

    public void a(World var1, Entity var2) {
        var2.w = 0.0D;
    }

    public int j(World var1, Location var2) {
        return this.a(var1.getData(var2));
    }

    public Block a(CreativeModeTab var1) {
        this.b = var1;
        return this;
    }

    public void a(World var1, Location var2, IBlockData var3, EntityHuman var4) {
    }

    public void k(World var1, Location var2) {
    }

    public boolean M() {
        return true;
    }

    public boolean a(aqo var1) {
        return true;
    }

    public boolean b(Block var1) {
        return this == var1;
    }

    public static boolean a(Block var0, Block var1) {
        return var0 != null && var1 != null ? (var0 == var1 ? true : var0.b(var1)) : false;
    }

    public boolean N() {
        return false;
    }

    public int l(World var1, Location var2) {
        return 0;
    }

    protected bed e() {
        return new bed(this, new bex[0]);
    }

    public bed O() {
        return this.L;
    }

    protected final void j(IBlockData var1) {
        this.M = var1;
    }

    public final IBlockData P() {
        return this.M;
    }

    public static void R() {
        a(0, a, (new BlockAir()).c("air"));
        a(1, "stone", (new BlockStone()).c(1.5F).b(10.0F).a(i).c("stone"));
        a(2, "grass", (new BlockGrass()).c(0.6F).a(h).c("grass"));
        a(3, "dirt", (new BlockDirt()).c(0.5F).a(g).c("dirt"));
        Block var0 = (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).c("stonebrick").a(CreativeModeTab.b);
        a(4, "cobblestone", var0);
        Block var1 = (new BlockWood()).c(2.0F).b(5.0F).a(f).c("wood");
        a(5, "planks", var1);
        a(6, "sapling", (new BlockSapling()).c(0.0F).a(h).c("sapling"));
        a(7, "bedrock", (new Block(Material.STONE)).v().b(6000000.0F).a(i).c("bedrock").J().a(CreativeModeTab.b));
        a(8, "flowing_water", (new BlockFlowing(Material.WATER)).c(100.0F).e(3).c("water").J());
        a(9, "water", (new BlockStationary(Material.WATER)).c(100.0F).e(3).c("water").J());
        a(10, "flowing_lava", (new BlockFlowing(Material.LAVA)).c(100.0F).a(1.0F).c("lava").J());
        a(11, "lava", (new BlockStationary(Material.LAVA)).c(100.0F).a(1.0F).c("lava").J());
        a(12, "sand", (new BlockSand()).c(0.5F).a(m).c("sand"));
        a(13, "gravel", (new BlockGravel()).c(0.6F).a(g).c("gravel"));
        a(14, "gold_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).c("oreGold"));
        a(15, "iron_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).c("oreIron"));
        a(16, "coal_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).c("oreCoal"));
        a(17, "log", (new BlockLog1()).c("log"));
        a(18, "leaves", (new BlockLeaves11()).c("leaves"));
        a(19, "sponge", (new BlockSponge()).c(0.6F).a(h).c("sponge"));
        a(20, "glass", (new BlockGlass(Material.SHATTERABLE, false)).c(0.3F).a(k).c("glass"));
        a(21, "lapis_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).c("oreLapis"));
        a(22, "lapis_block", (new BlockOreBlock(MaterialMapColor.H)).c(3.0F).b(5.0F).a(i).c("blockLapis").a(CreativeModeTab.b));
        a(23, "dispenser", (new BlockDispenser()).c(3.5F).a(i).c("dispenser"));
        Block var2 = (new BlockSandStone()).a(i).c(0.8F).c("sandStone");
        a(24, "sandstone", var2);
        a(25, "noteblock", (new BlockNote()).c(0.8F).c("musicBlock"));
        a(26, "bed", (new BlockBed()).a(f).c(0.2F).c("bed").J());
        a(27, "golden_rail", (new BlockPoweredRail()).c(0.7F).a(j).c("goldenRail"));
        a(28, "detector_rail", (new BlockMinecartDetector()).c(0.7F).a(j).c("detectorRail"));
        a(29, "sticky_piston", (new BlockPiston(true)).c("pistonStickyBase"));
        a(30, "web", (new BlockWeb()).e(1).c(4.0F).c("web"));
        a(31, "tallgrass", (new BlockLongGrass()).c(0.0F).a(h).c("tallgrass"));
        a(32, "deadbush", (new BlockDeadBush()).c(0.0F).a(h).c("deadbush"));
        a(33, "piston", (new BlockPiston(false)).c("pistonBase"));
        a(34, "piston_head", new BlockPistonExtension());
        a(35, "wool", (new BlockCloth(Material.CLOTH)).c(0.8F).a(l).c("cloth"));
        a(36, "piston_extension", new BlockPistonMoving());
        a(37, "yellow_flower", (new BlockYellowFlower()).c(0.0F).a(h).c("flower1"));
        a(38, "red_flower", (new BlockRedFlower()).c(0.0F).a(h).c("flower2"));
        Block var3 = (new BlockMushroom()).c(0.0F).a(h).a(0.125F).c("mushroom");
        a(39, "brown_mushroom", var3);
        Block var4 = (new BlockMushroom()).c(0.0F).a(h).c("mushroom");
        a(40, "red_mushroom", var4);
        a(41, "gold_block", (new BlockOreBlock(MaterialMapColor.F)).c(3.0F).b(10.0F).a(j).c("blockGold"));
        a(42, "iron_block", (new BlockOreBlock(MaterialMapColor.h)).c(5.0F).b(10.0F).a(j).c("blockIron"));
        a(43, "double_stone_slab", (new BlockStepDouble1()).c(2.0F).b(10.0F).a(i).c("stoneSlab"));
        a(44, "stone_slab", (new BlockStepSingle1()).c(2.0F).b(10.0F).a(i).c("stoneSlab"));
        Block var5 = (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).c("brick").a(CreativeModeTab.b);
        a(45, "brick_block", var5);
        a(46, "tnt", (new BlockTNT()).c(0.0F).a(h).c("tnt"));
        a(47, "bookshelf", (new BlockBookshelf()).c(1.5F).a(f).c("bookshelf"));
        a(48, "mossy_cobblestone", (new Block(Material.STONE)).c(2.0F).b(10.0F).a(i).c("stoneMoss").a(CreativeModeTab.b));
        a(49, "obsidian", (new BlockObsidian()).c(50.0F).b(2000.0F).a(i).c("obsidian"));
        a(50, "torch", (new BlockTorch()).c(0.0F).a(0.9375F).a(f).c("torch"));
        a(51, "fire", (new BlockFire()).c(0.0F).a(1.0F).a(l).c("fire").J());
        a(52, "mob_spawner", (new BlockMobSpawner()).c(5.0F).a(j).c("mobSpawner").J());
        a(53, "oak_stairs", (new BlockStairs(var1.P().a(BlockWood.a, ayx.a))).c("stairsWood"));
        a(54, "chest", (new BlockChest(0)).c(2.5F).a(f).c("chest"));
        a(55, "redstone_wire", (new BlockRedstoneWire()).c(0.0F).a(e).c("redstoneDust").J());
        a(56, "diamond_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).c("oreDiamond"));
        a(57, "diamond_block", (new BlockOreBlock(MaterialMapColor.G)).c(5.0F).b(10.0F).a(j).c("blockDiamond"));
        a(58, "crafting_table", (new BlockWorkbench()).c(2.5F).a(f).c("workbench"));
        a(59, "wheat", (new BlockCrops()).c("crops"));
        Block var6 = (new BlockSoil()).c(0.6F).a(g).c("farmland");
        a(60, "farmland", var6);
        a(61, "furnace", (new BlockFurnace(false)).c(3.5F).a(i).c("furnace").a(CreativeModeTab.c));
        a(62, "lit_furnace", (new BlockFurnace(true)).c(3.5F).a(i).a(0.875F).c("furnace"));
        a(63, "standing_sign", (new BlockStandingSign()).c(1.0F).a(f).c("sign").J());
        a(64, "wooden_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).c("doorOak").J());
        a(65, "ladder", (new BlockLadder()).c(0.4F).a(o).c("ladder"));
        a(66, "rail", (new BlockMinecartTrack()).c(0.7F).a(j).c("rail"));
        a(67, "stone_stairs", (new BlockStairs(var0.P())).c("stairsStone"));
        a(68, "wall_sign", (new BlockWallSign()).c(1.0F).a(f).c("sign").J());
        a(69, "lever", (new BlockLever()).c(0.5F).a(f).c("lever"));
        a(70, "stone_pressure_plate", (new BlockPressurePlateBinary(Material.STONE, azh.b)).c(0.5F).a(i).c("pressurePlateStone"));
        a(71, "iron_door", (new BlockDoor(Material.ORE)).c(5.0F).a(j).c("doorIron").J());
        a(72, "wooden_pressure_plate", (new BlockPressurePlateBinary(Material.WOOD, azh.a)).c(0.5F).a(f).c("pressurePlateWood"));
        a(73, "redstone_ore", (new BlockRedstoneOre(false)).c(3.0F).b(5.0F).a(i).c("oreRedstone").a(CreativeModeTab.b));
        a(74, "lit_redstone_ore", (new BlockRedstoneOre(true)).a(0.625F).c(3.0F).b(5.0F).a(i).c("oreRedstone"));
        a(75, "unlit_redstone_torch", (new BlockRedstoneTorch(false)).c(0.0F).a(f).c("notGate"));
        a(76, "redstone_torch", (new BlockRedstoneTorch(true)).c(0.0F).a(0.5F).a(f).c("notGate").a(CreativeModeTab.d));
        a(77, "stone_button", (new BlockStoneButton()).c(0.5F).a(i).c("button"));
        a(78, "snow_layer", (new BlockSnow()).c(0.1F).a(n).c("snow").e(0));
        a(79, "ice", (new BlockIce()).c(0.5F).e(3).a(k).c("ice"));
        a(80, "snow", (new BlockSnowBlock()).c(0.2F).a(n).c("snow"));
        a(81, "cactus", (new BlockCactus()).c(0.4F).a(l).c("cactus"));
        a(82, "clay", (new BlockClay()).c(0.6F).a(g).c("clay"));
        a(83, "reeds", (new BlockReed()).c(0.0F).a(h).c("reeds").J());
        a(84, "jukebox", (new BlockJukebox()).c(2.0F).b(10.0F).a(i).c("jukebox"));
        a(85, "fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).c("fence"));
        Block var7 = (new BlockPumpkin()).c(1.0F).a(f).c("pumpkin");
        a(86, "pumpkin", var7);
        a(87, "netherrack", (new BlockBloodStone()).c(0.4F).a(i).c("hellrock"));
        a(88, "soul_sand", (new BlockSlowSand()).c(0.5F).a(m).c("hellsand"));
        a(89, "glowstone", (new BlockLightStone(Material.SHATTERABLE)).c(0.3F).a(k).a(1.0F).c("lightgem"));
        a(90, "portal", (new BlockPortal()).c(-1.0F).a(k).a(0.75F).c("portal"));
        a(91, "lit_pumpkin", (new BlockPumpkin()).c(1.0F).a(f).a(1.0F).c("litpumpkin"));
        a(92, "cake", (new BlockCake()).c(0.5F).a(l).c("cake").J());
        a(93, "unpowered_repeater", (new BlockRepeater(false)).c(0.0F).a(f).c("diode").J());
        a(94, "powered_repeater", (new BlockRepeater(true)).c(0.0F).a(f).c("diode").J());
        a(95, "stained_glass", (new BlockStainedGlass(Material.SHATTERABLE)).c(0.3F).a(k).c("stainedGlass"));
        a(96, "trapdoor", (new BlockTrapdoor(Material.WOOD)).c(3.0F).a(f).c("trapdoor").J());
        a(97, "monster_egg", (new BlockMonsterEggs()).c(0.75F).c("monsterStoneEgg"));
        Block var8 = (new BlockSmoothBrick()).c(1.5F).b(10.0F).a(i).c("stonebricksmooth");
        a(98, "stonebrick", var8);
        a(99, "brown_mushroom_block", (new BlockHugeMushroom(Material.WOOD, var3)).c(0.2F).a(f).c("mushroom"));
        a(100, "red_mushroom_block", (new BlockHugeMushroom(Material.WOOD, var4)).c(0.2F).a(f).c("mushroom"));
        a(101, "iron_bars", (new BlockThin(Material.ORE, true)).c(5.0F).b(10.0F).a(j).c("fenceIron"));
        a(102, "glass_pane", (new BlockThin(Material.SHATTERABLE, false)).c(0.3F).a(k).c("thinGlass"));
        Block var9 = (new BlockMelon()).c(1.0F).a(f).c("melon");
        a(103, "melon_block", var9);
        a(104, "pumpkin_stem", (new BlockStem(var7)).c(0.0F).a(f).c("pumpkinStem"));
        a(105, "melon_stem", (new BlockStem(var9)).c(0.0F).a(f).c("pumpkinStem"));
        a(106, "vine", (new BlockVine()).c(0.2F).a(h).c("vine"));
        a(107, "fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).c("fenceGate"));
        a(108, "brick_stairs", (new BlockStairs(var5.P())).c("stairsBrick"));
        a(109, "stone_brick_stairs", (new BlockStairs(var8.P().a(BlockSmoothBrick.a, bbd.a))).c("stairsStoneBrickSmooth"));
        a(110, "mycelium", (new BlockMycel()).c(0.6F).a(h).c("mycel"));
        a(111, "waterlily", (new BlockWaterLily()).c(0.0F).a(h).c("waterlily"));
        Block var10 = (new BlockHellBrick()).c(2.0F).b(10.0F).a(i).c("netherBrick").a(CreativeModeTab.b);
        a(112, "nether_brick", var10);
        a(113, "nether_brick_fence", (new BlockFence(Material.STONE)).c(2.0F).b(10.0F).a(i).c("netherFence"));
        a(114, "nether_brick_stairs", (new BlockStairs(var10.P())).c("stairsNetherBrick"));
        a(115, "nether_wart", (new BlockNetherWart()).c("netherStalk"));
        a(116, "enchanting_table", (new BlockEnchantmentTable()).c(5.0F).b(2000.0F).c("enchantmentTable"));
        a(117, "brewing_stand", (new BlockBrewingStand()).c(0.5F).a(0.125F).c("brewingStand"));
        a(118, "cauldron", (new BlockCauldron()).c(2.0F).c("cauldron"));
        a(119, "end_portal", (new BlockEnderPortal(Material.PORTAL)).c(-1.0F).b(6000000.0F));
        a(120, "end_portal_frame", (new BlockEnderPortalFrame()).a(k).a(0.125F).c(-1.0F).c("endPortalFrame").b(6000000.0F).a(CreativeModeTab.c));
        a(121, "end_stone", (new Block(Material.STONE)).c(3.0F).b(15.0F).a(i).c("whiteStone").a(CreativeModeTab.b));
        a(122, "dragon_egg", (new BlockDragonEgg()).c(3.0F).b(15.0F).a(i).a(0.125F).c("dragonEgg"));
        a(123, "redstone_lamp", (new BlockRedstoneLamp(false)).c(0.3F).a(k).c("redstoneLight").a(CreativeModeTab.d));
        a(124, "lit_redstone_lamp", (new BlockRedstoneLamp(true)).c(0.3F).a(k).c("redstoneLight"));
        a(125, "double_wooden_slab", (new BlockWoodStepDouble()).c(2.0F).b(5.0F).a(f).c("woodSlab"));
        a(126, "wooden_slab", (new BlockWoodStepSingle()).c(2.0F).b(5.0F).a(f).c("woodSlab"));
        a(127, "cocoa", (new BlockCocoa()).c(0.2F).b(5.0F).a(f).c("cocoa"));
        a(128, "sandstone_stairs", (new BlockStairs(var2.P().a(BlockSandStone.a, bae.c))).c("stairsSandStone"));
        a(129, "emerald_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).c("oreEmerald"));
        a(130, "ender_chest", (new BlockEnderChest()).c(22.5F).b(1000.0F).a(i).c("enderChest").a(0.5F));
        a(131, "tripwire_hook", (new BlockTripwireHook()).c("tripWireSource"));
        a(132, "tripwire", (new BlockTripwire()).c("tripWire"));
        a(133, "emerald_block", (new BlockOreBlock(MaterialMapColor.I)).c(5.0F).b(10.0F).a(j).c("blockEmerald"));
        a(134, "spruce_stairs", (new BlockStairs(var1.P().a(BlockWood.a, ayx.b))).c("stairsWoodSpruce"));
        a(135, "birch_stairs", (new BlockStairs(var1.P().a(BlockWood.a, ayx.c))).c("stairsWoodBirch"));
        a(136, "jungle_stairs", (new BlockStairs(var1.P().a(BlockWood.a, ayx.d))).c("stairsWoodJungle"));
        a(137, "command_block", (new BlockCommand()).v().b(6000000.0F).c("commandBlock"));
        a(138, "beacon", (new BlockBeacon()).c("beacon").a(1.0F));
        a(139, "cobblestone_wall", (new BlockCobbleWall(var0)).c("cobbleWall"));
        a(140, "flower_pot", (new BlockFlowerPot()).c(0.0F).a(e).c("flowerPot"));
        a(141, "carrots", (new BlockCarrots()).c("carrots"));
        a(142, "potatoes", (new BlockPotatoes()).c("potatoes"));
        a(143, "wooden_button", (new BlockWoodButton()).c(0.5F).a(f).c("button"));
        a(144, "skull", (new BlockSkull()).c(1.0F).a(i).c("skull"));
        a(145, "anvil", (new BlockAnvil()).c(5.0F).a(p).b(2000.0F).c("anvil"));
        a(146, "trapped_chest", (new BlockChest(1)).c(2.5F).a(f).c("chestTrap"));
        a(147, "light_weighted_pressure_plate", (new BlockPressurePlateWeighed("gold_block", Material.ORE, 15)).c(0.5F).a(f).c("weightedPlate_light"));
        a(148, "heavy_weighted_pressure_plate", (new BlockPressurePlateWeighed("iron_block", Material.ORE, 150)).c(0.5F).a(f).c("weightedPlate_heavy"));
        a(149, "unpowered_comparator", (new BlockRedstoneComparator(false)).c(0.0F).a(f).c("comparator").J());
        a(150, "powered_comparator", (new BlockRedstoneComparator(true)).c(0.0F).a(0.625F).a(f).c("comparator").J());
        a(151, "daylight_detector", new BlockDaylightDetector(false));
        a(152, "redstone_block", (new BlockRedstone(MaterialMapColor.f)).c(5.0F).b(10.0F).a(j).c("blockRedstone"));
        a(153, "quartz_ore", (new BlockOre()).c(3.0F).b(5.0F).a(i).c("netherquartz"));
        a(154, "hopper", (new BlockHopper()).c(3.0F).b(8.0F).a(j).c("hopper"));
        Block var11 = (new BlockQuartz()).a(i).c(0.8F).c("quartzBlock");
        a(155, "quartz_block", var11);
        a(156, "quartz_stairs", (new BlockStairs(var11.P().a(BlockQuartz.a, azn.a))).c("stairsQuartz"));
        a(157, "activator_rail", (new BlockPoweredRail()).c(0.7F).a(j).c("activatorRail"));
        a(158, "dropper", (new BlockDropper()).c(3.5F).a(i).c("dropper"));
        a(159, "stained_hardened_clay", (new BlockCloth(Material.STONE)).c(1.25F).b(7.0F).a(i).c("clayHardenedStained"));
        a(160, "stained_glass_pane", (new BlockStainedGlassPane()).c(0.3F).a(k).c("thinStainedGlass"));
        a(161, "leaves2", (new BlockLeaves2()).c("leaves"));
        a(162, "log2", (new BlockLogs2()).c("log"));
        a(163, "acacia_stairs", (new BlockStairs(var1.P().a(BlockWood.a, ayx.e))).c("stairsWoodAcacia"));
        a(164, "dark_oak_stairs", (new BlockStairs(var1.P().a(BlockWood.a, ayx.f))).c("stairsWoodDarkOak"));
        a(165, "slime", (new BlockSlime()).c("slime").a(q));
        a(166, "barrier", (new BlockBarrier()).c("barrier"));
        a(167, "iron_trapdoor", (new BlockTrapdoor(Material.ORE)).c(5.0F).a(j).c("ironTrapdoor").J());
        a(168, "prismarine", (new BlockPrismarine()).c(1.5F).b(10.0F).a(i).c("prismarine"));
        a(169, "sea_lantern", (new BlockSeaLantern(Material.SHATTERABLE)).c(0.3F).a(k).a(1.0F).c("seaLantern"));
        a(170, "hay_block", (new BlockHay()).c(0.5F).a(h).c("hayBlock").a(CreativeModeTab.b));
        a(171, "carpet", (new BlockCarpet()).c(0.1F).a(l).c("woolCarpet").e(0));
        a(172, "hardened_clay", (new BlockHardenedClay()).c(1.25F).b(7.0F).a(i).c("clayHardened"));
        a(173, "coal_block", (new Block(Material.STONE)).c(5.0F).b(10.0F).a(i).c("blockCoal").a(CreativeModeTab.b));
        a(174, "packed_ice", (new BlockPackedIce()).c(0.5F).a(k).c("icePacked"));
        a(175, "double_plant", new BlockTallPlant());
        a(176, "standing_banner", (new BlockBannerStanding()).c(1.0F).a(f).c("banner").J());
        a(177, "wall_banner", (new BlockBannerWall()).c(1.0F).a(f).c("banner").J());
        a(178, "daylight_detector_inverted", new BlockDaylightDetector(true));
        Block var12 = (new BlockSandstoneRed()).a(i).c(0.8F).c("redSandStone");
        a(179, "red_sandstone", var12);
        a(180, "red_sandstone_stairs", (new BlockStairs(var12.P().a(BlockSandstoneRed.a, azr.c))).c("stairsRedSandStone"));
        a(181, "double_stone_slab2", (new BlockStepDouble2()).c(2.0F).b(10.0F).a(i).c("stoneSlab2"));
        a(182, "stone_slab2", (new BlockStepSingle2()).c(2.0F).b(10.0F).a(i).c("stoneSlab2"));
        a(183, "spruce_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).c("spruceFenceGate"));
        a(184, "birch_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).c("birchFenceGate"));
        a(185, "jungle_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).c("jungleFenceGate"));
        a(186, "dark_oak_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).c("darkOakFenceGate"));
        a(187, "acacia_fence_gate", (new BlockFenceGate()).c(2.0F).b(5.0F).a(f).c("acaciaFenceGate"));
        a(188, "spruce_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).c("spruceFence"));
        a(189, "birch_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).c("birchFence"));
        a(190, "jungle_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).c("jungleFence"));
        a(191, "dark_oak_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).c("darkOakFence"));
        a(192, "acacia_fence", (new BlockFence(Material.WOOD)).c(2.0F).b(5.0F).a(f).c("acaciaFence"));
        a(193, "spruce_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).c("doorSpruce").J());
        a(194, "birch_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).c("doorBirch").J());
        a(195, "jungle_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).c("doorJungle").J());
        a(196, "acacia_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).c("doorAcacia").J());
        a(197, "dark_oak_door", (new BlockDoor(Material.WOOD)).c(3.0F).a(f).c("doorDarkOak").J());
        REGISTRY.a();
        Iterator var13 = REGISTRY.iterator();

        Block var14;
        while (var13.hasNext()) {
            var14 = (Block) var13.next();
            if (var14.J == Material.AIR) {
                var14.v = false;
            } else {
                boolean var15 = false;
                boolean var16 = var14 instanceof BlockStairs;
                boolean var17 = var14 instanceof BlockStepAbstract;
                boolean var18 = var14 == var6;
                boolean var19 = var14.t;
                boolean var20 = var14.s == 0;
                if (var16 || var17 || var18 || var19 || var20) {
                    var15 = true;
                }

                var14.v = var15;
            }
        }

        var13 = REGISTRY.iterator();

        while (var13.hasNext()) {
            var14 = (Block) var13.next();
            Iterator var22 = var14.O().a().iterator();

            while (var22.hasNext()) {
                IBlockData var21 = (IBlockData) var22.next();
                int var23 = REGISTRY.b(var14) << 4 | var14.c(var21);
                d.a(var21, var23);
            }
        }

    }

    private static void a(int var0, RegistryPrepender var1, Block var2) {
        REGISTRY.a(var0, var1, var2);
    }

    private static void a(int var0, String var1, Block var2) {
        a(var0, new RegistryPrepender(var1), var2);
    }

}
