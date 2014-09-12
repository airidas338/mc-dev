package net.minecraft.server;

public class jb {

   private final short b;
   private final IBlock c;
   // $FF: synthetic field
   final ja a;


   public jb(ja var1, short var2, IBlock var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public jb(ja var1, short var2, bfh var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3.g(this.a());
   }

   public Location a() {
      return new Location(ja.a(this.a).a(this.b >> 12 & 15, this.b & 255, this.b >> 8 & 15));
   }

   public short b() {
      return this.b;
   }

   public IBlock c() {
      return this.c;
   }
}
