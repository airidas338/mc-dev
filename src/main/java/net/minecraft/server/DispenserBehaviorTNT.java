package net.minecraft.server;


final class DispenserBehaviorTNT extends DispenserBehaviorItem {

   protected ItemStack b(ISourceBlock var1, ItemStack var2) {
      World var3 = var1.i();
      Location var4 = var1.d().a(BlockDispenser.b(var1.f()));
      EntityTNTPrimed var5 = new EntityTNTPrimed(var3, (double)var4.n() + 0.5D, (double)var4.o(), (double)var4.p() + 0.5D, (EntityLiving)null);
      var3.d((Entity)var5);
      var3.a((Entity)var5, "game.tnt.primed", 1.0F, 1.0F);
      --var2.b;
      return var2;
   }
}
