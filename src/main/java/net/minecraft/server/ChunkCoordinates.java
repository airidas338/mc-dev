package net.minecraft.server;
import com.google.common.base.Objects;

public class ChunkCoordinates implements Comparable {

   public static final ChunkCoordinates e = new ChunkCoordinates(0, 0, 0);
   private final int a;
   private final int b;
   private final int c;


   public ChunkCoordinates(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public ChunkCoordinates(double var1, double var3, double var5) {
      this(MathHelper.floor(var1), MathHelper.floor(var3), MathHelper.floor(var5));
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ChunkCoordinates)) {
         return false;
      } else {
         ChunkCoordinates var2 = (ChunkCoordinates)var1;
         return this.n() != var2.n()?false:(this.o() != var2.o()?false:this.p() == var2.p());
      }
   }

   public int hashCode() {
      return (this.o() + this.p() * 31) * 31 + this.n();
   }

   public int g(ChunkCoordinates var1) {
      return this.o() == var1.o()?(this.p() == var1.p()?this.n() - var1.n():this.p() - var1.p()):this.o() - var1.o();
   }

   public int n() {
      return this.a;
   }

   public int o() {
      return this.b;
   }

   public int p() {
      return this.c;
   }

   public ChunkCoordinates d(ChunkCoordinates var1) {
      return new ChunkCoordinates(this.o() * var1.p() - this.p() * var1.o(), this.p() * var1.n() - this.n() * var1.p(), this.n() * var1.o() - this.o() * var1.n());
   }

   public double c(double var1, double var3, double var5) {
      double var7 = (double)this.n() - var1;
      double var9 = (double)this.o() - var3;
      double var11 = (double)this.p() - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double d(double var1, double var3, double var5) {
      double var7 = (double)this.n() + 0.5D - var1;
      double var9 = (double)this.o() + 0.5D - var3;
      double var11 = (double)this.p() + 0.5D - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double i(ChunkCoordinates var1) {
      return this.c((double)var1.n(), (double)var1.o(), (double)var1.p());
   }

   public String toString() {
      return Objects.toStringHelper(this).add("x", this.n()).add("y", this.o()).add("z", this.p()).toString();
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.g((ChunkCoordinates)var1);
   }

}
