package net.minecraft.server;

public class SourceBlock implements ISourceBlock {

   private final World a;
   private final Location b;


   public SourceBlock(World var1, Location var2) {
      this.a = var1;
      this.b = var2;
   }

   public World i() {
      return this.a;
   }

   public double getX() {
      return (double)this.b.n() + 0.5D;
   }

   public double getY() {
      return (double)this.b.o() + 0.5D;
   }

   public double getZ() {
      return (double)this.b.p() + 0.5D;
   }

   public Location d() {
      return this.b;
   }

   public Block e() {
      return this.a.getData(this.b).c();
   }

   public int f() {
      IBlockData var1 = this.a.getData(this.b);
      return var1.c().c(var1);
   }

   public TileEntity h() {
      return this.a.s(this.b);
   }
}
