package net.minecraft.server;


public class bpx extends bpu {

   public void a(IBlockAccess var1, Entity var2) {
      super.a(var1, var2);
   }

   public void a() {
      super.a();
   }

   public PathPoint a(Entity var1) {
      return this.a(MathHelper.floor(var1.aQ().a), MathHelper.floor(var1.aQ().b + 0.5D), MathHelper.floor(var1.aQ().c));
   }

   public PathPoint a(Entity var1, double var2, double var4, double var6) {
      return this.a(MathHelper.floor(var2 - (double)(var1.J / 2.0F)), MathHelper.floor(var4 + 0.5D), MathHelper.floor(var6 - (double)(var1.J / 2.0F)));
   }

   public int a(PathPoint[] var1, Entity var2, PathPoint var3, PathPoint var4, float var5) {
      int var6 = 0;
      EnumFacing[] var7 = EnumFacing.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         EnumFacing var10 = var7[var9];
         PathPoint var11 = this.a(var2, var3.a + var10.g(), var3.b + var10.h(), var3.c + var10.i());
         if(var11 != null && !var11.i && var11.a(var4) < var5) {
            var1[var6++] = var11;
         }
      }

      return var6;
   }

   private PathPoint a(Entity var1, int var2, int var3, int var4) {
      int var5 = this.b(var1, var2, var3, var4);
      return var5 == -1?this.a(var2, var3, var4):null;
   }

   private int b(Entity var1, int var2, int var3, int var4) {
      for(int var5 = var2; var5 < var2 + this.c; ++var5) {
         for(int var6 = var3; var6 < var3 + this.d; ++var6) {
            for(int var7 = var4; var7 < var4 + this.e; ++var7) {
               Location var8 = new Location(var5, var6, var7);
               Block var9 = this.a.getData(var8).c();
               if(var9.getMaterial() != Material.WATER) {
                  return 0;
               }
            }
         }
      }

      return -1;
   }
}
