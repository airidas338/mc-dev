package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Map;

public enum EnumHoverAction {

   SHOW_TEXT("SHOW_TEXT", 0, "show_text", true),
   SHOW_ACHIEVEMENT("SHOW_ACHIEVEMENT", 1, "show_achievement", true),
   SHOW_ITEM("SHOW_ITEM", 2, "show_item", true),
   SHOW_ENTITY("SHOW_ENTITY", 3, "show_entity", true);
   private static final Map e = Maps.newHashMap();
   private final boolean f;
   private final String g;
   // $FF: synthetic field
   private static final EnumHoverAction[] h = new EnumHoverAction[]{SHOW_TEXT, SHOW_ACHIEVEMENT, SHOW_ITEM, SHOW_ENTITY};


   private EnumHoverAction(String var1, int var2, String var3, boolean var4) {
      this.g = var3;
      this.f = var4;
   }

   public boolean a() {
      return this.f;
   }

   public String b() {
      return this.g;
   }

   public static EnumHoverAction a(String var0) {
      return (EnumHoverAction)e.get(var0);
   }

   static {
      EnumHoverAction[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumHoverAction var3 = var0[var2];
         e.put(var3.b(), var3);
      }

   }
}
