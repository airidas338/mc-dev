package net.minecraft.server;

enum azu implements IName {

   a("UP", 0, "up"),
   b("SIDE", 1, "side"),
   c("NONE", 2, "none");
   private final String d;
   // $FF: synthetic field
   private static final azu[] e = new azu[]{a, b, c};


   private azu(String var1, int var2, String var3) {
      this.d = var3;
   }

   public String toString() {
      return this.getName();
   }

   public String getName() {
      return this.d;
   }

}
