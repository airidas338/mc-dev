package net.minecraft.server;

final class DispenserBehaviorFlintAndSteel extends DispenserBehaviorItem {

   private boolean b = true;


   protected ItemStack b(ISourceBlock var1, ItemStack var2) {
      World var3 = var1.i();
      Location var4 = var1.d().a(BlockDispenser.b(var1.f()));
      if(var3.d(var4)) {
         var3.a(var4, Blocks.ab.P());
         if(var2.a(1, var3.s)) {
            var2.b = 0;
         }
      } else if(var3.getData(var4).c() == Blocks.W) {
         Blocks.W.d(var3, var4, Blocks.W.P().a(BlockTNT.a, Boolean.valueOf(true)));
         var3.g(var4);
      } else {
         this.b = false;
      }

      return var2;
   }

   protected void a(ISourceBlock var1) {
      if(this.b) {
         var1.i().b(1000, var1.d(), 0);
      } else {
         var1.i().b(1001, var1.d(), 0);
      }

   }
}
