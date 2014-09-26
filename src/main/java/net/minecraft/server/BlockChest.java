package net.minecraft.server;
import com.google.common.base.Predicate;

import java.util.Iterator;
import java.util.Random;

public class BlockChest extends BlockContainer {

   public static final beu a = beu.a("facing", (Predicate)en.a);
   private final Random M = new Random();
   public final int b;


   protected BlockChest(int var1) {
      super(Material.WOOD);
      this.j(this.L.b().a(a, EnumFacing.NORTH));
      this.b = var1;
      this.a(CreativeModeTab.c);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int b() {
      return 2;
   }

   public void updateShape(IBlockAccess var1, Location var2) {
      if(var1.getData(var2.c()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.getData(var2.d()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if(var1.getData(var2.e()).c() == this) {
         this.a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if(var1.getData(var2.f()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public void onPlace(World var1, Location var2, IBlockData var3) {
      this.e(var1, var2, var3);
      Iterator var4 = en.a.iterator();

      while(var4.hasNext()) {
         EnumFacing var5 = (EnumFacing)var4.next();
         Location var6 = var2.a(var5);
         IBlockData var7 = var1.getData(var6);
         if(var7.c() == this) {
            this.e(var1, var6, var7);
         }
      }

   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(a, var8.aO());
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      EnumFacing var6 = EnumFacing.b(MathHelper.floor((double)(var4.y * 4.0F / 360.0F) + 0.5D) & 3).d();
      var3 = var3.a(a, var6);
      Location var7 = var2.c();
      Location var8 = var2.d();
      Location var9 = var2.e();
      Location var10 = var2.f();
      boolean var11 = this == var1.getData(var7).c();
      boolean var12 = this == var1.getData(var8).c();
      boolean var13 = this == var1.getData(var9).c();
      boolean var14 = this == var1.getData(var10).c();
      if(!var11 && !var12 && !var13 && !var14) {
         var1.setTypeAndData(var2, var3, 3);
      } else if(var6.k() == el.a && (var11 || var12)) {
         if(var11) {
            var1.setTypeAndData(var7, var3, 3);
         } else {
            var1.setTypeAndData(var8, var3, 3);
         }

         var1.setTypeAndData(var2, var3, 3);
      } else if(var6.k() == el.c && (var13 || var14)) {
         if(var13) {
            var1.setTypeAndData(var9, var3, 3);
         } else {
            var1.setTypeAndData(var10, var3, 3);
         }

         var1.setTypeAndData(var2, var3, 3);
      }

      if(var5.hasName()) {
         TileEntity var15 = var1.getTileEntity(var2);
         if(var15 instanceof TileEntityChest) {
            ((TileEntityChest)var15).a(var5.getName());
         }
      }

   }

   public IBlockData e(World var1, Location var2, IBlockData var3) {
      if(var1.isStatic) {
         return var3;
      } else {
         IBlockData var4 = var1.getData(var2.c());
         IBlockData var5 = var1.getData(var2.d());
         IBlockData var6 = var1.getData(var2.e());
         IBlockData var7 = var1.getData(var2.f());
         EnumFacing var8 = (EnumFacing)var3.b(a);
         Block var9 = var4.c();
         Block var10 = var5.c();
         Block var11 = var6.c();
         Block var12 = var7.c();
         if(var9 != this && var10 != this) {
            boolean var21 = var9.m();
            boolean var23 = var10.m();
            if(var11 == this || var12 == this) {
               Location var22 = var11 == this?var2.e():var2.f();
               IBlockData var25 = var1.getData(var22.c());
               IBlockData var24 = var1.getData(var22.d());
               var8 = EnumFacing.SOUTH;
               EnumFacing var26;
               if(var11 == this) {
                  var26 = (EnumFacing)var6.b(a);
               } else {
                  var26 = (EnumFacing)var7.b(a);
               }

               if(var26 == EnumFacing.NORTH) {
                  var8 = EnumFacing.NORTH;
               }

               Block var19 = var25.c();
               Block var20 = var24.c();
               if((var21 || var19.m()) && !var23 && !var20.m()) {
                  var8 = EnumFacing.SOUTH;
               }

               if((var23 || var20.m()) && !var21 && !var19.m()) {
                  var8 = EnumFacing.NORTH;
               }
            }
         } else {
            Location var13 = var9 == this?var2.c():var2.d();
            IBlockData var14 = var1.getData(var13.e());
            IBlockData var15 = var1.getData(var13.f());
            var8 = EnumFacing.EAST;
            EnumFacing var16;
            if(var9 == this) {
               var16 = (EnumFacing)var4.b(a);
            } else {
               var16 = (EnumFacing)var5.b(a);
            }

            if(var16 == EnumFacing.WEST) {
               var8 = EnumFacing.WEST;
            }

            Block var17 = var14.c();
            Block var18 = var15.c();
            if((var11.m() || var17.m()) && !var12.m() && !var18.m()) {
               var8 = EnumFacing.EAST;
            }

            if((var12.m() || var18.m()) && !var11.m() && !var17.m()) {
               var8 = EnumFacing.WEST;
            }
         }

         var3 = var3.a(a, var8);
         var1.setTypeAndData(var2, var3, 3);
         return var3;
      }
   }

   public IBlockData f(World var1, Location var2, IBlockData var3) {
      EnumFacing var4 = null;
      Iterator var5 = en.a.iterator();

      while(var5.hasNext()) {
         EnumFacing var6 = (EnumFacing)var5.next();
         IBlockData var7 = var1.getData(var2.a(var6));
         if(var7.c() == this) {
            return var3;
         }

         if(var7.c().m()) {
            if(var4 != null) {
               var4 = null;
               break;
            }

            var4 = var6;
         }
      }

      if(var4 != null) {
         return var3.a(a, var4.d());
      } else {
         EnumFacing var8 = (EnumFacing)var3.b(a);
         if(var1.getData(var2.a(var8)).c().m()) {
            var8 = var8.d();
         }

         if(var1.getData(var2.a(var8)).c().m()) {
            var8 = var8.e();
         }

         if(var1.getData(var2.a(var8)).c().m()) {
            var8 = var8.d();
         }

         return var3.a(a, var8);
      }
   }

   public boolean canPlace(World var1, Location var2) {
      int var3 = 0;
      Location var4 = var2.e();
      Location var5 = var2.f();
      Location var6 = var2.c();
      Location var7 = var2.d();
      if(var1.getData(var4).c() == this) {
         if(this.e(var1, var4)) {
            return false;
         }

         ++var3;
      }

      if(var1.getData(var5).c() == this) {
         if(this.e(var1, var5)) {
            return false;
         }

         ++var3;
      }

      if(var1.getData(var6).c() == this) {
         if(this.e(var1, var6)) {
            return false;
         }

         ++var3;
      }

      if(var1.getData(var7).c() == this) {
         if(this.e(var1, var7)) {
            return false;
         }

         ++var3;
      }

      return var3 <= 1;
   }

   private boolean e(World var1, Location var2) {
      if(var1.getData(var2).c() != this) {
         return false;
      } else {
         Iterator var3 = en.a.iterator();

         EnumFacing var4;
         do {
            if(!var3.hasNext()) {
               return false;
            }

            var4 = (EnumFacing)var3.next();
         } while(var1.getData(var2.a(var4)).c() != this);

         return true;
      }
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      super.doPhysics(var1, var2, var3, var4);
      TileEntity var5 = var1.getTileEntity(var2);
      if(var5 instanceof TileEntityChest) {
         var5.E();
      }

   }

   public void remove(World var1, Location var2, IBlockData var3) {
      TileEntity var4 = var1.getTileEntity(var2);
      if(var4 instanceof IInventory) {
         vs.a(var1, var2, (IInventory)var4);
         var1.updateAdjacentComparators(var2, this);
      }

      super.remove(var1, var2, var3);
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var1.isStatic) {
         return true;
      } else {
         vy var9 = this.d(var1, var2);
         if(var9 != null) {
            var4.a((IInventory)var9);
         }

         return true;
      }
   }

   public vy d(World var1, Location var2) {
      TileEntity var3 = var1.getTileEntity(var2);
      if(!(var3 instanceof TileEntityChest)) {
         return null;
      } else {
         Object var4 = (TileEntityChest)var3;
         if(this.m(var1, var2)) {
            return null;
         } else {
            Iterator var5 = en.a.iterator();

            while(var5.hasNext()) {
               EnumFacing var6 = (EnumFacing)var5.next();
               Location var7 = var2.a(var6);
               Block var8 = var1.getData(var7).c();
               if(var8 == this) {
                  if(this.m(var1, var7)) {
                     return null;
                  }

                  TileEntity var9 = var1.getTileEntity(var7);
                  if(var9 instanceof TileEntityChest) {
                     if(var6 != EnumFacing.WEST && var6 != EnumFacing.NORTH) {
                        var4 = new vp("container.chestDouble", (vy)var4, (TileEntityChest)var9);
                     } else {
                        var4 = new vp("container.chestDouble", (TileEntityChest)var9, (vy)var4);
                     }
                  }
               }
            }

            return (vy)var4;
         }
      }
   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityChest();
   }

   public boolean isPowerSource() {
      return this.b == 1;
   }

   public int a(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
      if(!this.isPowerSource()) {
         return 0;
      } else {
         int var5 = 0;
         TileEntity var6 = var1.getTileEntity(var2);
         if(var6 instanceof TileEntityChest) {
            var5 = ((TileEntityChest)var6).l;
         }

         return MathHelper.a(var5, 0, 15);
      }
   }

   public int b(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
      return var4 == EnumFacing.UP?this.a(var1, var2, var3, var4):0;
   }

   private boolean m(World var1, Location var2) {
      return this.n(var1, var2) || this.o(var1, var2);
   }

   private boolean n(World var1, Location var2) {
      return var1.getData(var2.a()).c().t();
   }

   private boolean o(World var1, Location var2) {
      Iterator var3 = var1.getEntities(EntityOcelot.class, new AxisAlignedBB((double)var2.n(), (double)(var2.o() + 1), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 2), (double)(var2.p() + 1))).iterator();

      EntityOcelot var5;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         Entity var4 = (Entity)var3.next();
         var5 = (EntityOcelot)var4;
      } while(!var5.cl());

      return true;
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getDropData(World var1, Location var2) {
      return aib.b((IInventory)this.d(var1, var2));
   }

   public IBlockData a(int var1) {
      EnumFacing var2 = EnumFacing.a(var1);
      if(var2.k() == el.b) {
         var2 = EnumFacing.NORTH;
      }

      return this.P().a(a, var2);
   }

   public int c(IBlockData var1) {
      return ((EnumFacing)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
