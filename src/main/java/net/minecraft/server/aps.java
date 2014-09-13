package net.minecraft.server;

public class aps extends apf {

   protected aps(int var1, RegistryMaterials var2, int var3, EnchantmentSlotType var4) {
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

   public boolean a(apf var1) {
      return super.a(var1) && var1.B != s.B;
   }
}
