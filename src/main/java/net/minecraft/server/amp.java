package net.minecraft.server;


public class amp extends Item {

   private static final IDispenseBehavior a = new amq();
   private final EnumMinecartType b;


   public amp(EnumMinecartType var1) {
      this.h = 1;
      this.b = var1;
      this.a(CreativeModeTab.e);
      BlockDispenser.M.a(this, a);
   }

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      IBlockData var9 = var3.getData(var4);
      if(ati.d(var9)) {
         if(!var3.isStatic) {
            atl var10 = var9.c() instanceof ati?(atl)var9.b(((ati)var9.c()).l()):atl.a;
            double var11 = 0.0D;
            if(var10.c()) {
               var11 = 0.5D;
            }

            EntityMinecartAbstract var13 = EntityMinecartAbstract.a(var3, (double)var4.n() + 0.5D, (double)var4.o() + 0.0625D + var11, (double)var4.p() + 0.5D, this.b);
            if(var1.s()) {
               var13.a(var1.q());
            }

            var3.d((Entity)var13);
         }

         --var1.b;
         return true;
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   static EnumMinecartType a(amp var0) {
      return var0.b;
   }

}
