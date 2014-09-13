package net.minecraft.server;


public class amz extends Item {

   public amz() {
      this.a(CreativeModeTab.d);
   }

   public boolean a(amj var1, EntityHuman var2, World var3, Location var4, ej var5, float var6, float var7, float var8) {
      boolean var9 = var3.getData(var4).c().f(var3, var4);
      Location var10 = var9?var4:var4.a(var5);
      if(!var2.a(var10, var5, var1)) {
         return false;
      } else {
         Block var11 = var3.getData(var10).c();
         if(!var3.a(var11, var10, false, var5, (Entity)null, var1)) {
            return false;
         } else if(Blocks.af.c(var3, var10)) {
            --var1.b;
            var3.a(var10, Blocks.af.P());
            return true;
         } else {
            return false;
         }
      }
   }
}
