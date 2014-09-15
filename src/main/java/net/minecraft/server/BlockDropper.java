package net.minecraft.server;

public class BlockDropper extends BlockDispenser {

   private final IDispenseBehavior O = new DispenserBehaviorItem();


   protected IDispenseBehavior a(ItemStack var1) {
      return this.O;
   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityDropper();
   }

   protected void d(World var1, Location var2) {
      SourceBlock var3 = new SourceBlock(var1, var2);
      TileEntityDispenser var4 = (TileEntityDispenser)var3.h();
      if(var4 != null) {
         int var5 = var4.m();
         if(var5 < 0) {
            var1.b(1001, var2, 0);
         } else {
            ItemStack var6 = var4.a(var5);
            if(var6 != null) {
               EnumFacing var7 = (EnumFacing)var1.getData(var2).b(a);
               Location var8 = var2.a(var7);
               IInventory var9 = TileEntityHopper.b(var1, (double)var8.n(), (double)var8.o(), (double)var8.p());
               ItemStack var10;
               if(var9 == null) {
                  var10 = this.O.a(var3, var6);
                  if(var10 != null && var10.b == 0) {
                     var10 = null;
                  }
               } else {
                  var10 = TileEntityHopper.a(var9, var6.k().a(1), var7.d());
                  if(var10 == null) {
                     var10 = var6.k();
                     if(--var10.b == 0) {
                        var10 = null;
                     }
                  } else {
                     var10 = var6.k();
                  }
               }

               var4.a(var5, var10);
            }
         }
      }
   }
}
