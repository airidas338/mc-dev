package net.minecraft.server;


public class BlockJukeBox extends BlockContainer {

   public static final bet a = bet.a("has_record");


   protected BlockJukeBox() {
      super(Material.WOOD);
      this.j(this.L.b().a(a, Boolean.valueOf(false)));
      this.a(CreativeModeTab.c);
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(((Boolean)var3.b(a)).booleanValue()) {
         this.dropRecord(var1, var2, var3);
         var3 = var3.a(a, Boolean.valueOf(false));
         var1.setTypeAndData(var2, var3, 2);
         return true;
      } else {
         return false;
      }
   }

   public void a(World var1, Location var2, IBlockData var3, ItemStack var4) {
      if(!var1.isStatic) {
         TileEntity var5 = var1.getTileEntity(var2);
         if(var5 instanceof TileEntityRecordPlayer) {
            ((TileEntityRecordPlayer)var5).a(new ItemStack(var4.b(), 1, var4.i()));
            var1.setTypeAndData(var2, var3.a(a, Boolean.valueOf(true)), 2);
         }
      }
   }

   private void dropRecord(World var1, Location var2, IBlockData var3) {
      if(!var1.isStatic) {
         TileEntity var4 = var1.getTileEntity(var2);
         if(var4 instanceof TileEntityRecordPlayer) {
            TileEntityRecordPlayer var5 = (TileEntityRecordPlayer)var4;
            ItemStack var6 = var5.a();
            if(var6 != null) {
               var1.triggerEffect(1005, var2, 0);
               var1.a(var2, (String)null);
               var5.a((ItemStack)null);
               float var7 = 0.7F;
               double var8 = (double)(var1.random.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               double var10 = (double)(var1.random.nextFloat() * var7) + (double)(1.0F - var7) * 0.2D + 0.6D;
               double var12 = (double)(var1.random.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
               ItemStack var14 = var6.k();
               EntityItem var15 = new EntityItem(var1, (double)var2.n() + var8, (double)var2.o() + var10, (double)var2.p() + var12, var14);
               var15.p();
               var1.addEntity((Entity)var15);
            }
         }
      }
   }

   public void remove(World var1, Location var2, IBlockData var3) {
      this.dropRecord(var1, var2, var3);
      super.remove(var1, var2, var3);
   }

   public void dropNaturally(World var1, Location var2, IBlockData var3, float var4, int var5) {
      if(!var1.isStatic) {
         super.dropNaturally(var1, var2, var3, var4, 0);
      }
   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityRecordPlayer();
   }

   public boolean isComplexRedstone() {
      return true;
   }

   public int getDropData(World var1, Location var2) {
      TileEntity var3 = var1.getTileEntity(var2);
      if(var3 instanceof TileEntityRecordPlayer) {
         ItemStack var4 = ((TileEntityRecordPlayer)var3).a();
         if(var4 != null) {
            return Item.b(var4.b()) + 1 - Item.b(Items.cq);
         }
      }

      return 0;
   }

   public int b() {
      return 3;
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Boolean.valueOf(var1 > 0));
   }

   public int c(IBlockData var1) {
      return ((Boolean)var1.b(a)).booleanValue()?1:0;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
