package net.minecraft.server;
import java.util.Random;

public class BlockCrops extends auc implements atz {

   public static final bew a = bew.a("age", 0, 7);


   protected BlockCrops() {
      this.j(this.L.b().a(a, Integer.valueOf(0)));
      this.a(true);
      float var1 = 0.5F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.a((CreativeModeTab)null);
      this.c(0.0F);
      this.a(h);
      this.J();
   }

   protected boolean c(Block var1) {
      return var1 == aty.ak;
   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.l(var2.a()) >= 9) {
         int var5 = ((Integer)var3.b(a)).intValue();
         if(var5 < 7) {
            float var6 = a(this, var1, var2);
            if(var4.nextInt((int)(25.0F / var6) + 1) == 0) {
               var1.a(var2, var3.a(a, Integer.valueOf(var5 + 1)), 2);
            }
         }
      }

   }

   public void g(World var1, Location var2, IBlock var3) {
      int var4 = ((Integer)var3.b(a)).intValue() + MathHelper.a(var1.s, 2, 5);
      if(var4 > 7) {
         var4 = 7;
      }

      var1.a(var2, var3.a(a, Integer.valueOf(var4)), 2);
   }

   protected static float a(Block var0, World var1, Location var2) {
      float var3 = 1.0F;
      Location var4 = var2.b();

      for(int var5 = -1; var5 <= 1; ++var5) {
         for(int var6 = -1; var6 <= 1; ++var6) {
            float var7 = 0.0F;
            IBlock var8 = var1.getData(var4.a(var5, 0, var6));
            if(var8.c() == aty.ak) {
               var7 = 1.0F;
               if(((Integer)var8.b(BlockSoil.a)).intValue() > 0) {
                  var7 = 3.0F;
               }
            }

            if(var5 != 0 || var6 != 0) {
               var7 /= 4.0F;
            }

            var3 += var7;
         }
      }

      Location var12 = var2.c();
      Location var13 = var2.d();
      Location var15 = var2.e();
      Location var14 = var2.f();
      boolean var9 = var0 == var1.getData(var15).c() || var0 == var1.getData(var14).c();
      boolean var10 = var0 == var1.getData(var12).c() || var0 == var1.getData(var13).c();
      if(var9 && var10) {
         var3 /= 2.0F;
      } else {
         boolean var11 = var0 == var1.getData(var15.c()).c() || var0 == var1.getData(var14.c()).c() || var0 == var1.getData(var14.d()).c() || var0 == var1.getData(var15.d()).c();
         if(var11) {
            var3 /= 2.0F;
         }
      }

      return var3;
   }

   public boolean f(World var1, Location var2, IBlock var3) {
      return (var1.k(var2) >= 8 || var1.i(var2)) && this.c(var1.getData(var2.b()).c());
   }

   protected Item j() {
      return Items.N;
   }

   protected Item l() {
      return Items.O;
   }

   public void a(World var1, Location var2, IBlock var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, 0);
      if(!var1.D) {
         int var6 = ((Integer)var3.b(a)).intValue();
         if(var6 >= 7) {
            int var7 = 3 + var5;

            for(int var8 = 0; var8 < var7; ++var8) {
               if(var1.s.nextInt(15) <= var6) {
                  a(var1, var2, new amj(this.j(), 1, 0));
               }
            }
         }

      }
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return ((Integer)var1.b(a)).intValue() == 7?this.l():this.j();
   }

   public boolean a(World var1, Location var2, IBlock var3, boolean var4) {
      return ((Integer)var3.b(a)).intValue() < 7;
   }

   public boolean a(World var1, Random var2, Location var3, IBlock var4) {
      return true;
   }

   public void b(World var1, Random var2, Location var3, IBlock var4) {
      this.g(var1, var3, var4);
   }

   public IBlock a(int var1) {
      return this.P().a(a, Integer.valueOf(var1));
   }

   public int c(IBlock var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
