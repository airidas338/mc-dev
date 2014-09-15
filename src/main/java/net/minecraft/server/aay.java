package net.minecraft.server;
import java.util.Iterator;

public class aay extends Navigation {

   protected bpy a;
   private boolean f;


   public aay(EntityInsentient var1, World var2) {
      super(var1, var2);
   }

   protected bpw a() {
      this.a = new bpy();
      this.a.a(true);
      return new bpw(this.a);
   }

   protected boolean b() {
      return this.b.C || this.h() && this.o() || this.b.av() && this.b instanceof EntityZombie && this.b.m instanceof EntityChicken;
   }

   protected Vec3D c() {
      return new Vec3D(this.b.s, (double)this.p(), this.b.u);
   }

   private int p() {
      if(this.b.V() && this.h()) {
         int var1 = (int)this.b.aQ().b;
         Block var2 = this.c.getData(new Location(MathHelper.floor(this.b.s), var1, MathHelper.floor(this.b.u))).c();
         int var3 = 0;

         do {
            if(var2 != Blocks.WATER && var2 != Blocks.STATIONARY_WATER) {
               return var1;
            }

            ++var1;
            var2 = this.c.getData(new Location(MathHelper.floor(this.b.s), var1, MathHelper.floor(this.b.u))).c();
            ++var3;
         } while(var3 <= 16);

         return (int)this.b.aQ().b;
      } else {
         return (int)(this.b.aQ().b + 0.5D);
      }
   }

   protected void d() {
      super.d();
      if(this.f) {
         if(this.c.i(new Location(MathHelper.floor(this.b.s), (int)(this.b.aQ().b + 0.5D), MathHelper.floor(this.b.u)))) {
            return;
         }

         for(int var1 = 0; var1 < this.d.d(); ++var1) {
            bpt var2 = this.d.a(var1);
            if(this.c.i(new Location(var2.a, var2.b, var2.c))) {
               this.d.b(var1 - 1);
               return;
            }
         }
      }

   }

   protected boolean a(Vec3D var1, Vec3D var2, int var3, int var4, int var5) {
      int var6 = MathHelper.floor(var1.a);
      int var7 = MathHelper.floor(var1.c);
      double var8 = var2.a - var1.a;
      double var10 = var2.c - var1.c;
      double var12 = var8 * var8 + var10 * var10;
      if(var12 < 1.0E-8D) {
         return false;
      } else {
         double var14 = 1.0D / Math.sqrt(var12);
         var8 *= var14;
         var10 *= var14;
         var3 += 2;
         var5 += 2;
         if(!this.a(var6, (int)var1.b, var7, var3, var4, var5, var1, var8, var10)) {
            return false;
         } else {
            var3 -= 2;
            var5 -= 2;
            double var16 = 1.0D / Math.abs(var8);
            double var18 = 1.0D / Math.abs(var10);
            double var20 = (double)(var6 * 1) - var1.a;
            double var22 = (double)(var7 * 1) - var1.c;
            if(var8 >= 0.0D) {
               ++var20;
            }

            if(var10 >= 0.0D) {
               ++var22;
            }

            var20 /= var8;
            var22 /= var10;
            int var24 = var8 < 0.0D?-1:1;
            int var25 = var10 < 0.0D?-1:1;
            int var26 = MathHelper.floor(var2.a);
            int var27 = MathHelper.floor(var2.c);
            int var28 = var26 - var6;
            int var29 = var27 - var7;

            do {
               if(var28 * var24 <= 0 && var29 * var25 <= 0) {
                  return true;
               }

               if(var20 < var22) {
                  var20 += var16;
                  var6 += var24;
                  var28 = var26 - var6;
               } else {
                  var22 += var18;
                  var7 += var25;
                  var29 = var27 - var7;
               }
            } while(this.a(var6, (int)var1.b, var7, var3, var4, var5, var1, var8, var10));

            return false;
         }
      }
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, Vec3D var7, double var8, double var10) {
      int var12 = var1 - var4 / 2;
      int var13 = var3 - var6 / 2;
      if(!this.b(var12, var2, var13, var4, var5, var6, var7, var8, var10)) {
         return false;
      } else {
         for(int var14 = var12; var14 < var12 + var4; ++var14) {
            for(int var15 = var13; var15 < var13 + var6; ++var15) {
               double var16 = (double)var14 + 0.5D - var7.a;
               double var18 = (double)var15 + 0.5D - var7.c;
               if(var16 * var8 + var18 * var10 >= 0.0D) {
                  Block var20 = this.c.getData(new Location(var14, var2 - 1, var15)).c();
                  Material var21 = var20.getMaterial();
                  if(var21 == Material.AIR) {
                     return false;
                  }

                  if(var21 == Material.WATER && !this.b.V()) {
                     return false;
                  }

                  if(var21 == Material.LAVA) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private boolean b(int var1, int var2, int var3, int var4, int var5, int var6, Vec3D var7, double var8, double var10) {
      Iterator var12 = Location.a(new Location(var1, var2, var3), new Location(var1 + var4 - 1, var2 + var5 - 1, var3 + var6 - 1)).iterator();

      while(var12.hasNext()) {
         Location var13 = (Location)var12.next();
         double var14 = (double)var13.n() + 0.5D - var7.a;
         double var16 = (double)var13.p() + 0.5D - var7.c;
         if(var14 * var8 + var16 * var10 >= 0.0D) {
            Block var18 = this.c.getData(var13).c();
            if(!var18.b(this.c, var13)) {
               return false;
            }
         }
      }

      return true;
   }

   public void save(boolean var1) {
      this.a.c(var1);
   }

   public boolean e() {
      return this.a.e();
   }

   public void b(boolean var1) {
      this.a.b(var1);
   }

   public void c(boolean var1) {
      this.a.a(var1);
   }

   public boolean g() {
      return this.a.b();
   }

   public void d(boolean var1) {
      this.a.d(var1);
   }

   public boolean h() {
      return this.a.d();
   }

   public void e(boolean var1) {
      this.f = var1;
   }
}
