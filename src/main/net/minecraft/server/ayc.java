package net.minecraft.server;
import java.util.Random;

public class ayc extends Block {

   public static final bet a = bet.a("snowy");


   protected ayc() {
      super(Material.b);
      this.j(this.L.b().a(a, Boolean.valueOf(false)));
      this.a(true);
      this.a(akf.b);
   }

   public IBlock a(IBlock var1, ard var2, Location var3) {
      Block var4 = var2.p(var3.a()).c();
      return var1.a(a, Boolean.valueOf(var4 == aty.aJ || var4 == aty.aH));
   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      if(!var1.D) {
         if(var1.l(var2.a()) < 4 && var1.p(var2.a()).c().n() > 2) {
            var1.a(var2, aty.d.P().a(avc.a, avd.a));
         } else {
            if(var1.l(var2.a()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  Location var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
                  IBlock var7 = var1.p(var6);
                  Block var8 = var1.p(var6.a()).c();
                  if(var7.c() == aty.d && var7.b(avc.a) == avd.a && var1.l(var6.a()) >= 4 && var8.n() <= 2) {
                     var1.a(var6, this.P());
                  }
               }
            }

         }
      }
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return aty.d.a(aty.d.P().a(avc.a, avd.a), var2, var3);
   }

   public int c(IBlock var1) {
      return 0;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
