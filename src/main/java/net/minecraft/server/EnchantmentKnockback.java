package net.minecraft.server;

public class EnchantmentKnockback extends Enchantment {

   protected EnchantmentKnockback(int var1, RegistryPrepender var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.WEAPON);
      this.c("knockback");
   }

   public int a(int var1) {
      return 5 + 20 * (var1 - 1);
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 2;
   }
}
