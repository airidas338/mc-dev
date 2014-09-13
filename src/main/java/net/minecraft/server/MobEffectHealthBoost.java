package net.minecraft.server;



public class MobEffectHealthBoost extends MobEffectList {

   public MobEffectHealthBoost(int var1, RegistryMaterials var2, boolean var3, int var4) {
      super(var1, var2, var3, var4);
   }

   public void a(EntityLiving var1, AttributeMapBase var2, int var3) {
      super.a(var1, var2, var3);
      if(var1.bm() > var1.bt()) {
         var1.h(var1.bt());
      }

   }
}
