package net.minecraft.server;

import java.util.Random;

public class yx extends zb {

   private xu a;
   private double b;
   private double c;
   private double d;
   private double e;
   private World f;


   public yx(xu var1, double var2) {
      this.a = var1;
      this.e = var2;
      this.f = var1.o;
      this.a(1);
   }

   public boolean a() {
      if(!this.f.w()) {
         return false;
      } else if(!this.a.au()) {
         return false;
      } else if(!this.f.i(new dt(this.a.s, this.a.aQ().b, this.a.u))) {
         return false;
      } else {
         ChunkCoordinates var1 = this.f();
         if(var1 == null) {
            return false;
         } else {
            this.b = var1.a;
            this.c = var1.b;
            this.d = var1.c;
            return true;
         }
      }
   }

   public boolean b() {
      return !this.a.s().m();
   }

   public void c() {
      this.a.s().a(this.b, this.c, this.d, this.e);
   }

   private ChunkCoordinates f() {
      Random var1 = this.a.bb();
      dt var2 = new dt(this.a.s, this.a.aQ().b, this.a.u);

      for(int var3 = 0; var3 < 10; ++var3) {
         dt var4 = var2.a(var1.nextInt(20) - 10, var1.nextInt(6) - 3, var1.nextInt(20) - 10);
         if(!this.f.i(var4) && this.a.a(var4) < 0.0F) {
            return new ChunkCoordinates((double)var4.n(), (double)var4.o(), (double)var4.p());
         }
      }

      return null;
   }
}
