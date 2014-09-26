package net.minecraft.server;


public class ItemFireworks extends Item {

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(!var3.isStatic) {
         EntityFireworks var9 = new EntityFireworks(var3, (double)((float)var4.n() + var6), (double)((float)var4.o() + var7), (double)((float)var4.p() + var8), var1);
         var3.addEntity((Entity)var9);
         if(!var2.abilities.canInstantlyBuild) {
            --var1.count;
         }

         return true;
      } else {
         return false;
      }
   }
}
