package net.minecraft.server;

final class DispenserBehaviorPotion implements IDispenseBehavior {

   private final DispenserBehaviorItem b = new DispenserBehaviorItem();


   public ItemStack a(ISourceBlock var1, ItemStack var2) {
      return ItemPotion.f(var2.getData())?(new or(this, var2)).a(var1, var2):this.b.a(var1, var2);
   }
}
