package net.minecraft.server;

public enum EnumArmorMaterial {

   CLOTH("LEATHER", 0, "leather", 5, new int[]{1, 3, 2, 1}, 15),
   CHAIN("CHAIN", 1, "chainmail", 15, new int[]{2, 5, 4, 1}, 12),
   IRON("IRON", 2, "iron", 15, new int[]{2, 6, 5, 2}, 9),
   GOLD("GOLD", 3, "gold", 7, new int[]{2, 5, 3, 1}, 25),
   DIAMOND("DIAMOND", 4, "diamond", 33, new int[]{3, 8, 6, 3}, 10);
   private final String f;
   private final int g;
   private final int[] h;
   private final int i;
   // $FF: synthetic field
   private static final EnumArmorMaterial[] j = new EnumArmorMaterial[]{CLOTH, CHAIN, IRON, GOLD, DIAMOND};


   private EnumArmorMaterial(String var1, int var2, String var3, int var4, int[] var5, int var6) {
      this.f = var3;
      this.g = var4;
      this.h = var5;
      this.i = var6;
   }

   public int a(int var1) {
      return ItemArmor.d()[var1] * this.g;
   }

   public int b(int var1) {
      return this.h[var1];
   }

   public int a() {
      return this.i;
   }

   public Item b() {
      return this == CLOTH?Items.aF:(this == CHAIN?Items.IRON_INGOT:(this == GOLD?Items.GOLD_INGOT:(this == IRON?Items.IRON_INGOT:(this == DIAMOND?Items.DIAMOND:null))));
   }

}
