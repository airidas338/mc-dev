package net.minecraft.server;

public class anb extends all {

   private Block b;
   private Block c;


   public anb(int var1, float var2, Block var3, Block var4) {
      super(var1, var2, false);
      this.b = var3;
      this.c = var4;
   }

   public boolean a(amj var1, EntityHuman var2, World var3, Location var4, ej var5, float var6, float var7, float var8) {
      if(var5 != ej.b) {
         return false;
      } else if(!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else if(var3.p(var4).c() == this.c && var3.d(var4.a())) {
         var3.a(var4.a(), this.b.P());
         --var1.b;
         return true;
      } else {
         return false;
      }
   }
}
