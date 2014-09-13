package net.minecraft.server;

final class DispenserBehaviorBonemeal extends DispenserBehaviorItem {

   private boolean b = true;


   protected ItemStack b(ISourceBlock var1, ItemStack var2) {
      if(akv.a == akv.a(var2.i())) {
         World var3 = var1.i();
         Location var4 = var1.d().a(BlockDispenser.b(var1.f()));
         if(akw.a(var2, var3, var4)) {
            if(!var3.D) {
               var3.b(2005, var4, 0);
            }
         } else {
            this.b = false;
         }

         return var2;
      } else {
         return super.b(var1, var2);
      }
   }

   protected void a(ISourceBlock var1) {
      if(this.b) {
         var1.i().b(1000, var1.d(), 0);
      } else {
         var1.i().b(1001, var1.d(), 0);
      }

   }
}
