package net.minecraft.server;

public class wl extends wp {

   protected wl(int var1, oa var2, boolean var3, int var4) {
      super(var1, var2, var3, var4);
   }

   public void a(xm var1, yc var2, int var3) {
      var1.l(var1.bM() - (float)(4 * (var3 + 1)));
      super.a(var1, var2, var3);
   }

   public void b(xm var1, yc var2, int var3) {
      var1.l(var1.bM() + (float)(4 * (var3 + 1)));
      super.b(var1, var2, var3);
   }
}
