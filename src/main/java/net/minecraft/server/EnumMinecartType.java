package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Map;

public enum EnumMinecartType {

   RIDEABLE("RIDEABLE", 0, 0, "MinecartRideable"),
   CHEST("CHEST", 1, 1, "MinecartChest"),
   FURNACE("FURNACE", 2, 2, "MinecartFurnace"),
   TNT("TNT", 3, 3, "MinecartTNT"),
   SPAWNER("SPAWNER", 4, 4, "MinecartSpawner"),
   HOPPER("HOPPER", 5, 5, "MinecartHopper"),
   COMMAND_BLOCK("COMMAND_BLOCK", 6, 6, "MinecartCommandBlock");
   private static final Map h = Maps.newHashMap();
   private final int i;
   private final String j;
   // $FF: synthetic field
   private static final EnumMinecartType[] k = new EnumMinecartType[]{RIDEABLE, CHEST, FURNACE, TNT, SPAWNER, HOPPER, COMMAND_BLOCK};


   private EnumMinecartType(String var1, int var2, int var3, String var4) {
      this.i = var3;
      this.j = var4;
   }

   public int a() {
      return this.i;
   }

   public String b() {
      return this.j;
   }

   public static EnumMinecartType a(int var0) {
      EnumMinecartType var1 = (EnumMinecartType)h.get(Integer.valueOf(var0));
      return var1 == null?RIDEABLE:var1;
   }

   static {
      EnumMinecartType[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumMinecartType var3 = var0[var2];
         h.put(Integer.valueOf(var3.a()), var3);
      }

   }
}
