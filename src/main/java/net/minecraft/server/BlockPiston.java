package net.minecraft.server;
import java.util.List;

public class BlockPiston extends Block {

   public static final beu a = beu.a("facing");
   public static final bet b = bet.a("extended");
   private final boolean M;


   public BlockPiston(boolean var1) {
      super(Material.PISTON);
      this.j(this.L.b().a(a, EnumFacing.NORTH).a(b, Boolean.valueOf(false)));
      this.M = var1;
      this.a(i);
      this.c(0.5F);
      this.a(CreativeModeTab.d);
   }

   public boolean c() {
      return false;
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      var1.setTypeAndData(var2, var3.a(a, a(var1, var2, var4)), 2);
      if(!var1.isStatic) {
         this.e(var1, var2, var3);
      }

   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      if(!var1.isStatic) {
         this.e(var1, var2, var3);
      }

   }

   public void onPlace(World var1, Location var2, IBlockData var3) {
      if(!var1.isStatic && var1.getTileEntity(var2) == null) {
         this.e(var1, var2, var3);
      }

   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(a, a(var1, var2, var8)).a(b, Boolean.valueOf(false));
   }

   private void e(World var1, Location var2, IBlockData var3) {
      EnumFacing var4 = (EnumFacing)var3.b(a);
      boolean var5 = this.b(var1, var2, var4);
      if(var5 && !((Boolean)var3.b(b)).booleanValue()) {
         if((new bdy(var1, var2, var4, true)).a()) {
            var1.playBlockAction(var2, this, 0, var4.a());
         }
      } else if(!var5 && ((Boolean)var3.b(b)).booleanValue()) {
         var1.setTypeAndData(var2, var3.a(b, Boolean.valueOf(false)), 2);
         var1.playBlockAction(var2, this, 1, var4.a());
      }

   }

   private boolean b(World var1, Location var2, EnumFacing var3) {
      EnumFacing[] var4 = EnumFacing.values();
      int var5 = var4.length;

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         EnumFacing var7 = var4[var6];
         if(var7 != var3 && var1.isBlockFacePowered(var2.a(var7), var7)) {
            return true;
         }
      }

