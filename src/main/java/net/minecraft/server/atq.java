package net.minecraft.server;

public enum atq implements IName {

   a("HEAD", 0, "head"),
   b("FOOT", 1, "foot");
   private final String c;
   // $FF: synthetic field
   private static final atq[] d = new atq[]{a, b};


   private atq(String var1, int var2, String var3) {
      this.c = var3;
   }

   public String toString() {
      return this.c;
   }

   public String getName() {
      return this.c;
   }

}
