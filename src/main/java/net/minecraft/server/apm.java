package net.minecraft.server;


final class apm implements apl {

   public float a;
   public xs b;


   private apm() {}

   public void a(Enchantment var1, int var2) {
      this.a += var1.a(var2, this.b);
   }

   // $FF: synthetic method
   apm(api var1) {
      this();
   }
}
