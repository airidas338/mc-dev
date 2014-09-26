package net.minecraft.server;


final class DispenserBehaviorMonsterEgg extends DispenserBehaviorItem {

   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      EnumFacing var3 = BlockDispenser.b(var1.f());
      double var4 = var1.getX() + (double)var3.g();
      double var6 = (double)((float)var1.d().o() + 0.2F);
      double var8 = var1.getZ() + (double)var3.i();
      Entity var10 = ItemMonsterEgg.a(var1.i(), var2.getData(), var4, var6, var8);
      if(var10 instanceof EntityLiving && var2.hasName()) {
         ((EntityInsentient)var10).a(var2.getName());
      }

      var2.a(1);
      return var2;
   }
}
