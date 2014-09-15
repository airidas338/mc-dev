package net.minecraft.server;

public class jb {

   private final short b;
   private final IBlockData c;
   // $FF: synthetic field
   final PacketPlayOutMultiBlockChange a;


   public jb(PacketPlayOutMultiBlockChange var1, short var2, IBlockData var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public jb(PacketPlayOutMultiBlockChange var1, short var2, Chunk var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3.g(this.a());
   }

   public Location a() {
      return new Location(PacketPlayOutMultiBlockChange.a(this.a).a(this.b >> 12 & 15, this.b & 255, this.b >> 8 & 15));
   }

   public short b() {
      return this.b;
   }

   public IBlockData c() {
      return this.c;
   }
}
