package net.minecraft.server;


public class alh extends ItemFood {

   private final boolean b;


   public alh(boolean var1) {
      super(0, 0.0F, false);
      this.b = var1;
   }

   public int h(ItemStack var1) {
      ali var2 = ali.a(var1);
      return this.b && var2.g()?var2.e():var2.c();
   }

   public float i(ItemStack var1) {
      ali var2 = ali.a(var1);
      return this.b && var2.g()?var2.f():var2.d();
   }

   public String j(ItemStack var1) {
      return ali.a(var1) == ali.d?PotionBrewer.m:null;
   }

   protected void c(ItemStack var1, World var2, EntityHuman var3) {
      ali var4 = ali.a(var1);
      if(var4 == ali.d) {
         var3.c(new MobEffect(MobEffectList.u.H, 1200, 3));
         var3.c(new MobEffect(MobEffectList.s.H, 300, 2));
         var3.c(new MobEffect(MobEffectList.k.H, 300, 1));
      }

      super.c(var1, var2, var3);
   }

   public String e_(ItemStack var1) {
      ali var2 = ali.a(var1);
      return this.a() + "." + var2.b() + "." + (this.b && var2.g()?"cooked":"raw");
   }
}
