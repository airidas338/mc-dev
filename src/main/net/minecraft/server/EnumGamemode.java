package net.minecraft.server;

public enum EnumGamemode {

   NOT_SET("NOT_SET", 0, -1, ""),
   SURVIVAL("SURVIVAL", 1, 0, "survival"),
   CREATIVE("CREATIVE", 2, 1, "creative"),
   ADVENTURE("ADVENTURE", 3, 2, "adventure"),
   SPECTATOR("SPECTATOR", 4, 3, "spectator");
   int f;
   String g;
   // $FF: synthetic field
   private static final EnumGamemode[] h = new EnumGamemode[]{NOT_SET, SURVIVAL, CREATIVE, ADVENTURE, SPECTATOR};


   private EnumGamemode(String var1, int var2, int var3, String var4) {
      this.f = var3;
      this.g = var4;
   }

   public int a() {
      return this.f;
   }

   public String b() {
      return this.g;
   }

   public void a(aha var1) {
      if(this == CREATIVE) {
         var1.c = true;
         var1.d = true;
         var1.a = true;
      } else if(this == SPECTATOR) {
         var1.c = true;
         var1.d = false;
         var1.a = true;
         var1.b = true;
      } else {
         var1.c = false;
         var1.d = false;
         var1.a = false;
         var1.b = false;
      }

      var1.e = !this.c();
   }

   public boolean c() {
      return this == ADVENTURE || this == SPECTATOR;
   }

   public boolean d() {
      return this == CREATIVE;
   }

   public boolean e() {
      return this == SURVIVAL || this == ADVENTURE;
   }

   public static EnumGamemode a(int var0) {
      EnumGamemode[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         EnumGamemode var4 = var1[var3];
         if(var4.f == var0) {
            return var4;
         }
      }

      return SURVIVAL;
   }

}
