package net.minecraft.server;


class aga extends PathfinderGoal {

   private EntitySlime a;


   public aga(EntitySlime var1) {
      this.a = var1;
      this.a(5);
      ((aay)var1.getNavigation()).d(true);
   }

   public boolean a() {
      return this.a.V() || this.a.ab();
   }

   public void e() {
      if(this.a.bb().nextFloat() < 0.8F) {
         this.a.r().a();
      }

      ((agc)this.a.q()).a(1.2D);
   }
}
