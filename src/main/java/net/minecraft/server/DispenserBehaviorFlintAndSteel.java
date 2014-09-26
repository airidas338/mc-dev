package net.minecraft.server;

final class DispenserBehaviorFlintAndSteel extends DispenserBehaviorItem {

   private boolean b = true;


   protected ItemStack b(ISourceBlock var1, ItemStack var2) {
      World var3 = var1.i();
      Location var4 = var1.d().a(BlockDispenser.b(var1.f()));
      if(var3.isEmpty(var4)) {
         var3.a(var4, Blocks.FIRE.P());
         if(var2.isDamaged(1, var3.random)) {
            var2.count = 0;
         }
      } else if(var3.getData(var4).c() == Blocks.TNT) {
         Blocks.TNT.postBreak(var3, var4, Blocks.TNT.P().a(BlockTNT.a, Boolean.valueOf(true)));
         var3.setAir(var4);
      } else {
         this.b = false;
      }

      return var2;
   }

   protected void a(ISourceBlock var1) {
      if(this.b) {
         var1.i().triggerEffect(1000, var1.d(), 0);
      } else {
         var1.i().triggerEffect(1001, var1.d(), 0);
      }

   }
}
