package net.minecraft.server;



public class PathfinderGoalMoveTowardsTarget extends PathfinderGoal {

   private EntityCreature a;
   private EntityLiving b;
   private double c;
   private double d;
   private double e;
   private double f;
   private float g;


   public PathfinderGoalMoveTowardsTarget(EntityCreature var1, double var2, float var4) {
      this.a = var1;
      this.f = var2;
      this.g = var4;
      this.a(1);
   }

   public boolean a() {
      this.b = this.a.u();
      if(this.b == null) {
         return false;
      } else if(this.b.h(this.a) > (double)(this.g * this.g)) {
         return false;
      } else {
         Vec3D var1 = abf.a(this.a, 16, 7, new Vec3D(this.b.s, this.b.t, this.b.u));
         if(var1 == null) {
            return false;
         } else {
            this.c = var1.a;
            this.d = var1.b;
            this.e = var1.c;
            return true;
         }
      }
   }

   public boolean b() {
      return !this.a.getNavigation().m() && this.b.isAlive() && this.b.h(this.a) < (double)(this.g * this.g);
   }

   public void d() {
      this.b = null;
   }

   public void c() {
      this.a.getNavigation().a(this.c, this.d, this.e, this.f);
   }
}
