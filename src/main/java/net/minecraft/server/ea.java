package net.minecraft.server;

public class ea implements dz {

   private final World a;
   private final Location b;


   public ea(World var1, Location var2) {
      this.a = var1;
      this.b = var2;
   }

   public World i() {
      return this.a;
   }

   public double a() {
      return (double)this.b.n() + 0.5D;
   }

   public double b() {
      return (double)this.b.o() + 0.5D;
   }

   public double c() {
      return (double)this.b.p() + 0.5D;
   }

   public Location d() {
      return this.b;
   }

   public Block e() {
      return this.a.p(this.b).c();
   }

   public int f() {
      IBlock var1 = this.a.p(this.b);
      return var1.c().c(var1);
   }

   public bcm h() {
      return this.a.s(this.b);
   }
}
