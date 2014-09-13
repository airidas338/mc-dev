package net.minecraft.server;


public class Location extends fd {

   public static final Location a = new Location(0, 0, 0);
   private static final int b = 1 + MathHelper.c(MathHelper.b(30000000));
   private static final int c = b;
   private static final int d = 64 - b - c;
   private static final int f = 0 + c;
   private static final int g = f + d;
   private static final long h = (1L << b) - 1L;
   private static final long i = (1L << d) - 1L;
   private static final long j = (1L << c) - 1L;


   public Location(int var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   public Location(double var1, double var3, double var5) {
      super(var1, var3, var5);
   }

   public Location(Entity var1) {
      this(var1.s, var1.t, var1.u);
   }

   public Location(Vec3D var1) {
      this(var1.a, var1.b, var1.c);
   }

   public Location(fd var1) {
      this(var1.n(), var1.o(), var1.p());
   }

   public Location a(double var1, double var3, double var5) {
      return new Location((double)this.n() + var1, (double)this.o() + var3, (double)this.p() + var5);
   }

   public Location a(int var1, int var2, int var3) {
      return new Location(this.n() + var1, this.o() + var2, this.p() + var3);
   }

   public Location a(fd var1) {
      return new Location(this.n() + var1.n(), this.o() + var1.o(), this.p() + var1.p());
   }

   public Location a(int var1) {
      return new Location(this.n() * var1, this.o() * var1, this.p() * var1);
   }

   public Location a() {
      return this.b(1);
   }

   public Location b(int var1) {
      return this.a(EnumFacing.UP, var1);
   }

   public Location b() {
      return this.c(1);
   }

   public Location c(int var1) {
      return this.a(EnumFacing.DOWN, var1);
   }

   public Location c() {
      return this.d(1);
   }

   public Location d(int var1) {
      return this.a(EnumFacing.NORTH, var1);
   }

   public Location d() {
      return this.e(1);
   }

   public Location e(int var1) {
      return this.a(EnumFacing.SOUTH, var1);
   }

   public Location e() {
      return this.f(1);
   }

   public Location f(int var1) {
      return this.a(EnumFacing.WEST, var1);
   }

   public Location f() {
      return this.g(1);
   }

   public Location g(int var1) {
      return this.a(EnumFacing.EAST, var1);
   }

   public Location a(EnumFacing var1) {
      return this.a(var1, 1);
   }

   public Location a(EnumFacing var1, int var2) {
      return new Location(this.n() + var1.g() * var2, this.o() + var1.h() * var2, this.p() + var1.i() * var2);
   }

   public Location c(fd var1) {
      return new Location(this.o() * var1.p() - this.p() * var1.o(), this.p() * var1.n() - this.n() * var1.p(), this.n() * var1.o() - this.o() * var1.n());
   }

   public long g() {
      return ((long)this.n() & h) << g | ((long)this.o() & i) << f | ((long)this.p() & j) << 0;
   }

   public static Location a(long var0) {
      int var2 = (int)(var0 << 64 - g - b >> 64 - b);
      int var3 = (int)(var0 << 64 - f - d >> 64 - d);
      int var4 = (int)(var0 << 64 - c >> 64 - c);
      return new Location(var2, var3, var4);
   }

   public static Iterable a(Location var0, Location var1) {
      Location var2 = new Location(Math.min(var0.n(), var1.n()), Math.min(var0.o(), var1.o()), Math.min(var0.p(), var1.p()));
      Location var3 = new Location(Math.max(var0.n(), var1.n()), Math.max(var0.o(), var1.o()), Math.max(var0.p(), var1.p()));
      return new du(var2, var3);
   }

   public static Iterable b(Location var0, Location var1) {
      Location var2 = new Location(Math.min(var0.n(), var1.n()), Math.min(var0.o(), var1.o()), Math.min(var0.p(), var1.p()));
      Location var3 = new Location(Math.max(var0.n(), var1.n()), Math.max(var0.o(), var1.o()), Math.max(var0.p(), var1.p()));
      return new dw(var2, var3);
   }

   // $FF: synthetic method
   public fd d(fd var1) {
      return this.c(var1);
   }

}
