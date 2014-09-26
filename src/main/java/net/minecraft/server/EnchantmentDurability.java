package net.minecraft.server;
import java.util.Random;

public class EnchantmentDurability extends Enchantment {

   protected EnchantmentDurability(int var1, RegistryPrepender var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.BREAKABLE);
      this.c("durability");
   }

   public int a(int var1) {
      return 5 + (var1 - 1) * 8;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }

   public boolean a(ItemStack var1) {
      return var1.e()?true:super.a(var1);
   }

   public static boolean a(ItemStack var0, int var1, Random var2) {
      return var0.getItem() instanceof ItemArmor && var2.nextFloat() < 0.6F?false:var2.nextInt(var1 + 1) > 0;
   }
}
