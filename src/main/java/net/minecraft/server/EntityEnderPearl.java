package net.minecraft.server;
import java.io.IOException;


public class EntityEnderPearl extends EntityProjectile {

   public EntityEnderPearl(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   protected void a(MovingObjectPosition var1) {
      EntityLiving var2 = this.n();
      if(var1.d != null) {
         var1.d.a(DamageSource.a((Entity)this, var2), 0.0F);
      }

      for(int var3 = 0; var3 < 32; ++var3) {
         this.o.a(ew.y, this.s, this.t + this.V.nextDouble() * 2.0D, this.u, this.V.nextGaussian(), 0.0D, this.V.nextGaussian(), new int[0]);
      }

      if(!this.o.D) {
         if(var2 instanceof EntityPlayer) {
            EntityPlayer var5 = (EntityPlayer)var2;
            if(var5.a.a().isConnected() && var5.o == this.o && !var5.bI()) {
               if(this.V.nextFloat() < 0.05F && this.o.Q().b("doMobSpawning")) {
                  EntityEndermite var4 = new EntityEndermite(this.o);
                  var4.a(true);
                  var4.setPositionRotation(var2.s, var2.t, var2.u, var2.y, var2.z);
                  this.o.d((Entity)var4);
               }

               if(var2.av()) {
                  var2.a((Entity)null);
               }

               var2.a(this.s, this.t, this.u);
               var2.O = 0.0F;
               var2.a(DamageSource.i, 5.0F);
            }
         }

         this.J();
      }

   }

   public void s_() throws IOException {
      EntityLiving var1 = this.n();
      if(var1 != null && var1 instanceof EntityHuman && !var1.isAlive()) {
         this.J();
      } else {
         super.s_();
      }

   }
}
