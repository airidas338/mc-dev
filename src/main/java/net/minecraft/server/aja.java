package net.minecraft.server;

class aja extends ajk {

   // $FF: synthetic field
   final EntityHorse a;
   // $FF: synthetic field
   final aiy b;


   aja(aiy var1, vq var2, int var3, int var4, int var5, EntityHorse var6) {
      super(var2, var3, var4, var5);
      this.b = var1;
      this.a = var6;
   }

   public boolean a(amj var1) {
      return super.a(var1) && this.a.cM() && EntityHorse.a(var1.b());
   }
}
