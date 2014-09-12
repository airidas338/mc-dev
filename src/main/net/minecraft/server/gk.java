package net.minecraft.server;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import java.util.regex.Pattern;

class gk extends gh {

   private static final Pattern c = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[d|D]");
   private static final Pattern d = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[f|F]");
   private static final Pattern e = Pattern.compile("[-+]?[0-9]+[b|B]");
   private static final Pattern f = Pattern.compile("[-+]?[0-9]+[l|L]");
   private static final Pattern g = Pattern.compile("[-+]?[0-9]+[s|S]");
   private static final Pattern h = Pattern.compile("[-+]?[0-9]+");
   private static final Pattern i = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
   private static final Splitter j = Splitter.on(',').omitEmptyStrings();
   protected String b;


   public gk(String var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public gd a() {
      try {
         if(c.matcher(this.b).matches()) {
            return new fq(Double.parseDouble(this.b.substring(0, this.b.length() - 1)));
         }

         if(d.matcher(this.b).matches()) {
            return new fs(Float.parseFloat(this.b.substring(0, this.b.length() - 1)));
         }

         if(e.matcher(this.b).matches()) {
            return new fm(Byte.parseByte(this.b.substring(0, this.b.length() - 1)));
         }

         if(f.matcher(this.b).matches()) {
            return new fw(Long.parseLong(this.b.substring(0, this.b.length() - 1)));
         }

         if(g.matcher(this.b).matches()) {
            return new gb(Short.parseShort(this.b.substring(0, this.b.length() - 1)));
         }

         if(h.matcher(this.b).matches()) {
            return new fu(Integer.parseInt(this.b));
         }

         if(i.matcher(this.b).matches()) {
            return new fq(Double.parseDouble(this.b));
         }

         if(this.b.equalsIgnoreCase("true") || this.b.equalsIgnoreCase("false")) {
            return new fm((byte)(Boolean.parseBoolean(this.b)?1:0));
         }
      } catch (NumberFormatException var6) {
         this.b = this.b.replaceAll("\\\\\"", "\"");
         return new gc(this.b);
      }

      if(this.b.startsWith("[") && this.b.endsWith("]")) {
         String var7 = this.b.substring(1, this.b.length() - 1);
         String[] var8 = (String[])Iterables.toArray(j.split(var7), String.class);

         try {
            int[] var3 = new int[var8.length];

            for(int var4 = 0; var4 < var8.length; ++var4) {
               var3[var4] = Integer.parseInt(var8[var4].trim());
            }

            return new ft(var3);
         } catch (NumberFormatException var5) {
            return new gc(this.b);
         }
      } else {
         if(this.b.startsWith("\"") && this.b.endsWith("\"")) {
            this.b = this.b.substring(1, this.b.length() - 1);
         }

         this.b = this.b.replaceAll("\\\\\"", "\"");
         StringBuilder var1 = new StringBuilder();

         for(int var2 = 0; var2 < this.b.length(); ++var2) {
            if(var2 < this.b.length() - 1 && this.b.charAt(var2) == 92 && this.b.charAt(var2 + 1) == 92) {
               var1.append('\\');
               ++var2;
            } else {
               var1.append(this.b.charAt(var2));
            }
         }

         return new gc(var1.toString());
      }
   }

}
