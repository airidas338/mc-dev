package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;

public abstract class World implements IBlockAccess {

    protected boolean e;
    public final List entityList = Lists.newArrayList();
    protected final List g = Lists.newArrayList();
    public final List tileEntityList = Lists.newArrayList();
    public final List i = Lists.newArrayList();
    private final List a = Lists.newArrayList();
    private final List b = Lists.newArrayList();
    public final List players = Lists.newArrayList();
    public final List k = Lists.newArrayList();
    protected final IntHashMap l = new IntHashMap();
    private long c = 16777215L;
    private int d;
    protected int m = (new Random()).nextInt();
    protected final int n = 1013904223;
    protected float o;
    protected float p;
    protected float q;
    protected float r;
    private int I;
    public final Random random = new Random();
    public final WorldProvider worldProvider;
    protected List u = Lists.newArrayList();
    protected IChunkProvider chunkProvider;
    protected final IDataManager dataManager;
    protected WorldData worldData;
    protected boolean isLoading;
    protected PersistentCollection worldMaps;
    protected VillageSiege siegeManager;
    public final MethodProfiler methodProfiler;
    private final Calendar J = Calendar.getInstance();
    protected Scoreboard scoreboard = new Scoreboard();
    public final boolean isStatic;
    protected Set chunkTickList = Sets.newHashSet();
    private int K;
    protected boolean allowMonsters;
    protected boolean allowAnimals;
    private boolean L;
    private final WorldBorder M;
    int[] H;

    protected World(IDataManager var1, WorldData var2, WorldProvider var3, MethodProfiler var4, boolean var5) {
        this.K = this.random.nextInt(12000);
        this.allowMonsters = true;
        this.allowAnimals = true;
        this.H = new int['\u8000'];
        this.dataManager = var1;
        this.methodProfiler = var4;
        this.worldData = var2;
        this.worldProvider = var3;
        this.isStatic = var5;
        this.M = var3.r();
    }

    public World b() {
        return this;
    }

    public BiomeBase getBiome(Location var1) {
        if (this.isLoaded(var1)) {
            Chunk var2 = this.f(var1);

            try {
                return var2.getBiome(var1, this.worldProvider.m()); //TODO: Rename to getBiome
            } catch (Throwable var6) {
                CrashReport var4 = CrashReport.a(var6, "Getting biome");
                CrashReportSystemDetails var5 = var4.a("Coordinates of biome request");
                var5.a("Location", (Callable) (new CrashReportWorldLocation(this, var1))); //TODO: CrashReportWorldLocation
                throw new ReportedException(var4);
            }
        } else {
            return this.worldProvider.m().a(var1, BiomeBase.PLAINS);
        }
    }

    public WorldChunkManager getWorldChunkManager() {
        return this.worldProvider.m();
    }

    protected abstract IChunkProvider k();

    public void a(WorldSettings var1) {
        this.worldData.d(true);
    }

    public Block getType(Location var1) {
        Location var2;
        for (var2 = new Location(var1.n(), 63, var1.p()); !this.isEmpty(var2.a()); var2 = var2.a()) {
            ;
        }

        return this.getData(var2).c();
    }

    private boolean a(Location var1) {
        return var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000 && var1.o() >= 0 && var1.o() < 256;
    }

    public boolean isEmpty(Location var1) {
        return this.getData(var1).c().r() == Material.AIR;
    }

    public boolean isLoaded(Location var1) {
        return this.isLoaded(var1, true);
    }

    public boolean isLoaded(Location var1, boolean var2) {
        return !this.a(var1) ? false : this.a(var1.n() >> 4, var1.p() >> 4, var2);
    }

    public boolean a(Location var1, int var2) {
        return this.a(var1, var2, true);
    }

    public boolean a(Location var1, int var2, boolean var3) {
        return this.a(var1.n() - var2, var1.o() - var2, var1.p() - var2, var1.n() + var2, var1.o() + var2, var1.p() + var2, var3);
    }

    public boolean a(Location var1, Location var2) {
        return this.a(var1, var2, true);
    }

    public boolean a(Location var1, Location var2, boolean var3) {
        return this.a(var1.n(), var1.o(), var1.p(), var2.n(), var2.o(), var2.p(), var3);
    }

    public boolean a(bjb var1) {
        return this.b(var1, true);
    }

    public boolean b(bjb var1, boolean var2) {
        return this.a(var1.a, var1.b, var1.c, var1.d, var1.e, var1.f, var2);
    }

