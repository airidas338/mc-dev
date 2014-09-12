package net.minecraft.server;

public enum EnumDifficulty {

   a("PEACEFUL", 0, 0, "options.difficulty.peaceful"),
   b("EASY", 1, 1, "options.difficulty.easy"),
   c("NORMAL", 2, 2, "options.difficulty.normal"),
   d("HARD", 3, 3, "options.difficulty.hard");
   private static final EnumDifficulty[] e = new EnumDifficulty[values().length];
   private final int f;
   private final String g;
   // $FF: synthetic field
   private static final EnumDifficulty[] h = new EnumDifficulty[]{a, b, c, d};


   private EnumDifficulty(String var1, int var2, int var3, String var4) {
      this.f = var3;
      this.g = var4;
   }

   public int a() {
      return this.f;
   }

   public static EnumDifficulty a(int var0) {
      return e[var0 % e.length];
   }

   public String b() {
      return this.g;
   }

   static {
      EnumDifficulty[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumDifficulty var3 = var0[var2];
         e[var3.f] = var3;
      }

   }
}
