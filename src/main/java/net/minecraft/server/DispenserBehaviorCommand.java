package net.minecraft.server;

final class DispenserBehaviorCommand extends DispenserBehaviorItem {

   protected ItemStack b(ISourceBlock var1, ItemStack var2) {
      World var3 = var1.i();
      Location var4 = var1.d().a(BlockDispenser.b(var1.f()));
      if(var3.isEmpty(var4)) {
         if(!var3.isStatic) {
            IBlockData var5 = Blocks.COMMAND.P().a(BlockCommand.a, Boolean.valueOf(false));
            var3.setTypeAndData(var4, var5, 3);
            ItemBlock.a(var3, var4, var2);
            var3.applyPhysics(var1.d(), var1.e());
         }

         --var2.count;
      }

      return var2;
   }

   protected void a(ISourceBlock var1) {}

   protected void a(ISourceBlock var1, EnumFacing var2) {}
}
