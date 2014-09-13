package net.minecraft.server;

public class ajy extends Item {

   public ajy() {
      this.a(CreativeModeTab.k);
   }

   public amj a(amj var1, World var2, EntityHuman var3) {
      MovingObjectPosition var4 = this.a(var2, var3, true);
      if(var4 == null) {
         return var1;
      } else {
         if(var4.a == brv.b) {
            Location var5 = var4.a();
            if(!var2.a(var3, var5)) {
               return var1;
            }

            if(!var3.a(var5.a(var4.b), var4.b, var1)) {
               return var1;
            }

            if(var2.getData(var5).c().r() == Material.WATER) {
               --var1.b;
               var3.b(ty.J[Item.b((Item)this)]);
               if(var1.b <= 0) {
                  return new amj(Items.bz);
               }

               if(!var3.bg.a(new amj(Items.bz))) {
                  var3.a(new amj(Items.bz, 1, 0), false);
               }
            }
         }

         return var1;
      }
   }
}
