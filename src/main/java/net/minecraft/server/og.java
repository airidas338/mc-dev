package net.minecraft.server;

final class og extends eg {

   private final eg b = new eg();


   public amj b(dz var1, amj var2) {
      World var3 = var1.i();
      Location var4 = var1.d().a(BlockDispenser.b(var1.f()));
      IBlock var5 = var3.getData(var4);
      Block var6 = var5.c();
      Material var7 = var6.r();
      Item var8;
      if(Material.WATER.equals(var7) && var6 instanceof axl && ((Integer)var5.b(axl.b)).intValue() == 0) {
         var8 = Items.ax;
      } else {
         if(!Material.LAVA.equals(var7) || !(var6 instanceof axl) || ((Integer)var5.b(axl.b)).intValue() != 0) {
            return super.b(var1, var2);
         }

         var8 = Items.ay;
      }

      var3.g(var4);
      if(--var2.b == 0) {
         var2.a(var8);
         var2.b = 1;
      } else if(((bcx)var1.h()).a(new amj(var8)) < 0) {
         this.b.a(var1, new amj(var8));
      }

      return var2;
   }
}
