package net.minecraft.server;

public class EntityGiantZombie extends EntityMonster {

   public EntityGiantZombie(World var1) {
      super(var1);
      this.a(this.J * 6.0F, this.K * 6.0F);
   }

   public float aR() {
      return 10.440001F;
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(100.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.5D);
      this.getAttributeInstance(GenericAttributes.e).a(50.0D);
   }

   public float a(Location var1) {
      return this.o.o(var1) - 0.5F;
   }
}
