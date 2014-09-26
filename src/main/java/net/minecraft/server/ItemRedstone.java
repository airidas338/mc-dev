package net.minecraft.server;


public class ItemRedstone extends Item {

   public ItemRedstone() {
      this.a(CreativeModeTab.d);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      boolean var9 = var3.getData(var4).c().f(var3, var4);
      Location var10 = var9?var4:var4.a(var5);
      if(!var2.a(var10, var5, var1)) {
         return false;
      } else {
         Block var11 = var3.getData(var10).c();
         if(!var3.mayPlace(var11, var10, false, var5, (Entity)null, var1)) {
            return false;
         } else if(Blocks.REDSTONE_WIRE.canPlace(var3, var10)) {
            --var1.count;
            var3.a(var10, Blocks.REDSTONE_WIRE.P());
            return true;
         } else {
            return false;
         }
      }
   }
}
