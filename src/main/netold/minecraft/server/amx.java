package net.minecraft.server;

public enum amx {

   a("COMMON", 0, aRenamed.p, "Common"),
   b("UNCOMMON", 1, aRenamed.o, "Uncommon"),
   c("RARE", 2, aRenamed.l, "Rare"),
   d("EPIC", 3, aRenamed.n, "Epic");
   public final aRenamed e;
   public final String f;
   // $FF: synthetic field
   private static final amx[] g = new amx[]{a, b, c, d};


   private amx(String var1, int var2, aRenamed var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

}
