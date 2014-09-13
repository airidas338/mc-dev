package net.minecraft.server;

final class DispenserBehaviorSnowBall extends oc {

   protected IProjectile a(World var1, IPosition var2) {
      return new EntitySnowball(var1, var2.getX(), var2.getY(), var2.getZ());
   }
}
