package net.minecraft.server;


final class EnchantmentModifierDamage implements apl {

   public float a;
   public xs b;


   private EnchantmentModifierDamage() {}

   public void a(Enchantment var1, int var2) {
      this.a += var1.a(var2, this.b);
   }

   // $FF: synthetic method
   EnchantmentModifierDamage(EmptyClass var1) {
      this();
   }
}
