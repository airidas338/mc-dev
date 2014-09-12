package net.minecraft.server;


public class bru {

   private dt e;
   public brv a;
   public ej b;
   public ChunkCoordinates c;
   public Entity d;


   public bru(ChunkCoordinates var1, ej var2, dt var3) {
      this(brv.b, var1, var2, var3);
   }

   public bru(ChunkCoordinates var1, ej var2) {
      this(brv.b, var1, var2, dt.a);
   }

   public bru(Entity var1) {
      this(var1, new ChunkCoordinates(var1.s, var1.t, var1.u));
   }

   public bru(brv var1, ChunkCoordinates var2, ej var3, dt var4) {
      this.a = var1;
      this.e = var4;
      this.b = var3;
      this.c = new ChunkCoordinates(var2.a, var2.b, var2.c);
   }

   public bru(Entity var1, ChunkCoordinates var2) {
      this.a = brv.c;
      this.d = var1;
      this.c = var2;
   }

   public dt a() {
      return this.e;
   }

   public String toString() {
      return "HitResult{type=" + this.a + ", blockpos=" + this.e + ", f=" + this.b + ", pos=" + this.c + ", entity=" + this.d + '}';
   }
}
