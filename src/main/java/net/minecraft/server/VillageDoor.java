package net.minecraft.server;

public class VillageDoor {

   private final Location a;
   private final Location b;
   private final EnumFacing c;
   private int addedTime;
   private boolean removed;
   private int bookings;


   public VillageDoor(Location var1, int var2, int var3, int var4) {
      this(var1, a(var2, var3), var4);
   }

   private static EnumFacing a(int var0, int var1) {
      return var0 < 0?EnumFacing.WEST:(var0 > 0?EnumFacing.EAST:(var1 < 0?EnumFacing.NORTH:EnumFacing.SOUTH));
   }

   public VillageDoor(Location var1, EnumFacing var2, int var3) {
      this.a = var1;
      this.c = var2;
      this.b = var1.a(var2, 2);
      this.addedTime = var3;
   }

   public int b(int var1, int var2, int var3) {
      return (int)this.a.c((double)var1, (double)var2, (double)var3);
   }

   public int a(Location var1) {
      return (int)var1.i(this.d());
   }

   public int b(Location var1) {
      return (int)this.b.i(var1);
   }

   public boolean c(Location var1) {
      int var2 = var1.n() - this.a.n();
      int var3 = var1.p() - this.a.o();
      return var2 * this.c.g() + var3 * this.c.i() >= 0;
   }

   public void a() {
      this.bookings = 0;
   }

   public void b() {
      ++this.bookings;
   }

   public int c() {
      return this.bookings;
   }

   public Location d() {
      return this.a;
   }

   public Location e() {
      return this.b;
   }

   public int f() {
      return this.c.g() * 2;
   }

   public int g() {
      return this.c.i() * 2;
   }

   public int h() {
      return this.addedTime;
   }

   public void a(int var1) {
      this.addedTime = var1;
   }

   public boolean i() {
      return this.removed;
   }

   public void a(boolean var1) {
      this.removed = var1;
   }
}
