package net.minecraft.server;

final class DispenserBehaviorFilledBucket extends DispenserBehaviorItem {

   private final DispenserBehaviorItem b = new DispenserBehaviorItem();


   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      akb var3 = (akb)var2.b();
      Location var4 = var1.d().a(BlockDispenser.b(var1.f()));
      if(var3.a(var1.i(), var4)) {
         var2.a(Items.BUCKET);
         var2.b = 1;
         return var2;
      } else {
         return this.b.a(var1, var2);
      }
   }
}