      if(var1.isBlockFacePowered(var2, EnumFacing.NORTH)) {
         return true;
      } else {
         Location var9 = var2.a();
         EnumFacing[] var10 = EnumFacing.values();
         var6 = var10.length;

         for(int var11 = 0; var11 < var6; ++var11) {
            EnumFacing var8 = var10[var11];
            if(var8 != EnumFacing.DOWN && var1.isBlockFacePowered(var9.a(var8), var8)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean a(World var1, Location var2, IBlockData var3, int var4, int var5) {
      EnumFacing var6 = (EnumFacing)var3.b(a);
      if(!var1.isStatic) {
         boolean var7 = this.b(var1, var2, var6);
         if(var7 && var4 == 1) {
            var1.setTypeAndData(var2, var3.a(b, Boolean.valueOf(true)), 2);
            return false;
         }

         if(!var7 && var4 == 0) {
            return false;
         }
      }

      if(var4 == 0) {
         if(!this.a(var1, var2, var6, true)) {
            return false;
         }

         var1.setTypeAndData(var2, var3.a(b, Boolean.valueOf(true)), 2);
         var1.makeSound((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "tile.piston.out", 0.5F, var1.random.nextFloat() * 0.25F + 0.6F);
      } else if(var4 == 1) {
         TileEntity var13 = var1.getTileEntity(var2.a(var6));
         if(var13 instanceof TileEntityPiston) {
            ((TileEntityPiston)var13).h();
         }

         var1.setTypeAndData(var2, Blocks.PISTON_MOVING.P().a(BlockPistonMoving.a, var6).a(BlockPistonMoving.b, this.M?bdu.b:bdu.a), 3);
         var1.setTileEntity(var2, BlockPistonMoving.a(this.a(var5), var6, false, true));
         if(this.M) {
            Location var8 = var2.a(var6.g() * 2, var6.h() * 2, var6.i() * 2);
            Block var9 = var1.getData(var8).c();
            boolean var10 = false;
            if(var9 == Blocks.PISTON_MOVING) {
               TileEntity var11 = var1.getTileEntity(var8);
               if(var11 instanceof TileEntityPiston) {
                  TileEntityPiston var12 = (TileEntityPiston)var11;
                  if(var12.e() == var6 && var12.d()) {
                     var12.h();
                     var10 = true;
                  }
               }
            }

            if(!var10 && var9.getMaterial() != Material.AIR && a(var9, var1, var8, var6.d(), false) && (var9.getDropData() == 0 || var9 == Blocks.PISTON || var9 == Blocks.PISTON_STICKEY)) {
               this.a(var1, var2, var6, false);
            }
         } else {
            var1.setAir(var2.a(var6));
         }

         var1.makeSound((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "tile.piston.in", 0.5F, var1.random.nextFloat() * 0.15F + 0.6F);
      }

      return true;
   }

   public void updateShape(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      if(var3.c() == this && ((Boolean)var3.b(b)).booleanValue()) {
         float var4 = 0.25F;
         EnumFacing var5 = (EnumFacing)var3.b(a);
         if(var5 != null) {
            switch(bdr.a[var5.ordinal()]) {
            case 1:
               this.a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 2:
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
               break;
            case 3:
               this.a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
               break;
            case 4:
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
               break;
            case 5:
               this.a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
               break;
            case 6:
               this.a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
            }
         }
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(World var1, Location var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      this.updateShape(var1, var2);
      return super.a(var1, var2, var3);
   }

   public boolean d() {
      return false;
   }

   public static EnumFacing b(int var0) {
      int var1 = var0 & 7;
      return var1 > 5?null:EnumFacing.a(var1);
   }

   public static EnumFacing a(World var0, Location var1, EntityLiving var2) {
      if(MathHelper.e((float)var2.s - (float)var1.n()) < 2.0F && MathHelper.e((float)var2.u - (float)var1.p()) < 2.0F) {
         double var3 = var2.t + (double)var2.aR();
         if(var3 - (double)var1.o() > 2.0D) {
            return EnumFacing.UP;
         }

         if((double)var1.o() - var3 > 0.0D) {
            return EnumFacing.DOWN;
         }
      }

      return var2.aO().d();
   }

   public static boolean a(Block var0, World var1, Location var2, EnumFacing var3, boolean var4) {
      if(var0 == Blocks.OBSIDIAN) {
         return false;
      } else if(!var1.af().a(var2)) {
         return false;
      } else if(var2.o() >= 0 && (var3 != EnumFacing.DOWN || var2.o() != 0)) {
         if(var2.o() <= var1.U() - 1 && (var3 != EnumFacing.UP || var2.o() != var1.U() - 1)) {
            if(var0 != Blocks.PISTON && var0 != Blocks.PISTON_STICKEY) {
               if(var0.g(var1, var2) == -1.0F) {
                  return false;
               }

               if(var0.getDropData() == 2) {
                  return false;
               }

               if(var0.getDropData() == 1) {
                  if(!var4) {
                     return false;
                  }

                  return true;
               }
            } else if(((Boolean)var1.getData(var2).b(b)).booleanValue()) {
               return false;
            }

            return !(var0 instanceof IContainer);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean a(World var1, Location var2, EnumFacing var3, boolean var4) {
      if(!var4) {
         var1.setAir(var2.a(var3));
      }

      bdy var5 = new bdy(var1, var2, var3, var4);
      List var6 = var5.c();
      List var7 = var5.d();
      if(!var5.a()) {
         return false;
      } else {
         int var8 = var6.size() + var7.size();
         Block[] var9 = new Block[var8];
         EnumFacing var10 = var4?var3:var3.d();

         int var11;
         Location var12;
         for(var11 = var7.size() - 1; var11 >= 0; --var11) {
            var12 = (Location)var7.get(var11);
            Block var13 = var1.getData(var12).c();
            var13.b(var1, var12, var1.getData(var12), 0);
            var1.setAir(var12);
            --var8;
            var9[var8] = var13;
         }

         IBlockData var19;
         for(var11 = var6.size() - 1; var11 >= 0; --var11) {
            var12 = (Location)var6.get(var11);
            var19 = var1.getData(var12);
            Block var14 = var19.c();
            var14.c(var19);
            var1.setAir(var12);
            var12 = var12.a(var10);
            var1.setTypeAndData(var12, Blocks.PISTON_MOVING.P().a(a, var3), 4);
            var1.setTileEntity(var12, BlockPistonMoving.a(var19, var3, var4, false));
            --var8;
            var9[var8] = var14;
         }

         Location var16 = var2.a(var3);
         if(var4) {
            bdu var17 = this.M?bdu.b:bdu.a;
            var19 = Blocks.PISTON_EXTENSION.P().a(BlockPistonExtension.a, var3).a(BlockPistonExtension.b, var17);
            IBlockData var20 = Blocks.PISTON_MOVING.P().a(BlockPistonMoving.a, var3).a(BlockPistonMoving.b, this.M?bdu.b:bdu.a);
            var1.setTypeAndData(var16, var20, 4);
            var1.setTileEntity(var16, BlockPistonMoving.a(var19, var3, true, false));
         }

         int var18;
         for(var18 = var7.size() - 1; var18 >= 0; --var18) {
            var1.applyPhysics((Location)var7.get(var18), var9[var8++]);
         }

         for(var18 = var6.size() - 1; var18 >= 0; --var18) {
            var1.applyPhysics((Location)var6.get(var18), var9[var8++]);
         }

         if(var4) {
            var1.applyPhysics(var16, (Block)Blocks.PISTON_EXTENSION);
            var1.applyPhysics(var2, (Block)this);
         }

         return true;
      }
   }

   public IBlockData a(int var1) {
      return this.P().a(a, b(var1)).a(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(a)).a();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b});
   }

}
