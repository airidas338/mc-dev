package net.minecraft.server;


public class MovingObjectPosition {

   private Location e;
   public brv a;
   public ej b;
   public ChunkCoordinates c;
   public Entity d;


   public MovingObjectPosition(ChunkCoordinates var1, ej var2, Location var3) {
      this(brv.b, var1, var2, var3);
   }

   public MovingObjectPosition(ChunkCoordinates var1, ej var2) {
      this(brv.b, var1, var2, Location.a);
   }

   public MovingObjectPosition(Entity var1) {
      this(var1, new ChunkCoordinates(var1.s, var1.t, var1.u));
   }

   public MovingObjectPosition(brv var1, ChunkCoordinates var2, ej var3, Location var4) {
      this.a = var1;
      this.e = var4;
      this.b = var3;
      this.c = new ChunkCoordinates(var2.a, var2.b, var2.c);
   }

   public MovingObjectPosition(Entity var1, ChunkCoordinates var2) {
      this.a = brv.c;
      this.d = var1;
      this.c = var2;
   }

   public Location a() {
      return this.e;
   }

   public String toString() {
      return "HitResult{type=" + this.a + ", blockpos=" + this.e + ", f=" + this.b + ", pos=" + this.c + ", entity=" + this.d + '}';
   }
}
