package net.minecraft.server;

public enum bbr implements IName {

   a("TOP", 0, "top"),
   b("BOTTOM", 1, "bottom");
   private final String c;
   // $FF: synthetic field
   private static final bbr[] d = new bbr[]{a, b};


   private bbr(String var1, int var2, String var3) {
      this.c = var3;
   }

   public String toString() {
      return this.c;
   }

   public String getName() {
      return this.c;
   }

}
