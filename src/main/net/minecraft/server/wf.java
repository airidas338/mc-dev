package net.minecraft.server;


public class wf {

   private final DamageSource a;
   private final int b;
   private final float c;
   private final float d;
   private final String e;
   private final float f;


   public wf(DamageSource var1, int var2, float var3, float var4, String var5, float var6) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var3;
      this.e = var5;
      this.f = var6;
   }

   public DamageSource a() {
      return this.a;
   }

   public float c() {
      return this.c;
   }

   public boolean f() {
      return this.a.getEntity() instanceof EntityLiving;
   }

   public String g() {
      return this.e;
   }

   public IChatBaseComponent h() {
      return this.a().getEntity() == null?null:this.a().getEntity().e_();
   }

   public float i() {
      return this.a == DamageSource.j?Float.MAX_VALUE:this.f;
   }
}
