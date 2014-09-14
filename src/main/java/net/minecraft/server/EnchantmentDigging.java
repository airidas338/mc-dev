package net.minecraft.server;

public class EnchantmentDigging extends Enchantment {

   protected EnchantmentDigging(int var1, RegistryPrepender var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.DIGGER);
      this.c("digging");
   }

   public int a(int var1) {
      return 1 + 10 * (var1 - 1);
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 5;
   }

   public boolean a(ItemStack var1) {
      return var1.b() == Items.be?true:super.a(var1);
   }
}
