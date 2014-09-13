package net.minecraft.server;


public class EntityThrownExpBottle extends EntityProjectile {

   public EntityThrownExpBottle(World var1) {
      super(var1);
   }

   public EntityThrownExpBottle(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   public EntityThrownExpBottle(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected float m() {
      return 0.07F;
   }

   protected float j() {
      return 0.7F;
   }

   protected float l() {
      return -20.0F;
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.o.D) {
         this.o.b(2002, new Location(this), 0);
         int var2 = 3 + this.o.s.nextInt(5) + this.o.s.nextInt(5);

         while(var2 > 0) {
            int var3 = EntityExperienceOrb.a(var2);
            var2 -= var3;
            this.o.d((Entity)(new EntityExperienceOrb(this.o, this.s, this.t, this.u, var3)));
         }

         this.J();
      }

   }
}
