package net.minecraft.server;
import java.util.Random;

public abstract class BlockLeaves extends BlockTransparent {

   public static final bet a = bet.a("decayable");
   public static final bet b = bet.a("check_decay");
   int[] M;


   public BlockLeaves() {
      super(Material.LEAVES, false);
      this.a(true);
      this.a(CreativeModeTab.c);
      this.c(0.2F);
      this.e(1);
      this.a(h);
   }

   public void remove(World var1, Location var2, IBlockData var3) {
      byte var4 = 1;
      int var5 = var4 + 1;
      int var6 = var2.n();
      int var7 = var2.o();
      int var8 = var2.p();
      if(var1.a(new Location(var6 - var5, var7 - var5, var8 - var5), new Location(var6 + var5, var7 + var5, var8 + var5))) {
         for(int var9 = -var4; var9 <= var4; ++var9) {
            for(int var10 = -var4; var10 <= var4; ++var10) {
               for(int var11 = -var4; var11 <= var4; ++var11) {
                  Location var12 = var2.a(var9, var10, var11);
                  IBlockData var13 = var1.getData(var12);
                  if(var13.c().getMaterial() == Material.LEAVES && !((Boolean)var13.b(b)).booleanValue()) {
                     var1.setTypeAndData(var12, var13.a(b, Boolean.valueOf(true)), 4);
                  }
               }
            }
         }
      }

   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(!var1.isStatic) {
         if(((Boolean)var3.b(b)).booleanValue() && ((Boolean)var3.b(a)).booleanValue()) {
            byte var5 = 4;
            int var6 = var5 + 1;
            int var7 = var2.n();
            int var8 = var2.o();
            int var9 = var2.p();
            byte var10 = 32;
            int var11 = var10 * var10;
            int var12 = var10 / 2;
            if(this.M == null) {
               this.M = new int[var10 * var10 * var10];
            }

            int var13;
            if(var1.a(new Location(var7 - var6, var8 - var6, var9 - var6), new Location(var7 + var6, var8 + var6, var9 + var6))) {
               int var14;
               int var15;
               for(var13 = -var5; var13 <= var5; ++var13) {
                  for(var14 = -var5; var14 <= var5; ++var14) {
                     for(var15 = -var5; var15 <= var5; ++var15) {
                        Block var16 = var1.getData(new Location(var7 + var13, var8 + var14, var9 + var15)).c();
                        if(var16 != Blocks.LOG && var16 != Blocks.LOG2) {
                           if(var16.getMaterial() == Material.LEAVES) {
                              this.M[(var13 + var12) * var11 + (var14 + var12) * var10 + var15 + var12] = -2;
                           } else {
                              this.M[(var13 + var12) * var11 + (var14 + var12) * var10 + var15 + var12] = -1;
                           }
                        } else {
                           this.M[(var13 + var12) * var11 + (var14 + var12) * var10 + var15 + var12] = 0;
                        }
                     }
                  }
               }

               for(var13 = 1; var13 <= 4; ++var13) {
                  for(var14 = -var5; var14 <= var5; ++var14) {
                     for(var15 = -var5; var15 <= var5; ++var15) {
                        for(int var17 = -var5; var17 <= var5; ++var17) {
                           if(this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + var17 + var12] == var13 - 1) {
                              if(this.M[(var14 + var12 - 1) * var11 + (var15 + var12) * var10 + var17 + var12] == -2) {
                                 this.M[(var14 + var12 - 1) * var11 + (var15 + var12) * var10 + var17 + var12] = var13;
                              }

                              if(this.M[(var14 + var12 + 1) * var11 + (var15 + var12) * var10 + var17 + var12] == -2) {
                                 this.M[(var14 + var12 + 1) * var11 + (var15 + var12) * var10 + var17 + var12] = var13;
                              }

                              if(this.M[(var14 + var12) * var11 + (var15 + var12 - 1) * var10 + var17 + var12] == -2) {
                                 this.M[(var14 + var12) * var11 + (var15 + var12 - 1) * var10 + var17 + var12] = var13;
                              }

                              if(this.M[(var14 + var12) * var11 + (var15 + var12 + 1) * var10 + var17 + var12] == -2) {
                                 this.M[(var14 + var12) * var11 + (var15 + var12 + 1) * var10 + var17 + var12] = var13;
                              }

                              if(this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + (var17 + var12 - 1)] == -2) {
                                 this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + (var17 + var12 - 1)] = var13;
                              }

                              if(this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + var17 + var12 + 1] == -2) {
                                 this.M[(var14 + var12) * var11 + (var15 + var12) * var10 + var17 + var12 + 1] = var13;
                              }
                           }
                        }
                     }
                  }
               }
            }

            var13 = this.M[var12 * var11 + var12 * var10 + var12];
            if(var13 >= 0) {
               var1.setTypeAndData(var2, var3.a(b, Boolean.valueOf(false)), 4);
            } else {
               this.d(var1, var2);
            }
         }

      }
   }

   private void d(World var1, Location var2) {
      this.b(var1, var2, var1.getData(var2), 0);
      var1.setAir(var2);
   }

   public int a(Random var1) {
      return var1.nextInt(20) == 0?1:0;
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf(Blocks.SAPLING);
   }

   public void dropNaturally(World var1, Location var2, IBlockData var3, float var4, int var5) {
      if(!var1.isStatic) {
         int var6 = this.d(var3);
         if(var5 > 0) {
            var6 -= 2 << var5;
            if(var6 < 10) {
               var6 = 10;
            }
         }

         if(var1.random.nextInt(var6) == 0) {
            Item var7 = this.a(var3, var1.random, var5);
            a(var1, var2, new ItemStack(var7, 1, this.getDropData(var3)));
         }

         var6 = 200;
         if(var5 > 0) {
            var6 -= 10 << var5;
            if(var6 < 40) {
               var6 = 40;
            }
         }

         this.a(var1, var2, var3, var6);
      }

   }

   protected void a(World var1, Location var2, IBlockData var3, int var4) {}

   protected int d(IBlockData var1) {
      return 20;
   }

   public boolean c() {
      return !this.Q;
   }

   public boolean u() {
      return false;
   }

   public abstract ayx b(int var1);

}
