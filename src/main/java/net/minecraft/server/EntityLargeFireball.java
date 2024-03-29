package net.minecraft.server;


public class EntityLargeFireball extends EntityFireball {

   public int e = 1;


   public EntityLargeFireball(World var1) {
      super(var1);
   }

   public EntityLargeFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.o.isStatic) {
         if(var1.d != null) {
            var1.d.a(DamageSource.a((EntityFireball)this, this.a), 6.0F);
            this.a(this.a, var1.d);
         }

         boolean var2 = this.o.getGameRules().getBoolean("mobGriefing");
         this.o.createExplosion((Entity)null, this.s, this.t, this.u, (float)this.e, var2, var2);
         this.J();
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("ExplosionPower", this.e);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasKeyOfType("ExplosionPower", 99)) {
         this.e = var1.getInt("ExplosionPower");
      }

   }
}
