package net.minecraft.server;


class acp extends PathfinderGoal {

   private EntitySquid a;


   public acp(EntitySquid var1) {
      this.a = var1;
   }

   public boolean a() {
      return true;
   }

   public void e() {
      int var1 = this.a.bg();
      if(var1 > 100) {
         this.a.b(0.0F, 0.0F, 0.0F);
      } else if(this.a.bb().nextInt(50) == 0 || !EntitySquid.a(this.a) || !this.a.n()) {
         float var2 = this.a.bb().nextFloat() * 3.1415927F * 2.0F;
         float var3 = MathHelper.cos(var2) * 0.2F;
         float var4 = -0.1F + this.a.bb().nextFloat() * 0.2F;
         float var5 = MathHelper.sin(var2) * 0.2F;
         this.a.b(var3, var4, var5);
      }

   }
}
