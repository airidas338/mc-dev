package net.minecraft.server;
import java.io.IOException;


public class EntityMushroomCow extends EntityCow {

   public EntityMushroomCow(World var1) {
      super(var1);
      this.a(0.9F, 1.3F);
      this.bl = Blocks.MYCEL;
   }

   public boolean a(EntityHuman var1) {
      ItemStack var2 = var1.bg.h();
      if(var2 != null && var2.getItem() == Items.BOWL && this.l() >= 0) {
         if(var2.count == 1) {
            var1.bg.a(var1.bg.c, new ItemStack(Items.MUSHROOM_SOUP));
            return true;
         }

         if(var1.bg.a(new ItemStack(Items.MUSHROOM_SOUP)) && !var1.abilities.canInstantlyBuild) {
            var1.bg.a(var1.bg.c, 1);
            return true;
         }
      }

      if(var2 != null && var2.getItem() == Items.be && this.l() >= 0) {
         this.J();
         this.o.a(EnumParticleEffect.b, this.s, this.t + (double)(this.K / 2.0F), this.u, 0.0D, 0.0D, 0.0D, new int[0]);
         if(!this.o.isStatic) {
            EntityCow var3 = new EntityCow(this.o);
            var3.setPositionRotation(this.s, this.t, this.u, this.y, this.z);
            var3.h(this.bm());
            var3.aG = this.aG;
            if(this.k_()) {
               var3.a(this.aL());
            }

            this.o.addEntity((Entity)var3);

            for(int var4 = 0; var4 < 5; ++var4) {
               this.o.addEntity((Entity)(new EntityItem(this.o, this.s, this.t + (double)this.K, this.u, new ItemStack(Blocks.RED_MUSHROOM))));
            }

            var2.damage(1, (EntityLiving)var1);
            this.a("mob.sheep.shear", 1.0F, 1.0F);
         }

         return true;
      } else {
         return super.a(var1);
      }
   }

   public EntityMushroomCow c(EntityAgeable var1) {
      return new EntityMushroomCow(this.o);
   }

   // $FF: synthetic method
   public EntityCow b(EntityAgeable var1) {
      return this.c(var1);
   }

   // $FF: synthetic method
   public EntityAgeable a(EntityAgeable var1) {
      return this.c(var1);
   }
}
