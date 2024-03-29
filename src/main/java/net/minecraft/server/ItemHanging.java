package net.minecraft.server;


public class ItemHanging extends Item {

   private final Class a;


   public ItemHanging(Class var1) {
      this.a = var1;
      this.a(CreativeModeTab.c);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var5 == EnumFacing.DOWN) {
         return false;
      } else if(var5 == EnumFacing.UP) {
         return false;
      } else {
         Location var9 = var4.a(var5);
         if(!var2.a(var9, var5, var1)) {
            return false;
         } else {
            EntityHanging var10 = this.a(var3, var9, var5);
            if(var10 != null && var10.j()) {
               if(!var3.isStatic) {
                  var3.addEntity((Entity)var10);
               }

               --var1.count;
            }

            return true;
         }
      }
   }

   private EntityHanging a(World var1, Location var2, EnumFacing var3) {
      return (EntityHanging)(this.a == EntityPainting.class?new EntityPainting(var1, var2, var3):(this.a == EntityItemFrame.class?new EntityItemFrame(var1, var2, var3):null));
   }
}
