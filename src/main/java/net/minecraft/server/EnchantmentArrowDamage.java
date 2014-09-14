package net.minecraft.server;

public class EnchantmentArrowDamage extends Enchantment {

   public EnchantmentArrowDamage(int var1, RegistryPrepender var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.BOW);
      this.c("arrowDamage");
   }

   public int a(int var1) {
      return 1 + (var1 - 1) * 10;
   }

   public int b(int var1) {
      return this.a(var1) + 15;
   }

   public int b() {
      return 5;
   }
}
