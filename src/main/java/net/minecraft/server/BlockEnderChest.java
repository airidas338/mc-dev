package net.minecraft.server;
import com.google.common.base.Predicate;

import java.util.Random;

public class BlockEnderChest extends BlockContainer {

   public static final beu a = beu.a("facing", (Predicate)en.a);


   protected BlockEnderChest() {
      super(Material.STONE);
      this.j(this.L.b().a(a, EnumFacing.NORTH));
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

   public Item a(IBlockData var1, Random var2, int var3) {
      return Item.getItemOf(Blocks.OBSIDIAN);
   }

   public int a(Random var1) {
      return 8;
   }

   protected boolean G() {
      return true;
   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(a, var8.aO().d());
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      var1.setTypeAndData(var2, var3.a(a, var4.aO().d()), 2);
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      ajh var9 = var4.cn();
      TileEntity var10 = var1.getTileEntity(var2);
      if(var9 != null && var10 instanceof TileEntityEnderChest) {
         if(var1.getData(var2.a()).c().t()) {
            return true;
         } else if(var1.isStatic) {
            return true;
         } else {
            var9.a((TileEntityEnderChest)var10);
            var4.a((IInventory)var9);
            return true;
         }
      } else {
         return true;
      }
   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityEnderChest();
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
