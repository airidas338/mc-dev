package net.minecraft.server;


public abstract class DispenserBehaviorProjectile extends DispenserBehaviorItem {

   public ItemStack b(ISourceBlock var1, ItemStack var2) {
      World var3 = var1.i();
      IPosition var4 = BlockDispenser.a(var1);
      EnumFacing var5 = BlockDispenser.b(var1.f());
      IProjectile var6 = this.a(var3, var4);
      var6.shoot((double)var5.g(), (double)((float)var5.h() + 0.1F), (double)var5.i(), this.b(), this.a());
      var3.addEntity((Entity)var6);
      var2.a(1);
      return var2;
   }

   protected void a(ISourceBlock var1) {
      var1.i().triggerEffect(1002, var1.d(), 0);
   }

   protected abstract IProjectile a(World var1, IPosition var2);

   protected float a() {
      return 6.0F;
   }

   protected float b() {
      return 1.1F;
   }
}
