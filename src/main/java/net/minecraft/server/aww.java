package net.minecraft.server;


public class aww extends baa {

   public aww() {
      super(bof.b);
      this.j(this.L.b().a(M, el.b));
      this.a(akf.b);
   }

   public bec a(int var1) {
      el var2 = el.b;
      int var3 = var1 & 12;
      if(var3 == 4) {
         var2 = el.a;
      } else if(var3 == 8) {
         var2 = el.c;
      }

      return this.P().a(M, var2);
   }

   public int c(bec var1) {
      int var2 = 0;
      el var3 = (el)var1.b(M);
      if(var3 == el.a) {
         var2 |= 4;
      } else if(var3 == el.c) {
         var2 |= 8;
      }

      return var2;
   }

   protected bed e() {
      return new bed(this, new bex[]{M});
   }

   protected amj i(bec var1) {
      return new amj(alq.a((atr)this), 1, 0);
   }

   public bec a(World var1, dt var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(M, var3.k());
   }
}
