package net.minecraft.server;

public class arj implements IBlockAccess {

   protected int a;
   protected int b;
   protected bfh[][] c;
   protected boolean d;
   protected World e;


   public arj(World var1, Location var2, Location var3, int var4) {
      this.e = var1;
      this.a = var2.n() - var4 >> 4;
      this.b = var2.p() - var4 >> 4;
      int var5 = var3.n() + var4 >> 4;
      int var6 = var3.p() + var4 >> 4;
      this.c = new bfh[var5 - this.a + 1][var6 - this.b + 1];
      this.d = true;

      int var7;
      int var8;
      for(var7 = this.a; var7 <= var5; ++var7) {
         for(var8 = this.b; var8 <= var6; ++var8) {
            this.c[var7 - this.a][var8 - this.b] = var1.a(var7, var8);
         }
      }

      for(var7 = var2.n() >> 4; var7 <= var3.n() >> 4; ++var7) {
         for(var8 = var2.p() >> 4; var8 <= var3.p() >> 4; ++var8) {
            bfh var9 = this.c[var7 - this.a][var8 - this.b];
            if(var9 != null && !var9.c(var2.o(), var3.o())) {
               this.d = false;
            }
         }
      }

   }

   public bcm s(Location var1) {
      int var2 = (var1.n() >> 4) - this.a;
      int var3 = (var1.p() >> 4) - this.b;
      return this.c[var2][var3].a(var1, bfl.a);
   }

   public IBlock getData(Location var1) {
      if(var1.o() >= 0 && var1.o() < 256) {
         int var2 = (var1.n() >> 4) - this.a;
         int var3 = (var1.p() >> 4) - this.b;
         if(var2 >= 0 && var2 < this.c.length && var3 >= 0 && var3 < this.c[var2].length) {
            bfh var4 = this.c[var2][var3];
            if(var4 != null) {
               return var4.g(var1);
            }
         }
      }

      return aty.a.P();
   }

   public boolean d(Location var1) {
      return this.getData(var1).c().r() == Material.AIR;
   }

   public int a(Location var1, ej var2) {
      IBlock var3 = this.getData(var1);
      return var3.c().b((IBlockAccess)this, var1, var3, var2);
   }
}
