package net.minecraft.server;


public class EntityWitherSkull extends EntityFireball {

   public EntityWitherSkull(World var1) {
      super(var1);
      this.a(0.3125F, 0.3125F);
   }

   public EntityWitherSkull(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
      this.a(0.3125F, 0.3125F);
   }

   protected float j() {
      return this.l()?0.73F:super.j();
   }

   public boolean au() {
      return false;
   }

   public float a(aqo var1, World var2, Location var3, IBlock var4) {
      float var5 = super.a(var1, var2, var3, var4);
      if(this.l() && var4.c() != aty.h && var4.c() != aty.bF && var4.c() != aty.bG && var4.c() != aty.bX) {
         var5 = Math.min(0.8F, var5);
      }

      return var5;
   }

   protected void a(bru var1) {
      if(!this.o.D) {
         if(var1.d != null) {
            if(this.a != null) {
               if(var1.d.a(DamageSource.a(this.a), 8.0F)) {
                  if(!var1.d.ai()) {
                     this.a.g(5.0F);
                  } else {
                     this.a(this.a, var1.d);
                  }
               }
            } else {
               var1.d.a(DamageSource.l, 5.0F);
            }

            if(var1.d instanceof EntityLiving) {
               byte var2 = 0;
               if(this.o.aa() == EnumDifficulty.NORMAL) {
                  var2 = 10;
               } else if(this.o.aa() == EnumDifficulty.HARD) {
                  var2 = 40;
               }

               if(var2 > 0) {
                  ((EntityLiving)var1.d).c(new wq(wp.v.H, 20 * var2, 1));
               }
            }
         }

         this.o.a(this, this.s, this.t, this.u, 1.0F, false, this.o.Q().b("mobGriefing"));
         this.J();
      }

   }

   public boolean ad() {
      return false;
   }

   public boolean a(DamageSource var1, float var2) {
      return false;
   }

   protected void h() {
      this.ac.a(10, Byte.valueOf((byte)0));
   }

   public boolean l() {
      return this.ac.a(10) == 1;
   }

   public void a(boolean var1) {
      this.ac.b(10, Byte.valueOf((byte)(var1?1:0)));
   }
}
