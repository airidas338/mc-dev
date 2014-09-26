package net.minecraft.server;
import com.google.common.base.Predicate;

import java.util.Random;

public class BlockFurnace extends BlockContainer {

   public static final beu a = beu.a("facing", (Predicate)en.a);
   private final boolean b;
   private static boolean M;


   protected BlockFurnace(boolean var1) {
      super(Material.STONE);
      this.j(this.L.b().a(a, EnumFacing.NORTH));
      this.b = var1;
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf(Blocks.FURNACE);
   }

   public void onPlace(World var1, Location var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   private void e(World var1, Location var2, IBlockData var3) {
      if(!var1.isStatic) {
         Block var4 = var1.getData(var2.c()).c();
         Block var5 = var1.getData(var2.d()).c();
         Block var6 = var1.getData(var2.e()).c();
         Block var7 = var1.getData(var2.f()).c();
         EnumFacing var8 = (EnumFacing)var3.b(a);
         if(var8 == EnumFacing.NORTH && var4.m() && !var5.m()) {
            var8 = EnumFacing.SOUTH;
         } else if(var8 == EnumFacing.SOUTH && var5.m() && !var4.m()) {
            var8 = EnumFacing.NORTH;
         } else if(var8 == EnumFacing.WEST && var6.m() && !var7.m()) {
            var8 = EnumFacing.EAST;
         } else if(var8 == EnumFacing.EAST && var7.m() && !var6.m()) {
            var8 = EnumFacing.WEST;
         }

         var1.setTypeAndData(var2, var3.a(a, var8), 2);
      }
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var1.isStatic) {
         return true;
      } else {
         TileEntity var9 = var1.getTileEntity(var2);
         if(var9 instanceof TileEntityFurnace) {
            var4.a((IInventory)((TileEntityFurnace)var9));
         }

         return true;
      }
   }

   public static void a(boolean var0, World var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      TileEntity var4 = var1.getTileEntity(var2);
      M = true;
      if(var0) {
         var1.setTypeAndData(var2, Blocks.BURNING_FURNACE.P().a(a, var3.b(a)), 3);
         var1.setTypeAndData(var2, Blocks.BURNING_FURNACE.P().a(a, var3.b(a)), 3);
      } else {
         var1.setTypeAndData(var2, Blocks.FURNACE.P().a(a, var3.b(a)), 3);
         var1.setTypeAndData(var2, Blocks.FURNACE.P().a(a, var3.b(a)), 3);
      }

      M = false;
      if(var4 != null) {
         var4.D();
         var1.setTileEntity(var2, var4);
      }

   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityFurnace();
   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(a, var8.aO().d());
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      var1.setTypeAndData(var2, var3.a(a, var4.aO().d()), 2);
      if(var5.hasName()) {
         TileEntity var6 = var1.getTileEntity(var2);
         if(var6 instanceof TileEntityFurnace) {
            ((TileEntityFurnace)var6).a(var5.getName());
         }
      }

   }

   public void remove(World var1, Location var2, IBlockData var3) {
      if(!M) {
         TileEntity var4 = var1.getTileEntity(var2);
         if(var4 instanceof TileEntityFurnace) {
            vs.a(var1, var2, (TileEntityFurnace)var4);
            var1.updateAdjacentComparators(var2, this);
         }
      }

      super.remove(var1, var2, var3);
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getDropData(World var1, Location var2) {
      return aib.a(var1.getTileEntity(var2));
   }

   public int b() {
      return 3;
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
