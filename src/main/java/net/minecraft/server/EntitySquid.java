package net.minecraft.server;
import java.io.IOException;


public class EntitySquid extends EntityWaterAnimal {

   public float a;
   public float b;
   public float c;
   public float bi;
   public float bj;
   public float bk;
   public float bl;
   public float bm;
   private float bn;
   private float bo;
   private float bp;
   private float bq;
   private float br;
   private float bs;


   public EntitySquid(World var1) {
      super(var1);
      this.a(0.95F, 0.95F);
      this.V.setSeed((long)(1 + this.F()));
      this.bo = 1.0F / (this.V.nextFloat() + 1.0F) * 0.2F;
      this.goalSelector.a(0, new acp(this));
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(10.0D);
   }

   public float aR() {
      return this.K * 0.5F;
   }

   protected String z() {
      return null;
   }

   protected String bn() {
      return null;
   }

   protected String bo() {
      return null;
   }

   protected float bA() {
      return 0.4F;
   }

   protected Item A() {
      return null;
   }

   protected boolean r_() {
      return false;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3 + var2) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(new ItemStack(Items.aW, 1, akv.p.b()), 0.0F);
      }

   }

   public boolean V() {
      return this.o.a(this.aQ().b(0.0D, -0.6000000238418579D, 0.0D), Material.WATER, (Entity)this);
   }

   public void m() throws IOException {
      super.m();
      this.b = this.a;
      this.bi = this.c;
      this.bk = this.bj;
      this.bm = this.bl;
      this.bj += this.bo;
      if((double)this.bj > 6.283185307179586D) {
         if(this.o.isStatic) {
            this.bj = 6.2831855F;
         } else {
            this.bj = (float)((double)this.bj - 6.283185307179586D);
            if(this.V.nextInt(10) == 0) {
               this.bo = 1.0F / (this.V.nextFloat() + 1.0F) * 0.2F;
            }

            this.o.broadcastEntityEffect((Entity)this, (byte)19);
         }
      }

      if(this.Y) {
         float var1;
         if(this.bj < 3.1415927F) {
            var1 = this.bj / 3.1415927F;
            this.bl = MathHelper.sin(var1 * var1 * 3.1415927F) * 3.1415927F * 0.25F;
            if((double)var1 > 0.75D) {
               this.bn = 1.0F;
               this.bp = 1.0F;
            } else {
               this.bp *= 0.8F;
            }
         } else {
            this.bl = 0.0F;
            this.bn *= 0.9F;
            this.bp *= 0.99F;
         }

         if(!this.o.isStatic) {
            this.v = (double)(this.bq * this.bn);
            this.w = (double)(this.br * this.bn);
            this.x = (double)(this.bs * this.bn);
         }

         var1 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
         this.aG += (-((float)Math.atan2(this.v, this.x)) * 180.0F / 3.1415927F - this.aG) * 0.1F;
         this.y = this.aG;
         this.c = (float)((double)this.c + 3.141592653589793D * (double)this.bp * 1.5D);
         this.a += (-((float)Math.atan2((double)var1, this.w)) * 180.0F / 3.1415927F - this.a) * 0.1F;
      } else {
         this.bl = MathHelper.e(MathHelper.sin(this.bj)) * 3.1415927F * 0.25F;
         if(!this.o.isStatic) {
            this.v = 0.0D;
            this.w -= 0.08D;
            this.w *= 0.9800000190734863D;
            this.x = 0.0D;
         }

         this.a = (float)((double)this.a + (double)(-90.0F - this.a) * 0.02D);
      }

   }

   public void g(float var1, float var2) {
      this.d(this.v, this.w, this.x);
   }

   public boolean bQ() {
      return this.t > 45.0D && this.t < 63.0D && super.bQ();
   }

   public void b(float var1, float var2, float var3) {
      this.bq = var1;
      this.br = var2;
      this.bs = var3;
   }

   public boolean n() {
      return this.bq != 0.0F || this.br != 0.0F || this.bs != 0.0F;
   }

   // $FF: synthetic method
   static boolean a(EntitySquid var0) {
      return var0.Y;
   }
}
