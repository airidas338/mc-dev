package net.minecraft.server;

public class bos extends GenLayer {

   private BiomeBase[] c;
   private BiomeBase[] d;
   private BiomeBase[] e;
   private BiomeBase[] f;
   private final bgl g;


   public bos(long var1, GenLayer var3, WorldType var4, String var5) {
      super(var1);
      this.c = new BiomeBase[]{BiomeBase.DESERT, BiomeBase.DESERT, BiomeBase.DESERT, BiomeBase.SAVANNA, BiomeBase.SAVANNA, BiomeBase.PLAINS};
      this.d = new BiomeBase[]{BiomeBase.FOREST, BiomeBase.ROOFED_FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.PLAINS, BiomeBase.BIRCH_FOREST, BiomeBase.SWAMPLAND};
      this.e = new BiomeBase[]{BiomeBase.FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.TAIGA, BiomeBase.PLAINS};
      this.f = new BiomeBase[]{BiomeBase.ICE_PLAINS, BiomeBase.ICE_PLAINS, BiomeBase.ICE_PLAINS, BiomeBase.COLD_TAIGA};
      this.a = var3;
      if(var4 == WorldType.NORMAL_1_1) {
         this.c = new BiomeBase[]{BiomeBase.DESERT, BiomeBase.FOREST, BiomeBase.EXTREME_HILLS, BiomeBase.SWAMPLAND, BiomeBase.PLAINS, BiomeBase.TAIGA};
         this.g = null;
      } else if(var4 == WorldType.CUSTOMIZED) {
         this.g = bgn.a(var5).b();
      } else {
         this.g = null;
      }

   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1, var2, var3, var4);
      int[] var6 = boy.a(var3 * var4);

      for(int var7 = 0; var7 < var4; ++var7) {
         for(int var8 = 0; var8 < var3; ++var8) {
            this.a((long)(var8 + var1), (long)(var7 + var2));
            int var9 = var5[var8 + var7 * var3];
            int var10 = (var9 & 3840) >> 8;
            var9 &= -3841;
            if(this.g != null && this.g.F >= 0) {
               var6[var8 + var7 * var3] = this.g.F;
            } else if(b(var9)) {
               var6[var8 + var7 * var3] = var9;
            } else if(var9 == BiomeBase.MUSHROOM_ISLAND.id) {
               var6[var8 + var7 * var3] = var9;
            } else if(var9 == 1) {
               if(var10 > 0) {
                  if(this.a(3) == 0) {
                     var6[var8 + var7 * var3] = BiomeBase.MESA_PLATEAU.id;
                  } else {
                     var6[var8 + var7 * var3] = BiomeBase.MESA_PLATEAU_F.id;
                  }
               } else {
                  var6[var8 + var7 * var3] = this.c[this.a(this.c.length)].id;
               }
            } else if(var9 == 2) {
               if(var10 > 0) {
                  var6[var8 + var7 * var3] = BiomeBase.JUNGLE.id;
               } else {
                  var6[var8 + var7 * var3] = this.d[this.a(this.d.length)].id;
               }
            } else if(var9 == 3) {
               if(var10 > 0) {
                  var6[var8 + var7 * var3] = BiomeBase.MEGA_TAIGA.id;
               } else {
                  var6[var8 + var7 * var3] = this.e[this.a(this.e.length)].id;
               }
            } else if(var9 == 4) {
               var6[var8 + var7 * var3] = this.f[this.a(this.f.length)].id;
            } else {
               var6[var8 + var7 * var3] = BiomeBase.MUSHROOM_ISLAND.id;
            }
         }
      }

      return var6;
   }
}
