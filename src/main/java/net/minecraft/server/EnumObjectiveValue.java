package net.minecraft.server;
import com.google.common.collect.Maps;
import java.util.Map;

public enum EnumObjectiveValue {

   INTEGER("INTEGER", 0, "integer"),
   HEARTS("HEARTS", 1, "hearts");
   private static final Map c = Maps.newHashMap();
   private final String d;
   // $FF: synthetic field
   private static final EnumObjectiveValue[] e = new EnumObjectiveValue[]{INTEGER, HEARTS};


   private EnumObjectiveValue(String var1, int var2, String var3) {
      this.d = var3;
   }

   public String a() {
      return this.d;
   }

   public static EnumObjectiveValue a(String var0) {
      EnumObjectiveValue var1 = (EnumObjectiveValue)c.get(var0);
      return var1 == null?INTEGER:var1;
   }

   static {
      EnumObjectiveValue[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumObjectiveValue var3 = var0[var2];
         c.put(var3.a(), var3);
      }

   }
}
