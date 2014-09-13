package net.minecraft.server;

public class apb extends apf {

   public apb(int var1, RegistryMaterials var2, int var3) {
      super(var1, var2, var3, EnchantmentSlotType.BOW);
      this.c("arrowKnockback");
   }

   public int a(int var1) {
      return 12 + (var1 - 1) * 20;
   }

   public int b(int var1) {
      return this.a(var1) + 25;
   }

   public int b() {
      return 2;
   }
}
