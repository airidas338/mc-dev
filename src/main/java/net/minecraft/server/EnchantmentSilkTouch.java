package net.minecraft.server;

public class EnchantmentSilkTouch extends Enchantment {

   protected EnchantmentSilkTouch(int var1, RegistryPrepender var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.DIGGER);
      this.c("untouching");
   }

   public int a(int var1) {
      return 15;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 1;
   }

   public boolean a(Enchantment var1) {
      return super.a(var1) && var1.id != LOOT_BONUS_BLOCKS.id;
   }

   public boolean a(ItemStack var1) {
      return var1.getItem() == Items.be?true:super.a(var1);
   }
}
