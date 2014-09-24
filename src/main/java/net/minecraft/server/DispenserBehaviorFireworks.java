package net.minecraft.server;


final class DispenserBehaviorFireworks extends DispenserBehaviorItem {

   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      EnumFacing var3 = BlockDispenser.b(var1.f());
      double var4 = var1.getX() + (double)var3.g();
      double var6 = (double)((float)var1.d().o() + 0.2F);
      double var8 = var1.getZ() + (double)var3.i();
      EntityFireworks var10 = new EntityFireworks(var1.i(), var4, var6, var8, var2);
      var1.i().addEntity((Entity)var10);
      var2.a(1);
      return var2;
   }

   protected void a(ISourceBlock var1) {
      var1.i().triggerEffect(1002, var1.d(), 0);
   }
}
