package net.minecraft.server;


public class ItemMinecart extends Item {

   private static final IDispenseBehavior a = new amq();
   private final EnumMinecartType b;


   public ItemMinecart(EnumMinecartType var1) {
      this.maxStackSize = 1;
      this.b = var1;
      this.a(CreativeModeTab.e);
      BlockDispenser.M.a(this, a);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      IBlockData var9 = var3.getData(var4);
      if(BlockMinecartTrackAbstract.d(var9)) {
         if(!var3.isStatic) {
            atl var10 = var9.c() instanceof BlockMinecartTrackAbstract?(atl)var9.b(((BlockMinecartTrackAbstract)var9.c()).l()):atl.a;
            double var11 = 0.0D;
            if(var10.c()) {
               var11 = 0.5D;
            }

            EntityMinecartAbstract var13 = EntityMinecartAbstract.a(var3, (double)var4.n() + 0.5D, (double)var4.o() + 0.0625D + var11, (double)var4.p() + 0.5D, this.b);
            if(var1.hasName()) {
               var13.a(var1.getName());
            }

            var3.addEntity((Entity)var13);
         }

         --var1.count;
         return true;
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   static EnumMinecartType a(ItemMinecart var0) {
      return var0.b;
   }

}
