package net.minecraft.server;


public class EntityEnderCrystal extends Entity {

   public int a;
   public int b;


   public EntityEnderCrystal(World var1) {
      super(var1);
      this.k = true;
      this.a(2.0F, 2.0F);
      this.b = 5;
      this.a = this.V.nextInt(100000);
   }

   protected boolean r_() {
      return false;
   }

   protected void h() {
      this.ac.a(8, Integer.valueOf(this.b));
   }

   public void s_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      ++this.a;
      this.ac.b(8, Integer.valueOf(this.b));
      int var1 = MathHelper.floor(this.s);
      int var2 = MathHelper.floor(this.t);
      int var3 = MathHelper.floor(this.u);
      if(this.o.worldProvider instanceof bgh && this.o.getData(new Location(var1, var2, var3)).c() != Blocks.FIRE) {
         this.o.a(new Location(var1, var2, var3), Blocks.FIRE.P());
      }

   }

   protected void b(NBTTagCompound var1) {}

   protected void a(NBTTagCompound var1) {}

   public boolean ad() {
      return true;
   }

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         if(!this.I && !this.o.isStatic) {
            this.b = 0;
            if(this.b <= 0) {
               this.J();
               if(!this.o.isStatic) {
                  this.o.explode((Entity)null, this.s, this.t, this.u, 6.0F, true);
               }
            }
         }

         return true;
      }
   }
}
