package net.minecraft.server;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public abstract class bms {

   protected bjb l;
   protected EnumFacing m;
   protected int n;


   public bms() {}

   protected bms(int var1) {
      this.n = var1;
   }

   public NBTTagCompound b() {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.setString("id", bmq.a(this));
      var1.set("BB", (NBTBase)this.l.g());
      var1.setInt("O", this.m == null?-1:this.m.b());
      var1.setInt("GD", this.n);
      this.a(var1);
      return var1;
   }

   protected abstract void a(NBTTagCompound var1);

   public void a(World var1, NBTTagCompound var2) {
      if(var2.hasKey("BB")) {
         this.l = new bjb(var2.getIntArray("BB"));
      }

      int var3 = var2.getInt("O");
      this.m = var3 == -1?null:EnumFacing.b(var3);
      this.n = var2.getInt("GD");
      this.b(var2);
   }

   protected abstract void b(NBTTagCompound var1);

   public void a(bms var1, List var2, Random var3) {}

   public abstract boolean a(World var1, Random var2, bjb var3);

   public bjb c() {
      return this.l;
   }

   public int d() {
      return this.n;
   }

   public static bms a(List var0, bjb var1) {
      Iterator var2 = var0.iterator();

      bms var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (bms)var2.next();
      } while(var3.c() == null || !var3.c().a(var1));

      return var3;
   }

   public Location a() {
      return new Location(this.l.f());
   }

   protected boolean a(World var1, bjb var2) {
      int var3 = Math.max(this.l.a - 1, var2.a);
      int var4 = Math.max(this.l.b - 1, var2.b);
      int var5 = Math.max(this.l.c - 1, var2.c);
      int var6 = Math.min(this.l.d + 1, var2.d);
      int var7 = Math.min(this.l.e + 1, var2.e);
      int var8 = Math.min(this.l.f + 1, var2.f);

      int var9;
      int var10;
      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var5; var10 <= var8; ++var10) {
            if(var1.getData(new Location(var9, var4, var10)).c().getMaterial().isLiquid()) {
               return true;
            }

            if(var1.getData(new Location(var9, var7, var10)).c().getMaterial().isLiquid()) {
               return true;
            }
         }
      }

      for(var9 = var3; var9 <= var6; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            if(var1.getData(new Location(var9, var10, var5)).c().getMaterial().isLiquid()) {
               return true;
            }

            if(var1.getData(new Location(var9, var10, var8)).c().getMaterial().isLiquid()) {
               return true;
            }
         }
      }

      for(var9 = var5; var9 <= var8; ++var9) {
         for(var10 = var4; var10 <= var7; ++var10) {
            if(var1.getData(new Location(var3, var10, var9)).c().getMaterial().isLiquid()) {
               return true;
            }

            if(var1.getData(new Location(var6, var10, var9)).c().getMaterial().isLiquid()) {
               return true;
            }
         }
      }

      return false;
   }

   protected int a(int var1, int var2) {
      if(this.m == null) {
         return var1;
      } else {
         switch(bmt.a[this.m.ordinal()]) {
         case 1:
         case 2:
            return this.l.a + var1;
         case 3:
            return this.l.d - var2;
         case 4:
            return this.l.a + var2;
         default:
            return var1;
         }
      }
   }

   protected int d(int var1) {
      return this.m == null?var1:var1 + this.l.b;
   }

   protected int b(int var1, int var2) {
      if(this.m == null) {
         return var2;
      } else {
         switch(bmt.a[this.m.ordinal()]) {
         case 1:
            return this.l.f - var2;
         case 2:
            return this.l.c + var2;
         case 3:
         case 4:
            return this.l.c + var1;
         default:
            return var2;
         }
      }
   }

   protected int a(Block var1, int var2) {
      if(var1 == Blocks.RAILS) {
         if(this.m == EnumFacing.WEST || this.m == EnumFacing.EAST) {
            if(var2 == 1) {
               return 0;
            }

            return 1;
         }
      } else if(var1 instanceof BlockDoor) {
         if(this.m == EnumFacing.SOUTH) {
            if(var2 == 0) {
               return 2;
            }

            if(var2 == 2) {
               return 0;
            }
         } else {
            if(this.m == EnumFacing.WEST) {
               return var2 + 1 & 3;
            }

            if(this.m == EnumFacing.EAST) {
               return var2 + 3 & 3;
            }
         }
      } else if(var1 != Blocks.COBBLESTONE_STAIRS && var1 != Blocks.WOOD_STAIRS && var1 != Blocks.NETHER_BRICK_STAIRS && var1 != Blocks.STONE_STAIRS && var1 != Blocks.SANDSTONE_STAIRS) {
         if(var1 == Blocks.LADDER) {
            if(this.m == EnumFacing.SOUTH) {
               if(var2 == EnumFacing.NORTH.a()) {
                  return EnumFacing.SOUTH.a();
               }

               if(var2 == EnumFacing.SOUTH.a()) {
                  return EnumFacing.NORTH.a();
               }
            } else if(this.m == EnumFacing.WEST) {
               if(var2 == EnumFacing.NORTH.a()) {
                  return EnumFacing.WEST.a();
               }

               if(var2 == EnumFacing.SOUTH.a()) {
                  return EnumFacing.EAST.a();
               }

               if(var2 == EnumFacing.WEST.a()) {
                  return EnumFacing.NORTH.a();
               }

               if(var2 == EnumFacing.EAST.a()) {
                  return EnumFacing.SOUTH.a();
               }
            } else if(this.m == EnumFacing.EAST) {
               if(var2 == EnumFacing.NORTH.a()) {
                  return EnumFacing.EAST.a();
               }

               if(var2 == EnumFacing.SOUTH.a()) {
                  return EnumFacing.WEST.a();
               }

               if(var2 == EnumFacing.WEST.a()) {
                  return EnumFacing.NORTH.a();
               }

               if(var2 == EnumFacing.EAST.a()) {
                  return EnumFacing.SOUTH.a();
               }
            }
         } else if(var1 == Blocks.STONE_BUTTON) {
            if(this.m == EnumFacing.SOUTH) {
               if(var2 == 3) {
                  return 4;
               }

               if(var2 == 4) {
                  return 3;
               }
            } else if(this.m == EnumFacing.WEST) {
               if(var2 == 3) {
                  return 1;
               }

               if(var2 == 4) {
                  return 2;
               }

               if(var2 == 2) {
                  return 3;
               }

               if(var2 == 1) {
                  return 4;
               }
            } else if(this.m == EnumFacing.EAST) {
               if(var2 == 3) {
                  return 2;
               }

               if(var2 == 4) {
                  return 1;
               }

               if(var2 == 2) {
                  return 3;
               }

               if(var2 == 1) {
                  return 4;
               }
            }
         } else if(var1 != Blocks.TRIPWIRE_HOOK && !(var1 instanceof BlockDirectional)) {
            if(var1 == Blocks.PISTON || var1 == Blocks.PISTON_STICKEY || var1 == Blocks.LEVER || var1 == Blocks.DISPENSER) {
               if(this.m == EnumFacing.SOUTH) {
                  if(var2 == EnumFacing.NORTH.a() || var2 == EnumFacing.SOUTH.a()) {
                     return EnumFacing.a(var2).d().a();
                  }
               } else if(this.m == EnumFacing.WEST) {
                  if(var2 == EnumFacing.NORTH.a()) {
                     return EnumFacing.WEST.a();
                  }

                  if(var2 == EnumFacing.SOUTH.a()) {
                     return EnumFacing.EAST.a();
                  }

                  if(var2 == EnumFacing.WEST.a()) {
                     return EnumFacing.NORTH.a();
                  }

                  if(var2 == EnumFacing.EAST.a()) {
                     return EnumFacing.SOUTH.a();
                  }
               } else if(this.m == EnumFacing.EAST) {
                  if(var2 == EnumFacing.NORTH.a()) {
                     return EnumFacing.EAST.a();
                  }

                  if(var2 == EnumFacing.SOUTH.a()) {
                     return EnumFacing.WEST.a();
                  }

                  if(var2 == EnumFacing.WEST.a()) {
                     return EnumFacing.NORTH.a();
                  }

                  if(var2 == EnumFacing.EAST.a()) {
                     return EnumFacing.SOUTH.a();
                  }
               }
            }
         } else {
            EnumFacing var3 = EnumFacing.b(var2);
            if(this.m == EnumFacing.SOUTH) {
               if(var3 == EnumFacing.SOUTH || var3 == EnumFacing.NORTH) {
                  return var3.d().b();
               }
            } else if(this.m == EnumFacing.WEST) {
               if(var3 == EnumFacing.NORTH) {
                  return EnumFacing.WEST.b();
               }

               if(var3 == EnumFacing.SOUTH) {
                  return EnumFacing.EAST.b();
               }

               if(var3 == EnumFacing.WEST) {
                  return EnumFacing.NORTH.b();
               }

               if(var3 == EnumFacing.EAST) {
                  return EnumFacing.SOUTH.b();
               }
            } else if(this.m == EnumFacing.EAST) {
               if(var3 == EnumFacing.NORTH) {
                  return EnumFacing.EAST.b();
               }

               if(var3 == EnumFacing.SOUTH) {
                  return EnumFacing.WEST.b();
               }

               if(var3 == EnumFacing.WEST) {
                  return EnumFacing.NORTH.b();
               }

               if(var3 == EnumFacing.EAST) {
                  return EnumFacing.SOUTH.b();
               }
            }
         }
      } else if(this.m == EnumFacing.SOUTH) {
         if(var2 == 2) {
            return 3;
         }

         if(var2 == 3) {
            return 2;
         }
      } else if(this.m == EnumFacing.WEST) {
         if(var2 == 0) {
            return 2;
         }

         if(var2 == 1) {
            return 3;
         }

         if(var2 == 2) {
            return 0;
         }

         if(var2 == 3) {
            return 1;
         }
      } else if(this.m == EnumFacing.EAST) {
         if(var2 == 0) {
            return 2;
         }

         if(var2 == 1) {
            return 3;
         }

         if(var2 == 2) {
            return 1;
         }

         if(var2 == 3) {
            return 0;
         }
      }

      return var2;
   }

   protected void a(World var1, IBlockData var2, int var3, int var4, int var5, bjb var6) {
      Location var7 = new Location(this.a(var3, var5), this.d(var4), this.b(var3, var5));
      if(var6.b((ChunkCoordinates)var7)) {
         var1.setTypeAndData(var7, var2, 2);
      }
   }

   protected IBlockData a(World var1, int var2, int var3, int var4, bjb var5) {
      int var6 = this.a(var2, var4);
      int var7 = this.d(var3);
      int var8 = this.b(var2, var4);
      return !var5.b((ChunkCoordinates)(new Location(var6, var7, var8)))?Blocks.AIR.P():var1.getData(new Location(var6, var7, var8));
   }

   protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      for(int var9 = var4; var9 <= var7; ++var9) {
         for(int var10 = var3; var10 <= var6; ++var10) {
            for(int var11 = var5; var11 <= var8; ++var11) {
               this.a(var1, Blocks.AIR.P(), var10, var9, var11, var2);
            }
         }
      }

   }

   protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlockData var9, IBlockData var10, boolean var11) {
      for(int var12 = var4; var12 <= var7; ++var12) {
         for(int var13 = var3; var13 <= var6; ++var13) {
            for(int var14 = var5; var14 <= var8; ++var14) {
               if(!var11 || this.a(var1, var13, var12, var14, var2).c().getMaterial() != Material.AIR) {
                  if(var12 != var4 && var12 != var7 && var13 != var3 && var13 != var6 && var14 != var5 && var14 != var8) {
                     this.a(var1, var10, var13, var12, var14, var2);
                  } else {
                     this.a(var1, var9, var13, var12, var14, var2);
                  }
               }
            }
         }
      }

   }

   protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, Random var10, bmu var11) {
      for(int var12 = var4; var12 <= var7; ++var12) {
         for(int var13 = var3; var13 <= var6; ++var13) {
            for(int var14 = var5; var14 <= var8; ++var14) {
               if(!var9 || this.a(var1, var13, var12, var14, var2).c().getMaterial() != Material.AIR) {
                  var11.a(var10, var13, var12, var14, var12 == var4 || var12 == var7 || var13 == var3 || var13 == var6 || var14 == var5 || var14 == var8);
                  this.a(var1, var11.a(), var13, var12, var14, var2);
               }
            }
         }
      }

   }

   protected void a(World var1, bjb var2, Random var3, float var4, int var5, int var6, int var7, int var8, int var9, int var10, IBlockData var11, IBlockData var12, boolean var13) {
      for(int var14 = var6; var14 <= var9; ++var14) {
         for(int var15 = var5; var15 <= var8; ++var15) {
            for(int var16 = var7; var16 <= var10; ++var16) {
               if(var3.nextFloat() <= var4 && (!var13 || this.a(var1, var15, var14, var16, var2).c().getMaterial() != Material.AIR)) {
                  if(var14 != var6 && var14 != var9 && var15 != var5 && var15 != var8 && var16 != var7 && var16 != var10) {
                     this.a(var1, var12, var15, var14, var16, var2);
                  } else {
                     this.a(var1, var11, var15, var14, var16, var2);
                  }
               }
            }
         }
      }

   }

   protected void a(World var1, bjb var2, Random var3, float var4, int var5, int var6, int var7, IBlockData var8) {
      if(var3.nextFloat() < var4) {
         this.a(var1, var8, var5, var6, var7, var2);
      }

   }

   protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlockData var9, boolean var10) {
      float var11 = (float)(var6 - var3 + 1);
      float var12 = (float)(var7 - var4 + 1);
      float var13 = (float)(var8 - var5 + 1);
      float var14 = (float)var3 + var11 / 2.0F;
      float var15 = (float)var5 + var13 / 2.0F;

      for(int var16 = var4; var16 <= var7; ++var16) {
         float var17 = (float)(var16 - var4) / var12;

         for(int var18 = var3; var18 <= var6; ++var18) {
            float var19 = ((float)var18 - var14) / (var11 * 0.5F);

            for(int var20 = var5; var20 <= var8; ++var20) {
               float var21 = ((float)var20 - var15) / (var13 * 0.5F);
               if(!var10 || this.a(var1, var18, var16, var20, var2).c().getMaterial() != Material.AIR) {
                  float var22 = var19 * var19 + var17 * var17 + var21 * var21;
                  if(var22 <= 1.05F) {
                     this.a(var1, var9, var18, var16, var20, var2);
                  }
               }
            }
         }
      }

   }

   protected void b(World var1, int var2, int var3, int var4, bjb var5) {
      Location var6 = new Location(this.a(var2, var4), this.d(var3), this.b(var2, var4));
      if(var5.b((ChunkCoordinates)var6)) {
         while(!var1.isEmpty(var6) && var6.o() < 255) {
            var1.setTypeAndData(var6, Blocks.AIR.P(), 2);
            var6 = var6.a();
         }

      }
   }

   protected void b(World var1, IBlockData var2, int var3, int var4, int var5, bjb var6) {
      int var7 = this.a(var3, var5);
      int var8 = this.d(var4);
      int var9 = this.b(var3, var5);
      if(var6.b((ChunkCoordinates)(new Location(var7, var8, var9)))) {
         while((var1.isEmpty(new Location(var7, var8, var9)) || var1.getData(new Location(var7, var8, var9)).c().getMaterial().isLiquid()) && var8 > 1) {
            var1.setTypeAndData(new Location(var7, var8, var9), var2, 2);
            --var8;
         }

      }
   }

   protected boolean a(World var1, bjb var2, Random var3, int var4, int var5, int var6, List var7, int var8) {
      Location var9 = new Location(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if(var2.b((ChunkCoordinates)var9) && var1.getData(var9).c() != Blocks.CHEST) {
         IBlockData var10 = Blocks.CHEST.P();
         var1.setTypeAndData(var9, Blocks.CHEST.f(var1, var9, var10), 2);
         TileEntity var11 = var1.getTileEntity(var9);
         if(var11 instanceof TileEntityChest) {
            StructurePieceTreaasure.a(var3, var7, (IInventory)((TileEntityChest)var11), var8);
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean a(World var1, bjb var2, Random var3, int var4, int var5, int var6, int var7, List var8, int var9) {
      Location var10 = new Location(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if(var2.b((ChunkCoordinates)var10) && var1.getData(var10).c() != Blocks.DISPENSER) {
         var1.setTypeAndData(var10, Blocks.DISPENSER.a(this.a(Blocks.DISPENSER, var7)), 2);
         TileEntity var11 = var1.getTileEntity(var10);
         if(var11 instanceof TileEntityDispenser) {
            StructurePieceTreaasure.a(var3, var8, (TileEntityDispenser)var11, var9);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void a(World var1, bjb var2, Random var3, int var4, int var5, int var6, EnumFacing var7) {
      Location var8 = new Location(this.a(var4, var6), this.d(var5), this.b(var4, var6));
      if(var2.b((ChunkCoordinates)var8)) {
         akt.a(var1, var8, var7.f(), Blocks.WOODEN_DOOR);
      }

   }
}
