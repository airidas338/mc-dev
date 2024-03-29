package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bjg extends bms {

   private boolean a;
   private boolean b;
   private boolean c;
   private int d;


   public bjg() {}

   protected void a(NBTTagCompound var1) {
      var1.setBoolean("hr", this.a);
      var1.setBoolean("sc", this.b);
      var1.setBoolean("hps", this.c);
      var1.setInt("Num", this.d);
   }

   protected void b(NBTTagCompound var1) {
      this.a = var1.getBoolean("hr");
      this.b = var1.getBoolean("sc");
      this.c = var1.getBoolean("hps");
      this.d = var1.getInt("Num");
   }

   public bjg(int var1, Random var2, bjb var3, EnumFacing var4) {
      super(var1);
      this.m = var4;
      this.l = var3;
      this.a = var2.nextInt(3) == 0;
      this.b = !this.a && var2.nextInt(23) == 0;
      if(this.m != EnumFacing.NORTH && this.m != EnumFacing.SOUTH) {
         this.d = var3.c() / 5;
      } else {
         this.d = var3.e() / 5;
      }

   }

   public static bjb a(List var0, Random var1, int var2, int var3, int var4, EnumFacing var5) {
      bjb var6 = new bjb(var2, var3, var4, var2, var3 + 2, var4);

      int var7;
      for(var7 = var1.nextInt(3) + 2; var7 > 0; --var7) {
         int var8 = var7 * 5;
         switch(bjf.a[var5.ordinal()]) {
         case 1:
            var6.d = var2 + 2;
            var6.c = var4 - (var8 - 1);
            break;
         case 2:
            var6.d = var2 + 2;
            var6.f = var4 + (var8 - 1);
            break;
         case 3:
            var6.a = var2 - (var8 - 1);
            var6.f = var4 + 2;
            break;
         case 4:
            var6.d = var2 + (var8 - 1);
            var6.f = var4 + 2;
         }

         if(bms.a(var0, var6) == null) {
            break;
         }
      }

      return var7 > 0?var6:null;
   }

   public void a(bms var1, List var2, Random var3) {
      int var4 = this.d();
      int var5 = var3.nextInt(4);
      if(this.m != null) {
         switch(bjf.a[this.m.ordinal()]) {
         case 1:
            if(var5 <= 1) {
               bje.a(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, this.m, var4);
            } else if(var5 == 2) {
               bje.a(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.c, EnumFacing.WEST, var4);
            } else {
               bje.a(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.c, EnumFacing.EAST, var4);
            }
            break;
         case 2:
            if(var5 <= 1) {
               bje.a(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, this.m, var4);
            } else if(var5 == 2) {
               bje.a(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.f - 3, EnumFacing.WEST, var4);
            } else {
               bje.a(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.f - 3, EnumFacing.EAST, var4);
            }
            break;
         case 3:
            if(var5 <= 1) {
               bje.a(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.c, this.m, var4);
            } else if(var5 == 2) {
               bje.a(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, EnumFacing.NORTH, var4);
            } else {
               bje.a(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, EnumFacing.SOUTH, var4);
            }
            break;
         case 4:
            if(var5 <= 1) {
               bje.a(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.c, this.m, var4);
            } else if(var5 == 2) {
               bje.a(var1, var2, var3, this.l.d - 3, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, EnumFacing.NORTH, var4);
            } else {
               bje.a(var1, var2, var3, this.l.d - 3, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, EnumFacing.SOUTH, var4);
            }
         }
      }

      if(var4 < 8) {
         int var6;
         int var7;
         if(this.m != EnumFacing.NORTH && this.m != EnumFacing.SOUTH) {
            for(var6 = this.l.a + 3; var6 + 3 <= this.l.d; var6 += 5) {
               var7 = var3.nextInt(5);
               if(var7 == 0) {
                  bje.a(var1, var2, var3, var6, this.l.b, this.l.c - 1, EnumFacing.NORTH, var4 + 1);
               } else if(var7 == 1) {
                  bje.a(var1, var2, var3, var6, this.l.b, this.l.f + 1, EnumFacing.SOUTH, var4 + 1);
               }
            }
         } else {
            for(var6 = this.l.c + 3; var6 + 3 <= this.l.f; var6 += 5) {
               var7 = var3.nextInt(5);
               if(var7 == 0) {
                  bje.a(var1, var2, var3, this.l.a - 1, this.l.b, var6, EnumFacing.WEST, var4 + 1);
               } else if(var7 == 1) {
                  bje.a(var1, var2, var3, this.l.d + 1, this.l.b, var6, EnumFacing.EAST, var4 + 1);
               }
            }
         }
      }

   }

   protected boolean a(World var1, bjb var2, Random var3, int var4, int var5, int var6, List var7, int var8) {
      Location var9 = new Location(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if(var2.b((ChunkCoordinates)var9) && var1.getData(var9).c().getMaterial() == Material.AIR) {
         int var10 = var3.nextBoolean()?1:0;
         var1.setTypeAndData(var9, Blocks.RAILS.a(this.a(Blocks.RAILS, var10)), 2);
         EntityMinecartChest var11 = new EntityMinecartChest(var1, (double)((float)var9.n() + 0.5F), (double)((float)var9.o() + 0.5F), (double)((float)var9.p() + 0.5F));
         StructurePieceTreaasure.a(var3, var7, (IInventory)var11, var8);
         var1.addEntity((Entity)var11);
         return true;
      } else {
         return false;
      }
   }

   public boolean a(World var1, Random var2, bjb var3) {
      if(this.a(var1, var3)) {
         return false;
      } else {
         boolean var4 = false;
         boolean var5 = true;
         boolean var6 = false;
         boolean var7 = true;
         int var8 = this.d * 5 - 1;
         this.a(var1, var3, 0, 0, 0, 2, 1, var8, Blocks.AIR.P(), Blocks.AIR.P(), false);
         this.a(var1, var3, var2, 0.8F, 0, 2, 0, 2, 2, var8, Blocks.AIR.P(), Blocks.AIR.P(), false);
         if(this.b) {
            this.a(var1, var3, var2, 0.6F, 0, 0, 0, 2, 1, var8, Blocks.WEB.P(), Blocks.AIR.P(), false);
         }

         int var9;
         int var10;
         for(var9 = 0; var9 < this.d; ++var9) {
            var10 = 2 + var9 * 5;
            this.a(var1, var3, 0, 0, var10, 0, 1, var10, Blocks.FENCE.P(), Blocks.AIR.P(), false);
            this.a(var1, var3, 2, 0, var10, 2, 1, var10, Blocks.FENCE.P(), Blocks.AIR.P(), false);
            if(var2.nextInt(4) == 0) {
               this.a(var1, var3, 0, 2, var10, 0, 2, var10, Blocks.WOOD.P(), Blocks.AIR.P(), false);
               this.a(var1, var3, 2, 2, var10, 2, 2, var10, Blocks.WOOD.P(), Blocks.AIR.P(), false);
            } else {
               this.a(var1, var3, 0, 2, var10, 2, 2, var10, Blocks.WOOD.P(), Blocks.AIR.P(), false);
            }

            this.a(var1, var3, var2, 0.1F, 0, 2, var10 - 1, Blocks.WEB.P());
            this.a(var1, var3, var2, 0.1F, 2, 2, var10 - 1, Blocks.WEB.P());
            this.a(var1, var3, var2, 0.1F, 0, 2, var10 + 1, Blocks.WEB.P());
            this.a(var1, var3, var2, 0.1F, 2, 2, var10 + 1, Blocks.WEB.P());
            this.a(var1, var3, var2, 0.05F, 0, 2, var10 - 2, Blocks.WEB.P());
            this.a(var1, var3, var2, 0.05F, 2, 2, var10 - 2, Blocks.WEB.P());
            this.a(var1, var3, var2, 0.05F, 0, 2, var10 + 2, Blocks.WEB.P());
            this.a(var1, var3, var2, 0.05F, 2, 2, var10 + 2, Blocks.WEB.P());
            this.a(var1, var3, var2, 0.05F, 1, 2, var10 - 1, Blocks.TORCH.a(EnumFacing.UP.a()));
            this.a(var1, var3, var2, 0.05F, 1, 2, var10 + 1, Blocks.TORCH.a(EnumFacing.UP.a()));
            if(var2.nextInt(100) == 0) {
               this.a(var1, var3, var2, 2, 0, var10 - 1, StructurePieceTreaasure.a(bje.b(), new StructurePieceTreaasure[]{Items.cd.b(var2)}), 3 + var2.nextInt(4));
            }

            if(var2.nextInt(100) == 0) {
               this.a(var1, var3, var2, 0, 0, var10 + 1, StructurePieceTreaasure.a(bje.b(), new StructurePieceTreaasure[]{Items.cd.b(var2)}), 3 + var2.nextInt(4));
            }

            if(this.b && !this.c) {
               int var11 = this.d(0);
               int var12 = var10 - 1 + var2.nextInt(3);
               int var13 = this.a(1, var12);
               var12 = this.b(1, var12);
               Location var14 = new Location(var13, var11, var12);
               if(var3.b((ChunkCoordinates)var14)) {
                  this.c = true;
                  var1.setTypeAndData(var14, Blocks.MOB_SPAWNER.P(), 2);
                  TileEntity var15 = var1.getTileEntity(var14);
                  if(var15 instanceof TileEntityMobSpawner) {
                     ((TileEntityMobSpawner)var15).getSpawner().a("CaveSpider");
                  }
               }
            }
         }

         for(var9 = 0; var9 <= 2; ++var9) {
            for(var10 = 0; var10 <= var8; ++var10) {
               byte var17 = -1;
               IBlockData var18 = this.a(var1, var9, var17, var10, var3);
               if(var18.c().getMaterial() == Material.AIR) {
                  byte var19 = -1;
                  this.a(var1, Blocks.WOOD.P(), var9, var19, var10, var3);
               }
            }
         }

         if(this.a) {
            for(var9 = 0; var9 <= var8; ++var9) {
               IBlockData var16 = this.a(var1, 1, -1, var9, var3);
               if(var16.c().getMaterial() != Material.AIR && var16.c().m()) {
                  this.a(var1, var3, var2, 0.7F, 1, 0, var9, Blocks.RAILS.a(this.a(Blocks.RAILS, 0)));
               }
            }
         }

         return true;
      }
   }
}
