package net.minecraft.server;


public class aab extends PathfinderGoal {

   private EntityCreature a;


   public aab(EntityCreature var1) {
      this.a = var1;
   }

   public boolean a() {
      return this.a.o.w();
   }

   public void c() {
      ((aay)this.a.getNavigation()).e(true);
   }

   public void d() {
      ((aay)this.a.getNavigation()).e(false);
   }
}
