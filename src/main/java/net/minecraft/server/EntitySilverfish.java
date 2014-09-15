package net.minecraft.server;
import java.io.IOException;


public class EntitySilverfish extends EntityMonster {

   private afv b;


   public EntitySilverfish(World var1) {
      super(var1);
      this.a(0.4F, 0.3F);
      this.goalSelector.a(1, new yy(this));
      this.goalSelector.a(3, this.b = new afv(this));
      this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntityHuman.class, 1.0D, false));
      this.goalSelector.a(5, new afu(this));
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true, new Class[0]));
      this.targetSelector.a(2, new aaq(this, EntityHuman.class, true));
   }

   public float aR() {
      return 0.1F;
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(8.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.25D);
      this.getAttributeInstance(GenericAttributes.e).a(1.0D);
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

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         if(var1 instanceof EntityDamageSource || var1 == DamageSource.MAGIC) {
            this.b.f();
         }

         return super.a(var1, var2);
      }
   }

   protected void a(Location var1, Block var2) {
      this.a("mob.silverfish.step", 0.15F, 1.0F);
   }

   protected Item A() {
      return null;
   }

   public void s_() throws IOException {
      this.aG = this.y;
      super.s_();
   }

   public float a(Location var1) {
      return this.o.getData(var1.b()).c() == Blocks.STONE?10.0F:super.a(var1);
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
