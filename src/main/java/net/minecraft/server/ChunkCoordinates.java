package net.minecraft.server;

public class ChunkCoordinates {

   public final double a;
   public final double b;
   public final double c;


   public ChunkCoordinates(double var1, double var3, double var5) {
      if(var1 == -0.0D) {
         var1 = 0.0D;
      }

      if(var3 == -0.0D) {
         var3 = 0.0D;
      }

      if(var5 == -0.0D) {
         var5 = 0.0D;
      }

      this.a = var1;
      this.b = var3;
      this.c = var5;
   }

   public ChunkCoordinates a() {
      double var1 = (double)MathHelper.a(this.a * this.a + this.b * this.b + this.c * this.c);
      return var1 < 1.0E-4D?new ChunkCoordinates(0.0D, 0.0D, 0.0D):new ChunkCoordinates(this.a / var1, this.b / var1, this.c / var1);
   }

   public double b(ChunkCoordinates var1) {
      return this.a * var1.a + this.b * var1.b + this.c * var1.c;
   }

   public ChunkCoordinates d(ChunkCoordinates var1) {
      return this.a(var1.a, var1.b, var1.c);
   }

   public ChunkCoordinates a(double var1, double var3, double var5) {
      return this.b(-var1, -var3, -var5);
   }

   public ChunkCoordinates e(ChunkCoordinates var1) {
      return this.b(var1.a, var1.b, var1.c);
   }

   public ChunkCoordinates b(double var1, double var3, double var5) {
      return new ChunkCoordinates(this.a + var1, this.b + var3, this.c + var5);
   }

   public double f(ChunkCoordinates var1) {
      double var2 = var1.a - this.a;
      double var4 = var1.b - this.b;
      double var6 = var1.c - this.c;
      return (double)MathHelper.a(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public double g(ChunkCoordinates var1) {
      double var2 = var1.a - this.a;
      double var4 = var1.b - this.b;
      double var6 = var1.c - this.c;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public double b() {
      return (double)MathHelper.a(this.a * this.a + this.b * this.b + this.c * this.c);
   }

   public ChunkCoordinates a(ChunkCoordinates var1, double var2) {
      double var4 = var1.a - this.a;
      double var6 = var1.b - this.b;
      double var8 = var1.c - this.c;
      if(var4 * var4 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.a) / var4;
         return var10 >= 0.0D && var10 <= 1.0D?new ChunkCoordinates(this.a + var4 * var10, this.b + var6 * var10, this.c + var8 * var10):null;
      }
   }

   public ChunkCoordinates b(ChunkCoordinates var1, double var2) {
      double var4 = var1.a - this.a;
      double var6 = var1.b - this.b;
      double var8 = var1.c - this.c;
      if(var6 * var6 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.b) / var6;
         return var10 >= 0.0D && var10 <= 1.0D?new ChunkCoordinates(this.a + var4 * var10, this.b + var6 * var10, this.c + var8 * var10):null;
      }
   }

   public ChunkCoordinates c(ChunkCoordinates var1, double var2) {
      double var4 = var1.a - this.a;
      double var6 = var1.b - this.b;
      double var8 = var1.c - this.c;
      if(var8 * var8 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (var2 - this.c) / var8;
         return var10 >= 0.0D && var10 <= 1.0D?new ChunkCoordinates(this.a + var4 * var10, this.b + var6 * var10, this.c + var8 * var10):null;
      }
   }

   public String toString() {
      return "(" + this.a + ", " + this.b + ", " + this.c + ")";
   }

   public ChunkCoordinates a(float var1) {
      float var2 = MathHelper.b(var1);
      float var3 = MathHelper.a(var1);
      double var4 = this.a;
      double var6 = this.b * (double)var2 + this.c * (double)var3;
      double var8 = this.c * (double)var2 - this.b * (double)var3;
      return new ChunkCoordinates(var4, var6, var8);
   }

   public ChunkCoordinates b(float var1) {
      float var2 = MathHelper.b(var1);
      float var3 = MathHelper.a(var1);
      double var4 = this.a * (double)var2 + this.c * (double)var3;
      double var6 = this.b;
      double var8 = this.c * (double)var2 - this.a * (double)var3;
      return new ChunkCoordinates(var4, var6, var8);
   }
}
