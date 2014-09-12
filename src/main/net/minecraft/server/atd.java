package net.minecraft.server;

public class atd extends atb {

   public atd() {
      this.j(this.L.b().a(b, Integer.valueOf(0)));
   }

   public void a(World var1, Location var2, IBlock var3, Block var4) {
      if(!var1.p(var2.b()).c().r().a()) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   public IBlock a(int var1) {
      return this.P().a(b, Integer.valueOf(var1));
   }

   public int c(IBlock var1) {
      return ((Integer)var1.b(b)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{b});
   }
}
