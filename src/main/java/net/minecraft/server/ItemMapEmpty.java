package net.minecraft.server;

public class ItemMapEmpty extends ake {

   protected ItemMapEmpty() {
      this.a(CreativeModeTab.f);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      ItemStack var4 = new ItemStack(Items.bd, 1, var2.b("map"));
      String var5 = "map_" + var4.i();
      WorldMap var6 = new WorldMap(var5);
      var2.a(var5, (PersistentBase)var6);
      var6.e = 0;
      var6.a(var3.s, var3.u, var6.e);
      var6.d = (byte)var2.t.q();
      var6.c();
      --var1.b;
      if(var1.b <= 0) {
         return var4;
      } else {
         if(!var3.bg.a(var4.k())) {
            var3.a(var4, false);
         }

         var3.b(ty.J[Item.b((Item)this)]);
         return var1;
      }
   }
}
