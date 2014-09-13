package net.minecraft.server;

final class DispenserBehaviorEgg extends oc {

   protected IProjectile a(World var1, IPosition var2) {
      return new EntityEgg(var1, var2.getX(), var2.getY(), var2.getZ());
   }
}
