package net.minecraft.server;

public class EnchantmentInfiniteArrows extends Enchantment {

   public EnchantmentInfiniteArrows(int var1, RegistryPrepender var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.BOW);
      this.c("arrowInfinite");
   }

   public int a(int var1) {
      return 20;
   }

   public int b(int var1) {
      return 50;
   }

   public int b() {
      return 1;
   }
}
