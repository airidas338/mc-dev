package net.minecraft.server;
import java.util.Random;

final class DispenserBehaviorFireball extends DispenserBehaviorItem {

   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      EnumFacing var3 = BlockDispenser.b(var1.f());
      IPosition var4 = BlockDispenser.a(var1);
      double var5 = var4.getX() + (double)((float)var3.g() * 0.3F);
      double var7 = var4.getY() + (double)((float)var3.g() * 0.3F);
      double var9 = var4.getZ() + (double)((float)var3.i() * 0.3F);
      World var11 = var1.i();
      Random var12 = var11.random;
      double var13 = var12.nextGaussian() * 0.05D + (double)var3.g();
      double var15 = var12.nextGaussian() * 0.05D + (double)var3.h();
      double var17 = var12.nextGaussian() * 0.05D + (double)var3.i();
      var11.addEntity((Entity)(new EntitySmallFireball(var11, var5, var7, var9, var13, var15, var17)));
      var2.a(1);
      return var2;
   }

   protected void a(ISourceBlock var1) {
      var1.i().triggerEffect(1009, var1.d(), 0);
   }
}
