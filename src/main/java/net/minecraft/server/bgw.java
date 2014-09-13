package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bgw implements IChunkProvider {

   private Random h;
   private bnv i;
   private bnv j;
   private bnv k;
   public bnv a;
   public bnv b;
   private World l;
   private double[] m;
   private BiomeBase[] n;
   double[] c;
   double[] d;
   double[] e;
   double[] f;
   double[] g;


   public bgw(World var1, long var2) {
      this.l = var1;
      this.h = new Random(var2);
      this.i = new bnv(this.h, 16);
      this.j = new bnv(this.h, 16);
      this.k = new bnv(this.h, 8);
      this.a = new bnv(this.h, 10);
      this.b = new bnv(this.h, 16);
   }

   public void a(int var1, int var2, bgk var3) {
      byte var4 = 2;
      int var5 = var4 + 1;
      byte var6 = 33;
      int var7 = var4 + 1;
      this.m = this.a(this.m, var1 * var4, 0, var2 * var4, var5, var6, var7);

      for(int var8 = 0; var8 < var4; ++var8) {
         for(int var9 = 0; var9 < var4; ++var9) {
            for(int var10 = 0; var10 < 32; ++var10) {
               double var11 = 0.25D;
               double var13 = this.m[((var8 + 0) * var7 + var9 + 0) * var6 + var10 + 0];
               double var15 = this.m[((var8 + 0) * var7 + var9 + 1) * var6 + var10 + 0];
               double var17 = this.m[((var8 + 1) * var7 + var9 + 0) * var6 + var10 + 0];
               double var19 = this.m[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 0];
               double var21 = (this.m[((var8 + 0) * var7 + var9 + 0) * var6 + var10 + 1] - var13) * var11;
               double var23 = (this.m[((var8 + 0) * var7 + var9 + 1) * var6 + var10 + 1] - var15) * var11;
               double var25 = (this.m[((var8 + 1) * var7 + var9 + 0) * var6 + var10 + 1] - var17) * var11;
               double var27 = (this.m[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 1] - var19) * var11;

               for(int var29 = 0; var29 < 4; ++var29) {
                  double var30 = 0.125D;
                  double var32 = var13;
                  double var34 = var15;
                  double var36 = (var17 - var13) * var30;
                  double var38 = (var19 - var15) * var30;

                  for(int var40 = 0; var40 < 8; ++var40) {
                     double var41 = 0.125D;
                     double var43 = var32;
                     double var45 = (var34 - var32) * var41;

                     for(int var47 = 0; var47 < 8; ++var47) {
                        IBlock var48 = null;
                        if(var43 > 0.0D) {
                           var48 = Blocks.WHITESTONE.P();
                        }

                        int var49 = var40 + var8 * 8;
                        int var50 = var29 + var10 * 4;
                        int var51 = var47 + var9 * 8;
                        var3.a(var49, var50, var51, var48);
                        var43 += var45;
                     }

                     var32 += var36;
                     var34 += var38;
                  }

                  var13 += var21;
                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
               }
            }
         }
      }

   }

   public void a(bgk var1) {
      for(int var2 = 0; var2 < 16; ++var2) {
         for(int var3 = 0; var3 < 16; ++var3) {
            byte var4 = 1;
            int var5 = -1;
            IBlock var6 = Blocks.WHITESTONE.P();
            IBlock var7 = Blocks.WHITESTONE.P();

            for(int var8 = 127; var8 >= 0; --var8) {
               IBlock var9 = var1.a(var2, var8, var3);
               if(var9.c().r() == Material.AIR) {
                  var5 = -1;
               } else if(var9.c() == Blocks.STONE) {
                  if(var5 == -1) {
                     if(var4 <= 0) {
                        var6 = Blocks.AIR.P();
                        var7 = Blocks.WHITESTONE.P();
                     }

                     var5 = var4;
                     if(var8 >= 0) {
                        var1.a(var2, var8, var3, var6);
                     } else {
                        var1.a(var2, var8, var3, var7);
                     }
                  } else if(var5 > 0) {
                     --var5;
                     var1.a(var2, var8, var3, var7);
                  }
               }
            }
         }
      }

   }

   public Chunk getOrCreateChunk(int var1, int var2) {
      this.h.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      bgk var3 = new bgk();
      this.n = this.l.v().b(this.n, var1 * 16, var2 * 16, 16, 16);
      this.a(var1, var2, var3);
      this.a(var3);
      Chunk var4 = new Chunk(this.l, var3, var1, var2);
      byte[] var5 = var4.k();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.n[var6].az;
      }

      var4.b();
      return var4;
   }

   private double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      this.f = this.a.a(this.f, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
      this.g = this.b.a(this.g, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
      var8 *= 2.0D;
      this.c = this.k.a(this.c, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.d = this.i.a(this.d, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      this.e = this.j.a(this.e, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      int var12 = 0;

      for(int var13 = 0; var13 < var5; ++var13) {
         for(int var14 = 0; var14 < var7; ++var14) {
            float var15 = (float)(var13 + var2) / 1.0F;
            float var16 = (float)(var14 + var4) / 1.0F;
            float var17 = 100.0F - MathHelper.c(var15 * var15 + var16 * var16) * 8.0F;
            if(var17 > 80.0F) {
               var17 = 80.0F;
            }

            if(var17 < -100.0F) {
               var17 = -100.0F;
            }

            for(int var18 = 0; var18 < var6; ++var18) {
               double var19 = 0.0D;
               double var21 = this.d[var12] / 512.0D;
               double var23 = this.e[var12] / 512.0D;
               double var25 = (this.c[var12] / 10.0D + 1.0D) / 2.0D;
               if(var25 < 0.0D) {
                  var19 = var21;
               } else if(var25 > 1.0D) {
                  var19 = var23;
               } else {
                  var19 = var21 + (var23 - var21) * var25;
               }

               var19 -= 8.0D;
               var19 += (double)var17;
               byte var27 = 2;
               double var28;
               if(var18 > var6 / 2 - var27) {
                  var28 = (double)((float)(var18 - (var6 / 2 - var27)) / 64.0F);
                  var28 = MathHelper.a(var28, 0.0D, 1.0D);
                  var19 = var19 * (1.0D - var28) + -3000.0D * var28;
               }

               var27 = 8;
               if(var18 < var27) {
                  var28 = (double)((float)(var27 - var18) / ((float)var27 - 1.0F));
                  var19 = var19 * (1.0D - var28) + -30.0D * var28;
               }

               var1[var12] = var19;
               ++var12;
            }
         }
      }

      return var1;
   }

   public boolean isChunkLoaded(int var1, int var2) {
      return true;
   }

   public void a(IChunkProvider var1, int var2, int var3) {
      avt.M = true;
      Location var4 = new Location(var2 * 16, 0, var3 * 16);
      this.l.b(var4.a(16, 0, 16)).a(this.l, this.l.s, var4);
      avt.M = false;
   }

   public boolean a(IChunkProvider var1, Chunk var2, int var3, int var4) {
      return false;
   }

   public boolean a(boolean var1, IProgressUpdate var2) {
      return true;
   }

   public void c() {}

   public boolean d() {
      return false;
   }

   public boolean e() {
      return true;
   }

   public String f() {
      return "RandomLevelSource";
   }

   public List a(EnumCreatureType var1, Location var2) {
      return this.l.b(var2).a(var1);
   }

   public Location a(World var1, String var2, Location var3) {
      return null;
   }

   public int g() {
      return 0;
   }

   public void a(Chunk var1, int var2, int var3) {}

   public Chunk a(Location var1) {
      return this.getOrCreateChunk(var1.n() >> 4, var1.p() >> 4);
   }
}
