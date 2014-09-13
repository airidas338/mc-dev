package net.minecraft.server;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;

public class bet extends bes {

   private final ImmutableSet a = ImmutableSet.of(Boolean.valueOf(true), Boolean.valueOf(false));


   protected bet(String var1) {
      super(var1, Boolean.class);
   }

   public Collection c() {
      return this.a;
   }

   public static bet a(String var0) {
      return new bet(var0);
   }

   public String a(Comparable var1) {
      return var1.toString();
   }
}
