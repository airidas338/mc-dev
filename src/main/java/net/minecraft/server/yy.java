package net.minecraft.server;



public class yy extends PathfinderGoal {

   private EntityInsentient a;


   public yy(EntityInsentient var1) {
      this.a = var1;
      this.a(4);
      ((aay)var1.getNavigation()).d(true);
   }

   public boolean a() {
      return this.a.V() || this.a.ab();
   }

   public void e() {
      if(this.a.bb().nextFloat() < 0.8F) {
         this.a.r().a();
      }

   }
}
