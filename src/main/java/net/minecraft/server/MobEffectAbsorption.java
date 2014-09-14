package net.minecraft.server;



public class MobEffectAbsorption extends MobEffectList {

   protected MobEffectAbsorption(int var1, RegistryPrepender var2, boolean var3, int var4) {
      super(var1, var2, var3, var4);
   }

   public void a(EntityLiving var1, AttributeMapBase var2, int var3) {
      var1.l(var1.bM() - (float)(4 * (var3 + 1)));
      super.a(var1, var2, var3);
   }

   public void b(EntityLiving var1, AttributeMapBase var2, int var3) {
      var1.l(var1.bM() + (float)(4 * (var3 + 1)));
      super.b(var1, var2, var3);
   }
}
