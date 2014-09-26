package net.minecraft.server;

public enum EnumItemRarity {

   COMMON("COMMON", 0, EnumChatFormat.WHITE, "Common"),
   UNCOMMON("UNCOMMON", 1, EnumChatFormat.YELLOW, "Uncommon"),
   RARE("RARE", 2, EnumChatFormat.AQUA, "Rare"),
   EPIC("EPIC", 3, EnumChatFormat.LIGHT_PURPLE, "Epic");
   public final EnumChatFormat e;
   public final String f;
   // $FF: synthetic field
   private static final EnumItemRarity[] g = new EnumItemRarity[]{COMMON, UNCOMMON, RARE, EPIC};


   private EnumItemRarity(String var1, int var2, EnumChatFormat var3, String var4) {
      this.e = var3;
      this.f = var4;
   }

}
