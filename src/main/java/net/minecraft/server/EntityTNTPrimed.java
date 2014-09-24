package net.minecraft.server;


public class EntityTNTPrimed extends Entity {

   public int a;
   private EntityLiving b;


   public EntityTNTPrimed(World var1) {
      super(var1);
      this.k = true;
      this.a(0.98F, 0.98F);
   }

   public EntityTNTPrimed(World var1, double var2, double var4, double var6, EntityLiving var8) {
      this(var1);
      this.b(var2, var4, var6);
      float var9 = (float)(Math.random() * 3.1415927410125732D * 2.0D);
      this.v = (double)(-((float)Math.sin((double)var9)) * 0.02F);
      this.w = 0.20000000298023224D;
      this.x = (double)(-((float)Math.cos((double)var9)) * 0.02F);
      this.a = 80;
      this.p = var2;
      this.q = var4;
      this.r = var6;
      this.b = var8;
   }

   protected void h() {}

   protected boolean r_() {
      return false;
   }

   public boolean ad() {
      return !this.I;
   }

   public void s_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.w -= 0.03999999910593033D;
      this.d(this.v, this.w, this.x);
      this.v *= 0.9800000190734863D;
      this.w *= 0.9800000190734863D;
      this.x *= 0.9800000190734863D;
      if(this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
         this.w *= -0.5D;
      }

      if(this.a-- <= 0) {
         this.J();
         if(!this.o.isStatic) {
            this.l();
         }
      } else {
         this.W();
         this.o.a(EnumParticleEffect.l, this.s, this.t + 0.5D, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   private void l() {
      float var1 = 4.0F;
      this.o.explode(this, this.s, this.t + (double)(this.K / 2.0F), this.u, var1, true);
   }

   protected void b(NBTTagCompound var1) {
      var1.setByte("Fuse", (byte)this.a);
   }

   protected void a(NBTTagCompound var1) {
      this.a = var1.getByte("Fuse");
   }

   public EntityLiving j() {
      return this.b;
   }

   public float aR() {
      return 0.0F;
   }
}
