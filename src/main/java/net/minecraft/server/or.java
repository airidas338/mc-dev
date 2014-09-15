package net.minecraft.server;

class or extends DispenserBehaviorProjectile {

   // $FF: synthetic field
   final ItemStack b;
   // $FF: synthetic field
   final DispenserBehaviorPotion c;


   or(DispenserBehaviorPotion var1, ItemStack var2) {
      this.c = var1;
      this.b = var2;
   }

   protected IProjectile a(World var1, IPosition var2) {
      return new EntityPotion(var1, var2.getX(), var2.getY(), var2.getZ(), this.b.k());
   }

   protected float a() {
      return super.a() * 0.5F;
   }

   protected float b() {
      return super.b() * 1.25F;
   }
}
