package net.minecraft.server;

public class EnchantmentLootBonus extends Enchantment {

   protected EnchantmentLootBonus(int var1, RegistryPrepender var2, int var3, EnchantmentSlotType var4) {
      super(var1, var2, var3, var4);
      if(var4 == EnchantmentSlotType.DIGGER) {
         this.c("lootBonusDigger");
      } else if(var4 == EnchantmentSlotType.FISHING_ROD) {
         this.c("lootBonusFishing");
      } else {
         this.c("lootBonus");
      }

   }

   public int a(int var1) {
      return 15 + (var1 - 1) * 9;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }

   public boolean a(Enchantment var1) {
      return super.a(var1) && var1.id != DURABILITY.id;
   }
}
