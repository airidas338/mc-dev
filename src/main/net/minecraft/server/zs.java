package net.minecraft.server;



public class zs extends zb {

   private EntityIronGolem a;
   private EntityVillager b;
   private int c;


   public zs(EntityIronGolem var1) {
      this.a = var1;
      this.a(3);
   }

   public boolean a() {
      if(!this.a.o.w()) {
         return false;
      } else if(this.a.bb().nextInt(8000) != 0) {
         return false;
      } else {
         this.b = (EntityVillager)this.a.o.a(EntityVillager.class, this.a.aQ().b(6.0D, 2.0D, 6.0D), (Entity)this.a);
         return this.b != null;
      }
   }

   public boolean b() {
      return this.c > 0;
   }

   public void c() {
      this.c = 400;
      this.a.a(true);
   }

   public void d() {
      this.a.a(false);
      this.b = null;
   }

   public void e() {
      this.a.p().a(this.b, 30.0F, 30.0F);
      --this.c;
   }
}
