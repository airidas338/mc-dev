package net.minecraft.server;

public class bge extends bgd {

   public void b() {
      this.c = new asc(BiomeBase.x, 0.0F);
      this.d = true;
      this.e = true;
      this.g = -1;
   }

   protected void a() {
      float var1 = 0.1F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   public bfe c() {
      return new bgr(this.b, this.b.P().s(), this.b.J());
   }

   public boolean d() {
      return false;
   }

   public boolean a(int var1, int var2) {
      return false;
   }

   public float a(long var1, float var3) {
      return 0.5F;
   }

   public boolean e() {
      return false;
   }

   public String k() {
      return "Nether";
   }

   public String l() {
      return "_nether";
   }

   public bfb r() {
      return new bgf(this);
   }
}
