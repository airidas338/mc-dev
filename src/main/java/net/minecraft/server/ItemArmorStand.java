package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class ItemArmorStand extends Item {

   public ItemArmorStand() {
      this.a(CreativeModeTab.c);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var5 == EnumFacing.DOWN) {
         return false;
      } else {
         boolean var9 = var3.getData(var4).c().f(var3, var4);
         Location var10 = var9?var4:var4.a(var5);
         if(!var2.a(var10, var5, var1)) {
            return false;
         } else {
            Location var11 = var10.a();
            boolean var12 = !var3.isEmpty(var10) && !var3.getData(var10).c().f(var3, var10);
            var12 |= !var3.isEmpty(var11) && !var3.getData(var11).c().f(var3, var11);
            if(var12) {
               return false;
            } else {
               double var13 = (double)var10.n();
               double var15 = (double)var10.o();
               double var17 = (double)var10.p();
               List var19 = var3.b((Entity)null, AxisAlignedBB.a(var13, var15, var17, var13 + 1.0D, var15 + 2.0D, var17 + 1.0D));
               if(var19.size() > 0) {
                  return false;
               } else {
                  if(!var3.isStatic) {
                     var3.setAir(var10);
                     var3.setAir(var11);
                     EntityArmorStand var20 = new EntityArmorStand(var3, var13 + 0.5D, var15, var17 + 0.5D);
                     float var21 = (float)MathHelper.d((MathHelper.g(var2.y - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                     var20.setPositionRotation(var13 + 0.5D, var15, var17 + 0.5D, var21, 0.0F);
                     this.a(var20, var3.random);
                     NBTTagCompound var22 = var1.getTag();
                     if(var22 != null && var22.hasKeyOfType("EntityTag", 10)) {
                        NBTTagCompound var23 = new NBTTagCompound();
                        var20.d(var23);
                        var23.a(var22.getCompound("EntityTag"));
                        var20.f(var23);
                     }

                     var3.addEntity((Entity)var20);
                  }

                  --var1.count;
                  return true;
               }
            }
         }
      }
   }

   private void a(EntityArmorStand var1, Random var2) {
      fa var3 = var1.s();
      float var5 = var2.nextFloat() * 5.0F;
      float var6 = var2.nextFloat() * 20.0F - 10.0F;
      fa var4 = new fa(var3.b() + var5, var3.c() + var6, var3.d());
      var1.a(var4);
      var3 = var1.t();
      var5 = var2.nextFloat() * 10.0F - 5.0F;
      var4 = new fa(var3.b(), var3.c() + var5, var3.d());
      var1.b(var4);
   }
}
