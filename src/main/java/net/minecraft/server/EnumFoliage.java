package net.minecraft.server;

public enum EnumFoliage implements IName {

   a("DEAD_BUSH", 0, 0, "dead_bush"),
   b("GRASS", 1, 1, "tall_grass"),
   c("FERN", 2, 2, "fern");
   private static final EnumFoliage[] d = new EnumFoliage[values().length];
   private final int e;
   private final String f;
   // $FF: synthetic field
   private static final EnumFoliage[] g = new EnumFoliage[]{a, b, c};


   private EnumFoliage(String var1, int var2, int var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

   public int a() {
      return this.e;
   }

   public String toString() {
      return this.f;
   }

   public static EnumFoliage a(int var0) {
      if(var0 < 0 || var0 >= d.length) {
         var0 = 0;
      }

      return d[var0];
   }

   public String getName() {
      return this.f;
   }

   static {
      EnumFoliage[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumFoliage var3 = var0[var2];
         d[var3.a()] = var3;
      }

   }
}
