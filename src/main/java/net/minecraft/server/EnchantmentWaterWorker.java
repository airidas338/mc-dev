package net.minecraft.server;

public class EnchantmentWaterWorker extends Enchantment {

   public EnchantmentWaterWorker(int var1, RegistryPrepender var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.ARMOR_HEAD);
      this.c("waterWorker");
   }

   public int a(int var1) {
      return 1;
   }

   public int b(int var1) {
      return this.a(var1) + 40;
   }

   public int b() {
      return 1;
   }
}
