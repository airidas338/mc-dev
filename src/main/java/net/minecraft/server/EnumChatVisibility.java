package net.minecraft.server;

public enum EnumChatVisibility {

   FULL("FULL", 0, 0, "options.chat.visibility.full"),
   SYSTEM("SYSTEM", 1, 1, "options.chat.visibility.system"),
   HIDDEN("HIDDEN", 2, 2, "options.chat.visibility.hidden");
   private static final EnumChatVisibility[] d = new EnumChatVisibility[values().length];
   private final int e;
   private final String f;
   // $FF: synthetic field
   private static final EnumChatVisibility[] g = new EnumChatVisibility[]{FULL, SYSTEM, HIDDEN};


   private EnumChatVisibility(String var1, int var2, int var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

   public int a() {
      return this.e;
   }

   public static EnumChatVisibility a(int var0) {
      return d[var0 % d.length];
   }

   static {
      EnumChatVisibility[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumChatVisibility var3 = var0[var2];
         d[var3.e] = var3;
      }

   }
}
