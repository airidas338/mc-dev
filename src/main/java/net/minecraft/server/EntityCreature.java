package net.minecraft.server;

import java.util.UUID;

public abstract class EntityCreature extends EntityInsentient {

   public static final UUID bi = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
   public static final ya bj = (new ya(bi, "Fleeing speed bonus", 2.0D, 2)).a(false);
   private Location a;
   private float b;
   private PathfinderGoal c;
   private boolean bk;


   public EntityCreature(World var1) {
      super(var1);
      this.a = Location.a;
      this.b = -1.0F;
      this.c = new PathfinderGoalMoveTowardsRestriction(this, 1.0D);
   }

   public float a(Location var1) {
      return 0.0F;
   }

   public boolean bQ() {
      return super.bQ() && this.a(new Location(this.s, this.aQ().b, this.u)) >= 0.0F;
   }

   public boolean cd() {
      return !this.h.m();
   }

   public boolean ce() {
      return this.d(new Location(this));
   }

   public boolean d(Location var1) {
      return this.b == -1.0F?true:this.a.i(var1) < (double)(this.b * this.b);
   }

   public void a(Location var1, int var2) {
      this.a = var1;
      this.b = (float)var2;
   }

   public Location cf() {
      return this.a;
   }

   public float cg() {
      return this.b;
   }

   public void ch() {
      this.b = -1.0F;
   }

   public boolean ci() {
      return this.b != -1.0F;
   }

   protected void bZ() {
      super.bZ();
      if(this.cb() && this.cc() != null && this.cc().o == this.o) {
         Entity var1 = this.cc();
         this.a(new Location((int)var1.s, (int)var1.t, (int)var1.u), 5);
         float var2 = this.g(var1);
         if(this instanceof EntityTameableAnimal && ((EntityTameableAnimal)this).cl()) {
            if(var2 > 10.0F) {
               this.a(true, true);
            }

            return;
         }

         if(!this.bk) {
            this.goalSelector.a(2, this.c);
            if(this.getNavigation() instanceof aay) {
               ((aay)this.getNavigation()).save(false);
            }

            this.bk = true;
         }

         this.n(var2);
         if(var2 > 4.0F) {
            this.getNavigation().a(var1, 1.0D);
         }

         if(var2 > 6.0F) {
            double var3 = (var1.s - this.s) / (double)var2;
            double var5 = (var1.t - this.t) / (double)var2;
            double var7 = (var1.u - this.u) / (double)var2;
            this.v += var3 * Math.abs(var3) * 0.4D;
            this.w += var5 * Math.abs(var5) * 0.4D;
            this.x += var7 * Math.abs(var7) * 0.4D;
         }

         if(var2 > 10.0F) {
            this.a(true, true);
         }
      } else if(!this.cb() && this.bk) {
         this.bk = false;
         this.goalSelector.a(this.c);
         if(this.getNavigation() instanceof aay) {
            ((aay)this.getNavigation()).save(true);
         }

         this.ch();
      }

   }

   protected void n(float var1) {}

}
