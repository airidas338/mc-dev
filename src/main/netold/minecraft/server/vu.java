package net.minecraft.server;

public class vu {

   private final vt a;
   private final float b;


   public vu(vt var1, long var2, long var4, float var6) {
      this.a = var1;
      this.b = this.a(var1, var2, var4, var6);
   }

   public float c() {
      return this.b < 2.0F?0.0F:(this.b > 4.0F?1.0F:(this.b - 2.0F) / 2.0F);
   }

   private float a(vt var1, long var2, long var4, float var6) {
      if(var1 == vt.a) {
         return 0.0F;
      } else {
         boolean var7 = var1 == vt.d;
         float var8 = 0.75F;
         float var9 = uv.a(((float)var2 + -72000.0F) / 1440000.0F, 0.0F, 1.0F) * 0.25F;
         var8 += var9;
         float var10 = 0.0F;
         var10 += uv.a((float)var4 / 3600000.0F, 0.0F, 1.0F) * (var7?1.0F:0.75F);
         var10 += uv.a(var6 * 0.25F, 0.0F, var9);
         if(var1 == vt.b) {
            var10 *= 0.5F;
         }

         var8 += var10;
         return (float)var1.a() * var8;
      }
   }
}
