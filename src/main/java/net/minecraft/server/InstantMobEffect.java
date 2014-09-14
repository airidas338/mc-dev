package net.minecraft.server;



public class InstantMobEffect extends MobEffectList {

   public InstantMobEffect(int var1, RegistryPrepender var2, boolean var3, int var4) {
      super(var1, var2, var3, var4);
   }

   public boolean b() {
      return true;
   }

   public boolean a(int var1, int var2) {
      return var1 >= 1;
   }
}
