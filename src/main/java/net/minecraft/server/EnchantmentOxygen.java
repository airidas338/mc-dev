package net.minecraft.server;

public class EnchantmentOxygen extends Enchantment {

   public EnchantmentOxygen(int var1, RegistryPrepender var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.ARMOR_HEAD);
      this.c("oxygen");
   }

   public int a(int var1) {
      return 10 * var1;
   }

   public int b(int var1) {
      return this.a(var1) + 30;
   }

   public int b() {
      return 3;
   }
}
