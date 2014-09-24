package net.minecraft.server;
import com.google.common.base.Objects;

public class bjb {

   public int a;
   public int b;
   public int c;
   public int d;
   public int e;
   public int f;


   public bjb() {}

   public bjb(int[] var1) {
      if(var1.length == 6) {
         this.a = var1[0];
         this.b = var1[1];
         this.c = var1[2];
         this.d = var1[3];
         this.e = var1[4];
         this.f = var1[5];
      }

   }

   public static bjb a() {
      return new bjb(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
   }

   public static bjb a(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, EnumFacing var9) {
      switch(bjc.a[var9.ordinal()]) {
      case 1:
         return new bjb(var0 + var3, var1 + var4, var2 - var8 + 1 + var5, var0 + var6 - 1 + var3, var1 + var7 - 1 + var4, var2 + var5);
      case 2:
         return new bjb(var0 + var3, var1 + var4, var2 + var5, var0 + var6 - 1 + var3, var1 + var7 - 1 + var4, var2 + var8 - 1 + var5);
      case 3:
         return new bjb(var0 - var8 + 1 + var5, var1 + var4, var2 + var3, var0 + var5, var1 + var7 - 1 + var4, var2 + var6 - 1 + var3);
      case 4:
         return new bjb(var0 + var5, var1 + var4, var2 + var3, var0 + var8 - 1 + var5, var1 + var7 - 1 + var4, var2 + var6 - 1 + var3);
      default:
         return new bjb(var0 + var3, var1 + var4, var2 + var5, var0 + var6 - 1 + var3, var1 + var7 - 1 + var4, var2 + var8 - 1 + var5);
      }
   }

   public static bjb a(int var0, int var1, int var2, int var3, int var4, int var5) {
      return new bjb(Math.min(var0, var3), Math.min(var1, var4), Math.min(var2, var5), Math.max(var0, var3), Math.max(var1, var4), Math.max(var2, var5));
   }

   public bjb(bjb var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
   }

   public bjb(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public bjb(ChunkCoordinates var1, ChunkCoordinates var2) {
      this.a = Math.min(var1.n(), var2.n());
      this.b = Math.min(var1.o(), var2.o());
      this.c = Math.min(var1.p(), var2.p());
      this.d = Math.max(var1.n(), var2.n());
      this.e = Math.max(var1.o(), var2.o());
      this.f = Math.max(var1.p(), var2.p());
   }

   public bjb(int var1, int var2, int var3, int var4) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
      this.f = var4;
      this.b = 1;
      this.e = 512;
   }

   public boolean a(bjb var1) {
      return this.d >= var1.a && this.a <= var1.d && this.f >= var1.c && this.c <= var1.f && this.e >= var1.b && this.b <= var1.e;
   }

   public boolean a(int var1, int var2, int var3, int var4) {
      return this.d >= var1 && this.a <= var3 && this.f >= var2 && this.c <= var4;
   }

   public void b(bjb var1) {
      this.a = Math.min(this.a, var1.a);
      this.b = Math.min(this.b, var1.b);
      this.c = Math.min(this.c, var1.c);
      this.d = Math.max(this.d, var1.d);
      this.e = Math.max(this.e, var1.e);
      this.f = Math.max(this.f, var1.f);
   }

   public void a(int var1, int var2, int var3) {
      this.a += var1;
      this.b += var2;
      this.c += var3;
      this.d += var1;
      this.e += var2;
      this.f += var3;
   }

   public boolean b(ChunkCoordinates var1) {
      return var1.n() >= this.a && var1.n() <= this.d && var1.p() >= this.c && var1.p() <= this.f && var1.o() >= this.b && var1.o() <= this.e;
   }

   public ChunkCoordinates b() {
      return new ChunkCoordinates(this.d - this.a, this.e - this.b, this.f - this.c);
   }

   public int c() {
      return this.d - this.a + 1;
   }

   public int d() {
      return this.e - this.b + 1;
   }

   public int e() {
      return this.f - this.c + 1;
   }

   public ChunkCoordinates f() {
      return new Location(this.a + (this.d - this.a + 1) / 2, this.b + (this.e - this.b + 1) / 2, this.c + (this.f - this.c + 1) / 2);
   }

   public String toString() {
      return Objects.toStringHelper(this).add("x0", this.a).add("y0", this.b).add("z0", this.c).add("x1", this.d).add("y1", this.e).add("z1", this.f).toString();
   }

   public NBTTagIntArray g() {
      return new NBTTagIntArray(new int[]{this.a, this.b, this.c, this.d, this.e, this.f});
   }
}
