package net.minecraft.server;


final class amq extends DispenserBehaviorItem {

   private final DispenserBehaviorItem b = new DispenserBehaviorItem();


   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      EnumFacing var3 = BlockDispenser.b(var1.f());
      World var4 = var1.i();
      double var5 = var1.getX() + (double)var3.g() * 1.125D;
      double var7 = Math.floor(var1.getY()) + (double)var3.h();
      double var9 = var1.getZ() + (double)var3.i() * 1.125D;
      Location var11 = var1.d().a(var3);
      IBlockData var12 = var4.getData(var11);
      atl var13 = var12.c() instanceof BlockMinecartTrackAbstract?(atl)var12.b(((BlockMinecartTrackAbstract)var12.c()).l()):atl.a;
      double var14;
      if(BlockMinecartTrackAbstract.d(var12)) {
         if(var13.c()) {
            var14 = 0.6D;
         } else {
            var14 = 0.1D;
         }
      } else {
         if(var12.c().getMaterial() != Material.AIR || !BlockMinecartTrackAbstract.d(var4.getData(var11.b()))) {
            return this.b.a(var1, var2);
         }

         IBlockData var16 = var4.getData(var11.b());
         atl var17 = var16.c() instanceof BlockMinecartTrackAbstract?(atl)var16.b(((BlockMinecartTrackAbstract)var16.c()).l()):atl.a;
         if(var3 != EnumFacing.DOWN && var17.c()) {
            var14 = -0.4D;
         } else {
            var14 = -0.9D;
         }
      }

      EntityMinecartAbstract var18 = EntityMinecartAbstract.a(var4, var5, var7 + var14, var9, amp.a((amp)var2.b()));
      if(var2.s()) {
         var18.a(var2.q());
      }

      var4.d((Entity)var18);
      var2.a(1);
      return var2;
   }

   protected void a(ISourceBlock var1) {
      var1.i().b(1000, var1.d(), 0);
   }
}
