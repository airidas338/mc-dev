package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public enum EnumChatFormat {

   BLACK("BLACK", 0, "BLACK", '0', 0),
   DARK_BLUE("DARK_BLUE", 1, "DARK_BLUE", '1', 1),
   DARK_GREEN("DARK_GREEN", 2, "DARK_GREEN", '2', 2),
   DARK_AQUA("DARK_AQUA", 3, "DARK_AQUA", '3', 3),
   DARK_RED("DARK_RED", 4, "DARK_RED", '4', 4),
   DARK_PURPLE("DARK_PURPLE", 5, "DARK_PURPLE", '5', 5),
   GOLD("GOLD", 6, "GOLD", '6', 6),
   GRAY("GRAY", 7, "GRAY", '7', 7),
   DARK_GRAY("DARK_GRAY", 8, "DARK_GRAY", '8', 8),
   BLUE("BLUE", 9, "BLUE", '9', 9),
   GREEN("GREEN", 10, "GREEN", 'a', 10),
   AQUA("AQUA", 11, "AQUA", 'b', 11),
   RED("RED", 12, "RED", 'c', 12),
   LIGHT_PURPLE("LIGHT_PURPLE", 13, "LIGHT_PURPLE", 'd', 13),
   YELLOW("YELLOW", 14, "YELLOW", 'e', 14),
   WHITE("WHITE", 15, "WHITE", 'f', 15),
   OBFUSCATED("OBFUSCATED", 16, "OBFUSCATED", 'k', true),
   BOLD("BOLD", 17, "BOLD", 'l', true),
   STRIKETHROUGH("STRIKETHROUGH", 18, "STRIKETHROUGH", 'm', true),
   UNDERLINE("UNDERLINE", 19, "UNDERLINE", 'n', true),
   ITALIC("ITALIC", 20, "ITALIC", 'o', true),
   RESET("RESET", 21, "RESET", 'r', -1);
   private static final Map w = Maps.newHashMap();
   private static final Pattern x = Pattern.compile("(?i)" + String.valueOf('\u00a7') + "[0-9A-FK-OR]");
   private final String y;
   private final char z;
   private final boolean A;
   private final String B;
   private final int C;
   // $FF: synthetic field
   private static final EnumChatFormat[] D = new EnumChatFormat[]{BLACK, DARK_BLUE, DARK_GREEN, DARK_AQUA, DARK_RED, DARK_PURPLE, GOLD, GRAY, DARK_GRAY, BLUE, GREEN, AQUA, RED, LIGHT_PURPLE, YELLOW, WHITE, OBFUSCATED, BOLD, STRIKETHROUGH, UNDERLINE, ITALIC, RESET};


   private static String c(String var0) {
      return var0.toLowerCase().replaceAll("[^a-z]", "");
   }

   private EnumChatFormat(String var1, int var2, String var3, char var4, int var5) {
      this(var1, var2, var3, var4, false, var5);
   }

   private EnumChatFormat(String var1, int var2, String var3, char var4, boolean var5) {
      this(var1, var2, var3, var4, var5, -1);
   }

   private EnumChatFormat(String var1, int var2, String var3, char var4, boolean var5, int var6) {
      this.y = var3;
      this.z = var4;
      this.A = var5;
      this.C = var6;
      this.B = "§" + var4;
   }

   public int b() {
      return this.C;
   }

   public boolean c() {
      return this.A;
   }

   public boolean d() {
      return !this.A && this != RESET;
   }

   public String e() {
      return this.name().toLowerCase();
   }

   public String toString() {
      return this.B;
   }

   public static EnumChatFormat b(String var0) {
      return var0 == null?null:(EnumChatFormat)w.get(c(var0));
   }

   public static EnumChatFormat a(int var0) {
      if(var0 < 0) {
         return RESET;
      } else {
         EnumChatFormat[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            EnumChatFormat var4 = var1[var3];
            if(var4.b() == var0) {
               return var4;
            }
         }

         return null;
      }
   }

   public static Collection a(boolean var0, boolean var1) {
      ArrayList var2 = Lists.newArrayList();
      EnumChatFormat[] var3 = values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumChatFormat var6 = var3[var5];
         if((!var6.d() || var0) && (!var6.c() || var1)) {
            var2.add(var6.e());
         }
      }

      return var2;
   }

   static {
      EnumChatFormat[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         EnumChatFormat var3 = var0[var2];
         w.put(c(var3.y), var3);
      }

   }
}
