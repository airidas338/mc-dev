package net.minecraft.server;


public class yl {

   private EntityInsentient b;
   protected boolean a;


   public yl(EntityInsentient var1) {
      this.b = var1;
   }

   public void a() {
      this.a = true;
   }

   public void b() {
      this.b.i(this.a);
      this.a = false;
   }
}
