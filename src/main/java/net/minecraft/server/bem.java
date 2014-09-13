package net.minecraft.server;
import com.google.common.cache.LoadingCache;

public class bem {

   private final Location a;
   private final EnumFacing b;
   private final EnumFacing c;
   private final LoadingCache d;


   public bem(Location var1, EnumFacing var2, EnumFacing var3, LoadingCache var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public EnumFacing b() {
      return this.b;
   }

   public EnumFacing c() {
      return this.c;
   }

   public bei a(int var1, int var2, int var3) {
      return (bei)this.d.getUnchecked(bek.a(this.a, this.b(), this.c(), var1, var2, var3));
   }
}
