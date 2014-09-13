package net.minecraft.server;

public enum axk implements IName {

   a("DOWN_X", 0, 0, "down_x", EnumFacing.DOWN),
   b("EAST", 1, 1, "east", EnumFacing.EAST),
   c("WEST", 2, 2, "west", EnumFacing.WEST),
   d("SOUTH", 3, 3, "south", EnumFacing.SOUTH),
   e("NORTH", 4, 4, "north", EnumFacing.NORTH),
   f("UP_Z", 5, 5, "up_z", EnumFacing.UP),
   g("UP_X", 6, 6, "up_x", EnumFacing.UP),
   h("DOWN_Z", 7, 7, "down_z", EnumFacing.DOWN);
   private static final axk[] i = new axk[values().length];
   private final int j;
   private final String k;
   private final EnumFacing l;
   // $FF: synthetic field
   private static final axk[] m = new axk[]{a, b, c, d, e, f, g, h};


   private axk(String var1, int var2, int var3, String var4, EnumFacing var5) {
      this.j = var3;
      this.k = var4;
      this.l = var5;
   }

   public int a() {
      return this.j;
   }

   public EnumFacing c() {
      return this.l;
   }

   public String toString() {
      return this.k;
   }

   public static axk a(int var0) {
      if(var0 < 0 || var0 >= i.length) {
         var0 = 0;
      }

      return i[var0];
   }

   public static axk a(EnumFacing var0, EnumFacing var1) {
      switch(axj.a[var0.ordinal()]) {
      case 1:
         switch(axj.c[var1.k().ordinal()]) {
         case 1:
            return a;
         case 2:
            return h;
         default:
            throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
         }
      case 2:
         switch(axj.c[var1.k().ordinal()]) {
         case 1:
            return g;
         case 2:
            return f;
         default:
            throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
         }
      case 3:
         return e;
      case 4:
         return d;
      case 5:
         return c;
      case 6:
         return b;
      default:
         throw new IllegalArgumentException("Invalid facing: " + var0);
      }
   }

   public String getName() {
      return this.k;
   }

   static {
      axk[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         axk var3 = var0[var2];
         i[var3.a()] = var3;
      }

   }
}
