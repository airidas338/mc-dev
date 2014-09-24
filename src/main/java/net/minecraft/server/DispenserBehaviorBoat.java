package net.minecraft.server;


final class DispenserBehaviorBoat extends DispenserBehaviorItem {

   private final DispenserBehaviorItem b = new DispenserBehaviorItem();


   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      EnumFacing var3 = BlockDispenser.b(var1.f());
      World var4 = var1.i();
      double var5 = var1.getX() + (double)((float)var3.g() * 1.125F);
      double var7 = var1.getY() + (double)((float)var3.h() * 1.125F);
      double var9 = var1.getZ() + (double)((float)var3.i() * 1.125F);
      Location var11 = var1.d().a(var3);
      Material var12 = var4.getData(var11).c().getMaterial();
      double var13;
      if(Material.WATER.equals(var12)) {
         var13 = 1.0D;
      } else {
         if(!Material.AIR.equals(var12) || !Material.WATER.equals(var4.getData(var11.b()).c().getMaterial())) {
            return this.b.a(var1, var2);
         }

         var13 = 0.0D;
      }

      EntityBoat var15 = new EntityBoat(var4, var5, var7 + var13, var9);
      var4.addEntity((Entity)var15);
      var2.a(1);
      return var2;
   }

   protected void a(ISourceBlock var1) {
      var1.i().triggerEffect(1000, var1.d(), 0);
   }
}
