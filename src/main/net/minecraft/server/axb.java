package net.minecraft.server;
import java.util.Random;

public class axb extends awt {

   public axb() {
      super(Material.w, false);
      this.K = 0.98F;
      this.a(true);
      this.a(akf.b);
   }

   public void a(World var1, EntityHuman var2, Location var3, IBlock var4, bcm var5) {
      var2.b(ty.H[Block.a((Block)this)]);
      var2.a(0.025F);
      if(this.G() && EnchantmentManager.e(var2)) {
         amj var8 = this.i(var4);
         if(var8 != null) {
            a(var1, var3, var8);
         }
      } else {
         if(var1.t.n()) {
            var1.g(var3);
            return;
         }

         int var6 = EnchantmentManager.f(var2);
         this.b(var1, var3, var4, var6);
         Material var7 = var1.p(var3.b()).c().r();
         if(var7.c() || var7.d()) {
            var1.a(var3, aty.i.P());
         }
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      if(var1.b(EnumSkyBlock.BLOCK, var2) > 11 - this.n()) {
         if(var1.t.n()) {
            var1.g(var2);
         } else {
            this.b(var1, var2, var1.p(var2), 0);
            var1.a(var2, aty.j.P());
         }
      }
   }

   public int i() {
      return 0;
   }
}