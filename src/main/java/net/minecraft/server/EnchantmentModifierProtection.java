package net.minecraft.server;

final class EnchantmentModifierProtection implements apl {

   public int a;
   public DamageSource b;


   private EnchantmentModifierProtection() {}

   public void a(Enchantment var1, int var2) {
      this.a += var1.a(var2, this.b);
   }

   // $FF: synthetic method
   EnchantmentModifierProtection(EmptyClass var1) {
      this();
   }
}
