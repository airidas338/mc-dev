package net.minecraft.server;
import java.io.IOException;


public class EntityEndermite extends EntityMonster {

   private int b = 0;
   private boolean c = false;


   public EntityEndermite(World var1) {
      super(var1);
      this.b_ = 3;
      this.a(0.4F, 0.3F);
      this.i.a(1, new yy(this));
      this.i.a(2, new zk(this, EntityHuman.class, 1.0D, false));
      this.i.a(3, new zy(this, 1.0D));
      this.i.a(7, new zh(this, EntityHuman.class, 8.0F));
      this.i.a(8, new zx(this));
      this.bg.a(1, new aal(this, true, new Class[0]));
      this.bg.a(2, new aaq(this, EntityHuman.class, true));
   }

   public float aR() {
      return 0.1F;
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(8.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.25D);
      this.getAttributeInstance(GenericAttributes.e).a(2.0D);
   }

   protected boolean r_() {
      return false;
   }

   protected String z() {
      return "mob.silverfish.say";
   }

   protected String bn() {
      return "mob.silverfish.hit";
   }

   protected String bo() {
      return "mob.silverfish.kill";
   }

   protected void a(Location var1, Block var2) {
      this.a("mob.silverfish.step", 0.15F, 1.0F);
   }

   protected alq A() {
      return null;
   }

   public void a(fn var1) {
      super.a(var1);
      this.b = var1.f("Lifetime");
      this.c = var1.n("PlayerSpawned");
   }

   public void b(fn var1) {
      super.b(var1);
      var1.a("Lifetime", this.b);
      var1.a("PlayerSpawned", this.c);
   }

   public void s_() throws IOException {
      this.aG = this.y;
      super.s_();
   }

   public boolean n() {
      return this.c;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public void m() throws IOException {
      super.m();
      if(this.o.D) {
         for(int var1 = 0; var1 < 2; ++var1) {
            this.o.a(ew.y, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, (this.V.nextDouble() - 0.5D) * 2.0D, -this.V.nextDouble(), (this.V.nextDouble() - 0.5D) * 2.0D, new int[0]);
         }
      } else {
         if(!this.bY()) {
            ++this.b;
         }

         if(this.b >= 2400) {
            this.J();
         }
      }

   }

   protected boolean m_() {
      return true;
   }

   public boolean bQ() {
      if(super.bQ()) {
         EntityHuman var1 = this.o.a(this, 5.0D);
         return var1 == null;
      } else {
         return false;
      }
   }

   public xs by() {
      return xs.c;
   }
}
