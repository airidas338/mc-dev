package net.minecraft.server;
import com.google.common.base.Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BlockStairs extends Block {

   public static final beu a = beu.a("facing", (Predicate)en.a);
   public static final bev b = bev.a("half", bau.class);
   public static final bev M = bev.a("shape", bav.class);
   private static final int[][] N = new int[][]{{4, 5}, {5, 7}, {6, 7}, {4, 6}, {0, 1}, {1, 3}, {2, 3}, {0, 2}};
   private final Block O;
   private final IBlockData P;
   private boolean Q;
   private int R;


   protected BlockStairs(IBlockData var1) {
      super(var1.c().J);
      this.j(this.L.b().a(a, EnumFacing.NORTH).a(b, bau.b).a(M, bav.a));
      this.O = var1.c();
      this.P = var1;
      this.c(this.O.w);
      this.b(this.O.x / 3.0F);
      this.a(this.O.H);
      this.e(255);
      this.a(CreativeModeTab.b);
   }

   public void a(IBlockAccess var1, Location var2) {
      if(this.Q) {
         this.a(0.5F * (float)(this.R % 2), 0.5F * (float)(this.R / 4 % 2), 0.5F * (float)(this.R / 2 % 2), 0.5F + 0.5F * (float)(this.R % 2), 0.5F + 0.5F * (float)(this.R / 4 % 2), 0.5F + 0.5F * (float)(this.R / 2 % 2));
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void e(IBlockAccess var1, Location var2) {
      if(var1.getData(var2).b(b) == bau.a) {
         this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public static boolean c(Block var0) {
      return var0 instanceof BlockStairs;
   }

   public static boolean a(IBlockAccess var0, Location var1, IBlockData var2) {
      IBlockData var3 = var0.getData(var1);
      Block var4 = var3.c();
      return c(var4) && var3.b(b) == var2.b(b) && var3.b(a) == var2.b(a);
   }

   public int f(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      EnumFacing var4 = (EnumFacing)var3.b(a);
      bau var5 = (bau)var3.b(b);
      boolean var6 = var5 == bau.a;
      IBlockData var7;
      Block var8;
      EnumFacing var9;
      if(var4 == EnumFacing.EAST) {
         var7 = var1.getData(var2.f());
         var8 = var7.c();
         if(c(var8) && var5 == var7.b(b)) {
            var9 = (EnumFacing)var7.b(a);
            if(var9 == EnumFacing.NORTH && !a(var1, var2.d(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumFacing.SOUTH && !a(var1, var2.c(), var3)) {
               return var6?2:1;
            }
         }
      } else if(var4 == EnumFacing.WEST) {
         var7 = var1.getData(var2.e());
         var8 = var7.c();
         if(c(var8) && var5 == var7.b(b)) {
            var9 = (EnumFacing)var7.b(a);
            if(var9 == EnumFacing.NORTH && !a(var1, var2.d(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumFacing.SOUTH && !a(var1, var2.c(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumFacing.SOUTH) {
         var7 = var1.getData(var2.d());
         var8 = var7.c();
         if(c(var8) && var5 == var7.b(b)) {
            var9 = (EnumFacing)var7.b(a);
            if(var9 == EnumFacing.WEST && !a(var1, var2.f(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumFacing.EAST && !a(var1, var2.e(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumFacing.NORTH) {
         var7 = var1.getData(var2.c());
         var8 = var7.c();
         if(c(var8) && var5 == var7.b(b)) {
            var9 = (EnumFacing)var7.b(a);
            if(var9 == EnumFacing.WEST && !a(var1, var2.f(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumFacing.EAST && !a(var1, var2.e(), var3)) {
               return var6?2:1;
            }
         }
      }

      return 0;
   }

   public int g(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      EnumFacing var4 = (EnumFacing)var3.b(a);
      bau var5 = (bau)var3.b(b);
      boolean var6 = var5 == bau.a;
      IBlockData var7;
      Block var8;
      EnumFacing var9;
      if(var4 == EnumFacing.EAST) {
         var7 = var1.getData(var2.e());
         var8 = var7.c();
         if(c(var8) && var5 == var7.b(b)) {
            var9 = (EnumFacing)var7.b(a);
            if(var9 == EnumFacing.NORTH && !a(var1, var2.c(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumFacing.SOUTH && !a(var1, var2.d(), var3)) {
               return var6?2:1;
            }
         }
      } else if(var4 == EnumFacing.WEST) {
         var7 = var1.getData(var2.f());
         var8 = var7.c();
         if(c(var8) && var5 == var7.b(b)) {
            var9 = (EnumFacing)var7.b(a);
            if(var9 == EnumFacing.NORTH && !a(var1, var2.c(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumFacing.SOUTH && !a(var1, var2.d(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumFacing.SOUTH) {
         var7 = var1.getData(var2.c());
         var8 = var7.c();
         if(c(var8) && var5 == var7.b(b)) {
            var9 = (EnumFacing)var7.b(a);
            if(var9 == EnumFacing.WEST && !a(var1, var2.e(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumFacing.EAST && !a(var1, var2.f(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumFacing.NORTH) {
         var7 = var1.getData(var2.d());
         var8 = var7.c();
         if(c(var8) && var5 == var7.b(b)) {
            var9 = (EnumFacing)var7.b(a);
            if(var9 == EnumFacing.WEST && !a(var1, var2.e(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumFacing.EAST && !a(var1, var2.f(), var3)) {
               return var6?2:1;
            }
         }
      }

      return 0;
   }

   public boolean h(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      EnumFacing var4 = (EnumFacing)var3.b(a);
      bau var5 = (bau)var3.b(b);
      boolean var6 = var5 == bau.a;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if(var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 1.0F;
      float var11 = 0.0F;
      float var12 = 0.5F;
      boolean var13 = true;
      IBlockData var14;
      Block var15;
      EnumFacing var16;
      if(var4 == EnumFacing.EAST) {
         var9 = 0.5F;
         var12 = 1.0F;
         var14 = var1.getData(var2.f());
         var15 = var14.c();
         if(c(var15) && var5 == var14.b(b)) {
            var16 = (EnumFacing)var14.b(a);
            if(var16 == EnumFacing.NORTH && !a(var1, var2.d(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if(var16 == EnumFacing.SOUTH && !a(var1, var2.c(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumFacing.WEST) {
         var10 = 0.5F;
         var12 = 1.0F;
         var14 = var1.getData(var2.e());
         var15 = var14.c();
         if(c(var15) && var5 == var14.b(b)) {
            var16 = (EnumFacing)var14.b(a);
            if(var16 == EnumFacing.NORTH && !a(var1, var2.d(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if(var16 == EnumFacing.SOUTH && !a(var1, var2.c(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumFacing.SOUTH) {
         var11 = 0.5F;
         var12 = 1.0F;
         var14 = var1.getData(var2.d());
         var15 = var14.c();
         if(c(var15) && var5 == var14.b(b)) {
            var16 = (EnumFacing)var14.b(a);
            if(var16 == EnumFacing.WEST && !a(var1, var2.f(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if(var16 == EnumFacing.EAST && !a(var1, var2.e(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumFacing.NORTH) {
         var14 = var1.getData(var2.c());
         var15 = var14.c();
         if(c(var15) && var5 == var14.b(b)) {
            var16 = (EnumFacing)var14.b(a);
            if(var16 == EnumFacing.WEST && !a(var1, var2.f(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if(var16 == EnumFacing.EAST && !a(var1, var2.e(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      }

      this.a(var9, var7, var11, var10, var8, var12);
      return var13;
   }

   public boolean i(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      EnumFacing var4 = (EnumFacing)var3.b(a);
      bau var5 = (bau)var3.b(b);
      boolean var6 = var5 == bau.a;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if(var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 0.5F;
      float var11 = 0.5F;
      float var12 = 1.0F;
      boolean var13 = false;
      IBlockData var14;
      Block var15;
      EnumFacing var16;
      if(var4 == EnumFacing.EAST) {
         var14 = var1.getData(var2.e());
         var15 = var14.c();
         if(c(var15) && var5 == var14.b(b)) {
            var16 = (EnumFacing)var14.b(a);
            if(var16 == EnumFacing.NORTH && !a(var1, var2.c(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if(var16 == EnumFacing.SOUTH && !a(var1, var2.d(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumFacing.WEST) {
         var14 = var1.getData(var2.f());
         var15 = var14.c();
         if(c(var15) && var5 == var14.b(b)) {
            var9 = 0.5F;
            var10 = 1.0F;
            var16 = (EnumFacing)var14.b(a);
            if(var16 == EnumFacing.NORTH && !a(var1, var2.c(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if(var16 == EnumFacing.SOUTH && !a(var1, var2.d(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumFacing.SOUTH) {
         var14 = var1.getData(var2.c());
         var15 = var14.c();
         if(c(var15) && var5 == var14.b(b)) {
            var11 = 0.0F;
            var12 = 0.5F;
            var16 = (EnumFacing)var14.b(a);
            if(var16 == EnumFacing.WEST && !a(var1, var2.e(), var3)) {
               var13 = true;
            } else if(var16 == EnumFacing.EAST && !a(var1, var2.f(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumFacing.NORTH) {
         var14 = var1.getData(var2.d());
         var15 = var14.c();
         if(c(var15) && var5 == var14.b(b)) {
            var16 = (EnumFacing)var14.b(a);
            if(var16 == EnumFacing.WEST && !a(var1, var2.e(), var3)) {
               var13 = true;
            } else if(var16 == EnumFacing.EAST && !a(var1, var2.f(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      }

      if(var13) {
         this.a(var9, var7, var11, var10, var8, var12);
      }

      return var13;
   }

   public void a(World var1, Location var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.e(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
      boolean var7 = this.h(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
      if(var7 && this.i(var1, var2)) {
         super.a(var1, var2, var3, var4, var5, var6);
      }

      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(World var1, Location var2, EntityHuman var3) {
      this.O.a(var1, var2, var3);
   }

   public void d(World var1, Location var2, IBlockData var3) {
      this.O.d(var1, var2, var3);
   }

   public float a(Entity var1) {
      return this.O.a(var1);
   }

   public int a(World var1) {
      return this.O.a(var1);
   }

   public Vec3D a(World var1, Location var2, Entity var3, Vec3D var4) {
      return this.O.a(var1, var2, var3, var4);
   }

   public boolean y() {
      return this.O.y();
   }

   public boolean a(IBlockData var1, boolean var2) {
      return this.O.a(var1, var2);
   }

   public boolean c(World var1, Location var2) {
      return this.O.c(var1, var2);
   }

   public void c(World var1, Location var2, IBlockData var3) {
      this.a(var1, var2, this.P, Blocks.AIR);
      this.O.c(var1, var2, this.P);
   }

   public void b(World var1, Location var2, IBlockData var3) {
      this.O.b(var1, var2, this.P);
   }

   public void a(World var1, Location var2, Entity var3) {
      this.O.a(var1, var2, var3);
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      this.O.b(var1, var2, var3, var4);
   }

   public boolean a(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      return this.O.a(var1, var2, this.P, var4, EnumFacing.DOWN, 0.0F, 0.0F, 0.0F);
   }

   public void a(World var1, Location var2, aqo var3) {
      this.O.a(var1, var2, var3);
   }

   public MaterialMapColor g(IBlockData var1) {
      return this.O.g(this.P);
   }

   public IBlockData a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlockData var9 = super.a(var1, var2, var3, var4, var5, var6, var7, var8);
      var9 = var9.a(a, var8.aO()).a(M, bav.a);
      return var3 != EnumFacing.DOWN && (var3 == EnumFacing.UP || (double)var5 <= 0.5D)?var9.a(b, bau.b):var9.a(b, bau.a);
   }

   public MovingObjectPosition a(World var1, Location var2, Vec3D var3, Vec3D var4) {
      MovingObjectPosition[] var5 = new MovingObjectPosition[8];
      IBlockData var6 = var1.getData(var2);
      int var7 = ((EnumFacing)var6.b(a)).b();
      boolean var8 = var6.b(b) == bau.a;
      int[] var9 = N[var7 + (var8?4:0)];
      this.Q = true;

      for(int var10 = 0; var10 < 8; ++var10) {
         this.R = var10;
         if(Arrays.binarySearch(var9, var10) < 0) {
            var5[var10] = super.a(var1, var2, var3, var4);
         }
      }

      int[] var21 = var9;
      int var11 = var9.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         int var13 = var21[var12];
         var5[var13] = null;
      }

      MovingObjectPosition var19 = null;
      double var20 = 0.0D;
      MovingObjectPosition[] var22 = var5;
      int var14 = var5.length;

      for(int var15 = 0; var15 < var14; ++var15) {
         MovingObjectPosition var16 = var22[var15];
         if(var16 != null) {
            double var17 = var16.c.g(var4);
            if(var17 > var20) {
               var19 = var16;
               var20 = var17;
            }
         }
      }

      return var19;
   }

   public IBlockData a(int var1) {
      IBlockData var2 = this.P().a(b, (var1 & 4) > 0?bau.a:bau.b);
      var2 = var2.a(a, EnumFacing.a(5 - (var1 & 3)));
      return var2;
   }

   public int c(IBlockData var1) {
      int var2 = 0;
      if(var1.b(b) == bau.a) {
         var2 |= 4;
      }

      var2 |= 5 - ((EnumFacing)var1.b(a)).a();
      return var2;
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      if(this.h(var2, var3)) {
         switch(this.g(var2, var3)) {
         case 0:
            var1 = var1.a(M, bav.a);
            break;
         case 1:
            var1 = var1.a(M, bav.c);
            break;
         case 2:
            var1 = var1.a(M, bav.b);
         }
      } else {
         switch(this.f(var2, var3)) {
         case 0:
            var1 = var1.a(M, bav.a);
            break;
         case 1:
            var1 = var1.a(M, bav.e);
            break;
         case 2:
            var1 = var1.a(M, bav.d);
         }
      }

      return var1;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b, M});
   }

}