    private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
        if (var5 >= 0 && var2 < 256) {
            var1 >>= 4;
            var3 >>= 4;
            var4 >>= 4;
            var6 >>= 4;

            for (int var8 = var1; var8 <= var4; ++var8) {
                for (int var9 = var3; var9 <= var6; ++var9) {
                    if (!this.a(var8, var9, var7)) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    protected boolean a(int var1, int var2, boolean var3) {
        return this.chunkProvider.isChunkLoaded(var1, var2) && (var3 || !this.chunkProvider.getOrCreateChunk(var1, var2).f());
    }

    public Chunk f(Location var1) {
        return this.getChunkAt(var1.n() >> 4, var1.p() >> 4);
    }

    public Chunk getChunkAt(int var1, int var2) {
        return this.chunkProvider.getOrCreateChunk(var1, var2);
    }

    public boolean a(Location var1, IBlockData var2, int var3) {
        if (!this.a(var1)) {
            return false;
        } else if (!this.isStatic && this.worldData.u() == WorldType.DEBUG) {
            return false;
        } else {
            Chunk var4 = this.f(var1);
            Block var5 = var2.c();
            IBlockData var6 = var4.a(var1, var2);
            if (var6 == null) {
                return false;
            } else {
                Block var7 = var6.c();
                if (var5.n() != var7.n() || var5.p() != var7.p()) {
                    this.methodProfiler.a("checkLight");
                    this.x(var1);
                    this.methodProfiler.b();
                }

                if ((var3 & 2) != 0 && (!this.isStatic || (var3 & 4) == 0) && var4.i()) {
                    this.h(var1);
                }

                if (!this.isStatic && (var3 & 1) != 0) {
                    this.b(var1, var6.c());
                    if (var5.N()) {
                        this.e(var1, var5);
                    }
                }

                return true;
            }
        }
    }

    public boolean g(Location var1) {
        return this.a(var1, Blocks.AIR.P(), 3);
    }

    public boolean b(Location var1, boolean var2) {
        IBlockData var3 = this.getData(var1);
        Block var4 = var3.c();
        if (var4.r() == Material.AIR) {
            return false;
        } else {
            this.b(2001, var1, Block.f(var3));
            if (var2) {
                var4.b(this, var1, var3, 0);
            }

            return this.a(var1, Blocks.AIR.P(), 3);
        }
    }

    public boolean a(Location var1, IBlockData var2) {
        return this.a(var1, var2, 3);
    }

    public void h(Location var1) {
        for (int var2 = 0; var2 < this.u.size(); ++var2) {
            ((IWorldAccess) this.u.get(var2)).a(var1);
        }

    }

    public void b(Location var1, Block var2) {
        if (this.worldData.u() != WorldType.DEBUG) {
            this.c(var1, var2);
        }

    }

    public void a(int var1, int var2, int var3, int var4) {
        int var5;
        if (var3 > var4) {
            var5 = var4;
            var4 = var3;
            var3 = var5;
        }

        if (!this.worldProvider.o()) {
            for (var5 = var3; var5 <= var4; ++var5) {
                this.c(EnumSkyBlock.SKY, new Location(var1, var5, var2));
            }
        }

        this.b(var1, var3, var2, var1, var4, var2);
    }

    public void b(Location var1, Location var2) {
        this.b(var1.n(), var1.o(), var1.p(), var2.n(), var2.o(), var2.p());
    }

    public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
        for (int var7 = 0; var7 < this.u.size(); ++var7) {
            ((IWorldAccess) this.u.get(var7)).a(var1, var2, var3, var4, var5, var6);
        }

    }

    public void c(Location var1, Block var2) {
        this.d(var1.e(), var2);
        this.d(var1.f(), var2);
        this.d(var1.b(), var2);
        this.d(var1.a(), var2);
        this.d(var1.c(), var2);
        this.d(var1.d(), var2);
    }

    public void a(Location var1, Block var2, EnumFacing var3) {
        if (var3 != EnumFacing.WEST) {
            this.d(var1.e(), var2);
        }

        if (var3 != EnumFacing.EAST) {
            this.d(var1.f(), var2);
        }

        if (var3 != EnumFacing.DOWN) {
            this.d(var1.b(), var2);
        }

        if (var3 != EnumFacing.UP) {
            this.d(var1.a(), var2);
        }

        if (var3 != EnumFacing.NORTH) {
            this.d(var1.c(), var2);
        }

        if (var3 != EnumFacing.SOUTH) {
            this.d(var1.d(), var2);
        }

    }

    public void d(Location var1, Block var2) {
        if (!this.isStatic) {
            IBlockData var3 = this.getData(var1);

            try {
                var3.c().a(this, var1, var3, var2);
            } catch (Throwable var7) {
                CrashReport var5 = CrashReport.a(var7, "Exception while updating neighbours");
                CrashReportSystemDetails var6 = var5.a("Block being updated");
                var6.a("Source block type", (Callable) (new CrashReportSourceBlockType(this, var2)));
                CrashReportSystemDetails.a(var6, var1, var3);
                throw new ReportedException(var5);
            }
        }
    }

    public boolean a(Location var1, Block var2) {
        return false;
    }

    public boolean i(Location var1) {
        return this.f(var1).d(var1);
    }

    public boolean j(Location var1) {
        if (var1.o() >= 63) {
            return this.i(var1);
        } else {
            Location var2 = new Location(var1.n(), 63, var1.p());
            if (!this.i(var2)) {
                return false;
            } else {
                for (var2 = var2.b(); var2.o() > var1.o(); var2 = var2.b()) {
                    Block var3 = this.getData(var2).c();
                    if (var3.n() > 0 && !var3.r().d()) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public int k(Location var1) {
        if (var1.o() < 0) {
            return 0;
        } else {
            if (var1.o() >= 256) {
                var1 = new Location(var1.n(), 255, var1.p());
            }

            return this.f(var1).a(var1, 0);
        }
    }

    public int l(Location var1) {
        return this.c(var1, true);
    }

    public int c(Location var1, boolean var2) {
        if (var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000) {
            if (var2 && this.getData(var1).c().q()) {
                int var8 = this.c(var1.a(), false);
                int var4 = this.c(var1.f(), false);
                int var5 = this.c(var1.e(), false);
                int var6 = this.c(var1.d(), false);
                int var7 = this.c(var1.c(), false);
                if (var4 > var8) {
                    var8 = var4;
                }

                if (var5 > var8) {
                    var8 = var5;
                }

                if (var6 > var8) {
                    var8 = var6;
                }

                if (var7 > var8) {
                    var8 = var7;
                }

                return var8;
            } else if (var1.o() < 0) {
                return 0;
            } else {
                if (var1.o() >= 256) {
                    var1 = new Location(var1.n(), 255, var1.p());
                }

                Chunk var3 = this.f(var1);
                return var3.a(var1, this.d);
            }
        } else {
            return 15;
        }
    }

    public Location m(Location var1) {
        int var2;
        if (var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000) {
            if (this.a(var1.n() >> 4, var1.p() >> 4, true)) {
                var2 = this.getChunkAt(var1.n() >> 4, var1.p() >> 4).b(var1.n() & 15, var1.p() & 15);
            } else {
                var2 = 0;
            }
        } else {
            var2 = 64;
        }

        return new Location(var1.n(), var2, var1.p());
    }

    public int b(int var1, int var2) {
        if (var1 >= -30000000 && var2 >= -30000000 && var1 < 30000000 && var2 < 30000000) {
            if (!this.a(var1 >> 4, var2 >> 4, true)) {
                return 0;
            } else {
                Chunk var3 = this.getChunkAt(var1 >> 4, var2 >> 4);
                return var3.v();
            }
        } else {
            return 64;
        }
    }

    public int b(EnumSkyBlock var1, Location var2) {
        if (var2.o() < 0) {
            var2 = new Location(var2.n(), 0, var2.p());
        }

        if (!this.a(var2)) {
            return var1.c;
        } else if (!this.isLoaded(var2)) {
            return var1.c;
        } else {
            Chunk var3 = this.f(var2);
            return var3.a(var1, var2);
        }
    }

    public void a(EnumSkyBlock var1, Location var2, int var3) {
        if (this.a(var2)) {
            if (this.isLoaded(var2)) {
                Chunk var4 = this.f(var2);
                var4.a(var1, var2, var3);
                this.n(var2);
            }
        }
    }

    public void n(Location var1) {
        for (int var2 = 0; var2 < this.u.size(); ++var2) {
            ((IWorldAccess) this.u.get(var2)).b(var1);
        }

    }

    public float o(Location var1) {
        return this.worldProvider.p()[this.l(var1)];
    }

    public IBlockData getData(Location var1) {
        if (!this.a(var1)) {
            return Blocks.AIR.P();
        } else {
            Chunk var2 = this.f(var1);
            return var2.g(var1);
        }
    }

    public boolean w() {
        return this.d < 4;
    }

    public MovingObjectPosition a(Vec3D var1, Vec3D var2) {
        return this.a(var1, var2, false, false, false);
    }

    public MovingObjectPosition a(Vec3D var1, Vec3D var2, boolean var3) {
        return this.a(var1, var2, var3, false, false);
    }

    public MovingObjectPosition a(Vec3D var1, Vec3D var2, boolean var3, boolean var4, boolean var5) {
        if (!Double.isNaN(var1.a) && !Double.isNaN(var1.b) && !Double.isNaN(var1.c)) {
            if (!Double.isNaN(var2.a) && !Double.isNaN(var2.b) && !Double.isNaN(var2.c)) {
                int var6 = MathHelper.floor(var2.a);
                int var7 = MathHelper.floor(var2.b);
                int var8 = MathHelper.floor(var2.c);
                int var9 = MathHelper.floor(var1.a);
                int var10 = MathHelper.floor(var1.b);
                int var11 = MathHelper.floor(var1.c);
                Location var12 = new Location(var9, var10, var11);
                new Location(var6, var7, var8);
                IBlockData var14 = this.getData(var12);
                Block var15 = var14.c();
                if ((!var4 || var15.a(this, var12, var14) != null) && var15.a(var14, var3)) {
                    MovingObjectPosition var16 = var15.a(this, var12, var1, var2);
                    if (var16 != null) {
                        return var16;
                    }
                }

                MovingObjectPosition var42 = null;
                int var41 = 200;

                while (var41-- >= 0) {
                    if (Double.isNaN(var1.a) || Double.isNaN(var1.b) || Double.isNaN(var1.c)) {
                        return null;
                    }

                    if (var9 == var6 && var10 == var7 && var11 == var8) {
                        return var5 ? var42 : null;
                    }

                    boolean var43 = true;
                    boolean var17 = true;
                    boolean var18 = true;
                    double var19 = 999.0D;
                    double var21 = 999.0D;
                    double var23 = 999.0D;
                    if (var6 > var9) {
                        var19 = (double) var9 + 1.0D;
                    } else if (var6 < var9) {
                        var19 = (double) var9 + 0.0D;
                    } else {
                        var43 = false;
                    }

                    if (var7 > var10) {
                        var21 = (double) var10 + 1.0D;
                    } else if (var7 < var10) {
                        var21 = (double) var10 + 0.0D;
                    } else {
                        var17 = false;
                    }

                    if (var8 > var11) {
                        var23 = (double) var11 + 1.0D;
                    } else if (var8 < var11) {
                        var23 = (double) var11 + 0.0D;
                    } else {
                        var18 = false;
                    }

                    double var25 = 999.0D;
                    double var27 = 999.0D;
                    double var29 = 999.0D;
                    double var31 = var2.a - var1.a;
                    double var33 = var2.b - var1.b;
                    double var35 = var2.c - var1.c;
                    if (var43) {
                        var25 = (var19 - var1.a) / var31;
                    }

                    if (var17) {
                        var27 = (var21 - var1.b) / var33;
                    }

                    if (var18) {
                        var29 = (var23 - var1.c) / var35;
                    }

                    if (var25 == -0.0D) {
                        var25 = -1.0E-4D;
                    }

                    if (var27 == -0.0D) {
                        var27 = -1.0E-4D;
                    }

                    if (var29 == -0.0D) {
                        var29 = -1.0E-4D;
                    }

                    EnumFacing var37;
                    if (var25 < var27 && var25 < var29) {
                        var37 = var6 > var9 ? EnumFacing.WEST : EnumFacing.EAST;
                        var1 = new Vec3D(var19, var1.b + var33 * var25, var1.c + var35 * var25);
                    } else if (var27 < var29) {
                        var37 = var7 > var10 ? EnumFacing.DOWN : EnumFacing.UP;
                        var1 = new Vec3D(var1.a + var31 * var27, var21, var1.c + var35 * var27);
                    } else {
                        var37 = var8 > var11 ? EnumFacing.NORTH : EnumFacing.SOUTH;
                        var1 = new Vec3D(var1.a + var31 * var29, var1.b + var33 * var29, var23);
                    }

                    var9 = MathHelper.floor(var1.a) - (var37 == EnumFacing.EAST ? 1 : 0);
                    var10 = MathHelper.floor(var1.b) - (var37 == EnumFacing.UP ? 1 : 0);
                    var11 = MathHelper.floor(var1.c) - (var37 == EnumFacing.SOUTH ? 1 : 0);
                    var12 = new Location(var9, var10, var11);
                    IBlockData var38 = this.getData(var12);
                    Block var39 = var38.c();
                    if (!var4 || var39.a(this, var12, var38) != null) {
                        if (var39.a(var38, var3)) {
                            MovingObjectPosition var40 = var39.a(this, var12, var1, var2);
                            if (var40 != null) {
                                return var40;
                            }
                        } else {
                            var42 = new MovingObjectPosition(brv.a, var1, var37, var12);
                        }
                    }
                }

                return var5 ? var42 : null;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void a(Entity var1, String var2, float var3, float var4) {
        for (int var5 = 0; var5 < this.u.size(); ++var5) {
            ((IWorldAccess) this.u.get(var5)).a(var2, var1.s, var1.t, var1.u, var3, var4);
        }

    }

    public void a(EntityHuman var1, String var2, float var3, float var4) {
        for (int var5 = 0; var5 < this.u.size(); ++var5) {
            ((IWorldAccess) this.u.get(var5)).a(var1, var2, var1.s, var1.t, var1.u, var3, var4);
        }

    }

    public void a(double var1, double var3, double var5, String var7, float var8, float var9) {
        for (int var10 = 0; var10 < this.u.size(); ++var10) {
            ((IWorldAccess) this.u.get(var10)).a(var7, var1, var3, var5, var8, var9);
        }

    }

    public void a(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
    }

    public void a(Location var1, String var2) {
        for (int var3 = 0; var3 < this.u.size(); ++var3) {
            ((IWorldAccess) this.u.get(var3)).a(var2, var1);
        }

    }

    public void a(ew var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
        this.a(var1.c(), var1.e(), var2, var4, var6, var8, var10, var12, var14);
    }

    private void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
        for (int var16 = 0; var16 < this.u.size(); ++var16) {
            ((IWorldAccess) this.u.get(var16)).a(var1, var2, var3, var5, var7, var9, var11, var13, var15);
        }

    }

    public boolean c(Entity var1) {
        this.k.add(var1);
        return true;
    }

    public boolean d(Entity var1) {
        int var2 = MathHelper.floor(var1.s / 16.0D);
        int var3 = MathHelper.floor(var1.u / 16.0D);
        boolean var4 = var1.n;
        if (var1 instanceof EntityHuman) {
            var4 = true;
        }

        if (!var4 && !this.a(var2, var3, true)) {
            return false;
        } else {
            if (var1 instanceof EntityHuman) {
                EntityHuman var5 = (EntityHuman) var1;
                this.players.add(var5);
                this.d();
            }

            this.getChunkAt(var2, var3).a(var1);
            this.entityList.add(var1);
            this.a(var1);
            return true;
        }
    }

    protected void a(Entity var1) {
        for (int var2 = 0; var2 < this.u.size(); ++var2) {
            ((IWorldAccess) this.u.get(var2)).a(var1);
        }

    }

    protected void b(Entity var1) {
        for (int var2 = 0; var2 < this.u.size(); ++var2) {
            ((IWorldAccess) this.u.get(var2)).b(var1);
        }

    }

    public void e(Entity var1) {
        if (var1.l != null) {
            var1.l.a((Entity) null);
        }

        if (var1.m != null) {
            var1.a((Entity) null);
        }

        var1.J();
        if (var1 instanceof EntityHuman) {
            this.players.remove(var1);
            this.d();
            this.b(var1);
        }

    }

    public void f(Entity var1) {
        var1.J();
        if (var1 instanceof EntityHuman) {
            this.players.remove(var1);
            this.d();
        }

        int var2 = var1.ae;
        int var3 = var1.ag;
        if (var1.ad && this.a(var2, var3, true)) {
            this.getChunkAt(var2, var3).b(var1);
        }

        this.entityList.remove(var1);
        this.b(var1);
    }

    public void a(IWorldAccess var1) {
        this.u.add(var1);
    }

    public List a(Entity var1, AxisAlignedBB var2) {
        ArrayList var3 = Lists.newArrayList();
        int var4 = MathHelper.floor(var2.a);
        int var5 = MathHelper.floor(var2.d + 1.0D);
        int var6 = MathHelper.floor(var2.b);
        int var7 = MathHelper.floor(var2.e + 1.0D);
        int var8 = MathHelper.floor(var2.c);
        int var9 = MathHelper.floor(var2.f + 1.0D);

        for (int var10 = var4; var10 < var5; ++var10) {
            for (int var11 = var8; var11 < var9; ++var11) {
                if (this.isLoaded(new Location(var10, 64, var11))) {
                    for (int var12 = var6 - 1; var12 < var7; ++var12) {
                        Location var13 = new Location(var10, var12, var11);
                        boolean var14 = var1.aS();
                        boolean var15 = this.a(this.af(), var1);
                        if (var14 && var15) {
                            var1.h(false);
                        } else if (!var14 && !var15) {
                            var1.h(true);
                        }

                        IBlockData var16;
                        if (!this.af().a(var13) && var15) {
                            var16 = Blocks.STONE.P();
                        } else {
                            var16 = this.getData(var13);
                        }

                        var16.c().a(this, var13, var16, var2, var3, var1);
                    }
                }
            }
        }

        double var17 = 0.25D;
        List var18 = this.b(var1, var2.b(var17, var17, var17));

        for (int var19 = 0; var19 < var18.size(); ++var19) {
            if (var1.l != var18 && var1.m != var18) {
                AxisAlignedBB var20 = ((Entity) var18.get(var19)).S();
                if (var20 != null && var20.b(var2)) {
                    var3.add(var20);
                }

                var20 = var1.j((Entity) var18.get(var19));
                if (var20 != null && var20.b(var2)) {
                    var3.add(var20);
                }
            }
        }

        return var3;
    }

    public boolean a(WorldBorder var1, Entity var2) {
        double var3 = var1.b();
        double var5 = var1.c();
        double var7 = var1.d();
        double var9 = var1.e();
        if (var2.aS()) {
            ++var3;
            ++var5;
            --var7;
            --var9;
        } else {
            --var3;
            --var5;
            ++var7;
            ++var9;
        }

        return var2.s > var3 && var2.s < var7 && var2.u > var5 && var2.u < var9;
    }

    public List a(AxisAlignedBB var1) {
        ArrayList var2 = Lists.newArrayList();
        int var3 = MathHelper.floor(var1.a);
        int var4 = MathHelper.floor(var1.d + 1.0D);
        int var5 = MathHelper.floor(var1.b);
        int var6 = MathHelper.floor(var1.e + 1.0D);
        int var7 = MathHelper.floor(var1.c);
        int var8 = MathHelper.floor(var1.f + 1.0D);

        for (int var9 = var3; var9 < var4; ++var9) {
            for (int var10 = var7; var10 < var8; ++var10) {
                if (this.isLoaded(new Location(var9, 64, var10))) {
                    for (int var11 = var5 - 1; var11 < var6; ++var11) {
                        Location var13 = new Location(var9, var11, var10);
                        IBlockData var12;
                        if (var9 >= -30000000 && var9 < 30000000 && var10 >= -30000000 && var10 < 30000000) {
                            var12 = this.getData(var13);
                        } else {
                            var12 = Blocks.BEDROCK.P();
                        }

                        var12.c().a(this, var13, var12, var1, var2, (Entity) null);
                    }
                }
            }
        }

        return var2;
    }

    public int a(float var1) {
        float var2 = this.c(var1);
        float var3 = 1.0F - (MathHelper.cos(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
        var3 = MathHelper.a(var3, 0.0F, 1.0F);
        var3 = 1.0F - var3;
        var3 = (float) ((double) var3 * (1.0D - (double) (this.j(var1) * 5.0F) / 16.0D));
        var3 = (float) ((double) var3 * (1.0D - (double) (this.h(var1) * 5.0F) / 16.0D));
        var3 = 1.0F - var3;
        return (int) (var3 * 11.0F);
    }

    public float c(float var1) {
        return this.worldProvider.a(this.worldData.getDayTime(), var1);
    }

    public float y() {
        return WorldProvider.a[this.worldProvider.a(this.worldData.getDayTime())];
    }

    public float d(float var1) {
        float var2 = this.c(var1);
        return var2 * 3.1415927F * 2.0F;
    }

    public Location q(Location var1) {
        return this.f(var1).h(var1);
    }

    public Location r(Location var1) {
        Chunk var2 = this.f(var1);

        Location var3;
        Location var4;
        for (var3 = new Location(var1.n(), var2.g() + 16, var1.p()); var3.o() >= 0; var3 = var4) {
            var4 = var3.b();
            Material var5 = var2.a(var4).r();
            if (var5.c() && var5 != Material.LEAVES) {
                break;
            }
        }

        return var3;
    }

    public void a(Location var1, Block var2, int var3) {
    }

    public void a(Location var1, Block var2, int var3, int var4) {
    }

    public void b(Location var1, Block var2, int var3, int var4) {
    }

    public void i() {
        this.methodProfiler.a("entities");
        this.methodProfiler.a("global");

        int var1;
        Entity var2;
        CrashReport var4;
        CrashReportSystemDetails var5;
        for (var1 = 0; var1 < this.k.size(); ++var1) {
            var2 = (Entity) this.k.get(var1);

            try {
                ++var2.W;
                var2.s_();
            } catch (Throwable var9) {
                var4 = CrashReport.a(var9, "Ticking entity");
                var5 = var4.a("Entity being ticked");
                if (var2 == null) {
                    var5.a("Entity", (Object) "~~NULL~~");
                } else {
                    var2.getAttributeInstance(var5);
                }

                throw new ReportedException(var4);
            }

            if (var2.I) {
                this.k.remove(var1--);
            }
        }

        this.methodProfiler.c("remove");
        this.entityList.removeAll(this.g);

        int var3;
        int var14;
        for (var1 = 0; var1 < this.g.size(); ++var1) {
            var2 = (Entity) this.g.get(var1);
            var3 = var2.ae;
            var14 = var2.ag;
            if (var2.ad && this.a(var3, var14, true)) {
                this.getChunkAt(var3, var14).b(var2);
            }
        }

        for (var1 = 0; var1 < this.g.size(); ++var1) {
            this.b((Entity) this.g.get(var1));
        }

        this.g.clear();
        this.methodProfiler.c("regular");

        for (var1 = 0; var1 < this.entityList.size(); ++var1) {
            var2 = (Entity) this.entityList.get(var1);
            if (var2.m != null) {
                if (!var2.m.I && var2.m.l == var2) {
                    continue;
                }

                var2.m.l = null;
                var2.m = null;
            }

            this.methodProfiler.a("tick");
            if (!var2.I) {
                try {
                    this.g(var2);
                } catch (Throwable var8) {
                    var4 = CrashReport.a(var8, "Ticking entity");
                    var5 = var4.a("Entity being ticked");
                    var2.getAttributeInstance(var5);
                    throw new ReportedException(var4);
                }
            }

            this.methodProfiler.b();
            this.methodProfiler.a("remove");
            if (var2.I) {
                var3 = var2.ae;
                var14 = var2.ag;
                if (var2.ad && this.a(var3, var14, true)) {
                    this.getChunkAt(var3, var14).b(var2);
                }

                this.entityList.remove(var1--);
                this.b(var2);
            }

            this.methodProfiler.b();
        }

        this.methodProfiler.c("blockEntities");
        this.L = true;
        Iterator var15 = this.i.iterator();

        while (var15.hasNext()) {
            TileEntity var10 = (TileEntity) var15.next();
            if (!var10.x() && var10.t()) {
                Location var12 = var10.v();
                if (this.isLoaded(var12) && this.M.a(var12)) {
                    try {
                        ((IUpdatePlayerListBox) var10).c();
                    } catch (Throwable var7) {
                        CrashReport var16 = CrashReport.a(var7, "Ticking block entity");
                        CrashReportSystemDetails var6 = var16.a("Block entity being ticked");
                        var10.a(var6);
                        throw new ReportedException(var16);
                    }
                }
            }

            if (var10.x()) {
                var15.remove();
                this.tileEntityList.remove(var10);
                if (this.isLoaded(var10.v())) {
                    this.f(var10.v()).e(var10.v());
                }
            }
        }

        this.L = false;
        if (!this.b.isEmpty()) {
            this.i.removeAll(this.b);
            this.tileEntityList.removeAll(this.b);
            this.b.clear();
        }

        this.methodProfiler.c("pendingBlockEntities");
        if (!this.a.isEmpty()) {
            for (int var11 = 0; var11 < this.a.size(); ++var11) {
                TileEntity var13 = (TileEntity) this.a.get(var11);
                if (!var13.x()) {
                    if (!this.tileEntityList.contains(var13)) {
                        this.a(var13);
                    }

                    if (this.isLoaded(var13.v())) {
                        this.f(var13.v()).a(var13.v(), var13);
                    }

                    this.h(var13.v());
                }
            }

            this.a.clear();
        }

        this.methodProfiler.b();
        this.methodProfiler.b();
    }

    public boolean a(TileEntity var1) {
        boolean var2 = this.tileEntityList.add(var1);
        if (var2 && var1 instanceof IUpdatePlayerListBox) {
            this.i.add(var1);
        }

        return var2;
    }

    public void a(Collection var1) {
        if (this.L) {
            this.a.addAll(var1);
        } else {
            Iterator var2 = var1.iterator();

            while (var2.hasNext()) {
                TileEntity var3 = (TileEntity) var2.next();
                this.tileEntityList.add(var3);
                if (var3 instanceof IUpdatePlayerListBox) {
                    this.i.add(var3);
                }
            }
        }

    }

    public void g(Entity var1) throws IOException {
        this.a(var1, true);
    }

    public void a(Entity var1, boolean var2) throws IOException {
        int var3 = MathHelper.floor(var1.s);
        int var4 = MathHelper.floor(var1.u);
        byte var5 = 32;
        if (!var2 || this.a(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5, true)) {
            var1.P = var1.s;
            var1.Q = var1.t;
            var1.R = var1.u;
            var1.A = var1.y;
            var1.B = var1.z;
            if (var2 && var1.ad) {
                ++var1.W;
                if (var1.m != null) {
                    var1.ak();
                } else {
                    var1.s_();
                }
            }

            this.methodProfiler.a("chunkCheck");
            if (Double.isNaN(var1.s) || Double.isInfinite(var1.s)) {
                var1.s = var1.P;
            }

            if (Double.isNaN(var1.t) || Double.isInfinite(var1.t)) {
                var1.t = var1.Q;
            }

            if (Double.isNaN(var1.u) || Double.isInfinite(var1.u)) {
                var1.u = var1.R;
            }

            if (Double.isNaN((double) var1.z) || Double.isInfinite((double) var1.z)) {
                var1.z = var1.B;
            }

            if (Double.isNaN((double) var1.y) || Double.isInfinite((double) var1.y)) {
                var1.y = var1.A;
            }

            int var6 = MathHelper.floor(var1.s / 16.0D);
            int var7 = MathHelper.floor(var1.t / 16.0D);
            int var8 = MathHelper.floor(var1.u / 16.0D);
            if (!var1.ad || var1.ae != var6 || var1.af != var7 || var1.ag != var8) {
                if (var1.ad && this.a(var1.ae, var1.ag, true)) {
                    this.getChunkAt(var1.ae, var1.ag).a(var1, var1.af);
                }

                if (this.a(var6, var8, true)) {
                    var1.ad = true;
                    this.getChunkAt(var6, var8).a(var1);
                } else {
                    var1.ad = false;
                }
            }

            this.methodProfiler.b();
            if (var2 && var1.ad && var1.l != null) {
                if (!var1.l.I && var1.l.m == var1) {
                    this.g(var1.l);
                } else {
                    var1.l.m = null;
                    var1.l = null;
                }
            }

        }
    }

    public boolean b(AxisAlignedBB var1) {
        return this.a(var1, (Entity) null);
    }

    public boolean a(AxisAlignedBB var1, Entity var2) {
        List var3 = this.b((Entity) null, var1);

        for (int var4 = 0; var4 < var3.size(); ++var4) {
            Entity var5 = (Entity) var3.get(var4);
            if (!var5.I && var5.k && var5 != var2 && (var2 == null || var2.m != var5 && var2.l != var5)) {
                return false;
            }
        }

        return true;
    }

    public boolean c(AxisAlignedBB var1) {
        int var2 = MathHelper.floor(var1.a);
        int var3 = MathHelper.floor(var1.d);
        int var4 = MathHelper.floor(var1.b);
        int var5 = MathHelper.floor(var1.e);
        int var6 = MathHelper.floor(var1.c);
        int var7 = MathHelper.floor(var1.f);

        for (int var8 = var2; var8 <= var3; ++var8) {
            for (int var9 = var4; var9 <= var5; ++var9) {
                for (int var10 = var6; var10 <= var7; ++var10) {
                    Block var11 = this.getData(new Location(var8, var9, var10)).c();
                    if (var11.r() != Material.AIR) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean d(AxisAlignedBB var1) {
        int var2 = MathHelper.floor(var1.a);
        int var3 = MathHelper.floor(var1.d);
        int var4 = MathHelper.floor(var1.b);
        int var5 = MathHelper.floor(var1.e);
        int var6 = MathHelper.floor(var1.c);
        int var7 = MathHelper.floor(var1.f);

        for (int var8 = var2; var8 <= var3; ++var8) {
            for (int var9 = var4; var9 <= var5; ++var9) {
                for (int var10 = var6; var10 <= var7; ++var10) {
                    Block var11 = this.getData(new Location(var8, var9, var10)).c();
                    if (var11.r().d()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean e(AxisAlignedBB var1) {
        int var2 = MathHelper.floor(var1.a);
        int var3 = MathHelper.floor(var1.d + 1.0D);
        int var4 = MathHelper.floor(var1.b);
        int var5 = MathHelper.floor(var1.e + 1.0D);
        int var6 = MathHelper.floor(var1.c);
        int var7 = MathHelper.floor(var1.f + 1.0D);
        if (this.a(var2, var4, var6, var3, var5, var7, true)) {
            for (int var8 = var2; var8 < var3; ++var8) {
                for (int var9 = var4; var9 < var5; ++var9) {
                    for (int var10 = var6; var10 < var7; ++var10) {
                        Block var11 = this.getData(new Location(var8, var9, var10)).c();
                        if (var11 == Blocks.FIRE || var11 == Blocks.LAVA || var11 == Blocks.STATIONARY_LAVA) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean a(AxisAlignedBB var1, Material var2, Entity var3) {
        int var4 = MathHelper.floor(var1.a);
        int var5 = MathHelper.floor(var1.d + 1.0D);
        int var6 = MathHelper.floor(var1.b);
        int var7 = MathHelper.floor(var1.e + 1.0D);
        int var8 = MathHelper.floor(var1.c);
        int var9 = MathHelper.floor(var1.f + 1.0D);
        if (!this.a(var4, var6, var8, var5, var7, var9, true)) {
            return false;
        } else {
            boolean var10 = false;
            Vec3D var11 = new Vec3D(0.0D, 0.0D, 0.0D);

            for (int var12 = var4; var12 < var5; ++var12) {
                for (int var13 = var6; var13 < var7; ++var13) {
                    for (int var14 = var8; var14 < var9; ++var14) {
                        Location var15 = new Location(var12, var13, var14);
                        IBlockData var16 = this.getData(var15);
                        Block var17 = var16.c();
                        if (var17.r() == var2) {
                            double var18 = (double) ((float) (var13 + 1) - axl.b(((Integer) var16.b(axl.b)).intValue()));
                            if ((double) var7 >= var18) {
                                var10 = true;
                                var11 = var17.a(this, var15, var3, var11);
                            }
                        }
                    }
                }
            }

            if (var11.b() > 0.0D && var3.aK()) {
                var11 = var11.a();
                double var20 = 0.014D;
                var3.v += var11.a * var20;
                var3.w += var11.b * var20;
                var3.x += var11.c * var20;
            }

            return var10;
        }
    }

    public boolean a(AxisAlignedBB var1, Material var2) {
        int var3 = MathHelper.floor(var1.a);
        int var4 = MathHelper.floor(var1.d + 1.0D);
        int var5 = MathHelper.floor(var1.b);
        int var6 = MathHelper.floor(var1.e + 1.0D);
        int var7 = MathHelper.floor(var1.c);
        int var8 = MathHelper.floor(var1.f + 1.0D);

        for (int var9 = var3; var9 < var4; ++var9) {
            for (int var10 = var5; var10 < var6; ++var10) {
                for (int var11 = var7; var11 < var8; ++var11) {
                    if (this.getData(new Location(var9, var10, var11)).c().r() == var2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean b(AxisAlignedBB var1, Material var2) {
        int var3 = MathHelper.floor(var1.a);
        int var4 = MathHelper.floor(var1.d + 1.0D);
        int var5 = MathHelper.floor(var1.b);
        int var6 = MathHelper.floor(var1.e + 1.0D);
        int var7 = MathHelper.floor(var1.c);
        int var8 = MathHelper.floor(var1.f + 1.0D);

        for (int var9 = var3; var9 < var4; ++var9) {
            for (int var10 = var5; var10 < var6; ++var10) {
                for (int var11 = var7; var11 < var8; ++var11) {
                    Location var12 = new Location(var9, var10, var11);
                    IBlockData var13 = this.getData(var12);
                    Block var14 = var13.c();
                    if (var14.r() == var2) {
                        int var15 = ((Integer) var13.b(axl.b)).intValue();
                        double var16 = (double) (var10 + 1);
                        if (var15 < 8) {
                            var16 = (double) (var10 + 1) - (double) var15 / 8.0D;
                        }

                        if (var16 >= var1.b) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public aqo a(Entity var1, double var2, double var4, double var6, float var8, boolean var9) {
        return this.a(var1, var2, var4, var6, var8, false, var9);
    }

    public aqo a(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
        aqo var11 = new aqo(this, var1, var2, var4, var6, var8, var9, var10);
        var11.a();
        var11.a(true);
        return var11;
    }

    public float a(Vec3D var1, AxisAlignedBB var2) {
        double var3 = 1.0D / ((var2.d - var2.a) * 2.0D + 1.0D);
        double var5 = 1.0D / ((var2.e - var2.b) * 2.0D + 1.0D);
        double var7 = 1.0D / ((var2.f - var2.c) * 2.0D + 1.0D);
        if (var3 >= 0.0D && var5 >= 0.0D && var7 >= 0.0D) {
            int var9 = 0;
            int var10 = 0;

            for (float var11 = 0.0F; var11 <= 1.0F; var11 = (float) ((double) var11 + var3)) {
                for (float var12 = 0.0F; var12 <= 1.0F; var12 = (float) ((double) var12 + var5)) {
                    for (float var13 = 0.0F; var13 <= 1.0F; var13 = (float) ((double) var13 + var7)) {
                        double var14 = var2.a + (var2.d - var2.a) * (double) var11;
                        double var16 = var2.b + (var2.e - var2.b) * (double) var12;
                        double var18 = var2.c + (var2.f - var2.c) * (double) var13;
                        if (this.a(new Vec3D(var14, var16, var18), var1) == null) {
                            ++var9;
                        }

                        ++var10;
                    }
                }
            }

            return (float) var9 / (float) var10;
        } else {
            return 0.0F;
        }
    }

    public boolean a(EntityHuman var1, Location var2, EnumFacing var3) {
        var2 = var2.a(var3);
        if (this.getData(var2).c() == Blocks.FIRE) {
            this.a(var1, 1004, var2, 0);
            this.g(var2);
            return true;
        } else {
            return false;
        }
    }

    public TileEntity s(Location var1) {
        if (!this.a(var1)) {
            return null;
        } else {
            TileEntity var2 = null;
            int var3;
            TileEntity var4;
            if (this.L) {
                for (var3 = 0; var3 < this.a.size(); ++var3) {
                    var4 = (TileEntity) this.a.get(var3);
                    if (!var4.x() && var4.v().equals(var1)) {
                        var2 = var4;
                        break;
                    }
                }
            }

            if (var2 == null) {
                var2 = this.f(var1).a(var1, bfl.a);
            }

            if (var2 == null) {
                for (var3 = 0; var3 < this.a.size(); ++var3) {
                    var4 = (TileEntity) this.a.get(var3);
                    if (!var4.x() && var4.v().equals(var1)) {
                        var2 = var4;
                        break;
                    }
                }
            }

            return var2;
        }
    }

    public void a(Location var1, TileEntity var2) {
        if (var2 != null && !var2.x()) {
            if (this.L) {
                var2.a(var1);
                Iterator var3 = this.a.iterator();

                while (var3.hasNext()) {
                    TileEntity var4 = (TileEntity) var3.next();
                    if (var4.v().equals(var1)) {
                        var4.y();
                        var3.remove();
                    }
                }

                this.a.add(var2);
            } else {
                this.a(var2);
                this.f(var1).a(var1, var2);
            }
        }

    }

    public void t(Location var1) {
        TileEntity var2 = this.s(var1);
        if (var2 != null && this.L) {
            var2.y();
            this.a.remove(var2);
        } else {
            if (var2 != null) {
                this.a.remove(var2);
                this.tileEntityList.remove(var2);
                this.i.remove(var2);
            }

            this.f(var1).e(var1);
        }

    }

    public void b(TileEntity var1) {
        this.b.add(var1);
    }

    public boolean u(Location var1) {
        IBlockData var2 = this.getData(var1);
        AxisAlignedBB var3 = var2.c().a(this, var1, var2);
        return var3 != null && var3.a() >= 1.0D;
    }

    public static boolean a(IBlockAccess var0, Location var1) {
        IBlockData var2 = var0.getData(var1);
        Block var3 = var2.c();
        return var3.r().k() && var3.d() ? true : (var3 instanceof BlockStairs ? var2.b(BlockStairs.b) == bau.a : (var3 instanceof BlockStepAbstract ? var2.b(BlockStepAbstract.a) == awr.a
                : (var3 instanceof BlockHopper ? true : (var3 instanceof BlockSnow ? ((Integer) var2.b(BlockSnow.a)).intValue() == 7 : false))));
    }

    public boolean d(Location var1, boolean var2) {
        if (!this.a(var1)) {
            return var2;
        } else {
            Chunk var3 = this.chunkProvider.getChunkAt(var1);
            if (var3.f()) {
                return var2;
            } else {
                Block var4 = this.getData(var1).c();
                return var4.r().k() && var4.d();
            }
        }
    }

    public void B() {
        int var1 = this.a(1.0F);
        if (var1 != this.d) {
            this.d = var1;
        }

    }

    public void a(boolean var1, boolean var2) {
        this.allowMonsters = var1;
        this.allowAnimals = var2;
    }

    public void c() {
        this.p();
    }

    protected void C() {
        if (this.worldData.p()) {
            this.p = 1.0F;
            if (this.worldData.n()) {
                this.r = 1.0F;
            }
        }

    }

    protected void p() {
        if (!this.worldProvider.o()) {
            if (!this.isStatic) {
                int var1 = this.worldData.getThunderDuration();
                if (var1 > 0) {
                    --var1;
                    this.worldData.i(var1);
                    this.worldData.f(this.worldData.n() ? 1 : 2);
                    this.worldData.g(this.worldData.p() ? 1 : 2);
                }

                int var2 = this.worldData.o();
                if (var2 <= 0) {
                    if (this.worldData.n()) {
                        this.worldData.f(this.random.nextInt(12000) + 3600);
                    } else {
                        this.worldData.f(this.random.nextInt(168000) + 12000);
                    }
                } else {
                    --var2;
                    this.worldData.f(var2);
                    if (var2 <= 0) {
                        this.worldData.a(!this.worldData.n());
                    }
                }

                this.q = this.r;
                if (this.worldData.n()) {
                    this.r = (float) ((double) this.r + 0.01D);
                } else {
                    this.r = (float) ((double) this.r - 0.01D);
                }

                this.r = MathHelper.a(this.r, 0.0F, 1.0F);
                int var3 = this.worldData.q();
                if (var3 <= 0) {
                    if (this.worldData.p()) {
                        this.worldData.g(this.random.nextInt(12000) + 12000);
                    } else {
                        this.worldData.g(this.random.nextInt(168000) + 12000);
                    }
                } else {
                    --var3;
                    this.worldData.g(var3);
                    if (var3 <= 0) {
                        this.worldData.b(!this.worldData.p());
                    }
                }

                this.o = this.p;
                if (this.worldData.p()) {
                    this.p = (float) ((double) this.p + 0.01D);
                } else {
                    this.p = (float) ((double) this.p - 0.01D);
                }

                this.p = MathHelper.a(this.p, 0.0F, 1.0F);
            }
        }
    }

    protected void D() {
        this.chunkTickList.clear();
        this.methodProfiler.a("buildList");

        int var1;
        EntityHuman var2;
        int var3;
        int var4;
        int var5;
        for (var1 = 0; var1 < this.players.size(); ++var1) {
            var2 = (EntityHuman) this.players.get(var1);
            var3 = MathHelper.floor(var2.s / 16.0D);
            var4 = MathHelper.floor(var2.u / 16.0D);
            var5 = this.q();

            for (int var6 = -var5; var6 <= var5; ++var6) {
                for (int var7 = -var5; var7 <= var5; ++var7) {
                    this.chunkTickList.add(new aqm(var6 + var3, var7 + var4));
                }
            }
        }

        this.methodProfiler.b();
        if (this.K > 0) {
            --this.K;
        }

        this.methodProfiler.a("playerCheckLight");
        if (!this.players.isEmpty()) {
            var1 = this.random.nextInt(this.players.size());
            var2 = (EntityHuman) this.players.get(var1);
            var3 = MathHelper.floor(var2.s) + this.random.nextInt(11) - 5;
            var4 = MathHelper.floor(var2.t) + this.random.nextInt(11) - 5;
            var5 = MathHelper.floor(var2.u) + this.random.nextInt(11) - 5;
            this.x(new Location(var3, var4, var5));
        }

        this.methodProfiler.b();
    }

    protected abstract int q();

    protected void a(int var1, int var2, Chunk var3) {
        this.methodProfiler.c("moodSound");
        if (this.K == 0 && !this.isStatic) {
            this.m = this.m * 3 + 1013904223;
            int var4 = this.m >> 2;
            int var5 = var4 & 15;
            int var6 = var4 >> 8 & 15;
            int var7 = var4 >> 16 & 255;
            Location var8 = new Location(var5, var7, var6);
            Block var9 = var3.a(var8);
            var5 += var1;
            var6 += var2;
            if (var9.r() == Material.AIR && this.k(var8) <= this.random.nextInt(8) && this.b(EnumSkyBlock.SKY, var8) <= 0) {
                EntityHuman var10 = this.a((double) var5 + 0.5D, (double) var7 + 0.5D, (double) var6 + 0.5D, 8.0D);
                if (var10 != null && var10.e((double) var5 + 0.5D, (double) var7 + 0.5D, (double) var6 + 0.5D) > 4.0D) {
                    this.a((double) var5 + 0.5D, (double) var7 + 0.5D, (double) var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.random.nextFloat() * 0.2F);
                    this.K = this.random.nextInt(12000) + 6000;
                }
            }
        }

        this.methodProfiler.c("checkLight");
        var3.m();
    }

    protected void h() {
        this.D();
    }

    public void a(Block var1, Location var2, Random var3) {
        this.e = true;
        var1.b(this, var2, this.getData(var2), var3);
        this.e = false;
    }

    public boolean v(Location var1) {
        return this.e(var1, false);
    }

    public boolean w(Location var1) {
        return this.e(var1, true);
    }

    public boolean e(Location var1, boolean var2) {
        BiomeBase var3 = this.getBiome(var1);
        float var4 = var3.a(var1);
        if (var4 > 0.15F) {
            return false;
        } else {
            if (var1.o() >= 0 && var1.o() < 256 && this.b(EnumSkyBlock.BLOCK, var1) < 10) {
                IBlockData var5 = this.getData(var1);
                Block var6 = var5.c();
                if ((var6 == Blocks.STATIONARY_WATER || var6 == Blocks.WATER) && ((Integer) var5.b(axl.b)).intValue() == 0) {
                    if (!var2) {
                        return true;
                    }

                    boolean var7 = this.F(var1.e()) && this.F(var1.f()) && this.F(var1.c()) && this.F(var1.d());
                    if (!var7) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private boolean F(Location var1) {
        return this.getData(var1).c().r() == Material.WATER;
    }

    public boolean f(Location var1, boolean var2) {
        BiomeBase var3 = this.getBiome(var1);
        float var4 = var3.a(var1);
        if (var4 > 0.15F) {
            return false;
        } else if (!var2) {
            return true;
        } else {
            if (var1.o() >= 0 && var1.o() < 256 && this.b(EnumSkyBlock.BLOCK, var1) < 10) {
                Block var5 = this.getData(var1).c();
                if (var5.r() == Material.AIR && Blocks.SNOW.c(this, var1)) {
                    return true;
                }
            }

            return false;
        }
    }

    public boolean x(Location var1) {
        boolean var2 = false;
        if (!this.worldProvider.o()) {
            var2 |= this.c(EnumSkyBlock.SKY, var1);
        }

        var2 |= this.c(EnumSkyBlock.BLOCK, var1);
        return var2;
    }

    private int a(Location var1, EnumSkyBlock var2) {
        if (var2 == EnumSkyBlock.SKY && this.i(var1)) {
            return 15;
        } else {
            Block var3 = this.getData(var1).c();
            int var4 = var2 == EnumSkyBlock.SKY ? 0 : var3.p();
            int var5 = var3.n();
            if (var5 >= 15 && var3.p() > 0) {
                var5 = 1;
            }

            if (var5 < 1) {
                var5 = 1;
            }

            if (var5 >= 15) {
                return 0;
            } else if (var4 >= 14) {
                return var4;
            } else {
                EnumFacing[] var6 = EnumFacing.values();
                int var7 = var6.length;

                for (int var8 = 0; var8 < var7; ++var8) {
                    EnumFacing var9 = var6[var8];
                    Location var10 = var1.a(var9);
                    int var11 = this.b(var2, var10) - var5;
                    if (var11 > var4) {
                        var4 = var11;
                    }

                    if (var4 >= 14) {
                        return var4;
                    }
                }

                return var4;
            }
        }
    }

    public boolean c(EnumSkyBlock var1, Location var2) {
        if (!this.a(var2, 17, false)) {
            return false;
        } else {
            int var3 = 0;
            int var4 = 0;
            this.methodProfiler.a("getBrightness");
            int var5 = this.b(var1, var2);
            int var6 = this.a(var2, var1);
            int var7 = var2.n();
            int var8 = var2.o();
            int var9 = var2.p();
            int var10;
            int var11;
            int var12;
            int var13;
            int var17;
            int var16;
            int var19;
            int var18;
            if (var6 > var5) {
                this.H[var4++] = 133152;
            } else if (var6 < var5) {
                this.H[var4++] = 133152 | var5 << 18;

                while (var3 < var4) {
                    var10 = this.H[var3++];
                    var11 = (var10 & 63) - 32 + var7;
                    var12 = (var10 >> 6 & 63) - 32 + var8;
                    var13 = (var10 >> 12 & 63) - 32 + var9;
                    int var14 = var10 >> 18 & 15;
                    Location var15 = new Location(var11, var12, var13);
                    var16 = this.b(var1, var15);
                    if (var16 == var14) {
                        this.a(var1, var15, 0);
                        if (var14 > 0) {
                            var17 = MathHelper.a(var11 - var7);
                            var18 = MathHelper.a(var12 - var8);
                            var19 = MathHelper.a(var13 - var9);
                            if (var17 + var18 + var19 < 17) {
                                EnumFacing[] var20 = EnumFacing.values();
                                int var21 = var20.length;

                                for (int var22 = 0; var22 < var21; ++var22) {
                                    EnumFacing var23 = var20[var22];
                                    int var24 = var11 + var23.g();
                                    int var25 = var12 + var23.h();
                                    int var26 = var13 + var23.i();
                                    Location var27 = new Location(var24, var25, var26);
                                    int var28 = Math.max(1, this.getData(var27).c().n());
                                    var16 = this.b(var1, var27);
                                    if (var16 == var14 - var28 && var4 < this.H.length) {
                                        this.H[var4++] = var24 - var7 + 32 | var25 - var8 + 32 << 6 | var26 - var9 + 32 << 12 | var14 - var28 << 18;
                                    }
                                }
                            }
                        }
                    }
                }

                var3 = 0;
            }

            this.methodProfiler.b();
            this.methodProfiler.a("checkedPosition < toCheckCount");

            while (var3 < var4) {
                var10 = this.H[var3++];
                var11 = (var10 & 63) - 32 + var7;
                var12 = (var10 >> 6 & 63) - 32 + var8;
                var13 = (var10 >> 12 & 63) - 32 + var9;
                Location var30 = new Location(var11, var12, var13);
                int var29 = this.b(var1, var30);
                var16 = this.a(var30, var1);
                if (var16 != var29) {
                    this.a(var1, var30, var16);
                    if (var16 > var29) {
                        var17 = Math.abs(var11 - var7);
                        var18 = Math.abs(var12 - var8);
                        var19 = Math.abs(var13 - var9);
                        boolean var31 = var4 < this.H.length - 6;
                        if (var17 + var18 + var19 < 17 && var31) {
                            if (this.b(var1, var30.e()) < var16) {
                                this.H[var4++] = var11 - 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                            }

                            if (this.b(var1, var30.f()) < var16) {
                                this.H[var4++] = var11 + 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                            }

                            if (this.b(var1, var30.b()) < var16) {
                                this.H[var4++] = var11 - var7 + 32 + (var12 - 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                            }

                            if (this.b(var1, var30.a()) < var16) {
                                this.H[var4++] = var11 - var7 + 32 + (var12 + 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                            }

                            if (this.b(var1, var30.c()) < var16) {
                                this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - 1 - var9 + 32 << 12);
                            }

                            if (this.b(var1, var30.d()) < var16) {
                                this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 + 1 - var9 + 32 << 12);
                            }
                        }
                    }
                }
            }

            this.methodProfiler.b();
            return true;
        }
    }

    public boolean a(boolean var1) {
        return false;
    }

    public List a(Chunk var1, boolean var2) {
        return null;
    }

    public List a(bjb var1, boolean var2) {
        return null;
    }

    public List b(Entity var1, AxisAlignedBB var2) {
        return this.a(var1, var2, EntitySelectors.d);
    }

    public List a(Entity var1, AxisAlignedBB var2, Predicate var3) {
        ArrayList var4 = Lists.newArrayList();
        int var5 = MathHelper.floor((var2.a - 2.0D) / 16.0D);
        int var6 = MathHelper.floor((var2.d + 2.0D) / 16.0D);
        int var7 = MathHelper.floor((var2.c - 2.0D) / 16.0D);
        int var8 = MathHelper.floor((var2.f + 2.0D) / 16.0D);

        for (int var9 = var5; var9 <= var6; ++var9) {
            for (int var10 = var7; var10 <= var8; ++var10) {
                if (this.a(var9, var10, true)) {
                    this.getChunkAt(var9, var10).a(var1, var2, var4, var3);
                }
            }
        }

        return var4;
    }

    public List a(Class var1, Predicate var2) {
        ArrayList var3 = Lists.newArrayList();
        Iterator var4 = this.entityList.iterator();

        while (var4.hasNext()) {
            Entity var5 = (Entity) var4.next();
            if (var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
                var3.add(var5);
            }
        }

        return var3;
    }

    public List b(Class var1, Predicate var2) {
        ArrayList var3 = Lists.newArrayList();
        Iterator var4 = this.players.iterator();

        while (var4.hasNext()) {
            Entity var5 = (Entity) var4.next();
            if (var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
                var3.add(var5);
            }
        }

        return var3;
    }

    public List getEntities(Class var1, AxisAlignedBB var2) {
        return this.a(var1, var2, EntitySelectors.d);
    }

    public List a(Class var1, AxisAlignedBB var2, Predicate var3) {
        int var4 = MathHelper.floor((var2.a - 2.0D) / 16.0D);
        int var5 = MathHelper.floor((var2.d + 2.0D) / 16.0D);
        int var6 = MathHelper.floor((var2.c - 2.0D) / 16.0D);
        int var7 = MathHelper.floor((var2.f + 2.0D) / 16.0D);
        ArrayList var8 = Lists.newArrayList();

        for (int var9 = var4; var9 <= var5; ++var9) {
            for (int var10 = var6; var10 <= var7; ++var10) {
                if (this.a(var9, var10, true)) {
                    this.getChunkAt(var9, var10).a(var1, var2, var8, var3);
                }
            }
        }

        return var8;
    }

    public Entity a(Class var1, AxisAlignedBB var2, Entity var3) {
        List var4 = this.getEntities(var1, var2);
        Entity var5 = null;
        double var6 = Double.MAX_VALUE;

        for (int var8 = 0; var8 < var4.size(); ++var8) {
            Entity var9 = (Entity) var4.get(var8);
            if (var9 != var3 && EntitySelectors.d.apply(var9)) {
                double var10 = var3.h(var9);
                if (var10 <= var6) {
                    var5 = var9;
                    var6 = var10;
                }
            }
        }

        return var5;
    }

    public Entity a(int var1) {
        return (Entity) this.l.a(var1);
    }

    public void b(Location var1, TileEntity var2) {
        if (this.isLoaded(var1)) {
            this.f(var1).e();
        }

    }

    public int a(Class var1) {
        int var2 = 0;
        Iterator var3 = this.entityList.iterator();

        while (var3.hasNext()) {
            Entity var4 = (Entity) var3.next();
            if ((!(var4 instanceof EntityInsentient) || !((EntityInsentient) var4).bY()) && var1.isAssignableFrom(var4.getClass())) {
                ++var2;
            }
        }

        return var2;
    }

    public void b(Collection var1) {
        this.entityList.addAll(var1);
        Iterator var2 = var1.iterator();

        while (var2.hasNext()) {
            Entity var3 = (Entity) var2.next();
            this.a(var3);
        }

    }

    public void c(Collection var1) {
        this.g.addAll(var1);
    }

    public boolean a(Block var1, Location var2, boolean var3, EnumFacing var4, Entity var5, ItemStack var6) {
        Block var7 = this.getData(var2).c();
        AxisAlignedBB var8 = var3 ? null : var1.a(this, var2, var1.P());
        return var8 != null && !this.a(var8, var5) ? false : (var7.r() == Material.ORIENTABLE && var1 == Blocks.ANVIL ? true : var7.r().j() && var1.a(this, var2, var4, var6));
    }

    public int a(Location var1, EnumFacing var2) {
        IBlockData var3 = this.getData(var1);
        return var3.c().b((IBlockAccess) this, var1, var3, var2);
    }

    public WorldType G() {
        return this.worldData.u();
    }

    public int y(Location var1) {
        byte var2 = 0;
        int var3 = Math.max(var2, this.a(var1.b(), EnumFacing.DOWN));
        if (var3 >= 15) {
            return var3;
        } else {
            var3 = Math.max(var3, this.a(var1.a(), EnumFacing.UP));
            if (var3 >= 15) {
                return var3;
            } else {
                var3 = Math.max(var3, this.a(var1.c(), EnumFacing.NORTH));
                if (var3 >= 15) {
                    return var3;
                } else {
                    var3 = Math.max(var3, this.a(var1.d(), EnumFacing.SOUTH));
                    if (var3 >= 15) {
                        return var3;
                    } else {
                        var3 = Math.max(var3, this.a(var1.e(), EnumFacing.WEST));
                        if (var3 >= 15) {
                            return var3;
                        } else {
                            var3 = Math.max(var3, this.a(var1.f(), EnumFacing.EAST));
                            return var3 >= 15 ? var3 : var3;
                        }
                    }
                }
            }
        }
    }

    public boolean b(Location var1, EnumFacing var2) {
        return this.c(var1, var2) > 0;
    }

    public int c(Location var1, EnumFacing var2) {
        IBlockData var3 = this.getData(var1);
        Block var4 = var3.c();
        return var4.t() ? this.y(var1) : var4.a((IBlockAccess) this, var1, var3, var2);
    }

    public boolean z(Location var1) {
        return this.c(var1.b(), EnumFacing.DOWN) > 0 ? true : (this.c(var1.a(), EnumFacing.UP) > 0 ? true : (this.c(var1.c(), EnumFacing.NORTH) > 0 ? true
                : (this.c(var1.d(), EnumFacing.SOUTH) > 0 ? true : (this.c(var1.e(), EnumFacing.WEST) > 0 ? true : this.c(var1.f(), EnumFacing.EAST) > 0))));
    }

    public int A(Location var1) {
        int var2 = 0;
        EnumFacing[] var3 = EnumFacing.values();
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            EnumFacing var6 = var3[var5];
            int var7 = this.c(var1.a(var6), var6);
            if (var7 >= 15) {
                return 15;
            }

            if (var7 > var2) {
                var2 = var7;
            }
        }

        return var2;
    }

    public EntityHuman a(Entity var1, double var2) {
        return this.a(var1.s, var1.t, var1.u, var2);
    }

    public EntityHuman a(double var1, double var3, double var5, double var7) {
        double var9 = -1.0D;
        EntityHuman var11 = null;

        for (int var12 = 0; var12 < this.players.size(); ++var12) {
            EntityHuman var13 = (EntityHuman) this.players.get(var12);
            if (EntitySelectors.d.apply(var13)) {
                double var14 = var13.e(var1, var3, var5);
                if ((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
                    var9 = var14;
                    var11 = var13;
                }
            }
        }

        return var11;
    }

    public boolean b(double var1, double var3, double var5, double var7) {
        for (int var9 = 0; var9 < this.players.size(); ++var9) {
            EntityHuman var10 = (EntityHuman) this.players.get(var9);
            if (EntitySelectors.d.apply(var10)) {
                double var11 = var10.e(var1, var3, var5);
                if (var7 < 0.0D || var11 < var7 * var7) {
                    return true;
                }
            }
        }

        return false;
    }

    public EntityHuman a(String var1) {
        for (int var2 = 0; var2 < this.players.size(); ++var2) {
            EntityHuman var3 = (EntityHuman) this.players.get(var2);
            if (var1.equals(var3.getName())) {
                return var3;
            }
        }

        return null;
    }

    public EntityHuman b(UUID var1) {
        for (int var2 = 0; var2 < this.players.size(); ++var2) {
            EntityHuman var3 = (EntityHuman) this.players.get(var2);
            if (var1.equals(var3.aJ())) {
                return var3;
            }
        }

        return null;
    }

    public void I() throws ExceptionWorldConflict {
        this.dataManager.c();
    }

    public long J() {
        return this.worldData.b();
    }

    public long K() {
        return this.worldData.f();
    }

    public long L() {
        return this.worldData.getDayTime();
    }

    public void b(long var1) {
        this.worldData.c(var1);
    }

    public Location M() {
        Location var1 = new Location(this.worldData.c(), this.worldData.d(), this.worldData.e());
        if (!this.af().a(var1)) {
            var1 = this.m(new Location(this.af().f(), 0.0D, this.af().g()));
        }

        return var1;
    }

    public void B(Location var1) {
        this.worldData.a(var1);
    }

    public boolean a(EntityHuman var1, Location var2) {
        return true;
    }

    public void a(Entity var1, byte var2) {
    }

    public IChunkProvider N() {
        return this.chunkProvider;
    }

    public void c(Location var1, Block var2, int var3, int var4) {
        var2.a(this, var1, this.getData(var1), var3, var4);
    }

    public IDataManager O() {
        return this.dataManager;
    }

    public WorldData P() {
        return this.worldData;
    }

    public aqq Q() {
        return this.worldData.x();
    }

    public void d() {
    }

    public float h(float var1) {
        return (this.q + (this.r - this.q) * var1) * this.j(var1);
    }

    public float j(float var1) {
        return this.o + (this.p - this.o) * var1;
    }

    public boolean R() {
        return (double) this.h(1.0F) > 0.9D;
    }

    public boolean S() {
        return (double) this.j(1.0F) > 0.2D;
    }

    public boolean C(Location var1) {
        if (!this.S()) {
            return false;
        } else if (!this.i(var1)) {
            return false;
        } else if (this.q(var1).o() > var1.o()) {
            return false;
        } else {
            BiomeBase var2 = this.getBiome(var1);
            return var2.d() ? false : (this.f(var1, false) ? false : var2.e());
        }
    }

    public boolean D(Location var1) {
        BiomeBase var2 = this.getBiome(var1);
        return var2.f();
    }

    public PersistentCollection T() {
        return this.worldMaps;
    }

    public void a(String var1, PersistentBase var2) {
        this.worldMaps.a(var1, var2);
    }

    public PersistentBase a(Class var1, String var2) {
        return this.worldMaps.get(var1, var2);
    }

    public int b(String var1) {
        return this.worldMaps.a(var1);
    }

    public void a(int var1, Location var2, int var3) {
        for (int var4 = 0; var4 < this.u.size(); ++var4) {
            ((IWorldAccess) this.u.get(var4)).a(var1, var2, var3);
        }

    }

    public void b(int var1, Location var2, int var3) {
        this.a((EntityHuman) null, var1, var2, var3);
    }

    public void a(EntityHuman var1, int var2, Location var3, int var4) {
        try {
            for (int var5 = 0; var5 < this.u.size(); ++var5) {
                ((IWorldAccess) this.u.get(var5)).a(var1, var2, var3, var4);
            }

        } catch (Throwable var8) {
            CrashReport var6 = CrashReport.a(var8, "Playing level event");
            CrashReportSystemDetails var7 = var6.a("Level event being played");
            var7.a("Block coordinates", (Object) CrashReportSystemDetails.a(var3));
            var7.a("Event source", (Object) var1);
            var7.a("Event type", (Object) Integer.valueOf(var2));
            var7.a("Event data", (Object) Integer.valueOf(var4));
            throw new ReportedException(var6);
        }
    }

    public int U() {
        return 256;
    }

    public int V() {
        return this.worldProvider.o() ? 128 : 256;
    }

    public Random a(int var1, int var2, int var3) {
        long var4 = (long) var1 * 341873128712L + (long) var2 * 132897987541L + this.P().b() + (long) var3;
        this.random.setSeed(var4);
        return this.random;
    }

    public Location a(String var1, Location var2) {
        return this.N().findNearestMapFeature(this, var1, var2);
    }

    public CrashReportSystemDetails a(CrashReport var1) {
        CrashReportSystemDetails var2 = var1.a("Affected level", 1);
        var2.a("Level name", (Object) (this.worldData == null ? "????" : this.worldData.k()));
        var2.a("All players", (Callable) (new aqx(this)));
        var2.a("Chunk stats", (Callable) (new aqy(this)));

        try {
            this.worldData.a(var2);
        } catch (Throwable var4) {
            var2.a("Level Data Unobtainable", var4);
        }

        return var2;
    }

    public void c(int var1, Location var2, int var3) {
        for (int var4 = 0; var4 < this.u.size(); ++var4) {
            IWorldAccess var5 = (IWorldAccess) this.u.get(var4);
            var5.b(var1, var2, var3);
        }

    }

    public Calendar Y() {
        if (this.K() % 600L == 0L) {
            this.J.setTimeInMillis(MinecraftServer.ax());
        }

        return this.J;
    }

    public Scoreboard Z() {
        return this.scoreboard;
    }

    public void e(Location var1, Block var2) {
        Iterator var3 = en.a.iterator();

        while (var3.hasNext()) {
            EnumFacing var4 = (EnumFacing) var3.next();
            Location var5 = var1.a(var4);
            if (this.isLoaded(var5)) {
                IBlockData var6 = this.getData(var5);
                if (Blocks.REDSTONE_COMPARATOR_OFF.e(var6.c())) {
                    var6.c().a(this, var5, var6, var2);
                } else if (var6.c().t()) {
                    var5 = var5.a(var4);
                    var6 = this.getData(var5);
                    if (Blocks.REDSTONE_COMPARATOR_OFF.e(var6.c())) {
                        var6.c().a(this, var5, var6, var2);
                    }
                }
            }
        }

    }

    public vu E(Location var1) {
        long var2 = 0L;
        float var4 = 0.0F;
        if (this.isLoaded(var1)) {
            var4 = this.y();
            var2 = this.f(var1).w();
        }

        return new vu(this.aa(), this.L(), var2, var4);
    }

    public EnumDifficulty aa() {
        return this.P().y();
    }

    public int ab() {
        return this.d;
    }

    public void b(int var1) {
        this.d = var1;
    }

    public void c(int var1) {
        this.I = var1;
    }

    public boolean ad() {
        return this.isLoading;
    }

    public VillageSiege ae() {
        return this.siegeManager;
    }

    public WorldBorder af() {
        return this.M;
    }

    public boolean c(int var1, int var2) {
        Location var3 = this.M();
        int var4 = var1 * 16 + 8 - var3.n();
        int var5 = var2 * 16 + 8 - var3.p();
        short var6 = 128;
        return var4 >= -var6 && var4 <= var6 && var5 >= -var6 && var5 <= var6;
    }
}
