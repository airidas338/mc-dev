package net.minecraft.server;


public class alg extends Item {

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(!var3.isStatic) {
         EntityFireworks var9 = new EntityFireworks(var3, (double)((float)var4.n() + var6), (double)((float)var4.o() + var7), (double)((float)var4.p() + var8), var1);
         var3.addEntity((Entity)var9);
         if(!var2.by.canInstantlyBuild) {
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }
}
