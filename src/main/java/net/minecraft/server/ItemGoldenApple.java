package net.minecraft.server;


public class ItemGoldenApple extends ItemFood {

   public ItemGoldenApple(int var1, float var2, boolean var3) {
      super(var1, var2, var3);
      this.a(true);
   }

   public EnumItemRarity g(ItemStack var1) {
      return var1.getData() == 0?EnumItemRarity.RARE:EnumItemRarity.EPIC;
   }

   protected void c(ItemStack var1, World var2, EntityHuman var3) {
      if(!var2.isStatic) {
         var3.c(new MobEffect(MobEffectList.x.H, 2400, 0));
      }

      if(var1.getData() > 0) {
         if(!var2.isStatic) {
            var3.c(new MobEffect(MobEffectList.l.H, 600, 4));
            var3.c(new MobEffect(MobEffectList.m.H, 6000, 0));
            var3.c(new MobEffect(MobEffectList.n.H, 6000, 0));
         }
      } else {
         super.c(var1, var2, var3);
      }

   }
}
