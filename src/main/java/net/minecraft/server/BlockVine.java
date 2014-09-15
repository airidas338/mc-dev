package net.minecraft.server;
import java.util.Iterator;
import java.util.Random;

public class BlockVine extends Block {

   public static final bet a = bet.a("up");
   public static final bet b = bet.a("north");
   public static final bet M = bet.a("east");
   public static final bet N = bet.a("south");
   public static final bet O = bet.a("west");
   public static final bet[] P = new bet[]{a, b, N, O, M};
   public static final int Q = b(EnumFacing.SOUTH);
   public static final int R = b(EnumFacing.NORTH);
   public static final int S = b(EnumFacing.EAST);
   public static final int T = b(EnumFacing.WEST);


   public BlockVine() {
      super(Material.REPLACAEBLE_PLAN);
      this.j(this.L.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)));
      this.a(true);
      this.a(CreativeModeTab.c);
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      return var1.a(a, Boolean.valueOf(var2.getData(var3.a()).c().s()));
   }

   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean f(World var1, Location var2) {
      return true;
   }

   public void a(IBlockAccess var1, Location var2) {
      float var3 = 0.0625F;
      float var4 = 1.0F;
      float var5 = 1.0F;
      float var6 = 1.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;
      float var9 = 0.0F;
      boolean var10 = false;
      if(((Boolean)var1.getData(var2).b(O)).booleanValue()) {
         var7 = Math.max(var7, 0.0625F);
         var4 = 0.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
         var10 = true;
      }

      if(((Boolean)var1.getData(var2).b(M)).booleanValue()) {
         var4 = Math.min(var4, 0.9375F);
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
         var10 = true;
      }

      if(((Boolean)var1.getData(var2).b(b)).booleanValue()) {
         var9 = Math.max(var9, 0.0625F);
         var6 = 0.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var10 = true;
      }

      if(((Boolean)var1.getData(var2).b(N)).booleanValue()) {
         var6 = Math.min(var6, 0.9375F);
         var9 = 1.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var10 = true;
      }

      if(!var10 && this.c(var1.getData(var2.a()).c())) {
         var5 = Math.min(var5, 0.9375F);
         var8 = 1.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
      }

      this.a(var4, var5, var6, var7, var8, var9);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      return null;
   }

   public boolean canPlace(World var1, Location var2, EnumFacing var3) {
      switch(bbw.a[var3.ordinal()]) {
      case 1:
         return this.c(var1.getData(var2.a()).c());
      case 2:
      case 3:
      case 4:
      case 5:
         return this.c(var1.getData(var2.a(var3.d())).c());
      default:
         return false;
      }
   }

   private boolean c(Block var1) {
      return var1.d() && var1.J.isSolid();
   }

   private boolean e(World var1, Location var2, IBlockData var3) {
      IBlockData var4 = var3;
      Iterator var5 = en.a.iterator();

      while(var5.hasNext()) {
         EnumFacing var6 = (EnumFacing)var5.next();
         bet var7 = a(var6);
         if(((Boolean)var3.b(var7)).booleanValue() && !this.c(var1.getData(var2.a(var6)).c())) {
            IBlockData var8 = var1.getData(var2.a());
            if(var8.c() != this || !((Boolean)var8.b(var7)).booleanValue()) {
               var3 = var3.a(var7, Boolean.valueOf(false));
            }
         }
      }

      if(d(var3) == 0) {
         return false;
      } else {
         if(var4 != var3) {
            var1.a(var2, var3, 2);
         }

         return true;
      }
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      if(!var1.isStatic && !this.e(var1, var2, var3)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(!var1.isStatic) {
         if(var1.random.nextInt(4) == 0) {
            byte var5 = 4;
            int var6 = 5;
            boolean var7 = false;

            label189:
            for(int var8 = -var5; var8 <= var5; ++var8) {
               for(int var9 = -var5; var9 <= var5; ++var9) {
                  for(int var10 = -1; var10 <= 1; ++var10) {
                     if(var1.getData(var2.a(var8, var10, var9)).c() == this) {
                        --var6;
                        if(var6 <= 0) {
                           var7 = true;
                           break label189;
                        }
                     }
                  }
               }
            }

            EnumFacing var17 = EnumFacing.a(var4);
            EnumFacing var21;
            if(var17 == EnumFacing.UP && var2.o() < 255 && var1.isEmpty(var2.a())) {
               if(!var7) {
                  IBlockData var22 = var3;
                  Iterator var20 = en.a.iterator();

                  while(var20.hasNext()) {
                     var21 = (EnumFacing)var20.next();
                     if(var4.nextBoolean() || !this.c(var1.getData(var2.a(var21).a()).c())) {
                        var22 = var22.a(a(var21), Boolean.valueOf(false));
                     }
                  }

                  if(((Boolean)var22.b(b)).booleanValue() || ((Boolean)var22.b(M)).booleanValue() || ((Boolean)var22.b(N)).booleanValue() || ((Boolean)var22.b(O)).booleanValue()) {
                     var1.a(var2.a(), var22, 2);
                  }

               }
            } else {
               Location var18;
               if(var17.k().c() && !((Boolean)var3.b(a(var17))).booleanValue()) {
                  if(!var7) {
                     var18 = var2.a(var17);
                     Block var19 = var1.getData(var18).c();
                     if(var19.J == Material.AIR) {
                        var21 = var17.e();
                        EnumFacing var25 = var17.f();
                        boolean var24 = ((Boolean)var3.b(a(var21))).booleanValue();
                        boolean var27 = ((Boolean)var3.b(a(var25))).booleanValue();
                        Location var26 = var18.a(var21);
                        Location var16 = var18.a(var25);
                        if(var24 && this.c(var1.getData(var26).c())) {
                           var1.a(var18, this.P().a(a(var21), Boolean.valueOf(true)), 2);
                        } else if(var27 && this.c(var1.getData(var16).c())) {
                           var1.a(var18, this.P().a(a(var25), Boolean.valueOf(true)), 2);
                        } else if(var24 && var1.isEmpty(var26) && this.c(var1.getData(var2.a(var21)).c())) {
                           var1.a(var26, this.P().a(a(var17.d()), Boolean.valueOf(true)), 2);
                        } else if(var27 && var1.isEmpty(var16) && this.c(var1.getData(var2.a(var25)).c())) {
                           var1.a(var16, this.P().a(a(var17.d()), Boolean.valueOf(true)), 2);
                        } else if(this.c(var1.getData(var18.a()).c())) {
                           var1.a(var18, this.P(), 2);
                        }
                     } else if(var19.J.k() && var19.d()) {
                        var1.a(var2, var3.a(a(var17), Boolean.valueOf(true)), 2);
                     }

                  }
               } else {
                  if(var2.o() > 1) {
                     var18 = var2.b();
                     IBlockData var23 = var1.getData(var18);
                     Block var11 = var23.c();
                     IBlockData var12;
                     Iterator var13;
                     EnumFacing var14;
                     if(var11.J == Material.AIR) {
                        var12 = var3;
                        var13 = en.a.iterator();

                        while(var13.hasNext()) {
                           var14 = (EnumFacing)var13.next();
                           if(var4.nextBoolean()) {
                              var12 = var12.a(a(var14), Boolean.valueOf(false));
                           }
                        }

                        if(((Boolean)var12.b(b)).booleanValue() || ((Boolean)var12.b(M)).booleanValue() || ((Boolean)var12.b(N)).booleanValue() || ((Boolean)var12.b(O)).booleanValue()) {
                           var1.a(var18, var12, 2);
                        }
                     } else if(var11 == this) {
                        var12 = var23;
                        var13 = en.a.iterator();

                        while(var13.hasNext()) {
                           var14 = (EnumFacing)var13.next();
                           bet var15 = a(var14);
                           if(var4.nextBoolean() || !((Boolean)var3.b(var15)).booleanValue()) {
                              var12 = var12.a(var15, Boolean.valueOf(false));
                           }
                        }

                        if(((Boolean)var12.b(b)).booleanValue() || ((Boolean)var12.b(M)).booleanValue() || ((Boolean)var12.b(N)).booleanValue() || ((Boolean)var12.b(O)).booleanValue()) {
                           var1.a(var18, var12, 2);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   private static int b(EnumFacing var0) {
      return 1 << var0.b();
   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlockData var9 = this.P().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false));
      return var3.k().c()?var9.a(a(var3.d()), Boolean.valueOf(true)):var9;
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(World var1, EntityHuman var2, Location var3, IBlockData var4, TileEntity var5) {
      if(!var1.isStatic && var2.bY() != null && var2.bY().b() == Items.be) {
         var2.b(StatisticList.H[Block.getId((Block)this)]);
         a(var1, var3, new ItemStack(Blocks.VINE, 1, 0));
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }

   public IBlockData a(int var1) {
      return this.P().a(b, Boolean.valueOf((var1 & R) > 0)).a(M, Boolean.valueOf((var1 & S) > 0)).a(N, Boolean.valueOf((var1 & Q) > 0)).a(O, Boolean.valueOf((var1 & T) > 0));
   }

   public int c(IBlockData var1) {
      int var2 = 0;
      if(((Boolean)var1.b(b)).booleanValue()) {
         var2 |= R;
      }

      if(((Boolean)var1.b(M)).booleanValue()) {
         var2 |= S;
      }

      if(((Boolean)var1.b(N)).booleanValue()) {
         var2 |= Q;
      }

      if(((Boolean)var1.b(O)).booleanValue()) {
         var2 |= T;
      }

      return var2;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b, M, N, O});
   }

   public static bet a(EnumFacing var0) {
      switch(bbw.a[var0.ordinal()]) {
      case 1:
         return a;
      case 2:
         return b;
      case 3:
         return N;
      case 4:
         return M;
      case 5:
         return O;
      default:
         throw new IllegalArgumentException(var0 + " is an invalid choice");
      }
   }

   public static int d(IBlockData var0) {
      int var1 = 0;
      bet[] var2 = P;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         bet var5 = var2[var4];
         if(((Boolean)var0.b(var5)).booleanValue()) {
            ++var1;
         }
      }

      return var1;
   }

}
