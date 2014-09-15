package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;

public class BlockFire extends Block {

   public static final bew a = bew.a("age", 0, 15);
   public static final bet b = bet.a("flip");
   public static final bet M = bet.a("alt");
   public static final bet N = bet.a("north");
   public static final bet O = bet.a("east");
   public static final bet P = bet.a("south");
   public static final bet Q = bet.a("west");
   public static final bew R = bew.a("upper", 0, 2);
   private final Map S = Maps.newIdentityHashMap();
   private final Map T = Maps.newIdentityHashMap();


   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      int var4 = var3.n();
      int var5 = var3.o();
      int var6 = var3.p();
      if(!World.a(var2, var3.b()) && !Blocks.FIRE.e(var2, var3.b())) {
         boolean var7 = (var4 + var5 + var6 & 1) == 1;
         boolean var8 = (var4 / 2 + var5 / 2 + var6 / 2 & 1) == 1;
         int var9 = 0;
         if(this.e(var2, var3.a())) {
            var9 = var7?1:2;
         }

         return var1.a(N, Boolean.valueOf(this.e(var2, var3.c()))).a(O, Boolean.valueOf(this.e(var2, var3.f()))).a(P, Boolean.valueOf(this.e(var2, var3.d()))).a(Q, Boolean.valueOf(this.e(var2, var3.e()))).a(R, Integer.valueOf(var9)).a(b, Boolean.valueOf(var8)).a(M, Boolean.valueOf(var7));
      } else {
         return this.P();
      }
   }

   protected BlockFire() {
      super(Material.FIRE);
      this.j(this.L.b().a(a, Integer.valueOf(0)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, Boolean.valueOf(false)).a(R, Integer.valueOf(0)));
      this.a(true);
   }

   public static void j() {
      Blocks.FIRE.a(Blocks.WOOD, 5, 20);
      Blocks.FIRE.a(Blocks.WOOD_DOUBLE_STEP, 5, 20);
      Blocks.FIRE.a(Blocks.WOOD_STEP, 5, 20);
      Blocks.FIRE.a(Blocks.FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.SPRUCE_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.BIRCH_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.JUNGLE_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.DARK_OAK_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.ACACIA_FENCE_GATE, 5, 20);
      Blocks.FIRE.a(Blocks.FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.SPRUCE_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.BIRCH_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.JUNGLE_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.DARK_OAK_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.ACACIA_FENCE, 5, 20);
      Blocks.FIRE.a(Blocks.WOOD_STAIRS, 5, 20);
      Blocks.FIRE.a(Blocks.BIRCH_WOOD_STAIRS, 5, 20);
      Blocks.FIRE.a(Blocks.SPRUCE_WOOD_STAIRS, 5, 20);
      Blocks.FIRE.a(Blocks.JUNGLE_WOOD_STAIRS, 5, 20);
      Blocks.FIRE.a(Blocks.LOG, 5, 5);
      Blocks.FIRE.a(Blocks.LOG2, 5, 5);
      Blocks.FIRE.a(Blocks.LEAVES, 30, 60);
      Blocks.FIRE.a(Blocks.LEAVES2, 30, 60);
      Blocks.FIRE.a(Blocks.BOOKSHELF, 30, 20);
      Blocks.FIRE.a(Blocks.TNT, 15, 100);
      Blocks.FIRE.a(Blocks.LONG_GRASS, 60, 100);
      Blocks.FIRE.a(Blocks.DOUBLE_PLANT, 60, 100);
      Blocks.FIRE.a(Blocks.YELLOW_FLOWER, 60, 100);
      Blocks.FIRE.a(Blocks.RED_ROSE, 60, 100);
      Blocks.FIRE.a(Blocks.DEAD_BUSH, 60, 100);
      Blocks.FIRE.a(Blocks.WOOL, 30, 60);
      Blocks.FIRE.a(Blocks.VINE, 15, 100);
      Blocks.FIRE.a(Blocks.COAL_BLOCK, 5, 5);
      Blocks.FIRE.a(Blocks.HAY_BLOCK, 60, 20);
      Blocks.FIRE.a(Blocks.CARPET, 60, 20);
   }

   public void a(Block var1, int var2, int var3) {
      this.S.put(var1, Integer.valueOf(var2));
      this.T.put(var1, Integer.valueOf(var3));
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public int a(World var1) {
      return 30;
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(var1.Q().b("doFireTick")) {
         if(!this.canPlace(var1, var2)) {
            var1.g(var2);
         }

         Block var5 = var1.getData(var2.b()).c();
         boolean var6 = var5 == Blocks.NETHERRACK;
         if(var1.worldProvider instanceof bgh && var5 == Blocks.BEDROCK) {
            var6 = true;
         }

         if(!var6 && var1.S() && this.d(var1, var2)) {
            var1.g(var2);
         } else {
            int var7 = ((Integer)var3.b(a)).intValue();
            if(var7 < 15) {
               var3 = var3.a(a, Integer.valueOf(var7 + var4.nextInt(3) / 2));
               var1.a(var2, var3, 4);
            }

            var1.a(var2, (Block)this, this.a(var1) + var4.nextInt(10));
            if(!var6) {
               if(!this.e(var1, var2)) {
                  if(!World.a((IBlockAccess)var1, var2.b()) || var7 > 3) {
                     var1.g(var2);
                  }

                  return;
               }

               if(!this.e((IBlockAccess)var1, var2.b()) && var7 == 15 && var4.nextInt(4) == 0) {
                  var1.g(var2);
                  return;
               }
            }

            boolean var8 = var1.D(var2);
            byte var9 = 0;
            if(var8) {
               var9 = -50;
            }

            this.a(var1, var2.f(), 300 + var9, var4, var7);
            this.a(var1, var2.e(), 300 + var9, var4, var7);
            this.a(var1, var2.b(), 250 + var9, var4, var7);
            this.a(var1, var2.a(), 250 + var9, var4, var7);
            this.a(var1, var2.c(), 300 + var9, var4, var7);
            this.a(var1, var2.d(), 300 + var9, var4, var7);

            for(int var10 = -1; var10 <= 1; ++var10) {
               for(int var11 = -1; var11 <= 1; ++var11) {
                  for(int var12 = -1; var12 <= 4; ++var12) {
                     if(var10 != 0 || var12 != 0 || var11 != 0) {
                        int var13 = 100;
                        if(var12 > 1) {
                           var13 += (var12 - 1) * 100;
                        }

                        Location var14 = var2.a(var10, var12, var11);
                        int var15 = this.m(var1, var14);
                        if(var15 > 0) {
                           int var16 = (var15 + 40 + var1.aa().a() * 7) / (var7 + 30);
                           if(var8) {
                              var16 /= 2;
                           }

                           if(var16 > 0 && var4.nextInt(var13) <= var16 && (!var1.S() || !this.d(var1, var14))) {
                              int var17 = var7 + var4.nextInt(5) / 4;
                              if(var17 > 15) {
                                 var17 = 15;
                              }

                              var1.a(var14, var3.a(a, Integer.valueOf(var17)), 3);
                           }
                        }
                     }
                  }
               }
            }

         }
      }
   }

   protected boolean d(World var1, Location var2) {
      return var1.C(var2) || var1.C(var2.e()) || var1.C(var2.f()) || var1.C(var2.c()) || var1.C(var2.d());
   }

   public boolean M() {
      return false;
   }

   private int c(Block var1) {
      Integer var2 = (Integer)this.T.get(var1);
      return var2 == null?0:var2.intValue();
   }

   private int d(Block var1) {
      Integer var2 = (Integer)this.S.get(var1);
      return var2 == null?0:var2.intValue();
   }

   private void a(World var1, Location var2, int var3, Random var4, int var5) {
      int var6 = this.c(var1.getData(var2).c());
      if(var4.nextInt(var3) < var6) {
         IBlockData var7 = var1.getData(var2);
         if(var4.nextInt(var5 + 10) < 5 && !var1.C(var2)) {
            int var8 = var5 + var4.nextInt(5) / 4;
            if(var8 > 15) {
               var8 = 15;
            }

            var1.a(var2, this.P().a(a, Integer.valueOf(var8)), 3);
         } else {
            var1.g(var2);
         }

         if(var7.c() == Blocks.TNT) {
            Blocks.TNT.d(var1, var2, var7.a(BlockTNT.a, Boolean.valueOf(true)));
         }
      }

   }

   private boolean e(World var1, Location var2) {
      EnumFacing[] var3 = EnumFacing.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumFacing var6 = var3[var5];
         if(this.e((IBlockAccess)var1, var2.a(var6))) {
            return true;
         }
      }

      return false;
   }

   private int m(World var1, Location var2) {
      if(!var1.isEmpty(var2)) {
         return 0;
      } else {
         int var3 = 0;
         EnumFacing[] var4 = EnumFacing.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumFacing var7 = var4[var6];
            var3 = Math.max(this.d(var1.getData(var2.a(var7)).c()), var3);
         }

         return var3;
      }
   }

   public boolean y() {
      return false;
   }

   public boolean e(IBlockAccess var1, Location var2) {
      return this.d(var1.getData(var2).c()) > 0;
   }

   public boolean canPlace(World var1, Location var2) {
      return World.a((IBlockAccess)var1, var2.b()) || this.e(var1, var2);
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      if(!World.a((IBlockAccess)var1, var2.b()) && !this.e(var1, var2)) {
         var1.g(var2);
      }

   }

   public void c(World var1, Location var2, IBlockData var3) {
      if(var1.worldProvider.q() > 0 || !Blocks.PORTAL.d(var1, var2)) {
         if(!World.a((IBlockAccess)var1, var2.b()) && !this.e(var1, var2)) {
            var1.g(var2);
         } else {
            var1.a(var2, (Block)this, this.a(var1) + var1.random.nextInt(10));
         }
      }
   }

   public MaterialMapColor g(IBlockData var1) {
      return MaterialMapColor.f;
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Integer.valueOf(var1));
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a, N, O, P, Q, R, b, M});
   }

}
